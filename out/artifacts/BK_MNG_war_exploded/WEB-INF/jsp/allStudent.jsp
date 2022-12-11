<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人员管理</title>
    <!-- 引入 Bootstrap -->
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
                <h1>学生列表</h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/admin/queryStu"
              method="post" role="search" autocomplete="off">
            <div class="form-group">
                <input type="text" class="form-control" name="queryStuName" placeholder="请输入要查询的学生姓名">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
            <span style="color: red;font-weight: bold">
                ${error}
            </span>
        </form>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th bgcolor="#e0ffff">学号</th>
                    <th class="warning">姓名</th>
                    <th bgcolor="#e0ffff">性别</th>
                    <th class="warning">生日</th>
                    <th bgcolor="#e0ffff">密码</th>
                    <th class="warning">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${stu_list}">
                    <tr>
                        <td bgcolor="#e0ffff">${student.id}</td>
                        <td class="warning">${student.name}</td>
                        <td bgcolor="#e0ffff">${student.sex}</td>
                        <td class="warning">${student.birth}</td>
                        <td bgcolor="#e0ffff">${student.student_password}</td>
                        <td class="warning">
                            <a href="${pageContext.request.contextPath}/admin/updateStuPage?id=${student.id}">修改</a>
                            &nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/admin/deleteStu/${student.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/addStudentPage">新增学生</a>
        </div>
    </div>
</div>
</body>
</html>
