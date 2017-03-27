// 打开弹出页面 title 页面标题 ， type 页面类型， cb 打开页面之后的回调函数， source 要给页面传的参数
function openPage(title, type, cb, source) {
	var url = '',
		area = ['710px', '400px'];
	
	if(type == "members") {
		// 选择会员
		url = 'members';
	}else if(type == "doctors") {
		// 选择医生
		url = 'doctors';
	}else if(type == "iDoctors"){
		// 选择医生
		url = '../physical/doctors';
	}else if(type == "editHOIV") {
		// 编辑住院史
		url = '../editHOIV.jsp';
		area = ['416px', '380px']
	}else if(type == "editHODSB") {
		// 家庭病床史
		url = '../editHODSB.jsp';
		area = ['416px', '380px']
	}else if(type == "editMedicinal") {
		// 用药情况
		url = '../../inspect/editMedicinal.jsp?source='+source;
		area = ['416px', source=='healthExam'?'510px':'420px'];
	}else if(type == "editIPVH") {
		// 非免疫规划预防接种史
		url = '../editIPVH.jsp';
		area = ['416px', '280px']
	}
	
	layer.closeAll('iframe');
	layer.open({
	    type: 2,
		skin : 'skin1',
	    title: title,
	    shadeClose: false,
	    shade: 0,
	    area: area,
	    content: url, //iframe的url
	    success: function(layero, index) {
	    		if(cb) {
	    			cb(layero, index);
	    		}
	    }
	}); 

}


// 打开修改住院史页面
function editHOIV() {
	var checkboxs = $("#hoiv input[type='checkbox']:checked"),
		objTr;
	
	if(checkboxs.length <= 0) {
		layer.alert("请选择住院史信息", {shade: 0,skin : 'skin1'});
		return;
	}
	if(checkboxs.length >1) {
		layer.alert("只能选择一条住院史信息", {shade: 0,skin : 'skin1'});
		return;
	}
	objTr = $(checkboxs).parent("td").parent("tr").find("td");
	
	openPage('修改住院史', 'editHOIV',function(layero, index) {
		setHoiv(layero, index, objTr)
	});
	
}

//取消提示
function cancelMsg(msg) {
	  layer.confirm(msg, {
		  skin : 'skin1',
		  shade: 0,
	      btn: ['确认','取消'] //按钮
	  }, function(){
		  history.go(-1);
	  }, function(){
	      
	  });
}
// 添加住院史table内容
function addHoiv(obj, id) {
	var parentDome = $("table#"+id+" tbody");
	var index = parentDome.children('tr').last().find('input[type="checkbox"]').val();
		index = index?+index + 1: 0;
	
	var str = '<tr id="hoiv-cb-'+ index +'">' +
		'<td><input type="checkbox"  value="'+ index +'" ></td>' +
		'<td><input type="hidden" name="phHealthexamdetailinpatients['+ index +'].startDate" value="'+obj.admissionDate+'"><span>'+obj.admissionDate+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailinpatients['+ index +'].endTime" value="'+obj.dischargeDate+'"><span>'+obj.dischargeDate+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailinpatients['+ index +'].institution" value="'+obj.organization+'"><span>'+obj.organization+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailinpatients['+ index +'].patientID" value="'+obj.fileNumber+'"><span>'+obj.fileNumber+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailinpatients['+ index +'].resson" value="'+obj.reason+'"><span>'+obj.reason+'</span></td>' +
		'</tr>';
	parentDome.append(str);
}

