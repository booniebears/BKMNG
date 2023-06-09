<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅信息查询</title>
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
                <a href="${pageContext.request.contextPath}/student/allBook">图书概览</a>
            </li>
            <%--            <li role="presentation">--%>
            <%--                <a href="${pageContext.request.contextPath}/admin/allStudent">人员管理</a>--%>
            <%--            </li>--%>
            <li role="presentation" class="active">
                <a href="${pageContext.request.contextPath}/student/borrowInfo">借阅管理</a>
            </li>

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
                <h1>借阅信息列表</h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th bgcolor="#e0ffff">借阅编号</th>
                    <th class="warning">图书名</th>
                    <th bgcolor="#e0ffff">借书时间</th>
                    <th class="warning">还书时间</th>
                    <th bgcolor="#e0ffff">续借时间</th>
                    <th class="warning">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="info" items="${Info_list}">
                    <tr>
                        <td bgcolor="#e0ffff">${info.borrow_id}</td>
                        <td class="warning">${info.book_name}</td>
                        <td bgcolor="#e0ffff">${info.borrow_time}</td>
                        <td class="warning">${info.return_time}</td>
                        <td bgcolor="#e0ffff">${info.renew_time}</td>
                        <td class="warning">
                            <a href="${pageContext.request.contextPath}/student/returnBook/${info.borrow_id}">还书</a>
                            &nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/student/renewBook/${info.borrow_id}">续借</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <span style="color: red;font-weight: bold;font-size: 20px">
                ${returnError}
            </span>
        </div>
    </div>
</div>
</body>
</html>
