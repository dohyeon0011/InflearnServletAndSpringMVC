package com.example.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component("/springmvc/old-controller") // spring bean의 이름을 url로 설정
public class OldController implements Controller {  // 우선순위 3위

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        // 1순위. BeanNameViewResolver : 빈 이름으로 뷰를 찾아서 반환(예:엑셀 파일 생성 기능에 사용)
        // 2순위. InternalResourceViewResolver : JSP를 처리할 수 있는 뷰를 반환한다.(내부에서 자원을 찾을 때, JSP처럼 forward())
        // 현재는 2순위 방법("new-form" 이라는 이름을 가진 Bean이 없으니까)
        // 다른 뷰는 실제 뷰를 렌더링하지만, JSP의 경우 forward()를 통해서 해당 JSP로 이동(실행)해야 렌더링이 된다.
        // JSP를 제외한 나머지 뷰 템플릿들은 forward() 과정 없이 바로 렌더링 된다.
        return new ModelAndView("new-form");
    }
}
