$(function(){
	//项目计划转跳
	$('#projectPlan').on("click",projectPlan);
	//保存项目计划
	$("#addPlan").on("click",addPrjectPlan);
	//变换到项目进度
//	$("#plan_1").on("click",varyPrjectSchedule);
	//点击项目进度
//	$(".projectPlanClass").on("click",projectPlanClass);
	//重置
	$("#cleanPlan").on("click",function(){
		planReset();
	});
	//重置
	$(".modal-header .close").on("click",function(){
		planReset();
	});
	//总进度
	var all_project_plan;
	debugger
});
var j = 0;
//
function onProjectPlan(i){
	//debugger
	//alert("点击了");
//	var id = $(".projectPlan123132").attr("id");
//	var lenth = id.lastIndexOf("_");
//	var newId = id.substring(lenth+1);
//	console.log(newId);
//	console.log("点击项目进度");
	j++;
	//debugger
	if(j==1){
		$("#truePlan_"+i).show();
		$("#falsePlan_"+i).hide();
		$(".form-control_plan_"+i).val("查看计划进度");
	}else if(j==2){
		$("#truePlan_"+i).hide();
		$("#falsePlan_"+i).show();
		$(".form-control_plan_"+i).val("查看实际进度");
	}
	if(j==2)j=0;
}
//function varyPrjectSchedule(){
//	
//}
/*function MouseOver(obj){
	debugger
	console.log("MouseOver_________"+obj);
	$("#plan_"+obj).hide();
	$("#schedule_"+obj).show();
	
}*/
/*function Mouseout(obj){
	console.log("Mouseout_________"+obj);
	$("#plan_"+obj).show();
	$("#schedule_"+obj).hide();
}*/
function projectPlan(){
	//改为同步请求，不然会先删除再添加
	$.ajaxSettings.async = false;
	//debugger
	//增加上面两条项目名称、项目负责人信息
	viewProject();
	var params ={"fk_project_id" : $("#tBody input[name='projectId']:checked").val()};
	var url="plan/selectPrjectPlan.oo";
	$.post(url,params,function(result){
		//debugger
		var list = result.data;
		console.log("plan/selectPrjectPlan.oo.list"+list);
		for(var j=0;j<list.length;j++){
			console.log(j);
			addPlan();
			var z = j+1;
			$("#planSchedule_"+z).val(list[j].planSchedule);
			$("#projectContent_"+z).val(list[j].projectContent);
			$("#finishTime_"+z).val(list[j].finishTime);
			$("#personLiable_"+z).val(list[j].personLiable);
		}
		//放完之后多一条，删掉
		deletePlan();
	});
	
	/**
	 * 查看实际进度
	 */
	var url="plan/selectTruePrjectPlan.oo";
	$.post(url,params,function(result){
		//debugger
		var list = result.data;
		console.log("plan/selectTruePrjectPlan.oo.list"+list);
		for(var j=0;j<list.length;j++){
			console.log(j);
			//addPlan();
			var z = j+1;
			$("#true_planSchedule_"+z).val(list[j].planSchedule);
			$("#true_projectContent_"+z).val(list[j].projectContent);
			$("#true_finishTime_"+z).val(list[j].finishTime);
			$("#true_timeAdjustment_"+z).val(list[j].timeAdjustment);
		}
		
	});

}
function addPrjectPlan(){
	console.log("===obtainTable2()===")
	//debugger;
//	viewProject();
	//修改状态
	var resultState = true;
	//获取所有计划内容
	var params = getEditFormDataPlan();
	//清空
	//因为既有添加又有编辑所以只能清空之后再全部加入
	var deleteUrl = "plan/deletePrjectPlan.oo";
	$.post(deleteUrl,params[0],function(result){
		//console.log(result.state);
		resultState = false;
		if(result.state==1){
			//alert(result.data);
		}else{		//http://10.10.10.172:6080/arcgis/rest/services
			//alert("删除失败");
			resultState = false;
		}
	});
	
	//输入敏感退出
	if("exception" == params[0])return;
	console.log("addPrjectPlan.oo   ==  params="+JSON.stringify(params))
//	if(params == "exception"){
		//alert("请检查您的输入，不能包含##或&&");
//		return;
//	}
	var addUrl = "plan/addPrjectPlan.oo";
	console.log("===========继续进行了===========");
	$.post(addUrl,params[0],function(result){
		console.log("===============================addPrjectPlan===================================");
		console.log(params[0]);
		//console.log(result.state);
		if(result.state==1){
			//alert(result.data);
			//重置
			planReset();
		}else{		//http://10.10.10.172:6080/arcgis/rest/services
			//alert("添加失败");
			resultState = false;
		}
	});
	//debugger
	/**
	 * 实际项目计划
	 */
	var deleteUrl = "plan/deleteTruePrjectPlan.oo";
	console.log("实际="+JSON.stringify(params[1]));
	$.post(deleteUrl,params[1],function(result){
		console.log("删除实际项目计划");
		console.log(result.state);
		if(result.state==1){
			//alert(result.data);
		}else{		//http://10.10.10.172:6080/arcgis/rest/services
			//alert("删除实际项目失败");
			resultState = false;
		}
	});
//	debugger

	
	//输入敏感退出
//	if("exception" == params[1])return;
//	console.log("params="+JSON.stringify(params))
//	if(params == "exception"){
//		alert("请检查您的输入，不能包含##或&&");
//		return;
//	}
	//添加
	var addTrueUrl = "plan/addTruePrjectPlan.oo";
//	console.log("===========继续进行了===========");
	console.log("实际="+JSON.stringify(params[1]));
	$.post(addTrueUrl,params[1],function(result){
		//console.log("添加实际项目计划");
		//console.log(result.state);
		if(result.state==1){
			//alert(result.data);
		}else{		//http://10.10.10.172:6080/arcgis/rest/services
			//alert("添加实际项目失败");
			resultState = false;
		}
	});
	
	//总进度
	var allPlanUrl = "information/updateAll_planSchedule.oo";
	all_project_plan = params[2];
	console.log("总进度="+params[2]);
	$.post(allPlanUrl,params[2],function(result){
		console.log(result.state);
		if(result.state == 1){
			//alert(result.data);
		}else{		//http://10.10.10.172:6080/arcgis/rest/services
			//alert("删除失败");
			resultState = false;
		}
	});
	if(resultState = true){
		alert("修改完成");
	}else{
		alert("修改失败，请联系管理员");
	}
	if(Number(all_project_plan.all_planSchedule)>=100){
		var onPreservation =  confirm("项目总进度已达100%，是否存档？");
		if(onPreservation == true){
			//不加下面两句话模态框会导致背景变黑
		    $('.modal-backdrop').remove();
		    $('body').removeClass('modal-open');	
			var url="preservation/listUI.oo?t="+Math.random(1000);
			//在类选择器.content的位置异步加载对应的url
			$(".content").load(url);
			return;
		}else{
			alert("好的，下次再进行存档。")
		}
	}
	//因为项目总进度在页面显示所以要刷新一下
	searchProject();

}
//第几阶段计划
var i=1;
//重置
function planReset(){
	$("button[type='reset']").trigger("click");
	for(var j=2;j<=i;j++){
//		console.log("j="+j)
		$(".form-group_"+j).remove();
	}
	i=1;
}

