<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>

<%@ include file="nav.jsp" %>

<div class="container" style="margin-top: 32px">
    <div class="row" >
        <svg class="icon" aria-hidden="true" style="color:steelblue;font-size:80px;">
            <use xlink:href="#icon-xueshu"></use>
        </svg>
        <div style="width:60%;">
            <h5 style="color:#black;margin-left:4%;">
                ${expert.name}
            </h5>
            <div style="color:#black;margin-left:4%;">${expert.position}</div>
            <div style="color:#black;margin-left:4%;" >${expert.orgs}</div>
        </div>
    </div>
    <div style="height:20px;border-bottom: 1px solid black;">
    </div>
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
        <div class="col-md-8">

<%--            <p>${paper.authorId}</p>--%>
        </div>
        <c:if test="${user.type==0}">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">您是该专家本人？</h5>
                        <a class="btn btn-secondary" href="/tobeexpert/${expert.id}">申请入驻</a>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
    <div style="font-size:15px;font-weight:700;">摘要</div>
    <p>${expert.tags}</p>

</div>

<script src="/static/js/alertmodal.js"></script>

</body>
</html>