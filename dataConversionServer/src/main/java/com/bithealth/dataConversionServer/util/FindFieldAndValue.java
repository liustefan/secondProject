package com.bithealth.dataConversionServer.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.bithealth.dataConversionServer.bean.BloodGlucose;
import com.bithealth.dataConversionServer.bean.BloodPressure;




public class FindFieldAndValue {
    
    private String name;
    
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static List<FindFieldAndValue> testReflect(Object model) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{  
        //获取实体类的所有属性，返回Field数组
        Field[] field = model.getClass().getDeclaredFields();          
        List<FindFieldAndValue> list = new ArrayList<FindFieldAndValue>();
        //遍历所有属性
        for(int j=0 ; j<field.length ; j++){
            //获取属性的名字
            String name = field[j].getName();
            //过滤掉序列化号
            if(name.equals("serialVersionUID")){
                continue;
            }
            //获取转化成中联嘉裕的属性名：
            String attrStr = getZLJYAttrabutName(model,name);
            FindFieldAndValue object = new FindFieldAndValue();
            //将属性的首字符大写，方便构造get，set方法
            name = name.substring(0,1).toUpperCase()+name.substring(1);
            //获取属性的类型
            String type = field[j].getGenericType().toString();
            
            if(type.equals("class java.lang.String")){ 
                //如果type是类类型，则前面包含"class "，后面跟类名
                Method m = model.getClass().getMethod("get"+name);  
                String value = (String) m.invoke(model);    //调用getter方法获取属性值  
                if(!StringUtil.isEmpty(value) && !StringUtil.isEmpty(attrStr)){  
                    object.setName(attrStr);
                    object.setValue(value);  
                    list.add(object);
                }
            }  
            if(type.equals("class java.lang.Integer")){       
                Method m = model.getClass().getMethod("get"+name);  
                Integer value = (Integer) m.invoke(model);
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr)){  
                    object.setName(attrStr);
                    object.setValue(realValue);
                    list.add(object);
                }
            }
            if(type.equals("int")){       
                Method m = model.getClass().getMethod("get"+name);  
                Integer value = (Integer) m.invoke(model);
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr)){  
                    object.setName(attrStr);
                    object.setValue(realValue);
                    list.add(object);
                }
            }
            if(type.equals("float")){       
                Method m = model.getClass().getMethod("get"+name);  
                Float value = (Float) m.invoke(model);
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr)){  
                    object.setName(attrStr);
                    object.setValue(realValue);
                    list.add(object);
                }
            }
            if(type.equals("class java.lang.Short")){       
                Method m = model.getClass().getMethod("get"+name);  
                Short value = (Short) m.invoke(model);  
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr)){  
                    object.setName(attrStr);
                    object.setValue(realValue);
                    list.add(object);
                }
            }         
            if(type.equals("class java.lang.Double")){       
                Method m = model.getClass().getMethod("get"+name);  
                Double value = (Double) m.invoke(model);  
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr)){                      
                    object.setName(attrStr);
                    object.setValue(realValue);
                    list.add(object);
                }
            }
            if(type.equals("double")){       
                Method m = model.getClass().getMethod("get"+name);  
                Double value = (Double) m.invoke(model);  
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr)){                      
                    object.setName(attrStr);
                    object.setValue(realValue);
                    list.add(object);
                }
            }
            if(type.equals("long")){       
                Method m = model.getClass().getMethod("get"+name);  
                Long value = (Long) m.invoke(model);  
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr)){                      
                    object.setName(attrStr);
                    object.setValue(realValue);
                    list.add(object);
                }
            }
            if(type.equals("class java.lang.Boolean")){  
                Method m = model.getClass().getMethod("get"+name);      
                Boolean value = (Boolean) m.invoke(model);  
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr)){                        
                    object.setName(attrStr);
                    object.setValue(realValue); 
                    list.add(object);
                }
            }  
            if(type.equals("class java.util.Date")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Method m = model.getClass().getMethod("get"+name);                      
                Date value = (Date) m.invoke(model);  
                String realValue = String.valueOf(value);
                if(!StringUtil.isEmpty(realValue) && !StringUtil.isEmpty(attrStr) && !"null".equals(realValue)){  
                    object.setName(attrStr);
                    object.setValue(sdf.format(value));
                    list.add(object);
                }
            }
        }
        return list;
    }
    
    public static String getZLJYAttrabutName(Object model,String name){
        String attributeName = "";
        if(model.getClass()== BloodGlucose.class){
            attributeName = getBloodGlucoseAttrabutName(name); 
        }else if(model.getClass()== BloodPressure.class){
            attributeName = getBloodPressureAttrabutName(name);
        }
        /*else if(model.getClass()== DiabetesVisits.class){
            attributeName = getDiabetesVisitsAttrabutName(name);
        }else if(model.getClass()== HypertensionVisits.class){
            attributeName = getHypertensionVisitsAttrabutName(name);
        }else if(model.getClass()== HealthExam.class){
            attributeName = getHealthExamAttrabutName(name);
        }else if(model.getClass()== HospInfo.class){
            attributeName = getHospInfoAttrabutName(name);
        }else if(model.getClass()== Vaccinate.class){
            attributeName = getVaccinateAttrabutName(name);
        }*/
        return attributeName;
    }
    
     /** 
     * @Title: getBloodGlucoseAttrabutName 
     * @Description: 转化血糖属性名
     * @param name
     * @return    
     * @retrun String
     */
    public static String getBloodGlucoseAttrabutName(String name){
        String attributeName = "";
        if("hrGid".equals(name)){
            attributeName = "DGrdabh";
        }else if("identification".equals(name)){
            attributeName = "Identification";
        }else if("timePeriod".equals(name)){
            attributeName = "timePeriod";
        }else if("testTime".equals(name)){
            attributeName = "TestTime";
        }else if("bsValue".equals(name)){
            attributeName = "BsValue";
        }else if("abnormal".equals(name)){
            attributeName = "Abnormal";
        }else{
            attributeName = "";
        }
        return attributeName;
    }
    
     /** 
     * @Title: getBloodPressureAttrabutName 
     * @Description: 转化血压属性名 
     * @param name
     * @return    
     * @retrun String
     */
    public static String getBloodPressureAttrabutName(String name){
        String attributeName = "";
        if("hrGid".equals(name)){
            attributeName = "DGrdabh";
        }else if("identification".equals(name)){
            attributeName = "Identification";
        }else if("timePeriod".equals(name)){
            attributeName = "timePeriod";
        }else if("testTime".equals(name)){
            attributeName = "TestTime";
        }else if("pulseRate".equals(name)){
            attributeName = "PulseRate";
        }else if("sbp".equals(name)){
            attributeName = "SBP";
        }else if("dbp".equals(name)){
            attributeName = "DBP";
        }else if("abnormal".equals(name)){
            attributeName = "Abnormal";
        }else{
            attributeName = "";
        }
        return attributeName;
    }
    
     /** 
     * @Title: getDiabetesVisitsAttrabutName 
     * @Description: 转化糖尿病属性名 
     * @param name
     * @return    
     * @retrun String
     */
    public static String getDiabetesVisitsAttrabutName(String name){
        String attributeName = "";
        if("hrGid".equals(name)){
            attributeName = "DGrdabh";
        }else if("name".equals(name)){
            attributeName = "DXm";
        }else if("idcard".equals(name)){
            attributeName = "DSfzh";
        }else if("visDate".equals(name)){
            attributeName = "happentime";
        }else if("nexVisDate".equals(name)){
            attributeName = "GXcsfsj";
        }else if("refOrg".equals(name)){
            attributeName = "PRgid";
        }else if("visDoctor".equals(name)){
            attributeName = "TSfys";
        }else if("resDoctor".equals(name)){//暂时不做对应
            attributeName = "";
        }else if("visitsSrt".equals(name)){
            attributeName = "TSffs";
        }else if("symptom".equals(name)){
            attributeName = "TMqzz";
        }else if("symptomOth".equals(name)){
            attributeName = "TMqzzqt";
        }else if("height".equals(name)){
            attributeName = "DSg";
        }else if("weight".equals(name)){
            attributeName = "DTz";
        }else if("tarWeight".equals(name)){
            attributeName = "DTz2";
        }else if("bmi".equals(name)){
            attributeName = "DBmi";
        }else if("tarBmi".equals(name)){
            attributeName = "DBmi2";
        }else if("systolicPre".equals(name)){
            attributeName = "DSsy";
        }else if("diastolicPre".equals(name)){
            attributeName = "DSzy";
        }else if("glu".equals(name)){
            attributeName = "DKfxt";
        }else if("glyHem".equals(name)){
            attributeName = "TThxhdb";
        }else if("exDate".equals(name)){
            attributeName = "DFzjcrq";
        }else if("labExamRes".equals(name)){//未发现对应数据
            attributeName = "";
        }else if("medCom".equals(name)){
            attributeName = "TFyycx";
        }else if("advDrugRea".equals(name)){
            attributeName = "TYwfzy";
        }else if("advDrugReaRes".equals(name)){
            attributeName = "TFzyxs";
        }else if("lbsRea".equals(name)){
            attributeName = "DDxtfy";
        }else if("dorPedPul".equals(name)){
            attributeName = "DZbdmbd";
        }else if("posSignsOth".equals(name)){
            attributeName = "DTzqt";
        }else if("daoSmoking".equals(name)){
            attributeName = "MXysl";
        }else if("traDaoSmoking".equals(name)){
            attributeName = "MXysl2";
        }else if("alcConsumption".equals(name)){
            attributeName = "MYjsl";
        }else if("traAlcCon".equals(name)){
            attributeName = "MYjsl2";
        }else if("exePrequency".equals(name)){
            attributeName = "MYdpl";
        }else if("traExePrequency".equals(name)){
            attributeName = "MYdpl2";
        }else if("exeDuration".equals(name)){
            attributeName = "MYdcxsj";
        }else if("traExeDuration".equals(name)){
            attributeName = "MYdcxsj2";
        }else if("daoStaFood".equals(name)){
            attributeName = "DShzs";
        }else if("traDaoStaFood".equals(name)){
            attributeName = "DShzs2";
        }else if("refIns".equals(name)){
            attributeName = "TZzyy";
        }else if("refDept".equals(name)){
            attributeName = "TZzkb";
        }else if("refDes".equals(name)){
            attributeName = "TZzyuanyin";
        }else if("psyAdjEva".equals(name)){
            attributeName = "DXltz";
        }else if("comBehEva".equals(name)){
            attributeName = "DZyxw";
        }else if("visitsEva".equals(name)){
            attributeName = "TBcsffl";
        }else if("recUser".equals(name)){
            attributeName = "createuser";
        }else if("recDate".equals(name)){
            attributeName = "createtime";
        }else if("updUser".equals(name)){
            attributeName = "updateuser";
        }else if("updDate".equals(name)){
            attributeName = "updatetime";
        }else{
            attributeName = "";
        }
        return attributeName;
    }
    
    /** 
     * @Title: getHypertensionVisitsAttrabutName 
     * @Description: 转化高血压属性名 
     * @param name
     * @return    
     * @retrun String
     */
    public static String getHypertensionVisitsAttrabutName(String name){
        String attributeName = "";
        if("hrGid".equals(name)){
            attributeName = "DGrdabh";
        }else if("name".equals(name)){
            attributeName = "DXm";
        }else if("idcard".equals(name)){
            attributeName = "DSfzh";
        }else if("visDate".equals(name)){
            attributeName = "happentime";
        }else if("nexVisDate".equals(name)){
            attributeName = "GXcsfsj";
        }else if("refOrg".equals(name)){
            attributeName = "PRgid";
        }else if("visDoctor".equals(name)){
            attributeName = "GSfys";
        }else if("resDoctor".equals(name)){//暂时不做对应
            attributeName = "";
        }else if("visitsSrt".equals(name)){
            attributeName = "GSffs";
        }else if("symptom".equals(name)){
            attributeName = "GMqzz";
        }else if("symptomOth".equals(name)){
            attributeName = "GMqzzqt";
        }else if("height".equals(name)){
            attributeName = "DSg";
        }else if("weight".equals(name)){
            attributeName = "DTz";
        }else if("tarWeight".equals(name)){
            attributeName = "DTz2";
        }else if("bmi".equals(name)){
            attributeName = "DBmi";
        }else if("tarBmi".equals(name)){
            attributeName = "DBmi2";
        }else if("systolicPre".equals(name)){
            attributeName = "DSsy";
        }else if("diastolicPre".equals(name)){
            attributeName = "DSzy";
        }else if("heartRate".equals(name)){
            attributeName = "DXl";
        }else if("labExamRes".equals(name)){
            attributeName = "GFzjc";
        }else if("medCom".equals(name)){
            attributeName = "GFyycx";
        }else if("advDrugRea".equals(name)){
            attributeName = "GYwfzy";
        }else if("advDrugReaRes".equals(name)){
            attributeName = "GFzyxs";
        }else if("posSignsOth".equals(name)){//未找到对应项
            attributeName = "";
        }else if("daoSmoking".equals(name)){
            attributeName = "MXysl";
        }else if("traDaoSmoking".equals(name)){
            attributeName = "MXysl2";
        }else if("alcConsumption".equals(name)){
            attributeName = "MYjsl";
        }else if("traAlcCon".equals(name)){
            attributeName = "MYjsl2";
        }else if("exePrequency".equals(name)){
            attributeName = "MYdpl";
        }else if("traExePrequency".equals(name)){
            attributeName = "MYdpl2";
        }else if("exeDuration".equals(name)){
            attributeName = "MYdcxsj";
        }else if("traExeDuration".equals(name)){
            attributeName = "MYdcxsj2";
        }else if("ingoSalt".equals(name)){
            attributeName = "DSyqk";
        }else if("traIngoSalt".equals(name)){
            attributeName = "DSyqk2";
        }else if("refIns".equals(name)){
            attributeName = "GZzyy";
        }else if("refDept".equals(name)){
            attributeName = "GZzkb";
        }else if("refDes".equals(name)){
            attributeName = "GZzyuanyin";
        }else if("psyAdjEva".equals(name)){
            attributeName = "DXltz";
        }else if("comBehEva".equals(name)){
            attributeName = "DZyxw";
        }else if("visitsEva".equals(name)){
            attributeName = "GCcsffl";
        }else if("recUser".equals(name)){
            attributeName = "createuser";
        }else if("recDate".equals(name)){
            attributeName = "createtime";
        }else if("updUser".equals(name)){
            attributeName = "updateuser";
        }else if("updDate".equals(name)){
            attributeName = "updatetime";
        }else{
            attributeName = "";
        }
        return attributeName;
    }
    
    /** 
     * @Title: getDiabetesVisitsAttrabutName 
     * @Description: 转化健康体检属性名 
     * @param name
     * @return    
     * @retrun String
     */
    public static String getHealthExamAttrabutName(String name){
        String attributeName = "";
        if("hrGid".equals(name)){
            attributeName = "DGrdabh";
        }else if("diabGid".equals(name)){
            attributeName = "ZId";		//id
        }else if("admType".equals(name)){
            attributeName = "ZType";		//添加和删除住院史的控制字段
        }else if("beginDate".equals(name)){
            attributeName = "ZRyjcrq";		//入院日期
        }else if("endDate".equals(name)){
            attributeName = "ZCyccrq";		//出院日期
        }else if("admRes".equals(name)){
            attributeName = "ZYuanyin";		//原 因
        }else if("inpHospitalName".equals(name)){
            attributeName = "ZYljgmc";		//医疗机构名称
        }else if("inpNo".equals(name)){
            attributeName = "ZBingah";		//病案号
        }else if("visitsSrt".equals(name)){
            attributeName = "ZHappentime"; //发生时间    //住院治疗情况,包括住院史和家庭病床史	TODO HospInfo
        }else if("symptom".equals(name)){		// TODO 主要用药情况s
            attributeName = "YId";			//TODO 
        }else if("symptomOth".equals(name)){
            attributeName = "YYwmc";		//药物名称
        }else if("height".equals(name)){
            attributeName = "YYongfa";		//用法
        }else if("weight".equals(name)){
            attributeName = "YYongl";		//用量
        }else if("tarWeight".equals(name)){
            attributeName = "YYysj";		//用药时间
        }else if("bmi".equals(name)){
            attributeName = "YFyycx";		//服药依从性
        }else if("tarBmi".equals(name)){
            attributeName = "YHappentime";	//发生时间	//主要用药情况e
        }else if("systolicPre".equals(name)){	 //非免疫规划预防接种史S
            attributeName = "FId";		// TODO ID
        }else if("vaccine".equals(name)){
            attributeName = "FJzmc";		//接种名称
        }else if("vaccineDate".equals(name)){
            attributeName = "FJzrq";		//接种日期
        }else if("vaccineIns".equals(name)){
            attributeName = "FJzjg";		//接种机构
        }else if("exDate".equals(name)){
            attributeName = "FHappentime";	// TODO 非免疫规划预防接种史E
        }else if("id".equals(name)){		//TODO 
            attributeName = "id";
        }else if("medCom".equals(name)){
            attributeName = "GZhzh";	// /症状 1.无症状;2.头痛;3.头晕;4.心悸;5.胸闷;6.胸痛;7.慢性咳嗽;8.咳痰;9.呼吸困难;10.多饮;11.多尿;12.体重下降;13.乏力;14.关节肿痛;15.视力模糊;16.手脚麻木;17.尿急;18.尿痛;19.便秘;20.腹泻;21.恶心呕吐;22.眼花;23.耳鸣;24.乳房胀痛;99.其他; 
        }else if("temperature".equals(name)){
            attributeName = "GTw";		//体温
        }else if("resRate".equals(name)){
            attributeName = "GHx";		//呼吸频率
        }else if("pulsePate".equals(name)){
            attributeName = "GMb";		//脉率
        }else if("systolicPreRight".equals(name)){
            attributeName = "GXyyc1";		//右侧收缩压
        }else if("diastolicPreRight".equals(name)){
            attributeName = "GXyyc2";		//右侧舒张压
        }else if("systolicPreLeft".equals(name)){
            attributeName = "GXyzc1";		//左侧收缩压
        }else if("diastolicPreLeft".equals(name)){
            attributeName = "GXyzc2";		//左侧舒张压
        }else if("height".equals(name)){
            attributeName = "GSg";		//身高
        }else if("waistCircumference".equals(name)){	
            attributeName = "GYw";		//腰围
        }else if("weight".equals(name)){
            attributeName = "GTzh";		//体重
        }else if("bmi".equals(name)){
            attributeName = "GTzhzh";		//体重指数(BMI) 
        }else if("traExePrequency".equals(name)){
            attributeName = "GLnrrz";		////1.阴性；2.阳性; TODO
        }else if("exeDuration".equals(name)){
            attributeName = "GLnrqg";		//1.阴性；2.阳性; TODO
        }else if("traExeDuration".equals(name)){
            attributeName = "GLnrrzfen";	 //老年人认知能力分数	TODO
        }else if("daoStaFood".equals(name)){
            attributeName = "GLnrqgfen";	//老年人情感能力分数		TODO
        }else if("visionLeft".equals(name)){
            attributeName = "GZysl";		//左眼视力
        }else if("visionRight".equals(name)){
            attributeName = "GYysl";		//右眼视力
        }else if("visionCorLeft".equals(name)){
            attributeName = "GZyjz";		//左眼矫正视力
        }else if("visionCorRight".equals(name)){
            attributeName = "GYyjz";		//右眼矫正视力
        }else if("hearing".equals(name)){
            attributeName = "GTl";		// 听 力 1.听见;2.听不清或无法听见（耳鼻喉科专科就诊）;
        }else if("motorFun".equals(name)){
            attributeName = "GYdgn";		// 运动功能 1.可顺利完成;2.无法独立完成其中任何一个动作(上级医院就诊);
        }else if("skinExam".equals(name)){
            attributeName = "GPfgm";		// 皮 肤 1.正常;2.潮红;3.苍白;4.发绀;5.黄染;6.色素沉着;99.其他;
        }else if("lymphExam".equals(name)){
            attributeName = "GLbj";		// 淋巴结 1.未触及;2.锁骨上;3.腋窝;4.其他;
        }else if("lymphExamDesc".equals(name)){
            attributeName = "GLbjqt";		//淋巴结其他
        }else if("barrelChest".equals(name)){
            attributeName = "GTzx";		//  桶状胸： 1.是;2.否;
        }else if("breathSounds".equals(name)){
            attributeName = "GHxy";		// 呼吸音： 1.正常;2.异常;
        }else if("breathSoundsDesc".equals(name)){
            attributeName = "GHxyyc";		//呼吸音异常  和字段GHxy有关系，当为2时，使用此字段
        }else if("rales".equals(name)){
            attributeName = "GLy";		 // 罗 音： 1.无;2.干罗音;3.湿罗音;4.其他;
        }else if("ralesDesc".equals(name)){
            attributeName = "GLyyc";		//罗音其他
        }else if("heartRate".equals(name)){
            attributeName = "GXinlv";		//心率
        }else if("heartRateType".equals(name)){
            attributeName = "GXinlvci";		// 心律： 1.齐;2.不齐;3.绝对不齐;
        }else if("heartMurmur".equals(name)){
            attributeName = "GZayin";		 // 杂音： 1.无;2.有;	
        }else if("heartMurmurDesc".equals(name)){
            attributeName = "GZayinyo";		//有杂音  和字段GZayin有关系，当为2时，使用此字段
        }else if("abdTend".equals(name)){
            attributeName = "GYato";		// 压痛： 1.无;2.有;	
        }else if("abdTendDesc".equals(name)){
            attributeName = "GYatoyo";		//有压痛  和字段GYato有关系，当为2时，使用此字段
        }else if("abdMass".equals(name)){
            attributeName = "GBk";		// 包块： 1.无;2.有;
        }else if("abdMassDesc".equals(name)){
            attributeName = "GBkyo";		// 有包块  和字段GBk有关系，当为2时，使用此字段
        }else if("hepatomegaly".equals(name)){
            attributeName = "GGanda";		// 肝大： 1.无;2.有;
        }else if("hepatomegalyDesc".equals(name)){
            attributeName = "GGandayo";		//有肝大  和字段GGanda有关系，当为2时，使用此字段
        }else if("splenomegaly".equals(name)){
            attributeName = "GPida";		//有脾大： 和字段GPida有关系，当为2时，使用此字段
        }else if("splenomegalyDesc".equals(name)){
            attributeName = "GPidayo";		//有脾大： 和字段GPida有关系，当为2时，使用此字段
        }else if("shiDullness".equals(name)){
            attributeName = "GZhuoyin";		// 移动性浊音： 1.无;2.有;
        }else if("shiDullnessDesc".equals(name)){
            attributeName = "GZhuoyinyo";	//有移动性浊音：  和字段GZhuoyin有关系，当为2时，使用此字段		
        }else if("lowExtEdema".equals(name)){
            attributeName = "GXzsz"; 		//下肢水肿 1.无;2.左侧;3.右侧;4.双侧不对称;5.双侧对称;
        }else if("dre".equals(name)){
            attributeName = "GGmzhzh";		// 肛门指诊 1.未见异常;2.触痛;3.包块;4.前列腺异常;99.其他;
        }else if("dreDesc".equals(name)){
            attributeName = "GGmzhzhyi";	//其他肛门指诊  和字段GGmzhzh有关系，当为99时，使用此字段		
        }else if("glu".equals(name)){
            attributeName = "GQlx";		 // 暂时不对应	 TODO		
        }else if("glyHem".equals(name)){
            attributeName = "GCtqt";		//其他查体 	TODO
        }else if("leukocyte".equals(name)){
            attributeName = "wbc";		 //血常规-白细胞
        }else if("hemoglobin".equals(name)){
            attributeName = "hb";		 //血常规-血红蛋白
        }else if("bloodPlatelet".equals(name)){
            attributeName = "plt";		//血常规-血小板
        }else if("rouBloodOth".equals(name)){
            attributeName = "GXcgqt";		//血常规-其他
        }else if("riProQuan".equals(name)){
            attributeName = "GNdb";		//尿常规-尿蛋白   尿蛋白定量
        }else if("uriSugQuan".equals(name)){
            attributeName = "GNt";		//尿常规-尿糖  	尿糖定量			
        }else if("uriKetone".equals(name)){
            attributeName = "GNtt";		//尿常规-尿酮体
        }else if("uriOccBlo".equals(name)){
            attributeName = "GNqx";		//尿常规-尿潜血
        }else if("urineOth".equals(name)){
            attributeName = "GNcgqt";		//尿常规-其他
        }else if("fecOccBlo".equals(name)){
            attributeName = "GDbqx";		// 大便潜血 1.阴性;2.阳性;
        }else if("cpt".equals(name)){
            attributeName = "alt";		//肝功能-血清谷丙转氨酶
        }else if("ast".equals(name)){
            attributeName = "ast";		//肝功能-血清谷草转氨酶
        }else if("alb".equals(name)){
            attributeName = "alb";		//肝功能-白蛋白
        }else if("tbil".equals(name)){
            attributeName = "tbil";		//肝功能-总胆红素
        }else if("conBil".equals(name)){
            attributeName = "dbil";		//肝功能-结合胆红素
        }else if("dbil".equals(name)){
            attributeName = "scr";		//肾功能-血清肌酐
        }else if("bun".equals(name)){
            attributeName = "bun";		//肾功能-血尿素氮
        }else if("chol".equals(name)){
            attributeName = "cho";		//血脂-总胆固醇
        }else if("tg".equals(name)){
            attributeName = "tg";		//血脂-甘油三酯
        }else if("ldlC".equals(name)){
            attributeName = "ldlc";		//血脂-血清低密度脂蛋白胆固醇
        }else if("hdlC".equals(name)){
            attributeName = "hdlc";		//血脂-血清高密度脂蛋白胆固醇
        }else if("glu".equals(name)){
            attributeName = "GKfxt";		//空腹血糖
        }else if("hbsag".equals(name)){
            attributeName = "hbsag";	// 乙型肝炎表面抗原 1.阴性;2.阳性;
        }else if("fundusExam".equals(name)){
            attributeName = "GYand";// 眼 底 1.正常;2.异常;
        }else if("fundusExamDesc".equals(name)){
            attributeName = "GYandyi";//眼底异常  和字段GYand有关系，当为2时，使用此字段       //TODO HealthExam
        }else if("ecgAbn".equals(name)){
            attributeName = "GXindt";// 心电图 1.正常;2.异常;
        }else if("ecgAbnDesc".equals(name)){
            attributeName = "GXindtyi";//心电图异常填写  和字段GXindt有关系，当为2时，使用此字段
        }else if("xRay".equals(name)){
            attributeName = "GXiongp"; // 胸部X线片 1.正常;2.异常;
        }
        
        else if("xRayDesc".equals(name)){
            attributeName = "GXiongpyc";	//胸部X线片异常  和字段GXiongp有关系，当为2时，使用此字段
        }else if("bExc".equals(name)){
            attributeName = "GBchao";// B超 1.正常;2.异常;
        }else if("bExcDesc".equals(name)){
            attributeName = "GBchaoyi";	//B 超异常  和字段GBchao有关系，当为2时，使用此字段
        }else if("refDept".equals(name)){	//TODO
            attributeName = "GFuzhuqt"; //辅助检查其他
        }else if("refDes".equals(name)){
            attributeName = "GJljjy";	//暂时不对应
        }else if("exDate".equals(name)){
            attributeName = "happentime";	//体检日期 //TODO
        }else if("comBehEva".equals(name)){
            attributeName = "field1";//暂时不对应
        }else if("visitsEva".equals(name)){
            attributeName = "field2";//暂时不对应
        }else if("recUser".equals(name)){
            attributeName = "field3";//暂时不对应
        }else if("recDate".equals(name)){
            attributeName = "field4";//暂时不对应
        }else if("updUser".equals(name)){
            attributeName = "GTunwei";		//暂时不对应
        }else if("updDate".equals(name)){
            attributeName = "GYtwbz";		//暂时不对应
        } else if("exeFrequency".equals(name)){
            attributeName = "GDlpl";		// 锻炼频率 1.每天;2.每周一次以上;3.偶尔;4.不锻炼;
        }else if("exeDuration".equals(name)){
            attributeName = "GMcdlsj";		//每次锻炼时间
        }else if("attExeTime".equals(name)){
            attributeName = "GJcdlsj";		//坚持锻炼时间
        }else if("exeMode".equals(name)){
            attributeName = "GDlfs";		//锻炼方式
        }else if("eatHabits".equals(name)){
            attributeName = "GYsxg";		// 饮食习惯 1.荤素均衡;2.荤食为主;3.素食为主;4.嗜盐;5.嗜油;6.嗜糖;
        }else if("smoke".equals(name)){
            attributeName = "GXyzk";		// 吸烟状况  1.从不吸烟;2.已戒烟;3.吸烟;
        }else if("daoSmoking".equals(name)){
            attributeName = "GRxyl";		//日吸烟量
        }else if("aoSmokingInit".equals(name)){
            attributeName = "GKsxynl";		//开始吸烟年龄
        }else if("qSmokingAge".equals(name)){
            attributeName = "GJynl";		//戒烟年龄
        }else if("driFrequency".equals(name)){
            attributeName = "GYjpl";		// 饮酒频率 1.从不;2.偶尔;3.经常;4.每天;
        }else if("alcConsumption".equals(name)){
            attributeName = "GRyjl";		//日饮酒量
        }else if("alcoholics".equals(name)){
            attributeName = "GSfjj";		//是否戒酒   1.未戒酒;2.已戒酒;
        }else if("allAge".equals(name)){
            attributeName = "GJjnl";		//戒酒年龄
        }else if("drinkingAge".equals(name)){
            attributeName = "GKsyjnl";		//开始饮酒年龄
        }else if("drunk".equals(name)){
            attributeName = "GYnnsfyj"; 	// 近一年内是否曾醉酒 1.是;2.否;
        }
        
        
        else if("driSpecies".equals(name)){
            attributeName = "GYjzl";		// 饮酒种类 1.白酒;2.啤酒;3.红酒;4.黄酒;99.其他;  使用逗号分隔，如1,2,3
        }else if("driSpeciesOth".equals(name)){
            attributeName = "GYjzlqt";		//其他饮酒种类   和字段GYjzl有关联，当为99时，使用此字段
        }else if("occExposure".equals(name)){
            attributeName = "GYwzybl";		// 职业病危害因素接触史 1.无;2.有;	
        }else if("occDesc".equals(name)){
            attributeName = "GJtzy";		//工种  和字段GYwzybl有关联，当为3时，使用此字段
        }else if("occLong".equals(name)){
            attributeName = "GCysj";		///从业时间  和字段GYwzybl有关联，当为3时，使用此字段
        }else if("urineOth".equals(name)){
            attributeName = "GHxp";		//化学物质  和字段GYwzybl有关联，当为3时，使用此字段  TODO
        }else if("fecOccBlo".equals(name)){
            attributeName = "GHxpfhcs";		// 职业病危害因素接触史-化学物质-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段	TODO	
        }else if("cpt".equals(name)){
            attributeName = "GHxpfhcsjt";		//化学物质措施  和字段GHxpfhcs有关联，当为2时，使用此字段	TODO
        }else if("ast".equals(name)){
            attributeName = "GDuwu";		//暂时不对应 TODO
        }else if("alb".equals(name)){
            attributeName = "GDwfhcs";		//暂时不对应	TODO
        }else if("tbil".equals(name)){
            attributeName = "GDwfhcsqt";		//暂时不对应	TODO
        }else if("conBil".equals(name)){
            attributeName = "GShexian";		//放射物质  和字段GYwzybl有关联，当为3时，使用此字段	TODO	
        }else if("dbil".equals(name)){
            attributeName = "GSxfhcs";		// 职业病危害因素接触史-放射物质-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段	TODO
        }else if("bun".equals(name)){
            attributeName = "GSxfhcsqt";		 //放射物质措施 和字段GSxfhcs有关系，当为2时，使用此字段	TODO
        }else if("lipsApp".equals(name)){
            attributeName = "GKouchun";		// 口唇 1.红润;2.苍白;3.发绀;4.皲裂;5.疱疹;6.其他;
        }else if("denCategory".equals(name)){
            attributeName = "GChilei";		// 齿列 1.正常;2.缺齿;3.龋齿;4.义齿(假牙);5.其他;  
        }else if("throatExam".equals(name)){
            attributeName = "GYanbu";		 // 咽部 1.无充血;2.充血;3.淋巴滤泡增生;4.其他;
        }else if("skinExamDesc".equals(name)){
            attributeName = "GPfqt";		//皮肤其他
        }else if("scleraExam".equals(name)){
            attributeName = "GGongmo";		// 巩 膜 1.正常;2.黄染;3.充血;99.其他;
        }else if("scleraExamDesc".equals(name)){
            attributeName = "GGmqt";		// 巩 膜其他	
        }else if("dorPedPulse".equals(name)){ 	// FacialFeatures
            attributeName = "GZbdmmd";		// 足背动脉搏动 1.未触及;2.触及双侧对称;3.触及左侧弱或消失;4.触及右侧弱或消失;
        }else if("breastExam".equals(name)){ //		Gynaecology
            attributeName = "GRuxian";			// 乳 腺 1.未见异常;2.乳房切除;3.异常泌乳;4.乳腺包块;99.其他;	
        }else if("breastExamDesc".equals(name)){
            attributeName = "GRuxianqt";		//其他乳腺  和字段GRuxian有关系，当为99时，使用此字段
        }else if("genAbn".equals(name)){
            attributeName = "GWaiyin";		// 外阴 1.未见异常;2.异常; 
        }else if("genAbnDesc".equals(name)){
            attributeName = "GWaiyinyc"; 	//外阴异常  和字段GWaiyin有关系，当为2时，使用此字段
        }else if("vagAbn".equals(name)){
            attributeName = "GYindao";			//  阴道 1.未见异常;2.异常;
        }else if("vagAbnDesc".equals(name)){
            attributeName = "GYindaoyc";			//阴道异常  和字段GYindao有关系，当为2时，使用此字段 
        }else if("cerAbn".equals(name)){
            attributeName = "GGongjing";		 // 宫颈 1.未见异常;2.异常; 
        }else if("cerAbnDesc".equals(name)){	
            attributeName = "GGongjingyc"; 		//宫颈异常  和字段GGongjing有关系，当为2时，使用此字段 
        }else if("palAbn".equals(name)){
            attributeName = "GGongti";			// 宫体 1.未见异常;2.异常; 
        }else if("palAbnDesc".equals(name)){
            attributeName = "GGongtiyc";		 //宫体异常
        }else if("annAbn".equals(name)){
            attributeName = "GFujian";			// 附件 1.未见异常;2.异常;
        }else if("annAbnDesc".equals(name)){
            attributeName = "GFujianyc";			//附件异常
        }else if("potCon".equals(name)){
            attributeName = "GSgnxjnd";			//肾功能-血钾浓度   BloodRoutineUrianlysis
        }else if("sodCon".equals(name)){
            attributeName = "GSgnxnnd";			//肾功能-血钠浓度  BloodRoutineUrianlysis
        }else if("hemoglobin".equals(name)){
            attributeName = "GThxhdb";			//糖化血红蛋白   BloodRoutineUrianlysis
        }else if("cerSme".equals(name)){
            attributeName = "GGjtp";		// 宫颈涂片 1.正常;2.异常
        }else if("cerSmeDesc".equals(name)){
            attributeName = "GGjtpyc";		//宫颈涂片异常  和字段GGjtp有关系，当为2时，使用此字段
       } else if("tcmPhz".equals(name)){ //ChineseMedical
            attributeName = "GPhz";		// 平和质 1.是;2.基本是
        }else if("tcmQxz".equals(name)){
            attributeName = "GQxz";		// 气虚质 1.是;2.倾向是
        }else if("tcmYxz".equals(name)){
            attributeName = "GYangxz";		/// 阳虚质 1.是;2.倾向是;
        }else if("tcmYixz".equals(name)){
            attributeName = "GYinxz";		// 阴虚质 1.是;2.倾向是;
        }else if("tcmTsz".equals(name)){
            attributeName = "GTsz";		// 痰湿质 1.是;2.倾向是;
        }else if("tcmSrz".equals(name)){
            attributeName = "GSrz";		// 湿热质 1.是;2.倾向是;
        }else if("tcmXtz".equals(name)){
            attributeName = "GXyz";		// 血瘀质 1.是;2.倾向是;
        }else if("tcmQyz".equals(name)){
            attributeName = "GQyz";		// 气郁质 1.是;2.倾向是
        }else if("tcmTbz".equals(name)){
            attributeName = "GTbz";		// 特秉质 1.是;2.倾向是; ChineseMedical	END
        }else if("cerDis".equals(name)){	//HealthInfo
            attributeName = "GNxgjb";		// 脑血管疾病 1.未发现;2.缺血性卒中;3.脑出血;4.蛛网膜下腔出血;5.短暂性脑缺血发作;99.其他;
        }else if("cerDisOth".equals(name)){
            attributeName = "GNxgjbqt";		// 脑血管疾病 其他
        }else if("kidDis".equals(name)){
            attributeName = "GSzjb";		// 肾脏疾病 1.未发现;2.糖尿病肾病;3.肾功能衰竭;4.急性肾炎;5.慢性肾炎;99.其他;
        }else if("kidDisOth".equals(name)){
            attributeName = "GSzjbqt";		 // 肾脏疾病其他
        }else if("heaDis".equals(name)){
            attributeName = "GXzjb";		// 心脏疾病 1.未发现;2.心肌梗死;3.心绞痛;4.冠状动脉血运重建;5.充血性心力衰竭;6.心前区疼痛;99.其他;
        }else if("heaDisOth".equals(name)){
            attributeName = "GXzjbqt"; 	 // 心脏疾病其他
        }else if("vasDis".equals(name)){
        attributeName = "GXgjb";		// 血管疾病 1.未发现;2.夹层动脉瘤;3.动脉闭塞性疾病;99.其他;
        }else if("vasDisOth".equals(name)){
            attributeName = "GXgjbqt";		// 血管疾病其他
        }else if("eyeDis".equals(name)){
            attributeName = "GYbjb";		//  眼部疾病1.未发现;2.视网膜出血或渗出;3.视乳头水肿;4.白内障;99.其他;
        }else if("eyeDisOth".equals(name)){
            attributeName = "GYbjbqt";		//  眼部疾病其他
        }else if("nerDis".equals(name)){
            attributeName = "GSjxtjb";		/// 神经系统疾病 1.未发现;2.有;
        }else if("nerDisDes".equals(name)){
            attributeName = "GSjxtjbqt";		//神经系统疾病有时的填写
        }else if("otherDis".equals(name)){
            attributeName = "GQtxtjb";		// 其他系统疾病 1.未发现;2.有;
        }else if("otherDisDes".equals(name)){
            attributeName = "GQtxtjbqt";		//其他系统疾病有时填写
        }else if("qSmokingAge".equals(name)){
            attributeName = "GJkpj";		// 健康评价 1.体检无异常;2.有异常;	TODO
        }else if("driFrequency".equals(name)){
            attributeName = "GJkpjyc1";		//健康评价异常1  和字段GJkpj有关系，当为2时，使用此字段	TODO
        }else if("alcConsumption".equals(name)){
            attributeName = "GJkpjyc2";		//健康评价异常2  和字段GJkpj有关系，当为2时，使用此字段	TODO	
        }else if("alcoholics".equals(name)){
            attributeName = "GJkpjyc3";		//健康评价异常3  和字段GJkpj有关系，当为2时，使用此字段	TODO
        }else if("allAge".equals(name)){
            attributeName = "GJkpjyc4";		//健康评价异常4  和字段GJkpj有关系，当为2时，使用此字段  	TODO
        
        
        
        
        
        
    }else if("vasDisOth".equals(name)){
        attributeName = "GJkzd";		// 健康指导 1.定期随访;2.纳入慢性病管理;3.建议复查;4.建议转诊;
    }else if("eyeDis".equals(name)){
        attributeName = "GWxyskz";		// 危险因素控制 1.戒烟;2.健康饮酒;3.饮食;4.锻炼;97.减体重;98.建议疫苗接种;99.其他;
    }else if("eyeDisOth".equals(name)){
        attributeName = "GWxystz";		//危险因素控制  目标填写
    }else if("nerDis".equals(name)){
        attributeName = "GWsysym";		//危险因素控制建议疫苗接种 填写
    }else if("nerDisDes".equals(name)){
        attributeName = "GWxysqt";		//危险因素控制其他  填写
    }else if("otherDis".equals(name)){
        attributeName = "field5";		 //暂不对应
    }else if("otherDisDes".equals(name)){
        attributeName = "GZzqt";		//其他症状    和字段GZhzh有联系，当为99时，使用此字段
    }else if("qSmokingAge".equals(name)){
        attributeName = "GXyyc";		//不对应
    }else if("driFrequency".equals(name)){
        attributeName = "GXyzc";		//不对应
    }else if("alcConsumption".equals(name)){
        attributeName = "GQtzhzh";		//不对应	
    }else if("alcoholics".equals(name)){
        attributeName = "qdqxz";		//不对应
    }else if("allAge".equals(name)){
        attributeName = "info";		//不对应
    }else if("vasDisOth".equals(name)){
        attributeName = "kchqt";		//口唇其他  和字段GKouchun有关系，当为6时，使用此字段 暂不对应
    }else if("eyeDis".equals(name)){
        attributeName = "chlqt";		//齿列其他  暂不对应
    }else if("eyeDisOth".equals(name)){
        attributeName = "ybqt";		//咽部其他  和字段GYanbu有关系，当为4时，使用此字段 暂不对应
    }else if("nerDis".equals(name)){
        attributeName = "ydgnqt";		//不对应
    }else if("nerDisDes".equals(name)){
        attributeName = "wzd";		//不对应
    }else if("nerDis".equals(name)){
        attributeName = "GChxt";		//餐后2H血糖
    }
        
    else if("otherDis".equals(name)){
        attributeName = "lnrzkpg";		// 老年人健康状态自我评估 1.满意;2.基本满意;3.说不清楚;4.不太满意;5.不满意;
    }else if("otherDisDes".equals(name)){
        attributeName = "lnrzlpg";		// 老年人生活自理能力自我评估 1.可自理(0～3分);2.轻度依赖(4～8分);3.中度依赖(9～18分);4.不能自理(≥19分);
    }else if("qSmokingAge".equals(name)){
        attributeName = "fenchen";		//粉尘  和字段GYwzybl有关联，当为3时，使用此字段
    }else if("driFrequency".equals(name)){
        attributeName = "wuliyinsu";		//物理因素 和字段GYwzybl有关联，当为3时，使用此字段
    }else if("alcConsumption".equals(name)){
        attributeName = "blqita";		//职业病危害因素接触史 其他  和字段GYwzybl有关联，当为3时，使用此字段	
    }else if("alcoholics".equals(name)){
        attributeName = "fchcs";		// 职业病危害因素接触史-粉尘-防护措施  1.无;2.有;  和字段GYwzybl有关联，当为3时，使用此字段
    }else if("allAge".equals(name)){
        attributeName = "wlcs";		// 职业病危害因素接触史-物理因素-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段
    }
        
        
    else if("allAge".equals(name)){
        attributeName = "blqtcs";		// 职业病危害因素接触史-其他-防护措施 1.无;2.有;  和字段GYwzybl有关联，当为3时，使用此字段
    }else if("vasDisOth".equals(name)){
        attributeName = "fchY";		///粉尘措施  和字段fchcs有关系，当为2时，使用此字段
    }else if("eyeDis".equals(name)){
        attributeName = "wlY";		//物理因素措施  和字段wlcs有关系，当为2时，使用此字段
    }else if("eyeDisOth".equals(name)){
        attributeName = "qtY";		//职业病危害因素接触史-其他措施  和字段blqtcs有关联，当为2时，使用此字段
    }else if("nerDis".equals(name)){
        attributeName = "tnbfxjf";		//不对应	TODO
    }else if("nerDisDes".equals(name)){
        attributeName = "zcyy";		//左侧原因
    }else if("otherDis".equals(name)){
        attributeName = "ycyy";		//右侧原因
    }else if("otherDisDes".equals(name)){
        attributeName = "nwlbdb";		 //尿微量白蛋白 
    }else if("qSmokingAge".equals(name)){
        attributeName = "DJkbs";		//不对应	TODO
    }else if("driFrequency".equals(name)){
        attributeName = "GClque";		//缺齿 
    }else if("alcConsumption".equals(name)){
        attributeName = "GClqu";		//龋齿	
    }else if("alcoholics".equals(name)){
        attributeName = "GClyi";		//义齿(假牙)
    }else{
        attributeName = "";
    }
        return attributeName;
    }
    
    /** 
     * @Title: getVaccinateAttrabutName 
     * @Description: 非免疫规划预防接种 
     * @param name
     * @return    
     * @retrun String
     */
    public static String getVaccinateAttrabutName(String name){
        String attributeName = "";
        if("hrGid".equals(name)){
            attributeName = "DGrdabh";
        }else if("vaccine".equals(name)){
            attributeName = "FJzmc";
        }else if("vaccineDate".equals(name)){
            attributeName = "FJzrq";
        }else if("vaccineIns".equals(name)){
            attributeName = "FJzjg";
        }else if("updateDate".equals(name)){
            attributeName = "FHappentime";
        }else{
            attributeName = "";
        }
        return attributeName;
    }
    
    /** 
     * @Title: getHospInfoAttrabutName 
     * @Description: 住院治疗状况 
     * @param name
     * @return    
     * @retrun String
     */
    public static String getHospInfoAttrabutName(String name){
        String attributeName = "";
        if("hrGid".equals(name)){
            attributeName = "DGrdabh";
        }else if("beginDate".equals(name)){
            attributeName = "ZRyjcrq";
        }else if("endDate".equals(name)){
            attributeName = "ZCyccrq";
        }else if("admRes".equals(name)){
            attributeName = "ZYuanyin";
        }else if("inpHospitalName".equals(name)){
            attributeName = "ZYljgmc";
        }else if("inpNo".equals(name)){
            attributeName = "ZBingah";
        }else if("updateTime".equals(name)){
            attributeName = "ZHappentime";
        }else{
            attributeName = "";
        }
        return attributeName;
    }
    
}
