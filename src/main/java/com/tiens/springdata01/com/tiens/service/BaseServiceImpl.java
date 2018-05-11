package com.tiens.springdata01.com.tiens.service;

import com.tiens.springdata01.com.tiens.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseServiceImpl implements BaseService {
    @Autowired
    BaseDao baseDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String Hello() {
        System.out.println(stringRedisTemplate.opsForValue().get("a"));
        return baseDao.getStr("b");

    }
}
