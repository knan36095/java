package org.dxstudio.openapi.untils;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;


@Slf4j
public class SignUtil {

    private static String getListString(List<Map<String, Object>> list) {
        List<String> l = new ArrayList<>();
        list.forEach(item -> {
            l.add(getString(item));
        });
        String arrStr = String.join(",", l);
        return "[" + arrStr + "]";
    }

    public static String getString(Map<String, Object> p) {
        List<String> query = new ArrayList<>();
        p.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((v) -> {
            String s;
            Object value = v.getValue();
            if (value == null) return;
            if (value instanceof List<?>) {
                List<?> list = (List<?>) value;
                if (list.isEmpty()) return;
                if (list instanceof Map<?, ?>) {
                    s = getListString((List<Map<String, Object>>) list);
                } else {
                    s = getListConstable(list);
                }
            } else if (value instanceof Map) {
                s = "{" + getString((Map<String, Object>) value) + "}";
            } else if (value instanceof Double) {
                Double doubleValue = (Double) value;
                s = new BigDecimal(String.valueOf(doubleValue)).stripTrailingZeros().toPlainString();
            } else if (value instanceof Float) {
                Float floatValue = (Float) value;
                s = new BigDecimal(String.valueOf(floatValue)).stripTrailingZeros().toPlainString();
            } else if (value instanceof BigDecimal) {
                BigDecimal bigDecimalValue = (BigDecimal) value;
                s = bigDecimalValue.stripTrailingZeros().toPlainString();
            } else {
                s = value.toString();
            }

            query.add(v.getKey() + "=" + s);
        });
        return String.join("&", query);
    }

    private static String getListConstable(List<?> list) {
        List<String> l = new ArrayList<>();
        list.forEach(item -> {
            l.add(String.valueOf(item));
        });
        String arrStr = String.join(",", l);
        return "[" + arrStr + "]";
    }

    public static String getSignStr(Map<String, Object> p, String secret) {
        return getString(p) + "&secret=" + secret;
    }

    public static String getSign(Map<String, Object> p, String secret) {
        if (p.isEmpty()) return "";
        String originalSign = getSignStr(p, secret);
        log.info("待加密字符串 {}", originalSign);
        return DigestUtils.md5Hex(originalSign.getBytes());
    }


    public static Boolean verifySign(JSONObject param, String key,String secret) {

        log.info("收到回调通知 {}", param.toJSONString());
        param.put("key", key);
        //验证签名
        String sign = param.getString("sign");
        param.remove("sign");

        String validStr = getSign(param, secret);

        return validStr.equals(sign);
    };

}