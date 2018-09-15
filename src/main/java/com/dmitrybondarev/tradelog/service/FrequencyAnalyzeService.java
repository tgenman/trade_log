package com.dmitrybondarev.tradelog.service;

import com.dmitrybondarev.tradelog.model.Interval;
import com.dmitrybondarev.tradelog.model.Trade;
import com.dmitrybondarev.tradelog.model.TradeLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequencyAnalyzeService {

    public Map<String, Interval> findOneSecondWindowOfHighestFrequency(TradeLog tradeLog) {
        Map<String, Interval> result = new HashMap<>();
        TimeConverter timeConverter = new TimeConverter();

        Set<String> exchangeSet = tradeLog.getExchangesSet();

        for (String exchange : exchangeSet) {
            List<Trade> exchangeTradeLog = tradeLog.getExchangeTradeLog(exchange);
            int size = exchangeTradeLog.size();

            int[] timeStamps = getArrayOfTimeStamps(exchangeTradeLog, timeConverter);

            int startInterval = 0;
            int numberOfTrades = 0;

            for (int i = 0; i < size; i++) {
                int currentStartInterval = timeStamps[i];
                int currentEndInterval = currentStartInterval + 999;
                int currentNumberOfTrades = 1;
                for (int j = i + 1; j < size; j++) {
                    if (timeStamps[j] <= currentEndInterval) {
                        currentNumberOfTrades++;
                    } else {
                        if (currentNumberOfTrades > numberOfTrades) {
                            startInterval = currentStartInterval;
                            numberOfTrades = currentNumberOfTrades;
                        }
                        break;
                    }
                }
            }
            String startIntervalStr = timeConverter.fromIntToString(startInterval);
            String endIntervalStr = timeConverter.fromIntToString(startInterval + 999);

            result.put(exchange, new Interval(startIntervalStr, endIntervalStr, numberOfTrades));
        }
        return result;
    }

    private int[] getArrayOfTimeStamps(List<Trade> exchangeTradeLog, TimeConverter timeConverter) {
        int[] timeStamps = new int[exchangeTradeLog.size()];
        int pointerTimeStamps = 0;

        for (Trade trade : exchangeTradeLog) {
            timeStamps[pointerTimeStamps++]
                    = timeConverter.fromStringToInt(trade.getTime());
        }
        return timeStamps;
    }

    public static void main(String[] args) {
        TradeLog tradeLog = new TradeLog();
        tradeLog.addTrade(new Trade("10:00:00.015", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:00.435", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:00.985", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:01.155", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:01.175", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:01.345", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:02.015", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:02.455", 1, 1, "U"));

        FrequencyAnalyzeService frequencyAnalyzeService = new FrequencyAnalyzeService();

        Map<String, Interval> inputMap = frequencyAnalyzeService.findOneSecondWindowOfHighestFrequency(tradeLog);

        Interval interval = inputMap.get("U");
        System.out.println("start = " + interval.getStartInterval()
                + " end = " + interval.getEndInterval()
                + " number = " + interval.getNumberOfTrade()
        );

    }
}