// 更新住院史table内容
function updateHoiv(obj, id) {
	var str ='<td><input type="checkbox"  value="'+ obj.index +'" ><input type="hidden" name="phHealthexamdetailinpatients['+ obj.index +'].logID" value="'+obj.logID+'"/></td>' +
	'<td><input type="hidden" name="phHealthexamdetailinpatients['+ obj.index +'].startDate" value="'+obj.admissionDate+'"><span>'+obj.admissionDate+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailinpatients['+ obj.index +'].endTime" value="'+obj.dischargeDate+'"><span>'+obj.dischargeDate+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailinpatients['+ obj.index +'].institution" value="'+obj.organization+'"><span>'+obj.organization+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailinpatients['+ obj.index +'].patientID" value="'+obj.fileNumber+'"><span>'+obj.fileNumber+'</span></td>'+
	'<td><input type="hidden" name="phHealthexamdetailinpatients['+ obj.index +'].resson" value="'+obj.reason+'"><span>'+obj.reason+'</span></td>' ;
	
	$("table#"+id+" tbody #hoiv-cb-"+obj.index).html(str);
}
//  删除住院史
function removeTr(id,msg) {
	var checkboxs = $("#"+id+" input[type='checkbox']:checked").parent("td").parent("tr");
	if(checkboxs.length <= 0) { 
		layer.alert("请选择需要删除的信息", {shade: 0,skin : 'skin1'});
		return;
	}
	 layer.confirm(msg, {
		  skin : 'skin1',
		  shade: 0,
	      btn: ['确认','取消'] //按钮
	  }, function(i){
		  $(checkboxs).each(function(index, element) {
				element.remove();
			}),
			layer.close(i);
	  }, function(){
	      
	  });
}

// 拿到数据填充住院史表单
function setHoiv(layero, index, list) {
	// 获取弹出页面的外层div
	var p = layer.getChildFrame("#form-hospitalization", index);
	$(p).find("input[name='logID']").val($(list[0]).find("input[type='hidden']").val());
	$(p).find("input[name='index']").val($(list[0]).find("input[type='checkbox']").val());
	$(p).find("input[name='admissionDate']").val($(list[1]).find("span").html());
	$(p).find("input[name='dischargeDate']").val($(list[2]).find("span").html());
	$(p).find("input[name='organization']").val($(list[3]).find("span").html());
	$(p).find("input[name='fileNumber']").val($(list[4]).find("span").html());	
	$(p).find("textarea[name='reason']").val($(list[5]).find("span").html());
}

//添加家庭病床史
function addHospitalRecord(obj, id) {
	var parentDome = $("table#"+id+" tbody");
	var index = parentDome.children('tr').last().find('input[type="checkbox"]').val();
		index = index?+index + 1: 0;
	
	var str = '<tr id="detailHODSB-cb-'+ index +'">' +
		'<td><input type="checkbox"  value="'+ index +'" ></td>' +
		'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ index +'].startDate" value="'+obj.startDate+'"><span>'+obj.startDate+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ index +'].endTime" value="'+obj.endDate+'"><span>'+obj.endDate+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ index +'].institution" value="'+obj.organizationName+'"><span>'+obj.organizationName+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ index +'].patientID" value="'+obj.fileNumber+'"><span>'+obj.fileNumber+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ index +'].resson" value="'+obj.account+'"><span>'+obj.account+'</span></td>' +
		'</tr>';
	parentDome.append(str);
}

//更新病床史table内容
function updateHospitalRecord(obj, id) {
	var str ='<td><input type="checkbox"  value="'+ obj.index +'" ><input type="hidden" name="phHealthexamdetailfamilybeds['+ obj.index +'].logID" value="'+obj.logID+'"/></td>' +
	'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ obj.index +'].startDate" value="'+obj.startDate+'"><span>'+obj.startDate+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ obj.index +'].endTime" value="'+obj.endDate+'"><span>'+obj.endDate+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ obj.index +'].institution" value="'+obj.organizationName+'"><span>'+obj.organizationName+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ obj.index +'].patientID" value="'+obj.fileNumber+'"><span>'+obj.fileNumber+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailfamilybeds['+ obj.index +'].resson" value="'+obj.account+'"><span>'+obj.account+'</span></td>';
	
	$("table#"+id+" tbody #detailHODSB-cb-"+obj.index).html(str);
}

