function fileChange1(target){  
     //检测上传文件的类型
     var file=document.getElementById("fileField1");
     var imgName =file.value;
     var ext,idx;   
        idx = imgName.lastIndexOf(".");   
        if (idx != -1){   
            ext = imgName.substr(idx+1).toUpperCase();   
            ext = ext.toLowerCase( ); 
            if (ext != 'txt'){
                alert("只能上传.txt类型文件"); 
                if (file.outerHTML) {
               	 file.outerHTML = file.outerHTML;
               	   } else { 
               	   file.value = "";
               	}
                return false;  
            }   
        } else {  
          //document.all.submit_upload.disabled=true; 
           alert("只能上传.txt类型的文件!"); 
           if (file.outerHTML) {
        	 file.outerHTML = file.outerHTML;
        	   } else { // FF(包括3.5)
        	   file.value = "";
        	}
           return false;
        } 
        	document.getElementById('textfield1').value=imgName;
}    
function fileChange2(target){  
    //检测上传文件的类型
    var file=document.getElementById("fileField2");
    var imgName =file.value;
    var ext,idx;   
       idx = imgName.lastIndexOf(".");   
       if (idx != -1){   
           ext = imgName.substr(idx+1).toUpperCase();   
           ext = ext.toLowerCase( ); 
           if (ext != 'txt'){
               alert("只能上传.txt类型文件"); 
               if (file.outerHTML) {
              	 file.outerHTML = file.outerHTML;
              	   } else { 
              	   file.value = "";
              	}
               return false;  
           }   
       } else {  
         //document.all.submit_upload.disabled=true; 
          alert("只能上传.txt类型的文件!"); 
          if (file.outerHTML) {
       	 file.outerHTML = file.outerHTML;
       	   } else { // FF(包括3.5)
       	   file.value = "";
       	}
          return false;
       } 
       	document.getElementById('textfield2').value=imgName;
}   
function fileChange3(target){  
    //检测上传文件的类型
    var file=document.getElementById("fileField3");
    var imgName =file.value;
    var ext,idx;   
       idx = imgName.lastIndexOf(".");   
       if (idx != -1){   
           ext = imgName.substr(idx+1).toUpperCase();   
           ext = ext.toLowerCase( ); 
           if (ext != 'txt'){
               alert("只能上传.txt类型文件"); 
               if (file.outerHTML) {
              	 file.outerHTML = file.outerHTML;
              	   } else { 
              	   file.value = "";
              	}
               return false;  
           }   
       } else {  
         //document.all.submit_upload.disabled=true; 
          alert("只能上传.txt类型的文件!"); 
          if (file.outerHTML) {
       	 file.outerHTML = file.outerHTML;
       	   } else { // FF(包括3.5)
       	   file.value = "";
       	}
          return false;
       } 
       	document.getElementById('textfield3').value=imgName;
}    
 

