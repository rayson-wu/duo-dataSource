package com.rayson.duodatasource.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Author: rayson
 * Description:
 * Date: 2022/1/1 21:17
 */
@Mapper
public interface SlaveMapper {

    @Select("select name from student")
    String slave();

    @Update("update student set age = age+1 where student_id = 1")
    Integer update();
}
