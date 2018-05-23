package com.restservices.app.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Priya on 28/4/18.
 */
public enum EntityStatus {
    ACTIVE(0, "Active"),
    INACTIVE(1, "Inactive"),
    PAUSED(2, "Paused");

    Integer value;
    String description;

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    EntityStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    static Map<Integer, EntityStatus> authoritiesMap = new HashMap<>();

    static {
        for (EntityStatus generalStatus : EntityStatus.values()) {
            authoritiesMap.put(generalStatus.getValue(), generalStatus);
        }
    }

    public static EntityStatus valueOf(Integer enumValue) {
        return authoritiesMap.get(enumValue);
    }
}
