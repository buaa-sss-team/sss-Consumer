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
            <h1 style="margin-bottom: 24px">添加论文</h1>
            <form style="padding: 0 4px" method="post" enctype="multipart/form-data" >

                <div class="form-group">
                    <label for="paperTitle">标题</label>
                    <input type="text" class="form-control" id="paperTitle" name="paperTitle" placeholder="">
                </div>
                <div class="form-group">
                    <label for="paperISBN">ISBN</label>
                    <input type="text" class="form-control" id="paperISBN" name="paperISBN" placeholder="">
                </div>
                <div class="form-group">
                    <label for="paperCost">定价</label>
                    <input type="text" class="form-control" id="paperCost" name="paperCost" placeholder="">
                </div>
                <div class="form-group">
                    <label for="paperYear">发表年份</label>
                    <input type="text" class="form-control" id="paperYear" name="paperYear" placeholder="">
                </div>
                <div class="form-group">
                    <label for="paperOrg">发表刊物</label>
                    <input type="text" class="form-control" id="paperOrg" name="paperOrg" placeholder="">
                </div>
                <div class="form-group">
                    <label for="paperAuthors">除自己以外的作者（请使用竖线“|”分隔）</label>
                    <input type="text" class="form-control" id="paperAuthors" name="paperAuthors" placeholder="">
                </div>
                <div class="form-group">
                    <label for="paperAbs">摘要</label>
                    <input type="text" class="form-control" id="paperAbs" name="paperAbs" placeholder="">
                </div>
                <div class="form-group">
                    <label for="oldPwd">当前密码（必填）</label>
                    <input type="password" class="form-control" id="oldPwd" name="password" placeholder="">
                </div>
                <div class="form-group">
                    <input type="file" class="form-control" id="uploadUrl" name="file" placeholder="">
                </div>

                <button type="submit" class="btn btn-primary" style="margin-top: 24px;width: 96px">提交</button>
            </form>
        </div>
        <div class="col-md-4">

        </div>

    </div>

</div>

<script src="/static/js/alertmodal.js"></script>


</body>
</html>