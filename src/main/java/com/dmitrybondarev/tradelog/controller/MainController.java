package com.dmitrybondarev.tradelog.controller;

import com.dmitrybondarev.tradelog.model.Interval;
import com.dmitrybondarev.tradelog.model.TradeLog;
import com.dmitrybondarev.tradelog.service.FrequencyAnalyzeService;
import com.dmitrybondarev.tradelog.service.ReadCSV;
import com.dmitrybondarev.tradelog.view.ConsoleView;
import com.dmitrybondarev.tradelog.view.View;

import java.util.Map;

public class MainController {

    private static final String PATH_TO_LOG = "TRD.csv";

    public void findOneSecondsWindows(TradeLog tradeLog,
                                       ReadCSV readCSW,
                                       FrequencyAnalyzeService frequencyAnalyzeService,
                                       View view) {

        readCSW.readFromFile(PATH_TO_LOG, tradeLog);

        Map<String, Interval> oneSecondWindowMap =
                frequencyAnalyzeService
                        .findOneSecondWindowOfHighestFrequency(tradeLog);

        view.print(oneSecondWindowMap);
    }

    public static void main(String[] args) {
        TradeLog tradeLog = new TradeLog();
        ReadCSV readCSW = new ReadCSV();
        FrequencyAnalyzeService frequencyAnalyzeService = new FrequencyAnalyzeService();
        View view = new ConsoleView();

        MainController mainController = new MainController();

        mainController.findOneSecondsWindows(tradeLog, readCSW, frequencyAnalyzeService, view);
    }
}
