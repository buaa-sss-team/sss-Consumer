<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>

<%@ include file="nav.jsp" %>
<div class="container" style="margin-top: 32px">

    <div style="font-size:24px;">搜索</div>
    <div class="input-group input-group-lg">
        <div class="input-group-prepend">
            <span class="input-group-text" id="inputGroup-sizing-lg"><svg class="icon" aria-hidden="true" font-size="20px" color="#111111">
            <use xlink:href="#icon-weibiaoti--"></use>
        </svg></span>
        </div>
        <input type="text" class="form-control" id="searchInput" aria-describedby="inputGroup-sizing-lg">
    </div>

    <div class="row">
        <div class="col-md-8" style="margin-top:50px;">
            <c:forEach items="${res}" var="item">
                <div class="card1" style="margin-top:10px;height:100px;width:1000px;margin-left:20px">
                    <a href="/paper/${item.get("id")}" >
                        <p style="font-size:17px;height:50px;"><c:out value='${item.get("title")}'></c:out></p>
                    </a>
                    <div class="row" style="margin-bottom: 10px;">
                        <div style="font-size:13px;width:100px;font-weight:500px;margin-left:20px;">authorid</div>
                        <div style="font-size:13px;width:100px;font-weight:500px;">时间：${item.get("year")}</div>
                        <div style="font-size:13px;width:100px;font-weight:500px;">阅读量：${item.get("searchvalue")}</div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-4">

        </div>

    </div>

</div>


</body>
</html>