<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원관리 : 저장 완료</title>
</head>
<body>
<h2>회원 저장 성공</h2>
<ul>
    <li>
        id = ${member.id}
    </li>
    <li>
        user name = ${member.username}
    </li>
    <li>
        age = ${member.age}
    </li>
</ul>
<a href="/index.html">메인으로 이동</a>
</body>
</html>