<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/style.css"/>
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

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
<form action="treerela/save" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <input type="hidden" name="id" value="${treerela.id }"/>
        <tr>
            <td width="10%" class="tableleft">纳入额度编号</td>
            <td><input type="text" name="bigTreeNo" value="${treerela.bigTreeNo}"/></td>
        </tr>
        <tr>
            <td class="tableleft">被纳入额度编号</td>
            <td><input type="text" name="smallTreeNo" value="${treerela.smallTreeNo}"/></td>
        </tr>
        <tr>
            <td class="tableleft">额度关系类型</td>
            <td><input type="text" name="relaType" value="${treerela.relaType}"/></td>
        </tr>
        <tr>
            <td class="tableleft">是否有效</td>
            <td><input type="text" name="validFlag" value="${treerela.validFlag}"/></td>
        </tr>
        <tr>
            <td class="tableleft">创建时间</td>
            <td><input type="text" readonly="true" name="crtTimeFormat" value="${treerela.crtTimeFormat}"/></td>
        </tr>
        <tr>
            <td class="tableleft">更新时间</td>
            <td><input type="Integer"  readonly="true"  name="updTimeFromat" value="${treerela.updTimeFromat}"/></td>
        </tr>
        <tr>
            <td class="tableleft">版本号</td>
            <td><input type="Integer" readonly="true" name="verNo" value="${treerela.verNo}"/></td>
        </tr>
        <tr>
            <td class="tableleft">备注</td>
            <td><input type="text" name="remark" value="${treerela.remark}"/></td>
        </tr>


        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" name="saveid" id="saveid" class="btn btn-primary">保存</button>
                <%--<button type="submit" class="btn btn-primary" name="backid" id="backid">返回列表</button>--%>

            </td>
        </tr>
    </table>
</form>
<form class="form-inline definewidth m20" action="treerela/query"
      method="post">

    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</form>
</body>
</html>
