package com.cn.ssmr.dao;

import com.cn.ssmr.model.PersonProto;

/**
 * Created by sewef on 2017/9/28.
 */
public interface PersonDao {
    public void addPerson(PersonProto person);
    public void delePerson(PersonProto person);
    public void modifyPerson(PersonProto person);
    public void findPerson(PersonProto person);
}
