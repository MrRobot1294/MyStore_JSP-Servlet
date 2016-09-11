<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Personal</title>
<style>
hr {
	border: 2px solid darkslateblue;
}

#submit,#reset,button {
	background-color: orangered;
	color: white;
}

span {
	color: orangered;
	font-weight: bolder;
}
</style>
</head>
<body>
	<h1>个人资料</h1>
	<hr />
	<br />
	<!-- 
		 （仅限修改昵称，密码，邮箱和出生日期）
		 nickname
		 password
		 email
		 birthday
	 -->
	<form action="${pageContext.request.contextPath }/UserServlet" method="post">
		<input type="hidden" name="uid" value="${user.uid }"/>
		用&nbsp;户&nbsp;名： ${user.username }
		<br /> <br />
		昵&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="nickname" value="${user.nickname }">
		<br /><br />
		密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" value="${user.password }">
		<br /><br />
		邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" name="email" value="${user.email }">
		<br /> <br />
		出生日期：<input type="text" name="birthday" value="${user.birthday }">
		<br /><br />
		头像： ${user.headicon }
		<br /><br />
		注册时间： ${user.updatetime }
		<br /><br />
		<%-- <span>请准确填写您的信息，确保货物准确到达</span>
		<br /><br />
		详细地址 <input type="text" style="width: 400px" name="address" value="${address }"><span>*</span>
		<br /><br />
		联系电话 <input type="text" name="tel" value="${tel }"><span>*</span>
		<br /><br />
		 联系QQ&nbsp;&nbsp;&nbsp;<input type="text" name="qq" value="${qq }">
		 <br /><br /> --%>
		<input type="submit" value="保存填写" id="submit">
		<input type="reset" value="撤销重写" id="reset">
	</form>
</body>
</html>