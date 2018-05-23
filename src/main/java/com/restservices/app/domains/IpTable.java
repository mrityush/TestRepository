package com.restservices.app.domains;

import javax.persistence.Entity;

/**
 * Created by Priya on 28/4/18.
 */

/**
 * Table to store all IPs possible and fetch new IP whenever needed. For storing correct IP in it, there has to be validation put in it
 */
@Entity(name = "ip_table")
public class IpTable extends CommonDataEntity {
    private String ip;

    /**
     * Sets new ip.
     *
     * @param ip New value of ip.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Gets ip.
     *
     * @return Value of ip.
     */
    public String getIp() {
        return ip;
    }
}
