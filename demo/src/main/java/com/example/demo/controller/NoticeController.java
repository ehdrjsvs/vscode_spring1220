package com.example.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("/notice/*")
public class NoticeController {
    Logger logger = LoggerFactory.getLogger(NoticeController.class);
    //전체조회 및 조건검색일때
    //SELECT*FROM notice WHERE gubun=> AND keywoed=?
    @GetMapping("noticeList")
    public String noticeList(@RequestParam Map<String,Object> pmap){
        logger.info(pmap.get("gubun").toString());
        logger.info(pmap.get("keyword").toString());
        return "forward:noticeList.jsp"; //webapp아래에서찾음
    }
    //insert into notice(n_no,n_title,n_content,n_writer) values(?,?,?,?)
    @PostMapping("noticeInsert")
    public String noticeInsert(@RequestParam Map<String,Object> pmap){
        logger.info(pmap.get("n_title").toString());
        logger.info(pmap.get("n_content").toString());
        return "redirect:noticeList"; //화면을 호출하는게아니라 url을호출한다-9번라인
    }
}
