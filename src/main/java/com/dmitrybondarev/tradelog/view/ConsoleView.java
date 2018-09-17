package com.dmitrybondarev.tradelog.view;

import com.dmitrybondarev.tradelog.model.Interval;

import java.util.Map;
import java.util.Set;

public class ConsoleView implements View {

    public void print(Map<String, Interval> oneSecondWindowMap) {

        Set<String> exchanges = oneSecondWindowMap.keySet();

        for (String exchange : exchanges) {
            Interval oneSecondWindow = oneSecondWindowMap.get(exchange);
            String report =
                    String.format("Exchange is %s, time interval = [%s - %s], number of trades = %s",
                            exchange,
                            oneSecondWindow.getStartInterval(),
                            oneSecondWindow.getEndInterval(),
                            oneSecondWindow.getNumberOfTrade());
            System.out.println(report);
        }
    }
}
