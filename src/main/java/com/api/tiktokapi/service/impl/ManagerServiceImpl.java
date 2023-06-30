package com.api.tiktokapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.api.tiktokapi.entity.Manager;
import com.api.tiktokapi.service.ManagerService;
import com.api.tiktokapi.mapper.ManagerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author king
* @description 针对表【manager】的数据库操作Service实现
* @createDate 2023-03-14 21:10:16
*/

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager>
    implements ManagerService{


    @Override
    public Manager getByUserId(String userId) {
        final LambdaQueryWrapper<Manager> managerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        managerLambdaQueryWrapper.eq(Manager::getUserId,userId);

        return list(managerLambdaQueryWrapper).get(0);
    }


}




