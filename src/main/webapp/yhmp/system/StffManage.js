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
	
	//查看人员信息
	$("#viewUser").hide();
	//添加人员
	$("#addUser").hide();
	//编辑人员
	$("#editUser").hide();
	//删除人员
	$("#deleteUser").hide();
	//人员授权
	$("#staff_authority_id").attr("if_hide","0");
	$("#staff_authority_id").hide();
//	$("#load-authorityManage-id").hide();
//	$("#editProject").hide();
//	$("#deleteProject").hide();
//	$("#projectPlan").hide();
	//$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();
	//ajax改为同步，不然会出现挺尴尬的画面
	$.ajaxSettings.async = false;
	$.post(url,params,function(result){
		console.log(JSON.stringify(result.data));
		var authority = result.data.authority;
		authorityArray = authority.split(",");
		console.log(authorityArray);
		for(i in authorityArray){
			console.log("authorityArray[i]="+authorityArray[i]);
			switch(parseInt(authorityArray[i])){
				
			case 61://查看人员信息
				$("#viewUser").show();
				break;
			case 62://添加人员
				$("#addUser").show();
				break;
			case 63://编辑人员
				$("#editUser").show();
				break;
			case 64://删除人员
				$("#deleteUser").show();
				break;
			case 65://人员授权
				console.log("拥有授权权限");
				$("#staff_authority_id").attr("if_hide","1");
				$("#staff_authority_id").show();
				break;
			}
		}
	});

});


