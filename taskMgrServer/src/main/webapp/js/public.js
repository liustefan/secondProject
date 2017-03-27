function BeginOut4(f,s,w,h){
	l = (screen.width-w)/2
	t = (screen.height-h)/2
	s = f;
	sFeatures = "left="+ l +",top="+ t +",height="+h+",width="+w+",center=1,scroll=0,status=0,directories=0,channelmode=0,resizable=no,"
	scourseNanage = window.open(s,"scourseNanage",sFeatures);
	if (!scourseNanage.opener) 
		scourseNanage.opener = self;
	scourseNanage.focus();
}
 
function BeginOut3(f,w,h){
	l = (screen.width-w)/2
	t = (screen.height-h)/2
	sFeatures = "status:no;scroll:no;resizable:no;help:no;dialogWidth:" + w + "px;dialogHeight:" + h + "px";
	scourseNanage = window.showModalDialog (f, '',sFeatures );
	if (!scourseNanage.opener) 
		scourseNanage.opener = self;
	scourseNanage.focus();
}

/*
 * 打开新窗口
 */
function openWin(f,n,w,h,s){
	sb = s == "1" ? "1" : "0";
	l = (screen.width - w)/2;
	t = (screen.height - h)/2;
	sFeatures = "left="+ l +",top="+ t +",height="+ h +",width="+ w
			+ ",center=1,scrollbars=" + sb + ",status=0,resizable=0,directories=0,channelmode=0";
	openwin = window.open(f , n , sFeatures );
	if (!openwin.opener)
		openwin.opener = self;
	openwin.focus();
	return openwin;
}



function WinOpen(f,n,w,h,s,t){
	sb = s == "1" ? "1" : "0";
	l = (screen.width - w)/2;
	
	sFeatures = "left="+ l +",top="+ t +",height="+ h +",width="+ w
			+ ",center=1,scrollbars=" + sb + ",status=0,resizable=0,directories=0,channelmode=0";
	openwin = window.open(f , n , sFeatures );
	if (!openwin.opener)
		openwin.opener = self;
	openwin.focus();
	return openwin;
}


/*
 * 打开全屏窗口
 */
function openFullWin(f,n){
	var h = window.screen.availHeight;
	var w = window.screen.availWidth;
	sFeatures = "left=0,top=0,height=" + h +",width=" + w + ",scrollbars=1,resizable=yes,channelmode";
	openwin = window.open(f , n , sFeatures );
	openwin.moveTo(0,0);
	openwin.resizeTo(w,h);
	if (!openwin.opener) {
		openwin.opener = self;
	}
	openwin.focus();
	return openwin;

}

/*
 * 打开删除窗口
 */
function openDeleteDialog(url,confirmString){
	var c = confirmString;
	if(c == null || c == ''){
		c = "你确认要删除记录吗？";
	}
	if(confirm(c)){
		return window.showModalDialog(url,"window123","dialogHeight:234px;dialogWidth:271px;resizable:no;help:yes;status:no;scroll:no");
	}
	return false;
}

/*
 * 打开模态对话框
 */
function popWin(f,n,w,h){
	l = (screen.width-w)/2;
	t = (screen.height-h)/2;
	sFeatures = "left="+ l +",top="+ t +",height="+ h +",width="+ w
			+",center=1,status=0,directories=0,channelmode=0,resizable=no";
	popwin = window.showModalDialog(f, n, sFeatures);
	if (!openwin.opener)
		openwin.opener = self;
	popwin.focus();
}

/*
 * 翻页查询
 */
function gotoPaginatedPage(path, page, pageSize) {
	
    document.forms[0].action=path;
    document.forms[0].page.value=page;
    document.forms[0].pageSize.value=pageSize;
    document.forms[0].submit();
}

/*
 * 保存
 */
function gotoSave(checkedForm, path) {
    if (checkedForm) {
        document.forms[0].action=path;
        document.forms[0].submit();
    }
}

/*
 * 保存
 */
