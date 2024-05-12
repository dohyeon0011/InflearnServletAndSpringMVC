package com.example.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK);  // 기본 응답 코드

        // [response-headers]
//        response.setHeader("Content-Type", "text/plain;charset=utf-8"); // 인코딩 세팅을 해줘야 응답해줄 때 한글이 안 깨짐
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 무효화
        response.setHeader("Progma", "no-cache");
        response.setHeader("my-header", "hello");   // 내가 원하는 임의의 헤더 생성

        // [Header 편의 메서드]
//        content(response);
//        cookie(response);
        redirect(response);

        // [Message Body]
        PrintWriter writer = response.getWriter();
        writer.println("성공");   // println()으로 하면 줄바꿈까지 포함해서 byte길이가 3이 됨
    }

    private void content(HttpServletResponse response) {
        // Content-Type: text/plain;charset=utf-8
//         Content-Length: 2    // 꼭 설정을 해줘야 함
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");  // 인코딩 세팅을 이런 방식으로도 가능
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); // (생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        // Set-Cookie: myCookie=good; Max-Age=600; (key=value)
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");  response 객체를 사용해서 쿠키를 설정할 수 있지만, 편리하게 Cookie 객체를 이용하여 설정
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}

