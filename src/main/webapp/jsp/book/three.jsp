<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>图书列表</title>
	<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
	<link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
</head>
<body>
	<!-- 引入导航部分 -->
	<%@ include file="../common/Nav.jsp"%>
	
	<!-- 引入图片轮播部分 -->
	<%@ include file="../common/lunbo.jsp"%>
	
	<br/>
	<div class="container">	
		<ol class="breadcrumb">
		    <li><a href="#">图书列表</a></li>
		    <li><a href="#">${pages.list.get(0).category}</a></li>
		</ol>
	</div>
	
	<input type="hidden" value="${path}" id="path"/>
	<input type="hidden" value="${category}" id="style"/>
	
	<!-- 主题内容begain -->
	<!--图书列表 begin-->
		<div class="container">
			<div class="row">
		
				<c:forEach items="${pages.list}" var="book" >
					<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
						<div class="thumbnail">
							<a href="${path}/book/detail?bookId=${book.bookId}"><img src="${path}/images/${book.imgurl}"
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
		<!--图书列表end-->
	<!-- 主题内容end -->
	
	<%@ include file="../common/pages.jsp" %>
	
	<script src="${path}/js/list.js"></script>
	<script src="${path}/dist/js/jquery.min.js"></script>
	<script src="${path}/js/carousel.js" type="text/javascript" charset="utf-8"></script>
	<script src="${path}/dist/js/bootstrap.min.js"></script>
	<script src="${path}/js/wow.js"></script>
	
	<!-- 引入底部部分 -->
	<%@ include file="../common/foot.jsp" %>
</body>
</html>