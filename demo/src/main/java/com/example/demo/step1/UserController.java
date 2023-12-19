
package com.example.demo.step1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/user/*")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    // ->http://localhost:8000/user/login>mem_id=kiwi&mem_pw=123
    // 쿼리스트링 사용하여 값을 넘기는것은 Get방식이다
    @GetMapping("login")
    public String login(HttpServletRequest req) {
        String mem_id = req.getParameter("mem_id");
        String mem_pw = req.getParameter("mem_pw");
        logger.info(mem_id + mem_pw);
        return "redirect:/index.jsp";
    }

    @GetMapping("login2")
    public String login2(@RequestParam("mem_id") String mem_id, @RequestParam("mem_pw") String mem_pw) {
        // http://localhost:8000/user/login2 -> 400에러 required= true이라서 에러
        logger.info(mem_id + mem_pw);
        return "redirect:/index.jsp";
    }

    @GetMapping("login3")
    public String login3(String mem_id, String mem_pw) {
        logger.info(mem_id + mem_pw);
        return "redirect:/index.jsp";
    }

    @GetMapping("login4")
    public String login4(@RequestParam Map<String, Object> pmap) {
        logger.info(pmap.get("mem_id") + ", " + pmap.get("mem_pw"));
        return "redirect:/index.jsp";
    }

    // http://localhost:8000/user/loginForm
    @GetMapping("loginForm")
    public String loginForm() {
        // return "user/loginForm";
        // POJO에서 upmu[0] workname -@RequestMappin("/user/*")-요청시 알고있음
        // upmu[1] - 메소드이름,화면이름이기도하다.
        return "redirect:./loginForm.jsp";
    }

    // ModelAndView -WEB-INF찾음 ,forward유효범위,scope:request
    // url은 그대로인데 화면은 바뀐다
    // 화면의 이름을 생략하면 메소드이름이 화면이름이된다 - 스프링이 그렇게주입한다
    @GetMapping("loginForm2")
    public ModelAndView loginForm2() {
        return new ModelAndView(); // WEB-INF/views/user/loginForm2.jsp
    }

}