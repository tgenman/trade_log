package com.dmitrybondarev.tradelog.model;

/**
 * Class to contain information about trade.
 */
public class Trade {

    /**
     *Contain Time Stamp in String for simplicity.
     * Convert to int when process TradeLog
     */
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
        return "Trade{"
                + "time='" + time + '\''
                + ", price=" + price
                + ", volume=" + volume
                + ", exchange='" + exchange
                + '\''
                + '}';
    }
}
