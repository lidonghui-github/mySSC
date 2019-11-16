<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form action="approval/save" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <input type="hidden" name="id" value="${approval.id }"/>
        <tr>
            <td width="10%" class="tableleft">批复号</td>
            <td><input type="text" name="rescriptumno" value="${approval.rescriptumno}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">客户号</td>
            <td><input type="text" name="custNo" value="${approval.custNo}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">根节点编号</td>
            <td><input type="text" name="rootNo" value="${approval.rootNo}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">额度类型</td>
            <td>
                <%--<input type="text" name="crdtType" value="${approval.crdtType }"/>--%>
                <select id="crdtType" name="crdtType">
                    <option value="">==请选择额度类型==</option>
                    <c:forEach items="${ClBCrCrdtApprCrdtType}" var="u">
                        <option value="${u.code }" <c:if test="${approval.crdtType==u.code}"><c:out
                                value="selected"/></c:if>>
                                ${u.name}
                        </option>
                    </c:forEach>
                </select>
                <%--<select id="crdtType" name="crdtType">
                    <option value="">==请选择==</option>
                    <option value="1"
                            <c:if test="${approval.crdtType == '1'}">selected</c:if> >打开界面activity
                    </option>
                    <option value="2"
                            <c:if test="${approval.crdtType == '2'}">selected</c:if> >打开优惠网页
                    </option>
                    <option value="3"
                            <c:if test="${approval.crdtType =='3'}">selected</c:if> >优惠产品
                    </option>
                    <option value="4"
                            <c:if test="${approval.crdtType == '4'}">selected</c:if> >点击分享
                    </option>
                </select>--%>

            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">额度状态</td>
            <td>
                <select id="crdtStat" name="crdtStat">
                    <option value="">==请选择额度状态==</option>
                    <c:forEach items="${CreditStatus}" var="u">
                        <option value="${u.code }" <c:if test="${approval.crdtStat==u.code}"><c:out
                                value="selected"/></c:if>>
                                ${u.name}
                        </option>
                    </c:forEach>
                </select>
                <%-- <input type="radio" name="crdtStat" <c:if test="${approval.crdtStat== '01'}">checked="checked"</c:if>>未生效
                 <input type="radio" name="crdtStat" <c:if test="${approval.crdtStat== '02'}">checked="checked"</c:if>>生效
                 <input type="radio" name="crdtStat" <c:if test="${approval.crdtStat== '03'}">checked="checked"</c:if>>失效--%>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">授信金额</td>
            <td><input type="Integer" name="apprAmt" value="${approval.apprAmt}" placeholder="请输入大于0的整数"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">额度生效日</td>
            <td><input type="text" name="crdtValdDate"
                       value="<fmt:formatDate value="${approval.crdtValdDate}" pattern="yyyy-MM-dd"/>"
                       placeholder="请输入日期如1989-02-28"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">额度到期日</td>
            <td><input type="text" name="crdtEndDate"
                       value="<fmt:formatDate value="${approval.crdtEndDate }" pattern="yyyy-MM-dd"/>"
                       placeholder="请输入日期如1990-01-31"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">版本号</td>
            <td><input type="text" readonly="readonly" name="verNo" value="${approval.verNo}" placeholder="非手工录入"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><input type="text" name="remark" value="${approval.remark}"/></td>
        </tr>


        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" name="saveid" id="saveid" class="btn btn-primary">保存</button>

            </td>
        </tr>
    </table>
</form>
<form class="form-inline definewidth m20" action="approval/query"
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
