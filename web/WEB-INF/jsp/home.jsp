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
          <h5 style="color:black;margin-left:4%;">
            ${currentUserName}
          </h5>
        </div>
      </div>
      <div style="height:20px;border-bottom: 1px solid black;">
      </div>
      <div class="row" style="margin-top:4%;">
        <div class="col-md-8">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">${action.id}Hanseok Ko</h5>
              <h6 class="card-subtitle mb-2 text-muted" style="font-size:9px;">更新了论文</h6>
              <p class="card-text">${action.message}Combined Metabolome and Transcriptome Analysis of Bacillus subtilis Cells Cultured on Dieren t Carbon Sources</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card">
            <div class="card-body">
              通知：2019年6月3日，总部位于美国的IEEE今天宣布，解除对华为员工在论文审稿等方面的限制。
            </div>
          </div>
        </div>
        <div class="col-md-8">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">${action.id}C. M. Serre</h5>
              <h6 class="card-subtitle mb-2 text-muted" style="font-size:9px;">发布了新的论文</h6>
              <p class="card-text">${action.message}Effect of lysophosphatidic acid (LPA) on osteoclastogenesis</p>
            </div>
          </div>
        </div>
        <div class="col-md-8">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">${action.id}C. T. Rios</h5>
              <h6 class="card-subtitle mb-2 text-muted" style="font-size:9px;">发布了新的论文</h6>
              <p class="card-text">${action.message}Influence of Solidification Thermal Parameters on the Microstructure of an Aluminum Alloy</p>
            </div>
          </div>
        </div>
        <div class="col-md-8">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">${action.id}Robust stability of bi-directional associate memory neural networks with time varying delays</h5>
              <h6 class="card-subtitle mb-2 text-muted" style="font-size:9px;">发布了新的论文</h6>
              <p class="card-text">${action.message}Wang Zhan-shan</p>
            </div>
          </div>
        </div>
        <div class="col-md-8">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">${action.id}Sergio Lopez-Buedo</h5>
              <h6 class="card-subtitle mb-2 text-muted" style="font-size:9px;">发布了新的论文</h6>
              <p class="card-text">${action.message}Making visible the thermal behaviour of embedded microprocessors on FPGAs: a progress report</p>
            </div>
          </div>
        </div>


      </div>

    </div>



  </body>
</html>