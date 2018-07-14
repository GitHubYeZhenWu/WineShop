<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
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


#text1{
	color:	#6C6C6C;
	font-size: 15px;
	font-weight: normal;
	padding: 0 10px;
}
.error{
	color:red;

}
#verify {
		height: 24px;
		vertical-align: right;
		font-size: 16px;
		padding-top: 5px;
		
	}

#code_img {
		width: 70px;
		height: 35px;
		cursor: pointer;
		vertical-align: top;
		padding-right: 5px;
		
	}
/* .form-group{
		padding-top:8px;
	} */
</style>
<script type="text/javascript">
	$.validator.addMethod(
		"checkUsername",
		function(value,element,params){
			var flag = false;
			$.ajax({
				"async":false,
				"url":"${pageContext.request.contextPath}/checkname.action",
				"data":{"username":value},
				"type":"POST",
				"dataType":"json",
				"success":function(data){
					flag = data.isExist;
				}
			});
			
			return !flag;
		}
	);
	
	$(function(){
		$("#resform").validate({
			rules:{
				"username":{
					"required":true,
					"rangelength":[6,12],
					"checkUsername":true
					},
				"password":{
					"required":true,
					"rangelength":[6,12]
				},
				"repassword":{
					"equalTo":"#password",
					"required":true
				},
				"email":{
					"required":true,
					"email":true
				},
				"name":{
					"required":true,
					"rangelength":[2,5]
				},
				"sex":{
					"required":true,
				},
				"birthday":{
					"required":true,
					"dateISO":true
				},
				
				
			},
			messages:{
				"username":{
					"required":"用户名不能为空",
					"rangelength":"用户名长度为6-12位",
					"checkUsername":"用户名已存在"
					},
				"password":{
					"required":"用户密码不能为空",
					"rangelength":"密码长度为6-12位"
					},
				"repassword":{
					"equalTo":"两次密码不一致",
					"required":"确认密码不能为空"
					},
				"email":{
					"required":"邮箱不能为空",
					"email":"邮箱格式不正确"
					},
				"name":{
					"required":"真实姓名不能为空",
					"rangelength":"真实姓名长度为2-5位"
					},
				"birthday":{
					"required":"出生日期不能为空",
					"dateISO":"出生日期格式为(xxxx-xx-xx)"
					},

			}
		});
	});
</script>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%;padding-left:30px;padding-bottom:0px; background: url('images/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form class="form-horizontal" style="margin-top: 5px;" id="resform" method="post"
					action="${pageContext.request.contextPath }/register.action">
						<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6" >
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名">
						</div>
						
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="请输入密码">
						</div>
		
					</div>
					<div class="form-group">
						<label for="repassword" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="repassword" name="repassword"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="radio-inline" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> 
							<input type="radio" name="sex" id="sex1" value="male">
								男
							</label>
							<label class="radio-inline">
							<input type="radio" name="sex" id="sex2" value="female">
								女
							</label>
							<label for="sex" class="error" style="display:none;padding-left:5px;">性别不能为空</label>
						</div>
					</div>
					<div class="form-group">
						<label for="birthday" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="birthday" name="birthday"
							placeholder="请输入出生日期">
						</div>
					</div>

					<div class="form-group" style="padding-top:20px;padding-left:30px;padding-bottom:0px;">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




