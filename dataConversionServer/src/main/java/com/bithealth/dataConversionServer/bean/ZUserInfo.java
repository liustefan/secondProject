package com.bithealth.dataConversionServer.bean;


/**
 * @ClassName:     ZUserInfo.java 
 * @Description:   中联佳裕用户基本信息实体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月22日 下午3:59:30
*****/
public class ZUserInfo {
	private String id;
	/** 家庭档案编号 */
	private String DJtdabh;
	/** 姓名 */
	private String DXm;
	/** 身份证号 */
	private String DSfzh;
	/** 健康档案编号 */
	private String DGrdabh;
	/** 拼音简写 */
	private String DPyjm;
	/** 与户主关系 1户主  2.配偶;3.子女;4.(外)孙子女;5.父母;6.(外)祖父母;7.兄弟姐妹;8.儿媳;9.女婿;10.孙子女;11.侄子女;12.曾孙子女;13.祖父母;99.其他 */
	private String DYhzgx;
	/** 工作单位 */
	private String DGzdw;
	/** 联系电话 */
	private String DLxdh;
	/** 邮箱 */
	private String DEmail;
	/** 省 */
	private String DSheng;
	/** 市 */
	private String DShi;
	/** 区(县) */
	private String DQu;
	/** 街道(乡) */
	private String DJd;
	/** 居委会 */
	private String DJwh;
	/** 详细地址 */
	private String DXxdz;
	/** 所属片区 */
	private String DSspq;
	/** 居住状况  1.本地户籍常住;2.本地户籍不常住;3.外地户籍常住;4.不详; (可不写) */
	private String DJzzk;
	/** 性别*/
	private String DXb;
	/** 出生日期*/
	private String DCsrq;
	/** 民族 */
	private String DMz;
	/** 文化程度  10.研究生及以上;20.大学本科;30.大学专科和专科学校;40.中等专业学校;50.技工学校;60.高中;70.初中;80.小学;90.文盲或半文盲;99.学历不详;100.无;*/
	private String DWhcd;
	/** 职业  1.农林牧渔水利业生产人员;2.生产运输设备操作人员及有关人员;3.专业技术人员;4.办事人员和有关人员;5.商业、服务业人员;6.国家机关、党群组织、企事业单位负责人;7.在校学生;8.家务;9.待业;10.离退休人员;11.婴幼、学龄前儿童;12.军人;99.其他劳动者;*/
	private String DZy;
	/** 婚姻状况 ，10.未婚;20.已婚;21.初婚;22.再婚;23.复婚;30.丧偶;40.离异;90.未说明的婚姻状况;*/
	private String DHyzk;
	/** 医疗费支付类型  1.全自费;2.全公费;3.城镇职工基本医疗保险;4.城镇居民基本医疗保险;5.新型农村合作医疗;6.社会医疗保险;7.商业医疗保险;8.贫困救助;99.其他; */
	private String DYlfzflx;
	/** 医疗保险号 */
	private String DYlbxh;
	/** 新农合号 */
	private String DXnhh;
	/** 调查时间   上传信息时happentime必填项*/
	private String happentime;
	/** 联系人姓名 */
	private String DLxrxm;
	/** 联系人电话*/
	private String DLxrdh;
	/** 医疗支付方式其他  和字段DYlfzflx有关系，当为99时，使用此字段 */
	private String DYlfzflxqt;
	/** 怀孕情况  0.未孕;1.已孕未生产;2.已生产(随访期内);3.已生产(随访期外); */
	private String lhyqk;
	/** 孕次 */
	private String lyc;
	/** 孕次生产*/
	private String lycsc;
	/** 产次 */
	private String lcc;
	/** 产次生产 */
	private String lccsc;
	/**  */
	private String qdqxz;
	/** 档案类别  1.城镇;2.农村; */
	private String DDalb;
	/** 档案状态  1.活动;2.非活动; */
	private String DDazt;
	/** 档案非活动状态原因  1.死亡;2.失踪;3.迁出;4.其他;5.长期外出;  和字段DDazt有关系，当为2时，使用此字段 */
	private String DDaztyy;
	/** 证件类型 1.身份证;2.护照(外籍人士);3.军官证;  */
	private String DZjlx;
	/**  */
	private String DZjhqt;
	/**  */
	private String DZxzt;
	/** 所属机构 */
	private String PRgid;
	/** 是否高血压*/
	private String IsGxy;
	/** 是否糖尿病*/
	private String IsTnb;
	/** 是否冠心病*/
	private String IsGxb;
	/** 是否脑卒中*/
	private String IsNzz;
	
