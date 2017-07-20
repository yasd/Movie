<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>在线书城首页</title>
		<link rel="stylesheet" type="text/css" href="${path}/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/css/index.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/css/animate.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/css/list.css">
	</head>

	<body>
		<!-- 引入导航部分 -->
	<%@ include file="common/Nav.jsp" %>	
	<!-- 引入轮播部分 -->
	<%@ include file="common/lunbo.jsp" %>	
		<!--图书内容部分 begin-->
		<div class="container">
			<!--精选图书 begin-->
			<div>
				<div class="text-primary"><img src="../images/bullet1.gif" alt="" title="">
					<a href="#">精选图书</a>
				</div>
				<div class="row">
					<c:forEach items="${book.list}" var="b" >
						<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
						<div class="thumbnail">
							<a href="${path}/list/book?bookid=${b.bookId}"><img src="../images/${b.imgurl}" alt="通用的占位符缩略图"></a>
							<div class="caption">
								<h4>${b.name}</h4>
								<p>${b.newPrice}$&nbsp;&nbsp;作者:${b.author}&nbsp;&nbsp;</p>
								<p>
									<a href="${path}/list/book?bookid=${b.bookId}">
										更多信息
									</a>
								</p>
							</div>
						</div>
					</div>
					</c:forEach>
					<!--分页-->
					<div id="container">
						<ul class="pager">
							<li>
								<a href="javascript:p_up(page1:div1)">&larr;上一页</a>
								<a href="javascript:p_down(page1:div1)">下一页 &rarr;</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--精选图书 end-->

			<!--推荐图书 begin-->
			<div>
				<div class="text-primary"><img src="../images/bullet1.gif" alt="" title="">
					<a href="#">推荐图书</a>
				</div>
				<div class="row">
					<c:forEach items="${book1.list}" var="b1" >
						<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
						<div class="thumbnail">
							<a href="${path}/list/book?bookid=${b1.bookId}"><img src="../images/${b1.imgurl}" alt="通用的占位符缩略图"></a>
							<div class="caption">
								<h4>${b1.name}</h4>
								<p>${b1.newPrice}$&nbsp;&nbsp;作者:${b1.author}&nbsp;&nbsp;</p>
								<p>
								<a href="${path}/list/book?bookid=${b1.bookId}">
										更多信息
									</a>
								</p>
							</div>
						</div>
					</div>
					</c:forEach>
					<!--分页-->
					<div id="container">
						<ul class="pager">
							<li>
								<a href="javascript:p_up(page2:div2)">&larr;上一页</a>
								<a href="javascript:p_down(page2:div2)">下一页 &rarr;</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--推荐图书end..-->

			<!--特价图书 begin-->
			<div>
				<div class="text-primary"><img src="../images/bullet1.gif" alt="" title="">
					<a href="#">特价图书</a>
				</div>
				<div class="row">
					<c:forEach items="${book2.list}" var="b2" >
						<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
						<div class="thumbnail">
							<a href="${path}/list/book?bookid=${b2.bookId}"><img src="../images/${b2.imgurl}" alt="通用的占位符缩略图"></a>
							<div class="caption">
								<h4>${b2.name}</h4>
								<p>${b2.newPrice}$&nbsp;&nbsp;作者:${b2.author}&nbsp;&nbsp;</p>
								<p>
									<a href="${path}/list/book?bookid=${b2.bookId}">
										更多信息
									</a>
								</p>
							</div>
						</div>
					</div>
					</c:forEach>
					<!--分页-->
					<div id="container" >
						<ul class="pager">
							<li>
								<a href="javascript:p_up(pagebeans3:div3)">&larr;上一页</a>
								<a href="javascript:p_down(pagebeans3:div3)">下一页 &rarr;</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--特价图书 end-->
			<hr>
			<!--首页底部信息 begin-->
		<%@ include file="common/foot.jsp" %>	
		</div>
		<!--首页底部信息end->
		<!--图书内容部分end-->
			
		<script src="${path}/dist/js/jquery.min.js"></script>
		<script src="${path}/dist/js/bootstrap.min.js"></script>
		<script src="${path}/js/wow.js"></script>
		<script src="${path}/js/list.js"></script>
		<script src="${path}/js/carousel.js"></script>
		<script type="text/javascript">
			if(!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
				new WOW().init();
			};
			var now=1;
			var s_page="";
			var s_div="";
			var category="";
			function p_up(obj){
				var page_div=obj.split("\:");
				s_page=page_div[0];
				s_div=page_div[1];
				up();
			}
			function p_down(obj){
				var page_div=obj.split("\:");
				s_page=page_div[0];
				s_div=page_div[1];
				down();
			}
			function down() {
				/* alert("111111111111"); */
				
				var div = document.getElementById(s_div);
				var c =1;
				if("div1"==s_div){
				 	x = ${pagebeans1.pageCount};	
				 	category="精选图书"; 
				}else if("div2"==s_div){
				 	x = ${pagebeans2.pageCount};	
				 	category="推荐图书";
				}else if("div3"==s_div){
				 	x = ${pagebeans3.pageCount};	
				 	category="特价图书";
				}
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						//接收后台的字符串[应该是json字符串]
						var books = xmlhttp.responseText;
						//将json字符串转换成json对象
						var list = JSON.parse(books);
						//定义一个字符串
						var tbl = "<table border='1'>";
						tbl += "<tr>";
						tbl += "<th>图书名称</th>";
						tbl += "<th>图书作者</th>";
						tbl += "<th>图书价格</th>";
						tbl += "</tr>";
						for (var i = 0; i < list.length; i++) {
							tbl += "<tr>";
							tbl += "<td>" + list[i].name + "</td>";
							tbl += "<td>" + list[i].author + "</td>";
							tbl += "<td>" + list[i].newPrice + "</td>";
							tbl += "<tr>";
							tbl += "</tr>";
						}
						tbl += "</table>";
						div.innerHTML = tbl;
					}
				}
				if(now<c){
					now+=1;
				}else{
					now=c;
					alert("对不起!已经到达尾页!");
				}
				xmlhttp.open("get", "${path}/book/page?pageNow=" + now, true);
				xmlhttp.send(); 
			}
			function up() {
				/* alert("111111111111"); */
				var div = document.getElementById(s_div);
				var c =1;

				if("div1"==s_div){
				 	c = ${pagebeans1.pageCount};	
				 	category="精选图书"; 
				}else if("div2"==s_div){
				 	c = ${pagebeans2.pageCount};	
				 	category="推荐图书";
				}else if("div3"==s_div){
				 	c= ${pagebeans3.pageCount};	
				 	category="特价图书";
				}
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						//接收后台的字符串[应该是json字符串]
						var books = xmlhttp.responseText;
						//将json字符串转换成json对象
						var list = JSON.parse(books);
						//定义一个字符串
						var tbl = "<table border='1'>";
						tbl += "<tr>";
						tbl += "<th>图书名称</th>";
						tbl += "<th>图书作者</th>";
						tbl += "<th>图书价格</th>";
						tbl += "</tr>";
						for (var i = 0; i < list.length; i++) {
							tbl += "<tr>";
							tbl += "<td>" + list[i].name + "</td>";
							tbl += "<td>" + list[i].author + "</td>";
							tbl += "<td>" + list[i].newPrice + "</td>";
							tbl += "<tr>";
							tbl += "</tr>";
						}
						tbl += "</table>";
						div.innerHTML = tbl;
					}
				}
				if(now<=1){
					now = 1;
					alert("到达首页了...");
				}else{
					now-=1;
				}
				xmlhttp.open("get", "${path}/book/page?pageNow=" + now, true);
				xmlhttp.send(); 
			}
			 function checkPage(){
				var value = document.getElementById("goPage").value;
				var reg=/^[0-9]+$/;
				var count = ${pageBean.pageCount};
				if(reg.test(value) && value!=0 && value<=count){
					//1.获取图书名称输入框的参数
					var bookName = document.getElementById("bookName").value;
					var style = document.getElementById("style").value;
					window.location="${path}/book/page?bookName="+bookName+"&style="+style+"&pageNow="+value+"&pageSize="+${pageBean.pageSize}
				}else{
					alert("不匹配!");
				}
			}  
		</script>
	</body>
</html>