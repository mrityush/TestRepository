package com.restservices.app.service.interfaces;

import com.restservices.app.command.IPRangeParameter;
import com.restservices.app.dto.ResponseDto;
import com.restservices.app.exceptions.DeviceNotFoundException;

/**
 * Created by Priya on 28/4/18.
 */
public interface AllocationService {
    Boolean allocateIps();

    String allocate(String macAddress) throws DeviceNotFoundException;

    ResponseDto setIpRange(IPRangeParameter rangeParameter);
}
