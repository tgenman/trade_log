package com.dmitrybondarev.tradelog.model;

public class Interval {

    private final String startInterval;

    private final String endInterval;

    private final int numberOfTrade;

    public Interval(String startInterval, String endInterval, int numberOfTrade) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.numberOfTrade = numberOfTrade;
    }

    public String getStartInterval() {
        return startInterval;
    }

    public String getEndInterval() {
        return endInterval;
    }

    public int getNumberOfTrade() {
        return numberOfTrade;
    }
}
