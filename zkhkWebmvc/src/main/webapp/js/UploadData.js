//验证选择时间是否大于当前时间 2015-05-05由sz添加
function checkTime() {
	var d = new Date();
	// 取当前年月日，舍去时分秒
	// d = new Date(d.getFullYear() + "-" + (d.getMonth() + 1) + "-" +
	// d.getDate());
	var d2 = new Date(document.getElementById("startTime").value);

	if (d2 == "Invalid Date") {
		alert("非日期");
		return;
	}
	// getTime 从1970.1.1开始的毫秒数
	var n = d.getTime() - d2.getTime();

	if (n == 0) {
		return true;
	} else if (n > 0) {
		return true;
	} else {
		alert("不能大于当前日期");
		document.getElementById("startTime").value = "";
		return false;
	}
}

function checkTime1() {
	var d = new Date();
	// 取当前年月日，舍去时分秒
	// d = new Date(d.getFullYear() + "-" + (d.getMonth() + 1) + "-" +
	// d.getDate());
	var d2 = new Date(document.getElementById("startTime1").value);

	if (d2 == "Invalid Date") {
		alert("非日期");
		return;
	}
	// getTime 从1970.1.1开始的毫秒数
	var n = d.getTime() - d2.getTime();

	if (n == 0) {
		return true;
	} else if (n > 0) {
		return true;
	} else {
		alert("不能大于当前日期");
		document.getElementById("startTime1").value = "";
		return false;
	}
}

function checkTime2() {
	var d = new Date();
	// 取当前年月日，舍去时分秒
	// d = new Date(d.getFullYear() + "-" + (d.getMonth() + 1) + "-" +
	// d.getDate());
	var d2 = new Date(document.getElementById("startTime2").value);

	if (d2 == "Invalid Date") {
		alert("非日期");
		return;
	}
	// getTime 从1970.1.1开始的毫秒数
	var n = d.getTime() - d2.getTime();

	if (n == 0) {
		return true;
	} else if (n > 0) {
		return true;
	} else {
		alert("不能大于当前日期");
		document.getElementById("startTime2").value = "";
		return false;
	}
}

function checkTime3() {
	var d = new Date();
	// 取当前年月日，舍去时分秒
	// d = new Date(d.getFullYear() + "-" + (d.getMonth() + 1) + "-" +
	// d.getDate());
	var d2 = new Date(document.getElementById("startTime3").value);

	if (d2 == "Invalid Date") {
		alert("非日期");
		return;
	}
	// getTime 从1970.1.1开始的毫秒数
	var n = d.getTime() - d2.getTime();

	if (n == 0) {
		return true;
	} else if (n > 0) {
		return true;
	} else {
		alert("不能大于当前日期");
		document.getElementById("startTime3").value = "";
		return false;
	}
}

// 点击对比的时候判断所选择的checkbox是否超过5个
function checkCount() {
	var checkboxs = $("input[name='checkbox']:checked").length;
	if (checkboxs <= 0) {
		alert("请勾选需要对比的测量项");
		return false;
	} else if (checkboxs < 2) {
		alert("至少选择2次测量进行对比");
		return false;
	} else if (checkboxs > 5) {
		alert("最多只能选择5次测量进行对比");
		return false;
	} else {
		var s = '';
		$("input[name='checkbox']:checked").each(function() {
			s += $(this).val() + ',';
		});
		// window.location = "reportAction!showSanHeYiCompareUI?parameter="+s;
		window.open('reportAction!showSanHeYiCompareUI?parameter=' + s,
				'blank_', 'scrollbars=yes,resizable=no,width=900,height=400');
	}
}

// 点击左下角删除时进行的一些判断
function deleteInfo(memberId) {
	var checkboxs = $("input[name='checkbox']:checked").length;
	if (checkboxs <= 0) {
		alert("请勾选需要删除的测量项");
		return false;
	} else {
		if (confirm("确定要删除这些测量信息吗？")) {
			var s = '';
			$("input[name='checkbox']:checked").each(function() {
				s += $(this).val() + ',';
			});
			window.location = "reportAction!deleteInfoInXinDian?parameter=" + s
					+ "&memberId=" + memberId;
		} else {
			return false;
		}
	}
}

