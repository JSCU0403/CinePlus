<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/mainHeader.jsp"%>
<%@ include file="../common/common.jsp"%>
<main id="main">

	<section id="portfolio" class="portfolio">
		<div style="width: 90%; margin: 0 auto;">
		<div class="container-fluid">

			<div class="section-title">
				<h3>박스오피스</h3>
				</div>
				<div class="col-xl-12" style="display: flex; flex-direction: column; align-items: center;">
				<nav id="theaterNavbar" class="navbar">
					<ul>
						<li class="dropdown"><a href="vodList.mv">VOD</a></li>
					</ul>
				</nav>
				</div>
				
			</div>
				<div class="row portfolio-container justify-content-center" style="position: relative; width: 100%; margin: 50px auto;">
					<div class="col-xl-10">
						<div class="row">
							<c:forEach var="movie" items="${movieList}" varStatus="status">
							<c:set var="vod" value="${vodList.get(status.index)}"/>
							<!-- Start portfolio item -->
							<div class="col-xl-3 col-lg-4 col-md-6 portfolio-item">
								<!-- style="position: absolute; left: 0px; top: 0px;" -->
								<div class="portfolio-wrap" style="width:294px;height:420px;">
									<img src="${movie.poster}" class="img-fluid" style="width:294px;height:420px;" alt="">
									<div class="portfolio-info" style="width:294px;height:420px;">
										<h4>
											<a href="detail.mv?movie_code=${movie.movie_code}"
											 title="More Details">${vod.vod_title}</a>
										</h4>
										<p style="margin: 100px 0;">${fn:substring(movie.movie_story,0,150)}.....</p>
										<div class="portfolio-links">
										</div>
									</div>
								</div>
									<div class="tit-area">
										<c:if test="${movie.rating eq '18세관람가'}">
											<img src="https://img.megabox.co.kr/static/pc/images/common/txt/18_46x46.png" width="23px" height="23px">
										</c:if>
										<c:if test="${movie.rating eq '15세관람가'}">
											<img src="https://img.megabox.co.kr/static/pc/images/common/txt/15_46x46.png" width="23px" height="23px">
										</c:if>
										<c:if test="${movie.rating eq '12세관람가'}">
											<img src="https://img.megabox.co.kr/static/pc/images/common/txt/12_46x46.png" width="23px" height="23px">
										</c:if>
										<c:if test="${movie.rating ne '18세관람가' &&  movie.rating ne '12세관람가' && movie.rating ne '15세관람가'}">
											<img src="https://img.megabox.co.kr/static/pc/images/common/txt/ALL_46x46.png" width="23px" height="23px">
										</c:if>
										
										<p title="${vod.vod_title}" class="tit">${vod.vod_title}</p>
									</div>
									<div class="rate-date">
										<span class="rate">가격 ${vod.vod_price}원</span> <br>
										<span class="date">개봉일 ${movie.open_date} </span>
									</div>
							</div>
							<!-- End portfolio item -->
							</c:forEach>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
</main>
<!-- End #main -->
<%@ include file="../main/mainFooter.jsp"%>