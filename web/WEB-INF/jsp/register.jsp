<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp" %>
    <link rel="stylesheet" href="css/main.css">
    <title>SSS - 学术社群服务</title>
    <script src="js/index.js"></script>
</head>
<body>

<%@ include file="nav.jsp" %>
<div class="container" style="margin-top: 32px">


    <div class="row">
        <div class="col-md-8">
            <h1 style="margin-bottom: 24px">注册</h1>
            <form style="padding: 0 4px">
                <div class="form-group">
                    <label for="regUsername">用户名</label>
                    <input type="email" class="form-control" id="regUsername" aria-describedby="emailHelp" placeholder="">
                </div>
                <div class="form-group">
                    <label for="regPwd">密码</label>
                    <input type="password" class="form-control" id="regPwd" placeholder="">
                </div>
                <div class="form-group">
                    <label for="regTel">手机号码</label>
                    <input type="tel" class="form-control" id="regTel" placeholder="">
                </div>
                <div class="form-group">
                    <label for="regDoB">生日</label>
                    <input type="date" class="form-control" id="regDoB" placeholder="">
                </div>
                <div class="form-group">
                    <label for="regOrg">所在单位</label>
                    <input type="text" class="form-control" id="regOrg" placeholder="">
                </div>
                <button type="submit" class="btn btn-primary" style="margin-top: 24px;width: 96px">注册</button>


            </form>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    现在注册
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">搜索学术文献</li>
                    <li class="list-group-item">购买学术资源</li>
                    <li class="list-group-item">寻找专家协助</li>
                </ul>
            </div>
        </div>

    </div>

</div>


</body>
</html>