//拿到数据填充病床史表单
function setHospitalRecord(layero, index, list) {
	// 获取弹出页面的外层div
	var p = layer.getChildFrame("#form-detailHODSB", index);
	$(p).find("input[name='logID']").val($(list[0]).find("input[type='hidden']").val());
	$(p).find("input[name='index']").val($(list[0]).find("input[type='checkbox']").val());
	$(p).find("input[name='startDate']").val($(list[1]).find("span").html());
	$(p).find("input[name='endDate']").val($(list[2]).find("span").html());
	$(p).find("input[name='organizationName']").val($(list[3]).find("span").html());
	$(p).find("input[name='fileNumber']").val($(list[4]).find("span").html());
	$(p).find("textarea[name='account']").val($(list[5]).find("span").html());	
}

//打开修改病床史页面
function editHospitalRecord() {
	var checkboxs = $("#detailHODSB input[type='checkbox']:checked"),
		objTr;
	
	if(checkboxs.length <= 0) {
		layer.alert("请选择病床史页面信息", {shade: 0,skin : 'skin1'});
		return;
	}
	if(checkboxs.length >1) {
		layer.alert("只能选择一条病床史信息", {shade: 0,skin : 'skin1'});
		return;
	}
	objTr = $(checkboxs).parent("td").parent("tr").find("td");
	
	openPage('修改家庭病床史', 'editHODSB',function(layero, index) {
		setHospitalRecord(layero, index, objTr)
	});
	
}

//添加主要用药情况
function addMedicinal(obj, id, page) {
	var parentDome = $("table#"+id+" tbody");
	var index = parentDome.children('tr').last().find('input[type="checkbox"]').val();
		index = index?+index + 1: 0;
	var str='';
	
	if(page=="hypertension"){
		str = '<tr id="Medicinal-cb-'+ index +'">' +
		'<td><input type="checkbox"  value="'+ index +'" ></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ index +'].drugName" value="'+obj.drugName+'"><span>'+obj.drugName+'</span></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ index +'].drugUsage" value="'+obj.useMethod+'"><span>'+obj.useMethod+'</span></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ index +'].drugDosage" value="'+obj.count+'"><span>'+obj.count+'</span></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ index +'].drugUnit" value="'+obj.dosageUnit+'"><span>'+obj.dosageUnit+'</span></td>'+
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ index +'].drugFreq" value="'+obj.frequentness+'"><span>'+obj.frequentness+'</span></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ index +'].remarks" value="'+obj.remark+'"><span>'+obj.remark+'</span></td>' +
		'</tr>';
	}else if(page == 'diabetes'){
		str = '<tr id="Medicinal-cb-'+ index +'">' +
		'<td><input type="checkbox"  value="'+ index +'" ></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ index +'].drugName" value="'+obj.drugName+'"><span>'+obj.drugName+'</span></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ index +'].drugUsage" value="'+obj.useMethod+'"><span>'+obj.useMethod+'</span></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ index +'].drugDosage" value="'+obj.count+'"><span>'+obj.count+'</span></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ index +'].drugUnit" value="'+obj.dosageUnit+'"><span>'+obj.dosageUnit+'</span></td>'+
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ index +'].drugFreq" value="'+obj.frequentness+'"><span>'+obj.frequentness+'</span></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ index +'].remarks" value="'+obj.remark+'"><span>'+obj.remark+'</span></td>' +
		'</tr>';
	}else if(page == 'healthExam'){
		str = '<tr id="Medicinal-cb-'+ index +'">' +
		'<td><input type="checkbox"  value="'+ index +'" ></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ index +'].drugName" value="'+obj.drugName+'"><span>'+obj.drugName+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ index +'].drugUsage" value="'+obj.useMethod+'"><span>'+obj.useMethod+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ index +'].drugDosage" value="'+obj.count+'"><span>'+obj.count+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ index +'].drugUnit" value="'+obj.dosageUnit+'"><span>'+obj.dosageUnit+'</span></td>'+
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ index +'].drugFreq" value="'+obj.frequentness+'"><span>'+obj.frequentness+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ index +'].drugUseTime" value="'+obj.drugUseTime+'"><span>'+obj.drugUseTime+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ index +'].drugCompliance" value="'+obj.compliance+'"><span>'+obj.complianceDes+'</span></td>' +	
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ index +'].remarks" value="'+obj.remark+'"><span>'+obj.remark+'</span></td>' +
		'</tr>';
	}
	
	
	parentDome.append(str);
}

