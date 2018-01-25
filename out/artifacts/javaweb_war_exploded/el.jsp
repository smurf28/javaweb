<%@ page import="com.web.domain.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lhl28
  Date: 2018/1/25
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //存字符串
    request.setAttribute("name","lhl");
    //存对象
    Account account = new Account();
    account.setAccountid(1);
    account.setBalance(123);
    session.setAttribute("account",account);
    //存集合
    List<Account> accounts = new ArrayList<Account>();
    Account account1= new Account();
    account1.setAccountid(2);
    account1.setBalance(345);
    accounts.add(account1);
    accounts.add(account);
    application.setAttribute("accounts",accounts);

%>

<%=request.getAttribute("name")%>
<%
    Account session_account = (Account)session.getAttribute("account");
    out.write("12434");
    out.write(session_account.getBalance());
%>
${requestScope.name}<br>
${sessionScope.account.accountid}<br>
${applicationScope.accounts[0].accountid}
${name}
${account.accountid}
</body>
</html>
