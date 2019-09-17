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
<form action="driver/save" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <input type="hidden" name="driverId" value="${driver.driverId }"/>
    <tr> 
       
        <td width="10%" class="tableleft">司机姓名</td>
        <td><input type="text" name="driverName" value="${driver.driverName }"/></td>
    </tr>
    <tr>
        <td class="tableleft">性别</td>
        <td><input type="text" name="driverSex" value="${driver.driverSex }"/></td>
    </tr>
  
   
    <tr>
        <td class="tableleft">身份证号</td>
        <td><input type="text" name="driverIdcardNumber" value="${driver.driverIdcardNumber}"/></td>
    </tr> 
     <tr>
        <td class="tableleft">手机号</td>
        <td><input type="text" name="driverTelNumber" value="${driver.driverTelNumber}"/></td>
    </tr> 
      <tr>
        <td class="tableleft">运营状态</td>
        <td><input type="text" name="driverOperationStatus" value="${driver.driverOperationStatus}"/></td>
    </tr>
    <tr>
        <td class="tableleft">住址</td>
        <td><input type="text" name="driverAddress" value="${driver.driverAddress}"/></td>
    </tr>
      <tr>
        <td class="tableleft">备注</td>
        <td><input type="text" name="remark" value="${driver.remark}"/></td>
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
				window.location.href="WEB-INF/driver/driverlist.jsp";
		 });

    });
</script>