//更新主要用药情况table内容
function updateMedicinal(obj, id, page) {
	var str='';
	// 高血压随访
	if(page=="hypertension"){
		str ='<td><input type="checkbox"  value="'+ obj.index +'" ><input type="hidden" name="phHypertensiondetailmedicines['+ obj.index +'].logID" value="'+obj.logID+'"/></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ obj.index +'].drugName" value="'+obj.drugName+'"><span>'+obj.drugName+'</span></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ obj.index +'].drugUsage" value="'+obj.useMethod+'"><span>'+obj.useMethod+'</span></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ obj.index +'].drugDosage" value="'+obj.count+'"><span>'+obj.count+'</span></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ obj.index +'].drugUnit" value="'+obj.dosageUnit+'"><span>'+obj.dosageUnit+'</span></td>'+
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ obj.index +'].drugFreq" value="'+obj.frequentness+'"><span>'+obj.frequentness+'</span></td>' +
		'<td><input type="hidden" name="phHypertensiondetailmedicines['+ obj.index +'].remarks" value="'+obj.remark+'"><span>'+obj.remark+'</span></td>';
	}else if(page == 'diabetes'){ // 
		str ='<td><input type="checkbox"  value="'+ obj.index +'" ><input type="hidden" name="phDiabetesdetailmedicines['+ obj.index +'].logID" value="'+obj.logID+'"/></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ obj.index +'].drugName" value="'+obj.drugName+'"><span>'+obj.drugName+'</span></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ obj.index +'].drugUsage" value="'+obj.useMethod+'"><span>'+obj.useMethod+'</span></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ obj.index +'].drugDosage" value="'+obj.count+'"><span>'+obj.count+'</span></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ obj.index +'].drugUnit" value="'+obj.dosageUnit+'"><span>'+obj.dosageUnit+'</span></td>'+
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ obj.index +'].drugFreq" value="'+obj.frequentness+'"><span>'+obj.frequentness+'</span></td>' +
		'<td><input type="hidden" name="phDiabetesdetailmedicines['+ obj.index +'].remarks" value="'+obj.remark+'"><span>'+obj.remark+'</span></td>';
	}else if(page == 'healthExam'){
		str ='<td><input type="checkbox"  value="'+ obj.index +'" ><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].logID" value="'+obj.logID+'"/></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].drugName" value="'+obj.drugName+'"><span>'+obj.drugName+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].drugUsage" value="'+obj.useMethod+'"><span>'+obj.useMethod+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].drugDosage" value="'+obj.count+'"><span>'+obj.count+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].drugUnit" value="'+obj.dosageUnit+'"><span>'+obj.dosageUnit+'</span></td>'+
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].drugFreq" value="'+obj.frequentness+'"><span>'+obj.frequentness+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].drugUseTime" value="'+obj.drugUseTime+'"><span>'+obj.drugUseTime+'</span></td>'+
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].drugCompliance" value="'+obj.compliance+'"><span>'+obj.complianceDes+'</span></td>'+
		'<td><input type="hidden" name="phHealthexamdetailmedicines['+ obj.index +'].remarks" value="'+obj.remark+'"><span>'+obj.remark+'</span></td>';
	}
	
	$("table#"+id+" tbody #Medicinal-cb-"+obj.index).html(str);
}

