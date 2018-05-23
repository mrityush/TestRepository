package com.restservices.app.dao.interfaces;

import com.restservices.app.domains.Device;

/**
 * Created by Priya on 28/4/18.
 */
public interface DeviceDao extends BaseDao<Device> {
    Device findByMacAddress(String macAddress);
}
