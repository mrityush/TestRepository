package com.restservices.app.exceptions;

/**
 * Created by Priya on 28/4/18.
 */
public class DeviceNotFoundException extends Throwable {
    public DeviceNotFoundException() {
        super("Device not found");
    }
}
