package com.restservices.app.domains;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Priya on 28/4/18.
 */
@Entity(name = "device_ip_allocated")
public class DeviceIpAllocated extends CommonDataEntity {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "deviceId")
    private Device device;

    private String allocatedIp;
    private Date timeOfAllotment;
    private Integer validityPeriod;


    /**
     * Gets allocatedIp.
     *
     * @return Value of allocatedIp.
     */
    public String getAllocatedIp() {
        return allocatedIp;
    }

    /**
     * Sets new allocatedIp.
     *
     * @param allocatedIp New value of allocatedIp.
     */
    public void setAllocatedIp(String allocatedIp) {
        this.allocatedIp = allocatedIp;
    }

    /**
     * Gets device.
     *
     * @return Value of device.
     */
    public Device getDevice() {
        return device;
    }

    /**
     * Gets timeOfAllotment.
     *
     * @return Value of timeOfAllotment.
     */
    public Date getTimeOfAllotment() {
        return timeOfAllotment;
    }

    /**
     * Sets new device.
     *
     * @param device New value of device.
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * Sets new timeOfAllotment.
     *
     * @param timeOfAllotment New value of timeOfAllotment.
     */
    public void setTimeOfAllotment(Date timeOfAllotment) {
        this.timeOfAllotment = timeOfAllotment;
    }

    /**
     * Gets validityPeriod.
     *
     * @return Value of validityPeriod.
     */
    public Integer getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Sets new validityPeriod.
     *
     * @param validityPeriod New value of validityPeriod.
     */
    public void setValidityPeriod(Integer validityPeriod) {
        this.validityPeriod = validityPeriod;
    }
}
