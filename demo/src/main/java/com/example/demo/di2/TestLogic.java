package com.example.demo.di2;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

public class TestLogic {
    Logger logger = LoggerFactory.getLogger(TestLogic.class);
    TestDao testDao = null;

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    public List<Map<String, Object>> testList() {
        System.out.println("TestLogic testList()호출");
        List<Map<String, Object>> list = new ArrayList<>();
        list = testDao.testList();
        return list;
    }

}
