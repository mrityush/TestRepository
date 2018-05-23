package com.restservices.app.service.interfaces;

import com.restservices.app.exceptions.DeviceNotFoundException;
import com.restservices.app.exceptions.InvalidIpPassedException;
import com.restservices.app.exceptions.IpNotMatchingWithDeviceException;

/**
 * Created by Priya on 28/4/18.
 */
public interface HeartBeatService {
    Boolean refresh(String macAddress, String allocatedIPAddr) throws DeviceNotFoundException, IpNotMatchingWithDeviceException, InvalidIpPassedException, Exception;
}
