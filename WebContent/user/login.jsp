<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>

  <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <form method="post" action="${pageContext.request.contextPath }/UserServlet">
      	<input type="hidden" name="op" value="login"/>
      	<ul class="left-form">
        <li>
        	${msg.error.username }<br/>
        	<input type="text" name="username" value="${msg.username}" placeholder="用户名">
        </li>
        <li>
        	${msg.error.password }<br/>
        	<input type="password" name="password" value="${msg.password}" placeholder="密码">
        </li>
        </ul>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            记住密码
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="登录"></p>
      </form>
    </div>
  </section>

</body>
</html>
