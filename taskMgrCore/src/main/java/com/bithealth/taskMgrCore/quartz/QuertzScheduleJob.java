package com.bithealth.taskMgrCore.quartz;

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
import org.springframework.stereotype.Service;

import com.bithealth.taskMgrCore.constants.Constants;
import com.bithealth.taskMgrCore.model.JobConfig;
import com.bithealth.taskMgrCore.server.IJobConfigService;
 
@Service("quertzScheduleJob")
public class QuertzScheduleJob {
	private static Logger logger = LoggerFactory.getLogger(QuertzScheduleJob.class);
 	@Autowired
	  Scheduler scheduler;
	@Autowired
	private static IJobConfigService jobConfigService;
	private static JobConfig jobConfig;

//	static {
//	    ApplicationContext context = new ClassPathXmlApplicationContext("springQuartzContext.xml");
//		scheduler = (Scheduler) context.getBean("scheduler");
//	}
	/**
	 * <一句话功能简述>
	 * 
	 * @param args
	 * @throws jobConfigException
	 */
	public static void main(String[] args) throws SchedulerException{
		List<JobConfig> jobList = jobConfigService.selectAll(1);
		System.out.println("============");
		for (JobConfig job : jobList) {
			System.out.println("=======================3");
//			startJob(job);
//			job.setCronExpression("0/5 * * * * ?");
//			rescheduleJob(job);
			
		}
	}

	public   void startJob(JobConfig job) throws SchedulerException{
    			// jobConfigFactoryBean 由spring创建注入
	    		// 这里获取任务信息数据
			TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName());
			// 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			Class clas = null;
 
			if(job.getJobName().equals(Constants.HistoryUserData)){
			    clas = HistoryUserDataFormFactory.class;
			}else if(job.getJobName().equals(Constants.MEMBER_INSERT)) {
				clas = MemberRegistJob.class;
			} else if(job.getJobName().equals(Constants.MEMBER_DELETE)) {
				clas = MemberDeleteJob.class;
			} else if(job.getJobName().equals(Constants.MEMBER_UPDATE)) {
				clas = MemberUpdateJob.class;
			}else if(job.getJobName().equals(Constants.MEASURE_RESULT_MSG_SEND)) {
				clas = MeasureResultMsgSendJob.class;
			}else if(job.getJobName().equals(Constants.MEMBER_MERGE)) {
				clas = MemberMergeJob.class;
			}else if(job.getJobName().equals(Constants.MANAGESCHEME_TASK)) {
				clas = ManageschemeTaskJob.class;
			}
//			else if(job.getJobName().equals(Constants.ZLJYResendData)){
//			    clas=ZLJYResendDataFactory.class;
//			}else if(job.getJobName().equals(Constants.GoodDoctorGetData)){  
//			    clas=GoodDoctortimingGetDataFromFactory.class;
//			}else if(job.getJobName().equals(Constants.GoodDoctorHistoryUserData)){
//			    clas=GoodDoctorHistoryUserDataFormFactory.class;
//			}
			
			// 不存在，创建一个
			if (null == trigger) {
				JobDetail jobDetail = JobBuilder.newJob(clas).withIdentity(job.getJobName()).build();
//			    	JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName()).build();
				jobDetail.getJobDataMap().put(job.getJobName(), job);
				// 表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getJobTimeExpression());
				// 按新的cronExpression表达式构建一个新的trigger
				trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName()).withSchedule(scheduleBuilder).build();
				scheduler.scheduleJob(jobDetail, trigger);
			} else {
				// Trigger已存在，那么更新相应的定时设置
				// 表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getJobTimeExpression());
				// 按新的cronExpression表达式重新构建trigger
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				// 按新的trigger重新设置job执行
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		
	}

	public   List<JobConfig> getJobAll() throws SchedulerException {
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
	public   void isRunJob() throws SchedulerException {
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

	/**
	 * 暂停Job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public   void pauseJob(JobConfig jobConfig) throws SchedulerException {
		System.out.println("=======================5pauseJob="+jobConfig.getJobName());
		JobKey jobKey = JobKey.jobKey(jobConfig.getJobName());
		scheduler.pauseJob(jobKey);
	}

	/**
	 * 恢复Job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public   void resumeJob(JobConfig jobConfig) throws SchedulerException {
		System.out.println("=======================resumeJob="+jobConfig.getJobName());
		JobKey jobKey = JobKey.jobKey(jobConfig.getJobName());
		scheduler.resumeJob(jobKey);
	}

	/**
	 * 立即运行任务一次
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public   void triggerJob(JobConfig jobConfig) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobConfig.getJobName());
		scheduler.triggerJob(jobKey);
	}

	/**
	 * 更新任务表达式
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public   void rescheduleJob(JobConfig jobConfig) throws SchedulerException {
		TriggerKey triggerKey = TriggerKey.triggerKey(jobConfig.getJobName());
		// 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		// 表达式调度构建器
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobConfig.getJobTimeExpression());
		// 按新的cronExpression表达式重新构建trigger
		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
		// 按新的trigger重新设置job执行
		scheduler.rescheduleJob(triggerKey, trigger);
	}
	
}
