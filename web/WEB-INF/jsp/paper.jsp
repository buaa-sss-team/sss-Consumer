<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>

<%@ include file="nav.jsp" %>
<div class="container" style="margin-top: 32px">
    <div class="modal fade" id="noteModal" tabindex="-1" role="dialog" aria-labelledby="noteModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="noteModalLabel">错误</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p id="noteModalText">登录失败，请检查您输入的用户名和密码</p>
                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-9">
            <h5 class="title">
                ${paper.title}
            </h5>
            <%--          TODO @母宇婷 看下面  --%>
            <h6 class="year">作者：${authors}</h6>
            <%--          TODO @母宇婷 看上面  --%>
            <h6 class="year">SBN：${paper.isbn}</h6>
            <h6 class="year">发表年份:${paper.year}</h6>
            <div class="row1" >
                <h6 style="margin-top:20px;">摘要:</h6>
                <p>${paper.abs}</p>
            </div>
            <h6 style="fontsize:40px;font-weight:500;margin-top:30px;">关键字:
                <%--          TODO @母宇婷 看下面  --%>
                ${keywords}
                <%--          TODO @母宇婷 看上面  --%>
            </h6>
        </div>
        <div class="col-md-3" >
            <div class="card">
                <div class="card-body">
                    <div class="row" style="margin-top:10px;">
                        <h5 class="contentN" >阅览次数</h5>
                        <p class="contentM">${paper.searchvalue}</p>
                    </div>
                    <div class="row" style="margin-top:10px;">
                        <h5 class="contentN">下载次数</h5>
                        <p class="contentM">${paper.downvalue}</p>
                    </div>
                </div>
                <div class="card-body">
                    <c:if test="${bought}">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                资源下载
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <c:forEach items="${urls}" var="url">
                                    <a class="dropdown-item" href="${url}">${url}</a>
                                </c:forEach>

                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!bought}">
                        <a href="/buy/paper/${paper.id}"><button class="btn btn-secondary">购买全文</button></a></li>
                    </c:if>



                </div>
            </div>
        </div>
    </div>


</div>


<script src="/static/js/alertmodal.js"></script>

</body>
</html>