$(function(){
	$(".loginBtn").click(function(){
		var username=$(".username").val();
		var userpass=$(".userpass").val();
		var code=$(".code").val();
		$.ajax({
			data:{
				'username':username,
				'userpass':userpass,
				'code':code
			},
			type:"get",
			dataType:"text",
			url:"servlet/LoginServlet",
			error:function(data){
				alert("系统出错");
				
			},
			success:function(data){
				if(data=="3"){
					alert("验证码错误");
				}else if(data=="1"){
					alert("用户名或密码出错");
				}else{
					if(data=="管理员"){
						window.location.href="allUserServlet";
					}else{
						window.location.href="Welcome.jsp";
					}
				}
				
			}
		});
	});
	$(".modBtn").click(function(){
		var userid=$(".userid").val();
		var username=$(".username").val();
		var userpass=$(".userpass").val();
		var age=$(".age").val();
		var usertype=$(".usertype").val();
		var usersex=$(".usersex").val();
		$.ajax({
			data:{
				'userid':userid,
				'username':username,
				'userpass':userpass,
				'age':age,
				'usertype':usertype,
				'usersex':usersex
			},
			type:"get",
			dataType:"text",
			url:"servlet/ModifyServlet",
			error:function(data){
				alert("系统出错")
			},
			success:function(data){

				if(data=="1"){
					alert("用户名和密码不能为空");
				}else if(data=="2"){
					alert("用户名已被用，请重新填写");
				}else if(data=="4"){
					alert("系统出错，修改失败");
				}else{
					alert("修改成功");
				}
				
			
			}
		});
	});
	$(".regBtn").click(function(){
		var username=$(".username").val();
		var userpass=$(".userpass").val();
		var age=$(".age").val();
		var usertype=$(".usertype").val();
		var usersex=$(".usersex").val();
		$.ajax({
			data:{
				'username':username,
				'userpass':userpass,
				'age':age,
				'usertype':usertype,
				'usersex':usersex
			},
			type:"get",
			dataType:"text",
			url:"servlet/RegServlet",
			error:function(data){
				alert("系统出错")
			},
			success:function(data){

				if(data=="1"){
					alert("用户名和密码不能为空");
				}else if(data=="2"){
					alert("用户名已被用，请重新填写");
				}else if(data=="4"){
					alert("系统出错，注册失败");
				}else{
					alert("注册成功");
				}
				
			
			}
		});
	});
});