function gotoSavePage(checkedForm, path) {
    if (checkedForm) {
		document.forms[0].target="_blank";
        document.forms[0].action=path;
        document.forms[0].submit();
    }
}
function gotoSaveWarn(checkedForm, path) {
	setDirtyFormWarning(false);
	if (checkedForm) {
        document.forms[0].action=path;
        document.forms[0].submit();
    }
}
/*
 * 翻页
 */
function goto_page(path) {
    document.forms[0].action=path;
    document.forms[0].submit();
}

/*
 * 校验checkbox
 */
function checkAll( chkName, checkboxName, pageSize ) {
    var src = event.srcElement;
	var chkN=eval("document.all."+chkName);

    if (src.checked) {
		chkN[0].checked = true;
		chkN[1].checked = true;
		for(var i=0; i<pageSize; i++) {
			var chk = eval("document.all." + checkboxName + i);
			if (chk) {
				chk.checked=true;
			}
    	}
    } else {
		chkN[0].checked = false;
		chkN[1].checked = false;
    	for(var i=0; i<pageSize; i++) {
			var chk = eval("document.all." + checkboxName + i);
			if(chk) {
				chk.checked=false;
			}
    	}
    }
}

/*
 * 
 */
function makePages(maxPage, selectedPage, selectName) {
	var sel=eval("document.all."+selectName);
	sel.length=0;
	for(var i=1; i<=maxPage; i++) {
		sel.options[i]=new Option(i,i);
		if(sel.options[i]==selectedPage) {
			sel.options[i].selected=true;
		}
	}
}

/*
 * 替换字符串
 */
function replaceStr( str ) {
    var re="/( )/gi";
    str = str.replace(re,"");
    re="/\</gi";
    str = str.replace(re,"&lt;");

    return str;
}

/*
 * 去掉左边空格
 */
function LTrim(str) {
    var whitespace = new String(" \t\n\r");
    var s = new String(str);
    if (whitespace.indexOf(s.charAt(0)) != -1) {
        var j=0, i = s.length;
        while (j < i && whitespace.indexOf(s.charAt(j)) != -1) {
           j++;
        }
        s = s.substring(j, i);
    }
    return s;
}

/*
 * 去掉右边空格
 */
function RTrim(str) {
    var whitespace = new String(" \t\n\r");
    var s = new String(str);
    if (whitespace.indexOf(s.charAt(s.length-1)) != -1) {
        var i = s.length - 1;
        while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1) {
            i--;
        }
        s = s.substring(0, i+1);
    }
    return s;
}

/*
 * 去掉两边空格
 */
function Trim(str) {
    return RTrim(LTrim(str));
}

/*
 *
 */
function exeOperation( exePath ){
    var obj = new ActiveXObject("Microsoft.XMLHTTP");
    obj.open("post",exePath,false);
    obj.send();
    var res = obj.responseText;
    var rs = Trim(res);
    if (rs.indexOf('true',0) != -1) {
    	return true;
    } else {
        return false;
    }
}

/*
 *
 */
function exeValidate( exePath ){
    var obj = new ActiveXObject("Microsoft.XMLHTTP");
    obj.open("post",exePath,false);
    obj.send();
    var res = obj.responseText;
    var rs = Trim(res);
    if (rs.indexOf('validate_login_user',0) != -1) {
    	return true;
    } else {
        return false;
    }
}

/*
 * 显示
 */
function validate_date( exePath ) {
	 var obj = new ActiveXObject("Microsoft.XMLHTTP");
     obj.open("post",exePath,false);
     obj.send();
     var res = obj.responseText;
     var rs = Trim(res);
	 var begin_str = "<!--begin-->";
	 var beginIndex = rs.indexOf(begin_str) + begin_str.length;
	 var endIndex   = rs.indexOf("<!--end-->");
	 rs = ((beginIndex >= 0) && (endIndex >= 0)) ? rs.substring(beginIndex,endIndex) : "";
	 return Trim(rs);
}

/*
 * 校验是否数字
 */
