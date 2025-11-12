<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="index.html"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src='<c:url value="/assets/user/img/logo-bootstrap-shoping-cart.png"/>'
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper">
				<h1 class="dotmark">
					<i class="icon-cut"></i> Twitter Bootstrap shopping cart HTML
					template is available @ $14
				</h1>
			</div>
		</div>
		<div class="span4 alignR">
			<p>
				<br> <strong> Support (24/7) : 0800 1234 678 </strong><br>
				<br>
			</p>
			<a href='<c:url value="/gio-hang"/>'>
				<span class="btn btn-mini">[ ${ totalQuantyCart } ] 
					<span class="icon-shopping-cart"></span>
				</span>
			</a>
			 <span class="btn btn-warning btn-mini">$</span> <span
				class="btn btn-mini">&pound;</span> <span class="btn btn-mini">&euro;</span>
		</div>
	</div>
</header>
<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<c:forEach var="item" items="${ menus }" varStatus="index">

						<c:if test="${ index.first }">
							<li class="active">
						</c:if>
						<c:if test="${ not index.first }">
							<li class="">
						</c:if>

						<a href='<c:url value="/trang-chu"></c:url>'>${ item.name } </a>

						</li>
					</c:forEach>

				</ul>
				<form:form action="#" class="navbar-search pull-left">
					<input type="text" placeholder="Search" class="search-query span2">
				</form:form>
				<div class="navbar-login">
					<c:if test="${ empty LoginInfo }">
					<a class="login-link" href="<c:url value="/dang-nhap"></c:url>"><span class="icon-lock"></span>
							Đăng nhập </a>
				</c:if>
				
				<c:if test="${ not empty LoginInfo }">
					<a class="login-link">${ LoginInfo.display_name }</a>
				</c:if>
				</div>
					
			</div>
		</div>
	</div>
</div>