package com.example.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Spring MVC에서 어노테이션 기반 컨트롤러로 인식, @Component 어노테이션이 있어서 자동으로 스프링 빈으로 올라가고 컴포넌트 스캔의 대상이 됨
// RequestMappingHandlerMapping은 스프링 빈 중에서 @RequestMapping || @Controller가 클래스 레벨에 붙어 있는 경우에 매핑 정보로 인식
//@Component    컴포넌트 스캔의 대상이 되게 하기
//@RequestMapping   // RequestMappinghandlerMapping이 얘를 찾아냄
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")   // 해당 URL이 호출되면 이 메서드가 호출
    public ModelAndView process() {
        System.out.println("SpringMemberFormControllerV1.process");
        return new ModelAndView("new-form");
    }

}
