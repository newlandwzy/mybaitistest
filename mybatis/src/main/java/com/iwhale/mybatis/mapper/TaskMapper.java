package com.iwhale.mybatis.mapper;

import org.apache.ibatis.annotations.Update;

/**
 * @author wzy
 * @date 2019/6/24
 */
public interface TaskMapper {

    @Update("update task set id = 3")
    public void taskList();

}
