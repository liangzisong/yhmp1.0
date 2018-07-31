$(document).ready(function(){
	$("#onLogin").on("click",login);
	console.log("0");
});
$(document).keyup(function (e) {//捕获文档对象的按键弹起事件  
    if (e.keyCode == 13) {//按键信息对象以参数的形式传递进来了  
        //此处编写用户敲回车后的代码  
    	console.log("监听成功");
    	login();
    }  
});  
	function login(){
		console.log("1");
		var params = {
				"username":$("#inputUsername").val(),
				"password":$("#inputPassword").val()	
		}
		var url="onLogin.oo";
		if($("#inputUsername").val() == "" || $("#inputPassword").val() == ""){
			alert("输入用户名或密码");
			return;
		}
		debugger
		console.log("2");
		console.log(params);
		$.post(url,params,function(result){
			if(result.data == "000"){
				alert("用户名或密码错误");
				return;
			}
			console.log("登陆：result="+result);
			//debugger
			console.log("3");
				//debugger 
				//alert("登录成功");
				//debugger;
				//var id = parseInt(result.data.id);
				//console.log()
				
				/*var params_index = {
						"date=":new Date().getTime(),
						"&username=":result.data.username,
						"&user_id=":result.data.pk_id
				}*/
				
				console.log("登陆成功")
				console.log(result.data);	
				window.location.href="http://localhost:8080/yhmp1.0/indexUI.oo" +
						"?date="+new Date().getTime()
						+"&username="+encodeURI(result.data.username)
						+"&user_id="+result.data.pk_id;
				//post请求
				/*httpPost("http://localhost:8080/yhmp1.0/indexUI.oo", params_index);*/
				console.log("转跳后")
				/*var data = {
					"date":new Date().getTime(),
					"id":result.data.id,
					"username":result.data.username,
					"password":result.data.password,
					"job":result.data.job,
					"department":result.data.department
				}
				$.post("http://localhost:8080/yhmp1.0/indexUI.oo",data,function(){
					console.log("转跳成功");
				});*/
				
			
		});
	}

	//发送POST请求转跳到指定页面
	  /*function httpPost(URL, PARAMS) { 
	      var temp_form = document.createElement("form");      
	      temp_form.action = URL;      
	      temp_form.target = "_blank";
	      temp_form.method = "post";      
	      temp_form.style.display = "none"; 
	      for (var x in PARAMS) { 
	        var opt = document.createElement("textarea");      
	          opt.name = x;      
	          opt.value = PARAMS[x];      
	          temp_form .appendChild(opt);      
	      }      
	      document.body.appendChild(temp_form);      
	      temp_form .submit();     
	  } */
