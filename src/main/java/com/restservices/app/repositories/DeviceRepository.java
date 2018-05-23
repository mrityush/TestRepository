package com.restservices.app.repositories;

import com.restservices.app.domains.Device;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Priya on 28/4/18.
 */
public interface DeviceRepository extends CrudRepository<Device, Long> {
    Device findByMacAddress(String macAddress);
}
