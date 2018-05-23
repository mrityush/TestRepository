package com.restservices.app.domains;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Priya on 28/4/18.
 */
@Entity
public class Device extends CommonDataEntity {
    private String name;
    @Column(unique = true)
    private String macAddress;
    private String model;

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new model.
     *
     * @param model New value of model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets new macAddress.
     *
     * @param macAddress New value of macAddress.
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * Gets macAddress.
     *
     * @return Value of macAddress.
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Gets model.
     *
     * @return Value of model.
     */
    public String getModel() {
        return model;
    }
}