function checkNumber(name, TempS) {
	for(Count=0;Count<TempS.length;Count++) {
		TempChar=TempS.substring(Count,Count+1);
		RefString="0123456789.";
		if (RefString.indexOf(TempChar,0)==-1) {
			alert("请输入数字");
			eval("document.all." + name).focus();
			return false;
		}
	}
	return true;
}

/*
 * 是否有非法字符
 */
function chksafe(a){
	fibdn = new Array ("'" ,"\\");
	i=fibdn.length;
	j=a.length;
	for (ii=0; ii<i; ii++) {
		for (jj=0; jj<j; jj++) {
			temp1=a.charAt(jj);
			temp2=fibdn[ii];
			if (temp1==temp2){
				return false;
			}
		}
	}
	return true;
}

/*
 *
 */
function fucCheckNUM(NUM){
	var i,j,strTemp;
	strTemp="0123456789";
	if ( NUM.length== 0)  
		return false;
	for (i=0;i<NUM.length;i++) {
		j=strTemp.indexOf(NUM.charAt(i));
		if (j==-1){
			
			return false;
		}
	}
	return true;
}

/*
 *
 */
function fucCheckLength(strTemp) {
	var i,sum;
	sum=0;
	for(i=0;i<strTemp.length;i++) {
		if ((strTemp.charCodeAt(i)>=0) && (strTemp.charCodeAt(i)<=255)) {
			sum=sum+1;
		} else {
			sum=sum+2;
		}
	}
	return sum;
}

/*
 *
 */
function chkElements( name, errMsg, max_length, lengthMsg ) {
    var el_name = eval("document.all." + name);
	var v = el_name.value;
	if (!chksafe(v)) {
		el_name.focus();
		alert(errMsg);
		return false;
	} else if (fucCheckLength(v) > max_length) {
		el_name.focus();
		alert(lengthMsg);
		return false;
	}
	return true;
}

/*
 * 校验空字符串
 */
function checkNullStr(name, msg) {
	var el_name = eval("document.all['"+name+"']");
	if (Trim(el_name.value).length==0) {
		alert(msg);
		el_name.focus();
		return false;
	}
	return	true;
}

/*
 * 显示日期控件
 */
function GetDate(nText,para){
	var v_url = para=="1"?"./common/data.html":"../../common/data.html";
  	var reVal = window.showModalDialog(v_url, 'data',"status:no;center:yes;scroll:no;resizable:no;dialogWidth:255px;dialogHeight:260px");
  	if (reVal != null) {
		var n = eval("document.all." + nText);
		n.value=reVal;
  	}
}

/*
 * 显示日期控件
 */
function GetDate1(nText,para){
	var v_url = para=="1"?"./common/data1.html":"../../common/data1.html";
  	var reVal = window.showModalDialog(v_url, 'data',"status:no;center:yes;scroll:no;resizable:no;dialogWidth:255px;dialogHeight:260px");
  	if (reVal != null) {
		var n = eval("document.all." + nText);
		n.value=reVal;
  	}
}

/*
 * 按比例缩小图片
 */
function DrawImage(ImgD,iwidth,iheight){
	var flag=false;
	var image=new Image();
	image.src=ImgD.src;
	if(image.width>0 && image.height>0){
		flag=true;
		if(image.width/image.height>= iwidth/iheight){
			if(image.width>iwidth){ 
				ImgD.width=iwidth;
				ImgD.height=(image.height*iwidth)/image.width;
			}else{
				ImgD.width=image.width; 
				ImgD.height=image.height;
			}
//			ImgD.alt=image.width+"×"+image.height;
		}else{
			if(image.height>iheight){ 
				ImgD.height=iheight;
				ImgD.width=(image.width*iheight)/image.height; 
			}else{
				ImgD.width=image.width; 
				ImgD.height=image.height;
			}
//			ImgD.alt=image.width+"×"+image.height;
		}
	}
	ImgD.style.visibility = "visible";
} 

/*
 * 回车键转为Tab键
 */
function enterTab(){
	if(event.keyCode==13){
		oElement = document.activeElement;
		if(oElement.tagName != "TEXTAREA" && oElement.type != "button")
			event.keyCode=9;
		return ;
   	}
}

