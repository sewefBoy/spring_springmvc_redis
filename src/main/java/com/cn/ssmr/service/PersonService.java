package com.cn.ssmr.service;

import com.cn.ssmr.model.PersonProto;

/**
 * Created by sewef on 2017/9/28.
 */
public interface PersonService {
    public void addPerson(PersonProto person);
    public void delePerson(PersonProto person);
    public void modifyPerson(PersonProto person);
    public void findPerson(PersonProto person);
}
