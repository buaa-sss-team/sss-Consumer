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
            <h1 style="margin-bottom: 24px">个人信息</h1>
            <form style="padding: 0 4px" method="post">
                <div class="form-group">
                    <label for="regUsername">用户名</label>
                    <input type="text" class="form-control" id="regUsername" name="username" placeholder="" value="${user.account}" disabled>
                </div>
                <div class="form-group">
                    <label for="oldPwd">当前密码（必填）</label>
                    <input type="password" class="form-control" id="oldPwd" name="password" placeholder="">
                </div>
                <div class="form-group">
                    <label for="newPwd">新密码（留空则不变）</label>
                    <input type="password" class="form-control" id="newPwd" name="newpassword" placeholder="">
                </div>
                <div class="form-group">
                    <label for="regTel">手机号码</label>
                    <input type="tel" class="form-control" id="regTel" name="tel" placeholder="" value="${tel}">
                </div>
                <div class="form-group">
                    <label for="regDoB">生日</label>
                    <input type="date" class="form-control" id="regDoB" name="birthday" placeholder="" value="${birthday}">
                </div>
                <div class="form-group">
                    <label for="regOrg">所在单位</label>
                    <input type="text" class="form-control" id="regOrg" name="org" placeholder="" value="${org}">
                </div>
                <button type="submit" class="btn btn-primary" style="margin-top: 24px;width: 96px">修改</button>
            </form>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    申请成为专家
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><button class="btn btn-secondary">申请</button></li>
                </ul>
            </div>
            <div class="card">
                <div class="card-header">
                    余额管理
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">余额：${user.credit}</li>
                    <li class="list-group-item"><button class="btn btn-secondary">充值</button></li>
                </ul>
            </div>
        </div>

    </div>

</div>

<script src="../static/js/alertmodal.js"></script>

</body>
</html>