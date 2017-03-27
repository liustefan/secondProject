//创建分类
function addquestionclass(){
	//alert($('#Questionnbut').css('display'))
	if(mainId != null)
	{
		jPrompt('输入分类名称:','','问题分类',function(r) {
	   		if( r ) {
	   			$.post(checkTypeUrl,{typeName:r},function(data){
					if('true'==data){
						alert("问题分类: "+r+" 已经存在！");
						}else{
							$.post(addQuerUrl,{mainId:mainId,typeName:r},function(data){
								if(data){
//									var typeIdtemp=JSON.parse(data);
//									typeId=typeIdtemp.typeId;
									alert("添加分类成功");
//									var addques=$('<div id="contentsDefault_'+typeId+'" class="contents_de">'+
//											'<div id="contentstop_1" class="contentstop">'+
//												'<input type="text" value="'+r+'" name="contentsDefault_0" id="contentsDefault_all" readonly="readonly">'+
//											'</div>'+
//											'<div id="contentstop_content_'+typeId+'">'+
//											'</div>'+
//											'</div>');	
//										addques.prependTo('.content'); 	 	
								}else{
									alert("添加分类失败！");
								}
				   			})
						}
	   			});
				
	   		}
	   		else{
	   			return;
	   		};
	    });
	}else
	{
		alert('您还没有保存试卷信息！');
		return;
	}
	}
//打开div层
function showBg(type){ 
	if($('#Questionnbut').css("display")=="none")
	{
		var bh = $(document).height(); 
		var bw = $(document).width(); 
		    $("#fullbg").css({ 
		    height:bh, 
		    width:bw, 
		    display:"block" 
		    }); 
		    $("#"+type+"").show(); 
    }else
	{
		alert('您还没有保存试卷信息！');
		return;
	}
} 
    //关闭灰色 jQuery 遮罩 
    function closeBg(type) { 
	    $("#fullbg,#"+type+"").hide(); 
	    $("#"+type+"").find(".add_tr").remove();
	    $(".label_add").css('display','block');
    } 
//根据返回的问题类型弹出相应的div层
function add_question(){
	var type=$('input[name=ques_type]:checked').val();
	closeBg('ques_type');
	seltype();
	switch(type){
			case "1": showBg('ques_type_1');break;
			case "2": showBg('ques_type_2');break;
			case "3": showBg('ques_type_3');break;
			case "4": showBg('ques_type_4');break;
			case "5": showBg('ques_type_5');break;
			default :alert("未知错误！");break;
		}
}
//返回jQuery对象所有匹配元素的标识信息数组
//每个元素形如：#id
function getTagsInfo($doms){
    return $doms.map(function(){
        return "#" + this.id;
    }).get();
}
function getTagsInfo_1($doms){
    return $doms.map(function(){
        return this.id;
    }).get();
}
//删除答案
function del_answer(del){
	$(del).parent().parent().remove();
	};
