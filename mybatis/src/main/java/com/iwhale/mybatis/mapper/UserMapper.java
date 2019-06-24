package com.iwhale.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author wzy
 * @date 2019/6/23
 */
public interface UserMapper {

    @Select("select * from user")
    public void getAllUser();
}
