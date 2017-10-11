<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户管理</title>

<script type="text/javascript"> 
	 function refresh(obj) {        
	    obj.src = "${pageContext.request.contextPath }/servlet/ImageCodeMakerServlet?"+Math.random();    
	 }    
 </script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>

<body>
	<center>
		<div id="content">
			<div class="position">
				位置&nbsp;&gt;&nbsp;<span class="mainPos">登录</span>&nbsp;&nbsp;<a
					href="reg.jsp">注册</a>
			</div>
			<div class="header">用户登录</div>
			
				<table width="100%" height="330px">
					<tr>
						<td width="150px" style="text-align: right;">用户名:</td>
						<td><input type="text" class="username" name="username"></td>
					</tr>
					<tr>
						<td width="150px" style="text-align: right;">密&nbsp;码:</td>
						<td><input type="text" class="userpass" name="userpass"></td>
					</tr>
					<tr>
						<td width="150px" style="text-align: right;">验证码:</td>
						<td><input type="text" name="code" class="code" value=""
							size="12" style="display: block;float: left;" /> <img
							src="${pageContext.request.contextPath }/servlet/ImageCodeMakerServlet"
							width="100px"
							style="display: block;float: left;margin-left: 20px;"
							onclick="refresh(this);" /> 点击图片刷新</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="登录&gt;"
							class="loginBtn"></td>
					</tr>
				</table>
			
		</div>
	</center>
</body>
</html>
