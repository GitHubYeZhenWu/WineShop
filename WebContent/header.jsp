<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid" >
	<div class="col-md-4">
		<img src="img/logo.gif" width="200px" height="80px" />
	</div>
	<div class="col-md-5" style="padding-top:10px;">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:30px;padding-left:80px;">
			<ol class="list-inline">
			<c:if test="${empty user}">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
		    </c:if>
			<c:if test="${!empty user}">
				<li><a href="javascript:void(0);">${user.username}</a></li>
				<li><a href="${pageContext.request.contextPath}/logout.action">退出</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath}/showshopcart.action">购物车</a></li>
			<li><a href="${pageContext.request.contextPath}/showorders.action">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid" style="padding-left:10px;margin-left:0px;">
	<nav class="navbar navbar-inverse" style="background:#930000;border:0px;border-radius:5px;"  >

		<div class="container-fluid">
			<div class="navbar-header" >
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"><font color="#F0F0F0">首页</font></a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="category">
				
				</ul>
				<form class="navbar-form navbar-right" role="search" method="post" action="${pageContext.request.contextPath}/searchProduct.action">
					<div class="form-group">
						<input type="text" class="form-control" id="keyword" name="keyword" placeholder="红酒">
					</div>
					<button type="submit" class="btn btn-default"><font color="#6C6C6C">寻找</font></button>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				var content ="";
				$.post(
					"${pageContext.request.contextPath}/category.action",
					function(data){
						for(var i =0;i<data.length;i++){
							content+="<li><a href='${pageContext.request.contextPath}/productlist.action?cid="+data[i].cid+"' style='color:	#F0F0F0;'>"+data[i].cname+"</a></li>"
						}
						$("#category").html(content);
					},
					"json"
				);
			});
		</script>
	</nav>
</div>