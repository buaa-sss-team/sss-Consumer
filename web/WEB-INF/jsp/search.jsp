<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>

<%@ include file="nav.jsp" %>
<div class="container" style="margin-top: 32px">
    <h1 style="margin-bottom: 24px">搜索</h1>
    <div class="input-group input-group-lg">
        <div class="input-group-prepend">
            <span class="input-group-text" id="inputGroup-sizing-lg"><svg class="icon" aria-hidden="true" font-size="20px" color="#111111">
            <use xlink:href="#icon-weibiaoti--"></use>
        </svg></span>
        </div>
        <input type="text" class="form-control" id="searchInput" aria-describedby="inputGroup-sizing-lg">
    </div>
    <div class="row">
        <div class="col-md-8">
            <c:forEach items="${res}" var="item">
                <a href="/paper/${item.get("id")}">
                    <p><c:out value='${item.get("title")}'></c:out></p>
                </a>


            </c:forEach>
        </div>
        <div class="col-md-4">

        </div>

    </div>

</div>


</body>
</html>