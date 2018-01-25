<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lhl28
  Date: 2018/1/25
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
    <c:if test="${1==1}">
        xxxx
    </c:if>
    <%
        List<String> stringList = new ArrayList<String>();
        stringList.add("itcast");
        stringList.add("lhl");
        out.write("1234");
        request.setAttribute("stringList",stringList);
    %>
    <c:forEach items="${stringList}" var="string">
        ${string}
    </c:forEach>


</body>
</html>