//删除阶段计划
function deletePlan(){
	console.log("删除");
	if(i==1) {return};
	//删除br
	//$("#plan_br_id_"+i).remove();
	//删除主要内容
	$(".form-group_"+i).remove();
	i--;
}


//获取用户填入的数据   -----没问题
function getEditFormDataPlan(){
	debugger
	var format = "";
		var projectId =$("#tBody input[name='projectId']:checked").val();
//		字符串转数字
//		parseInt($("#tBody input[name='projectId']:checked").val());
		var name = $("#projectName_1").val();
		var leadingOffcial = $("#projectLeadingOffcial_1").val();
		var data="";
		var true_data="";
//		var arr = new Array();

	for(var v=1;v<=i;v++){
		//设置未填写默认值
		var newDate = new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-"+new Date().getDate();
		//总进度
		var all_planSchedule = ($("#all_planSchedule").val() == "" || $("#all_planSchedule").val() ==null) ? "0" : $("#all_planSchedule").val();
		//计划进度获取
		var planSchedule = ($("#planSchedule_"+v).val() == "" || $("#planSchedule_"+v).val() ==null) ? "0" : $("#planSchedule_"+v).val();
		var projectContent = ($("#projectContent_"+v).val() == "" || $("#projectContent_"+v).val() ==null) ? "未填写" : $("#projectContent_"+v).val();
		var finishTime = ($("#finishTime_"+v).val() == "" || $("#finishTime_"+v).val() ==null) ? newDate : $("#finishTime_"+v).val();
		var personLiable = ($("#personLiable_"+v).val() == "" || $("#personLiable_"+v).val() ==null) ? "未填写" : $("#personLiable_"+v).val();
		//实际进度获取
		
		//alert("newDate="+newDate);
		var true_planSchedule = ($("#true_planSchedule_"+v).val() == "" || $("#true_planSchedule_"+v).val() ==null) ? "0" : $("#true_planSchedule_"+v).val();
		var true_projectContent = ($("#true_projectContent_"+v).val() == "" || $("#true_projectContent_"+v).val() == null) ? "未填写" : $("#true_projectContent_"+v).val();
		var true_finishTime = ($("#true_finishTime_"+v).val() == "" || $("#true_finishTime_"+v).val() == null) ? newDate : $("#true_finishTime_"+v).val();
		var true_personLiable = ($("#true_timeAdjustment_"+v).val() == "" || $("#true_timeAdjustment_"+v).val() == null) ? "未填写" : $("#true_timeAdjustment_"+v).val();
		if(-1 != projectContent.indexOf("|")
				||-1 != finishTime.indexOf("|")
				||-1 != personLiable.indexOf("|")
				||-1 != projectContent.indexOf("^")
				||-1 != finishTime.indexOf("^")
				||-1 != personLiable.indexOf("^")){
			alert("输入不允许包含^或者|");
//			$("#planModal").attr("id","");
//			$("#projectPlan").onclick();
			return "exception";
		}
		if(isNaN(Number(planSchedule))){
			alert("在计划进度内输入数字")
			return "exception";
		}
		if(Number(planSchedule)>=100){
			planSchedule = '100';
		}
		if(Number(true_planSchedule)>=100){
			true_planSchedule = '100';
		}
		console.log("修改前all_planSchedule="+all_planSchedule)
		if(Number(all_planSchedule)>=100){
			all_planSchedule = '100';
		}
		console.log("修改后all_planSchedule="+all_planSchedule)
//		$("#planModal").attr("id","planModal");
		data += v+"^"+planSchedule+"^"+projectContent+"^"+finishTime+"^"+personLiable+"|";
		true_data += v+"^"+true_planSchedule+"^"+true_projectContent+"^"+true_finishTime+"^"+true_personLiable+"|";
//		arr.push(v+"");
//		arr.push(one);
//		arr.push(two);
//		arr.push(three);
//		var a = {
//			plan:v,
//			content:one,
//			finishTime:two,
//			member:three
//		}
		//formats.push(format);
	}
	console.log("noSubstr="+true_data);
	//截取最后一个|
	var len = data.length-1;
	var true_len = true_data.length-1;
	plan = data.substr(0,len);
	true_plan = true_data.substr(0,true_len);
	console.log("plan="+plan)
	var json = {
			"fk_project_id":projectId,
			"declareProject":name,
			"responsibilityName":leadingOffcial,
			"periodicPlan":plan
	}
	var true_json = {
		"fk_project_id":projectId,
		"declareProject":name,
		"responsibilityName":leadingOffcial,
		"periodicPlan":true_plan
	}
	var on_all_planSchedule = {
		"pk_id":projectId,
		"declareProject":name,
		"all_planSchedule":all_planSchedule
	}
	console.log("json="+JSON.stringify(json));
	console.log("true_json="+JSON.stringify(true_json));
	var allJosn=new Array();
	//计划进度
	allJosn[0]=json;
	//实际进度
	allJosn[1]=true_json;
	//总进度
	allJosn[2]=on_all_planSchedule;
	return allJosn;
}

