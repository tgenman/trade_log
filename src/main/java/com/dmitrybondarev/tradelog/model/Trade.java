package com.dmitrybondarev.tradelog.model;

public class Trade implements Comparable {

    private final String time;

    private final double price;

    private final int volume;

    private final String exchange;

    public Trade(String time,
                 double priceOfTrade,
                 int volumeOfTrade,
                 String exchange
    ) {
        this.time = time;
        this.price = priceOfTrade;
        this.volume = volumeOfTrade;
        this.exchange = exchange;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public String getExchange() {
        return exchange;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "time='" + time + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", exchange='" + exchange + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
