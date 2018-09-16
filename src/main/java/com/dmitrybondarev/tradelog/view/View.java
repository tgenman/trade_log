package com.dmitrybondarev.tradelog.view;

import com.dmitrybondarev.tradelog.model.Interval;

import java.util.Map;

public interface View {

    public void print(Map<String, Interval> oneSecondWindowMap);

}
