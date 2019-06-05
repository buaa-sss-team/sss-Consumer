<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>

<%@ include file="nav.jsp" %>
<div class="container" style="margin-top: 32px">

    <svg class="icon" aria-hidden="true" style="color:steelblue;font-size:200px;margin-left:40%;">
        <use xlink:href="#icon-xueshu"></use>
    </svg>
    <div class="input-group input-group-lg" style="margin-top:5%;">
        <div class="input-group-prepend">
            <span class="input-group-text" id="inputGroup-sizing-lg"><svg class="icon" aria-hidden="true" font-size="20px" color="#111111">
            <use xlink:href="#icon-weibiaoti--"></use>
        </svg></span>
        </div>
        <input type="text" class="form-control" id="searchInput" aria-describedby="inputGroup-sizing-lg" value="${keyword}">
    </div>

    <div class="row">
        <div class="col-md-8" style="margin-top:50px;">
            <c:if test='${category.equals("paper")}'>
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" href="#" aria-selected="true">论文</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/search/expert/${keyword}" aria-selected="false">专家</a>
                    </li>
                </ul>
            </c:if>
            <c:if test='${category.equals("expert")}'>
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link " href="/search/paper/${keyword}"  aria-selected="false">论文</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#" aria-selected="true">专家</a>
                    </li>
                </ul>
            </c:if>

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