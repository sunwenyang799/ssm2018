<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/26
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <a href="param/testParam1?username=test&password=123456">请求参数绑定</a>

        <%--请求参数绑定--%>
        <%--<form action="param/saveAccount" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            金额：<input type="text" name="money"><br>

            实体用户用户名：<input type="text" name="user.username"><br>
            实体用户密码：<input type="text" name="user.password"><br>

            list用户用户名：<input type="text" name="userList[0].username"><br>
            list用户密码：<input type="text" name="userList[0].password"><br>
            list用户用户名：<input type="text" name="userList[1].username"><br>
            list用户密码：<input type="text" name="userList[1].password"><br>

            Map用户用户名：<input type="text" name="userMap['one'].username"><br>
            Map用户密码：<input type="text" name="userMap['one'].password"><br>
            <button type="submit">提交</button>
        </form>--%>

        <%--自定义格式转换--%>
        <%--<form action="param/saveUser" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            出生日期：<input type="text" name="birthday"><br>
            <button type="submit">提交</button>
        </form>--%>

        <%--获取serlvet原生API--%>
        <a href="param/getServletAPI">获取servlet原生API</a>
</body>
</html>
