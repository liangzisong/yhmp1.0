<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
    <link href="${basePath}/css/templatemo_style.css" rel="stylesheet" />
    <link href="${basePath}/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${basePath}/css/font-awesome.min.css" rel="stylesheet" />
    <link href="${basePath}/css/bootstrap-theme.min.css" rel="stylesheet" />
<style type="text/css">
    body {                                



       /*  background: url("${basePath}/img/login.jpg") no-repeat;
background-position: center;
background-repeat: no-repeat;
background-attachment: fixed; */

    }                   
</style>    
	<script type="text/javascript" src="${basePath}/js/jquery.min.js" ></script>
</head>
<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">Hello，欢迎登录</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="#" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	用户名：&nbsp;&nbsp;&nbsp;<br>
		            	<input type="text" class="form-control" id="inputUsername" placeholder="Username">
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	密码：&nbsp;&nbsp;&nbsp;<br>
		            	<input type="password" class="form-control" id="inputPassword" placeholder="Password">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
	             	<div class="checkbox control-wrapper">
	                	<label>
	                  		<input type="checkbox"> 记住我
                		</label>
	              	</div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="button" value="登陆" class="btn btn-info" id="onLogin">
		          		<a class="text-right pull-right" onclick="alert('请联系管理员！')" >忘记密码?</a>
		          	</div>
		          </div>
		        </div>
		        <hr>
		        <div class="form-group">
		        	<div class="col-md-12">
		        		<label>友情链接: </label><br>
		        		<div class="inline-block">
		        			<a href="http://web2.qq.com/">QQ&nbsp;&nbsp;</i></a>
			        		<a href="https://wx.qq.com/">微信&nbsp;&nbsp;</a>
			        		<a href="https://www.baidu.com/">百度&nbsp;&nbsp;</a>
			        		<a href="https://mail.163.com/">网易邮箱&nbsp;&nbsp;</a>
			        		<a href="http://www.weather.com.cn/html/province/shandong.shtml">山东天气</a>
		        		</div>		        		
		        	</div>
		        </div>
		      </form>
		      <div class="text-center">
		      	<a onclick="alert('请联系管理员！')" class="templatemo-create-new">创建一个账号</a>	
		      </div>
		</div>
	</div>
	<script type="text/javascript" src="${basePath}/yhmp/common/login.js"></script>
	   <!-- 公共方法 -->
    <script type="text/javascript" src="${basePath}/yhmp/common/common.js" ></script>
</body>

</html>