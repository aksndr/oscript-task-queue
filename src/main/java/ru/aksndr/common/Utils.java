package ru.aksndr.common;//Created by Arzamastsev on 09.11.2016.

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, Object> validateTaskParams(Map<String, Object> taskParams){
        if (!taskParams.containsKey("script"))
            return error("Обязательный параметр 'script' необходимый для выполнения задачи отсутствует.");

        return ok(null);
    }

    public static Map<String, Object> ok(Object value){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        result.put("value", value);
        return result;
    }

    public static Map<String, Object> error(String errMsg){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", false);
        result.put("errMsg", errMsg);
        return result;
    }
}
