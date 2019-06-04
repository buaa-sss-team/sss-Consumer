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
        <div class="col-md-8">
            <h5>
                ${paper.title}
            </h5>
            <p class="text-secondary">${paper.year}</p>
            <p class="text-secondary">${paper.isbn}</p>
            <p>${paper.authorId}</p>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">阅览次数</h5>
                    <p class="card-text">${paper.searchvalue}</p>
                    <h5 class="card-title">下载次数</h5>
                    <p class="card-text">${paper.downvalue}</p>
                </div>
            </div>
        </div>
    </div>
    <h6>摘要</h6>
    <p>${paper.abs}</p>

</div>

<script src="../static/js/alertmodal.js"></script>

</body>
</html>