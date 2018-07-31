<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
			<form class="form-horizontal" role="form">
					<div class="col-lg-6">
		                <div class="input-group">
		                    <input type="text" class="form-control" placeholder="请输入要查询的项目" id="staff-search-input">
		                    <div class="input-group-btn">
		                        <button type="button" class="btn btn-default" tabindex="-1" id="staff-search-button" >搜索人员
		                        </button>
		                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1">
		                            <span class="caret"></span>
		                            <span class="sr-only">切换下拉菜单</span>
		                        </button>
		                        <ul class="dropdown-menu pull-right">
		                            <li><a href="#" id="job-search-button" >按职位搜索</a></li>
		                            <li><a href="#" id="department-search-button" >按部门搜索</a></li>
		                        </ul>
		                    </div><!-- /btn-group -->
		                </div><!-- /input-group -->
		            </div><!-- /.col-lg-6 -->
				</form><br><br>
				<h3>
					个人信息
				</h3>
				<input type="button" value="查看" id="viewUser" data-toggle="modal" data-target="#UserModal" class="btn btn-info"> &nbsp &nbsp 
				<input type="button" value="添加" id="addUser" data-toggle="modal" data-target="#UserModal" class="btn btn-info"> &nbsp &nbsp 
				<input type="button" value="编辑" id="editUser" data-toggle="modal" data-target="#UserModal" class="btn btn-info"> &nbsp &nbsp 
				<input type="button" value="删除" id="deleteUser" class="btn btn-info"> &nbsp &nbsp 
				<br/>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>
								选择
							</th>
							<th>
								名称
							</th>
							<th>
								职位
							</th>
							<th>
								部门
							</th>
							<th>
								入职时间
							</th>
							<th id="staff_authority_id" >
								权限设置
							</th>
						</tr>
					</thead>
					<!-- 动态填充 -->
					<tbody id="tBody">
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
		<!-- 权限管理模态框（Modal） -->
	<div class="modal fade" id="authorityModal" tabindex="-1" role="dialog" aria-labelledby="authorityModalH4" aria-hidden="true" data-backdrop="static" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" id="cancelAuthority1" data-dismiss="modal" aria-hidden="true" >
						&times;
					</button>
					<h4 class="modal-title">
						权限管理
					</h4>
				</div>
				<div class="modal-body">
				<!-- 开始 -->
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span2">
							</div>
							<div class="span8">
								<div class="content_wrap">
									<div class="authorityBackground left">
										<ul id="authorityTree" class="ztree"></ul>
									</div>
								</div>
								<div class="span2">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="cancelAuthority" >
							取消
						</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="saveAuthority" >
							保存
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
	</div>
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="UserModal" tabindex="-1" role="dialog" aria-labelledby="UserModalH4" aria-hidden="true" data-backdrop="static" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="cancel1" >
						&times;
					</button>
					<h4 class="modal-title" id=UserModalH4>
						个人信息
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
										账号：
										<input type="text" class="form-control" id="userName" ></input>
									</span>
									<br>
									<span>
										职位：
										<input type="text" class="form-control" id="userJob"></input>
									</span>
									<br>
									<span>
										部门：
										<input type="text" class="form-control" id="userDepartment"></input>
									</span>
									<br>
									<span>
										入职时间：
										<input type="date" class="form-control required datepickers" id="userHiredate" name="finishTime1" >
									</span>
									<br>
									<span>
										个人手机：
										<input type="text" class="form-control" id="phone"></input>
									</span>
									<br>
									<span>
										入职状态：
										<select class="form-control" id="status" >
											<option value="0">实习</option>
											<option value="1">在职</option>
											<option value="2">离职</option>
										</select>
									</span>
									<br>
									<span>
										居住地：
										<input type="text" class="form-control" id="domicile" ></input>
									</span>
									<br>
									<span>
										性别：
										<select class="form-control" id="sex" >
											<option value="1">男</option>
											<option value="0">女</option>
										</select>
									</span>
									<br>
									<span>
										年龄：
										<input type="text" class="form-control" id="age" ></input>
									</span>
									<br>
									<button type="reset" style="display: none;" id="stffManage_reset" ></button>
								</form>
							</div>
							<div class="span2">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="cancel" >
						取消
					</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="saveUser" >
						保存
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	<!-- tree追加数据 -->
<script type="text/javascript" src="${basePath }/yhmp/system/StffManage.js" ></script>
	<SCRIPT type="text/javascript">
		//<!--
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			/* callback: {
				onClick: zTreeOnClick
			} */
			view:{
				showLine: false
			},
			callback: { 
				onClick: function (e, treeId, treeNode, clickFlag) { 
					$.fn.zTree.getZTreeObj("authorityTree").checkNode(treeNode, !treeNode.checked, true); 
				} 
				} 
		};

		var zNodes =[
			{ id:0, pId:0, name:"山东元鸿", open:true, iconOpen:"${basePath}/css/zTree/zTreeStyle/img/diy/1_open.png", iconClose:"${basePath}/css/zTree/zTreeStyle/img/diy/1_close.png"},
			{ id:1, pId:0, name:"项目申报", open:true, iconOpen:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png", iconClose:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png"},
			
			{ id:2, pId:0, name:"项目信息", open:true, iconOpen:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png", iconClose:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png"},
			{ id:21, pId:2, name:"具体项目信息查看", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:22, pId:2, name:"项目编辑", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:23, pId:2, name:"项目删除", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:24, pId:2, name:"项目计划/进度", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			
			/* { id:3, pId:0, name:"已完成项目", open:true, iconOpen:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png", iconClose:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png"},
			{ id:15, pId:3, name:"项目审核", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:16, pId:3, name:"项目评价", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:17, pId:3, name:"项目总结", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:18, pId:3, name:"项目计分", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"}, */
			
			{ id:4, pId:0, name:"已存档项目", open:true, iconOpen:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png", iconClose:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png"},
			{ id:41, pId:4, name:"具体项目信息", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:42, pId:4, name:"具体过程信息", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:43, pId:4, name:"具体存档信息", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:44, pId:4, name:"项目总结", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			
			/* { id:5, pId:0, name:"统计日志", open:true, iconOpen:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png", iconClose:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png"},
			{ id:51, pId:5, name:"统计日志查看", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"}, */
			
			{ id:6, pId:0, name:"人员管理", open:true, iconOpen:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png", iconClose:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png"},
			{ id:61, pId:6, name:"查看人员信息", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:62, pId:6, name:"添加人员", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:63, pId:6, name:"编辑人员", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:64, pId:6, name:"删除人员", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			{ id:65, pId:6, name:"人员授权", icon:"${basePath}/css/zTree/zTreeStyle/img/diy/2.png"},
			
			{ id:7, pId:0, name:"操作日志", open:true, iconOpen:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png", iconClose:"${basePath}/css/zTree/zTreeStyle/img/diy/3.png"}
		];
		
		
		$(document).ready(function(){
			$.fn.zTree.init($("#authorityTree"), setting, zNodes);
		});
		//-->
	</SCRIPT>
</body>
</html>