<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>

<%@ include file="nav.jsp" %>
<div class="container" style="margin-top: 32px">
    <h1 style="margin-bottom: 24px">申请审核</h1>

    <div class="row">
        <div class="col-md-8">
            <c:forEach items="${applist}" var="app" varStatus="i">
                <p>用户ID：${app.userid}</p>
                <p>用户名：${appextra.get(i.index).get("userName")}</p>
                <p>专家ID：${appextra.get(i.index).get("expert")}</p>
                <p>专家名：${appextra.get(i.index).get("expertName")}</p>
                <p>申请身份证号：${appextra.get(i.index).get("PersonalIdNumber")}</p>
                <p>申请备注：${appextra.get(i.index).get("message")}</p>
                <a class="btn btn-primary" href="/review/${app.id}/a">接受</a>
                <a class="btn btn-secondary"  href="/review/${app.id}/r">拒绝</a>
            </c:forEach>
        </div>
        <div class="col-md-4">

        </div>

    </div>

</div>


</body>
</html>