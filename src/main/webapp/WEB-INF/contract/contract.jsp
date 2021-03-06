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
<form action="contract/save" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <input type="hidden" name="id" value="${contract.id}"/>
        <tr>
            <td width="10%" class="tableleft">合同编号</td>
            <td><input type="text" name="contNo" value="${contract.contNo}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">节点编号</td>
            <td><input type="text" name="treeNo" value="${contract.treeNo}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">合同金额</td>
            <td><input type="Integer" name="contAmt" value="${contract.contAmt}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">创建时间</td>
            <td><input type="text"   disabled="disabled" readonly="readonly" name="crtTimeFormat" value="${contract.crtTimeFormat}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">更新时间</td>
            <td><input type="text"   disabled="disabled" readonly="readonly" name="updTimeFormat" value="${contract.updTimeFormat}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">合同起始日</td>
            <td><input type="text" name="beginDateFormat" value="${contract.beginDateFormat}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">合同到期日</td>
            <td><input type="text" name="endDateFormat" value="${contract.endDateFormat}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">版本号</td>
            <td><input type="Integer" disabled="disabled" readonly="readonly" name="verNo" value="${contract.verNo}"/></td>
        </tr>
        <tr>
            <td class="tableleft">备注</td>
            <td><input type="text" name="remark" value="${contract.remark}"/></td>
        </tr>


        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-success" name="saveid" id="saveid" class="btn btn-primary">保存</button>
            </td>
        </tr>
    </table>
</form>
<form class="form-inline definewidth m20" action="contract/query"
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
