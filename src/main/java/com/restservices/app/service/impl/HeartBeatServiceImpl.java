package com.restservices.app.service.impl;

import com.restservices.app.dao.interfaces.DeviceDao;
import com.restservices.app.dao.interfaces.DeviceIpAllocatedDao;
import com.restservices.app.dao.interfaces.IpTableDao;
import com.restservices.app.domains.Device;
import com.restservices.app.domains.DeviceIpAllocated;
import com.restservices.app.enums.EntityStatus;
import com.restservices.app.exceptions.DeviceNotFoundException;
import com.restservices.app.exceptions.InvalidIpPassedException;
import com.restservices.app.exceptions.IpNotMatchingWithDeviceException;
import com.restservices.app.service.interfaces.HeartBeatService;
import com.restservices.app.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Priya on 28/4/18.
 */
@Service
public class HeartBeatServiceImpl implements HeartBeatService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private DeviceIpAllocatedDao deviceIpAllocatedDao;
    @Autowired
    private IpTableDao ipTableDao;
    @Value("${validity.period.extension.amount}")
    private Integer periodExtensionAmount;

    @Override
    public Boolean refresh(String macAddress, String allocatedIPAddr) throws DeviceNotFoundException, IpNotMatchingWithDeviceException, InvalidIpPassedException, Exception {
        Device device = deviceDao.findByMacAddress(macAddress);
        if (device == null)
            throw new DeviceNotFoundException();
        DeviceIpAllocated deviceIpAllocated = deviceIpAllocatedDao.findByDeviceAndStatusAndAllocatedIp(device, EntityStatus.ACTIVE, allocatedIPAddr);
        checkValidityOfIp(allocatedIPAddr);
        if (deviceIpAllocated == null)
            throw new IpNotMatchingWithDeviceException();
        Integer validityPeriod = deviceIpAllocated.getValidityPeriod();
        Date endtime = getDeviceIpAllocatedEndTime(deviceIpAllocated);
        if (endtime.before(Calendar.getInstance().getTime())) {
            deviceIpAllocated.setEntityStatus(EntityStatus.INACTIVE);
            deviceIpAllocatedDao.update(deviceIpAllocated);
            throw new Exception("IP has ended now. It is no more valid");
        }
        deviceIpAllocated.setValidityPeriod(validityPeriod + periodExtensionAmount);
        deviceIpAllocatedDao.update(deviceIpAllocated);
        return true;
    }

    private Date getDeviceIpAllocatedEndTime(DeviceIpAllocated deviceIpAllocated) {
        Date deviceIpAllocatedStartTime = deviceIpAllocated.getTimeOfAllotment();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(deviceIpAllocatedStartTime);
        calendar.add(Calendar.MINUTE, deviceIpAllocated.getValidityPeriod());
        Date endDate = calendar.getTime();
        return endDate;
    }

    private void checkValidityOfIp(String allocatedIPAddr) throws InvalidIpPassedException {
        if (!HttpUtils.validate(allocatedIPAddr))
            throw new InvalidIpPassedException();
    }


    @Scheduled(cron = "${validity.ip.period}")
    private void updateIpStatus() {
        //// TODO: 28/4/18  
    }
}
