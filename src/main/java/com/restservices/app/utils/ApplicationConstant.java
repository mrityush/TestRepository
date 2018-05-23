package com.restservices.app.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mj on 1/6/16.
 */
public class ApplicationConstant {

    public static final String DUMMY_NAME = "DUMMY NAME";
    public static final Integer ERROR_STATUS_CODE = 0;
    public static final Integer HTTP_RESPONSE_ERROR_CODE = 500;
    public static final Integer HTTP_RESPONSE_SUCCESS_CODE = 200;
    public static final Integer MAX_NO_OF_LOGIN_INFO = 3;
    public static final Integer SUCCESS_STATUS_CODE = 1;
    public static final Long SYSTEM_ID = -1L;
    public static final int OTP_EXPIRY_TIME_IN_MINUTES = 3;
    public static final Integer noOfMonthsForExchangeData = 3;
    public static final String X_AUTH_TOKEN = "authorization";
    public static final Integer SERVER_ERROR = 500;
    public static final Integer SERVER_OK = 200;
    public static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    public static final String YYYYMMDD_hyphen = "yyyy-MM-dd";
    public static final String YYYYMMDD_slash = "yyyy/MM/dd";
    public static final String DDMMYYYY_hyphen = "dd-MM-yyyy";
    public static final String DDMMYYYY_HHMMSS_hyphen = "dd-MM-yyyy HH:mm:ss:SSS";
    public static final String HHMMSS_SSS = "HH:mm:ss:SSS";
    public static final String HHMM = "HH:mm";
    public static final String DDMMYYYY_slash = "dd/MM/yyyy";
    public static final String YYYYMMMMMd = "yyyy MMMMM d";//2001 january 5
    public static final String YYYYdMMMMM = "yyyy d MMMMM";//2001 5 january
    public static final String dMMMMMYYYY = "d MMMMM yyyy";//5 january 2001
    public static final String MMMMMd = "MMMMM d";//january 5
    public static final String dMMMMM = "d MMMMM";//5 january
    public static final List<String> BYPASSED_URLS = new LinkedList<String>() {{
        add("/");
    }};
    public static Integer LOWER_IP_LIMIT = 10;
    public static Integer UPPER_IP_LIMIT = 255;
}
