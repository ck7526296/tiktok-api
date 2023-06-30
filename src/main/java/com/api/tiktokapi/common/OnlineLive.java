package com.api.tiktokapi.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class OnlineLive {
    private static final String PY_ID = "py_id";
    private static final String ONLINE = "online";
    private static final Map<String, Live> data = new HashMap<>();

    @Scheduled(fixedDelay = 3000)
    public synchronized void diff() {
        for (Map.Entry<String, Live> liveEntry : data.entrySet()) {

            final Live value = liveEntry.getValue();
            final String key = liveEntry.getKey();

            if (value.getOnlineStatus()) {
                value.setOnlineStatus(false);
            } else {
                data.remove(key);
                log.info("{} 下线",key);
            }

        }
    }

    public static synchronized Live update(String liveId, String deviceId) {
        Live live = data.get(liveId);
        if (live != null) {
            live.setOnlineStatus(true);
        } else {
            live = new Live(deviceId);
            data.put(liveId, live);
            log.info("{} 上线",liveId);
        }
        return live;
    }

    public static boolean isOnline(String liveId) {
        return data.get(liveId) != null;
    }

    public static Live getLive(String liveId){
        return data.getOrDefault(liveId,null);
    }
    public static final class Live {
        private Boolean onlineStatus;
        private String OnlineId;

        public Live(String onlineId) {
            OnlineId = onlineId;
            this.onlineStatus = true;
        }

        public Live(Boolean onlineStatus, String onlineId) {
            this.onlineStatus = onlineStatus;
            OnlineId = onlineId;
        }

        public Boolean getOnlineStatus() {
            return onlineStatus;
        }

        public void setOnlineStatus(Boolean onlineStatus) {
            this.onlineStatus = onlineStatus;
        }

        public String getOnlineId() {
            return OnlineId;
        }

        public void setOnlineId(String onlineId) {
            OnlineId = onlineId;

        }
    }


}

