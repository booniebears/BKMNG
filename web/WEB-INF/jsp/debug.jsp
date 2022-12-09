<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>调试页面</title>--%>
<%--    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">--%>
<%--    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>
<%--    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<nav class="navbar navbar-default">--%>
<%--    <div class="container-fluid">--%>
<%--        <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--        <div class="navbar-header">--%>
<%--            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">--%>
<%--                <span class="sr-only">Toggle navigation</span>--%>
<%--                <span class="icon-bar"></span>--%>
<%--                <span class="icon-bar"></span>--%>
<%--                <span class="icon-bar"></span>--%>
<%--            </button>--%>
<%--            <a class="navbar-brand" href="#">Brand</a>--%>
<%--        </div>--%>

<%--        <!-- Collect the nav links, forms, and other content for toggling -->--%>
<%--        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
<%--            <ul class="nav navbar-nav">--%>
<%--                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
<%--                <li><a href="#">Link</a></li>--%>
<%--                <li class="dropdown">--%>
<%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li><a href="#">Action</a></li>--%>
<%--                        <li><a href="#">Another action</a></li>--%>
<%--                        <li><a href="#">Something else here</a></li>--%>
<%--                        <li role="separator" class="divider"></li>--%>
<%--                        <li><a href="#">Separated link</a></li>--%>
<%--                        <li role="separator" class="divider"></li>--%>
<%--                        <li><a href="#">One more separated link</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--            <form class="navbar-form navbar-left">--%>
<%--                <div class="form-group">--%>
<%--                    <input type="text" class="form-control" placeholder="Search">--%>
<%--                </div>--%>
<%--                <button type="submit" class="btn btn-default">Submit</button>--%>
<%--            </form>--%>
<%--            <ul class="nav navbar-nav navbar-right">--%>
<%--                <li><a href="#">Link</a></li>--%>
<%--                <li class="dropdown">--%>
<%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li><a href="#">Action</a></li>--%>
<%--                        <li><a href="#">Another action</a></li>--%>
<%--                        <li><a href="#">Something else here</a></li>--%>
<%--                        <li role="separator" class="divider"></li>--%>
<%--                        <li><a href="#">Separated link</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div><!-- /.navbar-collapse -->--%>
<%--    </div><!-- /.container-fluid -->--%>
<%--</nav>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        html {
            height: 100%;
        }
        body {
            height: 100%;
        }
        .container {
            height: 100%;
            background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
        }
        .login-wrapper {
            background-color: #fff;
            width: 388px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }
        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }
        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px;
            outline: none;
        }
        .input-item:placeholder {
            text-transform: uppercase;
        }
        .btn {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
            color: #fff;
        }
        .msg {
            text-align: center;
            line-height: 88px;
        }
        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">欢迎来到图书管理系统</div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-wrapper">
                <input type="text" name="username" placeholder="username" class="input-item" autocomplete="off" required>
                <input type="password" name="password" placeholder="password" class="input-item" autocomplete="off" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 是否为管理员
                    </label>
                </div>
<%--                <div class="btn">--%>
                <input class="btn btn-info" type="submit" value="Login">
<%--                </div>--%>
            </div>

        </form>
    </div>
</div>
</body>
</html>
