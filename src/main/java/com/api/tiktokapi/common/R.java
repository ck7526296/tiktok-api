package com.api.tiktokapi.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {
    /**
     * 校验码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 操作成功
     */
    private final static Integer SUCCESS = 1;
    /**
     * 操作失败
     */
    private final static Integer ERROR = 0;
    /**
     * 返回数据对象
     */
    private T data;
    /**
     * 返回map
     */
    private Map<String, Object> map = new HashMap<>();


    public static <T> R<T> success(String msg) {
        return success(null, msg);
    }

    public static <T> R<T> success(T object, String msg) {

        R<T> r = new R<T>();
        r.msg = msg;
        r.data = object;
        r.code = SUCCESS;
        return r;
    }

    public static <T> R<T> error(String msg) {
        return error(null, msg);
    }

    public static <T> R<T> error(T object, String msg) {
        R<T> r = new R<T>();
        r.msg = msg;
        r.data = object;
        r.code = ERROR;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