/*
 *
 */
function objectEval(text) {
    text = text.replace(/\n/g, " ");
    text = text.replace(/\r/g, " ");
    if (text.match(/^\s*\{.*\}\s*$/)) {
        text = "[" + text + "]";
    }
    return eval(text)[0];
}

/*
 * 打开领导查询页面
 * action	- 查询的Action
 * method	- 调用的方法
 * title	- 标题message
 * name		- 员工选择域的name
 */
function openLeaderQuery(action,method,title,name){
	openWin("../../common/selectStaff.jsp?action="+action+"&method="+method+"&title="+title+"&name="+name,"public_leader_find_page","400","150");
}

/*
 * 第一行变色
 */
function chgColor(){
	var v_table = document.all["PowerTable"];
	var v_row = v_table.rows[1];
	var len = v_row.cells.length;
	for(var i=0;i<len;i++){
		var v_cell = v_row.cells[i];
		v_cell.style.backgroundColor = "yellow";
	}
}

/*
 * 第一行变色
 */
function chgColor2(){
	var v_table = document.all["PowerTable"];
	var rows_count=v_table.rows.length;
	var v_row,v_cell,temp_len,len;
	var rowspan=0;
	
	//get rowspan
	if (v_table.rows.length > 1) {
		len = v_table.rows[1].cells.length;
		for (var r=2; r < rows_count; r++) {
			v_row = v_table.rows[r];
			temp_len = v_row.cells.length;
			if (temp_len==len) {
				rowspan=r-1;
				break;
			}
		}
		
		rowspan=(rowspan>0) ? (rowspan+1) : rows_count;		
		for(var r=1; r < rowspan; r++) {
			v_row=v_table.rows[r];
			for (var t=0; t < v_row.cells.length; t++) {
				v_cell = v_row.cells[t];
				v_cell.style.backgroundColor = "yellow";
			}
		}			
	}	
}

/*
 * 添加页面载入后触发的事件
 */
function addLoadEvent(func) {
	var oldonload = window.onload;
	if (typeof(window.onload) != "function") {
		window.onload = func;
	} else {
		window.onload = function() {
			oldonload();
			func();
		}
	}
}

//验证表单重复提交
var checkSubmitFlg = false;
function checkSubmit() {
	if (checkSubmitFlg) {
		return false;
	}
	checkSubmitFlg = true;
	return true;
}

//adsName:名称,adsUrl:地址,sTime:时间(小时) add by wujie 2005.12.12
function PopAds(adsName,adsUrl,sTime,number,w,h,s)
{
	if(document.cookie.indexOf(adsName)==-1)
	{
		window.open(adsUrl,adsName);
		self.focus();
	            var expireDate = new Date();
	            var lefttime = 1000 * (3600 * sTime);
	            expireDate.setTime (expireDate.getTime() + lefttime);
	            document.cookie = adsName +"=yes" + "; expires=" + expireDate.toGMTString() +  ";";
	}
openWin(adsUrl,number,w,h,s);
}
//add by wujie 2006.3.20
//四舍五入
function adv_format(value,num) 
{
var a_str = formatnumber(value,num);
var a_int = parseFloat(a_str);
if (value.toString().length>a_str.length)
{
var b_str = value.toString().substring(a_str.length,a_str.length+1)
var b_int = parseFloat(b_str);
if (b_int<5)
{
return a_str
}
else
{
var bonus_str,bonus_int;
if (num==0)
{
bonus_int = 1;
}
else
{
bonus_str = "0."
for (var i=1; i<num; i++)
bonus_str+="0";
bonus_str+="1";
bonus_int = parseFloat(bonus_str);
}
a_str = formatnumber(a_int + bonus_int, num)
}
	
}
	
return a_str
}
//add by wujie 2006.3.20
function formatnumber(value,num) //直接去尾
{
var a,b,c,i
a = value.toString();
b = a.indexOf('.');
c = a.length;
if (num==0)
{
if (b!=-1)
a = a.substring(0,b);
}
else
{
if (b==-1)
{
a = a + ".";
for (i=1;i<=num;i++)
a = a + "0";
}
else
{
a = a.substring(0,b+num+1);
for (i=c;i<=b+num;i++)
a = a + "0";
}
	if(a.indexOf(".")==0)
	{
		a="0"+a;
	}
}
return a
}
// add by wujie日期比较
function compareDate(beginDate,endDate){
	
 	var strSeparator = "-"; //日期分隔符
		
		if(beginDate!="" && endDate!=""){
		beginDate=beginDate.split(strSeparator);
		endDate=endDate.split(strSeparator);
	
		var strDateS = new Date(beginDate[0] + "/" + beginDate[1] + "/" + beginDate[2]);
  	    var strDateE = new Date(endDate[0] + "/" + endDate[1] + "/" + endDate[2]);
		
	
		if((Date.parse(strDateS) - Date.parse(strDateE)) > 0){
			alert("开始时间不能大于结束时间!");
			return false;
		}
}
	return true;
 
}

