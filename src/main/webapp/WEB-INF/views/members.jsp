<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <c:forEach var="item" items="${memberList}">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
