package com.example.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // 요청이 오면 WAS가 HttpServletRequest, HttpServletResponse 객체를 만들어 서블릿 컨테이너에 던져줌
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request); // 구현체들
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // Content Type에 들어감
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // HTTP 메세지 바디에 들어감
        response.getWriter().write("hello" + username);

    }
}
