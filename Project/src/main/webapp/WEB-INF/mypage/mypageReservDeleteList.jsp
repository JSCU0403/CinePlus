<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

     <%@include file="../common/common.jsp"%>
    <%@ include file="../main/mainHeader.jsp"%>
	<%@ include file="mypageSidebar.jsp"%>
	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
 <style>
 	body{
 		
 	}
 
 	.orderList{
 		 cursor: pointer;
 		 text-align: center;
 	}
 	.orderList:hover{
 		transform: scale(1.1);
 	}
 	.panel-default {
   		 border-color: #ddd;
	}
	.panel-order .row {
		border-bottom: 1px solid #ccc;
	}
	.panel-order .row .col-md-1  {
		text-align: center;
		padding-top: 28px;
	}
	.panel-order .row .col-md-1 i {
		width: 50px;
		max-height: 50px;
	}
	.panel-order .row .row {
		border-bottom: 0;
	}
	.panel-order .row .col-md-11 {
	
		border-left: 1px solid #ccc;
	}
	.panel-order .row .row .col-md-12 {
		text-align : left;
		padding-top: 7px;
		padding-bottom: 7px; 
	}
	.panel-order .row .row .col-md-12:last-child {
		font-size: 11px; 
		color: #555;  
		background: #efefef;
	}
	.panel-order .btn-group {
		margin: 0px;
		padding: 0px;
	}
	.panel-order .panel-body {
		padding-top: 0px;
		padding-bottom: 0px;
	}
	.panel-order .panel-deading {
		margin-bottom: 0;
	}                    
	a {
    color: #000000;
    text-decoration: none;
}
	.row .row {
		text-align :left;
	}
	.panel-order .panel-heading{
		color: #333;
	    background-color: #f5f5f5;
	    border-color: #ddd;
	    padding: 10px 15px;
	    border-bottom: 1px solid transparent;
	    border-top-left-radius: 3px;
	    border-top-right-radius: 3px;
	}
	
	.label-danger {
    background-color: #5cb85c;
	}
	.label {
	    display: inline;
	    padding: .2em .6em .3em;
	    font-size: 75%;
	    font-weight: 700;
	    line-height: 1;
	    color: #fff;
	    text-align: center;
	    white-space: nowrap;
	    vertical-align: baseline;
	    border-radius: .25em;
	}
</style> 

					<div class="col-lg-9" style="padding: 20px;">
							<div class="card info-card customers-card">
								<div class="card-body align-items-center justify-content-center">
									<ul class="nav nav-tabs" id="myTab" role="tablist">
									  <li class="nav-item" role="presentation">
									    <button class="nav-link active" id="reservation-tab" onclick="location.href='myreservation.mp?member_id=${loginInfo.member_id}'">예매내역</button>
									  </li>
									  <li class="nav-item" role="presentation">
									    <button class="nav-link" id="purchase-tab" data-bs-toggle="tab" data-bs-target="#purchase-tab-pane" type="button" role="tab" aria-controls="purchase-tab-pane" aria-selected="false">취소내역</button>
									  </li>
									</ul>
									<div class="tab-content" id="myTabContent">
									  <div class="tab-pane fade" id="purchase-tab-pane" role="tabpanel" aria-labelledby="purchase-tab" tabindex="0">
									  	<div style="width:100%;">
									  		<!-- <div class="my-reservation-search">
									  			<a style="font-size:1.1rem;font-weight:600;padding-right:20px;">조회기간</a>
									  			<input type="date" class="my-reservation-search-date">
									  			<a style="font-size:1.1rem;font-weight:600;padding:0 10px;">~</a>
									  			<input type="date" class="my-reservation-search-date">
									  			<input type="submit" class="my-search" value="검색">
									  		</div><br> -->
								             <div style="width: 100%;display: flex;">
								             <!--  Table -->
								             
								             
								              <table class="table">
								                <thead>
								                  <tr>
								                    <th scope="col" width="15%">예매날짜</th>
								                    <th scope="col" width="15%">영화관</th>
								                    <th scope="col" width="30%">영화</th>
								                    <th scope="col" width="15%">좌석번호</th>
								                    <th scope="col" width="15%">실행취소</th>
								                    <th scope="col" width="15%">완전삭제</th>
								                  </tr>
								                </thead>
								                
								                <c:if test="${fn:length(delList) == 0}">
												<tr>
													<td colspan="6" align="center">취소 내역이 없습니다.</td>
												</tr>
												
											</c:if>
											 <c:if test="${fn:length(delList) != 0}">
												<tbody>
												<c:forEach var="del" items="${delList}" varStatus="status">
													<tr>
														<fmt:parseDate var="date1" value="${del.reservation_date}" pattern="yyyy-MM-dd"/>
														<fmt:formatDate  var="date2" value="${date1}" type="DATE" pattern="yyyy-MM-dd"/> 
														<td>${date2}</td>
														<td>${del.screen_name}</td>
														<td>${del.movie_title}</td>
														<td>${del.seat_number}</td>
														<td><a href="cancleDelete.mp?reservation_num=${del.reservation_num}">실행취소</a></td>
														<td><a href="hangDelete.mp?reservation_num=${del.reservation_num}">완전삭제</a></td>
													</tr>
												</c:forEach>												
												</tbody>
											</c:if>
								              </table>
								              <!-- Table -->
								             </div>
									  	</div>
									  </div>
									</div>
							</div>
						</div>

	<div class="card info-card customers-card">
		<div class="card-body align-items-center justify-content-center">
			<details>
				<summary style="margin-left: 8px;">이용안내</summary>
				<br>
				<div markdown="1">
					<p>
						영화 예매 시에는 다른 결제수단(신용카드, 예매쿠폰, 계좌이체 등)과 병행하여 사용이 가능합니다.<br> 등록
						쿠폰이 특정 영화/극장 전용 쿠폰일 경우, 명시된 사용기간 내에만 사용이 가능합니다.<br> 온라인 전용으로
						발행된 쿠폰의 경우에는 현장 사용이 불가능합니다.<br> 홈페이지 예매 후 예매취소는 홈페이지에서 상영시간
						30분 전까지 가능합니다.<br> 취소 시 현금 환불은 되지 않으며,기존 쿠폰으로 유효기간 중에서 재사용 하실
						수 있습니다.<br> 기타 할인쿠폰에 대한 문의사항이 있으실 경우, 1544-0101 또는 홈페이지를 이용해
						주시기 바랍니다.<br>
					</p>
				</div>
			</details>
		</div>
	</div>


</div>
		</div>
	</div>
</section>

</main>
<!-- End #main -->
<%@ include file="../main/mainFooter.jsp"%>