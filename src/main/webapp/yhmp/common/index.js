var theRequest;
//预加载，截取字符
$(document).ready(function(){
	//获取url
	function GetRequest() {   
		   var url = location.search; //获取url中"?"符后的字串   
		   var theRequest1 = new Object();   
		   if (url.indexOf("?") != -1) {   
		      var str = url.substr(1);   
		      strs = str.split("&");   
		      for(var i = 0; i < strs.length; i ++) {   
		         theRequest1[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
		      }   
		   }   
		   return theRequest1;   
		}   
	theRequest = GetRequest();
	console.log("theRequest="+JSON.stringify(theRequest));
	console.log("theRequest.user_id="+theRequest.user_id);
//	$.post("onIndex.oo",function(){
//		console.log("=========回调函数==========");
//	});
	var url="personal/onPersonal.oo";
	var params={"pk_id":theRequest.user_id};
	//全部写完再加权限
	//主页
	$("#index").hide();
	//项目申报
	$("#load-declare-id").hide();
	//项目信息
	$("#Information-id").hide();
	//已存档项目
	$("#PreservationProject-id").hide();
	//人员管理
	$("#load-staffManage-id").hide();
	//操作日志
	$("#user_log_id").hide();
	
	
//	$("#load-authorityManage-id").hide();
//	$("#editProject").hide();
//	$("#deleteProject").hide();
//	$("#projectPlan").hide();
	//$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();
	$.post(url,params,function(result){
		console.log(JSON.stringify(result.data));
		var authority = result.data.authority;
		authorityArray = authority.split(",");
		debugger
		console.log(authorityArray);
		for(var i=0;i<authorityArray.length;i++){
			if(authorityArray[i]==4){
				console.log("=============4============");
			}
			console.log("authorityArray[i]="+authorityArray[i]);
			switch(parseInt(authorityArray[i])){
			case 0://主页
				$("#index").show();
				break;
			case 1://项目申报
				$("#load-declare-id").show();
				break;
			case 2://项目信息
				$("#Information-id").show();
				break;
			case 3:
				break;
			case 4://已存档项目
				console.log("已存档项目===================");
				$("#PreservationProject-id").show();
				break;
			case 5:
				break;
			case 6://人员管理
				$("#load-staffManage-id").show();
				break;
			case 7://操作日志
				$("#user_log_id").show();
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			}
		}
	});
	$("#daoshanjiao").before(theRequest.username);
	$("#iInformation").attr("userid",theRequest.user_id);
	$("#iInformation").attr("username",theRequest.username);

});
//项目管理
//项目查看
$('#Information-id').click(function(){
	console.log("项目管理theRequest="+theRequest);
		console.log("点击了");
		//Information();
		var url="information/listUI.oo?t="+Math.random(1000)+"&user_id="+theRequest.user_id+"&user_name="+theRequest.username;
		//在类选择器.content的位置异步加载对应的url
		$(".content").load(url);
});
$('#index').click(function(){
	console.log("点击主页")
	//刷新当前页，相当于重新加载
	window.location.reload();
});
//点击项目申报
$('#load-declare-id').click(function(){
	console.log("点击了");
	console.log("user_id="+theRequest.user_id);
	var url="declare/listUI.oo?t="+Math.random(1000)+"&user_id="+theRequest.user_id+"&user_name="+theRequest.username;
	//在类选择器.content的位置异步加载对应的url
	$(".content").load(url);
});
//系统管理
//点击人员管理
$('#load-staffManage-id').click(function(){
	console.log("点击人员管理");
	var url="staffManage/listUI.oo?t="+Math.random(1000)+"&user_id="+theRequest.user_id+"&user_name="+theRequest.username;
	//在类选择器.content的位置异步加载对应的url
	$(".content").load(url);
});
//点击已存档项目
$('#PreservationProject-id').click(function(){
	var url="preservationProject/listUI.oo?t="+Math.random(1000)+"&user_id="+theRequest.user_id+"&user_name="+theRequest.username;
	//在类选择器.content的位置异步加载对应的url
	$(".content").load(url);
	var selectUrl = "preservationProject/selectPreservationProject.oo"
	$.post(selectUrl,function(result){
		console.log("result.data="+JSON.stringify(result.data));
		console.log("result.data.length="+result.data.length);
		var tBody = $("#preservationProject-tbody-id");
		//清空
		tBody.empty();
		for(var i=0;i<result.data.length;i++){
			debugger
			console.log("=========");
			console.log("result.data[i].declareNumber="+result.data[i].declareNumber);
			var contract = result.data[i].contract == 1 ? "<td>√</td><td></td>" : "<td></td><td>√</td>";
			var tr = "<tr>"
						+"<td>"
							+"<input type='radio' name='preservationProject_pk_id' value="+result.data[i].pk_id+" >"
						+"</td>"
						+"<td>"
							+result.data[i].declareNumber
						+"</td>"
						+"<td>"
							+result.data[i].declareProject
						+"</td>"
						+"<td>"
							+result.data[i].declareScale
						+"</td>"
						+"<td>"
							+result.data[i].preservation_date
						+"</td>"
						+"<td>"
							+result.data[i].achievement_type
						+"</td>"	
						+"<td>"
						+result.data[i].responsibilityName
						+"</td>"
							+contract
						+"<td>"
							+result.data[i].remarks
						+"</td>"
					"</tr>";
			tBody.append(tr);
		}


		
	});
	
});