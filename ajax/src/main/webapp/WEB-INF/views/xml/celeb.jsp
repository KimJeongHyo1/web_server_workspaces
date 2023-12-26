<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2023-12-26
  Time: 오후 12:07
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="utf-8" ?>  <%-- xml은 ?시작해 ?끝나기--%>
<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<Celebs>
    <c:forEach items="${celebs}" var="celeb">
    <Celeb>
        <Id>${celeb.id}</Id>
        <Name>${celeb.name}</Name>
        <Profile>${celeb.profile}</Profile>
        <Type>${celeb.type}</Type>
    </Celeb>
    </c:forEach>
</Celebs>