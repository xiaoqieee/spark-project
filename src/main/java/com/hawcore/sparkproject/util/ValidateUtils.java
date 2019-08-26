package com.hawcore.sparkproject.util;

import java.util.Map;

/**
 * @author xn025665
 */
public class ValidateUtils {

    public static boolean between(String data, String conditionStrings, String startColumn, String endColumn) {
        checkParam(data);

        Map<String, String> keyValueMap = StringUtils.toMap(conditionStrings);
        String start = keyValueMap.get(startColumn);
        String end = keyValueMap.get(endColumn);
        if (StringUtils.isEmpty(start)) {
            throw new RuntimeException("start 不能为空");
        }
        if (StringUtils.isEmpty(end)) {
            throw new RuntimeException("end 不能为空");
        }
        return data.compareTo(start) >= 0 && data.compareTo(end) <= 0;
    }

    public static boolean in(String data, String conditionStrings, String columnName) {
        checkParam(data);

        Map<String, String> keyValueMap = StringUtils.toMap(conditionStrings);
        String conditionValue = keyValueMap.get(columnName);
        if (StringUtils.isEmpty(conditionValue)) {
            return false;
        }
        String[] valueArr = conditionValue.split(",");
        for (String value : valueArr) {
            if (data.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean eq(String data, String conditionStrings, String columnName) {
        checkParam(data);

        Map<String, String> keyValueMap = StringUtils.toMap(conditionStrings);
        String conditionValue = keyValueMap.get(columnName);
        if (StringUtils.isEmpty(conditionValue)) {
            return false;
        }
        return data.equals(conditionValue);
    }

    private static void checkParam(String data) {
        if (StringUtils.isEmpty(data)) {
            throw new RuntimeException("data 不能为空");
        }
    }


}
