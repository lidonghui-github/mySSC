<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>孔雀搬家后台管理-管理员登录</title>
    <link rel="stylesheet" href="Css/pintuer.css">
    <link rel="stylesheet" href="Css/admin.css">
    <script src="Js/jquery.js"></script>
    <script src="Js/pintuer.js"></script>
    <script src="Js/respond.js"></script>
    <script src="Js/admin.js"></script>
    <link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
    <link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
</head>

<body>
<div class="container">
    <div class="line">
        <div class="xs6 xm4 xs3-move xm4-move">
            <br />
            <br />
            <br />
            <br />
            <form  action="login/login" method="post" name="form1">
                <div class="panel">
                    <div class="panel-head"><strong>登录孔雀搬家后台管理系统</strong></div>
                    <div class="panel-body" style="padding:30px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input"  id="name" name="name" placeholder="登录账号" data-validate="required:请填写账号,length#>=5:账号长度不符合要求" />
                                <span class="icon icon-user"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input" id="password" name="password" placeholder="登录密码" data-validate="required:请填写密码,length#>=8:密码长度不符合要求" />
                                <span class="icon icon-key"></span>
                            </div>
                        </div>
                    </div>
                    <div class="panel-foot text-center">
                        <button  type="submit" class="button button-block bg-main text-big" onclick="check()">立即登录后台</button>
                        <br />
                        <button type="reset" class="button button-block bg-main text-big" >清除</button>
                    </div>
                </div>
            </form>
            <div class="text-right text-small text-gray padding-top">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</div>
        </div>
    </div>
</div>

<div class="hidden">
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
</div>
</body>

</html>