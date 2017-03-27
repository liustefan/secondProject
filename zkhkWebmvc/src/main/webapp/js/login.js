/*login.js*/
if (window != top) 
	top.location.href = location.href; 

function checksubmit(){
    $("#errmsg").text('');
	if (!isHost(form1.docacc.value)) {
		$("#errmsg").append("请输入合法的用户名！").attr("style","color:red;text-align:left;");
		//alert("请输入合法的用户名！");
		return false;
	}
	if(form1.docpass.value==""){
		$("#errmsg").append("请输入密码！").attr("style","color:red;text-align:left;");
		//alert("请输入密码！");
		return false;
	}
	/* if(form1.v_code.value==""){
		alert("请输入验证码！");
		return false;
	} */
	return true;
}

function isHost(host){
	var pattern=/^([a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?)$/;
	var emailRex = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	if(host.match(pattern)==null && !host.match(emailRex))
		return false;
	else
		return true;
}