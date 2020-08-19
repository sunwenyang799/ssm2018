<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="com.sun.org.apache.bcel.internal.generic.NEW" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.ssm.dao.IUserDao" %>
<%@ page import="com.ssm.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello World!</h2>
<%
    InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
    SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = factoryBuilder.build(resourceAsStream);
    SqlSession sqlSession = factory.openSession(true);
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    List<User> list = userDao.findAll();
    for (User user : list) {
        System.out.println(user.toString());
    }
%>
</body>
</html>
