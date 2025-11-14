<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
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
				<div class="span4 register-container">
					<div class="well">
						<h5>ĐĂNG KÝ TÀI KHOẢN</h5>
						<br />
						<form:form action="dang-ky" method="post" modelAttribute="user" class="register-form">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls pr-10">
									<form:input type="email" class="w-100" placeholder="Vui lòng nhập email" path="user"/>
									<form:errors path="user" class="error-message"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Mật khẩu</label>
								<div class="controls pr-10">
									<form:input type="password" class="w-100" placeholder="Vui lòng nhập mật khẩu" path="password"/>
									<form:errors path="password" class="error-message"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Họ và tên</label>
								<div class="controls pr-10">
									<form:input type="text" class="w-100" placeholder="Vui lòng nhập họ và tên" path="display_name"/>
									<form:errors path="display_name" class="error-message"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Địa chỉ</label>
								<div class="controls pr-10">
									<form:input type="text" class="w-100" placeholder="Vui lòng nhập địa chỉ" path="address" />
								</div>
							</div>
							<div class="controls margin-auto submitBtn">
								<button type="submit" class="btn block">Đăng ký</button>
							</div>
							<p class="message">${ status }</p>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
			</div>

		</div>
	</div>

</body>
