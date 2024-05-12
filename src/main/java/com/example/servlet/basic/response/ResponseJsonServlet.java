package com.example.servlet.basic.response;

import com.example.servlet.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Http Message Body에 Json 데이터 직접 보내기
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Content-Type : application/json -> 스펙상 utf-8 형식을 사용하도록 정의되어 있어서 기본으로 지정되어 있음
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8"); // 사실 그래서 이건 쓸모없는 코드

        HelloData helloData = new HelloData();
        helloData.setUserName("Lee");
        helloData.setAge(20);

        // {"userName" : Lee", "age" : 20}
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result); // getWriter()를 하면 추가 파라미터(setCharacterEncoding 이런 것)를 자동으로 추가하게 되어서 getOutputStream()으로 하면 이런 문제가 사라짐
    }
}
