<%--
  Created by IntelliJ IDEA.
  User: 孙闻钖
  Date: 2020/8/27
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h3>传统文件上传</h3>
        <form action="user/fileUpload" method="post" enctype="multipart/form-data">
            用户名：<input name="username" type="text">
            点击上传：<input type="file" name="fileUpload">
            <button type="submit">提交</button>
        </form>

        <h3>SpringMvc文件上传</h3>
        <form action="user/springmvcFileUpload" method="post" enctype="multipart/form-data">
            用户名：<input name="username" type="text">
            点击上传：<input type="file" name="file">
            <button type="submit">提交</button>
        </form>

        <h3>服务器文件上传</h3>
        <form action="user/clientFileUpload" method="post" enctype="multipart/form-data">
            点击上传：<input type="file" name="file">
            <button type="submit">提交</button>
        </form>
</body>
</html>
