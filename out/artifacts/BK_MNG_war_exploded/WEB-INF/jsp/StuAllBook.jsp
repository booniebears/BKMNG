<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书概览</title>
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
            <li role="presentation" class="active">
                <a href="${pageContext.request.contextPath}/student/allBook">图书概览</a>
            </li>
<%--            <li role="presentation">--%>
<%--                <a href="${pageContext.request.contextPath}/admin/allStudent">人员管理</a>--%>
<%--            </li>--%>
            <li role="presentation"><a href="${pageContext.request.contextPath}/student/borrowInfo">借阅管理</a></li>
            <%--以下为调试页面的前端部分--%>
            <%--            <li role="presentation"><a href="${pageContext.request.contextPath}/book/debugPage">调试页面</a></li>--%>
            <%--以上为调试页面的前端部分--%>

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
                <h1>书籍列表</h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/student/queryBook"
              method="post" role="search" autocomplete="off">
            <div class="form-group">
                <input type="text" class="form-control" name="queryBookName" placeholder="请输入要查询的书籍名称">
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
                    <th bgcolor="#e0ffff">编号</th>
                    <th class="warning">名称</th>
                    <th bgcolor="#e0ffff">作者</th>
                    <th class="warning">出版商</th>
                    <th bgcolor="#e0ffff">单价</th>
                    <th class="warning">剩余数量</th>
                    <th bgcolor="#e0ffff">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td bgcolor="#e0ffff">${book.book_id}</td>
                        <td class="warning">${book.book_name}</td>
                        <td bgcolor="#e0ffff">${book.book_author}</td>
                        <td class="warning">${book.book_publisher}</td>
                        <td bgcolor="#e0ffff">${book.book_price}</td>
                        <td class="warning">${book.book_number}</td>
                        <td bgcolor="#e0ffff">
                            <a href="${pageContext.request.contextPath}/student/borrowBook/${book.book_id}">借书</a>
<%--                            &nbsp; | &nbsp;--%>
<%--                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.book_id}">删除</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <span style="color: red;font-weight: bold;font-size: 20px">
                ${borrowError}
            </span>
        </div>

    </div>
</div>
</body>
</html>
