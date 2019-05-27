<%--
  Created by IntelliJ IDEA.
  User: EnTaroZeratul
  Date: 2019/5/23
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    查询结果：
    <p>账号:${account}</p>
    <p>密码:${pwd}</p>
    <br/>
    <c:forEach items="${userlist}" var="user">
        <p>${user.id}</p>
        <p>${user.account}</p>
        <p>${user.pwd}</p>
    </c:forEach>
</body>
</html>
