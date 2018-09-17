package com.dmitrybondarev.tradelog.controller;

import com.dmitrybondarev.tradelog.model.Interval;
import com.dmitrybondarev.tradelog.model.TradeLog;
import com.dmitrybondarev.tradelog.service.FrequencyAnalysisService;
import com.dmitrybondarev.tradelog.service.ReadCSV;
import com.dmitrybondarev.tradelog.view.ConsoleView;
import com.dmitrybondarev.tradelog.view.View;

import java.util.Map;

public class MainController {

    private static final String PATH_TO_LOG = "TRD.csv";

    public void findOneSecondsWindows(TradeLog tradeLog,
                                       ReadCSV readCSW,
                                       FrequencyAnalysisService frequencyAnalysisService,
                                       View view) {

        readCSW.readFromFile(PATH_TO_LOG, tradeLog);

        Map<String, Interval> oneSecondWindowMap =
                frequencyAnalysisService
                        .findOneSecondWindowsOfAllExchanges(tradeLog);

        view.print(oneSecondWindowMap);
    }

    /**
     * Point to start program.
     * @param args .
     */
    public static void main(String[] args) {
        TradeLog tradeLog = new TradeLog();
        ReadCSV readCSW = new ReadCSV();
        FrequencyAnalysisService frequencyAnalysisService = new FrequencyAnalysisService();
        View view = new ConsoleView();

        MainController mainController = new MainController();

        mainController.findOneSecondsWindows(tradeLog, readCSW, frequencyAnalysisService, view);
    }
}
