package com.api.tiktokapi.controller;

import com.api.tiktokapi.common.Md5Util;
import com.api.tiktokapi.common.OnlineLive;
import com.api.tiktokapi.common.R;
import com.api.tiktokapi.entity.LiveWarrant;
import com.api.tiktokapi.service.LiveWarrantService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/client")
public class LiveClientController {

    @Resource
    private LiveWarrantService liveWarrantService;

    @PostMapping
    public R<LiveWarrant> get(@RequestBody LiveWarrant liveWarrant) {

        final LiveWarrant byLiveId = liveWarrantService.getByLiveId(liveWarrant.getLiveId());
        Long localDateTime = new Date().getTime();
        log.info(liveWarrant.toString());
        if (byLiveId == null) {
            return R.error("The live room does not exist.");
        }

        if ("".equals(byLiveId.getDevice())) {
            log.info("该直播间没有绑定直播间");
            byLiveId.setDevice(liveWarrant.getDevice());
            liveWarrantService.updateDeviceByLiveId(byLiveId);
        }

        if (!byLiveId.getDevice().equals(liveWarrant.getDevice())) {
            return R.error("该设备没有授权");
        }

        if (OnlineLive.isOnline(byLiveId.getLiveId())) {

            if (!byLiveId.getDevice().equals(liveWarrant.getDevice())) {
                return R.error("Live is online.");
            }

            if (byLiveId.getStatus() == 0) {
                return R.error("Live rooms are not enabled.");
            }



        }

        OnlineLive.Live old = OnlineLive.getLive(byLiveId.getLiveId());

        byLiveId.setRandom(liveWarrant.getRandom());
        byLiveId.setCode(liveWarrant.getCode());
        byLiveId.setCode(Md5Util.codeMake(byLiveId, liveWarrant.getRandom(), localDateTime.toString()));

        if (old == null) {
            old = OnlineLive.update(byLiveId.getLiveId(), liveWarrant.getCode());

        } else {
            byLiveId.setWarrant("");
        }


        if (!old.getOnlineId().equals(liveWarrant.getCode())) {
            return R.error("Live is online.");
        }


        byLiveId.setRemark("");
        byLiveId.setDevice("");
        byLiveId.setRandom("");
        byLiveId.setId(0L);
        byLiveId.setTime(localDateTime);
        byLiveId.setDevice(liveWarrant.getDevice());

//        OnlineLive.update(byLiveId.getLiveId(), liveWarrant.getCode());
        return R.success(byLiveId, "ok");

    }
}
