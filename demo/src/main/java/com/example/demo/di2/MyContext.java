package com.example.demo.di2;

import java.util.*;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

import org.springframework.context.annotation.Bean;

public class MyContext {
    Map<String, Object> map = new HashMap<>();

    public MyContext() {
        map.put("testController", new TestController());
        map.put("testLogic", new TestLogic());
        map.put("testDao", new TestDao());
    }

    @SuppressWarnings("deprecation")
    public MyContext(Class<?> clazz) {// 파라미터자리 -MyConfig - @Configuration 스캔 @Bean등록
        try {
            Object myConfig = clazz.newInstance();
            for (Method m : clazz.getDeclaredMethods()) {
                for (Annotation ann : m.getDeclaredAnnotations()) {
                    if (ann.annotationType() == Bean.class) {// 객체들을생성
                        // 메소드이름을(TestController,Logic,Dao) 키값으로하여 값을생성함
                        map.put(m.getName(), m.invoke(myConfig, null));
                    }
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    Object getBean(String id) {
        return map.get(id);
    }

    // 타입비교 instanceof
    // 타입으로 객체 찾기
    Object getBean(Class<?> clazz) {
        for (Object obj : map.values()) {
            if (clazz.isInstance(obj)) {
                return obj;
            }
        }
        return null;
    }
}
