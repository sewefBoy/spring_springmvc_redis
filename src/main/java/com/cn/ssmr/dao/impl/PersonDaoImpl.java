package com.cn.ssmr.dao.impl;

import com.cn.ssmr.dao.PersonDao;
import com.cn.ssmr.model.PersonProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by sewef on 2017/9/28.
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    RedisTemplate redisTemplate;

    public void addPerson(PersonProto person) {

        redisTemplate.opsForValue().set("person",person);
    }

    public void delePerson(PersonProto person) {

    }

    public void modifyPerson(PersonProto person) {

    }

    public void findPerson(PersonProto person) {

    }
}
