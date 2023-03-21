<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> memberList = memberRepository.findAll();
%>
<html>
<head>
    <title>회원관리 : 전체 리스트</title>
</head>
<body>

  <a href="/index.html">메인</a>
  <table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
      <%
        for (Member member : memberList) {
          out.write(" <tr>");
          out.write(" <td>" + member.getId() + "</td>");
          out.write(" <td>" + member.getUsername() + "</td>");
          out.write(" <td>" + member.getAge() + "</td>");
          out.write(" </tr>");
        }
      %>
    </tbody>
  </table>
</body>
</html>
