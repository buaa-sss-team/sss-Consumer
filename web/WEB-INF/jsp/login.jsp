<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/6/1
  Time: 下午 5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>

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
</div><div class="modal fade" id="noteModalLoginFirst" tabindex="-1" role="dialog" aria-labelledby="noteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="noteModalLabelLoginFirst">错误</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="noteModalTextLoginFirst">登录后方可使用该功能</p>
            </div>
        </div>
    </div>
</div>


    <div class="container" style="width: 576px;margin-top: 56px">
        <div class="card">
            <div class="card-body">

                <a href="home.jsp" class="navbar-brand" style="margin-bottom: 16px;color: rgba(0, 0, 0, 0.9);"><svg class="icon" aria-hidden="true" font-size="20px" color="#111111">
                    <use xlink:href="#icon-xueshu"></use>
                </svg>
                    Scholar Social/Search Service</a>

                <form style="padding: 0 4px" method="post">
                    <div class="form-group">
                        <label for="loginUsername">用户名</label>
                        <input type="text" class="form-control" name="username" id="loginUsername" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="loginPwd">密码</label>
                        <input type="password" class="form-control" name="password" id="loginPwd" placeholder="">
                    </div>
<%--                    <div class="form-group form-check">--%>
<%--                        <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
<%--                        <label class="form-check-label" for="exampleCheck1">自动登录</label>--%>
<%--                    </div>--%>
                    <button type="submit" class="btn btn-primary btn-block" style="margin-top: 24px">登录</button>
                    <button class="btn btn-outline-secondary btn-block" style="margin-top: 24px">忘记密码？</button>


                </form>
            </div>
        </div>

    </div>

    <script src="../static/js/alertmodal.js"></script>
</body>
</html>
