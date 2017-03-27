/**
 * @PackageName:      com.bithealth.excel
 * @FileName:     DeleteFileTask.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月11日 上午11:34:55  
 * 
 */
package com.bithealth.task;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.task.DeleteFileTask.MyTask;

/**
 * 类名称: DeleteFileTask  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月11日 上午11:34:55 
 * 
 * @author liuhm
 * @version  
 */
@Service
public class DeleteFileTask {
	
	private static Logger logger = Logger.getLogger(DeleteFileTask.class);
	
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	private static final long EXECUTE_PEROID =  60 * 1000L;  //间隔时间

	/**
	 * @param args
	 */
	public void delMemFile(FileConfigModel model) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(timer, model), EXECUTE_PEROID);
	}
	
	class MyTask extends TimerTask{
		private Timer timer;
		private FileConfigModel model;
		public MyTask(Timer timer, FileConfigModel model){
			this.timer = timer;
			this.model = model;
		}

		@Override
		public void run() {
			try {
				logger.info("删除DB上文件，objectId:" + model.getUniqueId());
				fileManagerServiceFacade.deleteFile(model);
			} catch (Exception e) {
				logger.error(e);
			}finally{
				timer.cancel();
			}
		}
	}

}
