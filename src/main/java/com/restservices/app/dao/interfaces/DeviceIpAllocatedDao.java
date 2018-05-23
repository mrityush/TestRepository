package com.restservices.app.dao.interfaces;

import com.restservices.app.domains.Device;
import com.restservices.app.domains.DeviceIpAllocated;
import com.restservices.app.enums.EntityStatus;

import java.util.List;

/**
 * Created by Priya on 28/4/18.
 */
public interface DeviceIpAllocatedDao extends BaseDao<DeviceIpAllocated> {
    DeviceIpAllocated findNextInactiveIp();

    DeviceIpAllocated findByDeviceAndStatusAndAllocatedIp(Device device, EntityStatus active, String allocatedIPAddr);

    List<DeviceIpAllocated> findByDeviceAndEntityStatus(Device device, EntityStatus active);
}
