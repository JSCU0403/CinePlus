<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../main/mainHeader.jsp"%>   

<h3>아이디 찾기</h3>
	<p>
		<label>이름</label>
		<input type="text" id="member_name" name="member_name" placeholder="이름을 입력하세요." required>
	</p>

	<p>
		<label>생년월일</label>
		<input type="text" id="member_birth" name="member_birth" placeholder="생년월일을 입력하세요." required>
	</p>
	<p>
		<label>핸드폰번호</label>
		<input type="text" id="member_phone" name="member_phone" placeholder="핸드폰 번호를 입력하세요." required>
	</p>
	<p>
		<button type="button" id='find_id' onclick="findId_click()">아이디찾기</button>
		<button type="button" onclick="history.go(-1);">취소</button>
	</p>

	<%@ include file="../main/mainFooter.jsp"%>