//拿到数据填充主要用药情况表单
function setMedicinal(layero, index, list, page) {
	// 获取弹出页面的外层div
	var p = layer.getChildFrame("#form-drugDetail", index);
	$(p).find("input[name='logID']").val($(list[0]).find("input[type='hidden']").val());
	// 获取选择的列的值
	var index = $(list[0]).find("input[type='checkbox']").val(),
		drugName = $(list[1]).find("span").html(),
		useMethod = $(list[2]).find("input").val(),
		isUseMethodOther = $(p).find("select[name='useMethod']>option[value='"+useMethod+"']").length <= 0,
		frequentness = $(list[5]).find("input").val(),
		isFrequentnessOther = $(p).find("select[name='frequentness']>option[value='"+frequentness+"']").length <= 0,
		count = $(list[3]).find("span").html(),
		dosageUnit = $(list[4]).find("input").val(),
		isDosageUnitOther = $(p).find("select[name='dosageUnit']>option[value='"+dosageUnit+"']").length <= 0;
	
	// 将值传给弹出框内的文本框
	$(p).find("input[name='index']").val(index);
	$(p).find("input[name='drugName']").val(drugName);
	if(isUseMethodOther){
		$(p).find("select[name='useMethod']").val(' ');
		$(p).find("#txt1").val(useMethod).show();
	}else {
		$(p).find("select[name='useMethod']").val(useMethod);
	}
	
	if(isFrequentnessOther){
		$(p).find("select[name='frequentness']").val(' ');
		$(p).find("#txt2").val(frequentness).show();
	}else {
		$(p).find("select[name='frequentness']").val(frequentness);
	}
	$(p).find("input[name='count']").val(count);
	
	if(isDosageUnitOther){
		$(p).find("select[name='dosageUnit']").val(' ');
		$(p).find("#txt3").val(dosageUnit).show();
	}else {
		$(p).find("select[name='dosageUnit']").val(dosageUnit);
	}
	// 健康体检页面 有服药依从性
	if(page == 'healthExam') {
		$(p).find("input[name='drugUseTime']").val($(list[6]).find("input").val());
		$(p).find("select[name='compliance']").val($(list[7]).find("input").val());
		$(p).find("textarea[name='remark']").val($(list[8]).find("span").html());
	}else {
		$(p).find("textarea[name='remark']").val($(list[6]).find("span").html());
	}
	
}

//打开修改主要用药情况页面
function editMedicinal(page) {
	var checkboxs = $("#Medicinal input[type='checkbox']:checked"),
		objTr;
	
	if(checkboxs.length <= 0) {
		layer.alert("请选择用药情况信息", {shade: 0,skin : 'skin1'});
		return;
	}
	if(checkboxs.length >1) {
		layer.alert("只能选择一条用药情况信息", {shade: 0,skin : 'skin1'});
		return;
	}
	objTr = $(checkboxs).parent("td").parent("tr").find("td");
	
	openPage('修改药物', 'editMedicinal',function(layero, index) {
		setMedicinal(layero, index, objTr, page)
	}, page);
	
}

//添加非免疫规划预防接种史
function addIPVH(obj, id) {
	var parentDome = $("table#"+id+" tbody");
	var index = parentDome.children('tr').last().find('input[type="checkbox"]').val();
		index = index?+index + 1: 0;
	
	var str = '<tr id="detailIPVH-cb-'+ index +'">' +
		'<td><input type="checkbox"  value="'+ index +'" ></td>' +
		'<td><input type="hidden" name="phHealthexamdetailnonimmunes['+ index +'].vaccinateName" value="'+obj.vaccineName+'"><span>'+obj.vaccineName+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailnonimmunes['+ index +'].vaccinateDate" value="'+obj.vaccineDate+'"><span>'+obj.vaccineDate+'</span></td>' +
		'<td><input type="hidden" name="phHealthexamdetailnonimmunes['+ index +'].institution" value="'+obj.vaccineOrganization+'"><span>'+obj.vaccineOrganization+'</span></td>' +
		'</tr>';
	parentDome.append(str);
}

