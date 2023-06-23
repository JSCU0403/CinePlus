<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/common.jsp" %>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="resources/assets/img/favicon.ico" rel="icon">
	
    <title>Cinema + 관리자 페이지</title>

    <!-- Bootstrap -->
    <link href="resources/admin/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="resources/admin/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="resources/admin/css/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="resources/admin/css/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="resources/admin/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="resources/admin/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="resources/admin/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="resources/admin/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="resources/admin/css/scroller.bootstrap.min.css" rel="stylesheet">
	<!-- bootstrap-wysiwyg -->
    <link href="resources/admin/css/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="resources/admin/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="resources/admin/css/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="resources/admin/css/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="resources/admin/css/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="resources/admin/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href=" " class="site_title">
              	<img width="210px" height="40px" src="resources/images/main-logo-dark.png"> 
              	<span>관리자 페이지</span>
              </a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_info">
                <span>관리자 님</span>
                <h2>반갑습니다.</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>관리자 메뉴</h3>
                <ul class="nav side-menu">
                
                  <li><a><i class="fa fa-home"></i> 예시 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="adminTest1.admin">테이블</a></li>
                      <li><a href="adminTest2.admin">생성</a></li>
                    </ul>
                  </li>
                  
                  
                  <li><a><i class="fa fa-edit"></i> 쿠폰 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="couponCreate.admin">쿠폰 발급</a></li>
                      <li><a href="coupon.admin">쿠폰 리스트</a></li>
                    </ul>
                  </li>
                  
                    <li><a><i class="fa fa-edit"></i> 고객센터 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="faqInsert.admin">FAQ 등록</a></li>
                      <li><a href="faq.admin">FAQ 조회</a></li>
                      <li><a href="board.admin">1:1문의 조회</a></li>
                    </ul>
                  </li>
                  
                  <li><a><i class="fa fa-edit"></i> 영화 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="boxOffice.mv?admin=admin">박스오피스 목록</a></li>
                      <li><a href="screenOnList.admin">상영중</a></li>
                      <li><a href="movieList.admin">영화 목록</a></li>
                    </ul>
                  </li>
                 
                  
                  
                </ul>
              </div>

            </div>
            <!-- 메뉴바 -->

            
          </div>
        </div>

    