function isEmpty() {
	if ($("#startTime").val() == "" || $("#textfield").val() == "") {
		alert("信息不全，请填写！");
		return false;
	}
}
function isObsrEmpty() {
	var bsValue = $("#bsValue").val();
	if ($("startTime3").val() == "" || $("#timePeriod2").val() == ""
			|| $("#bsValue").val() == "") {
		alert("信息不全，请填写！");
		return false;
	}

	var re = /^(?=[\d.]{1,7})([1-9]\d{1,6}|\d)(\.\d{1,1})?$/;
	if (re.test(bsValue)) {
		if (bsValue < 0 || bsValue > 50) {
			alert("血糖测量范围为0~50，范围已超出，请重新输入！");
			return false;
		}
	} else {
		alert("格式错误，请重新输入！");
		return false;
	}
}

function isOsbpEmpty() {
	var dbp = +$("#dbp").val();
	var sbp = +$("#sbp").val();
	var pulseRate = $("#pulseRate").val();
	if ($("startTime2").val() == "" || $("#timePeriod1").val() == ""
			|| $("#sbp").val() == "" || $("#dbp").val() == ""
			|| $("#pulseRate").val() == "") {
		alert("信息不全，请填写！");
		return false;
	} else if (sbp <= 40 || sbp > 260) {
		alert("收缩压测量范围为40~260，范围已超出，请重新输入！");
		return false;
	} else if (dbp < 40 || dbp > 180) {
		alert("舒张压测量范围为40~180，范围已超出，请重新输入！");
		return false;
	} else if (pulseRate < 0 || pulseRate > 200) {
		alert("脉率测量范围为0~200，范围已超出，请重新输入！");
		return false;
	} else if (dbp >= sbp) {
		alert("舒张压必须小于收缩压的值，条件不符，请重新输入！");
		return false;
	}
}

function isSanheyiEmpty() {
	var spo = $("#spo").val();
	if ($("#startTime1").val() == "" || $("#textfield2").val() == ""
			|| $("#textfield3").val() == "" || $("#spo").val() == "") {
		alert("信息不全，请填写！");
		return false;
	} else if (spo < 95 || spo > 100) {
		alert("血氧饱和度测量范围为95~100，范围已超出，请重新输入！");
		return false;
	}
}

