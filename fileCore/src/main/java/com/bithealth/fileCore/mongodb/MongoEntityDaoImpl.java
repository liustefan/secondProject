package com.bithealth.fileCore.mongodb;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;

import com.bithealth.sdk.common.utils.GzipUtil;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * 类名称: MongoEntityDaoImpl  
 * 功能描述: TODO mongodb数据库实体操作类
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:17:28 
 * 
 * @author 胡翔
 * @version  
 */
public class MongoEntityDaoImpl implements MongoEntityDao {
	@Override
	public String saveFile(String collectionName, File file) throws Exception {

		// 存储fs的根节点
		GridFS gridFS = new GridFS(MongoUtil.getDB(), collectionName);
		GridFSInputFile gfs = gridFS.createFile(file);
		gfs.put("filename", file.getName());
		gfs.put("contentType",
				file.getName().substring(file.getName().lastIndexOf(".")));
		gfs.save();
		return gfs.getId().toString();

	}
	
	/**
	 * 保存或更新源文件并返回文件唯一标识
	 * @param in 文件流
	 * @param collectionName 集合名称
	 * @param uniqueId 文件唯一标识, (新上传文件时为空；修改文件时，不能为空) 
	 * @return 保存成功后的，文件唯一标识
	 * @author 胡翔
	 * @throws Exception 
	 */
	@Override
	public String saveFile(byte[] by, String collectionName, String id)
			throws Exception {
		GridFS gridFS = new GridFS(MongoUtil.getDB(), collectionName);
		GridFSInputFile gfs = gridFS.createFile(by);
		gfs.put("contentType", "gzip");
		if (StringUtils.isNotBlank(id)) {
			gfs.setId(new ObjectId(id));
		}
		gfs.save();
		return gfs.getId().toString();
	}
	/**
	 * 通过集合名称和id获取文件数据
	 * @param collectionName 集合名称
	 * @param id 文件唯一标识, 
	 * @return 源文件数据
	 * @author 胡翔
	 * @throws Exception 
	 */
	@Override
	public GridFSDBFile retrieveFileOne(String collectionName, ObjectId id)
			throws Exception {
		// 获取fs的根节点
		GridFS gridFS = new GridFS(MongoUtil.getDB(), collectionName);
		GridFSDBFile dbfile = gridFS.find(id);
		if (dbfile != null) {
			return dbfile;
		}

		return null;
	}
	/**
	 * 通过集合名称和id删除源文件
	 * @param collectionName 集合名称
	 * @param id 文件唯一标识,  
	 * @return 删除成功或文件不存在 正常返回。
	 * @author 胡翔
	 * @throws Exception 删除异常时抛出异常信息  
	 */
	@Override
	public boolean removeFile(String collectionName, ObjectId id)
			throws Exception {
		// 获取fs的根节点
		GridFS gridFS = new GridFS(MongoUtil.getDB(), collectionName);
		gridFS.remove(id);
		return true;
	}
	@Override
	public String saveFile(String collectionName, byte[] bytes, String inComing)
			throws Exception {
		// 存储fs的根节点
		GridFS gridFS = new GridFS(MongoUtil.getDB(), collectionName);
		GridFSInputFile gfs = gridFS.createFile(GzipUtil.gzip(bytes));
		gfs.put("filename", "webFile");
		gfs.put("contentType", "gzip");
		if (inComing != null) {
			gfs.put("inComing", inComing);
		}
		gfs.save();
		return gfs.getId().toString();

	}
}
