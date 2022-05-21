package com.rayson.duodatasource.controller;

import com.rayson.duodatasource.mapper.MasterMapper;
import com.rayson.duodatasource.mapper.SlaveMapper;
import com.rayson.duodatasource.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: rayson
 * Description:
 * Date: 2022/1/1 21:16
 */
@RestController
public class TestController {

    @Autowired
    private DynamicService dynamicService;

    @GetMapping("/master")
    public String master() {
        return dynamicService.master();
    }

    @GetMapping("/slave")
    public String slave() {
        return dynamicService.slave();
    }

    @GetMapping("/master/update")
    public Integer masterUpdate() {
        return dynamicService.masterUpdate();
    }

    @GetMapping("/slave/update")
    public Integer slaveUpdate() {
        return dynamicService.slaveUpdate();
    }
}
