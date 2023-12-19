package com.example.demo.di2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;

//@Controller // @RestController - getBean()호출안되어도 미리 다 생성되어있다
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);
    // @Autowired
    TestLogic testLogic = null; // new붙이면 하드코딩이다 제어권을 넘기자
    // setter 객체 주입법 코드이다

    public void setTestLogic(TestLogic testLogic) {
        this.testLogic = testLogic;
    }

    public String testList() {
        System.out.println("TestController testList()호출");
        List<Map<String, Object>> list = null;
        list = testLogic.testList();
        logger.info(list.toString());
        return "ok";
    }
}
