<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/28
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <a href="account/testSpringMvc">测试testSpringMvc查询</a>
        <br>

        <form action="account/saveAccount" method="post">
            用户名:<input name="name" type="text">
            金额:<input name="money" type="text">
            <button type="submit">提交</button>
        </form>
</body>
</html>
