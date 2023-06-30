package com.api.tiktokapi.service;

import com.api.tiktokapi.entity.LiveWarrant;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author king
* @description 针对表【live_warrant】的数据库操作Service
* @createDate 2023-03-15 16:47:34
*/
public interface LiveWarrantService extends IService<LiveWarrant> {
    LiveWarrant getByLiveId(String liveId);
    void updateDeviceByLiveId(LiveWarrant live);
}
