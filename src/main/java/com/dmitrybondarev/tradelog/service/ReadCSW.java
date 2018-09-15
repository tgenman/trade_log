package com.dmitrybondarev.tradelog.service;

import com.dmitrybondarev.tradelog.model.Trade;
import com.dmitrybondarev.tradelog.model.TradeLog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSW {

    public void readFromFile(String path, TradeLog tradeLog) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path));) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        TradeLog tradeLog = new TradeLog();
//        String path = "TRD.csv";
//        new ReadCSW().readFromFile(path, tradeLog);
//
//        System.out.println(tradeLog.getExchangesSet().size());
//
//        Set<String> exchangesSet = tradeLog.getExchangesSet();
//        int sum = 0;
//        for (String ex : exchangesSet) {
//            List<Trade> exchangeTradeLog = tradeLog.getExchangeTradeLog(ex);
//            sum += exchangeTradeLog.size();
//            System.out.println(ex + " = " + exchangeTradeLog.size());
//
//        }
//        System.out.println("sum = " + sum);
//        List<Trade> exchangeTradeLog = tradeLog.getExchangeTradeLog("D");
//        System.out.println(exchangeTradeLog.get(10).toString());
//    }

}
