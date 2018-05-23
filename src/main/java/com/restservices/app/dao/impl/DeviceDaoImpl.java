package com.restservices.app.dao.impl;

import com.restservices.app.dao.interfaces.DeviceDao;
import com.restservices.app.domains.Device;
import com.restservices.app.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

/**
 * Created by Priya on 28/4/18.
 */
@Repository
public class DeviceDaoImpl implements DeviceDao {
    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public void save(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public void update(Device device) {
        device.setLastUpdated(Calendar.getInstance().getTime());
        deviceRepository.save(device);
    }

    @Override
    public Device get(Long id) {
        return deviceRepository.findOne(id);
    }

    @Override
    public Device findByMacAddress(String macAddress) {
        return deviceRepository.findByMacAddress(macAddress);
    }
}
