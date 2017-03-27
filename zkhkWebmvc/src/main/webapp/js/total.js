function totalshow(type){
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
	    $("#"+type+"").find('input[name="mainId"]').val(mainId);
	    var countMethod = $("input[name=countMethod]:checked").val();
	    $.post("../question/questionAction!getQuestionTotalScoreInfo",{qustid:mainId,countMethod:countMethod},function(data){
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
	if($('#'+upl+'').find("#myTitle").val()){
		var totalScore = $('input[name=totalScore]').val();
		for(var i = 1;i < 10;i ++){
			var score_a = "score_a"+i;
			var score_b = "score_b"+i;
			var scoreA1 = $('input[name='+ score_a +']');
			var scoreB1 = $('input[name='+ score_b +']');
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
		
		
		$('#'+upl+'').ajaxForm({
			dataType: 'json',
			success:function(data){
					var sum='';
					if(data){
						switch(data.countMethod){
							case '1':sum="求和";break;
							case '2':sum="求平均值";break;
							case '3':sum="求最大值";break;
						}
						var addAn=$('<table class="sel_table" cellspacing="0" cellpadding="0">'+
									'<tr class="title_count">'+
										'<td>问卷总分:</td>'+
										'<td>'+data.title+'</td>'+
										'<td width="40"></td>'+
										'<td>从No.'+data.startNum+'到'+data.endNum+'</td>'+
									'</tr>'+
									'<tr id=sel_table_tr_'+data.questionId+'>'+
										'<td>计分方式：</td>'+
										'<td colspan="3">'+sum+'</td>'+
									'</tr>'+
								'</table>');
						addAn.prependTo($('#footer_content'));
						$.each(data.conclusions,function(i,item){					
											 var addAntd=$('<tr>'+
											'<td class="sel_table_td">结论'+item.num+':</td>'+
											'<td>'+item.downRange+'≤ 分值 &lt;'+item.upRange+'</td>'+
											'<td colspan="2">'+item.conclusionDescription+'</td>'+
											'</tr>');
											addAntd.insertAfter($('#sel_table_tr_'+data.questionId+''));
						});
						$('#'+upl+'').find(".Issue_Answer_del_ipt,.Issue_total_topic,.Issue_content_topic").attr("value","");
						var cols=getTagsInfo_1($('#'+upl+'').find("div").slice(0, 1));
						closeBg(cols);	
					}else
					{
						alert('未知错误！');
					}
				}
		});
	}else{
		alert("总分描述不能为空");
		return false;
	}
	
	
}
function detection(){
	var questionName=$('#Questionnairename').val();
	if($('#Questionnbut').css("display")=="none")
	{

	}else{
			if(questionName==""){
				//alert('试卷名称不能为空');
				//$('#Questionnairename').focus();
				$('#Questionnairename').css("border-color","#ccc");
				$('#Questionnairename').next("span").text("问卷名称不能为空");
				return;
				}
			$.post(checkQuesUrl,{questionName:questionName},function(data){
				if('true'==data){
					$('#Questionnairename').css("border-color","#ccc");
					$('#Questionnairename').next("span").text("问卷名称已存在");
					//('#Questionnairename').focus();
					return;
					}else{
						$('#Questionnairename').next("span").text("");
					}
			})
	}
}