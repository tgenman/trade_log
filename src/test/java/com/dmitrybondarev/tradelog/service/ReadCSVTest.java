package com.dmitrybondarev.tradelog.service;

import com.dmitrybondarev.tradelog.model.Trade;
import com.dmitrybondarev.tradelog.model.TradeLog;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReadCSVTest {

    @Test
    public void  testReadFromFile() {
        TradeLog tradeLog = new TradeLog();

//      Input values
        String pathToTestCSV = "src/test/test.csv";

//      Expected results
        String timeOne = "10:00:00.013";
        int volumeOne = 100;
        String exchangeOne = "D";
        String timeTwo = "10:00:00.015";
        int volumeTwo = 300;
        String exchangeTwo = "D";

//      Test class
        ReadCSV readCSV = new ReadCSV();

//      run
        readCSV.readFromFile(pathToTestCSV, tradeLog);

//      actual results
        Set<String> exchangesSet = tradeLog.getExchangesSet();
        Iterator<String> iterator = exchangesSet.iterator();
        List<Trade> exchangeTradeLog = tradeLog.getExchangeTradeLog(iterator.next());

        String actualTimeOne = exchangeTradeLog.get(0).getTime();
        int actualVolumeOne = exchangeTradeLog.get(0).getVolume();
        String actualExchangeOne = exchangeTradeLog.get(0).getExchange();
        String actualTimeTwo = exchangeTradeLog.get(1).getTime();
        int actualVolumeTwo = exchangeTradeLog.get(1).getVolume();
        String actualExchangeTwo = exchangeTradeLog.get(1).getExchange();

//      assert
        Assert.assertEquals(timeOne, actualTimeOne);
        Assert.assertEquals(volumeOne, actualVolumeOne);
        Assert.assertEquals(exchangeOne, actualExchangeOne);

        Assert.assertEquals(timeTwo, actualTimeTwo);
        Assert.assertEquals(volumeTwo, actualVolumeTwo);
        Assert.assertEquals(exchangeTwo, actualExchangeTwo);
    }
}