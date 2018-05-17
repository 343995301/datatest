package com.tiens.springdata01.com.tiens.service;

import com.alibaba.fastjson.JSON;
import com.tiens.springdata01.com.tiens.dao.BaseDao;
import com.tiens.springdata01.com.tiens.entity.BaseEntity;
import com.tiens.springdata01.com.tiens.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseServiceImpl implements BaseService {
    @Autowired
    BaseDao baseDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello() {
        System.out.println(stringRedisTemplate.opsForValue().get("a"));
        return baseDao.getStr("b");

    }
    @RequestMapping(value = "/findbyyser",method = RequestMethod.GET)
    public BaseEntity get(@RequestParam("id") int id){
        BaseEntity baseEntity =userMapper.findUserByID(id);
        return baseEntity;
    }
    @RequestMapping(value = "/updatebyuser",method = RequestMethod.POST)
    public String update(@RequestBody String json) {
       BaseEntity baseEntity = (BaseEntity) JSON.parseObject(json,BaseEntity.class);
        userMapper.updateUserById(baseEntity);
        return "ok";
    }
}
