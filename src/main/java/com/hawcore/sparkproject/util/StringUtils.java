package com.hawcore.sparkproject.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xn025665
 */
public class StringUtils {

    public static boolean isEmpty(String value) {
        if (null == value || value.length() == 0) {
            return true;
        }
        if (value.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static String trimSpecifiedCharacter(String value, String character) {
        if (value == null) {
            return null;
        }
        if (value.startsWith(character)) {
            value = value.substring(character.length());
        }
        if (value.endsWith(character)) {
            value = value.substring(0, value.length() - character.length());
        }
        return value;
    }

    public static String trimComma(String value) {
        return trimSpecifiedCharacter(value, ",");
    }

    public static String trimVerticalLine(String value) {
        return trimSpecifiedCharacter(value, "\\|");
    }

    public static String toKeyValueString(Map<String, String> keyValues) {
        StringBuffer sb = new StringBuffer();
        if (null != keyValues) {
            for (Map.Entry<String, String> entry : keyValues.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("|");
            }
        }
        return trimVerticalLine(sb.toString());
    }

    public static Map<String, String> toMap(String keyValueString) {
        Map<String, String> result = new HashMap<>(4);
        if (null != keyValueString) {
            String[] keyValueArr = keyValueString.split("\\|");
            if (keyValueArr != null && keyValueArr.length > 0) {
                String[] kvArr = null;
                for (String keyValue : keyValueArr) {
                    kvArr = keyValue.split("=");
                    result.put(kvArr[0], (kvArr.length == 2) ? kvArr[1] : null);
                }
            }
        }
        return result;
    }

    public String getFromKeyValueString(String keyValueString, String keyStr) {
        Map<String, String> result = toMap(keyValueString);
        return result.get(keyStr);
    }

}
