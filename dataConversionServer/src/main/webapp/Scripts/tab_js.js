     
	function getid(obj)
	{
		return document.getElementById(obj);
	}
	
	function gettag(obj,tag,name)
	{
		var t = obj.getElementsByTagName(tag);
		var list = new Array();
		for(i=0;i<t.length;i++)
		{
			if(t[i].getAttribute("name") == name )
			{
				list[list.length] = t[i];
			}
		}
		return list;
	}
		
	function changeFod(obj,info,name)
	{
		var p = obj.parentNode.getElementsByTagName("a");
		var f1 = getid(info);
		var t = gettag(f1,"table",name);
		for(i=0;i<p.length;i++)
		{
			if(p[i] == obj)
			{
				p[i].className = "tab_select";
				t[i].style.display = "";
			}
			else
			{
				p[i].className = "tab_nomal";
				t[i].style.display = "none";			
			}
		}
}
