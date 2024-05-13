<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlet.domain.member.Member" %>
<%@ page import="com.example.servlet.domain.member.MemberRepository" %>
<%
    // request, response 사용 가능(JSP도 결국엔 나중에 Servlet으로 변환 되기 때문에)
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    String userName = request.getParameter("userName");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(userName, age);
    memberRepository.save(member);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>userName=<%=member.getUserName()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
