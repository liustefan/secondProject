//创建分类
function addquestionclass(){
		jPrompt('输入分类名称:','','问题分类',function(r) {
	   		if( r ) {
	   			$.post(checkTypeUrl,{typeName:r},function(data){
					if('true'==data){
						alert("问题分类: "+r+" 已经存在！");
						}else{
							$.post(addQuerUrl,{mainId:mainId,typeName:r},function(data){
								if(data){
									alert("添加分类成功");
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
}

//点击修改弹出对应的修改问题界面
function updateThisAnswerInfo(qustid,problemid,ansType) {
	seltype();
	setOriginalValue(qustid,problemid,ansType);
	switch(ansType){
			case "1": showBg('ques_type_1');break;
			case "2": showBg('ques_type_2');break;
			case "3": showBg('ques_type_3');break;
			case "4": showBg('ques_type_4');break;
			case "5": showBg('ques_type_5');break;
			default :alert("未知错误！");break;
	}
}

function tocheckname() 
{ 
	var QuestionnairenameValue= $('#Questionnairename').val();
    var qustnameOriginalValue = $('input[name=qustnameOriginalValue]').val();
    if(qustnameOriginalValue != QuestionnairenameValue){
    	$.ajax({ 
    		type:"POST", 
    		cache:false, 
    		url : checkQuesUrl, 
    		dataType : "text", 
    		data:{"questionName":QuestionnairenameValue}, 
    		async:false, 
    		success : function(data){
    			if('true'==data){
    				$('#qustnameValidate').css("border-color","#ccc");
    				$('#qustnameValidate').text("问卷名称已存在");
    				$('#qustnameValidate').focus();
    			}else{
    				$('#qustnameValidate').text("");
    			}
    		} 
    	});
    }else{
    	$('#qustnameValidate').text("");
    }
 
} 


//关闭灰色 jQuery 遮罩 
function closeBg(type) { 
	 $("#fullbg,#"+type+"").hide(); 
	 $("#"+type+"").find(".add_tr").remove();
	 $(".label_add").css('display','block');
}	 
    
function showBg(type){ 
		var bh = $(document).height(); 
		var bw = $(document).width(); 
		    $("#fullbg").css({ 
		    height:bh, 
		    width:bw, 
		    display:"block" 
		    }); 
		 $("#"+type+"").show(); 
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

	});
	
}

//返回jQuery对象所有匹配元素的标识信息数组
//每个元素形如：#id
function getTagsInfo($doms){
  return $doms.map(function(){
      return "#" + this.id;
  }).get();
}

//删除答案
function del_answer(del){
	$(del).parent().parent().remove();
};

//根据返回的问题类型弹出相应的div层
function add_question(qustid){
	var type=$('input[name=ques_type]:checked').val();
	closeBg('ques_type');
	$('input[name=qustid]').val(qustid);
	seltype();
	switch(type){
			case "1": showBg('ques_type_11');break;
			case "2": showBg('ques_type_22');break;
			case "3": showBg('ques_type_33');break;
			case "4": showBg('ques_type_44');break;
			case "5": showBg('ques_type_55');break;
			default :alert("未知错误！");break;
		}
}


//取出当前问题的答案信息赋值到修改问题界面
function setOriginalValue(qustid,problemid,ansType) {
	$('input[name=qustid]').val(qustid);
	$('input[name=problemid]').val(problemid);
	$('input[name=ansType]').val(ansType);
	$.post(setOriginalValueUrl,{qustid:qustid,problemid:problemid,ansType:ansType},function(data){
		if(data){ 
			$.each(data.answer,function(i,item){
				var issueAnswerDel = "Issue_Answer_del_"+(i+1);
				var issueAnswerGrade = "Issue_Answer_Grade_"+(i+1); 
				var issueAnswerScoring = "Issue_Answer_Scoring_"+(i+1);
				var parent = $('#ques_type_'+ansType);
				switch(data.choose){
				  case '1':
					  if(i > 1){
							var leg=String(getTagsInfo($('#traddan_add').prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
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
							addAn.insertBefore(''+getTagsInfo($('#traddan_add'))+'');
						}
					  
						var issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(0)', parent);
						var issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(0)', parent);
						var issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(0)', parent);
						
						//$('select[name=typeId ]:eq(0)').attr("value",data.typeName);
						$('select[name=typeId ]:eq(0)', parent).val(data.flag);
						//$('select[name=relation ]:eq(0)').attr("value",data.relation);
						$('select[name=relation ]:eq(0)', parent).val(data.relation);
						
						$('textarea[name=proDesc ]:eq(0)', parent).val(data.questionName);
						$('input[name=withQuestionNum]:eq(0)', parent).val(data.withQuestionNum);
						$('input[name=withAnswerNum]:eq(0)', parent).val(data.withAnswerNum);
						
						if(issueAnswerDelA.val() != undefined){
							$('input[name='+ issueAnswerDel +']:eq(0)', parent).val(item.description);
						}
						if(issueAnswerGradeA.val() != undefined){
							$('input[name='+ issueAnswerGrade +']:eq(0)', parent).val(item.mark);
						}
						if(issueAnswerScoringA.val() != undefined){
							$('input[name='+ issueAnswerScoring +']:eq(0)', parent).val(item.score);
						}
						break;
						
				  case '2':
					  if(i > 1){
							var leg=String(getTagsInfo($('#traddan_add_2').prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
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
							addAn.insertBefore(''+getTagsInfo($('#traddan_add_2'))+'');
						}
					  
					    var issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(1)');
						var issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(1)');
						var issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(1)');
						
						//$('select[name=typeId ]:eq(0)').attr("value",data.typeName);
						$('select[name=typeId ]:eq(1)').val(data.flag);
						//$('select[name=relation ]:eq(0)').attr("value",data.relation);
						$('select[name=relation ]:eq(1)').val(data.relation);
						
						$('textarea[name=proDesc ]:eq(1)').val(data.questionName);
						$('input[name=withQuestionNum]:eq(1)').val(data.withQuestionNum);
						$('input[name=withAnswerNum]:eq(1)').val(data.withAnswerNum);
						
						if(issueAnswerDelA.val() != undefined){
							$('input[name='+ issueAnswerDel +']:eq(1)').val(item.description);
						}else{
							issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(0)'); 
							if(issueAnswerDelA.val() != undefined){
								$('input[name='+ issueAnswerDel +']:eq(0)').val(item.description);
							}
						}
						if(issueAnswerGradeA.val() != undefined){
							$('input[name='+ issueAnswerGrade +']:eq(1)').val(item.mark);
						}else{
							issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(0)'); 
							if(issueAnswerGradeA.val() != undefined){
								$('input[name='+ issueAnswerGrade +']:eq(0)').val(item.mark);
							}
						}
						if(issueAnswerScoringA.val() != undefined){
							$('input[name='+ issueAnswerScoring +']:eq(1)').val(item.score);
						}else{
							issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(0)');
							if(issueAnswerScoringA.val() != undefined){
								$('input[name='+ issueAnswerScoring +']:eq(0)').val(item.score);
							}
						}
					  
					  break;
				  
				  case '3':
					    var issueAnswerDelB = "Issue_Answer_ipt_"+(i+1)+"b";
					    var issueAnswerDelA = $('input[name='+ issueAnswerDelB +']:eq(0)');
					    var issueAnswerDelForSelect = $('select[name='+ issueAnswerDel +']:eq(0)');
						var issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(2)');
						
					  if(i > 1 && issueAnswerDelA.val() == undefined){
							var leg=String(getTagsInfo($('#traddan_add_3').prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
							var leh=leg.substring(leg.length-1,leg.length);
							var lengt=parseInt(leh)+1;//计算下一个答案编号
							var type=$('input[name=ques_type]:checked').val();
							if(lengt==9){
								$(del).css('display','none');
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
							addAn.insertBefore(''+getTagsInfo($('#traddan_add_3'))+'');
						}
						
						//$('select[name=typeId ]:eq(0)').attr("value",data.typeName);
						$('select[name=typeId ]:eq(2)').val(data.flag);
						//$('select[name=relation ]:eq(0)').attr("value",data.relation);
						$('select[name=relation ]:eq(2)').val(data.relation);
						//$('checkbox[name=isValidate ]:eq(0)').val(data.isValidate);
						if(data.isValidate == 1){
							$('input[name=isValidate ]:eq(0)').attr("checked",'true');
						}
						$('textarea[name=proDesc ]:eq(2)').val(data.questionName);
						$('input[name=withQuestionNum]:eq(2)').val(data.withQuestionNum);
						$('input[name=withAnswerNum]:eq(2)').val(data.withAnswerNum);
						
						$('input[name=inputAnswer]:eq(0)').val(data.inputAnswer);
						$('input[name=outputAnswer]:eq(0)').val(data.outputAnswer);
						
						if(item.temp == "大于"){
							$('select[name='+ issueAnswerDel +']:eq(0)').val(">");
						}else if(item.temp == "小于"){
							$('select[name='+ issueAnswerDel +']:eq(0)').val("<");
						}else if(item.temp == "等于"){
							$('select[name='+ issueAnswerDel +']:eq(0)').val("=");
						}else if(item.temp == "介于"){
							$('select[name='+ issueAnswerDel +']:eq(0)').val("_≤_≤");
						}else if(item.temp == "大于等于"){
							$('select[name='+ issueAnswerDel +']:eq(0)').val("≥");
						}else if(item.temp == "小于等于"){
							$('select[name='+ issueAnswerDel +']:eq(0)').val("≤");
						}
						
						upsel(issueAnswerDel);
						
						$('input[name='+ issueAnswerDelB +']:eq(0)').val(item.small);
						
						if(issueAnswerScoringA.val() != undefined){
							$('input[name='+ issueAnswerScoring +']:eq(2)').val(item.defen);
						}else{
							issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(1)');
							if(issueAnswerScoringA.val() != undefined){
								$('input[name='+ issueAnswerScoring +']:eq(1)').val(item.defen);
							}else{
								issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(0)'); 
								if(issueAnswerScoringA.val() != undefined){
									$('input[name='+ issueAnswerScoring +']:eq(0)').val(item.defen);
								}
							}
						}
					  
					  break;
				  
				  case '4':
					  if(i > 1){
							var leg=String(getTagsInfo($('#traddan_add_4').prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
							var leh=leg.substring(leg.length-1,leg.length);
							var lengt=parseInt(leh)+1;//计算下一个答案编号
							var type=$('input[name=ques_type]:checked').val();
							if(lengt==9){
								$(del).css('display','none');
							}
							var addAn=$('<tr id="tr_answer_'+type+'_'+lengt+'" class="add_tr">'+
									'<td class="td_Answer">答案'+lengt+':<img src="../img/del.png" id="Issue_Answer_del"  onclick="del_answer(this)"></td>'+
									'<td class=""><input type="text" name="Issue_Answer_del_'+lengt+'" class="Issue_Answer_del_ipt">是否填空：<input type="radio" value="Y" name="xztk_'+lengt+'"/>是<input type="radio" value="N" name="xztk_'+lengt+'" checked="checked"/>否</td>'+
									'<td class="td_Issue3">标号：<input type="text" name="Issue_Answer_Grade_'+lengt+'" class="Issue_content_topic">'+
										' 计分:<input type="text" name="Issue_Answer_Scoring_'+lengt+'" class="Issue_content_topic"></td>'+
								'</tr>');
							addAn.insertBefore(''+getTagsInfo($('#traddan_add_4'))+'');
						}
					  
					    var xztk = "xztk_"+(i+1);
					    var issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(2)');
						var issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(2)');
						var issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(3)');
						
						//$('select[name=typeId ]:eq(0)').attr("value",data.typeName);
						$('select[name=typeId ]:eq(3)').val(data.flag);
						//$('select[name=relation ]:eq(0)').attr("value",data.relation);
						$('select[name=relation ]:eq(3)').val(data.relation);
						
						$('textarea[name=proDesc ]:eq(3)').val(data.questionName);
						$('input[name=withQuestionNum]:eq(3)').val(data.withQuestionNum);
						$('input[name=withAnswerNum]:eq(3)').val(data.withAnswerNum);
						
						if(item.isValidate == "Y"){
							$('input[name='+ xztk +' ]:eq(0)').attr("checked",'true');
						}
						
						if(issueAnswerDelA.val() != undefined){
							$('input[name='+ issueAnswerDel +']:eq(2)').val(item.description);
						}else{
							issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(1)'); 
							if(issueAnswerDelA.val() != undefined){
								$('input[name='+ issueAnswerDel +']:eq(1)').val(item.description);
							}else{
								issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(0)'); 
								if(issueAnswerDelA.val() != undefined){
									$('input[name='+ issueAnswerDel +']:eq(0)').val(item.description);
								}
							}
						}
						if(issueAnswerGradeA.val() != undefined){
							$('input[name='+ issueAnswerGrade +']:eq(2)').val(item.mark);
						}else{
							issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(1)'); 
							if(issueAnswerGradeA.val() != undefined){
								$('input[name='+ issueAnswerGrade +']:eq(1)').val(item.mark);
							}else{
								issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(0)'); 
								if(issueAnswerGradeA.val() != undefined){
									$('input[name='+ issueAnswerGrade +']:eq(0)').val(item.mark);
								}
							}
						}
						if(issueAnswerScoringA.val() != undefined){
							$('input[name='+ issueAnswerScoring +']:eq(3)').val(item.score);
						}else{
							issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(2)');
							if(issueAnswerScoringA.val() != undefined){
								$('input[name='+ issueAnswerScoring +']:eq(2)').val(item.score);
							}else{
								issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(1)');
								if(issueAnswerScoringA.val() != undefined){
									$('input[name='+ issueAnswerScoring +']:eq(1)').val(item.score);
								}else{
									issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(0)'); 
									if(issueAnswerScoringA.val() != undefined){
										$('input[name='+ issueAnswerScoring +']:eq(0)').val(item.score);
									}
								}
							}
						}
					  break;
				  
				  case '5':
					  if(i > 1){
							var leg=String(getTagsInfo($('#traddan_add_5').prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
							var leh=leg.substring(leg.length-1,leg.length);
							var lengt=parseInt(leh)+1;//计算下一个答案编号
							var type=$('input[name=ques_type]:checked').val();
							if(lengt==9){
								$(del).css('display','none');
							}
							var addAn=$('<tr id="tr_answer_'+type+'_'+lengt+'" class="add_tr">'+
									'<td class="td_Answer">答案'+lengt+':<img src="../img/del.png" id="Issue_Answer_del"  onclick="del_answer(this)"></td>'+
									'<td class=""><input type="text" name="Issue_Answer_del_'+lengt+'" class="Issue_Answer_del_ipt">是否填空：<input type="radio" value="Y" name="xztk_'+lengt+'"/>是<input type="radio" value="N" name="xztk_'+lengt+'" checked="checked"/>否</td>'+
									'<td class="td_Issue3">标号：<input type="text" name="Issue_Answer_Grade_'+lengt+'" class="Issue_content_topic">'+
										' 计分:<input type="text" name="Issue_Answer_Scoring_'+lengt+'" class="Issue_content_topic"></td>'+
								'</tr>');
							addAn.insertBefore(''+getTagsInfo($('#traddan_add_5'))+'');
						}
					  
					    var xztk = "xztk_"+(i+1);
					    var xztkA = $('input[name='+ xztk +' ]:eq(2)');
					    var issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(3)');
						var issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(3)');
						var issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(4)');
						
						//$('select[name=typeId ]:eq(0)').attr("value",data.typeName);
						$('select[name=typeId ]:eq(4)').val(data.flag);
						//$('select[name=relation ]:eq(0)').attr("value",data.relation);
						$('select[name=relation ]:eq(4)').val(data.relation);
						
						$('textarea[name=proDesc ]:eq(4)').val(data.questionName);
						$('input[name=withQuestionNum]:eq(4)').val(data.withQuestionNum);
						$('input[name=withAnswerNum]:eq(4)').val(data.withAnswerNum);
						
						if(xztkA.val() != undefined){
							if(item.isValidate == "Y"){
								$('input[name='+ xztk +' ]:eq(2)').attr("checked",'true');
							}
						}else{
							xztkA = $('input[name='+ xztk +' ]:eq(0)');
							if(xztkA.val() != undefined){
								if(item.isValidate == "Y"){
									$('input[name='+ xztk +' ]:eq(0)').attr("checked",'true');
								}
							}
						}
						
						if(issueAnswerDelA.val() != undefined){
							$('input[name='+ issueAnswerDel +']:eq(3)').val(item.description);
						}else{
							issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(2)'); 
							if(issueAnswerDelA.val() != undefined){
								$('input[name='+ issueAnswerDel +']:eq(2)').val(item.description);
							}else{
								issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(1)'); 
								if(issueAnswerDelA.val() != undefined){
									$('input[name='+ issueAnswerDel +']:eq(1)').val(item.description);
								}else{
									issueAnswerDelA = $('input[name='+ issueAnswerDel +']:eq(0)'); 
									if(issueAnswerDelA.val() != undefined){
										$('input[name='+ issueAnswerDel +']:eq(0)').val(item.description);
									}
								}
							}
						}
						if(issueAnswerGradeA.val() != undefined){
							$('input[name='+ issueAnswerGrade +']:eq(3)').val(item.mark);
						}else{
							issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(2)'); 
							if(issueAnswerGradeA.val() != undefined){
								$('input[name='+ issueAnswerGrade +']:eq(2)').val(item.mark);
							}else{
								issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(1)'); 
								if(issueAnswerGradeA.val() != undefined){
									$('input[name='+ issueAnswerGrade +']:eq(1)').val(item.mark);
								}else{
									issueAnswerGradeA = $('input[name='+ issueAnswerGrade +']:eq(0)'); 
									if(issueAnswerGradeA.val() != undefined){
										$('input[name='+ issueAnswerGrade +']:eq(0)').val(item.mark);
									}
								}
							}
						}
						if(issueAnswerScoringA.val() != undefined){
							$('input[name='+ issueAnswerScoring +']:eq(4)').val(item.score);
						}else{
							issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(3)');
							if(issueAnswerScoringA.val() != undefined){
								$('input[name='+ issueAnswerScoring +']:eq(3)').val(item.score);
							}else{
								issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(2)');
								if(issueAnswerScoringA.val() != undefined){
									$('input[name='+ issueAnswerScoring +']:eq(2)').val(item.score);
								}else{
									issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(1)'); 
									if(issueAnswerScoringA.val() != undefined){
										$('input[name='+ issueAnswerScoring +']:eq(1)').val(item.score);
									}else{
										issueAnswerScoringA = $('input[name='+ issueAnswerScoring +']:eq(0)'); 
										if(issueAnswerScoringA.val() != undefined){
											$('input[name='+ issueAnswerScoring +']:eq(0)').val(item.score);
										}
									}
								}
							}
						}
					  break;
				  
				  default : break;
			    }
				
			});
			
		}else
		{
			alert('查询问题答案信息失败!');
		}

	},'json');
}

function updateQuestion(upl){
	if($('#'+upl+'').find("textarea[name=proDesc]").val()){
		var parent = $("#"+upl);
		var reg1 = /^[0-9]*$/;
		var reg = /^[0-9]+([.][0-9]{1}){0,1}$/;
		var answers = [];
		var answerGrade = [];
		for(var i = 1;i < 10;i ++){
			var issueAnswerDel = 'uploadForm_3' == upl ? issueAnswerDel = "Issue_Answer_ipt_"+i+"b" : "Issue_Answer_del_"+i;
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
					if('uploadForm_3' == upl){
						alert("请输入计分"+i+"的答案内容");
					}else{
						alert("请输入答案"+i+"的答案内容");
					}
					return false;
				}else{
					if('uploadForm_3' == upl){
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
			}else if('uploadForm_3' != upl){
				break;
			}
			
			if(issueAnswerScoringA.val() != undefined){
				if(issueAnswerScoringA.val() == ""){
					if('uploadForm_3' == upl){
						alert("请输入计分"+i+"的得分情况");
					}else{
						alert("请输入答案"+i+"的计分");
					}
					return false;
				}else{
					  if(!reg.test(issueAnswerScoringA.val())){
						  if('uploadForm_3' == upl){
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
		
		$('#'+upl+'').post(setUpdateQuestionUrl,{qustid:qustid,problemid:problemid,ansType:ansType},function(data){
			if(data){ 
				//alert("data "+data);
			}
		},'json');
		
//		$('#'+upl+'').ajaxForm({
//			dataType: 'json',
//			success:function(data){
//				alert("修改成功");
//			},
//			error: function(data) {
//                alert("error:"+data.responseText);
//            }
//		});
	}else{
		alert("问题标题不能为空");
		return false;
	}
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


function totalshow(type,qustid){
	$('input[name=mainId]').val(qustid);
	var bh = $(document).height(); 
	var bw = $(document).width(); 
    $("#fullbg").css({ 
    height:bh, 
    width:bw, 
    display:"block" 
    }); 
	var countMethod = $("input[name=countMethod]:checked").val();
	$.post("../question/questionAction!getQuestionTotalScoreInfo",{qustid:qustid,countMethod:countMethod},function(data){
		if(data){ 
			//alert("data.endNum "+data.endNum);
			$('input[name=startNum]').val(1);
			if(data.endNum == '0'){
				$('input[name=endNum]').val(1);
			}else{
				$('input[name=endNum]').val(data.endNum);
			}
			$('input[name=totalScore]').val(data.totalScore);
		}
	},"json");
	
	
    $("#"+type+"").show();
} 

function addtotal(del){
	var leg=String(getTagsInfo($(del).parent().parent().prev()));//取点击添加新问题的父级的父级的前一个同级元素--tr_answer_x_x_x
	var leh=leg.substring(leg.length-1,leg.length);
	var lengt=parseInt(leh)+1;//计算下一个答案编号
	if(lengt==9){
		$(del).css('display','none');
	}
	var addAn=$('<tr id="traddantype_6_'+lengt+'">'+
				'<td class="td_Answer">结论'+lengt+':<img src="../img/del.png" id="Issue_Answer_del"  onclick="del_answer(this)"></td>'+
					'<td class="">'+
						'<input type="text" class="Issue_content_topic" name="score_a'+lengt+'"/>&nbsp;&nbsp;≤&nbsp;&nbsp;分值&nbsp;&nbsp;&lt;<input type="text" class="Issue_content_topic" name="score_b'+lengt+'"/>'+
					'</td>'+
					'<td class="td_Issue3"  colspan="2">'+
					'<input type="text" name="Issue_Answer_Scoring_'+lengt+'" class="Issue_total_topic"></td>'+
					'</tr>');
	addAn.insertBefore(''+getTagsInfo($(del).parent().parent())+'');
}

function addQuestion_total(upl){
	var reg = /^[0-9]+([.][0-9]{1}){0,1}$/;
	var parent = $('#'+upl);
	if($('#'+upl+'').find("#myTitle").val()){
		var totalScore = $('input[name=totalScore]', parent).val();
		for(var i = 1;i < 10;i ++){
			var score_a = "score_a"+i;
			var score_b = "score_b"+i;
			var scoreA1 = $('input[name='+ score_a +']', parent);
			var scoreB1 = $('input[name='+ score_b +']', parent);
			if(scoreA1.val() != undefined && scoreB1.val() != undefined){
				if(scoreA1.val() == "" || scoreB1.val() == ""){
					alert("请输入结论"+i+"的分值区间");
					return false;
				}else{
					 if(!reg.test(scoreA1.val()) || !reg.test(scoreB1.val())){
						 alert("结论"+i+"的分值区间不是数字或者小数，请重新输入");
						 return false;
					 }
					 var totalScoreNum = new Number(totalScore);
					 var scoreA1Num = new Number(scoreA1.val());
					 var scoreB1Num = new Number(scoreB1.val());
					 if(scoreA1Num > totalScoreNum || scoreB1Num > totalScoreNum){
						 alert("结论"+i+"的分值区间的值大于该问卷的总分，请重新输入");
						 return false;
					 }
				}
			}else{
				break;
			}
		}
		
		$('#'+upl+'').post(addQuestionTotalScoreUrl,function(data){
			if(data){ 
				//alert("data "+data);
			}
		},'json');
		
	}else{
		alert("总分描述不能为空");
		return false;
	}
	
	
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
		$('#'+upl+'').post(setSaveQuestionUrl,{qustid:qustid,choose:choose},function(data){
			if(data){ 
				//alert("data "+data);
			}
		},'json');
		
//		$('#'+upl+'').ajaxForm({
//			dataType: 'json',
//			success:function(data){
//				alert("增加成功");
//			}
//		});
	}else{
		alert("问题标题不能为空");
		return false;
	}
}