$(document)
		.ready(
				function() {
					// tab功能切换
					jQuery.jqtab = function(tabtit, tab_conbox, shijian) {
						var uploadShow = $("#uploadShow").val();

						$(tab_conbox).find("div.tab_conbox_item2").hide();
						if (uploadShow == "obsr") {
							$("#box4").addClass("thistab").show();
							$($(tabtit).find("li")[3]).addClass("thistab")
									.show();
						} else if (uploadShow == "osbp") {
							$("#box3").addClass("thistab").show();
							$($(tabtit).find("li")[2]).addClass("thistab")
									.show();
						} else if (uploadShow == "sanheyi") {
							$("#box2").addClass("thistab").show();
							$($(tabtit).find("li")[1]).addClass("thistab")
									.show();
						} else {
							$("#box1").addClass("thistab").show();
							$($(tabtit).find("li")[0]).addClass("thistab")
									.show();
						}

						// $(tab_conbox).find("div.tab_conbox_item2:first").show();
						$(tabtit).find("li").bind(
								shijian,
								function() {
									$(this).addClass("thistab").siblings("li")
											.removeClass("thistab");
									var activeindex = $(tabtit).find("li")
											.index(this);
									$(tab_conbox).children().eq(activeindex)
											.show().siblings().hide();
									return false;
								});
					};
					$.jqtab("#tab_title2", "#tab_conbox2", "click");

					// 验证血氧饱和度
					$("#spo").blur(function() {
						/*
						 * var re=/^(?=[\d.]{1,4})([1-9]\d{1,5}|\d)?$/; var
						 * isNum=re.test($("#spo").val()); if(!isNum){
						 * alert("必须为不超过4位的非负整数"); $("#spo").val(""); return
						 * false; }
						 */
						var spo = $("#spo").val();
						var startTime1 = $("#startTime1").val();
						var re = /^(?=[\d.]{1,4})([1-9]\d{1,5}|\d)?$/;
						if (re.test(spo)) {
							if (startTime1 == "" && spo == "") {
								return false;
							} else if (spo < 95 || spo > 100) {
								alert("血氧饱和度测量范围为95~100，范围已超出，请重新输入！");
								return false;
							}
						} else {
							if (spo == "") {
								alert("血氧饱和度值为空，请输入！");
								return false;
							} else {
								alert("格式不正确，请重新输入！");
								return false;
							}
						}
					});
					// 验证收缩压 舒张压 脉率

					$("#sbp").blur(
							function() {
								/*
								 * var re=/^(?=[\d.]{1,8})([1-9]\d{1,10}|\d)?$/;
								 * var isNum=re.test($("#sbp").val());
								 * if(!isNum){ alert("必须为不超过8位的非负整数");
								 * $("#sbp").val(""); return false; }
								 */

								var sbp = $("#sbp").val();
								var timePeriod1 = $("#timePeriod1").val();
								var startTime2 = $("#startTime2").val();
								var re = /^(?=[\d.]{1,8})([1-9]\d{1,10}|\d)?$/;
								if (re.test(sbp)) {
									if ((timePeriod1 == "" || startTime2 == "")
											&& sbp == "") {
										return false;
									} else if (sbp <= 40 || sbp > 260) {
										alert("收缩压测量范围为40~260，范围已超出，请重新输入！");
										return false;
									}
								} else {
									if (sbp == "") {
										alert("收缩压值为空，请输入！");
										return false;
									} else {
										alert("格式错误，请重新输入！");
										return false;
									}
								}
							});
					$("#dbp")
							.blur(
									function() {
										/*
										 * var
										 * re=/^(?=[\d.]{1,8})([1-9]\d{1,10}|\d)?$/;
										 * var isNum=re.test($("#dbp").val());
										 * if(!isNum){ alert("必须为不超过8位的非负整数");
										 * $("#dbp").val(""); return false; }
										 */

										var dbp = $("#dbp").val();
										var sbp = $("#sbp").val();
										var timePeriod1 = $("#timePeriod1")
												.val();
										var startTime2 = $("#startTime2").val();
										var re = /^(?=[\d.]{1,8})([1-9]\d{1,10}|\d)?$/;
										if (re.test(dbp)) {
											if ((timePeriod1 == ""
													|| startTime2 == "" || sbp == "")
													&& dbp == "") {
												return false;
											} else if (dbp < 40 || dbp > 180) {
												alert("舒张压测量范围为40~180，范围已超出，请重新输入！");
												return false;
											}
										} else {
											if (dbp == "") {
												alert("舒张压值为空，请输入！");
												return false;
											} else {
												alert("格式错误，请重新输入！");
												return false;
											}
										}
									});

					$("#pulseRate")
							.blur(
									function() {
										/*
										 * var
										 * re=/^(?=[\d.]{1,8})([1-9]\d{1,10}|\d)?$/;
										 * var
										 * isNum=re.test($("#pulseRate").val());
										 * if(!isNum){ alert("必须为不超过8位的非负整数");
										 * $("#pulseRate").val(""); return
										 * false; }
										 */

										var dbp = $("#dbp").val();
										var sbp = $("#sbp").val();
										var pulseRate = $("#pulseRate").val();
										var timePeriod1 = $("#timePeriod1")
												.val();
										var startTime2 = $("#startTime2").val();
										var re = /^(?=[\d.]{1,6})([1-9]\d{1,10}|\d)?$/;
										if (re.test(pulseRate)) {
											if ((timePeriod1 == ""
													|| startTime2 == ""
													|| sbp == "" || dbp == "")
													&& pulseRate == "") {
												return false;
											} else if (pulseRate < 0
													|| pulseRate > 200) {
												alert("脉率测量范围为0~200，范围已超出，请重新输入！");
												return false;
											}
										} else {
											if (pulseRate == "") {
												alert("脉率值为空，请输入！");
												return false;
											} else {
												alert("格式错误，请重新输入！");
												return false;
											}
										}
									});

					// 验证血糖
					$("#bsValue")
							.blur(
									function() {
										// var
										// re=/(^[1-9]\d{1,10}([0-9]*)$|^[0-9]$)(\.\d{1,1})?$/;
										/*
										 * var
										 * re=/^(?=[\d.]{1,7})([1-9]\d{1,6}|\d)(\.\d{1,1})?$/;
										 * var
										 * isNum=re.test($("#bsValue").val());
										 * if(!isNum){
										 * alert("必须为整数部分不超过7位数的数字，小数不得超过一位");
										 * $("#bsValue").val(""); return false; }
										 */
										var re = /^(?=[\d.]{1,7})([1-9]\d{1,6}|\d)(\.\d{1,1})?$/;
										var timePeriod2 = $("#timePeriod2")
												.val();
										var startTime3 = $("#startTime3").val();
										var bsValue = $("#bsValue").val();
										if (re.test(bsValue)) {
											if ((timePeriod2 == "" || startTime3 == "")
													&& bsValue == "") {
												return false;
											} else if (bsValue < 0
													|| bsValue > 25) {
												alert("血糖测量范围为0~25，范围已超出，请重新输入！");
												return false;
											}
										} else {
											if (bsValue == "") {
												alert("血糖值信息为空，请输入！");
												return false;
											} else {
												alert("格式错误，请重新输入！");
												return false;
											}
										}
									});
				});