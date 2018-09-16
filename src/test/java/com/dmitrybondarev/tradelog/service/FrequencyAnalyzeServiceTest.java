package com.dmitrybondarev.tradelog.service;

import com.dmitrybondarev.tradelog.model.Interval;
import com.dmitrybondarev.tradelog.model.Trade;
import com.dmitrybondarev.tradelog.model.TradeLog;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class FrequencyAnalyzeServiceTest {

    @Test
    public void  testReadFromFile() {
        TradeLog tradeLog = new TradeLog();
        tradeLog.addTrade(new Trade("10:00:00.015", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:00.435", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:00.985", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:01.155", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:01.175", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:01.345", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:02.015", 1, 1, "U"));
        tradeLog.addTrade(new Trade("10:00:02.455", 1, 1, "U"));

//      Expected results
        String startInterval = "10:00:00.435";
        String endInterval = "10:00:01.434";
        int numberOfTrade = 5;

//      Test class
        FrequencyAnalyzeService frequencyAnalyzeService = new FrequencyAnalyzeService();

//      run
        Map<String, Interval> inputMap = frequencyAnalyzeService.findOneSecondWindowOfHighestFrequency(tradeLog);

//      actual results
        Interval interval = inputMap.get("U");
        String actualStartInterval = interval.getStartInterval();
        String actualEndInterval = interval.getEndInterval();
        int actualNumberOfTrade = interval.getNumberOfTrade();

//      assert
        Assert.assertEquals(startInterval, actualStartInterval);
        Assert.assertEquals(endInterval, actualEndInterval);
        Assert.assertEquals(numberOfTrade, actualNumberOfTrade);
    }

}