document.ondblclick = function docondblclick() {
	window.event.returnValue = false;
}
document.onkeydown=enterTab;

//功能介绍：检查是否为数字 add by yangyong2007.11.22
function CheckNUM(NUM){  
	var i,j,strTemp; 
	strTemp="0123456789."; 
	if ( NUM.length== 0){
		return false;
	}
	for (i=0;i<NUM.length;i++){ 
		j=strTemp.indexOf(NUM.charAt(i)); 
		if (j==-1) { 	
			//说明有字符不是数字 
			return false; 
		} 
	} 
	//说明是数字 
	return true; 
} 

//检查时间格式是否正确 add by yangyong2009.03.13
function CheckDateTime(dateStr)
{  
    var str = Trim(dateStr);
   if(str=="")
   {
        return true;
   } 
   var reg;
   try
   {
       if(str.indexOf(' ')>0)
       {
             reg = /^(\d+)-(\d{1,2})-(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;     
             var r = str.match(reg);     
             if(r==null||r==undefined)  
             {
                 return false;
             }
             r[2]=r[2]-1;
             var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);  
             if(d.getFullYear()!=r[1]||Number(d.getMonth())!=Number(r[2])||Number(d.getDate())!=Number(r[3])
           ||Number(d.getHours())!=Number(r[4])||Number(d.getMinutes())!=Number(r[5])||Number(d.getSeconds())!=Number(r[6]))
             {
                 return false;
             }        
       }
       else
       {
           reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
             var r = str.match(reg); 
            if(r==null||r==undefined)
             {
                 return false; 
             } 
             var d= new Date(r[1], r[3]-1, r[4]); 
             if(d.getFullYear()!=r[1]||(d.getMonth()+1)!=r[3]||d.getDate()!=r[4])
             {
                return false; 
            }  
       }
   }
   catch(e)
   {
       alert(e);
       return false;
   }
   return true;   
}
//替换字符窜里的特殊字符
function replaceValue(obj)
{
  var objValue=obj.value;
  obj.value=objValue.replace(/[\W]/g,'');
}
function validateEmail(emailStr){
    var   re=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if(re.test(emailStr)){return   true;}
    else{return false;}
}
function validateTel(value)
  {
  //  if(!/^([0-9])*-?([0-9])*$/.test(value)) if(!/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(value))    +86-10-87654321  /^((((\(|(){0,1}[0-9]{3,4}(\)|)|-| ){0,1}){0,1}[0-9]{7,8}((-| ){1}[0-9]+)*)|(0{0,1}13[0-9]{9})){1}$/
	var test=/^0\d{2,3}\-[2-9][0-9]{6,7}(\-[0-9]{1,4})?$/;
  if(!value.match(test))
  {     
       return false;
  }
       return true;
 }
function validateMobile(value){
	var t=/^(13\d{9})|(15\d{9})|(18\d{9})|(0\d{10,11})$/; 
	if(!value.match(t)){ 
		return false;
	}
	return true;

}
/**
 * 验证邮政编码
 * @param value
 * @return boolean
 */
