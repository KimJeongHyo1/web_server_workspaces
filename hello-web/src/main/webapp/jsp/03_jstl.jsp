<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2023-12-07
  Time: 오후 2:27
  To change this template use File | Settings | File Templates.
--%>

<%--
    JSTL
    - JSP Standard Tag Library
    - JSP에서 사용가능한 액션태그의 한 종류
        - 표준액션태그 <jsp:xxx> -> 많이 안씀
        - 커스텀액션태그 <c:xxx>, <fmt:xxx>, ${fn:xxx}
            - jstl.jar 의존 추가 후 taglib 등록 후 사용
    -
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 기본으로 써두는게 좋음 or 설정해놓기--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JSP | JSTL</title>
</head>
<body>
    <h1>JSTL</h1>
    <h2>core</h2>
    <%-- 분기처리 if --%>
    <c:if test="${num % 2 == 0}">
        <p title="${num}">짝수🍧</p>
    </c:if>
    <c:if test="${num % 2 != 0}">
        <p title="${num}">홀수🍭</p>
    </c:if>


    <%-- 분기처리 choose --%>
    <c:choose>
        <c:when test="${num >= 1 and num < 50 }">
            <p>🐻인형줄게~</p>
        </c:when>
        <c:when test="${num >= 50 and num < 75 }">
            <p>🔫장난감줄게~</p>
        </c:when>
        <c:otherwise>
            <p>꽝🧨</p>
        </c:otherwise>
    </c:choose>


    <%-- 반복처리 forEach --%>
    <%-- 단순반복 증감변수 n의 범위 : begin ~ end (step설정) --%>
    <c:forEach begin="1" end="6" var="n">
        <h${n}>Helloworld${n}</h${n}>
    </c:forEach>

    <%--
        list, 배열 등 반복처리
    --%>
    <ul>
        <c:forEach items="${hobbies}" var="hobby">
            <li>${hobby}</li>
        </c:forEach>
    </ul>

    <table>
        <thead>
            <tr>
                <th>No</th>
                <th>취미</th>
            </tr>
        </thead>
        <tbody>
            <%--
                varStatus 반복상태를 관리하는 객체 이름 지정
                - vs.index : int 반환, 0-based index
                - vs.count : int 반환, 1-based index
                - vs.first : boolean 반환, 첫번째요소 여부
                - vs.last : boolean 반환, 마지막요소 여부
             --%>
            <c:forEach items="${hobbies}" var="h" varStatus="vs">
                <tr>
                    <td>${vs.index}</td>
                    <td>
                        ${vs.first ? '🤘' : ' '}
                        ${vs.last ? '👎' : ' '}
                        ${h}
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <div>
        <%-- 독서, 넷플릭스, 게임, 맛집투어 --%>
        <c:forEach items="${hobbies}" var="ho" varStatus="vs">
            ${ho}${! vs.last ? ',' : ''}
        </c:forEach>
    </div>

    <h2>fmt</h2>
    <a href="https://docs.oracle.com/javase/8/docs/api/java/text/DecimalFormat.html">DecimalFormat</a>
    <a href="https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html">SimpleDateFormat</a>
    <ul>
        <li>
            <fmt:formatNumber value="${no1}" pattern="#,###"/> <%-- 적을거 없으면 뒤에 지워도됌 --%>
        </li>
        <li>
            <%-- # 해당자리수가 없으면 공란처리 --%>
            <%-- 0 해당자리수가 없으면 0처리 --%>
            <fmt:formatNumber value="${no2}" pattern="#,#"/> <%-- 특정자리수까지 반올림처리 --%>
            <fmt:formatNumber value="${no2}" pattern="#,000"/> <%-- 특정자리수까지 반올림처리 --%>
        </li>
        <li>
            <fmt:formatDate value="${today}" pattern="yy/MM/dd(E) hh:mm:ss"/>
        </li>
    </ul>


    <h2>functions</h2>
    <a href="https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/fn/tld-summary.html">함수관련</a>
    <ul>
        <li>${name}</li>
        <li>${fn:toUpperCase(name)}</li>
        <li>${fn:startsWith(name, 'hong')}</li>
        <li>${fn:indexOf(name, 'ng')} ${fn:indexOf(name, 'xxxx')}</li>
        <li>${fn:substring(name, 6, 8)}</li>
        <li>${fn:replace(name, 'gil', '길')}</li>
    </ul>



</body>
</html>
