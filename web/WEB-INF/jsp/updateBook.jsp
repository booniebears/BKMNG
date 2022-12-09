<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
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
                <a href="${pageContext.request.contextPath}/book/allBook">图书概览</a>
            </li>
            <li role="presentation">
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
                <h1>修改书籍</h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <div class="form-group">
                <label for="bk_id">书籍编号: </label>
                <input type="text" name="book_id" class="form-control" id="bk_id" autocomplete="off"
                       value="${QueryBooks.book_id}" required>
            </div>
            <div class="form-group">
                <label for="bk_name">书籍名称: </label>
                <input type="text" name="book_name" class="form-control" id="bk_name" autocomplete="off"
                       value="${QueryBooks.book_name}" required>
            </div>
            <div class="form-group">
                <label for="bk_author">书籍作者: </label>
                <input type="text" name="book_author" class="form-control" autocomplete="off"
                       value="${QueryBooks.book_author}" id="bk_author">
            </div>
            <div class="form-group">
                <label for="bk_publisher">书籍出版商: </label>
                <input type="text" name="book_publisher" class="form-control" autocomplete="off"
                       value="${QueryBooks.book_publisher}" id="bk_publisher">
            </div>
            <div class="form-group">
                <label for="bk_price">书籍价格: </label>
                <input type="text" name="book_price" class="form-control" autocomplete="off"
                       value="${QueryBooks.book_price}" id="bk_price">
            </div>
            <div class="form-group">
                <label for="bk_number">书籍数目: </label>
                <input type="text" name="book_number" class="form-control" autocomplete="off"
                       value="${QueryBooks.book_number}" id="bk_number" required>
            </div>
            <div class="form-group">
                <input class="btn btn-info" type="submit" value="修改">
            </div>
        </form>
    </div>

</div>
</body>
</html>
