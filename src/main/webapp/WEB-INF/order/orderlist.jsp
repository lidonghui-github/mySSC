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
	<form class="form-inline definewidth m20" action="order/query"
		method="post">
		关键字： <input type="text" name="keywords" id="keywords"
			class="abc input-default" placeholder="请输入订单号或订单客户编号或订单司机编号"
			value="${vo.keywords }">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新建订单</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th colspan="1">订单号</th>
				<th colspan="1">订单创建人编号</th>
				<th colspan="1">订单创建时间</th>
				<th colspan="1">订单更新时间</th>
				<th colspan="1">订单状态</th>
				<th colspan="1">订单执行状态</th>
				<th colspan="1">司机编号</th>
				<th colspan="1">出发地</th>
				<th colspan="1">目的地</th>
				<th colspan="1">订单预约时间</th>
				<th colspan="1">订单更新人编号</th>
				<th colspan="1">订单客户编号</th>
				<th colspan="1">备注</th>
				<th colspan="1">操作</th>

			</tr>
		</thead>
		<c:forEach items="${pageModel.list}" var="u">
			<tr>
				<td>${u.orderNo }</td>
				<td>${u.orderCrtUserNo }</td>
				<td>${u.orderCrtTime }</td>
				<td>${u.orderUpdTime }</td>
				<td>${u.orderStatus }</td>
				<td>${u.orderOperateStatus }</td>
				<td>${u.orderDriverNo }</td>
				<td>${u.orderOrigin }</td>
				<td>${u.orderDestination }</td>
				<td>${u.orderAppointmenTime }</td>
				<td>${u.orderUpdUserNo }</td>
				<td>${u.orderCustomerNo }</td>
				<td>${u.remark }</td>
				<td><a href="order/updatePage/${u.orderNo }">编辑</a> <a
					href="order/delete/${u.orderNo }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<form action="order/query" id="pager" name="pager" method="post">
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

				window.location.href="<%=path%>/order/init";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "<%=path%>/order/query";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
