package com.api.tiktokapi.controller;

import com.api.tiktokapi.common.Md5Util;
import com.api.tiktokapi.common.R;
import com.api.tiktokapi.entity.LiveWarrant;
import com.api.tiktokapi.service.LiveWarrantService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/live")
public class LiveWarrantController {

    @Resource
    private LiveWarrantService liveWarrantService;

    @GetMapping("/list")
    public R<List<LiveWarrant>> getAllLive() {
        return R.success(liveWarrantService.list(), "Get successful.");
    }

    @PostMapping("/add")
    public R<String> add(@RequestBody LiveWarrant liveWarrant) {
        liveWarrant.setWarrant(Md5Util.md5(LocalDateTime.now().toString() + new Random().nextDouble(0D, 100000D)));
        liveWarrant.setCreateTime(LocalDateTime.now());
        liveWarrant.setExpirationDate(new Date());
        liveWarrant.setDevice("");
        liveWarrant.setStatus(1L);
        try {
            liveWarrantService.save(liveWarrant);
        } catch (DuplicateKeyException e) {
            return R.error("The live room ID exists.");
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return R.error("Unknown error.");
        }
        return R.success("The addition succeeded.");
    }



    @PostMapping("/reset")
    public R<String> reset(@RequestBody LiveWarrant liveWarrant) {

        final LiveWarrant byId = liveWarrantService.getById(liveWarrant);
        if (byId == null) {
            return R.error("The live room does not exist.");
        }

        byId.setDevice("");
        liveWarrantService.updateDeviceByLiveId(byId);
        return R.success("ok");

    }
    @PostMapping("/delete")
    public R<String> delete(@RequestBody LiveWarrant liveWarrant) {

        final LiveWarrant byId = liveWarrantService.getById(liveWarrant);
        if (byId == null) {
            return R.error("The live room does not exist.");
        }

        byId.setDevice("");
        liveWarrantService.removeById(byId.getId());
        return R.success("ok");

    }
    @PostMapping("/change")
    public R<String> change(@RequestBody LiveWarrant liveWarrant) {

        final LiveWarrant byId = liveWarrantService.getById(liveWarrant);
        if (byId == null) {
            return R.error("The live room does not exist.");
        }
        log.info("{} ==> {}",byId.getStatus(),byId.getStatus()==1?0L:1L);
        byId.setStatus(byId.getStatus()==1?0L:1L);
        liveWarrantService.updateById(byId);
        return R.success("ok");

    }
}
