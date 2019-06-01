<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Test Page</title>
</head>
<body>

<%!
    private int initVar=0;
    private int serviceVar=0;
    private int destroyVar=0;
%>

<%!
    public void jspInit(){
        initVar++;
        System.out.println("jspInit(): JSP被初始化了"+initVar+"次");
    }
    public void jspDestroy(){
        destroyVar++;
        System.out.println("jspDestroy(): JSP被销毁了"+destroyVar+"次");
    }
%>

<%
    serviceVar++;
    System.out.println("_jspService(): JSP共响应了"+serviceVar+"次请求");

    String content1="初始化次数 : "+initVar;
    String content2="响应客户请求次数 : "+serviceVar;
    String content3="销毁次数 : "+destroyVar;
%>
<h1>JSP 测试实例</h1>
<p><%=content1 %></p>
<p><%=content2 %></p>
<p><%=content3 %></p>
<form action="test">
    id号：<input type="text" name="name_id"/><br/>
    <button type="submit">submit</button>
</form>

<form action="fileupload" enctype="multipart/form-data" method="post">
    <p>请选择文件</p>
    <input type="file" name="file">
    <p>上传文件</p>
    <p><input type="submit" value="上传"></p>
</form>

<a href="/filedownload/10091.jpg" >下载10091.jpg</a>
</body>
</html>
