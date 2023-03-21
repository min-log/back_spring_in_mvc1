<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

  //JSP 에서 request,response 그대로 사용이 가능하다.
  MemberRepository memberRepository = MemberRepository.getInstance();

  //1. 전송 받은 request 값 가져오기
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));
  //2. 비즈니스 로직
  Member member = new Member(username,age);
  Member saveMember = memberRepository.save(member);
%>
<html>
<head>
    <title>회원관리 : 저장 완료</title>
</head>
<body>
  <h2>회원 저장 성공</h2>
  <ul>
    <li>
        id = <%= saveMember.getId() %>
    </li>
    <li>
      user name = <%= saveMember.getUsername() %>
    </li>
    <li>
      age = <%= saveMember.getAge() %>
    </li>
  </ul>
  <a href="/index.html">메인으로 이동</a>
</body>
</html>
