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
	//具体项目信息
	$("#project_select_project_id").hide();
	//具体过程信息
	$("#planProject_select_project_id").hide();
	//具体存档信息
	$("#preservationProject_select_project_id").hide();
	//项目总结
	$("#preservation_project_summary").hide();
	
//	$("#load-authorityManage-id").hide();
//	$("#editProject").hide();
//	$("#deleteProject").hide();
//	$("#projectPlan").hide();
	//$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();$("#").hide();
	$.post(url,params,function(result){
		console.log(JSON.stringify(result.data));
		var authority = result.data.authority;
		authorityArray = authority.split(",");
		console.log(authorityArray);
		for(i in authorityArray){
			console.log("authorityArray[i]="+authorityArray[i]);
			switch(parseInt(authorityArray[i])){
			case 41://具体项目信息
				$("#project_select_project_id").show();
				break;
			case 42://具体过程信息
				$("#planProject_select_project_id").show();
				break;
			case 43://具体存档信息
				$("#preservationProject_select_project_id").show();
				break;
			case 44://项目总结
				$("#preservation_project_summary").show();
				break;
				
			}
		}
	});

});



//点击搜索按钮
$("#preservationProject-search-button").on("click",selectOneProject);
$("#preservationUsersSarch").on("click",preservationUsersSarch);
$("#preservationScaleSarch").on("click",preservationScaleSarch);
//点击查看项目信息
$("#project_select_project_id").on("click",oneProject);
//点击查看项目过程信息
$("#planProject_select_project_id").on("click",oneProjectPlan);
//点击查看存档项目信息
$("#preservationProject_select_project_id").on("click",onePreservationProject);
//点击项目总结保存按钮
$("#saveProjectSummary").on("click",saveProjectSummary);
//点击查看项目总结
$("#preservation_project_summary").on("click",selectProjectSummary);

