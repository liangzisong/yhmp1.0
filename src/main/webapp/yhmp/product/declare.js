$(function(){
	$("#table1-submit").on("click",obtainTable1);
	selectUser();
});


function obtainTable1(){
	var params = getEditFormDataDeclare();
	console.log(params);
	var url = "declare/disposeSubmit.oo";
	$.post(url,params,function(result){
		console.log("++++++++回调函数+++++++++");
		alert(result.message);
	});
}
function getEditFormDataDeclare(){
	var fullDate = $("#declare-finishTime").val().split("-"); 
	var data = {
			"declareProject":$("#declareProject").val(),
			"declareNumber":$("#declareNumber").val(),
			"declareFraction":$("#declareFraction").val(),
			"declareScale":$("#declareScale").val(),
			"declareArrange":$("#declareArrange").val(),
			"declareAssess":$("#declareAssess").val(),
			"declareSurveying":$("#declareSurveying").val(),
			"declarePlan":$("#declarePlan").val(),
			"contract":($("#contract input[name='contract']:checked").val() =="已签订") ? 1 : 0,
			"declareCompany":$("#declareCompany").val(),
			"declareName":$("#declareName").val(),
			"declarePhone":$("#declarePhone").val(),
			//"declare":new Date(fullDate[0], fullDate[1]-1, fullDate[2]),
			"finishTime":$("#declare-finishTime").val(),
			"quality":($("#quality input[name='quality']:checked").val() == "优秀") ? 1 : 
				($("#quality input[name='quality']:checked").val() == "良好") ? 2 : 3,
			"bid":($("#Bid input[name='Bid']:checked").val() == "需要") ? 1 : 
				($("#Bid input[name='Bid']:checked").val() == "不需要") ? 2 : 3,
			"responsibilityName":$("#responsibilityName").val(),
			"responsibilityPhone":$("#responsibilityPhone").val()
	}
	return data;
}
function selectUser(){
	var url = "staffManage/selectUser.oo";
	$.post(url,function(result){
		console.log("++++++++回调函数+++++++++");
		//alert(result.message);
		console.log(result.data);
		var select = $("#responsibilityName");
		for(var v=0;v<result.data.length;v++){
			select.append("<option>"+result.data[v].username+"</option>");
		}
		//select.append();
	});
}