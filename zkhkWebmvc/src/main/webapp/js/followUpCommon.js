function setOtherInfo(memberId, type, url){
	if(memberId && type){
		$.ajax({
	   type: "GET",
	   url:  url ? url : "getLatestInfoByMemberId",
	   data: {id: memberId},
	   async: false,
	   success: function(msg){
		   if(msg.status){
			   if($("#systolic").val() == "" && $("#diastolic").val() == ""){
				   $("#systolic").val(msg.data.systolic);
				   $("#diastolic").val(msg.data.diastolic);
			   }
			   
			   if($("#height").val() == "" && $("#weight").val() == ""){
				   $("#height").val(msg.data.height);
				   $("#weight").val(msg.data.weight);
				   $("#bmi").val(msg.data.bmi);
			   }
			   
			   if($("#dailySmoking").val() == "" && $("#dailySmokingNext").val() == ""){
				   $("#dailySmoking").val(msg.data.dailySmoking);
				   $("#dailySmokingNext").val(msg.data.dailySmoking_Next);
			   }
			   
			   if($("#dailyDrink").val() == "" && $("#dailyDrinkNext").val() == ""){
				   $("#dailyDrink").val(msg.data.dailyDrink);
				   $("#dailyDrinkNext").val(msg.data.dailyDrink_Next);
			   }
			   
			   if($("#sportFrequency").val() == "" && $("#sportDuration").val() == ""){
//				   $("#sportFrequency").val(msg.data.sportFrequency);
				   $("#sportDuration").val(msg.data.sportDuration);
			   }
			   
			   if(type == "h"){
				   if(msg.data.medicines && $("#medicine_data").children().length == 0){
					   var str="";
					   for(var i=0; i<msg.data.medicines.length; i++){
	 					   str+="<tr id='Medicinal-cb-"+i+"'><td><input type='checkbox' value='"+i+"'/><input type='hidden' name='phHypertensiondetailmedicines["+i+"].logID' value='"+msg.data.medicines[i].logID+"'/></td>"
	 					   		+"<td><input type='hidden' name='phHypertensiondetailmedicines["+i+"].drugName' value='"+msg.data.medicines[i].drugName+"'><span>"+msg.data.medicines[i].drugName+"</span></td>"
	 					   		+"<td><input type='hidden' name='phHypertensiondetailmedicines["+i+"].drugUsage' value='"+msg.data.medicines[i].drugUsage+"'><span>"+msg.data.medicines[i].drugUsage+"</span></td>"
	 					   		+"<td><input type='hidden' name='phHypertensiondetailmedicines["+i+"].drugDosage' value='"+msg.data.medicines[i].drugDosage+"'><span>"+msg.data.medicines[i].drugDosage+"</span></td>"
	 					   		+"<td><input type='hidden' name='phHypertensiondetailmedicines["+i+"].drugUnit' value='"+msg.data.medicines[i].drugUnit+"'><span>"+msg.data.medicines[i].drugUnit+"</span></td>"
	 					   		+"<td><input type='hidden' name='phHypertensiondetailmedicines["+i+"].drugFreq' value='"+msg.data.medicines[i].drugFreq+"'><span>"+msg.data.medicines[i].drugFreq+"</span></td>"
	 					   		+"<td><input type='hidden' name='phHypertensiondetailmedicines["+i+"].remarks' value='"+msg.data.medicines[i].remarks+"'><span>"+msg.data.medicines[i].remarks+"</span></td></tr>";
	 				    }
					   $("#medicine_data").html(str);
				   }
			   }else{
				   if($("#fpg").val() == ""){
					   $("#fpg").val(msg.data.glu);
				   }
				   
				   if($("#pglu").val() == ""){
					   $("#pglu").val(msg.data.pglu);
				   }
				   
				   if($("#hba1c").val() == ""){
					   $("#hba1c").val(msg.data.hba1c);
				   }
				   
				   if(msg.data.medicines && $("#medicine_data").children().length == 0){
					   var str="";
					   for(var i=0; i<msg.data.medicines.length; i++){
	 					    str+="<tr id='Medicinal-cb-"+i+"'><td><input type='checkbox' value='"+i+"'/><input type='hidden' name='phDiabetesdetailmedicines["+i+"].logID' value='"+msg.data.medicines[i].logID+"'/></td>"
	 					   		+"<td><input type='hidden' name='phDiabetesdetailmedicines["+i+"].drugName' value='"+msg.data.medicines[i].drugName+"'><span>"+msg.data.medicines[i].drugName+"</span></td>"
	 					   		+"<td><input type='hidden' name='phDiabetesdetailmedicines["+i+"].drugUsage' value='"+msg.data.medicines[i].drugUsage+"'><span>"+msg.data.medicines[i].drugUsage+"</span></td>"
	 					   		+"<td><input type='hidden' name='phDiabetesdetailmedicines["+i+"].drugDosage' value='"+msg.data.medicines[i].drugDosage+"'><span>"+msg.data.medicines[i].drugDosage+"</span></td>"
	 					   		+"<td><input type='hidden' name='phDiabetesdetailmedicines["+i+"].drugUnit' value='"+msg.data.medicines[i].drugUnit+"'><span>"+msg.data.medicines[i].drugUnit+"</span></td>"
	 					   		+"<td><input type='hidden' name='phDiabetesdetailmedicines["+i+"].drugFreq' value='"+msg.data.medicines[i].drugFreq+"'><span>"+msg.data.medicines[i].drugFreq+"</span></td>"
	 					   		+"<td><input type='hidden' name='phDiabetesdetailmedicines["+i+"].remarks' value='"+msg.data.medicines[i].remarks+"'><span>"+msg.data.medicines[i].remarks+"</span></td></tr>";
	 				    }
					   $("#medicine_data").html(str);
				   }
			   }
		   }
	   }
	});
	}
}

