package com.example.demo.di2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//XML문서 대신 자바 클래스를통해서 필요한객체를 미리 등록해줌
//이러면 이른 객체생성을 가져갈수있음 -왜냐면 서비스를 위해 필요한 클래스 설계는 개발자의 몫인거니까
//다시말해설계자에따라 클래스이름이 다 달라져야하니까. 스프링은 정할수없는거니까
//@ Configuration을 붙여서 필요한객체를 미리 선언해준다
//이때 함깨사용할 어노테이션이 Bean어노테이션이다

//스프링에서 해당 클래스를 관리함 -스캔 -클래스 정보수집
//ApplicationContext컨테이너는 이렇게등론된빈을 관리해줌
@Configuration
public class MyConfig {
    @Bean
    public TestController testController() {// 메소드를 통해서 객체를 주입받는방법 -권장방식
        return new TestController();
    }

    @Bean
    public TestLogic testLogic() {
        return new TestLogic();
    }

    @Bean
    public TestDao testDao() {
        return new TestDao();
    }

}
