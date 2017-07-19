<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书列表</title>
</head>
<body>
	<!-- 引入导航部分 -->
		<!-- 引入导航部分 -->
	<%@ include file="../common/Nav.jsp" %>	
	<!-- 引入轮播部分 -->
	<%@ include file="../common/lunbo.jsp" %>	
	<!-- 滚动end -->

	<div id="outer" style="padding-top:20px" >
	<div class="container">	
		<ol class="breadcrumb">
		    <li><a href="#">图书列表</a></li>
		    <li><a href="#"></a></li>
		</ol>
</div>
	
		
		<div class="container">
			<div class="row">
		
				<c:forEach items="${book}" var="book" >
					<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
						<div class="thumbnail">
							<a href="<%-- ${path}/book/detail?bookId=${book.bookId} --%>"><img src="${path}/images/${book.imgurl}"
								alt="通用的占位符缩略图"></a>
							<div class="caption">
								<h4>${book.name}</h4>
								<h6>图书ID:${book.bookId}</h6>
								<h6>类型:${book.category}</h6>
								<p>${book.newPrice}&nbsp;&nbsp;作者:${book.author}&nbsp;&nbsp;</p>
								<p>
									<a href="details.html">更多信息 </a>
								</p>
								
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
	</div>

	<!-- 引入模板的js文件 -->
	<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/js/list.js"></script>
	<script>
		$('#myCarousel').carousel({
			interval : 1500
		});
		
		function books(){
			 var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var books = xmlhttp.responseText;
				/* 	var list = JSON.parse(book);
					var tbl = "<table border='1'>";
					tbl += "<tr>";
					tbl += "<th>图书名称</th>";
					tbl += "<th>图书作者</th>";
					tbl += "<th>图书价格</th>";
					tbl += "<th>出版社</th>";
					tbl += "<th>出版日期</th>";
					tbl += "</tr>";

					for (var i = 0; i < list.length; i++) {
						tbl += "<tr>";
						tbl += "<td>" + list[i].name + "</td>";
						tbl += "<td>" + list[i].author + "</td>";
						tbl += "<td>" + list[i].newPrice + "</td>";
						tbl += "<td>" + list[i].publisher + "</td>";
						tbl += "<td>" + list[i].publiher + "</td>";
						tbl += "<tr>";
						tbl += "</tr>";
					}

					tbl += "</table>";  */
					

					div.innerText = tbl;
			}
				xmlhttp.open("get","${path}/book/select",true);
				xmlhttp.send();
		} 
		
	}
	</script>
</body>
</html>