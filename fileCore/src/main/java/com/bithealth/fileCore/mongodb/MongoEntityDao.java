package com.bithealth.fileCore.mongodb;


import java.io.File;

import org.bson.types.ObjectId;

import com.mongodb.gridfs.GridFSDBFile;

/**
 * 类名称: MongoEntityDao  
 * 功能描述: TODO 定义操作mongodbdb的接口方法
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:09:03 
 * 
 * @author 胡翔
 * @version  
 */
public interface MongoEntityDao {
    
    
    /**
     * @Title:saveFile 
     * TODO(保存文件).  
     * @author 胡翔
     * @param collectionName 保存的集合名称
     * @param file 需要保存的文件
     * @return String 保存成功后的文件唯一标识
     * @throws Exception 
     */ 
    public String saveFile(String collectionName, File file) throws Exception;
    
    
    /**
     * @Title:retrieveFileOne 
     * TODO(获取文件).  
     * @author 胡翔
     * @param collectionName 保存的集合名称
     * @param id 文件唯一标识
     * @return GridFSDBFile 获取到的保存源文件
     * @throws Exception 
     */ 
    public GridFSDBFile retrieveFileOne(String collectionName, ObjectId id) throws Exception;
    
    
    /**
     * @Title:removeFile 
     * TODO(从集合中删除文件).  
     * @author 胡翔
     * @param collectionName 集合名称
     * @param id 文件唯一标识
     * @return boolean 删除结果
     * @throws Exception 
     */ 
    public boolean removeFile(String collectionName, ObjectId id) throws Exception;
    

    /**
     * @Title:saveFile 
     * TODO(保存文件).  
     * @author 胡翔
     * @param collectionName 集合名称
     * @param bytes  文件字节数组
     * @param inComing 
     * @return String 保存成功后的文件唯一标识。保存失败返回null
     * @throws Exception 
     */ 
    public  String saveFile(String collectionName, byte[] bytes, String inComing) throws Exception;
    
    /**
     * @Title:saveFile 
     * TODO(保存文件数据).  
     * @author 胡翔
     * @param by 文件字节流数组
     * @param collectionName 集合名称
     * @param id 文件唯一标识。 (第一次保存时，该字段为空,修改源文件时需要赋值)
     * @return String 保存成功后的唯一标识
     * @throws Exception 
     */ 
    public String saveFile(byte[] by, String collectionName, String id) throws Exception; 
	
}
