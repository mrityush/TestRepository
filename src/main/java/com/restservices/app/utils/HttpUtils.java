package com.restservices.app.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Priya on 28/4/18.
 */
public class HttpUtils {
    public static String getRemoteUrl(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }


    public static boolean validate(final String ip) {
        Pattern pattern = Pattern.compile(ApplicationConstant.IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static boolean inRange(int i, int j, int k, int l) {
        if (i > ApplicationConstant.LOWER_IP_LIMIT && i < ApplicationConstant.UPPER_IP_LIMIT &&
                j > ApplicationConstant.LOWER_IP_LIMIT && j < ApplicationConstant.UPPER_IP_LIMIT &&
                k > ApplicationConstant.LOWER_IP_LIMIT && k < ApplicationConstant.UPPER_IP_LIMIT &&
                l > ApplicationConstant.LOWER_IP_LIMIT && l < ApplicationConstant.UPPER_IP_LIMIT
                ) return true;
        else return false;
    }
}
