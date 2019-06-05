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
                <div class="card1" style="margin-top:10px;width:1000px;margin-left:20px">
                    <c:if test="${i%2==0}">
                        <a href="/paper/${papers.get(i/2).id}">
                            <p style="font-size:17px;line-height:50px;"><c:out value='${papers.get(i/2).title}'></c:out></p>
                        </a>
                    </c:if>
                    <c:if test="${i%2!=0}">
                        <a href="/paper/${patents.get((i-1)/2).id}">
                            <p style="font-size:17px;line-height:50px;"><c:out value='${patents.get((i-1)).title}'></c:out></p>
                        </a>
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