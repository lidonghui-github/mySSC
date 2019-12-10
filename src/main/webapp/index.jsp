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
<script type="text/javascript">
    function showTime() {
        var  span=document.getElementById("mySpan");
        var  date=new Date();
        span.innerHTML=date.toLocaleString();

    }
    window.setInterval('showTime();',1000);
</script>
<body>

<div class="header">

    <div class="dl-title">

    </div>
    <div class="dl-log">
        欢迎您，<span class="dl-log-user">用户:${sessionScope.username}</span>
        <input type="button" value="清理缓存" onclick="alert('清理成功!');"/>
        当前时间:<span id="mySpan"></span>
        <a href="<%=basePath%>/login/login" title="退出系统" class="dl-log-quit">[退出]</a><br/>
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
            <li class="nav-item dl-selected">
                <div
                        class="nav-item-inner nav-home">额度管理
                </div>
            </li>
            <li class="nav-item dl-selected">
                <div
                        class="nav-item-inner nav-home">合同模块
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
                    id: '1-1-1',
                    text: '部门管理',
                    href: 'dept/query'
                }, {
                    id: '1-1-2',
                    text: '角色管理',
                    href: 'role/query'
                }, {
                    id: '1-1-3',
                    text: '用户管理',
                    href: 'user/query'
                }, {
                    id: '1-1-4',
                    text: '菜单管理',
                    href: 'menu/query'
                }, {
                    id: '1-1-5',
                    text: '数据字典管理',
                    href: 'data/query'
                }]
            },{
                text: '系统管理2',
                items: [{
                    id: '1-2-1',
                    text: '部门管理',
                    href: 'dept/query'
                }, {
                    id: '1-2-2',
                    text: '角色管理',
                    href: 'role/query'
                }, {
                    id: '1-2-3',
                    text: '用户管理',
                    href: 'user/query'
                }, {
                    id: '1-2-4',
                    text: '菜单管理',
                    href: 'menu/query'
                }, {
                    id: '1-2-5',
                    text: '数据字典管理',
                    href: 'data/query'
                }]
            },{
                text: '批复管理',
                items: [{
                    id: '1-3-1',
                    text: '批复信息管理',
                    href: 'approval/query'
                }]
            }]
        }, {
            id: '2',
            menu: [{
                text: '司机管理模块',
                items: [{
                    id: '2-1-1',
                    text: '司机信息管理',
                    href: 'driver/query'
                }, {
                    id: '2-1-2',
                    text: '司机当前订单管理',
                    href: 'asset/query'
                }, {
                    id: '2-1-3',
                    text: '司机历史订单管理',
                    href: 'asset/query'
                }]
            }]
        }, {
            id: '3',
            menu: [{
                text: '客户管理模块',
                items: [{
                    id: '3-1-1',
                    text: '客户信息管理',
                    href: 'checkedout/query'
                }, {
                    id: '3-1-2',
                    text: '客户当前订单管理',
                    href: 'checkedout/query'
                }, {
                    id: '3-1-3',
                    text: '客户历史订单管理',
                    href: 'checkedout/query'
                }]
            }]
        }, {
            id: '4',
            menu: [{
                text: '订单管理模块',
                items: [{
                    id: '4-1-1',
                    text: '订单信息管理',
                    href: 'order/query'
                }, {
                    id: '4-1-2',
                    text: '未完成订单管理',
                    href: 'checkedout/query'
                }, {
                    id: '4-1-3',
                    text: '已完成订单管理',
                    href: 'checkedout/query'
                }, {
                    id: '4-1-4',
                    text: '失效订单管理',
                    href: 'checkedout/query'
                }]
            }]
        },{
            id: '5',
            menu: [{
                text: '登录模块',
                items: [{
                    id: '5-1-1',
                    text: '登录信息管理',
                    href: 'login/query'
                }]
            }]
        },{
            id: '6',
            menu: [{
                text: '额度模块',
                items: [{
                    id: '6-1-1',
                    text: '额度信息管理',
                    href: 'tree/query'
                },{
                    id: '6-1-2',
                    text: '额度使用信息管理',
                    href: 'usage/query'
                },{
                    id: '6-1-3',
                    text: '额度冻结信息管理',
                    href: 'tree/query'
                },{
                    id: '6-1-4',
                    text: '额度解冻信息管理',
                    href: 'tree/query'
                }]
            },{
                text: '额度关系模块',
                items: [{
                    id: '6-2-1',
                    text: '额度关系管理',
                    href: 'treerela/query'
                },{
                    id: '6-2-2',
                    text: '额度纳入关系管理',
                    href: 'treerela/naruquery'
                },{
                    id: '6-2-3',
                    text: '额度替换关系管理',
                    href: 'treerela/replacequery'
                },{
                    id: '6-2-4',
                    text: '额度关联关系管理',
                    href: 'treerela/glquery'
                }]
            }]
        },{
            id: '7',
            menu: [{
                text: '合同占用模块',
                items: [{
                    id: '7-1-1',
                    text: '合同占用信息管理',
                    href: 'contract/query'
                }]
            },{
                text: '合同信息模块',
                items: [{
                    id: '7-2-1',
                    text: '合同信息管理',
                    href: 'contractinfo/query'
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