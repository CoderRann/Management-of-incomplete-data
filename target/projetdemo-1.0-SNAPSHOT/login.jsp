<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--绝对路径-->
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
<meta charset="UTF-8">
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

	<script>
		$(function () {

			if(window.top!=window){
				window.top.location=window.location;
			}


			//页面加载完毕后，将用户文本框中的内容清空
			$("#loginAct").val("");

			//页面加载完毕后，让用户的文本框自动获取焦点
			$("#loginAct").focus();

			//为登录按钮绑定事件，登录
			$("#submitBtn").click(function () {
				login();
			})
			//为登录页窗口绑定键盘敲击事件
			//event:这个参数可以取得我们敲击键的数值
			//回车:13
			$(window).keydown(function (event) {
				//alert(event.keyCode);
				if (event.keyCode == 13){
					login();
				}
			})

		})

		function login() {
			//alert("登录操作");
			//用户密码不为空
			//取得账户密码
			//将文本中的左右空去掉，使用$.trim(文本)
			var loginAct = $.trim($("#loginAct").val());
			var loginPwd = $.trim($("#loginPwd").val());

			if (loginAct=="" || loginPwd==""){
				$("#msg").html("username et password est null!");
				return false;
			}else {
				$.ajax({
					url : "settings/user/login.do",
					data :{
						"loginAct" : loginAct,
						"loginPwd" : loginPwd
					},
					type : "post",
					dataType : "json",
					success : function (data) {
						/*
						 data
						 	{"success": true,false,
						 	"msg" : "那里错了"}
						 */
						if (data.success){
							//跳转到工作台的初始页
							window.location.href = "workbench/index.jsp";
						}else {
							//登录失败
							$("#msg").html(data.msg);
						}
					}
				})

			}



		}

	</script>


</head>
<body>
	<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
		<img src="image/IMG_7114.JPG" style="width: 100%; height: 90%; position: relative; top: 50px;">
	</div>
	<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
		<div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">Gestion des données incomplète &nbsp;<span style="font-size: 12px;">&copy;2021&nbsp;</span></div>
	</div>
	
	<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
		<div style="position: absolute; top: 0px; right: 60px;">
			<div class="page-header">
				<h1>Binevenue!</h1>
			</div>
			<form action="workbench/index.jsp" class="form-horizontal" role="form">
				<div class="form-group form-group-lg">
					<div style="width: 350px;">
						<input class="form-control" type="text" placeholder="Username" id="loginAct">
					</div>
					<div style="width: 350px; position: relative;top: 20px;">
						<input class="form-control" type="password" placeholder="Password" id="loginPwd">
					</div>
					<div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
						
							<span id="msg" style="color: red"></span>
						
					</div>
					<!--

                    注意：按钮写在form表单中，默认的行为就是提交表单
                        一定要将按钮的类型设置为button
                        按钮所触发的行为应该是由我们自己手动写js代码来决定

                -->
					<button type="button" id="submitBtn" class="btn btn-primary btn-lg btn-block"  style="width: 350px; position: relative;top: 45px;">Sign in</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>