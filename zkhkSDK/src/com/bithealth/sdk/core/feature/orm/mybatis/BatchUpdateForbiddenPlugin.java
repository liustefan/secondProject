package com.bithealth.sdk.core.feature.orm.mybatis;

/**
 * 描述 ：
 *
 * @author "jason chai"
 * @date 2016年9月9日
 */
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * <p>
 * 禁止批量更新的插件,只允许更新单条记录
 * </p>
 * 
 * <pre>
 * mapper示例：必须在update语句的最后面定义[presentColumn="orderNo"]，其中orderNo是能标识orders表的主键（逻辑主键或者业务主键）
 * <update id="updateOrder" parameterType="java.util.HashMap">
 *         <![CDATA[
 *         update 
 *             orders
 *         set 
 *             status = #{currentStatus}
 *         ]]>
 * <where>
 * <if test="orderNo != null and orderNo != ''">
 * and orderNo = #{orderNo, jdbcType=VARCHAR}
 * </if>
 * <if test="preStatus != null and preStatus != ''">
 * and status = #{preStatus, jdbcType=INTEGER}
 * </if>
 * </where>
 * [presentColumn="orderNo"]
 * </update>
 * </pre>
 * 
 * @author yi.chen@qunar.com
 * @version 0.0.1
 * @createTime 2012-04-03 18:25
 */
@Intercepts({
	    
	           @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class } )  
			 
	          })
public class BatchUpdateForbiddenPlugin implements Interceptor {

//	private final static String presentColumnTag = "presentColumn";// 定义where条件中必须出现的字段
	
	private final static String presentColumnTag = "where";// 定义where条件中必须出现

	/**
	 * <p>
	 * 只对update语句进行拦截
	 * </p>
	 * 
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin
	 *      .Invocation)
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		// 只拦截update ,Delete
		if (isUpdateMethod(invocation)||isDeleteMethod(invocation)) {
//			invocation.getArgs()[0] = checkAndResetSQL(invocation);
			
			checkAndResetSQL(invocation);
		}
		return invocation.proceed();
	}

	/**
	 * <p>
	 * 判断该操作是否是update操作
	 * </p>
	 * 
	 * @param invocation
	 * @return 是否是update操作
	 */
	private boolean isUpdateMethod(Invocation invocation) {
		if (invocation.getArgs()[0] instanceof MappedStatement) {
			MappedStatement mappedStatement = (MappedStatement) invocation
					.getArgs()[0];
			return SqlCommandType.UPDATE.equals(mappedStatement
					.getSqlCommandType());
		}
		return false;
	}

	
	/**
	 * <p>
	 * 判断该操作是否是delete操作
	 * </p>
	 * 
	 * @param invocation
	 * @return 是否是update操作
	 */
	private boolean isDeleteMethod(Invocation invocation) {
		if (invocation.getArgs()[0] instanceof MappedStatement) {
			MappedStatement mappedStatement = (MappedStatement) invocation
					.getArgs()[0];
			return SqlCommandType.DELETE .equals(mappedStatement
					.getSqlCommandType());
		}
		return false;
	}

	
	/**
	 * <p>
	 * 检查update语句中是否定义了presentColumn，并且删除presentColumn后重新设置update语句
	 * </p>
	 * 
	 * @param invocation
	 *            invocation实例
	 * @return MappedStatement 返回删除presentColumn之后的MappedStatement实例
	 */
	private Object checkAndResetSQL(Invocation invocation) {
		MappedStatement mappedStatement = (MappedStatement) invocation
				.getArgs()[0];
		Object parameter = invocation.getArgs()[1];
		mappedStatement.getSqlSource().getBoundSql(parameter);
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		String resetSql = doCheckAndResetSQL(boundSql.getSql());
		return getMappedStatement(mappedStatement, boundSql, resetSql);
	}

	/**
	 * <p>
	 * 检查update语句中是否定义了presentColumn，并且删除presentColumn后重新设置update语句
	 * </p>
	 * 
	 * @param sql
	 *            mapper中定义的sql语句(带有presentColumn的定义)
	 * @return 删除presentColumn之后的sql
	 */
	private String doCheckAndResetSQL(String sql) {
		if (sql.toLowerCase().indexOf(presentColumnTag) <=0) {
	 
		 
			throw new IllegalArgumentException("在mapper文件中定义的delete ,update语句必须包含"
					+ presentColumnTag + "，它用于防止不带条件的批量处理");
//					"，它用于定义该sql的主键（逻辑主键或者业务主键），比如id");
		}
		return sql;
	}

	/**
	 * <p>
	 * 通过验证关键字段不能为空之后的sql重新构建mappedStatement
	 * </p>
	 * 
	 * @param mappedStatement
	 *            重新构造sql之前的mappedStatement实例
	 * @param boundSql
	 *            重新构造sql之前的boundSql实例
	 * @param resetSql
	 *            验证关键字段不能为空之后的sql
	 * @return 重新构造之后的mappedStatement实例
	 */
	private Object getMappedStatement(MappedStatement mappedStatement,
			BoundSql boundSql, String resetSql) {
		final BoundSql newBoundSql = new BoundSql(
				mappedStatement.getConfiguration(), resetSql,
				boundSql.getParameterMappings(), boundSql.getParameterObject());

		Builder builder = new MappedStatement.Builder(
				mappedStatement.getConfiguration(), mappedStatement.getId(),
				new SqlSource() {
					public BoundSql getBoundSql(Object parameterObject) {
						return newBoundSql;
					}
				}, mappedStatement.getSqlCommandType());

		builder.cache(mappedStatement.getCache());
		builder.fetchSize(mappedStatement.getFetchSize());
		builder.flushCacheRequired(mappedStatement.isFlushCacheRequired());
		builder.keyGenerator(mappedStatement.getKeyGenerator());
//		 builder.keyProperty(mappedStatement.getKeyProperties());//.getKeyProperty());

		builder.resource(mappedStatement.getResource());
		builder.resultMaps(mappedStatement.getResultMaps());
		builder.resultSetType(mappedStatement.getResultSetType());
		builder.statementType(mappedStatement.getStatementType());
		builder.timeout(mappedStatement.getTimeout());
		builder.useCache(mappedStatement.isUseCache());
		return builder.build();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {

	}

}