function validateZip(value)
{
	var type=/^\d{6}$/;         //邮政编码匹配格式
	if(!value.match(type))
	{
		return false;
	}
	else
	{
		return true;
	}
}
function checkIsNotEmpty(str)
{
if(str.trim() == "")
return true;
else
return false;
}
function showCalendar(eventObj,isTime,textObj,other)
{
          var obj1=document.getElementById(eventObj);
		  var obj2=document.all[textObj];
		  setday(obj1,obj2,isTime);

}
/**
 * 截取指定长度的中英文混合字符窜
 * @param str
 * @param len
 * @return 截取后的字符窜
 */
function getSubStr(str, len) {
    if(!str || !len) { 
    	return ''; 
    }
  
   //预期计数：中文2字节，英文1字节
   var str_length = 0;
   //需截取的字符窜长度
   var str_len = 0;
   var str_cut = new String();
   str_len = str.length;
   for(var i = 0;i<str_len;i++)
     {
        var tempstr = str.charAt(i);
        if (str.charCodeAt(i)>255){
      	  //按照预期计数增加2
        	str_length+=2;
      	 }
      	 else
      	 { 
      		str_length++;
      		 
      	 }
         str_cut = str_cut.concat(tempstr);
         if(str_length>=len)
         {
          str_cut = str_cut.concat("...");
          return str_cut;
         }
    }
    //如果给定字符串小于指定长度，则返回源字符串；
    if(str_length<len){
       return  str;
    }
}


/**
 * 截取指定日期格式的字符窜
 * @param strTemp
 * @param splitmark
 * @param retmark
 * @return 截取后的字符窜
 */
function getSubDateStr(strTemp,splitmark,retmark)
{
	  var inputdts=strTemp.split(splitmark);
	  var days=inputdts[2].split(" ");
	   return inputdts[0]+retmark+(inputdts[1].length==1?"0"+inputdts[1]:inputdts[1])+retmark+(days[0].length==1?"0"+days[0]:days[0]);
}
function setTableDefaultHeight(tbId)
{
	var tbobj=document.getElementById(tbId);
    var height=window.screen.availHeight-374;
    //tbobj.setAttribute("style", "height:"+height+"px;");
    tbobj.style.height =height+"px";
 
}
function setTableDefaultHeight1(tbId)
{
	var tbobj=document.getElementById(tbId);
    var height=window.screen.availHeight-406;
    //tbobj.setAttribute("style", "height:"+height+"px;");
    tbobj.style.height =height+"px";
 
}
function initButtonValue(buttonname)
{
  document.forms[0].buttonName.value=buttonname;
}

String.prototype.Trim = function() {   
	  var m = this.match(/^\s*(\S+(\s+\S+)*)\s*/);   
	  return (m == null) ? "" : m[1];   
}   
  
String.prototype.isMobile = function() {   
  return (/^(?:13\d|15\d|18\d)-?\d{5}(\d{3}|\*{3})$/.test(this.Trim()));   
}   
  
String.prototype.isTel = function()   
{   
  //"兼容格式: 国家代码(2到3位)-区号(2到3位)-电话号码(7到8位)-分机号(3位)"   
  //return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?/.test(this.Trim()));   
	 return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test(this.Trim()));
}
function clearNoNum(obj)   
{   
    //先把非数字的都替换掉，除了数字和.   
    obj.value = obj.value.replace(/[^\d.]/g,"");   
    //必须保证第一个为数字而不是.   
    obj.value = obj.value.replace(/^\./g,"");   
    //保证只有出现一个.而没有多个.   
    obj.value = obj.value.replace(/\.{2,}/g,".");   
    //保证.只出现一次，而不能出现两次以上   
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
 
}
//只能输入整数或者浮点数 
function checkInputIntFloat(oInput)
{
    if('' != oInput.value.replace(/\d{1,}\.{0,1}\d{0,}/,''))
    {
        oInput.value = oInput.value.match(/\d{1,}\.{0,1}\d{0,}/) == null ? '' :oInput.value.match(/\d{1,}\.{0,1}\d{0,}/);
    }
}