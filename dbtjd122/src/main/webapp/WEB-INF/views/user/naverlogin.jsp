<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<html>
  <head>
    <title>네이버로그인</title>
  </head>
  <body>
  <%
    String clientId = "MOm4TZKLMVGoITQ6bl2i";
    String redirectURI = URLEncoder.encode("http://localhost:8080/board/list", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    
    String apiURL = "http://localhost:8080/user";
    apiURL += "MOm4TZKLMVGoITQ6bl2i" + clientId;
    apiURL += "&http://localhost:8080" + redirectURI;
    apiURL += "&dbtjd122=" + state;
    session.setAttribute("dbtjd122", state);
 %>
 <a href="<%=apiURL%>"><img height="50" src="/resources/naverimg/icon1.PNG"/></a>
  </body>
</html>