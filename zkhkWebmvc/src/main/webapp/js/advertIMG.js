function fileChange(target){  
     //检测上传文件的类型(检测封面图)
     var file=document.getElementById("img_up");
     var imgName =file.value;
     var ext,idx;   
    /*if (imgName == ''){  
       document.all.submit_upload.disabled=true; 
        alert("请选择需要上传的文件!");  
        return; 
    } else { */  
        idx = imgName.lastIndexOf(".");   
        if (idx != -1){   
            ext = imgName.substr(idx+1).toUpperCase();   
            ext = ext.toLowerCase( ); 
           // alert("ext="+ext);
            if (ext != 'jpg' && ext != 'bmp' && ext != 'png' && ext != 'gif'){
              //document.all.submit_upload.disabled=true;   
                alert("只能上传.jpg  .bmp  .png  .gif类型的文件!"); 
                if (file.outerHTML) {
               	 file.outerHTML = file.outerHTML;
               	   } else { // FF(包括3.5)
               	   file.value = "";
               	}
                return false;  
            }   
        } else {  
          //document.all.submit_upload.disabled=true; 
           alert("只能上传.jpg  .bmp  .png  .gif类型的文件!"); 
           if (file.outerHTML) {
        	 file.outerHTML = file.outerHTML;
        	   } else { // FF(包括3.5)
        	   file.value = "";
        	}
           return false;
        }   
    /*}*/
    
    //检测上传文件的大小        
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;  
    var fileSize = 0;           
    if (isIE && !target.files){       
        var filePath = target.value;       
        var fileSystem = new ActiveXObject("Scripting.FileSystemObject");          
        var file = fileSystem.GetFile (filePath);       
        fileSize = file.Size;      
    } else {      
        fileSize = target.files[0].size;       
    }     

    var size = fileSize / 1024*1024;   

    if(size>(1024*1024)){    
   // document.all.submit_upload.disabled=true;
        alert("文件大小不能超过1M"); 
        if (file.outerHTML) {
       	 file.outerHTML = file.outerHTML;
       	   } else { // FF(包括3.5)
       	   file.value = "";
       	}
    }else{
   // document.all.submit_upload.disabled=false;
     previewImage(file);
    }    
}

function fileChange2(target){  
     //检测上传文件的类型(检测缩略图)
     var file=document.getElementById("thumb");
     var imgName =file.value;
     var ext,idx;   
    /*if (imgName == ''){  
       document.all.submit_upload.disabled=true; 
        alert("请选择需要上传的文件!");  
        return; 
    } else { */  
        idx = imgName.lastIndexOf(".");   
        if (idx != -1){   
            ext = imgName.substr(idx+1).toUpperCase();   
            ext = ext.toLowerCase( ); 
           // alert("ext="+ext);
            if (ext != 'jpg' && ext != 'bmp' && ext != 'png' && ext != 'gif'){
              //document.all.submit_upload.disabled=true;   
                alert("只能上传.jpg  .bmp  .png  .gif类型的文件!"); 
                if (file.outerHTML) {
               	 file.outerHTML = file.outerHTML;
               	   } else { // FF(包括3.5)
               	   file.value = "";
               	}
                return false;  
            }   
        } else {  
          //document.all.submit_upload.disabled=true; 
           alert("只能上传.jpg  .bmp  .png  .gif类型的文件!"); 
           if (file.outerHTML) {
        	 file.outerHTML = file.outerHTML;
        	   } else { // FF(包括3.5)
        	   file.value = "";
        	}
           return false;
        }   
    /*}*/
    
    //检测上传文件的大小        
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;  
    var fileSize = 0;           
    if (isIE && !target.files){       
        var filePath = target.value;       
        var fileSystem = new ActiveXObject("Scripting.FileSystemObject");          
        var file = fileSystem.GetFile (filePath);       
        fileSize = file.Size;      
    } else {      
        fileSize = target.files[0].size;       
    }     

    var size = fileSize / 1024*1024;   

    if(size>(1024*200)){    
   // document.all.submit_upload.disabled=true;
        alert("文件大小不能超过200KB");
        if (file.outerHTML) {
       	 file.outerHTML = file.outerHTML;
       	   } else { // FF(包括3.5)
       	   file.value = "";
       	}
    }else{
   // document.all.submit_upload.disabled=false;
     previewImage2(file);
    }    
}

//图片上传预览    IE是用了滤镜。
        function previewImage(file)
        {
          var MAXWIDTH  = 720; 
          var MAXHEIGHT = 260;
          var div = document.getElementById('preview');
          if (file.files && file.files[0])
          {
              div.innerHTML ='<img id=img_up2>';
              var img = document.getElementById('img_up2');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=img_up2>';
            var img = document.getElementById('img_up2');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function previewImage2(file)
        {
          var MAXWIDTH  = 64; 
          var MAXHEIGHT = 64;
          var div = document.getElementById('preview2');
          if (file.files && file.files[0])
          {
              div.innerHTML ='<img id=thumb2>';
              var img = document.getElementById('thumb2');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=thumb2>';
            var img = document.getElementById('thumb2');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight )
            {
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                 
                if( rateWidth > rateHeight )
                {
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else
                {
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
             
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }