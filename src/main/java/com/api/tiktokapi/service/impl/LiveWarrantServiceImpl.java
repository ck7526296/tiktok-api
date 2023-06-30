package com.api.tiktokapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.api.tiktokapi.entity.LiveWarrant;
import com.api.tiktokapi.service.LiveWarrantService;
import com.api.tiktokapi.mapper.LiveWarrantMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author king
 * @description 针对表【live_warrant】的数据库操作Service实现
 * @createDate 2023-03-15 16:47:34
 */
@Service
public class LiveWarrantServiceImpl extends ServiceImpl<LiveWarrantMapper, LiveWarrant>
        implements LiveWarrantService {

    @Resource
    private LiveWarrantMapper liveWarrantMapper;
    @Override
    public LiveWarrant getByLiveId(String liveId) {
        final LambdaQueryWrapper<LiveWarrant> liveWarrantLambdaQueryWrapper = new LambdaQueryWrapper<>();
        liveWarrantLambdaQueryWrapper.eq(LiveWarrant::getLiveId, liveId);

        return getOne(liveWarrantLambdaQueryWrapper);
    }

    @Override
    public void updateDeviceByLiveId(LiveWarrant live) {
        liveWarrantMapper.updateDeviceByLiveId(live.getLiveId(),live.getDevice());
    }


}




