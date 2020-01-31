<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/thems.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');

        });
    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">个人信息</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="edit.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">编号：</span>
                            <div class="li_r">${USER.id}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">账户名：</span>
                            <div class="li_r">${USER.account}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">状态：</span>
                            <div class="li_r">${USER.status}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">所属部门：</span>
                            <div class="li_r">${USER.department.name}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">${USER.name}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">${USER.sex}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">身份证号码：</span>
                            <div class="li_r">${USER.idNumber}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">入职时间：</span>
                            <div class="li_r"><fmt:formatDate value="${USER.workTime}" pattern="yyyy-MM-dd"></fmt:formatDate></div>
                        </li>
                        <li class="clearfix">
                            <span class="title">离职时间：</span>
                            <div class="li_r"><fmt:formatDate value="${USER.leaveTime}" pattern="yyyy-MM-dd"></fmt:formatDate></div>
                        </li>
                        <li class="clearfix">
                            <span class="title">出生日期：</span>
                            <div class="li_r"><fmt:formatDate value="${USER.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate></div>
                        </li>
                        <li class="clearfix">
                            <span class="title">备注：</span>
                            <div class="li_r">${USER.info}</div>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
