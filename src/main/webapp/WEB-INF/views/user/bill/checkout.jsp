<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Thanh toán</li>
			</ul>
			<h3>Thanh toán</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span4 checkout">
					<div class="well">
						<br />
						<form:form class="form-horizontal checkout-form" action="checkout" method="post" modelAttribute="bill">
							<h3>Thanh toán đơn hàng</h3>
							<div class="control-group pr-10">
								<label class="control-label">Họ tên <sup>*</sup></label>
								<div class="controls ">
									<form:input type="text" placeholder=" Vui lòng nhập họ tên" path="display_name" class="w-100"/>
								</div>
							</div>
							<div class="control-group pr-10">
								<label class="control-label">Email <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" placeholder=" Vui lòng nhập email" path="user" class="w-100"/>
								</div>
							</div>
							<div class="control-group pr-10">
								<label class="control-label">Liên hệ <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" placeholder=" Vui lòng nhập số điện thoại" path="phone" class="w-100"/>
								</div>
							</div>
							<div class="control-group pr-10">
								<label class="control-label">Địa chỉ <sup>*</sup></label>
								<div class="controls">
									<form:textarea path="address" rows="5" cols="30" class="w-100"/>
								</div>
							</div>
							<div class="control-group pr-10">
								<label class="control-label">Ghi chú </label>
								<div class="controls">
									<form:textarea path="note" rows="5" cols="30" class="w-100"/>
								</div>
							</div>
							<div class="control-group submitBtn">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Đặt hàng"
										class="shopBtn exclusive">
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
			</div>

		</div>
	</div>

</body>
