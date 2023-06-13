<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<%@ include file="../main/mainHeader.jsp"%>
<%@ include file="./cartNavigation.jsp" %>

<style>
	.container_cart {
		width: 1080px;
		height: inherit;
		margin: 0 auto;
		display: flex;
		flex-direction: column;
		border: 1px solid;
		position: relative;
	}
	.cart{
		margin-top: 50px;
		padding : 50px;
	}
	
	.cart_list{
		width : 100%;
		margin-top: 30px;
	}
	
	tr td{
		text-align : center;
	}
	
	.store_cart_img {
		width : 150px;
		float : left;
	}
	
	.btn_minus, .btn_plus{
		float:left;
		background-color: #fff;
		border: 1px solid #ccc;
		width : 32px;
		height : 32px;
		cursor: pointer;
	}
	
	.cart_qty{
		float:left;
		border: 1px solid #ccc;
		text-align : center;
		width : 42px;
		height : 32px;
		color: #aaa;
		background-color: #f7f8f9;
	}
	
	.delete_cart_btn{
		float: left;
	    width: 22px;
	    height: 22px;
	    font-size: 0;
	    border: 1px solid #bebebe;
	    background: transparent url(resources/store_menuImages/bg_closedBtn.png) center center scroll no-repeat;
	}
</style>



<div class="container_cart">
	<section id="store">
	        <div class="container">
	            <div class="row">
	            	<div class="cart">
							<h2>장바구니</h2>
	            		<div class="cart_list">
	            			<form action="order.store" method="get">
								<table border="1" width="100%">
									<tr>
										<th width="40%">상품/옵션 정보</th>
										<th>상품 금액</th>
										<th>수량</th>
										<th>합계 금액</th>
									</tr>
									 <c:forEach items="${cartBeanList}" var="cart">
										<tr>
											<td>
												<a href="productDetail.store?product_code=${cart.product_code}">
						                       		<img alt="상품 사진" class="store_cart_img" src="<%=request.getContextPath()%>/resources/store_images/${cart.product_image}">
						                   		 </a>
						                   		<span style="float: left; padding-top: 60px;">
							                   		${cart.product_name }
						                   		</span> 
											</td>
											<td>${cart.product_sprice }</td>
											<td width="110px">
													<button type="button" class="btn_minus" title="수량감소" onClick="btn_minus()">-</button>
					                            	<input type="text" class="cart_qty" id="cart_qty" name="cart_qty" title="수량 입력" readonly="readonly" value="${cart.cart_qty }">
					                            	<button type="button" class="btn_plus" title="수량증가" onClick="btn_plus()">+</button>
											</td>
											<td>
												<div style="float : left">
													${cart.cart_amount }
												</div>
													<a href="" class="delete_cart_btn"></a>
											</td>
										</tr>
									</c:forEach>				
								</table>
								<table width="100%" border="1">
									<tr>
										<td>
											<button type="button" onClick="empty_cart()">
												장바구니 비우기
											</button>
										</td>
										<td>
											총 주문 금액 ${totalAmount }
										</td>
									</tr>
									<tr>	
										<td colspan="2">
											<button type="submit">
												결제하기
											</button>
										</td>
									</tr>	
								</table>
							</form>
	            		</div>
					</div>
	            	
	            </div>
	        </div>
	</section>
</div>

<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">
	
	function empty_cart() {
		location.href = "emptyAll.store";
	}
</script>


<%@ include file="../main/mainFooter.jsp"%>