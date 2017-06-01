package com.zy.test.reflect.demo;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    //按照行查询,额外的业务逻辑.
    List<User>findAll();
}