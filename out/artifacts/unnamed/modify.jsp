<%@page import="model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户管理</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<% User user=(User)request.getAttribute("user");%>
<body>
	<center>
		<div id="content">
			
			
			<div class="header">修改信息</div>
				<input type="hidden" class="userid" value="<%=user.getUserid() %>">
				<table width="100%" height="330px">
					<tr>
						<td width="150px" style="text-align: right;">用户名:</td>
						<td><input type="text" class="username" name="username" value="<%=user.getUsername()%>"></td>
					</tr>
					<tr>
						<td width="150px" style="text-align: right;">密&nbsp;码:</td>
						<td><input type="text" class="userpass" name="userpass" value="<%=user.getUserpass()%>"></td>
					</tr>
					<tr>
					<td width="150px" style="text-align: right;">年&nbsp;龄:</td>
					<td><select name="age" class="age" >
					<option value="<%=user.getAge()%>"><%=user.getAge()%>
					<option value="1">1<option value="2">2<option value="3">3<option value="4">4<option value="5">5
					<option value="6">6<option value="7">7<option value="8">8<option value="9">9<option value="10">10
					<option value="11">11<option value="12">12<option value="13">13<option value="14">14<option value="15">15
					<option value="16">16<option value="17">17<option value="18">18<option value="19">19<option value="20">20
					<option value="21">21<option value="22">22<option value="23">23<option value="24">24<option value="25">25
					<option value="26">26<option value="27">27<option value="28">28<option value="29">29<option value="30">30
					<option value="31">31<option value="32">32<option value="33">33<option value="34">34<option value="35">35
					<option value="36">36<option value="37">37<option value="38">38<option value="39">39<option value="40">40
					<option value="41">41<option value="42">42<option value="43">43<option value="44">44<option value="45">45
					<option value="46">46<option value="47">47<option value="48">48<option value="49">49<option value="50">50
					<option value="51">51<option value="52">52<option value="53">53<option value="54">54<option value="55">55
					<option value="56">56<option value="57">57<option value="58">58<option value="59">59<option value="60">60
					
					</select></td>
					</tr>
					<tr>
					<td width="150px" style="text-align: right;">类&nbsp;型:</td>
					<td><input name="usertype" class="usertype" value="<%=user.getType()%>" readonly="readonly">
					</td>
					</tr>
					<tr>
					<td width="150px" style="text-align: right;">性&nbsp;别:</td>
					<td><select name="usersex" class="usersex" >
					<option value="男">男<option value="女">女
					</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="修改&gt;"
							class="modBtn"></td>
					</tr>
				</table>
			
		</div>
	</center>
</body>
</html>
