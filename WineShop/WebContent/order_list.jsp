<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的订单</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
	<c:if test="${!empty orders}">
	<div class="container">
		<div class="row">
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>我的订单</strong>
				<table class="table table-bordered">
					<tbody>
					<c:forEach items="${orders}" var="order">
						<tr class="success">
							<th colspan="5">订单编号：${order.oid}&nbsp&nbsp&nbsp订单时间：${order.ordertime}</th>
						</tr>
						<tr class="warning">
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach items="${order.orderitems}" var="orderitem">
							<tr class="active">
								<td width="60" width="40%"><input type="hidden" name="id"
									value="22"> <img src="${orderitem.product.pimage}" width="70"
									height="60"></td>
								<td width="30%"><a href="${pageContext.request.contextPath}/productinfo.action?pid=${orderitem.product.pid}">${orderitem.product.pname}</a></td>
								<td width="20%">￥${orderitem.product.shopPrice}</td>
								<td width="10%">${orderitem.count}</td>
								<td width="15%"><span class="subtotal">￥${orderitem.subtotal}</span></td>
							</tr>
						</c:forEach>
						<tr class="warning">
							<th colspan="5" style="text-align: right;">总额：${order.total}元</th>
						</tr>
					
						
					</c:forEach>
						
					</tbody>
					
				</table>
			</div>
		</div>	
	</div>
	</c:if>
	
	
	<c:if test="${empty orders}">
			<div align="center" style="padding-bottom:100px;">
				<img alt="" src="${pageContext.request.contextPath}/images/order-empty.gif" style="width:200px;height:200px;" />
				<div>
	            <h2>您暂无订单！</h2>	
	            <a href="${pageContext.request.contextPath}/" class="btn btn-primary btn-shoping J_goShoping">马上去购物</a>
	        	</div>
			</div>
	</c:if>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>
	
</body>

</html>