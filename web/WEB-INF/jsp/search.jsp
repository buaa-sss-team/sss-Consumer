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
                <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <c:if test='${row.equals("")}'>智能搜索</c:if>
                    <c:if test='${row.equals("keywords")}'>关键词</c:if>
                    <c:if test='${row.equals("title")}'>标题</c:if>
                    <c:if test='${row.equals("abstract")}'>摘要</c:if>
                    <c:if test='${row.equals("name")}'>名字</c:if>
                    <c:if test='${row.equals("orgs")}'>机构</c:if>
                    <c:if test='${row.equals("tags")}'>研究领域</c:if>

                </button>
                <div class="dropdown-menu">
                    <c:if test='${category.equals("paper")}'>
                      <a class="dropdown-item" href="/search/paper/${keyword}">智能搜索</a>
                    <div role="separator" class="dropdown-divider"></div>
                      <a class="dropdown-item" href="/search/paper/${keyword}/keywords">关键词</a>
                      <a class="dropdown-item" href="/search/paper/${keyword}/title">标题</a>
                      <a class="dropdown-item" href="/search/paper/${keyword}/abstract">摘要</a>
                    </c:if>
                    <c:if test='${category.equals("expert")}'>
                        <a class="dropdown-item" href="/search/expert/${keyword}">智能搜索</a>
                        <div role="separator" class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/search/expert/${keyword}/name">名字</a>
                        <a class="dropdown-item" href="/search/expert/${keyword}/orgs">机构</a>
                        <a class="dropdown-item" href="/search/expert/${keyword}/tags">研究领域</a>
                    </c:if>

                </div>
        </div>
        <input type="text" class="form-control" id="searchInput" aria-describedby="inputGroup-sizing-lg" value="${keyword}">
        <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button" id="btnSearch">搜索</button>
        </div>
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
                <c:forEach items="${res}" var="item">
                    <div class="card1" style="margin-top:10px;height:100px;width:1000px;margin-left:20px">
                        <a href="/paper/${item.get("id")}" >
                            <p style="font-size:17px;height:50px;"><c:out value='${item.get("title")}'></c:out></p>
                        </a>
                        <div class="row" style="margin-bottom: 10px;">
                            <div style="font-size:13px;width:100px;font-weight:500px;margin-left:20px;">${item.get("authorname")}</div>
                            <div style="font-size:13px;width:100px;font-weight:500px;">时间：${item.get("year")}</div>
                            <div style="font-size:13px;width:100px;font-weight:500px;">阅读量：${item.get("searchvalue")}</div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test='${category.equals("expert")}'>
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link" href="/search/paper/${keyword}" aria-selected="false">论文</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#" aria-selected="true">专家</a>
                    </li>
                </ul>
                <c:forEach items="${res}" var="item">
                    <div class="card1" style="margin-top:10px;height:100px;width:1000px;margin-left:20px">
                        <a href="/expert/${item.get("id")}" >
                            <p style="font-size:17px;height:50px;"><c:out value='${item.get("name")}'></c:out></p>
                        </a>
                        <div class="row" style="margin-bottom: 10px;">
                            <div style="font-size:13px;width:100px;font-weight:500px;margin-left:20px;">职称：${item.get("position")}</div>
                            <div style="font-size:13px;width:100px;font-weight:500px;">单位：${item.get("org")}</div>
                            <div style="font-size:13px;width:100px;font-weight:500px;">著作数量：${item.get("pubCount")}</div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>


        </div>
        <div class="col-md-4">

        </div>

    </div>

</div>


</body>
</html>