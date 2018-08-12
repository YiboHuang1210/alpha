package com.hyb.alpha.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * JSON 工具类
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/3 11:55
 **/
public class JSONUtil {
    /**
     * 组装json格式返回结果
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    public static Map<String, Object> createJson(boolean isOk, int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("result", isOk ? "ok" : "fail");
        jsonMap.put("rescode", resCode);
        jsonMap.put("msg", errorMsg);
        jsonMap.put("data", obj);
        return jsonMap;
    }

    /**
     * 组装json字符串返回结果
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    public static String createJsonString(boolean isOk, int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = createJson(isOk, resCode, errorMsg, obj);
        return JSON.toJSONString(jsonMap);
    }
}
