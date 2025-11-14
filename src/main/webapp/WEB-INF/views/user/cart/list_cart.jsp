<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<head>
<meta charset="UTF-8">
<title>List cart</title>
</head>
<body>
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="<c:url value="/trang-chu"/>">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Giỏ hàng</li>
			</ul>
			<div class="well well-small">
				<h1>
					Giỏ hàng <small class="pull-right"> ${ totalQuantyCart }
						Sản phẩm trong giỏ hàng </small>
				</h1>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Hình ảnh</th>
							<th>Mô tả</th>
							<th>Màu sắc</th>
							<th>Giá bán</th>
							<th>Số lượng</th>
							<th>Xóa</th>
							<th>Tổng tiền</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="item" items="${ cart }">
							<tr>
								<td><img width="100"
									src="<c:url value="/assets/user/img/${ item.value.product.img }"/>"
									alt=""></td>
								<td>${ item.value.product.title }</td>
								<td><span class="shopBtn" style="background-color: ${ item.value.product.code_color };"><span class="icon-ok"></span></span>
								</td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${ item.value.product.price }" /> ₫</td>
								<td><input class="span1" style="max-width: 34px"
									placeholder="${ item.value.quanty }" id="quanty-cart-${ item.key }" size="16"
									type="number" min="1" max="1000">
									<div class="input-append">
										<button data-id="${ item.key }" class="btn btn-mini btn-danger edit-cart" type="button">
											<span class="icon-edit"></span>
										</button>
									</div></td>
								<td><a href="<c:url value="/DeleteCart/${ item.key }"/>"
									class="btn btn-mini btn-danger" type="button"> <span
										class="icon-remove"></span>
								</a></td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${ item.value.totalPrice }" /> ₫</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6" class="alignR">Total products:</td>
							<td><fmt:formatNumber type="number" groupingUsed="true"
									value="${ totalPriceCart }" /> ₫</td>
						</tr>
					</tbody>
				</table>
				<br /> <a href="<c:url value="/trang-chu"/>" class="shopBtn btn-large"><span
					class="icon-arrow-left"></span> Tiếp tục mua sắm </a> <a
					href="<c:url value="/checkout"/>" class="shopBtn btn-large pull-right">Thanh
					toán <span class="icon-arrow-right"></span>
				</a>

			</div>
		</div>
	</div>
	
	<content tag="script">
		<script>
			$(".edit-cart").on("click", function() {
				var id = $(this).data("id");
				var quanty = $("#quanty-cart-" + id).val();
				window.location = "EditCart/" + id + "/" + quanty;
			});
		</script>
	</content>
	
</body>
