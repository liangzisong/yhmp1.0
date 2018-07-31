<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已存档项目</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-2 column">
			</div>
			<div class="col-md-10 column">
				<form class="form-horizontal" role="form">
					<div class="col-lg-6">
		                <div class="input-group">
		                    <input type="text" class="form-control" placeholder="请输入要查询的项目" id="preservationProject-search-input">
		                    <div class="input-group-btn">
		                        <button type="button" class="btn btn-default" tabindex="-1" Id="preservationProject-search-button" >搜索项目
		                        </button>
		                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1">
		                            <span class="caret"></span>
		                            <span class="sr-only">切换下拉菜单</span>
		                        </button>
		                        <ul class="dropdown-menu pull-right">
		                            <li><a href="#" id="preservationUsersSarch" >按负责人搜索</a></li>
		                            <li><a href="#" id="preservationScaleSarch" >按项目规模搜索</a></li>
		                        </ul>
		                    </div><!-- /btn-group -->
		                </div><!-- /input-group -->
		            </div><!-- /.col-lg-6 -->
				</form><br><br>
				<h3>项目存档管理</h3>
				<input type="button" value="查看项目信息" id="project_select_project_id" data-toggle="modal" data-target="#selectOnePreservationProject" class="btn btn-info" > &nbsp &nbsp 
				<input type="button" value="查看项目过程信息" id="planProject_select_project_id" data-toggle="modal" data-target="#selectOnePreservationProjectPlan" class="btn btn-info" > &nbsp &nbsp 
				<input type="button" id="preservationProject_select_project_id" value="查看项目存档信息"  data-toggle="modal" data-target="#selectOnePreservationPreservationProject" class="btn btn-info" > &nbsp &nbsp 
				<input type="button" id="preservation_project_summary" value="项目总结"  data-toggle="modal" data-target="#preservation_project_summary_modal" class="btn btn-info" > &nbsp &nbsp 
				<br><br>
				<table class="table table-hover table-bordered">
					<thead style="background-color: #C0C0C0" >
						<tr>
							<td >
								选择
							</td>
							<td >
								编号
							</td>
							<td colspan="5">
								项目基本概述
							</td>
	                        <td colspan="2">
	                                                                                     合同签订情况
	                        </td>
							<td>
								备注
							</td>						
						</tr>
                        <tr>
                       		<td>
                             
                            </td>
                            <td>
                             
                            </td>
                            <td>
                                                                                                项目名称
                            </td>
                            <td>
                                                                                                  项目规模
                            </td>
                            <td>
                                                                                                   归档时间
                            </td>
                            <td>
                                                                                                  成果资料
                            </td>   
                             <td>
                                                                     项目负责人
                            </td>
                            <td>
                                                                                                  以签订
                            </td>
                            <td>
                                                                                                     未签订
                            </td>
                            <td>
                                
                            </td>
                        </tr>
					</thead>
					<tbody id="preservationProject-tbody-id" >

					</tbody>
				</table>
			</div>
		</div>
	</div>
		<!-- 模态框（Modal） -->
	<div class="modal fade" id="selectOnePreservationProject" tabindex="-1" role="dialog" aria-labelledby="projectModalH4" aria-hidden="true" data-backdrop="static" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="cancel1" >
						&times;
					</button>
					<h4 class="modal-title" >
						已存档项目信息
					</h4>
				</div>
				<div class="modal-body">
				<!-- 开始 -->
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span2">
							</div>
							<div class="span8">
								<form>
									<span>
										项目名称：
										<input type="text" class="form-control" id="preservation_declareProject" ></input>
									</span>
									<br>
									<span>
										项目编号：
										<input type="text" class="form-control" id="preservation_declareNumber"></input>
									</span>
									<br>
									<span>
										项目标准分：
										<input type="text" class="form-control" id="preservation_declareFraction"></input>
									</span>
									<br>
									<span>
										项目规模：
										<input type="text" class="form-control" id="preservation_declareScale"></input>
									</span>
									<br>
									<span>
										项目类型-整理：
										<input type="text" class="form-control" id="preservation_declareArrange"></input>
									</span>
									<br>
									<span>
										项目类型-评估：
										<input type="text" class="form-control" id="preservation_declareAssess"></input>
									</span>
									<br>
									<span>
										项目类型-测绘：
										<input type="text" class="form-control" id="preservation_declareSurveying"></input>
									</span>
									<br>
									<span>
										项目类型-规划：
										<input type="text" class="form-control" id="preservation_declarePlan"></input>
									</span>
									<br>
									<span>
										合同签订情况：
										<select class="form-control" id="preservation_contract" >
											<option value="0">未签订</option>
											<option value="1">已签订</option>
										</select>
									</span>
									<br>
									<span>
										单位名称：
										<input type="text" class="form-control" id="preservation_declareCompany"></input>
									</span>
									<br>
									<span>
										联系人姓名：
										<input type="text" class="form-control" id="preservation_declareName"></input>
									</span>
									<br>
									<span>
										联系人电话：
										<input type="text" class="form-control" id="preservation_declarePhone"></input>
									</span>
									<br>
									<span>
										项目完成时间：
										<input type="date" class="form-control required datepickers" id="preservation_finishTime" name="finishTime1" >
									</span>
									<br>
									<span>
										项目质量要求：
										<select class="form-control" id="preservation_quality" >
											<option value="1">优秀</option>
											<option value="2">良好</option>
											<option value="3">合格</option>
										</select>
									</span>
									<br>
									<span>
										招投标情况：
										<select class="form-control" id="preservation_Bid" >
											<option value="1">需要</option>
											<option value="2">不需要</option>
											<option value="3">暂不确定</option>
										</select>
									</span>
									<br>
									<span>
										负责人姓名：
										<input type="text" class="form-control" id="preservation_responsibilityName"></input>
									</span>
									<br>
									<span>
										负责人电话：
										<input type="text" class="form-control" id="preservation_responsibilityPhone" ></input>
									</span>
									<br>
									<button type="reset" style="display: none;" ></button>
								</form>
							</div>
							<div class="span2">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
		<!-- 项目进度模态框 -->
	<div class="modal fade" id="selectOnePreservationProjectPlan" tabindex="-1" role="dialog" aria-labelledby="planModalH4" aria-hidden="true" data-backdrop="static" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="cancel1" >
						&times;
					</button>
					<h4 class="modal-title">
						项目工作计划
					</h4>
				</div>
				<div class="modal-body">
				<!-- 开始 -->
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span2">
							</div>
							<div class="span8">
								<form class="form-group" id="preservation_add_from" >
									<span>
									项目名称：
									<input type="text" class="form-control" id="preservation_projectName" disabled="disabled"></input>
									</span>
									<br>
									<span>
									项目负责人:
									<input type="text" class="form-control" id="preservation_projectLeadingOffcial" disabled="disabled"></input>
									</span>
									<br>
									<span>
									总进度 
									<span class="input-group" >
										<input type="text" class="form-control" id="preservation_all_planSchedule" placeholder="请输入项目总进度" >
										<span class="input-group-addon" >%</span>
									</span>
									</span>
									<br>
									<div class="form-group_1">
										<h4 >&nbsp; &nbsp;第1阶段计划</h4>
										<!-- <h4 onmouseout="Mouseout(1)" hidden onclick="onProjectPlan(1)" >&nbsp; &nbsp;项目进度</h4> -->
										<div id="preservation_falsePlan_1" >
											<span>
											项目进度:
												<span class="input-group" >
													<input type="text" class="form-control" id="preservation_planSchedule_1" placeholder="请输入计划进度" >
													<span class="input-group-addon" >%</span>
												</span>
											</span>
											<br>
											<span>
											项目内容:
											<input type="text" class="form-control" id="preservation_projectContent_1" ></input>
											</span>
											<br>
											<span>
											完成时间:
											<input type="date" class="form-control required datepickers" id="preservation_finishTime_1" name="finishTime_1" >
											</span>
											<br>
											<span>
											项目成员:
											<input type="text" class="form-control" id="preservation_personLiable_1" ></input>
											</span>
											<br>
										</div>
									</div>
									<br>
								</form>
							</div>
							<div class="span2">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	       <!-- 模态框（Modal） -->
    <div class="modal fade" id="selectOnePreservationPreservationProject" tabindex="-1" role="dialog" aria-labelledby="projectModalH4" aria-hidden="true" data-backdrop="static" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="cancel1" >
                        &times;
                    </button>
                    <h4 class="modal-title" >
                                                                项目已存档信息
                    </h4>
                </div>
                <div class="modal-body">
                <!-- 开始 -->
                    <div class="container-fluid">
                        <div class="row-fluid">
                            <div class="span2">
                            </div>
                            <div class="span8">
			                <form class="form-horizontal " role="form">
	                            <span>
	                                                                                                                            项目名称：
	                                <input type="text" class="form-control" id="select_preservation-project-name"></input>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                            项目搜集资料：
	                                <input type="text" class="form-control" id="select_collect_data"></input>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                            外业调查资料：
	                                <input type="text" class="form-control" id="select_field_work"></input>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                            项目评审资料：
	                                <input type="text" class="form-control" id="select_review_data"></input>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                            项目成果资料：
	                                <input type="text" class="form-control" id="select_achievement_type"></input>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                   项目是否审核：
	                            <!-- <label for="nameId" class="col-sm-2 control-label" >项目是否审核：</label> 
	                            <input type="radio" name="select_if_auditing" value="1">已审核
	                            <input type="radio" name="select_if_auditing" value="0" >未审核 -->
	                            <select class="form-control" id="preservation_ifAuditing" >
	                                <option value="0">未审核</option>
	                                <option value="1">已审核</option>
	                            </select>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                项目协议书
	                            <!-- <label for="nameId" class="col-sm-2 control-label" >项目协议书：</label>
	                            <input type="radio" name="select_project_agreement" value="1">具备
	                            <input type="radio" name="select_project_agreement" value="0" >不具备 -->
	                            <select class="form-control" id="select_project_agreement" >
	                                <option value="0">不具备</option>
	                                <option value="1">具备</option>
	                            </select>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                           协议书编号：
	                                <input type="text" class="form-control" id="select_project_number"></input>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                           其他资料：
	                                <input type="text" class="form-control" id="select_other_data"></input>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                           归档日期：
	                                <input type="date" class="form-control required datepicker" id="select_project_preservation_date" >
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                           备注：
	                                <input type="text" class="form-control" id="select_project_remarks"></input>
	                            </span>
	                            <br>
	                            <span>
	                                                                                                                           接收人：
	                                <input type="text" class="form-control" id="select_project_sendee"></input>
	                            </span>
	                            <br>
			            </form>
                            </div>
                            <div class="span2">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
            <!-- 模态框（Modal） -->
    <div class="modal fade" id="preservation_project_summary_modal" tabindex="-1" role="dialog" aria-labelledby="projectModalH4" aria-hidden="true" data-backdrop="static" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="cancel1" >
                        &times;
                    </button>
                    <h4 class="modal-title" id="preservationProject_id" >
                                                 项目总结
                    </h4>
                </div>
                <div class="modal-body">
                <!-- 开始 -->
                    <div class="container-fluid">
                        <div class="row-fluid">
                            <div class="span2">
                            </div>
                            <div class="span8">
                                <form>
                                    <span>
                                                                                                                                          评审会意见摘要：
                                        <input type="text" class="form-control" id="reviewSuggestion" ></input>
                                    </span>
                                    <br>
                                    <span>
                                                                                                                             项目技术总结：
                                        <input type="text" class="form-control" id="technicalSummary"></input>
                                    </span>
                                    <br>
                                    <span>
                                                                                                                              经验与教训：
                                        <input type="text" class="form-control" id="experience"></input>
                                    </span>
                                    <br>
                                    <span>
                                                                                                                             其他：
                                        <input type="text" class="form-control" id="otherSummary"></input>
                                    </span>
                                    <br>
                                    <button type="reset" style="display: none;" ></button>
                                </form>
                            </div>
                            <div class="span2">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="cancelProjectSummary" >
                                                        取消
                    </button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="saveProjectSummary" >
                                                       保存
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
	   <script type="text/javascript" src="${basePath }/yhmp/product/preservationProject.js" ></script>
</body>
</html>