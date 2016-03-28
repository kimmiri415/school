<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
	<style type="text/css">
		#login{margin-top: 5em;	}
	</style>

	<div id="login">
		<div class="loginTop text-center" >
			<img src="${context}/resources/img/member/simpson.jpeg" id="paper_plane"  />
		</div>
		
		<form>
		<div class="loginCenter row" style="margin-left: 43.5%;">
		<h3>관리자 로그인 폼</h3>
		<br />
				<fieldset class="loginField">
					<div class="form-group">
					 	<label for="input_id" class="control-label sr-only">아이디</label>
					 	<div class="col-sm-3">
							<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="control-label sr-only">비밀번호</label>
					 	<div class="col-sm-3">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
						</div>
					</div>
				</fieldset>
		</div>
		<div class="input_button text-center">
			<img src="${context}/resources/img/member/login.jpg" alt="" id="loginButton" />
		</div>
		</form>
	</div>
</body>
<script>
	$(function() {
		$('form').addClass("form-horizontal").attr('action' ,'${context}/admin/login.do').attr('method','post');
		$('#paper_plane').css('border','0').css('height','260px').css('width','360px').css('margin-bottom','20px');
		$('#loginButton').css('width', '100px');
		$('#loginButton').click(function() {
		$('form').submit();
		});
	});
</script>
</html>