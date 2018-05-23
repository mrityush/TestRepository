package com.restservices.app.repositories;

import com.restservices.app.domains.Device;
import com.restservices.app.domains.DeviceIpAllocated;
import com.restservices.app.enums.EntityStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Priya on 28/4/18.
 */
public interface DeviceIpAllocatedRepository  extends CrudRepository<DeviceIpAllocated, Long> {
    DeviceIpAllocated findByEntityStatus(EntityStatus active);

    DeviceIpAllocated findByDeviceAndEntityStatusAndAllocatedIp(Device device, EntityStatus status, String allocatedIPAddr);

    List<DeviceIpAllocated> findByDeviceAndEntityStatus(Device device, EntityStatus entityStatus);
}
