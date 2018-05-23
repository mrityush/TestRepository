package com.restservices.app.exceptions;

/**
 * Created by Priya on 28/4/18.
 */
public class IpNotMatchingWithDeviceException extends Throwable {

    public IpNotMatchingWithDeviceException() {
        super("Ip passed does not match with the device mac.");
    }
}
