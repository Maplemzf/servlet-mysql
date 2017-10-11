<%@page import="model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	 table,td{
	 border:1px solid blue;
	 }
	</style>
  </head>
  
  <body>
  <center>
   <table width="800px" cellpadding="0" cellspacing="0">
   	<tr style="background: pink;"><th>用户名</th><th>性别</th><th>年龄</th><th>类别</th><th>删除</th></tr>
   	<% List<User> allUser=(List<User>)request.getAttribute("allUser");
   	    for(User user:allUser){
   	 %>
   	 <tr>
   	 <td><%=user.getUsername() %></td><td><%=user.getUsersex() %></td><td><%=user.getAge() %></td>
   	 <td><%=user.getType() %></td>
   	 <td>
   	 <% String currenName=(String)session.getAttribute("username");
   	 if(!currenName.equals(user.getUsername())){
   	  %>
   	 <a href="deleteServlet?id=<%=user.getUserid() %>">删除</a></td>
   	 <%} %>
   	 </tr>
   	 <%
   	 }
   	  %>
   </table>
   <a href="getUserMes?username=<%=session.getAttribute("username") %>">修改个人信息</a>
   </center>
  </body>
</html>
