<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyOrders</title>
</head>
<body>
	<center>
	<h2>我所有的订单</h2>
	<table border="1" width="700">
		<tr>
			<td>订单号</td>
			<td>下单时间</td>
			<td>订单总金额</td>
			<td>订单状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${orders }" var="order" >
			<tr>
				<td>${order.oid }</td>
				<td>${order.ordertime }</td>
				<td>${order.money }</td>
				<td>
					<c:if test="${order.state == 0}">订单已取消</c:if>
					<c:if test="${order.state == 1}">已下单</c:if>
					<c:if test="${order.state == 2}">已支付</c:if>
					<c:if test="${order.state == 3}">已发货</c:if>
				</td>
				<td>
					<c:if test="${order.state == 1}"><a href="${pageContext.request.contextPath }/OrderServlet?op=delOrder&oid=${order.oid}&state=0">取消订单</a></c:if>
				</td>
			</tr>			
		</c:forEach>
	</table>
	</center>
</body>
</html>