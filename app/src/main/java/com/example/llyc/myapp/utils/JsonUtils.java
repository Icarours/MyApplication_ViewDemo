package com.example.llyc.myapp.utils;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by Bright on 2018/11/2.
 *
 * @Describe
 * @Called
 */
public class JsonUtils {
    /**
     * map集合转化为json数据
     * @param map
     * @param <T>
     * @return
     */
    public static <T> String mapToJson(Map<String, T> map) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }
}
