package com.api.tiktokapi.controller;

import com.api.tiktokapi.common.R;
import com.api.tiktokapi.entity.Manager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class TestApi {

    @GetMapping("/get")
    public R<Manager> managerR(){
        final Manager asd = new Manager(100L, "asd", "5666");
        return R.success(asd,"ok");
    }

    @PostMapping("/post")
    public R<Manager> managerRs(@RequestBody Manager manager){
        return R.success(manager,"ok");
    }

}
