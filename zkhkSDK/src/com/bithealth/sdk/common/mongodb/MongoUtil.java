package com.bithealth.sdk.common.mongodb;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;


/**
 * to see:http://www.mongodb.org/display/DOCS/Java+Driver+Concurrency
 * Mongo工具类:设计为单例模式，每当月份发生变化，数据库连接名称就会发生变化，这是业务规则
 * 因 MongoDB的Java驱动是线程安全的，对于一般的应用，只要一个Mongo实例即可，Mongo有个内置的连接池（池大小默认为10个）。
 * 对于有大量写和读的环境中，为了确保在一个Session中使用同一个DB时，我们可以用以下方式保证一致性：
 *	 DB mdb = mongo.getDB('dbname');
 *	 mdb.requestStart();
 *	 // 业务代码
 *	 mdb.requestDone();
 * DB和DBCollection是绝对线程安全的
 * @author wujintao
 */
public class MongoUtil{
	
	private static Mongo mongo;
	private static DBCollection coll;
	private static Log log = LogFactory.getLog(MongoUtil.class);
	private static DB db;
	private static String mongoURL;
	private static int mongoPort;
	private static String mongoDB;
	private static String mongoDBName;
	private static String mongoDBPassword;
	
	static{
//		Properties prop = new Properties();
//		InputStream in = MongoUtil.class.getResourceAsStream("/jdbc.properties");
		
		try {
//			prop.load(in);
//			mongoURL = prop.getProperty("mongoURL").trim();
//			mongoPort = Integer.parseInt(prop.getProperty("mongoPort").trim());
//			mongoDB = prop.getProperty("mongoDB").trim();
//			mongoDBName = prop.getProperty("mongoDBName").trim();
//			mongoDBPassword = prop.getProperty("mongoDBPassword").trim();
//			
		   
		            
			 KDConfig kdConfig = Env.getBean("rdConfig");
			 
			 mongoURL =kdConfig.getProperty("mongo.server.mongoURL") ; 
			 mongoPort = Integer.valueOf(kdConfig.getProperty("mongo.server.mongoPort")) ; 
			 mongoDB =  kdConfig.getProperty("mongo.server.mongoDB") ;
			 mongoDBName =  kdConfig.getProperty("mongo.server.mongoDBName") ;
			 mongoDBPassword =  kdConfig.getProperty("mongo.server.mongoDBPassword") ;
 
		    MongoOptions options = new MongoOptions();
                    options.autoConnectRetry =Boolean.valueOf(kdConfig.getProperty("mongo.options.autoConnectRetry")) ;// true;
                    options.connectionsPerHost =Integer.parseInt(kdConfig.getProperty("mongo.options.connectionsPerHost")) ;// 1000;
                    options.maxWaitTime =  Integer.parseInt(kdConfig.getProperty("mongo.options.maxWaitTime")) ;//5000;
                    options.socketTimeout =Integer.parseInt(kdConfig.getProperty("mongo.options.socketTimeout")) ;// 0;
                    options.connectTimeout = Integer.parseInt(kdConfig.getProperty("mongo.options.connectTimeout")) ;//15000;
                    options.threadsAllowedToBlockForConnectionMultiplier =Integer.parseInt(
                        kdConfig.getProperty("mongo.options.threads")) ;//5000;
                    
 

                    
			//事实上，Mongo实例代表了一个数据库连接池，即使在多线程的环境中，一个Mongo实例对我们来说已经足够了
			mongo = new Mongo(new ServerAddress(mongoURL,mongoPort),options);
			//mongo = new Mongo(DBMongoConfig.getHost(),DBMongoConfig.getPort());
			// or, to connect to a replica set, supply a seed list of members
			// Mongo m = new Mongo(Arrays.asList(new ServerAddress("localhost",
			// 27017),
			// new ServerAddress("localhost", 27018),
			// new ServerAddress("localhost", 27019)));

			// 注意Mongo已经实现了连接池，并且是线程安全的。
			// 大部分用户使用mongodb都在安全内网下，但如果将mongodb设为安全验证模式，就需要在客户端提供用户名和密码：
			 //boolean auth = db.authenticate("", "");
		} catch (Exception e) {
			log.info("get mongo instance failed");
		}
	}
	
	public static DB getDB(){
		if(db==null){
			db = mongo.getDB(mongoDB);
			db.authenticate(mongoDBName, mongoDBPassword.toCharArray());
		}
		return db;
	}
	
	
	public static Mongo getMong(){
		return mongo;
	}
	
	public static DBCollection getColl(String collname){
		return getDB().getCollection(collname);
	}

}
