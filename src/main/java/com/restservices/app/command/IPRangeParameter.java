package com.restservices.app.command;

/**
 * Created by Priya on 28/4/18.
 */
public class IPRangeParameter {
    private RangePair[] rangePairs = new RangePair[4];


    /**
     * Gets rangePairs.
     *
     * @return Value of rangePairs.
     */
    public RangePair[] getRangePairs() {
        return rangePairs;
    }

    /**
     * Sets new rangePairs.
     *
     * @param rangePairs New value of rangePairs.
     */
    public void setRangePairs(RangePair[] rangePairs) {
        this.rangePairs = rangePairs;
    }
}