//添加阶段计划
function addPlan(){
	console.log("============================================i===========================================");
	console.log(i);
	console.log("点击添加阶段计划");
	i++; 
	var addFrom = $("#addFrom");
	var newAdd ='<div class="form-group_'+i+'">'+
					'<h4 >&nbsp; &nbsp;第'+i+'阶段计划</h4>'+
					'<!--<h4 onmouseover="MouseOver('+i+')" id="plan_'+i+'" >&nbsp; &nbsp;第'+i+'阶段计划</h4>-->'+
					'<!--<h4 onmouseout="Mouseout('+i+')" hidden id="schedule_'+i+'" >&nbsp; &nbsp;项目进度</h4>-->'+
					'<div id="falsePlan_'+i+'" >'+
						'<span>'+
						'计划进度:'+
							'<div class="input-group" >'+
								'<input type="text" class="information-false form-control" id="planSchedule_'+i+'" placeholder="请输入计划进度" >'+
								'<div class="input-group-addon" >%</div>'+
							'</div>'+
						'</span>'+
						'<br>'+
						'<span>'+
							'计划内容:'+
							'<input type="text" class="information-false form-control" id="projectContent_'+i+'" ></input>'+
						'</span>'+
						'<br>'+
						'<span>'+
							'完成时间:'+
							'<input type="date" class="information-false form-control required datepickers" id="finishTime_'+i+'" name="finishTime_'+i+'" >'+
						'</span>'+
						'<br>'+
						'<span>'+
							'项目成员:'+
							'<input type="text" class="information-false form-control" id="personLiable_'+i+'" ></input>'+
						'</span>'+
						'<br>'+
					'</div>'+
					'<div id="truePlan_'+i+'"  hidden >'+
						'<span>'+
						'实际进度:'+
							'<span class="input-group" >'+
								'<input type="text" class="form-control" id="true_planSchedule_'+i+'" placeholder="请输入实际进度" >'+
								'<span class="input-group-addon" >%</span>'+
							'</span>'+
						'</span>'+
						'<br>'+
						'<span>'+
							'实际工作：'+
							'<input type="text" class="form-control" id="true_projectContent_'+i+'" ></input>'+
						'</span>'+
						'<br>'+
						'<span>'+
							'实际完成时间:'+
							'<input type="date" class="form-control required datepickers" id="true_finishTime_'+i+'" >'+
						'</span>'+
						'<br>'+
						'<span>'+
							'调整工期理由:'+
							'<input type="text" class="form-control" id="true_timeAdjustment_'+i+'"></input>'+
						'</span>'+
						'<br>'+
					'</div>'+
					'<span>'+
					'<input type="button" class="form-control_plan_'+i+'" onclick="onProjectPlan('+i+');" value="查看实际进度" ></input>'+
					'</span>'+
				'</div>'; 
				//console.log(newAdd);
				//console.log(a)
	//console.log(newAdd);

	addFrom.append(newAdd);
}	
