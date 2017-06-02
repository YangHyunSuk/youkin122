<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <html>
    <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>Login Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>
<body>
<a id="custom-login-btn" href="javascript:loginWithKakao()">
<img src="/dbtjd122/resources/naverimg/o.jpg"  width="300"/>
</a>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('13af4fd361bed3680aae7ad76096ee29');
    function loginWithKakao() {
      // 로그인 창을 띄웁니다.
      Kakao.Auth.login({
        success: function(authObj) {
          alert(JSON.stringify(authObj));
        },
        fail: function(err) {
          alert(JSON.stringify(err));
         
          var refreshToken = Kakao.Auth.getRefreshToken();
          Kakao.Auth.setAccessToken(accessTokenFromServer);
			
          
        }
      });
    };


    </script>


</body>
</html>