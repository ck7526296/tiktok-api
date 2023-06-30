package com.api.tiktokapi.common;

import com.api.tiktokapi.entity.LiveWarrant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Slf4j
public class Md5Util {
    final static private String code = "ck7526296";

    public static String md5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String codeMake(LiveWarrant liveWarrant, String random, String now) {
        if (random == null) random = "";

        String builder = liveWarrant.getLiveId() +
                liveWarrant.getDevice() +
                liveWarrant.getWarrant() +
                1 +
                liveWarrant.getExpirationDate().getTime() +
                random +
                code +
                now;
        log.info(builder);
        return DigestUtils.md5DigestAsHex(builder.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        System.out.println(md5("tiktok_device0:178BFBFF00860F011:C8:B2:9B:DB:BF:D21:00:2B:67:D8:59:321:C8:B2:9B:DB:BF:D31:CA:B2:9B:DB:BF:D21:B2:D0:20:52:41:531:B2:54:20:52:41:531:B0:AC:20:52:41:532:PF2D84583:0025_3883_01D5_24FD.4:PF2D8458").equals("0add2b0af04fa1f81b1c86cf973d0ecc"));
    }
}
