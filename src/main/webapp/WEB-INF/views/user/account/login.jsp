<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Người dùng</li>
			</ul>
			<h3>Người dùng</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span1">&nbsp;</div>
				<div class="span4 login-container">
					<div class="well">
						<h5>ĐĂNG NHẬP</h5>
						<form:form action="dang-nhap" method="post" modelAttribute="user" class="login-form">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls pr-10">
									<form:input type="email" class="w-100" placeholder="Vui lòng nhập email" path="user" required="require"/>
									<form:errors path="user" class="error-message"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Password</label>
								<div class="controls pr-10">
									<form:input type="password" class="w-100" placeholder="Vui lòng nhập mật khẩu" path="password" required="require"/>
									<form:errors path="password" class="error-message"/>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Đăng nhập</button>
									<a href="#">Quên mật khẩu?</a>
								</div>
							</div>
							<p class="error-message">${ statusLogin }</p>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
