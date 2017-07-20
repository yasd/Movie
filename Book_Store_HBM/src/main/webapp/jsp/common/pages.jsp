<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<!-- 将一些共性的url放入到一个变量中进行保存 -->
	<c:set value="bookName=${bookName}&style=${category}&pageSize=${pageBean.pageSize}" var="url"></c:set>
	<ul class="pagination">
	
		<li><a href="${path}/book/list?pageNow=1&${url}">首页</a></li>
		
		<!-- 判断上一页的边界 -->
		<c:if test="${pageBean.pageNow>1}">
			<li><a href="${path}/book/list?pageNow=${pageBean.pageNow-1 }&${url}">&laquo;</a></li>
		</c:if>	
		
		<c:if test="${pageBean.pageNow==1}">
			<li class="disabled"><a href="#">&laquo;</a></li>
		</c:if>
		
		<!-- 判断分页标签的末尾 -->
		<c:if test="${pageBean.pageNow+3<pageBean.pageCount}">
			<c:set value="${pageBean.pageNow+3}" var="endPage"></c:set>
		</c:if>
		<c:if test="${pageBean.pageNow+3>=pageBean.pageCount}">
			<c:set value="${pageBean.pageCount}" var="endPage"></c:set>
		</c:if>
		
		<!-- 判断分页标签的开始 -->
		<c:if test="${pageBean.pageNow+3>=pageBean.pageCount }">
			<c:set value="${pageBean.pageCount-3 }" var="beginPage"></c:set>
		</c:if>
		<c:if test="${pageBean.pageNow+3<pageBean.pageCount }">
			<c:set value="${pageBean.pageNow}" var="beginPage"></c:set>
		</c:if>
		
		<!-- 分页标签页 -->
		<c:forEach begin="${beginPage<=0?1:beginPage}" var="p" end="${endPage}" step="1">
			
			<c:if test="${pageBean.pageNow==p }">
				<li class="active"><a href="${path}/book/list?pageNow=${p}&${url}">${p }</a></li>
			</c:if>
			
			<c:if test="${pageBean.pageNow!=p }">
				<li><a href="${path}/book/list?pageNow=${p}&${url}">${p }</a></li>
			</c:if>
			
		</c:forEach>
		
		<!-- 判断下一页的边界值 -->
		<c:if test="${pageBean.pageNow<pageBean.pageCount}">
			<li><a href="${path}/book/list?pageNow=${pageBean.pageNow+1 }&${url}">&raquo;</a></li>
		</c:if>
		<c:if test="${pageBean.pageNow==pageBean.pageCount}">
			<li class="disabled"><a href="#">&raquo;</a></li>
		</c:if>
	
		<li><a href="${path}/book/list?pageNow=${pageBean.pageCount}&${url}">尾页</a></li>
	
		<li><a href="#">当前页${pageBean.pageNow }/${pageBean.pageCount }总页</a></li>

		<li><a style="border:0;padding:0;margin-left: 10px;">
		<form class="bs-example bs-example-form" role="form" >
					<div class="row">	
						<div class="col-md-8 col-xs-8">
							<div class="input-group">
								<input id="goPage" name="pageNow" type="text" class="form-control" placeholder="跳转页"> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button"  onclick="checkPage()">Go!</button>
								</span>
							</div>
							<!-- /input-group -->
						</div>
						<!-- /.col-lg-6 -->
					</div>
					<!-- /.row -->
		</form>
		</a></li>

		<li><a style="border: 0; padding: 0"> <span>每页显示</span> 
			<select onchange="checkSize(this)"
				style="width: 100px; display: inline" class="form-control">
					<option <c:if test="${pageBean.pageSize==2}">selected</c:if> value="2">2</option>
					<option <c:if test="${pageBean.pageSize==4}">selected</c:if> value="4">4</option>
					<option <c:if test="${pageBean.pageSize==6}">selected</c:if> value="6">6</option>
					<option <c:if test="${pageBean.pageSize==8}">selected</c:if> value="8">8</option>
			</select> <span>条</span>
		</a></li>
	</ul>
</div>