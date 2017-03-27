/**
 * @PackageName: com.bithealth.fileCore.dao.impl
 * @FileName:    FileManagerDaoImpl.java  
 * @Description: TODO(文件管理dao层实现类)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月27日 下午5:59:56  
 * 
 */
package com.bithealth.fileCore.fileDao.impl;

import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.bithealth.fileCore.fileDao.FileManagerDao;
import com.bithealth.sdk.common.mongodb.MongoEntityDao;
import com.bithealth.sdk.common.mongodb.MongoEntityDaoImpl;
import com.mongodb.gridfs.GridFSDBFile;

/**
 * 类名称: FileManagerDaoImpl  
 * 功能描述: TODO 文件管理dao层实现类.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 下午5:59:56 
 * 
 * @author 胡翔
 * @version  
 */
@Repository
public class FileManagerDaoImpl implements FileManagerDao {
	
	private MongoEntityDao mongoEntityDao = new MongoEntityDaoImpl();
	
	@Override
	public String saveFile(byte[] by, String pathname, String uniqueId)
			throws Exception {
		return mongoEntityDao.saveFile(by, pathname, uniqueId);
	}

	@Override
	public InputStream getFile(String pathname, String uniqueId)
			throws Exception {
		GridFSDBFile file = mongoEntityDao.retrieveFileOne(pathname,new ObjectId(uniqueId));
		if(file!=null){
			return file.getInputStream();
		}
		return null;
	}

	@Override
	public boolean deleteFile(String pathname, String uniqueId)
			throws Exception {
		mongoEntityDao.removeFile(pathname, new ObjectId(uniqueId));
		return true;
	}

}
