<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>朱雀搬家后台管理系统</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
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

@media ( max-width : 980px) {
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
	<form class="form-inline definewidth m20" action="driver/query"
		method="post">
		关键字： <input type="text" name="keywords" id="keywords"
			class="abc input-default" placeholder="请输入司机姓名或手机号码"
			value="${vo.keywords }">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增司机</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th colspan="1">司机id</th>
				<th colspan="1">司机姓名</th>
				<th colspan="1">司机性别</th>
				<th colspan="1">司机身份证号码</th>
				<th colspan="1">司机手机号码</th>
				<th colspan="1">司机注册时间</th>
				<th colspan="1">司机运营状态</th>
				<th colspan="1">司机住址</th>
				<th colspan="1">司机已完成订单数</th>
				<th colspan="1">司机当前订单号</th>
				<th colspan="1">司机上次完成订单时间</th>
				<th colspan="1">司机注销时间</th>
				<th colspan="1">备注</th>
				<th colspan="1">操作</th>

			</tr>
		</thead>
		<c:forEach items="${pageModel.list}" var="u">
			<tr>
				<td>${u.driverId }</td>
				<td>${u.driverName }</td>
				<td>${u.driverSex }</td>
				<td>${u.driverIdcardNumber }</td>
				<td>${u.driverTelNumber }</td>
				<td>${u.driverCrtTime }</td>
				<td>${u.driverOperationStatus }</td>
				<td>${u.driverAddress }</td>
				<td>${u.driverFinisedOrderSum }</td>
				<td>${u.driverCurrentOrderNumber }</td>
				<td>${u.driverLastOrderEndTime }</td>
				<td>${u.cancellationTime }</td>
				<td>${u.remark }</td>
				<td><a href="driver/updatePage/${u.driverId }">编辑</a> <a
					href="driver/delete/${u.driverId }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<form action="driver/query" id="pager" name="pager" method="post">
		<input type="hidden" name="pageNum" id="pageNum"
			value="${pageModel.pageNum}"> <input type="hidden"
			name="pageSize" id="pageSize" value="${pageModel.pageSize}">
	</form>
	<div class="inline pull-right page">
		<%@include file="../../pageBar.jsp"%>
	</div>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="<%=path%>/driver/init";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "<%=path%>/driver/query";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