//添加会员信息函数
function addaccountinfo(){
	var docId=$('input[name=docId]');

}
//添加问题备选答案
function addAnswer(del){
	var leg=String(getTagsInfo($(del).parent().parent().prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
	var leh=leg.substring(leg.length-1,leg.length);
	var lengt=parseInt(leh)+1;//计算下一个答案编号
	var type=$('input[name=ques_type]:checked').val();
	if(lengt==9){
		$(del).css('display','none');
	}
	var addAn=$('<tr id="tr_answer_'+type+'_'+lengt+'" class="add_tr">'+
					'<td class="td_Answer">答案'+lengt+':<img src="../img/del.png" id="Issue_Answer_del"  onclick="del_answer(this)"></td>'+
					'<td class=""><input type="text" name="Issue_Answer_del_'+lengt+'" class="Issue_Answer_del_ipt"></td>'+
					'<td class="td_Issue3">标号：<input type="text" name="Issue_Answer_Grade_'+lengt+'" class="Issue_content_topic">'+
						' 计分:<input type="text" name="Issue_Answer_Scoring_'+lengt+'" class="Issue_content_topic"></td>'+
				'</tr>');
	addAn.insertBefore(''+getTagsInfo($(del).parent().parent())+'');
	};
//添加填空问题备选答案
function addAnswer_tk(del){
	var leg=String(getTagsInfo($(del).parent().parent().prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
	var leh=leg.substring(leg.length-1,leg.length);
	var lengt=parseInt(leh)+1;//计算下一个答案编号
	var type=$('input[name=ques_type]:checked').val();
	if(lengt==9){
		$(del).css({
			'display':'none'
		});
	}
	var addAn=$('<tr id="traddantype_'+type+'_'+lengt+'" id="add_tr">'+
		'<td class="td_Answer">计分'+lengt+':<img src="../img/del.png" id="Issue_Answer_del"  onclick="del_answer(this)"></td>'+
					'<td class="td_tinakong">'+
						'<select name="Issue_Answer_del_'+lengt+'" id="Issue_Answer_del_'+lengt+'" onchange="upsel(\'Issue_Answer_del_'+lengt+'\')">'+
							'<option value=">">大于</option>'+
							'<option value="<">小于</option>'+
							'<option value="=">等于</option>'+
							'<option value="_≤_≤">介于</option>'+
							'<option value="≥">大于等于</option>'+
							'<option value="≤">小于等于</option>'+
						'</select>'+
						'<label id="tk_label">&nbsp;</label><input type="text" name="Issue_Answer_ipt_'+lengt+'a" value="NaN" class="Issue_content_topic_b" hidden/><label  id="tk_label">&nbsp;答案:>&nbsp;</label>'+
						'<input type="text" name="Issue_Answer_ipt_'+lengt+'b" class="Issue_content_topic_a">'+
					'</td>'+
					'<td class="td_Issue3">'+
						'得分:<input type="text" name="Issue_Answer_Scoring_'+lengt+'" class="Issue_content_topic"></td>'+
	'</tr>');
	addAn.insertBefore(''+getTagsInfo($(del).parent().parent())+'');
	};
	//添加单选+填空备选答案
function addAnswer_dt(del){
	var leg=String(getTagsInfo($(del).parent().parent().prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
	var leh=leg.substring(leg.length-1,leg.length);
	var lengt=parseInt(leh)+1;//计算下一个答案编号
	var type=$('input[name=ques_type]:checked').val();
	if(lengt==9){
		$(del).css({
			'display':'none'
		});
	}
	var addAn=$('<tr id="tr_answer_'+type+'_'+lengt+'" class="add_tr">'+
					'<td class="td_Answer">答案'+lengt+':<img src="../img/del.png" id="Issue_Answer_del"  onclick="del_answer(this)"></td>'+
					'<td class=""><input type="text" name="Issue_Answer_del_'+lengt+'" class="Issue_Answer_del_ipt">是否填空：<input type="radio" value="Y" name="xztk_'+lengt+'"/>是<input type="radio" value="N" name="xztk_'+lengt+'" checked="checked"/>否</td>'+
					'<td class="td_Issue3">标号：<input type="text" name="Issue_Answer_Grade_'+lengt+'" class="Issue_content_topic">'+
						' 计分:<input type="text" name="Issue_Answer_Scoring_'+lengt+'" class="Issue_content_topic"></td>'+
				'</tr>');
	addAn.insertBefore(''+getTagsInfo($(del).parent().parent())+'');
	};
//ajaxb保存试卷
function addPsq(){
	
	var Questionnairename=$('input[name=Questionnairename]');
	var QuestionnaireAnswermode=$('input[name=QuestionnaireAnswermode]:checked');
	var isCheck=$('input[name=isCheck]:checked');
	var Questionnaireexplain=$('textarea[name=Questionnaireexplain]');
	var QuestionnaireInformation=$('textarea[name=QuestionnaireInformation]');
	var docId=$('input[name=docId]');
	var optId=$('select[name=optId]');
	var QuestionnaireAnswermodeNotChecked=$('input[name=QuestionnaireAnswermode]:not([checked])');
	var isCheckNotChecked=$('input[name=isCheck]:not([checked])');
	//alert($(Questionnaireexplain).val().length);
	if($(Questionnaireexplain).val().length>100){
		//alert(11);
		$('#Questionnaireexplain_msg').text("问卷说明内容长度不能大于100个文字!");
		return;
	}
	if($(QuestionnaireInformation).val().length>1000){
		//alert(11);
		$('#QuestionnaireInformation_msg').text("问卷信息内容长度不能大于1000个文字!");
		return;
	}
	
	if($('#Questionnairename').val()=="")
	{
		$('#Questionnairename').css("border-color","#ccc");
		$('#Questionnairename').next("span").text("问卷名称不能为空");
		$('#Questionnairename').focus();
		return;
	}
	$.post(checkQuesUrl,{questionName:Questionnairename.val()},function(data){
				if('true'==data){
					$('#Questionnairename').css("border-color","#ccc");
					$('#Questionnairename').next("span").text("问卷名称已存在");
					$('#Questionnairename').focus();
					return false;
					}else{
						  $.post(addPSQUrl,{docId:docId.val(),
		questionName:Questionnairename.val(),replyMethod:QuestionnaireAnswermode.val(),chTag:isCheck.val(),
		questionIntro:Questionnaireexplain.val(),questionInfo:QuestionnaireInformation.val(),optId:optId.val()},function(data){
			if(data){
				Questionnairename.css({"readonly":true,
										"background":"#FFF",
										"border":"0px"});
				Questionnairename.attr("readonly",true);
				
				QuestionnaireAnswermode.css({"readonly":true,
										"background":"#FFF",
										"border":"0px"});
				QuestionnaireAnswermode.attr("readonly",true);	
									
				isCheck.css({"readonly":true,
										"background":"#FFF",
										"border":"0px"});
				isCheck.attr("readonly",true);							
				Questionnaireexplain.css({"readonly":true,
										"background":"#FFF",
										"border":"0px",
										"overflow-y": "scroll"});
				Questionnaireexplain.attr("readonly",true);	
											
				QuestionnaireInformation.css({"readonly":true,
										"background":"#FFF",
										"border":"0px",
										"overflow-y": "scroll"});
				QuestionnaireInformation.attr("readonly",true);		
			    
				QuestionnaireAnswermode.attr("disabled","disabled"); 
				isCheck.attr("disabled","disabled"); 
				QuestionnaireAnswermodeNotChecked.attr("disabled","disabled"); 
				isCheckNotChecked.attr("disabled","disabled"); 
				optId.attr("disabled","disabled");  
				var mainIdtemp=JSON.parse(data);
				if(mainIdtemp.mainId){
					mainId=mainIdtemp.mainId;
					$("#Questionnbut").css('display','none');
					alert("保存成功！");
				}else{
					alert('保存失败');
				}
					
//				$('#Questionnbut').css({
//					'display':'none',
//				})
			}else{
				alert("未知错误！");
			}
	})

					}
			});
}
//查找任务分类
function seltype(){
	var seltype=$('select[name=typeId]');
	$.post(selTypeUrl,{mainId:mainId},function(data){
		if(data){ 
//alert(data);
			var typeall=JSON.parse(data);	
			seltype.empty();	
			$.each(typeall,function(i,item){		
				$.each(item,function(k,v){
					seltype.append("<option value='"+v.typeId+"'>"+v.typeName+"</option>"); 	
				});
			});
			$('input[name=mainId]').val(mainId);
		}else
		{
			alert('查询章节失败!');
//			var typeall=JSON.parse(data);	
//			seltype.empty();	
//			$.each(typeall,function(i,item){		
//				$.each(item,function(k,v){
//					seltype.append("<option value='+"-1"+'>+"无分类问题"+</option>"); 	
//				});
//			});
//			$('input[name=mainId]').val(mainId);
		}

	})
	
}
//保存问题，同时显示在页面
function addQuestion(upl){
	
	if($('#'+upl+'').find("textarea[name=proDesc]").val()){
		
		var parent = $("#"+upl);
		var reg1 = /^[0-9]*$/;
		var reg = /^[0-9]+([.][0-9]{1}){0,1}$/;
		var answers = [];
		var answerGrade = [];
		for(var i = 1;i < 10;i ++){
			var issueAnswerDel = 'uploadForm_33' == upl ? issueAnswerDel = "Issue_Answer_ipt_"+i+"b" : "Issue_Answer_del_"+i;
			var issueAnswerScoring = "Issue_Answer_Scoring_"+i;
			var issueAnswerGrade = "Issue_Answer_Grade_"+i;
			var issueAnswerDelA = "";
			var issueAnswerScoringA = "";
			var issueAnswerGradeA = "";
			
			issueAnswerDelA = $('input[name='+ issueAnswerDel +']', parent);
			issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']', parent);
			issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']', parent);
			
			if(issueAnswerDelA.val() != undefined){
				if(issueAnswerDelA.val() == ""){
					if('uploadForm_33' == upl){
						alert("请输入计分"+i+"的答案内容");
					}else{
						alert("请输入答案"+i+"的答案内容");
					}
					return false;
				}else{
					if('uploadForm_33' == upl){
						 if(!reg1.test(issueAnswerDelA.val())){
							 alert("计分"+i+"的答案不是数字，请重新输入计分"+i+"的答案");
							 return false;
						  }
					}
					if(answers.indexOf(issueAnswerDelA.val()) >= 0 ){
						 alert("答案"+i+"的答案内容重复");
						 return false;
					}else{
						answers.push(issueAnswerDelA.val());
					}
				}
			}else{
				break;
			}
			if(issueAnswerGradeA.val() != undefined){
				if(issueAnswerGradeA.val().trim().length==0){
					alert("请输入答案"+i+"的标号");
					return false;
				}else{
					if(answerGrade.indexOf(issueAnswerGradeA.val()) >= 0 ){
						 alert("答案"+i+"的标号重复");
						 return false;
					}else{
						answerGrade.push(issueAnswerGradeA.val());
					}
				}
			}else if('uploadForm_33' != upl){
				break;
			}
			
			if(issueAnswerScoringA.val() != undefined){
				if(issueAnswerScoringA.val() == ""){
					if('uploadForm_33' == upl){
						alert("请输入计分"+i+"的得分情况");
					}else{
						alert("请输入答案"+i+"的计分");
					}
					return false;
				}else{
					  if(!reg.test(issueAnswerScoringA.val())){
						  if('uploadForm_33' == upl){
								alert("计分"+i+"的得分不是数字或者小数，请重新输入计分"+i+"的得分");
							}else{
								alert("答案"+i+"的计分不是数字或者小数，请重新输入答案"+i+"的计分");
							}
						  return false;
					  }
				}
			}else{
				break;
			}
			
			
		}
		
		$('#'+upl+'').ajaxForm({
			dataType: 'json',
			success:function(data){
				var chooses="";
				var greaters="";
				var relation="";
				var token="";
				var Validate="";
								if(data){
									switch(data.choose){
										case '1':chooses="单选";break;
										case '2':chooses="多选";break;
										case '3':chooses="填空";break;
										case '4':chooses="单选+填空";break;
										case '5':chooses="多选+填空";break;
										default :alert("未知类型！");break;
									}
									switch(data.relation){
										case 0:relation="不与";break;
										case 1:relation="与";break;
										default :alert("未知类型1！");break;
									}
									switch(data.isValidate){
										case '1':Validate="有效";break;
										default :Validate='无效';break;
									}
//									alert($('#contentsDefault_'+data.flag+'').find('#contentsDefault_all').val()==undefined);
									if(data.flag != '0'){
										if(($('#contentsDefault_'+data.flag+'').find('#contentsDefault_all').val())==undefined){
		//									alert(data.flag);
											var addques=$('<div id="contentsDefault_'+data.flag+'" class="contents_de">'+
													'<div id="contentstop_1" class="contentstop">'+
														'<input type="text" value="'+data.typeName+'" name="contentsDefault_0" id="contentsDefault_all" readonly="readonly">'+
													'</div>'+
													'<div id="contentstop_content_'+data.flag+'">'+
													'</div>'+
													'</div>');	
												addques.prependTo('.content'); 	 	
										}
									}
									var addAn=$('<table class="sel_table" cellspacing="0" cellpadding="0">'+
												'<tr class="title_count">'+
													'<td align="right">问题内容：</td>'+
													'<td colspan="2">No.'+data.lineNum+'-'+data.questionName+'</td>'+
												'</tr>'+
												'<tr id=sel_table_tr_'+data.questionId+'>'+
													'<td align="right">问题类型：</td>'+
													'<td class="sel_table_td_price">'+chooses+'</td>'+
													'<td>问题冲突：'+relation+'&nbsp;&nbsp;&nbsp;问题&nbsp;&nbsp;&nbsp;'+data.withQuestionNum+'&nbsp;&nbsp;&nbsp;答案&nbsp;&nbsp;&nbsp;'+data.withAnswerNum+'&nbsp;&nbsp;&nbsp;同时出现</td>'+
												'</tr>'+
											'</table>');
									var addAn_1=$('<table class="sel_table" cellspacing="0" cellpadding="0">'+
												'<tr class="title_count">'+
													'<td align="right">问题内容：</td>'+
													'<td colspan="2">No.'+data.lineNum+'-'+data.questionName+'</td>'+
												'</tr>'+
												'<tr>'+
													'<td align="right">问题类型：</td>'+
													'<td class="sel_table_td_price">'+chooses+'</td>'+
													'<td>问题冲突：'+relation+'&nbsp;&nbsp;&nbsp;问题&nbsp;&nbsp;&nbsp;'+data.withQuestionNum+'&nbsp;&nbsp;&nbsp;答案&nbsp;&nbsp;&nbsp;'+data.withAnswerNum+'&nbsp;&nbsp;&nbsp;同时出现</td>'+
												'</tr>'+
												'<tr id=sel_table_tr_'+data.questionId+'>'+
													'<td>'+Validate+'</td>'+
													'<td>输入答案&nbsp;≥&nbsp;'+data.inputAnswer+''+
														'输入答案&nbsp;≤&nbsp;'+data.outputAnswer+'</td>'+
													'<td></td></tr>'+
											'</table>');
									if(data.flag=='0'){
										if(data.choose==3){
											addAn_1.prependTo($('#contentstop_content'));
										}else
										{
											addAn.prependTo($('#contentstop_content'));
										}
										
									}else
									{
										if(data.choose==3){
//											alert(data.flag);
											addAn_1.prependTo($('#contentstop_content_'+data.flag+''));
										}else
										{
											addAn.prependTo($('#contentstop_content_'+data.flag+''));
										}
									}
									$.each(data.answer,function(i,item){
										switch(data.choose){
										case '1':   var addAntd=$('<tr>'+
														'<td class="sel_table_td">答案'+item.questionCount+':</td>'+
														'<td>&nbsp;&nbsp;'+item.description+'</td>'+
														'<td>标号:&nbsp;&nbsp;&nbsp;'+item.mark+'&nbsp;&nbsp;&nbsp;计分:&nbsp;&nbsp;&nbsp;'+item.score+'</td>'+
														'</tr>');
														addAntd.insertAfter($('#sel_table_tr_'+data.questionId+''));break;
										case '2':   var addAntd=$('<tr>'+
														'<td class="sel_table_td">答案'+item.questionCount+':</td>'+
														'<td class="sel_table_td_price">&nbsp;&nbsp;'+item.description+'</td>'+
														'<td>标号:&nbsp;&nbsp;&nbsp;'+item.mark+'&nbsp;&nbsp;&nbsp;计分:&nbsp;&nbsp;&nbsp;'+item.score+'</td>'+
														'</tr>');
														addAntd.insertAfter($('#sel_table_tr_'+data.questionId+''));break;
										case '3':   if(item.greater=='NaN')
													{
														greaters="";
													}else{
														greaters=item.greater;
													}
													var addAntd=$('</tr><tr>'+
														'<td class="sel_table_td">计分'+item.questionCount+':</td>'+
														'<td>&nbsp;答案&nbsp;&nbsp;&nbsp;'+greaters+item.temp+'&nbsp;'+item.small+'</td>'+
														'<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;得分:&nbsp;&nbsp;&nbsp;'+item.defen+'</td>'+
														'</tr>');
													addAntd.insertAfter($('#sel_table_tr_'+data.questionId+''));break;
										case '4':if(item.isValidate=="Y")
												{
													token="需要填空";
												}else
												{
													token="不需要填空";
												}
													var addAntd=$('<tr>'+
														'<td class="sel_table_td">答案'+item.questionCount+':</td>'+
														'<td>&nbsp;&nbsp;'+item.description+'----'+token+'</td>'+
														'<td>标号:&nbsp;&nbsp;&nbsp;'+item.mark+'&nbsp;&nbsp;&nbsp;计分:&nbsp;&nbsp;&nbsp;'+item.score+'</td>'+
														'</tr>');
														addAntd.insertAfter($('#sel_table_tr_'+data.questionId+''));break;
										case '5':
												if(item.isValidate=="Y")
												{
													token="需要填空";
												}else
												{
													token="不需要填空";
												}
													var addAntd=$('<tr>'+
														'<td class="sel_table_td">答案'+item.questionCount+':</td>'+
														'<td>&nbsp;&nbsp;'+item.description+'----'+token+'</td>'+
														'<td>标号:&nbsp;&nbsp;&nbsp;'+item.mark+'&nbsp;&nbsp;&nbsp;计分:&nbsp;&nbsp;&nbsp;'+item.score+'</td>'+
														'</tr>');
														addAntd.insertAfter($('#sel_table_tr_'+data.questionId+''));break;
										default :alert("未知类型！");break;
									}
									});
									$('#'+upl+'').find(".ipnutcontent,.Issue_Answer_del_ipt,.Issue_content_topic,.Issue_content_topic_a,.Issue_content_topic_b").attr("value","");
									var cols=getTagsInfo_1($('#'+upl+'').find("div").slice(0, 1));
									closeBg(cols);	
								}else
								{
									alert('未知错误！');
								}
							}
		});
	}else{
		alert("问题标题不能为空");
		return false;
	}
}
//动态改变填空的样式
function upsel(upselect){
	var addup=$('#'+upselect+'');
	var values=$('#'+upselect+'').val();
	var num=upselect.substring(upselect.length-1,upselect.length);
	var lab=$('<label id="tk_label">&nbsp;</label><input type="hidden" name="Issue_Answer_ipt_'+num+'a" value="NaN" class="Issue_content_topic_b" /><label id="tk_label">&nbsp;答案：'+values+'&nbsp;</label><input type="text" name="Issue_Answer_ipt_'+num+'b" class="Issue_content_topic_a">');
	var labjy=$('<label id="tk_label">&nbsp;</label><input type="text" name="Issue_Answer_ipt_'+num+'a" class="Issue_content_topic_b"><label id="tk_label"> ≤ 答案 ≤ </label><input type="text" name="Issue_Answer_ipt_'+num+'b" class="Issue_content_topic_b">');
	switch(values){
			case ">":addup.parent().find("label,input").remove();lab.insertAfter(addup);break;
			case "<":addup.parent().find("label,input").remove();lab.insertAfter(addup);break;
			case "=": addup.parent().find("label,input").remove();lab.insertAfter(addup);break;
			case "_≤_≤": addup.parent().find("label,input").remove();labjy.insertAfter(addup);break;
			case "≥":addup.parent().find("label,input").remove(); lab.insertAfter(addup);break;
			case "≤":addup.parent().find("label,input").remove(); lab.insertAfter(addup);break;
			default :alert("未知错误！");break;
		}
}