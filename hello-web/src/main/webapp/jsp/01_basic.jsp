<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2023-12-07
  Time: 오전 11:19
  To change this template use File | Settings | File Templates.
--%>

<%--
    JSP
    - Java + HTML(이라고 생각할 수 있음)
    - 모든 jsp는 Servlet으로 변환되어 서비스된다
    - jsp의 모든 java코드는 서버단에서 먼저 처리된 후 그 결과만 html형식으로 클라이언트에 전달된다

    구성요소
    1. Java
        a. 지시어(설정) <%@ page %>, <%@ include %>, <% talib %>
        b. 스크립팅원소 <% %>, <%= %>, <%! %>
    2. EL ${}
    3. JSTL

    내장객체 (선언없이 사용할 수 있는 객체)
    1. context객체 (서버운영에 필요한 정보를 가지고, 각기 다른 생명주기를 가진 객체)
        - pageContext : PageContext (JSP처리기간동안만 사용가능)
        - request : HttpServletRequest (사용자 요청정보를 가진 객체, 요청 ~ 응답까지 사용가능)
        - session : HttpSession (사용자 첫 접속 ~ 접속해제까지 사용가능)
        - application : ServletContext (서버시작 ~ 서버종료까지 사용가능)
    2. response : HttpServletResponse 응답관련 처리를 위한 객체
    3. out : PrintWriter 응답 출력스트림


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 자바영역
    // 한줄 주석
    /*
        여러줄주석
    */
    System.out.println("Basic.jsp");

    int sum = 0;
    for(int i = 1; i <=100; i++){
        sum += i;
    }
    System.out.println(sum);


    long millis = System.currentTimeMillis();


    // context객체에 속성으로 대입 -> EL에서 사용가능
    pageContext.setAttribute("sum", sum);
    pageContext.setAttribute("millis", millis);


%>
<html>
<body>
    <h1>Basics</h1>
    <%-- 자바코드가 먼저 실행됨--%>

    <h2>1 ~ 100까지의 합</h2>
        <p id="sumFromServer"><%= sum %></p>
        <%-- el로 적고싶으면 --%>
        <p id="sumFromServer">${sum}</p>
        <p id="sumFromClient"></p>

    <h2>현재 시각(밀리초)</h2>
        <p id="nowFromServer"><%= millis %></p>
        <p id="nowFromServer">${millis}</p>
        <p id="nowFromClient"></p>

    <%-- jsp주석 : servlet변환 과정에서 제거된다 (안보임)--%>
    <!-- html주석 : client까지 전달 (보임)-->

    <script>
        let sum = 0;
        for(let i = 1; i <= 100; i++)
            sum += i;
        document.querySelector("#sumFromClient").innerHTML = sum;

        const millis = Date.now();
        document.querySelector("#nowFromClient").innerHTML = Date.now();
    </script>



</body>
<head>
    <title>JSP | Basics</title>
</head>
</html>
