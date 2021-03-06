<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.net.URLDecoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线书城首页</title>
<link rel="stylesheet" type="text/css" href="${path}/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/list.css">
<style type="text/css">
	#e1{
		color: red;
	}
	#e2{
		color: green;
	}
</style>
</head>
<body>
	<!--导航部分  begin-->
	<div class="container " style="margin-top: 5px;" >
		<nav class="navbar navbar-default well-sm" style="padding-left: 0px;"role="navigation" class="container-fluid">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
						<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">在线书城</a>
				</div>
				<!--登录的form表单-->
				<form class="form-horizontal" role="form" action="${path}/book/select">
				<div class="input-group col-md-3 pull-right" style="positon: relative; padding: 7px;">
					<input type="text" class="form-control" id="bookName" name="bookName"  value="${name}"
					 placeholder="请输入图书名" /> <span
						class="input-group-btn">
						<button class="btn btn-info btn-search">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				</form>
			
				<div class="collapse navbar-collapse" id="example-navbar-collapse"
					class="container-fluid">
					<ul class="nav navbar-nav pull-left">
					<%
			String name = "";
		    String pwd = "";
		    String ckon="";
			Cookie[] cookies = request.getCookies();
		
			if(null!=cookies && cookies.length>0){
				for(Cookie c:cookies){
					if("username".equals(c.getName())){
						//获取该cookie的value
						String urr = c.getValue();
						//根据:进行切割
						String[] values = urr.split(":");
						//同样需要对用户名进行一级解码
						name = URLDecoder.decode(values[0],"utf-8");
						pwd = values[1];
						ckon="checked";
					}
				}
			}
			request.setAttribute("username", name);
			request.setAttribute("pwd", pwd);
		%>
						<li class="active"><a href="${path}/book/index">首页</a></li>
								
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									图书类型
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="${path}/book/three?category=精选图书">精选图书</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="${path}/book/three?category=推荐图书">推荐图书</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="${path}/book/three?category=特价图书">特价图书</a>
									</li>
									<li class="divider"></li>
								</ul>
							</li>
						<c:if test="${empty user}">
							<li><a href="" data-toggle="modal" data-target="#modal_login" id="lg">登录</a>
							</li>
						</c:if>
						<c:if test="${!empty user}">
							<li><a href=""><span class="text-success">${user.userName}</span></a>
							</li>
						</c:if>
						<c:if test="${!empty user}">
							<li><a href="${path}/user/safeExit">安全退出</a></li>
						</c:if>
						<c:if test="${empty user}">
						<li><a href="#" data-toggle="modal" data-target="#register">注册</a></li>
						</c:if>
						<c:if test="${!empty user}">
							<li><a href="${path}/order_list.jsp">我的订单</a></li>
							<li><a href="${path}/cart/list"><span class="glyphicon glyphicon-shopping-cart"> </span>我的购物车</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!---->
	<!--导航部分 end-->
	<!-- 登录模态框（Modal） -->
	<div class="modal fade" id="modal_login" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">用户登录</h4>
				</div>
				<div class="modal-body">
					<!--登录的form表单-->
					<form class="form-horizontal" role="form" action="">
						<div class="form-group has-feedback">
							<label for="firstname" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-5">

					<input type="text" class="form-control" id="username" value="${name}" placeholder="请输入用户名"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							
								<div id="c" class="col-sm-3" style="padding-top: 10px;">
								<label class="alert-danger" id="erruser"></label>
							</div>
							
						</div>
						<div class="form-group has-feedback">
							<label for="lastname" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-5">
				<input type="password" class="form-control" id="pwd"  value="${pwd}" placeholder="请输入密码"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
							</div>
							
								<div id="c" class="col-sm-3" style="padding-top: 10px;">
								<label class="alert-danger" id="errpwd"></label>
							</div>
							
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" id="ck" name="cookie">请记住我
									</label>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<input type="button" class="btn btn-primary" value="登录" onclick="login()">
						</div>
					</form>
					<!--form结束-->
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<!-- 登录modal end/.modal -->
	<div class="modal fade" id="register" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div id="errinput">
			<div class="modal-content" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
					用户注册
					<input type="hidden" value="${path}" id="regpath">
				</h4>
				</div>
				<div class="modal-body">
					<!--登录的form表单-->
					<form action="${path}/user/register" class="form-horizontal" role="form" onsubmit="return doRegister('p')" method="get">
						<div class="form-group has-feedback">
							<label for="firstname" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-5">
							
							<input type="hidden" class="form-control"  name="yname" id="yname" >
							
								<input type="text" class="form-control"  name="rname" id="rname" required
									placeholder="小写字母开头,不含中文.">
									 <span class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="col-sm-4" style="padding-top: 10px;">
									<label class="alert-danger" id="errname"></label>
								</div>
						</div>
						<div class="form-group has-feedback">
							<label for="lastname" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" name="rpassword" id="rpassword"
									placeholder="密码长度6-8位" minlength="6" maxlength="8"> <span
									class="glyphicon glyphicon-lock form-control-feedback"></span>
							</div>
							<div class="col-sm-4" style="padding-top: 10px;">
									<label class="alert-danger" id="errpwd1"></label>
								</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" name="rcheckpwd" id="rcheck" minlength="6" maxlength="8" placeholder="和密码保持一致"> <span
									class="glyphicon glyphicon-lock form-control-feedback"></span>
							</div>
							<div class="col-sm-4" style="padding-top: 10px;">
									<label class="alert-danger" id="errpwd"></label>
								</div>
						</div>

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-5">
								<input type="email" class="form-control" name="remail" id="remail"
									placeholder="合法邮箱格式"> <span
									class="glyphicon glyphicon-envelope form-control-feedback"></span>
							</div>
						</div>

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">电话</label>
							<div class="col-sm-5">
								<input type="tel" class="form-control" name="rphone" id="rphone" placeholder="合法手机格式"> <span
									class="glyphicon glyphicon-earphone form-control-feedback"></span>
							</div>
						</div>

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">公司</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="rcompany" id="rcompany" placeholder="请输入公司地址"> <span
									class="glyphicon glyphicon-home form-control-feedback"></span>
							</div>
						</div>

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">地址</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="raddress" id="raddress" placeholder="请输入收货"> <span
									class="glyphicon glyphicon-home form-control-feedback"></span>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<input type="submit" class="btn btn-primary" value="注册">
						</div>
					</form>
					<!--form结束-->
				</div>
			</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<script src="${path}/js/register.js"></script>
	 <script src="${path}/js/jquery.min.js"></script>
	<%-- <script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/dist/js/bootstrap.min.js"></script>
	<script src="${path}/js/wow.js"></script>
	<script src="${path}/js/list.js"></script> --%>
	<script type="text/javascript">
	
     function login(){
	/* 	alert("开始登录"); */
		var name = document.getElementById("username").value;
		var pwd = document.getElementById("pwd").value;
		var erruser = document.getElementById("erruser");
		var errpwd = document.getElementById("errpwd");
		var ck = document.getElementById("ck").value;
		var login = document.getElementById("lg");
		var xml;
		
		if(ck!=null && ck!=""){
			ckbox="1";
		}
		xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				var str = xml.responseText;
				//alert(str);
				if("0"==str){
					erruser.innerHTML="用户名不存在";
					errpwd.innerHTML="";
				}else if("1"==str){
					errpwd.innerHTML="密码错误";
					erruser.innerHTML="";
				}else{
					window.location="${path}/book/index";
				}
			}
		}
		xml.open("post","${path}/book/login",true);
		xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
		xml.send("username="+name+"&password="+pwd);
	}
     
   //验证跳转页数是否合法
	/* */
	</script>
	
</body>
</html>