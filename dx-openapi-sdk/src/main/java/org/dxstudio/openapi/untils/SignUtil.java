package org.dxstudio.openapi.untils;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils ;

public class SignUtil {

    private final static Logger log = LoggerFactory.getLogger(SignUtil.class);
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
            if( value == null ) return ;
            if (value instanceof List<?>) {
                List<?> list = (List<?>) value;
                s = getListString((List<Map<String, Object>>) list);
            }else if (value instanceof Map){
                s = "{" + getString( (Map<String, Object>) value ) + "}";
            }else if (value instanceof Double) {
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

    public static String getSignStr(Map<String, Object> p, String secret){
        return getString(p) + "&secret=" + secret;
    }

    public static String getSign(Map<String, Object> p, String secret) {
        if (p.isEmpty()) return "";
        String originalSign = getSignStr(p, secret);
        log.warn("ML待加密字符串 {}",originalSign);
        return DigestUtils.md5Hex(originalSign.getBytes());
    }

}