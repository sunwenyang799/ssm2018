<%--
  Created by IntelliJ IDEA.
  User: 孙闻钖
  Date: 2020/8/27
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        $(function (){
            $("#btn").click(function (){
                // alert("按钮被点击了");
                $.ajax({
                    url:"user/testAjax",
                    type:"post",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"swy","password":"123","age":22}',
                    success:function (data){
                        console.log(data);
                        console.log(data.username);
                        console.log(data.password);
                        console.log(data.age);
                    }
                })
            })
        })
    </script>

</head>
<body>
    <a href="user/testStringResponse">测试testStringResponse</a><br>
    <a href="user/testVoidResponse">测试testVoidResponse</a><br>
    <a href="user/testForwardOrRedirect">测试testForwardOrRedirect</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>
    <button id="btn">发送ajax请求</button><br>
</body>
</html>
