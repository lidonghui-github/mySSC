<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css"/>
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

        @media (max-width: 980px) {
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
<form class="form-inline definewidth m20" action="approval/query" method="post">
    关键字：
    <input type="text" name="keywords" id="keywords" class="abc input-default" placeholder="请输入客户号或批复号或根节点编号"
           value="${vo.keywords }">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
    <button type="button" class="btn btn-success" id="addnew">新增批复</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th colspan="1">批复号</th>
        <th colspan="1">客户号</th>
        <th colspan="1">根节点号</th>
        <th colspan="1">额度类型</th>
        <th colspan="1">授信金额</th>
        <th colspan="1">已用授信金额</th>
        <th colspan="1">冻结授信金额</th>
        <th colspan="1">可用授信金额</th>
        <th colspan="1">额度状态</th>
        <th colspan="1">冻结状态</th>
        <th colspan="1">被纳入标识</th>
        <th colspan="1">被替换标识</th>
        <th colspan="1">额度生效日</th>
        <th colspan="1">额度到期日</th>
        <th colspan="1">创建时间</th>
        <th colspan="1">更新时间</th>
        <th colspan="1">版本号</th>
        <th colspan="1">备注</th>
        <th colspan="1">操作</th>

    </tr>
    </thead>
    <c:forEach items="${pageModel.list}" var="u">
        <tr>
            <td>${u.rescriptumno }</td>
            <td>${u.custNo }</td>
            <td>${u.rootNo }</td>
                <%-- <td>${u.crdtType }</td>--%>
            <td>
                <c:forEach items="${ClBCrCrdtApprCrdtType}" var="v">
                    <c:if test="${v.code ==u.crdtType}"><c:out value="${v.name}"/></c:if>
                </c:forEach>
            </td>
            <td>${u.apprAmt }</td>
            <td>${u.useApprAmt }</td>
            <td>${u.frozApprAmt }</td>
            <td>${u.enabApprAmt }</td>
           <%-- <td>${u.crdtStat }</td>--%>
            <td>
                <c:forEach items="${CreditStatus}" var="v">
                    <c:if test="${v.code ==u.crdtStat}"><c:out value="${v.name}"/></c:if>
                </c:forEach>
            </td>
           <%-- <td>${u.frozStat }</td>--%>
            <td>
                <c:forEach items="${FrozStat}" var="v">
                    <c:if test="${v.code ==u.frozStat}"><c:out value="${v.name}"/></c:if>
                </c:forEach>
            </td>
            <%--<td>${u.covIntoFlag }</td>--%>
            <td>
                <c:forEach items="${IsIf}" var="v">
                    <c:if test="${v.code ==u.covIntoFlag}"><c:out value="${v.name}"/></c:if>
                </c:forEach>
            </td>

           <%-- <td>${u.covReplFlag }</td>--%>
            <td>
            <c:forEach items="${IsIf}" var="v">
                <c:if test="${v.code ==u.covReplFlag}"><c:out value="${v.name}"/></c:if>
            </c:forEach>
            </td>
            <td><fmt:formatDate value="${u.crdtValdDate}" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${u.crdtEndDate }" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${u.crtTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><fmt:formatDate value="${u.updTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${u.verNo }</td>
            <td>${u.remark }</td>
            <td>
                <a href="approval/updatePage/${u.id }">编辑</a>
                <a href="approval/delete/${u.id }" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="approval/query" id="pager" name="pager" method="post">
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

            window.location.href = "<%=path%>/approval/init";
        });


    });

</script>
