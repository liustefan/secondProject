package com.bithealth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class HKEJConfig {
	
	private static HKEJConfig instance = null;
	
	private HKEJConfig(){}
	
	public static HKEJConfig getConfig(){
		if(instance == null)
			return getInstance();
		else
			return instance;
	}
	
	private synchronized static HKEJConfig getInstance() {
		if(instance == null){
			instance = JSON.parseObject(getJson("/hkej.cfg.json"), HKEJConfig.class);
			if(instance == null)
				instance = new HKEJConfig(); 
		}
		return instance;
	}
	
    private static String getJson(String fileName) {
       StringBuilder stringBuilder = new StringBuilder();
       try {
          BufferedReader bf = new BufferedReader(new InputStreamReader(HKEJConfig.class.getResourceAsStream(fileName)));
          String line;
          while ((line = bf.readLine()) != null) {
        	  stringBuilder.append(line);
          }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return stringBuilder.toString();
    }

	private Questionnaire questionnaire;
	
    public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public class Questionnaire{
	    
	   private Map<String, Short> evaluationWay;

		public Map<String, Short> getEvaluationWay() {
			return evaluationWay;
		}

		public void setEvaluationWay(Map<String, Short> evaluationWay) {
			this.evaluationWay = evaluationWay;
		}
	   
    }
}
