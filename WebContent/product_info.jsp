<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
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
<script type="text/javascript">
	function addCart(){
		var buyNum = $("#buyNum").val();
		location.href="${pageContext.request.contextPath}/addshopcart.action?pid=${productinfo.pid}&shopprice=${productinfo.shopPrice}&buyNum="+buyNum;
	}
	
</script>
</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div
				style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
				<a href="index.jsp">首页&nbsp;&nbsp;&gt;</a> 
			<!-- 	<a href="./蔬菜分类.htm">蔬菜&nbsp;&nbsp;&gt;</a> -->
				<a href="JavaScript:history.back(-1)">返回</a>
			</div>

			<div style="margin: 0 auto; width: 950px;">
				<div class="col-md-6">
					<img style="opacity: 1; width: 400px; height: 350px;" title=""
						class="medium"
						src="${pageContext.request.contextPath}/${productinfo.pimage}">
				</div>

				<div class="col-md-6">
					<div>
						<strong>${productinfo.pname}</strong>
					</div>
					<div
						style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>编号：${productinfo.pid}</div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						商家价： <strong style="color: #ef0101;">￥${productinfo.shopPrice}元      </strong> &nbsp&nbsp 参考价：
						<del>￥${productinfo.marketPrice}元</del>
					</div>

						<div style="margin: 10px 0 10px 0;">
						促销： <a target="_blank" title="限时抢购"
							><font color="#82D900">限时抢购</font></a>
					</div>
					<br>
					<div
						style="padding: 10px;margin:10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">

						<div
							style="border-bottom: 0px solid #faeac7; margin-top: 20px; padding-left: 10px;">
							购买数量：<input id="buyNum" name="buyNum" value="1"
								maxlength="4" size="8" type="text">
						</div>

						<div style="margin: 20px 0 10px 0;; text-align: center;">
							<a href="javascript:void(0);" onclick="addCart()" > 
							<font color="#CE0000">
							<input style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;" value="加入购物车" type="button" border="none">
							</font>
							</a> &nbsp;收藏商品
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">
				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品介绍</strong>
				</div>
				
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="${pageContext.request.contextPath}/${productinfo.pimage}" height="110px" width="110px">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span style="position:absolute;left:514px;top:620px;">商品名称：${productinfo.pname}</span>
						<span style="position:absolute;left:514px;top:660px;">商品品牌：${productinfo.pvendor}</span>
						<span style="position:absolute;left:700px;top:660px;">商品产地：${productinfo.porigin}</span>
						<span style="position:absolute;left:514px;top:700px;">商品含量：${productinfo.pcontent}</span>	
						<span style="position:absolute;left:700px;top:700px;">酒精度：${productinfo.palcohol}</span>	
						<span style="position:absolute;left:886px;top:660px;">生产日期：${productinfo.pdate}</span>	
				</div>

			<!-- 	<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品参数</strong>
				</div> -->
			
			</div>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>