package com.rayson.duodatasource.service;

import com.rayson.duodatasource.annotation.DataSource;
import com.rayson.duodatasource.mapper.MasterMapper;
import com.rayson.duodatasource.mapper.SlaveMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Author: rayson
 * Description:
 * Date: 2022/1/1 21:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DynamicService {

    @Resource
    private MasterMapper masterMapper;

    @Resource
    private SlaveMapper slaveMapper;


    public String master() {
        return masterMapper.master();
    }

    @DataSource("SLAVE") // 此处要用大写,小写匹配不到！！！！
    public String slave() {
        return slaveMapper.slave();
    }

    public Integer masterUpdate() {

        Integer update = masterMapper.update();
        int i = 1/0;
        return update;
    }

    @DataSource("SLAVE")
    public Integer slaveUpdate() {

        Integer update = slaveMapper.update();
        int i = 1/0;
        return update;
    }
}
