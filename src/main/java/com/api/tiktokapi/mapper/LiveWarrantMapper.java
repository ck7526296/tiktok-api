package com.api.tiktokapi.mapper;

import com.api.tiktokapi.entity.LiveWarrant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author king
* @description 针对表【live_warrant】的数据库操作Mapper
* @createDate 2023-03-15 16:47:34
* @Entity com.api.tiktokapi.entity.LiveWarrant
*/
public interface LiveWarrantMapper extends BaseMapper<LiveWarrant> {
    void updateDeviceByLiveId(@Param("liveId") String live,@Param("device") String device);
}




