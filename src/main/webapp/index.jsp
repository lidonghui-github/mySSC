<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>朱雀搬家后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">
        欢迎您，<span class="dl-log-user">root</span><a href="<%=basePath%>/login/login" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform">
            <div class="dl-inform-title">
                <s class="dl-inform-icon dl-up"></s>
            </div>
        </div>
        <ul id="J_Nav" class="nav-list ks-clear">
            <li class="nav-item dl-selected">
                <div
                        class="nav-item-inner nav-home">系统管理
                </div>
            </li>
            <li class="nav-item dl-selected">
                <div
                        class="nav-item-inner nav-order">司机管理
                </div>
            </li>
            <li class="nav-item dl-selected">
                <div
                        class="nav-item-inner nav-home">客户管理
                </div>
            </li>
            <li class="nav-item dl-selected">
                <div
                        class="nav-item-inner nav-home">订单管理
                </div>
            </li>
            <li class="nav-item dl-selected">
                <div
                        class="nav-item-inner nav-home">登录管理
                </div>
            </li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main', function () {
        var config = [{
            id: '1',
            menu: [{
                text: '系统管理',
                items: [{
                    id: '11',
                    text: '部门管理',
                    href: 'dept/query'
                }, {
                    id: '12',
                    text: '角色管理',
                    href: 'role/query'
                }, {
                    id: '13',
                    text: '用户管理',
                    href: 'user/query'
                }, {
                    id: '14',
                    text: '菜单管理',
                    href: 'menu/query'
                }, {
                    id: '15',
                    text: '数据字典管理',
                    href: 'data/query'
                }]
            }]
        }, {
            id: '2',
            menu: [{
                text: '司机管理模块',
                items: [{
                    id: '21',
                    text: '司机信息管理',
                    href: 'driver/query'
                }, {
                    id: '22',
                    text: '司机当前订单管理',
                    href: 'asset/query'
                }, {
                    id: '23',
                    text: '司机历史订单管理',
                    href: 'asset/query'
                }]
            }]
        }, {
            id: '3',
            menu: [{
                text: '客户管理模块',
                items: [{
                    id: '31',
                    text: '客户信息管理',
                    href: 'checkedout/query'
                }, {
                    id: '32',
                    text: '客户当前订单管理',
                    href: 'checkedout/query'
                }, {
                    id: '33',
                    text: '客户历史订单管理',
                    href: 'checkedout/query'
                }]
            }]
        }, {
            id: '4',
            menu: [{
                text: '订单管理模块',
                items: [{
                    id: '41',
                    text: '订单信息管理',
                    href: 'order/query'
                }, {
                    id: '42',
                    text: '未完成订单管理',
                    href: 'checkedout/query'
                }, {
                    id: '43',
                    text: '已完成订单管理',
                    href: 'checkedout/query'
                }, {
                    id: '44',
                    text: '失效订单管理',
                    href: 'checkedout/query'
                }]
            }]
        },{
            id: '5',
            menu: [{
                text: '登录模块模块',
                items: [{
                    id: '51',
                    text: '订单信息管理',
                    href: 'order/query'
                }, {
                    id: '52',
                    text: '未完成订单管理',
                    href: 'checkedout/query'
                }, {
                    id: '53',
                    text: '已完成订单管理',
                    href: 'checkedout/query'
                }, {
                    id: '54',
                    text: '失效订单管理',
                    href: 'checkedout/query'
                }]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });
</script>
<div style="text-align:center;">
    <p>
        来源：<a href="http://www.baidu.com/" target="_blank">源码之家</a>
    </p>
</div>
</body>
</html>