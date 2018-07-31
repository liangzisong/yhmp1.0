<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存档表</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-2 column">
			</div>
			<div class="col-md-8 column">
				<h3 class="text-center">
					项目存档表
				</h3>
				<form class="form-horizontal " role="form">
					<div class="form-group">
						 <label for="nameId" class="col-sm-2 control-label ">项目名称：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="preservation-project-name" disabled="disabled" />
						</div>
					</div>
					<div class="form-group">
						 <label for="nameId" class="col-sm-2 control-label " >项目搜集资料：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="collect_data" />
						</div>
					</div>
					<div class="form-group text-left">
						<label for="nameId" class="col-sm-2 control-label ">外业调查资料:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control required" id="field_work" >
						</div>
					</div>
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label">项目评审资料：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control required" id="review_data" >
						</div>
					</div>
					
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label">项目成果资料：</label>
						<!-- 项目类型选项卡 -->
						<label class="checkbox-inline"> 
						<input type="checkbox" id="inlineCheckbox1" value="报告" name="achievement_type"> 报告
						</label> <label class="checkbox-inline"> 
						<input type="checkbox" value="预算书" name="achievement_type"> 预算书
						</label> <label class="checkbox-inline"> 
						<input type="checkbox"  value="图件" name="achievement_type"> 图件
						</label> <label class="checkbox-inline"> 
						<input type="checkbox" value="电子光盘" name="achievement_type">
							电子光盘
						</label>
					</div>
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label" >项目是否审核：</label> 
						<input type="radio" name="if_auditing" value="1">已审核
						<input type="radio" name="if_auditing" value="0" >未审核
					</div>
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label" >项目协议书：</label>
						<input type="radio" name="project_agreement" value="1">具备
						<input type="radio" name="project_agreement" value="0" >不具备
					</div>
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label">协议书编号：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control required" id="project_number">
						</div>
					</div>
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label">其他资料：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control required" id="other_data" >
						</div>
					</div>
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label ">归档日期:</label>
						<div class="col-sm-10">
								<input type="date" class="form-control required datepicker" id="project_preservation_date" >
						</div>
					</div>
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label ">备注:</label>
						<div class="col-sm-10">
								<input type="text" class="form-control required" id="project_remarks" >
						</div>
					</div>
					<div class="form-group">
						<label for="nameId" class="col-sm-2 control-label">接收人：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control required" id="project_sendee" >
						</div>
					</div>
					<div class="col-md-9 column">
						<div class="row clearfix">
							<div class="col-md-3 column"></div>
							<div class="col-md-9 column">
								<br>
								<br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn btn-default" id="preservation-submint">提交</button>
							</div>
						</div>
					</div>
			</form>
			</div>
			<div class="col-md-2 column">
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
//项目计划js内的id与项目名称
$("#preservation-project-name").val(all_project_plan.declareProject);
$("#preservation-project-name").attr("project-id",all_project_plan.pk_id);
</script>
	<script type="text/javascript" src="${basePath }/yhmp/product/preservation.js" ></script>
</html>