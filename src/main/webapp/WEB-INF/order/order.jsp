<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
 <base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
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
<form action="order/save" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <input type="hidden" name="orderNo" value="${order.orderNo }"/>
    <tr> 
       
        <td width="10%" class="tableleft">订单创建人编号</td>
        <td><input type="text" name="orderCrtUserNo" value="${order.orderCrtUserNo }"/></td>
    </tr>
    <tr>
        <td class="tableleft">订单状态</td>
        <td><input type="text" name="orderStatus" value="${order.orderStatus }"/></td>
    </tr>
  
   
    <tr>
        <td class="tableleft">订单执行状态</td>
        <td><input type="text" name="orderOperateStatus" value="${order.orderOperateStatus}"/></td>
    </tr> 
     <tr>
        <td class="tableleft">司机编号</td>
        <td><input type="text" name="orderDriverNo" value="${order.orderDriverNo}"/></td>
    </tr> 
      <tr>
        <td class="tableleft">出发地</td>
        <td><input type="text" name="orderOrigin" value="${order.orderOrigin}"/></td>
    </tr>
    <tr>
        <td class="tableleft">目的地</td>
        <td><input type="text" name="orderDestination" value="${order.orderDestination}"/></td>
    </tr>
  <%--     <tr>
        <td class="tableleft">订单预约时间</td>
        <td><input type="text" name="orderAppointmenTime" value="${order.orderAppointmenTime}"/></td>
    </tr> --%>
     <tr>
        <td class="tableleft">订单更新人编号</td>
        <td><input type="text" name="orderUpdUserNo" value="${order.orderUpdUserNo}"/></td>
    </tr>
     <tr>
        <td class="tableleft">订单客户编号</td>
        <td><input type="text" name="orderCustomerNo" value="${order.orderCustomerNo}"/></td>
    </tr>
      <tr>
        <td class="tableleft">备注</td>
        <td><input type="text" name="remark" value="${order.remark}"/></td>
    </tr>
  
  
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" >保存</button>
             &nbsp;&nbsp;<button type="submit" class="btn btn-primary" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="WEB-INF/order/driverlist.jsp";
		 });

    });
</script>