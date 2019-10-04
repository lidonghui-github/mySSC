<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>朱雀搬家后台管理系统</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="Css/style.css"/>
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>


    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media ( max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="treerela/glquery"
      method="post">
    关键字： <input type="text" name="keywords" id="keywords"
                class="abc input-default" placeholder="请输入纳入额度编号或者被纳入编号"
                value="${vo.keywords }">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <%-- <th colspan="1" height="10px">节点id号</th>--%>
        <th colspan="1" height="10px">纳入额度编号</th>
        <th colspan="1" height="10px">被纳入额度编号</th>
        <th colspan="1" height="10px">额度关系类型</th>
        <th colspan="1" height="10px">是否有效</th>       
        <th colspan="1" height="10px">创建时间</th>
        <th colspan="1" height="10px">更新时间</th>
        <th colspan="1" height="10px">版本号</th>
        <th colspan="1" height="10px">备注</th>


    </tr>
    </thead>
    <c:forEach items="${pageModel.list}" var="treerela">
        <tr>
                <%-- <td>${treerela.id}</td>--%>
            <td>${treerela.bigTreeNo}</td>
            <td>${treerela.smallTreeNo }</td>
            <td>${treerela.relaType }</td>
            <td>${treerela.validFlag }</td>            
            <td>${treerela.crtTimeFormat }</td>
            <td>${treerela.updTimeFromat }</td>
            <td>${treerela.verNo }</td>
            <td>${treerela.remark }</td>
        </tr>
    </c:forEach>
</table>
<form action="treerela/glquery" id="pager" name="pager" method="post">
    <input type="hidden" name="pageNum" id="pageNum"
           value="${pageModel.pageNum}"> <input type="hidden"
                                                name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page">
    <%@include file="../../pageBar.jsp" %>
</div>
</body>
</html>

