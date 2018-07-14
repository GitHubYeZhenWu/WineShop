<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>公子酒业首页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">

			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>

			<!-- 轮播图 -->
			<div class="container-fluid" style="width:1200px;">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- 轮播图的中的小点 -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<!-- 轮播图的轮播图片 -->
					<div class="carousel-inner" role="listbox" style="height:500px;">
						<div class="item active">
							<img src="img/4.jpg" style="width:1200px;">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="img/5.jpg" style="width:1500px;">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="img/6.jpg" style="width:1500px;">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
					</div>

					<!-- 上一张 下一张按钮 -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			
			<!-- 热门商品 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="img/down4.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="javascript:void(0)">
							<img src="img/3.png" width="400px" height="180px" style="display: inline-block;">
						</a>
					</div>
					<div id="hotproductarea">
					
					
					</div>
			
				</div>
			</div>
			
			<!-- 广告条 -->
            <div class="container-fluid" style="padding-top:20px;">
				 <img src="products/hao/ad.jpg" width="100%"/> 
			</div>
			
			<!-- 最新商品 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="img/down5.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="javascript:void(0)">
							<img src="img/4.png" width="400px" height="180px" style="display: inline-block;">
						</a>
					</div>
					<div id="newproductarea">
					
					</div>
				
				</div>
			</div>

			
			<script type="text/javascript">
			$(function(){
				var hotprduct ="";
				$.post(
					"${pageContext.request.contextPath}/hotproduct.action",
					function(data){
						for(var i =0;i<data.length;i++){
							hotprduct+="<div class='col-md-2' style='text-align:center;height:200px;padding:10px 0px;'>"+
								"<a href='${pageContext.request.contextPath}/productinfo.action?pid="+data[i].pid+"'>"+
								"<img src='${pageContext.request.contextPath}/"+data[i].pimage+"' width='130' height='130' style='display: inline-block;'></a>"+
								"<p><a href='#' style='color:#666'>"+data[i].pname+"</a></p>"+
								"<p><font color='#E4393C' style='font-size:16px'>&yen;"+data[i].shopPrice+"</font></p></div>"
						}
						$("#hotproductarea").html(hotprduct);
					},
					"json"
				);
				
				 var newproduct="";
				$.post(
						"${pageContext.request.contextPath}/newproduct.action",
						function(data){
							for(var i =0;i<data.length;i++){
								newproduct+="<div class='col-md-2' style='text-align:center;height:200px;padding:10px 0px;'>"+
									"<a href='${pageContext.request.contextPath}/productinfo.action?pid="+data[i].pid+"'>"+
									"<img src='${pageContext.request.contextPath}/"+data[i].pimage+"' width='130' height='130' style='display: inline-block;'></a>"+
									"<p><a href='#' style='color:#666'>"+data[i].pname+"</a></p>"+
									"<p><font color='#E4393C' style='font-size:16px'>&yen;"+data[i].shopPrice+"</font></p></div>"
							}
							$("#newproductarea").html(newproduct);
						},
						"json"
					); 
				
			});
			</script>	
					
			
			<!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>
			
		</div>
	</body>

</html>