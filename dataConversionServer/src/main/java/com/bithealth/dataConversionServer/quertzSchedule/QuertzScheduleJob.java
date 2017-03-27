package com.bithealth.dataConversionServer.quertzSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bithealth.dataConversionServer.model.JobConfig;



public class QuertzScheduleJob {
	private static Logger logger = LoggerFactory.getLogger(QuertzScheduleJob.class);
	@Autowired
	private static Scheduler scheduler;



	public static void startJob(JobConfig job) throws SchedulerException{
	    	TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName());
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		Class clazz =null;
		if(job.getJobName().equals("zkhkSendDatasTask")){
		    clazz = QuertzJobZKHKSendDataTask.class;
		}else if(job.getJobName().equals("diabetesVisitsTask")){
		    clazz=QuertzJobDiabetesVisitsTask.class;
		}else if(job.getJobName().equals("diabetesVisitsTask")){
		    clazz=QuertzJobDiabetesVisitsTask.class;
		}else if(job.getJobName().equals("healthExamTask")){
		    clazz=QuertzJobHealthExamTask.class;
		}else if(job.getJobName().equals("healthRecordsTask")){
		    clazz=QuertzJobHealthRecordsTask.class;
		}else if(job.getJobName().equals("hypertensionVisitsTask")){
		    clazz=QuertzJobHypertensionVisitsTask.class;
		}
		if (null == trigger) {
		    JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName()).build();
		    jobDetail.getJobDataMap().put(job.getJobName(), job);
		    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getJobTimeExpression());
		    trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName()).withSchedule(scheduleBuilder).build();
		    scheduler.scheduleJob(jobDetail,trigger);
		} else {
		    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getJobTimeExpression());
		    trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
		    scheduler.rescheduleJob(triggerKey, trigger);
		}
		
	}
	


	public static List<JobConfig> getJobAll() throws SchedulerException {
		// schedulerFactoryBean 由spring创建注入
		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
		Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
		List<JobConfig> jobList = new ArrayList<JobConfig>();
		for (JobKey jobKey : jobKeys) {
			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			for (Trigger trigger : triggers) {
			    	JobConfig job = new JobConfig();
				job.setJobName(jobKey.getName());
				job.setJobDesc("触发器:" + trigger.getKey());
				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				job.setJobStatus(triggerState.name());
				if (trigger instanceof CronTrigger) {
					CronTrigger cronTrigger = (CronTrigger) trigger;
					String cronExpression = cronTrigger.getCronExpression();
					job.setJobTimeExpression(cronExpression);
				}
				logger.info("all job is " + job.getJobName());
				jobList.add(job);
			}
		}
		 return jobList;
	}

	/**
	 * 获取正在运行的job
	 * 
	 * @throws jobConfigException
	 */
	public static void isRunJob() throws SchedulerException {
		List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
		List<JobConfig> jobList = new ArrayList<JobConfig>(executingJobs.size());
		for (JobExecutionContext executingJob : executingJobs) {
		    JobConfig job = new JobConfig();
			JobDetail jobDetail = executingJob.getJobDetail();
			JobKey jobKey = jobDetail.getKey();
			Trigger trigger = executingJob.getTrigger();
			job.setJobName(jobKey.getName());
			job.setJobDesc("触发器:" + trigger.getKey());
			Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			job.setJobStatus(triggerState.name());
			if (trigger instanceof CronTrigger) {
				CronTrigger cronTrigger = (CronTrigger) trigger;
				String cronExpression = cronTrigger.getCronExpression();
				job.setJobTimeExpression(cronExpression);
			}
			logger.info("runing job is " + job.getJobName());
			jobList.add(job);
		}
	}



}
