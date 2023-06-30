package com.api.tiktokapi.service;

import com.api.tiktokapi.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author king
* @description 针对表【manager】的数据库操作Service
* @createDate 2023-03-14 21:10:16
*/
public interface ManagerService extends IService<Manager> {
    Manager getByUserId(String userId);
}
