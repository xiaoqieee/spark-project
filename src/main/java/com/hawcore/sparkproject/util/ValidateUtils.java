package com.hawcore.sparkproject.util;

import java.util.Map;

/**
 * @author xn025665
 */
public class ValidateUtils {

    public boolean between(String data, String conditionStrings, String startColumn, String endColumn) {
        if (StringUtils.isEmpty(data)) {
            throw new RuntimeException("data 不能为空");
        }
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

    public boolean in(String data, String conditionStrings, String columnName) {
        if (StringUtils.isEmpty(data)) {
            throw new RuntimeException("data 不能为空");
        }
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

    public boolean eq(String data, String conditionStrings, String columnName) {
        if (StringUtils.isEmpty(data)) {
            throw new RuntimeException("data 不能为空");
        }
        Map<String, String> keyValueMap = StringUtils.toMap(conditionStrings);
        String conditionValue = keyValueMap.get(columnName);
        if (StringUtils.isEmpty(conditionValue)) {
            return false;
        }
        return data.equals(conditionValue);
    }


}
