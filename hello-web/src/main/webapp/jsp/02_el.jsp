<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2023-12-07
  Time: 오후 12:24
  To change this template use File | Settings | File Templates.
--%>
<%--
    EL 내장객체
    - context객체속성 (생략가능, 생략시 page -> request -> session -> application순으로 조회함
        - pageScope -> pageContext.setAttribute 이렇게 쓰면 들어감
        - requestScope -> requestScope.name 이렇게 작성하는데 생략이 가능함
        - sessionScope
        - applicationScope
    - 사용자입력값
        - param
        - paramValues
    - header정보
        - header
        - headerValues
    - 쿠키 cookie
    - PageContext객체 직접 접근

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP | EL</title>
</head>
<body>
    <h1>EL</h1>
    <h2>context내장객체 속성</h2>
    <ul>
                    <%-- 이름 여러개쓰려면 Scope.사용해야함 --%>
        <li>이름 : ${name} ${requestScope.name} ${sessionScope.name}</li>
        <li>숫자 : ${num}</li>
        <li>취미 : ${hobbies}
            <ul>
                <li>${hobbies[0]}</li>
                <li>${hobbies[1]}</li>
                <li>${hobbies[2]}</li>
                <li>${hobbies[3]}</li>
                <li>${hobbies[4]}</li>
            </ul>
        </li>
        <li>책/가격 : ${bookMap}
            <ul>
                <li>${bookMap.MyJava}</li>
                <li>${bookMap['정신이 나가기전']}</li>
                <li>${bookMap["Dr.zang\'s office"]}</li>
            </ul>
        </li>
    </ul>

    <h2>사용자 입력값</h2>
    <ul>
        <li>name : ${param.name}</li>
        <li>option1 : ${paramValues.option[0]}</li>
        <li>option2 : ${paramValues.option[1]}</li>
    </ul>

    <h2>헤더값</h2>
    <ul>
        <li>User-Agent : ${header['user-Agent']}</li>
    </ul>

</body>
</html>