function selectProjectSummary(){
	var url = "summary/selectProjectSummary.oo";
	var params ={"fk_project_id" : $("#preservationProject-tbody-id input[name='preservationProject_pk_id']:checked").val()};
	$.post(url,params,function(result){
		console.log("JSON.stringify(rsult.data)="+JSON.stringify(result.data));
		if(result.data == null){
			//0为无项目可以进行添加
			$("#preservationProject_id").attr("preservationProject_i","0");
			return;
		}
		//1，有项目
		$("#preservationProject_id").attr("preservationProject_i","1");
		$("#reviewSuggestion").val(result.data.reviewSuggestion);
		$("#technicalSummary").val(result.data.technicalSummary);
		$("#experience").val(result.data.experience);
		$("#otherSummary").val(result.data.otherSummary);
	});
}
function saveProjectSummary(){
	var params ={
		"fk_project_id" : $("#preservationProject-tbody-id input[name='preservationProject_pk_id']:checked").val(),
		"reviewSuggestion":$("#reviewSuggestion").val(),
		"technicalSummary":$("#technicalSummary").val(),
		"experience":$("#experience").val(),
		"otherSummary":$("#otherSummary").val()
	};
	var url = "summary/addProjectSummary.oo";
	if($("#preservationProject_id").attr("preservationProject_i") == 1){
		url = "summary/updateProjectSummary.oo";
	}

//	if(params.reviewSuggestion != "" &&params.technicalSummary != "" &&params.experience !="" &&params.otherSummary !=""){
//	}
	$.post(url,params,function(result){
		$("#preservationProject_id").attr("preservationProject_i","");
		alert(result.message);
	});
}
function onePreservationProject(){
	console.log("==================点击查看存档项目信息===================");
	var params ={"projectId" : $("#preservationProject-tbody-id input[name='preservationProject_pk_id']:checked").val()};
	var url = "preservation/selectPreservation.oo";
	$.post(url,params,function(result){
		console.log(JSON.stringify(result.data));
		$("#select_preservation-project-name").val(result.data.projectName);
		$("#select_collect_data").val(result.data.collectData);
		$("#select_field_work").val(result.data.fieldWork);
		$("#select_review_data").val(result.data.reviewData);
		$("#select_achievement_type").val(result.data.achievementType);
		$("#preservation_ifAuditing").val(result.data.ifAuditing);
		$("#select_project_agreement").val(result.data.projectAgreement);
		$("#select_project_number").val(result.data.projectNumber);
		$("#select_other_data").val(result.data.otherData);
		$("#select_project_preservation_date").val(result.data.preservationDate);
		$("#select_project_remarks").val(result.data.remarks);
		$("#select_project_sendee").val(result.data.sendee);
	});
}
function oneProjectPlan(){
	var params ={"pk_id" : $("#preservationProject-tbody-id input[name='preservationProject_pk_id']:checked").val()};
	var url = "plan/selectOneProjectPlan.oo";
	
	/**
	 * 查看实际进度
	 */
	var z=1;
	$.post(url,params,function(result){
		debugger
		//增加上面两条项目名称、项目负责人信息
		oneProject();
		
		var list = result.data;
		console.log("list="+JSON.stringify(list));
		
		for(var j=0;j<list.length;j++){
			console.log(j);
			//跟随进度数目添加对应进度数
			
			//z = j+1;
			console.log("====================start==================="+z);
			console.log("list[j].planSchedule="+list[j].planSchedule);
			console.log("list[j].projectContent="+list[j].projectContent);
			console.log("list[j].finishTime="+list[j].finishTime);
			console.log("list[j].timeAdjustment="+list[j].timeAdjustment);
			$("#preservation_planSchedule_"+z).val(list[j].planSchedule);
			$("#preservation_projectContent_"+z).val(list[j].projectContent);
			$("#preservation_finishTime_"+z).val(list[j].finishTime);
			$("#preservation_personLiable_"+z).val(list[j].timeAdjustment);
			console.log("===================end======================"+z);
			addPlan();
		}
		//放完之后多一条，删掉
		//if(i==1) return;
		$(".form-group_"+z).remove();
		//i--;
	});
	//添加阶段计划
	function addPlan(){
		console.log("点击添加阶段计划");
		z++; 
		var addFrom = $("#preservation_add_from");
		var newAdd ='<br><div class="form-group_'+z+'">'+
						'<h4 >&nbsp; &nbsp;第'+z+'阶段计划</h4>'+
						'<!--<h4 onmouseover="MouseOver('+z+')" id="plan_'+z+'" >&nbsp; &nbsp;第'+z+'阶段计划</h4>-->'+
						'<!--<h4 onmouseout="Mouseout('+z+')" hidden id="schedule_'+z+'" >&nbsp; &nbsp;项目进度</h4>-->'+
						'<div>'+
							'<span>'+
							'项目进度:'+
								'<div class="input-group" >'+
									'<input type="text" class="information-false form-control" id="preservation_planSchedule_'+z+'" placeholder="请输入计划进度" >'+
									'<div class="input-group-addon" >%</div>'+
								'</div>'+
							'</span>'+
							'<br>'+
							'<span>'+
								'项目内容:'+
								'<input type="text" class="information-false form-control" id="preservation_projectContent_'+z+'" ></input>'+
							'</span>'+
							'<br>'+
							'<span>'+
								'完成时间:'+
								'<input type="date" class="information-false form-control required datepickers" id="preservation_finishTime_'+z+'" name="finishTime_'+z+'" >'+
							'</span>'+
							'<br>'+
							'<span>'+
								'项目成员:'+
								'<input type="text" class="information-false form-control" id="preservation_personLiable_'+z+'" ></input>'+
							'</span>'+
							'<br>'+
						'</div>'+
					'</div>'; 
					//console.log(newAdd);
					//console.log(a)
		console.log(newAdd);
		addFrom.append(newAdd);
	}	
}
function oneProject(){
	var params ={"pk_id" : $("#preservationProject-tbody-id input[name='preservationProject_pk_id']:checked").val()};
	var url = "information/selectOneProjectInfo.oo";
	$.post(url,params,function(result){
		console.log("JSON.stringify(result)="+JSON.stringify(result));
		console.log("JSON.stringify(result.data.contract)="+JSON.stringify(result.data.contract));
		var data = result.data;
		$("#preservation_declareProject").val(data.declareProject);
		$("#preservation_declareNumber").val(data.declareNumber);
		$("#preservation_declareFraction").val(data.declareFraction);
		$("#preservation_declareScale").val(data.declareScale);
		$("#preservation_declareArrange").val(data.declareArrange);
		$("#preservation_declareAssess").val(data.declareAssess);
		$("#preservation_declareSurveying").val(data.declareSurveying);
		$("#preservation_declarePlan").val(data.declarePlan);
		$("#preservation_contract").val(data.contract);
		$("#preservation_declareCompany").val(data.declareCompany);
		$("#preservation_declareName").val(data.declareName);
		$("#preservation_declarePhone").val(data.declarePhone);
		$("#preservation_finishTime").val(data.finishTime);
		$("#preservation_quality").val(data.quality);
		$("#preservation_Bid").val(data.bid);
		$("#preservation_responsibilityName").val(data.responsibilityName);
		$("#preservation_responsibilityPhone").val(data.responsibilityPhone);
		//项目计划内输入框
		$("#preservation_projectName").val(data.declareProject);
		$("#preservation_projectLeadingOffcial").val(data.responsibilityName);
		$("#preservation_all_planSchedule").val(data.all_planSchedule);
	});
}
//查询项目名称
function selectOneProject(){
	var params = {
			"declareProject" : $("#preservationProject-search-input").val()
	}
	//console.log(preservationProject_search_input);
	var url = "preservationProject/selectPreservationProject.oo";
	$.post(url,params,function(result){
		var tBody = $("#preservationProject-tbody-id");
		//清空
		tBody.empty();
		for(var i=0;i<result.data.length;i++){
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
}
//按照项目规模查询项目
function preservationScaleSarch(){
	var params = {
			"declareScale" : $("#preservationProject-search-input").val()
	}
	//console.log(preservationProject_search_input);
	var url = "preservationProject/selectPreservationProject.oo";
	$.post(url,params,function(result){
		var tBody = $("#preservationProject-tbody-id");
		//清空
		tBody.empty();
		for(var i=0;i<result.data.length;i++){
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
}
//按照项目负责人查询项目
function preservationUsersSarch(){
	var params = {
			"responsibilityName" : $("#preservationProject-search-input").val()
	}
	//console.log(preservationProject_search_input);
	var url = "preservationProject/selectPreservationProject.oo";
	$.post(url,params,function(result){
		var tBody = $("#preservationProject-tbody-id");
		//清空
		tBody.empty();
		for(var i=0;i<result.data.length;i++){
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
}