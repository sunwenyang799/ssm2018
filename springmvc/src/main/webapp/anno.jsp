<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/26
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<br>
        <a href="anno/testRequestParam?name=你好">测试RequestParam注解</a>

        <br>
        <form action="anno/testRequestBody" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            <button type="submit">提交</button>
        </form>

        <a href="anno/testPathVariable/10">测试PathVariable注解</a>
        <br>
        <a href="anno/testRequestHeader">测试RequestHeader注解</a>
        <br>
        <a href="anno/testCookieValue">测试CookieValue注解</a>
        <br>
        <form action="anno/testModeAttribute" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            <button type="submit">提交</button>
        </form>
        <a href="anno/setSessionAttributes">setSessionAttributes存值</a>
        <br>
        <a href="anno/getSessionAttributes">getSessionAttributes取值</a>
        <br>
        <a href="anno/deleteSessionAttributes">deleteSessionAttributes清空session中的值</a>
        <br>
</body>
</html>
