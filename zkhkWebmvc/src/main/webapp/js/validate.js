	
		var haveError;
		var errorMsgColor ="color:red";		//(样式)错误消息的颜色
		var firstMsgColor = "color: #888"; //(样式)初始的提示语的颜色   用于之后的判断,中间要加空格,全文小写
		
		function basicInit(object){//初始化基本方法
			if(object==null){
				return false;
			}
			$(object).next().text('');//把验证对象后面的提示信息清空
		}
		//文本框验证初始化 
		function checkInit(object){
			
			basicInit(object);
			$(object).val(jQuery.trim($(object).val()));//去掉左右空格
		}
		
		//通过验证后,补写提示语
		function supplyMsg(object){
			if(object==null){
				return false;
			}
			if($(object).attr("firstMsg")!=undefined){
			$(object).next().text($(object).attr("firstMsg"));
			$(object).next().attr("style",$(object).attr("firstMsgColor"));
			}
		}

		//非空验证
		function required(object){
			checkInit(object);
			if($(object).val().trim().length==0){
				$(object).next().text("必须填写").attr("style",errorMsgColor);
				haveError = true;
				return false;
			}
		}
		
		//最大长度验证(所要验证的对象,文本的长度,出错后的提示信息)
		function maxLength(object,textlength,msg){
			if(object==null){
				return false;
			}
			checkInit(object);
			var len=0;
			for(var i=0;i<$(object).val().length;i++){
				var intCode=$(object).val().charCodeAt(i);
				if (intCode>=0&&intCode<=128){
					len=len+1;
				}else{
					len=len+3;
				}
			}
			if(len >textlength)
			{
				$(object).next().text(msg).attr("style",errorMsgColor);
				haveError = true;
				return false;
			}
			supplyMsg(object);
			return true;
		}
		//最小长度验证
		function minLength(object,textlength,msg){
			if(object==null){
				return false;
			}
			checkInit(object);
			var len=0;
			for(var i=0;i<$(object).val().length;i++){
				var intCode=$(object).val().charCodeAt(i);
				if (intCode>=0&&intCode<=128){
					len=len+1;
				}else{
					len=len+3;
				}
			}
			if(len <textlength)
			{
				$(object).next().text(msg).attr("style",errorMsgColor);
				haveError = true;
				return false;
			}
			supplyMsg(object);
			return true;
		}
		


		//下拉列表是否选择
		function selectType(object){
			
			basicInit(object);
			if($(object).children().length == 0 || $(object).val()==''){
				$(object).next().text("请选择").attr("style",errorMsgColor);
				haveError = true;
				return false;
			}
			supplyMsg(object);
			return true;
		}
		//必须是纯数字
		function isOnlyNumber(object){
			
			var reg = /^[0-9]{0,}$/;
			return regularExpression(object,"手机号必须是存数字！",reg);
		}
		
		//邮箱验证
		function isEmail(object){
			var myReg =/^.+\@(\[?)[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3}|[0-9]{1,3})(\]?)$/;
			return regularExpression(object,"邮箱格式错误！",myReg);
		}
		//身份证验证
		function isIDCard(object){
			checkInit(object);
		    var myReg =/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/;
			if($(object).val().length==18){
				myReg =/^((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91)\d{4})((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\d)|(2[0-8])))|((((0[1,3-9])|(1[0-2]))(29|30))|(((0[13578])|(1[02]))31))))((\d{3}(x|X))|(\d{4}))$/;
			}
			return regularExpression(object,"格式错误！",myReg);
		}
		
		//中间是否存在空格
		function nohaveSpace(object,msg,onlyName){//oblyName用于判断是否仅取出文件名称, 如果是判断一般字符串则,直接为false;
			var newstr;
			if(onlyName){ //是否只取出文件名,而忽略文件路径
				 newstr = $(object).val().substr($(object).val().lastIndexOf('\\')+1);
			}else{
				 newstr = $(object).val();
			}
			var myReg = /^\S{0,}$/;
			if(!myReg.test(newstr)){
				$(object).next().text(msg).attr("style",errorMsgColor);
				haveError = true;
				return false;
			}else{
				supplyMsg(object);
				return true;
			}
		}
		//****************************************************
		//*	提取正则表达式,所有正则表达式判断,js文件内部调用此方法    *
		//****************************************************	
		function regularExpression(object,msg,myReg)
		{
			checkInit(object);
			if(!myReg.test($(object).val())){
				$(object).next().text(msg).attr("style",errorMsgColor);
				haveError = true;
				return false;
			}else{
				supplyMsg(object);
				return true;
			}
		}
