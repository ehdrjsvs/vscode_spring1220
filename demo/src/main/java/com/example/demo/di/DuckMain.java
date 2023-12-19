package com.example.demo.di;

import java.util.Properties;
import java.io.FileReader;

public class DuckMain {
    public static void main(String[] args) {
        Duck duck = Duck.getDuck(1);
        if (duck instanceof RubberDuck) {
            System.out.println("RubberDuck");
        }
        Duck duck2 = Duck.getDuck(1.0);
        if (duck2 instanceof WoodDuck) {
            System.out.println("WoodDuck");
        }
    }
}

/*
 * 선언부 생성부
 * 객체를 사용하려는쪽
 * 개발자가 수정해야할 코드가 많아짐 - 문제제기
 * :왜냐면 선언부와 생성부 모두 수정해야함 -생성자 오버로딩 -전변-고유명사-모두수정해야함
 * :여기에더해서 이 제어권을 외부에서 갖자-스프링컨테이너-IoC(제어역전=역제어)
 * 기존 방식의 문제점
 * 컴포넌트간의 결합도가 높아서 컴포넌트 확장 및 재사용이 어려운 문제 발생된다
 * IoC사용시
 * :제어권 컨테이너에 넘어가 객체의 생명주기를 컨테이너가 전담하게 됨->빼앗김
 * ApplicationContext,BeanFactory
 * MallardDuck myDuck = new MallardDuck();
 * WoodDuck himDuck = new WoodDuck();
 */