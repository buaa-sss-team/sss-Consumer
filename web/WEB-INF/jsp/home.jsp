<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%@include file="head.jsp"%>

  </head>
  <body>

    <%@ include file="nav.jsp"%>
    <div class="container" style="margin-top: 32px">
      <div class="row" >
        <svg class="icon" aria-hidden="true" style="color:steelblue;font-size:80px;">
          <use xlink:href="#icon-xueshu"></use>
        </svg>
        <div style="width:60%;">
          <h5 style="color:darkgrey;margin-left:4%;font-size:25px;">Hello!</h5>
          <h5 style="color:#black;margin-left:4%;">
            ${user.account}
          </h5>
        </div>
      </div>
      <div style="height:20px;border-bottom: 1px solid black;">
      </div>
      <div class="row" style="margin-top:4%;">
        <div class="col-md-8">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">${action.id}12</h5>
              <h6 class="card-subtitle mb-2 text-muted" style="font-size:9px;">发布了新的论文</h6>
              <p class="card-text">${action.message}TEST</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card">
            <div class="card-body">
              This is some text within a card body.
            </div>
          </div>
        </div>

      </div>

    </div>



  </body>
</html>