<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--最顶端轮播图片 begin-->
		<div id="gcarouse" class="container">
			<!--轮播-->
			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<a href="details.html"><img src="${path}/images/advert1.jpg" class="pull-left" alt="First slide"></a>
					
					</div>
					<div class="item">
						<a href="details.html"><img src="${path}/images/advert2.jpg" class="pull-left" alt="First slide"></a>
						
					</div>
					<div class="item">
						<a href="details.html"><img src="${path}/images/advert3.jpg" class="pull-left" alt="First slide"></a>
					
					</div>
				</div>

				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
				<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
		</div>
		
		<script src="${path}/js/carousel.js" type="text/javascript" charset="utf-8"></script>
		<!--最顶端轮播图片 end-->
	