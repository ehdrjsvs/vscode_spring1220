package com.example.demo.step1;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//스프링에서는 서블릿과 다르게 메소드 마다에 url매핑이 가능함
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

//spring3.0 - @ResponseBody
// 페이지출력이아닌 모든경우에 사용이 가능하다
// @Controller를 사용하면 메소드이름이 페이지 이름이된다
@RestController // @Controller 다르게 응답이 page가 아니고 text/plain이다
@RequestMapping("/step1/*")
public class HomeController {
  Logger logger = LoggerFactory.getLogger(HomeController.class);

  // 스프링에서는 req.getParameter 쓰지 않고도 파라미터 자리에 넣어주는 것 만으로 담김
  // url -> http://localhost:8000/step1/home?param=1
  // 스프링에서는 클래스와 빈은 같은말 이해 <bean>
  // 어떻게 이런일이 가능한가 ? - 빈관리 - spring - context.jar -> ApplicationContext
  // 스프링에서 의존성 주입을 담당하니까 가능함
  // 환경설정 - spring-core.jar - 환경설정 - myBatis,Hikaricp 외부 라이브러리 - IOC
  // 라이브러리에는 없는 제어권을 스프링이 갖는다
  // 스프링을 사용하면 객체에 대한 라이프사이클 관리를 빼앗긴다
  @GetMapping("jsonTest") // 메소드가 호출되는 매핑이름이다
  public String home(String param) {
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> map = new HashMap<>();
    map.put("deptno", 10);
    map.put("dname", "총무부");
    map.put("loc", "인천");
    list.add(map);
    logger.info(list.toString());
    Gson g = new Gson();
    String temp = g.toJson(list);
    return temp;
  }

}
/*
 * 상속을 받지않았지만 req,res는 여전히 사용가능
 * 입력(@RequestParam)-> 처리 -> 출력
 * 사람은 처리만해줄래
 * 컨트롤 계층이라면
 * 응답페이지 처리에 대한 책임(관심사)
 * 필요할때 응답 요청객채를 사용할수있다 -없어진게아님
 * 메소드의 파라미터 갯수의 제약이없다.
 * 실제처리는 하지않는다 - 처리는 미룬다 - Logic클래스가 담당함
 * 
 */