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
<form class="form-inline definewidth m20" action="tree/query"
      method="post">
    关键字： <input type="text" name="keywords" id="keywords"
                class="abc input-default" placeholder="请输入节点编号或者批复编号"
                value="${vo.keywords }">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
    &nbsp;&nbsp;
    <button type="button" class="btn btn-success" id="addnew">新建额度节点</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th colspan="1" >节点id号</th>
        <th colspan="1">节点号</th>
        <th colspan="1">节点名称</th>
        <th colspan="1">上级节点号</th>
        <th colspan="1">批复号</th>
        <th colspan="1">额度状态</th>
        <th colspan="1">冻结状态</th>
        <th colspan="1">授信金额</th>
        <th colspan="1">已用授信金额</th>
        <th colspan="1">冻结授信金额</th>
        <th colspan="1">可用授信金额</th>
        <th colspan="1">创建时间</th>
        <th colspan="1">更新时间</th>
        <th colspan="1">版本号</th>
        <th colspan="1">备注</th>
        <th colspan="1">操作</th>

    </tr>
    </thead>
    <c:forEach items="${pageModel.list}" var="tree">
        <tr>
            <td >${tree.id}</td>
            <td>${tree.treeNo}</td>
            <td>${tree.treeName }</td>
            <td>${tree.upTreeNo }</td>
            <td>${tree.apprNo }</td>
            <td>${tree.crdtStat }</td>
            <td>${tree.frozStat }</td>
            <td>${tree.apprAmt }</td>
            <td>${tree.usedAmt }</td>
            <td>${tree.frozAmt }</td>
            <td>${tree.enabAmt }</td>
            <td>${tree.crtTimeFormat }</td>
            <td>${tree.updTimeFormat }</td>
            <td>${tree.verNo }</td>
            <td>${tree.remark }</td>

            <td><a href="tree/updatePage/${tree.id }">编辑</a>
                <a id="delete" href="tree/delete/${tree.id }">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="tree/query" id="pager" name="pager" method="post">
    <input type="hidden" name="pageNum" id="pageNum"
           value="${pageModel.pageNum}"> <input type="hidden"
                                                name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page">
    <%@include file="../../pageBar.jsp" %>
</div>
</body>
</html>
<script>
    $(function () {


        $('#addnew').click(function () {

            window.location.href = "<%=path%>/tree/init";
        });
        $('#delete').click(function () {
            if (confirm("确定要删除吗？")) {

                var url = "<%=path%>/tree/query";

                window.location.href = url;

            }
        });

    });

</script>
