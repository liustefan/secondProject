package com.bithealth.dataConversionServer.bean;

import java.io.Serializable;
/**
 * @ClassName:     BloodRoutineUrianlysis.java 
 * @Description:   血常规检测
 * @author         liuxiaoqin  
 * @version        V1.0   
 * @Date           2015年12月19日 下午4:34:08
*****/
public class BloodRoutineUrianlysis implements Serializable {

    private static final long serialVersionUID = 6759906338684633953L;
    
    /*  体检编号  */
    private String exId;
    
    /*  健康档案编号  */
    private String hrGid;
    
    /*  乙肝表面抗原;1.阴性 2.阳性  */
    private String hbsag;
    
    /*  血清谷丙转氨酶单位为U/L  */
    private int cpt;
    
    /*  血清谷草转氨酶单位为U/L  */
    private int ast;
    
    /*  白蛋白单位为g/L  */
    private int alb;
    
    /* 总胆红素单位为μmol/L  */
    private double tbil;
    
    /*  结合胆红素单位为μmol/L  */
    private double conBil;
    
    /*  血清肌酐单位为μmol/L */
    private double cr;
    
    /*  血尿素氮单位为mmol/L  */
    private double bun;
    
    /*  血钾浓度单位为mmol/L  */
    private double potCon;
    
    /*  血钠浓度单位为mmol/L */
    private int sodCon;
    
    /* 总胆固醇单位为mmol/L  */
    private double chol;
    
    /*  甘油三酯单位为mmol/L  */
    private double tg;
    
    /* 血清低密度脂蛋白胆固醇单位为mmol/L  */
    private double ldlC;
    
    /*  血清高密度脂蛋白胆固醇单位为mmol/L  */
    private double hdlC;
    
    /*  血红蛋白,单位为g/L */
    private int hemoglobin;
    
    /*  白细胞,单位为g/L  */
    private double leukocyte;
    
    /*  血小板,单位为G/L  */
    private int bloodPlatelet;

    public String getExId() {
        return exId;
    }

    public void setExId(String exId) {
        this.exId = exId;
    }

    public String getHrGid() {
        return hrGid;
    }

    public void setHrGid(String hrGid) {
        this.hrGid = hrGid;
    }

    public String getHbsag() {
        return hbsag;
    }

    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }

    public int getCpt() {
        return cpt;
    }

    public void setCpt(int cpt) {
        this.cpt = cpt;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getAlb() {
        return alb;
    }

    public void setAlb(int alb) {
        this.alb = alb;
    }

    public double getTbil() {
        return tbil;
    }

    public void setTbil(double tbil) {
        this.tbil = tbil;
    }

    public double getConBil() {
        return conBil;
    }

    public void setConBil(double conBil) {
        this.conBil = conBil;
    }

    public double getCr() {
        return cr;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }

    public double getBun() {
        return bun;
    }

    public void setBun(double bun) {
        this.bun = bun;
    }

    public double getPotCon() {
        return potCon;
    }

    public void setPotCon(double potCon) {
        this.potCon = potCon;
    }

    public int getSodCon() {
        return sodCon;
    }

    public void setSodCon(int sodCon) {
        this.sodCon = sodCon;
    }

    public double getChol() {
        return chol;
    }

    public void setChol(double chol) {
        this.chol = chol;
    }

    public double getTg() {
        return tg;
    }

    public void setTg(double tg) {
        this.tg = tg;
    }

    public double getLdlC() {
        return ldlC;
    }

    public void setLdlC(double ldlC) {
        this.ldlC = ldlC;
    }

    public double getHdlC() {
        return hdlC;
    }

    public void setHdlC(double hdlC) {
        this.hdlC = hdlC;
    }

    public int getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(int hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public double getLeukocyte() {
        return leukocyte;
    }

    public void setLeukocyte(double leukocyte) {
        this.leukocyte = leukocyte;
    }

    public int getBloodPlatelet() {
        return bloodPlatelet;
    }

    public void setBloodPlatelet(int bloodPlatelet) {
        this.bloodPlatelet = bloodPlatelet;
    }
    

}