//更新非免疫规划预防接种史table内容
function updateIPVH(obj, id) {
	var str ='<td><input type="checkbox"  value="'+ obj.index +'" ><input type="hidden" name="phHealthexamdetailnonimmunes['+ obj.index +'].logID" value="'+obj.logID+'"/></td>' +
	'<td><input type="hidden" name="phHealthexamdetailnonimmunes['+ obj.index +'].vaccinateName" value="'+obj.vaccineName+'"><span>'+obj.vaccineName+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailnonimmunes['+ obj.index +'].vaccinateDate" value="'+obj.vaccineDate+'"><span>'+obj.vaccineDate+'</span></td>' +
	'<td><input type="hidden" name="phHealthexamdetailnonimmunes['+ obj.index +'].institution" value="'+obj.vaccineOrganization+'"><span>'+obj.vaccineOrganization+'</span></td>';
	
	$("table#"+id+" tbody #detailIPVH-cb-"+obj.index).html(str);
}

//拿到数据填充非免疫规划预防接种史表单
function setIPVH(layero, index, list) {
	// 获取弹出页面的外层div
	var p = layer.getChildFrame("#form-vaccine", index);
	$(p).find("input[name='logID']").val($(list[0]).find("input[type='hidden']").val());
	$(p).find("input[name='index']").val($(list[0]).find("input[type='checkbox']").val());
	$(p).find("input[name='vaccineName']").val($(list[1]).find("span").html());
	$(p).find("input[name='vaccineDate']").val($(list[2]).find("span").html());
	$(p).find("input[name='vaccineOrganization']").val($(list[3]).find("span").html());
}

//打开修改非免疫规划预防接种史页面
function editIPVH() {
	var checkboxs = $("#detailIPVH input[type='checkbox']:checked"),
		objTr;
	
	if(checkboxs.length <= 0) {
		layer.alert("请选择非免疫规划预防接种史信息", {shade: 0,skin : 'skin1'});
		return;
	}
	if(checkboxs.length >1) {
		layer.alert("只能选择一条非免疫规划预防接种史信息", {shade: 0,skin : 'skin1'});
		return;
	}
	objTr = $(checkboxs).parent("td").parent("tr").find("td");
	
	openPage('修改非免疫规划预防接种史', 'editIPVH',function(layero, index) {
		setIPVH(layero, index, objTr);
	});
	
}

//计算体质指数 参数说明 
function calcBMI(heightName, weightName, bmiName, bmiDes,bmiErr) {
	var height = +$("input[name='"+heightName+"']").val(),
		weight = +$("input[name='"+weightName+"']").val(),
		bmi = $("input[name='"+bmiName+"']"),
		des = $("#" + bmiDes),
		err = $("#" + bmiErr),
		value;
	
	if(height != '' && weight != '') {
		value = decimal(weight/(height*height/10000), 1);
		
		if(value <18.5 ) {
			des.html("体重过低");
			des.css({'color': 'red'});
		}else if(value <= 23.9) {
			des.html("体重正常");
			des.css({'color': '#000'});
		}else if(value <= 26.9) {
			des.html("体重超重");
			des.css({'color': 'red'});
		}else {
			des.html("体重肥胖");
			des.css({'color': 'red'});
		}
		
		if(value <1000){
			err.html("");
		}
		bmi.val(value);
		
		$("#toggle").show();
	}else {
		bmi.val('');
		$("#toggle").hide();
	}
}

//num表示要四舍五入的数,v表示要保留的小数位数。  
function decimal(num,v)  
{  
    var vv = Math.pow(10,v);  
    return Math.round(num*vv)/vv;  
}  