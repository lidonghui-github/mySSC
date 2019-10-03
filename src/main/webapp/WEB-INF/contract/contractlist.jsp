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
<form class="form-inline definewidth m20" action="contract/query"
      method="post">
    关键字： <input type="text" name="keywords" id="keywords"
                class="abc input-default" placeholder="请输入节点编号或者合同号"
                value="${vo.keywords }">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
    &nbsp;&nbsp;
    <button type="button" class="btn btn-success" id="addnew">新建合同占用</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
      <%--  <th colspan="1" height="10px">合同id号</th>--%>
        <th colspan="1" height="10px">合同编号</th>
        <th colspan="1" height="10px">节点编号</th>
        <th colspan="1" height="10px">合同金额</th>
        <th colspan="1" height="10px">创建时间</th>
        <th colspan="1" height="10px">更新时间</th>
        <th colspan="1" height="10px">合同起始日</th>
        <th colspan="1" height="10px">合同到期日</th>
        <th colspan="1" height="10px">版本号</th>
        <th colspan="1" height="10px">备注</th>
        <th colspan="1" height="10px">操作</th>

    </tr>
    </thead>
    <c:forEach items="${pageModel.list}" var="contract">
        <tr>
           <%-- <td>${contract.id}</td>--%>
            <td>${contract.contNo}</td>
            <td>${contract.treeNo}</td>
            <td>${contract.contAmt}</td>
            <td>${contract.crtTimeFormat }</td>
            <td>${contract.updTimeFormat }</td>
            <td>${contract.beginDateFormat}</td>
            <td>${contract.endDateFormat}</td>
            <td>${contract.verNo }</td>
            <td>${contract.remark }</td>
            <td><a href="contract/updatePage/${contract.id}">编辑</a>
                <a id="delete" href="contract/delete/${contract.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="contract/query" id="pager" name="pager" method="post">
    <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page">
    <%@include file="../../pageBar.jsp" %>
</div>
</body>
</html>
<script>
    $(function () {

        $('#addnew').click(function () {
            window.location.href = "<%=path%>/contract/init";
        });

    });

</script>
