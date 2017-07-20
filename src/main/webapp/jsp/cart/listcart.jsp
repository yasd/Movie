<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>我的购物车</title>
        <link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${path}/css/cart.css" />
		<link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
    </head>
    <body>
    <!--购物车 begin-->
		<!--外层div-->
			<%@ include file="../common/Nav.jsp" %>	
	<!-- 引入轮播部分 -->
	<%@ include file="../common/lunbo.jsp" %>
		<div class="container">
			<!--左边-->
			<div class="col-md-8 col-sm-12">
				<!--左边-->
				<ol class="breadcrumb">
					<li>
						<a href="#" class="text-success"><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的宝贝</a>
					</li>
				</ol>

				<!--购物车表格 begin-->
				<div class="table-responsive" id="imgDiv">
					<table class="table table-hover table-striped" style="vertical-align:middle;">
						<thead>
							<tr>
								<td colspan="8">
									<label class="text-primary">显示条数:</label>
									<select id="cartSzie" style="width: 20%;display:inline" class="form-control"  onchange="displaySize(this)">
										<option value="2" selected>2</option>
										<option value="4">4</option>
										<option value="6">6</option>
										<option value="8">8</option>
									</select>
								</td>
							</tr>
							<tr class="text-success success">
								<th><input type="checkbox" id="selectAll" onclick="selectAll(this)"></th>
								<th id="sequence">序号</th>
								<th>图片</th>
								<th>书名</th>
								<th>单价</th>
								<th>数量</th>
								<th>合计</th>
							</tr>
						</thead>
						<tbody id="tby">
						<c:forEach items="${cart}" var="ct">
							<tr>
								<td><input type="checkbox" name="cks" ></td>
								<td>${ct.key}</td>
								<td><img src="${path}/images/${book.imgurl}"></td>
								<td>${ct.value.book_name}</td>
								<td>${ct.value.ccc}元</td>
								<td>${ct.value.count}</td>
								<td>${ct.value.allPrice}$</td>
								<%-- <td>${ct.value.ccc*ct.value.count}$</td> --%>
							</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="5"></td>
								<td class="text-success">总价:</td>
								<td class="text-success">345$:</td>
							</tr>
							<tr style="background-color: white;">
								<td>
									<a href="${path}/book/index" class="btn btn-info">&lt;&lt;继续购买</a>
								</td>
								<td><button class="btn btn-danger" data-toggle="modal" data-target="#myModal" onclick="del()">删除商品</button></td>
								<td colspan="4"></td>
								<td>
									<a href="${path}/order/comfirm" class="btn btn-warning">结算商品</a>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
				<!--购物车 end-->

				<!--删除提示模态框 begin-->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<!--如果没有选中任何一个商品的时候,出现-->
					<div id="first_del" style="display: none;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title text-warning" id="myModalLabel">抱歉!请您先选择商品!</h4>
								</div>
								<div class="modal-body">请选进行勾选!再执行删除删除!</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
					</div>
					<!--first_del  end-->

					<!--如果没有选中了一个商品的时候,出现-->
					<div id="two_del" style="display: none;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title text-warning" id="myModalLabel">删除商品,慎重操作!</h4>
								</div>
								<div class="modal-body">此操作一旦进行,数据将不可恢复!</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									<button type="button" class="btn btn-danger" onclick="delRows(this)">确定删除</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
					</div>
					<!--two_del  end-->
				</div>
				<!--删除提示模态框 end-->
			</div>

			<!--右边-->
			<div class="col-md-4 col-sm-3 col-xs-8">
				<ol class="breadcrumb ">
					<li>
						<a href="${path}/listcart.jsp" class="text-success "><span class="glyphicon glyphicon-shopping-cart "></span>我的购物车</a>
					</li>
					<li>
						<a href="# ">3个商品</a>
					</li>
					<li>
						<a href="# ">总价100元</a>
					</li>
				</ol>

			<!--猜您喜欢-->
				<div>
					<span class="text-info"><span class="glyphicon glyphicon-heart"></span><span style="font-size: 20px; ">&nbsp;&nbsp;猜您喜欢</span></span>
					<div class="row" id="love">
						<div class="col-sm-12 col-md-12 wow fadeInRight animated">
							<div class="thumbnail">
								<a href="details.html"><img src="${path}/images/cikehuakai.jpg " style="height: 200px; " alt="通用的占位符缩略图 "></a>
								<div class="caption ">
									<h3>此刻花开</h3>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-12 wow fadeInRight animated">
							<div class="thumbnail ">
								<a href="details.html"><img src="${path}/images/jindumanbu.jpg " style="height: 200px; " alt="通用的占位符缩略图 "></a>
								<div class="caption ">
									<h3>京都漫步</h3>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-12 wow fadeInRight animated">
							<div class="thumbnail ">
								<a href="details.html"><img src="${path}/images/lapulasidemonv.jpg" style="height: 200px; " alt="通用的占位符缩略图 "></a>
								<div class="caption ">
									<h3>拉普拉斯的魔女</h3>
								</div>
							</div>
						</div>
						<div>
							<ul class="pager ">
								<li>
									<a href="#" onclick="pageUp() ">&larr;上一页</a>
									<a href="#" onclick="pageDown() ">下一页 &rarr;</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!--喜欢end-->
			</div>
		</div>
		<%@ include file="../common/foot.jsp" %>
		<script src="${path}/js/cart.js"></script>
		<script src="${path}/dist/js/jquery.min.js"></script>
		<script src="${path}/js/wow.js"></script>
		<script src="${path}/js/carousel.js" type="text/javascript"></script>
		<script src="${path}/dist/js/bootstrap.min.js"></script>
		<script src="${path}/js/details.js" type="text/javascript" charset="utf-8"></script>
 	</body>
</html>