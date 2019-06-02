<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-md navbar-light bg-white fixed-top" id="navmain">
    <a class="navbar-brand" href="/">
        <svg class="icon" aria-hidden="true" font-size="20px" color="#111111">
            <use xlink:href="#icon-xueshu"></use>
        </svg>
        Scholar Social/Search Service
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
                    <input type="text" class="form-control" placeholder="" aria-describedby="button-navsearch">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="button-navsearch">搜索</button>
                    </div>
                </div>
            </li>
            <c:if test="${user==null}">
                <li class="nav-item">
                    <a class="nav-link" href="login">登录</a>
                </li>
            </c:if>
            <c:if test="${user!=null}">
                <li class="nav-item">
                    <a class="nav-link" href="#">${user.getName()}</a>
                </li>
            </c:if>


        </ul>
    </div>
</nav>
<div style="height: 56px">&nbsp;</div>
