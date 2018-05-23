package com.restservices.app.service.impl;

import com.restservices.app.command.IPRangeParameter;
import com.restservices.app.dao.interfaces.IpTableDao;
import com.restservices.app.dao.interfaces.DeviceDao;
import com.restservices.app.dao.interfaces.DeviceIpAllocatedDao;
import com.restservices.app.domains.Device;
import com.restservices.app.domains.DeviceIpAllocated;
import com.restservices.app.domains.IpTable;
import com.restservices.app.dto.ResponseDto;
import com.restservices.app.dto.SuccessResponseDto;
import com.restservices.app.enums.EntityStatus;
import com.restservices.app.exceptions.DeviceNotFoundException;
import com.restservices.app.service.interfaces.AllocationService;
import com.restservices.app.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Priya on 28/4/18.
 */
@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private DeviceIpAllocatedDao deviceIpAllocatedDao;
    @Autowired
    private IpTableDao ipTableDao;
    @Value("${validity.period.extension.amount}")
    private Integer periodExtensionAmount;

    @Override
    public Boolean allocateIps() {
        try {

            for (int i = 1; i <= 255; i++)
                for (int j = 1; j <= 255; j++)
                    for (int k = 1; k <= 255; k++)
                        for (int l = 1; l <= 255; l++) {
                            IpTable ipTable = new IpTable();
                            String ip = i + "." + j + "." + k + "." + l;
                            if (HttpUtils.validate(ip) && HttpUtils.inRange(i,j,k,l)) {
                                ipTable.setIp(ip);
                                ipTableDao.save(ipTable);
                            }
                        }
            return true;
        } catch (Exception e) {
            System.out.println("Error in entering IPs");
            return false;
        }
    }

    @Override
    public String allocate(String macAddress) throws DeviceNotFoundException {
        Device device = deviceDao.findByMacAddress(macAddress);
        if (device == null)
            throw new DeviceNotFoundException();
        IpTable ipTable = ipTableDao.findNextInactiveIp();
        String ipAllotted = getIpAfterSettingDeviceIp(device, ipTable);
        return ipAllotted;
    }

    private String getIpAfterSettingDeviceIp(Device device, IpTable ipTable) {
        List<DeviceIpAllocated> deviceIpsAllocated = deviceIpAllocatedDao.findByDeviceAndEntityStatus(device, EntityStatus.ACTIVE);
        for (DeviceIpAllocated deviceIpAllocated1 : deviceIpsAllocated) {
            if (deviceIpAllocated1.getEntityStatus() == EntityStatus.ACTIVE) {
                deviceIpAllocated1.setEntityStatus(EntityStatus.INACTIVE);
                deviceIpAllocatedDao.update(deviceIpAllocated1);
            }
        }
        String ip = ipTable.getIp();
        DeviceIpAllocated deviceIpAllocated = new DeviceIpAllocated();
        deviceIpAllocated.setDevice(device);
        deviceIpAllocated.setAllocatedIp(ip);
        deviceIpAllocated.setTimeOfAllotment(Calendar.getInstance().getTime());
        deviceIpAllocated.setValidityPeriod(periodExtensionAmount);
        deviceIpAllocatedDao.update(deviceIpAllocated);

        ipTable.setEntityStatus(EntityStatus.ACTIVE);
        ipTableDao.update(ipTable);
        return ip;
    }

    @Override
    public ResponseDto setIpRange(IPRangeParameter rangeParameter) {

        return new SuccessResponseDto("Success!!");
    }
}
