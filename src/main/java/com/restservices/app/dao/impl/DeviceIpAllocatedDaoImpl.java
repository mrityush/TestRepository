package com.restservices.app.dao.impl;

import com.restservices.app.dao.interfaces.DeviceIpAllocatedDao;
import com.restservices.app.domains.Device;
import com.restservices.app.domains.DeviceIpAllocated;
import com.restservices.app.enums.EntityStatus;
import com.restservices.app.repositories.DeviceIpAllocatedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Priya on 28/4/18.
 */
@Repository
public class DeviceIpAllocatedDaoImpl implements DeviceIpAllocatedDao {
    @Autowired
    DeviceIpAllocatedRepository deviceIpAllocatedRepository;

    @Override
    public void save(DeviceIpAllocated deviceIpAllocated) {
        deviceIpAllocatedRepository.save(deviceIpAllocated);
    }

    @Override
    public void update(DeviceIpAllocated deviceIpAllocated) {
        deviceIpAllocated.setLastUpdated(Calendar.getInstance().getTime());
        deviceIpAllocatedRepository.save(deviceIpAllocated);
    }

    @Override
    public DeviceIpAllocated get(Long id) {
        return deviceIpAllocatedRepository.findOne(id);
    }

    @Override
    public DeviceIpAllocated findNextInactiveIp() {
        return deviceIpAllocatedRepository.findByEntityStatus(EntityStatus.ACTIVE);
    }

    @Override
    public DeviceIpAllocated findByDeviceAndStatusAndAllocatedIp(Device device, EntityStatus status, String allocatedIPAddr) {
        return deviceIpAllocatedRepository.findByDeviceAndEntityStatusAndAllocatedIp(device, status, allocatedIPAddr);
    }

    @Override
    public List<DeviceIpAllocated> findByDeviceAndEntityStatus(Device device, EntityStatus entityStatus) {
        return deviceIpAllocatedRepository.findByDeviceAndEntityStatus(device, entityStatus);
    }
}
