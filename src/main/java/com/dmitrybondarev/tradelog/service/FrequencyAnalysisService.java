package com.dmitrybondarev.tradelog.service;

import com.dmitrybondarev.tradelog.model.Interval;
import com.dmitrybondarev.tradelog.model.Trade;
import com.dmitrybondarev.tradelog.model.TradeLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service to find one second window in exchange.
 */
public class FrequencyAnalysisService {

    /**
     * Find one second window in exchange.
     * Transform TradeLog to int[] of time stamps of trades.
     * Search in int[] a second with the highest density.
     * @param tradeLog data for analysis
     * @return Map of results intervals
     */
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

    /**
     * Transform List of Trades to int[] of time stamps of trades.
     * @param exchangeTradeLog
     * @param timeConverter
     * @return int[] of time stamps of trades
     */
    private int[] getArrayOfTimeStamps(List<Trade> exchangeTradeLog, TimeConverter timeConverter) {
        int[] timeStamps = new int[exchangeTradeLog.size()];
        int pointerTimeStamps = 0;

        for (Trade trade : exchangeTradeLog) {
            timeStamps[pointerTimeStamps++]
                    = timeConverter.fromStringToInt(trade.getTime());
        }
        return timeStamps;
    }
}
