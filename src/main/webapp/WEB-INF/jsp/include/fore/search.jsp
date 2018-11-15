<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>

<a href="${contextPath}">
	<img id="logo" src="img/site/logo.gif" class="logo">
</a>

<form action="foresearch" method="post" >
	<div class="searchDiv">
		<input name="keyword" type="text" value="${param.keyword}" placeholder="时尚男鞋  太阳镜 ">
		<button  type="submit" class="searchButton">搜索</button>
		<div class="searchBelow">
			<c:forEach items="${cs}" var="c" varStatus="st">
				<%-- 从request的属性"cs" 中获取到分类集合，并取第5个到第8个，一共4个来显示 --%>
				<c:if test="${st.count>=5 and st.count<=8}">
						<span>
							<a href="forecategory?cid=${c.id}">
									${c.name}
							</a>
							<%-- 第8个不加中间一杠 --%>
							<c:if test="${st.count!=8}">
								<span>|</span>
							</c:if>
						</span>
				</c:if>
			</c:forEach>
		</div>
	</div>
</form>
