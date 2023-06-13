<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/mainHeader.jsp"%>

<!-- 회원가입 -->
<div class="container-register">
<div class="register">회원가입</div>
<form:form commandName="mb" action="register.mb" method="post">
<div class="register-1">회원정보입력<hr></div>
<table class="registerForm-1">
	<tr>
		<td>
			<a style="color: #DE0000">*&nbsp&nbsp</a>이름
		</td>
		<td>
			<input type="text" class="inputText3" name="member_name" value="${mb.member_name}">
		</td>
	</tr>
	<tr>
		<td>
			<a style="color: #DE0000">*&nbsp&nbsp</a>아이디
		</td>
		<td>
			<input type="text" class="inputText3" name="member_id" value="${mb.member_id}">
			<input type="button" class="idcheckbutton" value="중복체크" id="id_check">
			<span id="idcheck-message"></span><br>
			
		</td>
	</tr>
	<tr>
		<td>
			<a style="color: #DE0000">*&nbsp&nbsp</a>비밀번호
		</td>
		<td>
			<input type="password" class="inputText3" name="member_pw" id="member_pw" value="${mb.member_pw}"><br>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<a class="register-infor">비밀번호는 영문 소문자/숫자를 조합하여 8~12자 이내로 입력해주세요</a>
		</td>
	</tr>
	<tr>
		<td>
			<a style="color: #DE0000">*&nbsp&nbsp</a>비밀번호 확인
		</td>
		<td>
			<input type="password" class="inputText3" name="member_pwcheck">
			<span id="pwcheck-message"></span>
		</td>
	</tr>
	<tr>
		<td>
			<a style="color: #DE0000">*&nbsp&nbsp</a>비밀번호 찾기 질문
		</td>
		<td>
			<select name="pw_question" class="selectBox1">
				<option value="">선택하세요
				<option value="q1"<c:if test="${mb.pw_question == 'q1'}">selected</c:if>>기억에 남는 추억의 장소는?
				<option value="q2"<c:if test="${mb.pw_question == 'q2'}">selected</c:if>>자신의 인생 좌우명은?
				<option value="q3"<c:if test="${mb.pw_question == 'q3'}">selected</c:if>>자신의 보물 제1호는?
				<option value="q4"<c:if test="${mb.pw_question == 'q4'}">selected</c:if>>가장 기억에 남는 선생님 성함은?
				<option value="q5"<c:if test="${mb.pw_question == 'q5'}">selected</c:if>>내가 좋아하는 캐릭터는?
				<option value="q6"<c:if test="${mb.pw_question == 'q6'}">selected</c:if>>인상깊게 읽은 책 이름은?
				<option value="q7"<c:if test="${mb.pw_question == 'q7'}">selected</c:if>>다시 태어나면 되고 싶은 것은?
			</select>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<a class="register-infor">비밀번호 찾기 시 사용할 질문을 선택해주세요</a>
		</td>
	</tr>
	<tr>
		<td>
			<a style="color: #DE0000">*&nbsp&nbsp</a>비밀번호 찾기 답변
		</td>
		<td>
			<input type="text" class="inputText3" name="pw_answer" value="${mb.pw_answer}"><br>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<a class="register-infor">비밀번호 찾기 시 사용할 답변을 입력해주세요</a>
		</td>
	</tr>
	<tr>
     	 <td>
      	   <a style="color: #DE0000">*&nbsp&nbsp</a>생년월일
    	  </td>
     	 <td>
        	 <input type="text" class="inputText3" name="member_birth" value="${mb.member_birth}"><br>
     	 </td>
	</tr>
	<tr>
		<td>
			<a style="color: #DE0000">*&nbsp&nbsp</a>휴대폰번호
		</td>
		<td>
			<input type="text" class="inputText3" name="member_phone" value="${mb.member_phone}"><br>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<a class="register-infor">휴대폰 번호는 '-' 없이 11자리의 숫자로 입력해주세요</a>
		</td>
	</tr>
	<tr>
		<td>
			<a style="color: #DE0000">*&nbsp&nbsp</a>이메일
		</td>
		<td>
			<input type="email" class="inputText3" name="member_email" value="${mb.member_email}">
		</td>
	</tr>
</table>
<div class="register-1">마케팅 정보 수집 및 수신 동의<hr></div>
<table class="registerForm-2">
	<tr>
		<td>
			마케팅 활용을 위한 개인정보 수집 이용 안내
		</td>
		<td>
			<input type="radio" name="member_marketing_agree" value="동의">&nbsp동의&nbsp&nbsp
			<input type="radio" name="member_marketing_agree" value="미동의">&nbsp미동의
		</td>
	</tr>
	<tr>
		<td colspan="2" style="font-size: 0.9em">
			[수집 목적]<br>
			고객 맞춤형 상품 및 서비스 추천. 당사 신규 상품/서비스 안내 및 권유. 사은/할인 행사 등 각종 이벤트 정보 등의 안내 및 권유<br>
			<div style="padding-bottom: 5px"></div>
			[수집 항목]<br>
			이메일, 휴대폰번호, 주소, 생년월일, 선호극장, 문자/이메일/앱푸쉬 정보 수신동의여부, 서비스 이용기록, 포인트 적립 및 사용 정보, 접속로그<br>
			<div style="padding-bottom: 5px"></div>
			[보유 및 이용 기간]<br>
			회원 탈퇴 시 혹은 이용 목적 달성 시까지
		</td>
	</tr>
</table>
<table class="registerForm-2">
	<tr>
		<td colspan="2">
			마케팅 정보 수신 동의
		</td>
	</tr>
	<tr>
		<td colspan="2" style="font-size: 0.9em">
			거래정보와 관련된 내용(예매완료/취소)과 소멸포인트 안내는 수신동의 여부와 관계없이 SMS, PUSH 알림 또는 이메일로 발송됩니다.<br>
			이 외 타 정보는 수신동의를 하셔야만 받으실 있습니다. (2014.05.16 기준)
			<div style="padding-bottom: 7px"></div>
			! 수신 동의 여부를 선택해주세요
			<div style="padding-bottom: 7px"></div>
			<div style="background-color: #F2F2F2; padding-top: 10px; padding-bottom: 10px; padding-left: 15px;">
				<a style="font-weight: 500; margin-right: 20px;"> 이메일 </a>
				<input type="radio" name="member_email_agree" value="수신동의">&nbsp수신동의&nbsp&nbsp
				<input type="radio" name="member_email_agree" value="수신거부">&nbsp수신거부
				<br>
				<div style="padding-bottom: 5px"></div>
				<a style="font-weight: 500; margin-right: 30px"> SMS </a>
				<input type="radio" name="member_sms_agree" value="수신동의">&nbsp수신동의&nbsp&nbsp
				<input type="radio" name="member_sms_agree" value="수신거부">&nbsp수신거부
			</div>
		</td>
	</tr>
</table>
<div class="register-button">
	<input type="button" class="registerButton" value="취소" onClick="location.href='main.mn'">
	<input type="submit" class="registerButton" id="join" value="가입하기">
</div>
</form:form>
</div>


<%@ include file="../main/mainFooter.jsp"%>