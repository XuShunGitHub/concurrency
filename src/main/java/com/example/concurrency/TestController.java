package com.example.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "test")
    @ResponseBody
    public String test(){
        logger.info("test");
        return "test";
    }
}
