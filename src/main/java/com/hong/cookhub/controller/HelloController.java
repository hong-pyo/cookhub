package com.hong.cookhub.controller;

import com.hong.cookhub.model.common.CommonRequestData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class HelloController {

    @RequestMapping("/")
    public String test(Model model) {
        model.addAttribute("test", String.valueOf(new Date()));

        return "index";
    }

    @RequestMapping("/file")
    public String fileUPload(Model model) {
        CommonRequestData commonRequestData = CommonRequestData.builder().userAgent("user").sessionId("1111").build();
        System.out.println(commonRequestData.getSessionId());
        System.out.println(commonRequestData.getUserAgent());
        return "fileUpload";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String git() {
        return "good";
    }
}
