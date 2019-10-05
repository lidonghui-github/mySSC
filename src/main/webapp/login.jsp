<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登录页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<center>
    <div id="global">
        <form action="login/login" method="post" name="form1">
            用户名:<input type="text" id="name" name="name" ><br/>
            密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" id="password" name="password"><br/>
            <p>
                <input type="submit" value="登录" onclick="check()">
                <input type="reset" value="清除">
            </p>
        </form>

    </div>
</center>
<%--验证用户名和密码非空  ldh  20191005--%>
<script language="JavaScript">
    function check() {
        if(form1.name.value==""){
            alert("请输入用户名!");
            form1.name.focus();
            return;
        }else if(form1.password.value==""){
            alert("请输入密码!");
            form1.password.focus();
            return;
        }else{
            form1.submit();
        }
    }
</script>
</body>
</html>