	/* 在hkhk数据库中对应的memberid */
    private int memberid;
	
	
	
	
	public String getIsGxy() {
		return IsGxy;
	}
	public void setIsGxy(String isGxy) {
		IsGxy = isGxy;
	}
	public String getIsTnb() {
		return IsTnb;
	}
	public void setIsTnb(String isTnb) {
		IsTnb = isTnb;
	}
	public String getIsGxb() {
		return IsGxb;
	}
	public void setIsGxb(String isGxb) {
		IsGxb = isGxb;
	}
	public String getIsNzz() {
		return IsNzz;
	}
	public void setIsNzz(String isNzz) {
		IsNzz = isNzz;
	}
	public String getPRgid() {
		return PRgid;
	}
	public void setPRgid(String pRgid) {
		PRgid = pRgid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDJtdabh() {
		return DJtdabh;
	}
	public void setDJtdabh(String dJtdabh) {
		DJtdabh = dJtdabh;
	}
	public String getDXm() {
		return DXm;
	}
	public void setDXm(String dXm) {
		DXm = dXm;
	}
	public String getDSfzh() {
		return DSfzh;
	}
	public void setDSfzh(String dSfzh) {
		DSfzh = dSfzh;
	}
	public String getDGrdabh() {
		return DGrdabh;
	}
	public void setDGrdabh(String dGrdabh) {
		DGrdabh = dGrdabh;
	}
	public String getDPyjm() {
		return DPyjm;
	}
	public void setDPyjm(String dPyjm) {
		DPyjm = dPyjm;
	}
	public String getDYhzgx() {
		return DYhzgx;
	}
	public void setDYhzgx(String dYhzgx) {
		DYhzgx = dYhzgx;
	}
	public String getDGzdw() {
		return DGzdw;
	}
	public void setDGzdw(String dGzdw) {
		DGzdw = dGzdw;
	}
	public String getDLxdh() {
		return DLxdh;
	}
	public void setDLxdh(String dLxdh) {
		DLxdh = dLxdh;
	}
	public String getDEmail() {
		return DEmail;
	}
	public void setDEmail(String dEmail) {
		DEmail = dEmail;
	}
	public String getDSheng() {
		return DSheng;
	}
	public void setDSheng(String dSheng) {
		DSheng = dSheng;
	}
	public String getDShi() {
		return DShi;
	}
	public void setDShi(String dShi) {
		DShi = dShi;
	}
	public String getDQu() {
		return DQu;
	}
	public void setDQu(String dQu) {
		DQu = dQu;
	}
	public String getDJd() {
		return DJd;
	}
	public void setDJd(String dJd) {
		DJd = dJd;
	}
	public String getDJwh() {
		return DJwh;
	}
	public void setDJwh(String dJwh) {
		DJwh = dJwh;
	}
	public String getDXxdz() {
		return DXxdz;
	}
	public void setDXxdz(String dXxdz) {
		DXxdz = dXxdz;
	}
	public String getDSspq() {
		return DSspq;
	}
	public void setDSspq(String dSspq) {
		DSspq = dSspq;
	}
	public String getDJzzk() {
		return DJzzk;
	}
	public void setDJzzk(String dJzzk) {
		DJzzk = dJzzk;
	}
	public String getDXb() {
		return DXb;
	}
	public void setDXb(String dXb) {
		DXb = dXb;
	}
	public String getDCsrq() {
		return DCsrq;
	}
	public void setDCsrq(String dCsrq) {
		DCsrq = dCsrq;
	}
	public String getDMz() {
		return DMz;
	}
	public void setDMz(String dMz) {
		DMz = dMz;
	}
	public String getDWhcd() {
		return DWhcd;
	}
	public void setDWhcd(String dWhcd) {
		DWhcd = dWhcd;
	}
	public String getDZy() {
		return DZy;
	}
	public void setDZy(String dZy) {
		DZy = dZy;
	}
	public String getDHyzk() {
		return DHyzk;
	}
	public void setDHyzk(String dHyzk) {
		DHyzk = dHyzk;
	}
	public String getDYlfzflx() {
		return DYlfzflx;
	}
	public void setDYlfzflx(String dYlfzflx) {
		DYlfzflx = dYlfzflx;
	}
	public String getDYlbxh() {
		return DYlbxh;
	}
	public void setDYlbxh(String dYlbxh) {
		DYlbxh = dYlbxh;
	}
	public String getDXnhh() {
		return DXnhh;
	}
	public void setDXnhh(String dXnhh) {
		DXnhh = dXnhh;
	}
	public String getHappentime() {
		return happentime;
	}
	public void setHappentime(String happentime) {
		this.happentime = happentime;
	}
	public String getDLxrxm() {
		return DLxrxm;
	}
	public void setDLxrxm(String dLxrxm) {
		DLxrxm = dLxrxm;
	}
	public String getDLxrdh() {
		return DLxrdh;
	}
	public void setDLxrdh(String dLxrdh) {
		DLxrdh = dLxrdh;
	}
	public String getDYlfzflxqt() {
		return DYlfzflxqt;
	}
	public void setDYlfzflxqt(String dYlfzflxqt) {
		DYlfzflxqt = dYlfzflxqt;
	}
	public String getLhyqk() {
		return lhyqk;
	}
	public void setLhyqk(String lhyqk) {
		this.lhyqk = lhyqk;
	}
	public String getLyc() {
		return lyc;
	}
	public void setLyc(String lyc) {
		this.lyc = lyc;
	}
	public String getLycsc() {
		return lycsc;
	}
	public void setLycsc(String lycsc) {
		this.lycsc = lycsc;
	}
	public String getLcc() {
		return lcc;
	}
	public void setLcc(String lcc) {
		this.lcc = lcc;
	}
	public String getLccsc() {
		return lccsc;
	}
	public void setLccsc(String lccsc) {
		this.lccsc = lccsc;
	}
	public String getQdqxz() {
		return qdqxz;
	}
	public void setQdqxz(String qdqxz) {
		this.qdqxz = qdqxz;
	}
	public String getDDalb() {
		return DDalb;
	}
	public void setDDalb(String dDalb) {
		DDalb = dDalb;
	}
	public String getDDazt() {
		return DDazt;
	}
	public void setDDazt(String dDazt) {
		DDazt = dDazt;
	}
	public String getDDaztyy() {
		return DDaztyy;
	}
	public void setDDaztyy(String dDaztyy) {
		DDaztyy = dDaztyy;
	}
	public String getDZjlx() {
		return DZjlx;
	}
	public void setDZjlx(String dZjlx) {
		DZjlx = dZjlx;
	}
	public String getDZjhqt() {
		return DZjhqt;
	}
	public void setDZjhqt(String dZjhqt) {
		DZjhqt = dZjhqt;
	}
	public String getDZxzt() {
		return DZxzt;
	}
	public void setDZxzt(String dZxzt) {
		DZxzt = dZxzt;
	}
    public int getMemberid() {
        return memberid;
    }
    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

	
}