//查询所有人员
$(function(){
	//查看所有人员
	selectUserAll();
	//查看人员信息
	$("#viewUser").on("click",viewUser);
	//点击添加人员
	$("#addUser").on("click",addUser);
	//编辑人员
	$("#editUser").on("click",editUser);
	//debugger;
	//点击(添加/编辑)保存按钮
	$("#saveUser").on("click",saveUser);
	//点击权限保存按钮
	$("#saveAuthority").on("click",saveAuthority);
	//删除人员
	$("#deleteUser").on("click",deleteUser);
	//点击搜索按钮
	$("#staff-search-button").on("click",selectUserSarch);
	$("#job-search-button").on("click",selectJobSarch);
	$("#department-search-button").on("click",selectDepartmentSarch);
	
	
	
	//清空模态框内容
	$("#cancel").on("click",function(){
		$("button[type='reset']").trigger("click");
	});
	$("#cancel1").on("click",function(){
		$("button[type='reset']").trigger("click");
	});
	
});
//搜索人员
function selectUserSarch(){
	console.log("===搜索人员===");
	var params ={
			"username":$("#staff-search-input").val()
	}
	///console.log("declareProject="+declareProject)
	var url = "staffManage/selectUser.oo";
	$.post(url,params,function(result){
		//debugger;
		console.log(result)
		console.log(result.data.length)
		if(result.data.length == 0){
			alert("未查询到");
			return;
		}
		var tBody = $("#tBody");
		//清空
		tBody.empty();
		console.log(result);
		var list = result.data;
		//debugger;
		for(var i in list){
			var tr = $("<tr></tr>");
			tr.append("<td><input type='radio' name='userId' value="+list[i].pk_id+"></td>");
			tr.append("<td>"+list[i].username+"</td>");
			tr.append("<td>"+list[i].job+"</td>");
			tr.append("<td>"+list[i].department+"</td>");
			tr.append("<td>"+list[i].hiredate+"</td>");
			console.log('$("#staff_authority_id").attr("if_hide")='+$("#staff_authority_id").attr("if_hide"))
			if($("#staff_authority_id").attr("if_hide") == "0"){
				console.log("权限控制进入判断")
				tr.append('<td style="display: none;" ><a data-toggle="modal" data-target="#authorityModal" class="userAuthorityClass" userAuthorityId="'+list[i].pk_id+'" href="#">权限设置</a></td>');
			}else{
				console.log("权限控制没进入判断")
				tr.append('<td ><a data-toggle="modal" data-target="#authorityModal" class="userAuthorityClass" userAuthorityId="'+list[i].pk_id+'" href="#">权限设置</a></td>');
			}
			
			tBody.append(tr);
		}
		//点击权限设置        放在$(function(){});内会导致查询不到类
		$(".userAuthorityClass").on("click",userAuthority);

	});
}
//点击职位搜索人员
function selectJobSarch(){
	console.log("===点击职位搜索人员===");
	var params ={
			"job":$("#staff-search-input").val()
	}
	///console.log("declareProject="+declareProject)
	var url = "staffManage/selectUser.oo";
	$.post(url,params,function(result){
		//debugger;
		console.log(result)
		console.log(result.data.length)
		if(result.data.length == 0){
			alert("未查询到");
			return;
		}
		var tBody = $("#tBody");
		//清空
		tBody.empty();
		console.log(result);
		var list = result.data;
		//debugger;
		for(var i in list){
			var tr = $("<tr></tr>");
			tr.append("<td><input type='radio' name='userId' value="+list[i].pk_id+"></td>");
			tr.append("<td>"+list[i].username+"</td>");
			tr.append("<td>"+list[i].job+"</td>");
			tr.append("<td>"+list[i].department+"</td>");
			tr.append("<td>"+list[i].hiredate+"</td>");
			console.log('$("#staff_authority_id").attr("if_hide")='+$("#staff_authority_id").attr("if_hide"))
			if($("#staff_authority_id").attr("if_hide") == "0"){
				console.log("权限控制进入判断")
				tr.append('<td style="display: none;" ><a data-toggle="modal" data-target="#authorityModal" class="userAuthorityClass" userAuthorityId="'+list[i].pk_id+'" href="#">权限设置</a></td>');
			}else{
				console.log("权限控制没进入判断")
				tr.append('<td ><a data-toggle="modal" data-target="#authorityModal" class="userAuthorityClass" userAuthorityId="'+list[i].pk_id+'" href="#">权限设置</a></td>');
			}
			
			tBody.append(tr);
		}
		//点击权限设置        放在$(function(){});内会导致查询不到类
		$(".userAuthorityClass").on("click",userAuthority);

	});
}
//点击部门搜索人员
function selectDepartmentSarch(){
	console.log("===点击部门搜索人员===");
	var params ={
			"department":$("#staff-search-input").val()
	}
	///console.log("declareProject="+declareProject)
	var url = "staffManage/selectUser.oo";
	$.post(url,params,function(result){
		//debugger;
		console.log(result)
		console.log(result.data.length)
		if(result.data.length == 0){
			alert("未查询到");
			return;
		}
		var tBody = $("#tBody");
		//清空
		tBody.empty();
		console.log(result);
		var list = result.data;
		//debugger;
		for(var i in list){
			var tr = $("<tr></tr>");
			tr.append("<td><input type='radio' name='userId' value="+list[i].pk_id+"></td>");
			tr.append("<td>"+list[i].username+"</td>");
			tr.append("<td>"+list[i].job+"</td>");
			tr.append("<td>"+list[i].department+"</td>");
			tr.append("<td>"+list[i].hiredate+"</td>");
			console.log('$("#staff_authority_id").attr("if_hide")='+$("#staff_authority_id").attr("if_hide"))
			if($("#staff_authority_id").attr("if_hide") == "0"){
				console.log("权限控制进入判断")
				tr.append('<td style="display: none;" ><a data-toggle="modal" data-target="#authorityModal" class="userAuthorityClass" userAuthorityId="'+list[i].pk_id+'" href="#">权限设置</a></td>');
			}else{
				console.log("权限控制没进入判断")
				tr.append('<td ><a data-toggle="modal" data-target="#authorityModal" class="userAuthorityClass" userAuthorityId="'+list[i].pk_id+'" href="#">权限设置</a></td>');
			}
			
			tBody.append(tr);
		}
		//点击权限设置        放在$(function(){});内会导致查询不到类
		$(".userAuthorityClass").on("click",userAuthority);

	});
}
function selectUserAll(){
	var url = "staffManage/selectUser.oo";
	$.post(url,function(result){
		var tBody = $("#tBody");
		//清空
		tBody.empty();
		console.log(result);
		var list = result.data;
		//debugger;
		for(var i in list){
			var tr = $("<tr></tr>");
			tr.append("<td><input type='radio' name='userId' value="+list[i].pk_id+"></td>");
			tr.append("<td>"+list[i].username+"</td>");
			tr.append("<td>"+list[i].job+"</td>");
			tr.append("<td>"+list[i].department+"</td>");
			tr.append("<td>"+list[i].hiredate+"</td>");
			console.log('$("#staff_authority_id").attr("if_hide")='+$("#staff_authority_id").attr("if_hide"))
			if($("#staff_authority_id").attr("if_hide") == "0"){
				console.log("权限控制进入判断")
				tr.append('<td style="display: none;" ><a data-toggle="modal" data-target="#authorityModal" class="userAuthorityClass" userAuthorityId="'+list[i].pk_id+'" href="#">权限设置</a></td>');
			}else{
				console.log("权限控制没进入判断")
				tr.append('<td ><a data-toggle="modal" data-target="#authorityModal" class="userAuthorityClass" userAuthorityId="'+list[i].pk_id+'" href="#">权限设置</a></td>');
			}
			
			tBody.append(tr);
		}
		//点击权限设置        放在$(function(){});内会导致查询不到类
		$(".userAuthorityClass").on("click",userAuthority);
	});
}
//权限用户id
var userAuthorityId;
//查询人员权限
function userAuthority(){
//	debugger;
	console.log("============userAuthorityId============");
	userAuthorityId = $(this).attr("userAuthorityId");
	
	console.log(userAuthorityId);
//	  treeObj.checkNode(treeObj.getNodeByParam("id", "13", null), true, true);
	var url = "staffManage/selectOneUser.oo";
	var params = {
		"pk_id":parseInt(userAuthorityId)
	};
	$.post(url,params,function(result){
		console.log(result);
		console.log(result.data.authority);
		//取消zTree选中状态，清空
		var treeObj = $.fn.zTree.getZTreeObj("authorityTree");
		treeObj.checkAllNodes(false);
		
		var arr=new Array();  
//		var newArr=new Array();  
		arr=result.data.authority.split(',');//注split可以用字符或字符串分割 
		var j = 0;
		for(var i=0;i<arr.length;i++){
			//zTree真神奇
			var node = treeObj.getNodeByParam("id",arr[i]);
			//zTree.cancelSelectedNode();//先取消所有的选中状态
			treeObj.selectNode(node,true);//将指定ID的节点选中
			treeObj.checkNode(node,true);//将指定ID的复选框选中
			treeObj.expandNode(node, true, false);//将指定ID节点展开
			
//			if(arr[i]>10){
//				newArr[j];
//				j++;
//			}
		}

//		for(var i=0;i<arr.length;i++){
//			var treeObj = $.fn.zTree.getZTreeObj("authorityTree");
//			console.log(arr[i]);
//			//设置zTree勾选状态
//			treeObj.checkNode(treeObj.getNodeByParam("pk_id", arr[i]+"", null), false, false);//未完成
//		}
		
		
	//  var nodes = treeObj.getNodes();
	});

}
function viewUser(){
	debugger
	$("#UserModalH4").empty();
	$("#UserModalH4").append("人员信息");
	var params ={"pk_id" : $("#tBody input[name='userId']:checked").val()};
	var params = {
			"pk_id":parseInt($("#tBody input[name='userId']:checked").val()),
			"user_id":theRequest.user_id,
			"user_name":theRequest.username
	}
	console.log("params="+JSON.stringify(params));
	if(params.pk_id == undefined){
		alert("选择人员");
		//没有选择人员消除模态框
		$("#viewUser").attr("data-target","");
		$("#editUser").attr("data-target","");
		return null;
	}
	//选择人员后恢复模态框显示
	$("#viewUser").attr("data-target","#UserModal");
	$("#editUser").attr("data-target","#UserModal");
	var url = "staffManage/selectOneUser.oo";
	//隐藏取消、保存按钮
	$("#cancel").hide();
	$("#saveUser").hide();
	$.post(url,params,function(result){
		var data = result.data;
//		console.log("(data.hiredate).toLocaleString()="+(data.hiredate).toLocaleString());
//		console.log("new Date(data.hiredate)="+new Date(data.hiredate));
//		console.log("data.hiredate="+data.hiredate);
		$("#userName").val(data.username);
		$("#userJob").val(data.job);
		$("#userDepartment").val(data.department);
		$("#userHiredate").val(data.hiredate);
		$("#phone").val(data.phone);
		$("#status").val(data.status);
		$("#domicile").val(data.domicile);
		$("#sex").val(data.sex);
		$("#age").val(data.age);
	});
}
function addUser(){
	//清空用户之前输入的值
	$("#stffManage_reset").trigger("click"); 
	$("#UserModalH4").empty();
	$("#UserModalH4").append("添加人员");
	$("#saveUser").attr("UserState","");
	$("#saveUser").attr("UserState","add");
	//显示取消、保存按钮
	$("#cancel").show();
	$("#saveUser").show();
}
function editUser(){
	//先查询
	viewUser();
	$("#UserModalH4").empty();
	$("#UserModalH4").append("编辑人员");
	$("#saveUser").attr("UserState","");
	$("#saveUser").attr("UserState","edit");
	//显示取消、保存按钮
	$("#cancel").show();
	$("#saveUser").show();
}
function saveUser(){
	var url;
	debugger;
	if($("#saveUser").attr("UserState") == "add"){
		url = "staffManage/addUser.oo";
	}
	if($("#saveUser").attr("UserState") == "edit"){
		
		var id ={"pk_id" : $("#tBody input[name='userId']:checked").val()};
		//console.log("params.id="+params.id);
		if(id.pk_id == undefined){
			alert("选择人员");
			//没有选择人员消除模态框
			$("#editUser").attr("data-target","");
			return;
		}
		console.log("显示模态框");
		//选择人员后恢复模态框显示
		$("#editUser").attr("data-target","#UserModal");
		url = "staffManage/editUser.oo";
	}

	
	//清除
	$("#saveUser").attr("UserState","");
//	//不包含id
	var params = getUser();
//	//合并json，包含id
//	console.log(JSON.stringify(id));
//	console.log("qian")
//	//合并未成功
//	var params = extend({},[id,param]);
//	console.log("hou");
//	console.log(params);
	$.post(url,params,function(result){
		//console.log(result);
		alert(result.message);
		//查看所有人员
		selectUserAll();
	});
	
}
function saveAuthority(){
	//var nodes = $(".checkbox_true_full").next().attr("title");
	console.log("================");
	var id = userAuthorityId;
	console.log(id)
	let ztreeObj = $.fn.zTree.getZTreeObj("authorityTree");
	let list = ztreeObj.getCheckedNodes(true);
	let idArr = [];
	list.map(val => idArr.push(val.id));
	console.log(idArr)
	var url = "authorityManage/saveAuthority.oo";
	var params = {
			"pk_id":id,
			"authority":idArr.toString()
	}
	$.post(url,params,function(result){
		selectUserAll();
		alert(result.message);
	});
	//console.log(zTreeOnClick());
	
}
//function authorityConvert(authority){
//	if(authority=="增加项目")
//}
function deleteUser(){
	//先查询
//	var select = viewUser();
//	if(select == null) return;
	var params = {"pk_id":$("#tBody input[name='userId']:checked").val()};
	//alert(userId);
	var onDelete = confirm("确定删除人员？");
	if(onDelete == false)return;
	var url = "staffManage/deleteUser.oo";
	console.log("userId.id="+params.pk_id);
	$.post(url,params,function(result){
		selectUserAll();
		alert(result.message);
	});
}
function getUser(){
	var data = {
			"pk_id":$("#tBody input[name='userId']:checked").val(),
			"username":$("#userName").val(),
			"job":$("#userJob").val(),
			"department":$("#userDepartment").val(),
			"hiredate":$("#userHiredate").val(),
			"phone":$("#phone").val(),
			"status":parseInt($("#status").val()),
			"sex":parseInt($("#sex").val()),
			"domicile":$("#domicile").val(),
			"age":$("#age").val(),
	}
	return data;
}