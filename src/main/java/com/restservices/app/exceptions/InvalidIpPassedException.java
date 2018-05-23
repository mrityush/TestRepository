package com.restservices.app.exceptions;

/**
 * Created by Priya on 28/4/18.
 */
public class InvalidIpPassedException extends Throwable {

    public InvalidIpPassedException() {
        super("Invalid Ip Passed");
    }
}
