//点击提交
$("#preservation-submint").on("click",savePreservation);
function savePreservation(){
	var params = getFromData();
	console.log(params);
	var url="preservation/savePreservation.oo";
	$.post(url,params,function(result){
		alert(result.message);
	});
}
function getFromData(){
	json = {
		"projectId":parseInt($("#preservation-project-name").attr("project-id")),
		"projectName":$("#preservation-project-name").val(),
		"collectData":$("#collect_data").val(),
		"fieldWork":$("#field_work").val(),
		"reviewData":$("#review_data").val(),
		"achievementType": $("input:checkbox[name='achievement_type']:checked").map(function(index,elem) {
	        return $(elem).val();
	    }).get().join(','),
		"ifAuditing":parseInt($('input[name="if_auditing"]:checked ').val()),
		"projectAgreement":parseInt($('input[name="project_agreement"]:checked ').val()),
		"projectNumber":$("#project_number").val(),
		"otherData":$("#other_data").val(),
		"preservationDate":$("#project_preservation_date").val(),
		"sendee":$("#project_sendee").val(),
		"remarks":$("#project_remarks").val()
	}
	return json;
}