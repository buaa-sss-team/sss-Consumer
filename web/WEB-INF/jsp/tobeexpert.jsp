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
                    <p id="noteModalText">修改失败，请检查您输入的信息</p>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="noteModalOK" tabindex="-1" role="dialog" aria-labelledby="noteModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="noteModalLabelOK">成功</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p id="noteModalTextOK">修改成功</p>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-8">
            <h1 style="margin-bottom: 24px">专家申请</h1>
            <form style="padding: 0 4px" method="post">
                <div class="form-group">
                    <label for="regUsername">用户名</label>
                    <input type="text" class="form-control" id="regUsername" name="username" placeholder="" value="${user.account}" disabled>
                </div>
                <div class="form-group">
                    <label for="expertId">专家ID</label>
                    <input type="text" class="form-control" id="expertId" name="expertId" placeholder="" value="${expert.id}" disabled>
                </div>
                <div class="form-group">
                    <label for="expertname">专家名</label>
                    <input type="text" class="form-control" id="expertname" name="expertname" placeholder="" value="${expert.name}" disabled>
                </div>
                <div class="form-group">
                    <label for="oldPwd">当前密码（必填）</label>
                    <input type="password" class="form-control" id="oldPwd" name="password" placeholder="">
                </div>
                <div class="form-group">
                    <label for="personalIdNumber">身份证</label>
                    <input type="text" class="form-control" id="personalIdNumber" name="personalIdNumber" placeholder="">
                </div>
                <div class="form-group">
                    <label for="message">备注</label>
                    <input type="text" class="form-control" id="message" name="message" placeholder="">
                </div>
                <button type="submit" class="btn btn-primary" style="margin-top: 24px;width: 96px">提交</button>
            </form>
        </div>
        <div class="col-md-4">

        </div>

    </div>

</div>

<script src="../static/js/alertmodal.js"></script>

</body>
</html>