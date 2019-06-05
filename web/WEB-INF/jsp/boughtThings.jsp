<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>

<%@ include file="nav.jsp" %>
<div class="container" style="margin-top: 32px">
    <h1 style="margin-bottom: 24px">我的宝贝</h1>


    <div class="row">
        <div class="col-md-8" style="margin-top:50px;">
            <c:forEach items="${index}" var="i">
                <div class="card1" style="margin-top:10px;height:100px;width:1000px;margin-left:20px">
                    <c:if test="${i%2==0}">
                        <a href="/paper/${papers.get(i/2).id}">
                            <p style="font-size:17px;height:50px;"><c:out value='${papers.get(i/2).title}'></c:out></p>
                        </a>
                        <div class="row" style="margin-bottom: 10px;">
                            <div style="font-size:13px;width:100px;font-weight:500px;margin-left:20px;">authorid</div>
                            <div style="font-size:13px;width:100px;font-weight:500px;">时间：${patent.get(i/2).year}</div>
                            <div style="font-size:13px;width:100px;font-weight:500px;">阅读量：${patent.get(i/2).searchvalue}</div>
                        </div>
                    </c:if>
                    <c:if test="${i%2!=0}">
                        <a href="/paper/${patents.get((i-1)/2).id}">
                            <p style="font-size:17px;height:50px;"><c:out value='${patents.get((i-1)).title}'></c:out></p>
                        </a>
                        <div class="row" style="margin-bottom: 10px;">
                            <div style="font-size:13px;width:100px;font-weight:500px;margin-left:20px;">authorid</div>
                            <div style="font-size:13px;width:100px;font-weight:500px;">时间：${patent.get((i-1)).year}</div>
                            <div style="font-size:13px;width:100px;font-weight:500px;">阅读量：${patent.get((i-1)).searchvalue}</div>
                        </div>
                    </c:if>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-4">

        </div>

    </div>

</div>


</body>
</html>