<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-md navbar-dark bg-steelblue fixed-top" id="navmain">
    <a class="navbar-brand" href="/">
        <svg class="icon" aria-hidden="true"  color="white">
            <use xlink:href="#icon-xueshu"></use>
        </svg>
        <span style="color:white;">
            Scholar Social/Search Service
        </span>
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
<%--                <div class="input-group" style="width:auto;padding-left: 0.8rem;padding-right: 0.8rem">--%>
<%--                    <input type="text" class="form-control">--%>
<%--                    <span class="input-group-btn">--%>
<%--                        <button class="btn btn-outline-secondary" type="button">搜索</button>--%>
<%--                    </span>--%>
<%--                </div><!-- /input-group -->--%>
    <div class="input-group input-group-sm" style="margin-top:5px; width:auto;padding-left: 0.8rem;padding-right: 0.8rem">
        <input type="text" class="form-control" placeholder="" aria-describedby="btnNavSearch" id="inputNavSearch">
        <div class="input-group-append">
            <button class="btn btn-primary" type="button" id="btnNavSearch" style="color:white;">搜索</button>
        </div>
    </div>
            </li>
            <c:if test="${user==null}">
                <li class="nav-item">
                    <a class="nav-link" href="/login">登录</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">注册</a>
                </li>
            </c:if>
            <c:if test="${user!=null}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${user.getAccount()}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/account">个人信息</a>
                        <a class="dropdown-item" href="/bought">已买到的资源</a>
                        <c:if test="${user.type==-1}">
                            <a class="dropdown-item" href="/review">审核专家申请</a>
                        </c:if>
                        <c:if test="${user.type>0}">
                            <a class="dropdown-item" href="/addpaper">登记新论文</a>
                        </c:if>
                        <a class="dropdown-item" href="/logout">登出</a>
                    </div>
                </li>

            </c:if>


        </ul>
    </div>
</nav>
<div style="height: 56px">&nbsp;</div>
