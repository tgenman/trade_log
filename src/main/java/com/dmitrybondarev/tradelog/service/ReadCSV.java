package com.dmitrybondarev.tradelog.service;

import com.dmitrybondarev.tradelog.model.Trade;
import com.dmitrybondarev.tradelog.model.TradeLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Util class to read .csv, parse and save information to TradeLog.
 */
public class ReadCSV {

    public void readFromFile(String path, TradeLog tradeLog) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                String time = row[0];
                double price = Double.parseDouble(row[1]);
                int volume = Integer.parseInt(row[2]);
                String exchange = row[3];

                Trade trade = new Trade(time, price, volume, exchange);

                tradeLog.addTrade(trade);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
