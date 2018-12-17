package com.example.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("redisCache")
public class RedisCacheController {
    @Autowired
    private RedisClient redisClient;

    @RequestMapping("set")
    @ResponseBody
    public String set(String key, String val){
        redisClient.set(key, val);
        return "success";
    }
    @RequestMapping("get")
    @ResponseBody
    public String get(String key){
        return redisClient.get(key);
    }
}
