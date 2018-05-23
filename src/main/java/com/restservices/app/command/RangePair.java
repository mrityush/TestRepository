package com.restservices.app.command;

/**
 * Created by Priya on 28/4/18.
 */
public class RangePair {
    private Integer lowerLimit;
    private Integer upperLimit;

    /**
     * Sets new lowerLimit.
     *
     * @param lowerLimit New value of lowerLimit.
     */
    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    /**
     * Gets lowerLimit.
     *
     * @return Value of lowerLimit.
     */
    public Integer getLowerLimit() {
        return lowerLimit;
    }

    /**
     * Gets upperLimit.
     *
     * @return Value of upperLimit.
     */
    public Integer getUpperLimit() {
        return upperLimit;
    }

    /**
     * Sets new upperLimit.
     *
     * @param upperLimit New value of upperLimit.
     */
    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }
}
