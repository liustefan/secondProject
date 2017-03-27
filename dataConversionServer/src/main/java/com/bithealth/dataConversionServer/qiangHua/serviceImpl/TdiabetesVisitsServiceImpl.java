package com.bithealth.dataConversionServer.qiangHua.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.qiangHua.bean.TdiabetesVisits;
import com.bithealth.dataConversionServer.qiangHua.dao.TdiabetesVisitsMapper;
import com.bithealth.dataConversionServer.qiangHua.service.ITdiabetesVisitsService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;



/**
 * @ClassName:     TdiabetesVisitsServiceImpl.java 
  * @Description:   TODO
  * @author         zengxuhua  
 * @version        V1.0   
  * @Date           2016年2月29日 下午2:55:04
 *****/
@Service("tdiabetesVisitsService")
public class TdiabetesVisitsServiceImpl extends GenericBaseServiceImpl implements ITdiabetesVisitsService{

	@Autowired
    private TdiabetesVisitsMapper tdiabetesVisitsMapper;
    
    public List<TdiabetesVisits> select(int num) {
	return tdiabetesVisitsMapper.select(num);
    }

    public long selectByCount() {
	long count=0;
	try{
	     count=tdiabetesVisitsMapper.selectByCount();
	}catch(Exception e){
	    e.printStackTrace();
	}
	return count;
    }
    
    
    public void update(TdiabetesVisits tdiabetesVisits){
	tdiabetesVisitsMapper.updateByPrimaryKeySelective(tdiabetesVisits);
    }

	public int insert(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExampleSelective(Object model, Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Object model, Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Object id) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public Object selectById(Object id) {
		
		// TODO Auto-generated method stub
		return null;
	}

	public List selectByExampleAndPage(Page page, Object example) {
		
		// TODO Auto-generated method stub
		return null;
	}

	public int countByExample(Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public List selectByExample(Object example) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericBaseDao getDao() {
		
		// TODO Auto-generated method stub
		return null;
	}
    

}
