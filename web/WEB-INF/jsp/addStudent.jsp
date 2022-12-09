<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增学生</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="login_bg2">
<%--这里就用BootStrap了--%>
<div class="container">
    <div class="row clearfix">
        <ul class="nav nav-pills">
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/book/allBook">图书概览</a>
            </li>
            <li role="presentation" class="active">
                <a href="${pageContext.request.contextPath}/admin/allStudent">人员管理</a>
            </li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/admin/borrowInfo">借阅管理</a></li>
            <li class="dropdown pull-right">
                <a href="#" data-toggle="dropdown" class="dropdown-toggle">选项<strong class="caret"></strong></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#">你好,${UserLoginInfo}!</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/logout">退出登录</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>新增学生</h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <form action="${pageContext.request.contextPath}/admin/addStudent" method="post">
            <div class="form-group">
                <label for="stu_id">学生学号: </label>
                <input type="text" name="id" class="form-control" id="stu_id" autocomplete="off" required>
            </div>
            <div class="form-group">
                <label for="stu_name">学生姓名: </label>
                <input type="text" name="name" class="form-control" id="stu_name" autocomplete="off" required>
            </div>
            <div class="form-group">
                <label for="stu_sex">学生性别: </label>
                <input type="text" name="sex" class="form-control" id="stu_sex" autocomplete="off" required>
            </div>
            <div class="form-group">
                <label for="stu_birth">学生生日: </label>
                <input type="text" name="birth" class="form-control" id="stu_birth" autocomplete="off">
            </div>
            <div class="form-group">
                <label for="stu_password">登录密码: </label>
                <input type="text" name="student_password" class="form-control" id="stu_password" autocomplete="off" required>
            </div>
            <div class="form-group">
                <input class="btn btn-info" type="submit" value="提交">
            </div>
        </form>
    </div>
</div>
</body>
</html>
