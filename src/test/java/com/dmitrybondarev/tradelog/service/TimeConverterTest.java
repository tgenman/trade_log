package com.dmitrybondarev.tradelog.service;

import org.junit.Assert;
import org.junit.Test;

public class TimeConverterTest {

    @Test
    public void  testFromStringToInt() {
//      Input values
        String timeString = "10:00:02.883";

//      Expected results
        int expectedResult = 36002883;

//      Test class
        TimeConverter timeConverter = new TimeConverter();

//      run
        int actualResult = timeConverter.fromStringToInt(timeString);

//      assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void  testFromIntToString() {
//      Input values
        int timeInt = 36002883;

//      Expected results
        String expectedResult = "10:00:02.883";

//      Test class
        TimeConverter timeConverter = new TimeConverter();

//      run
        String actualResult = timeConverter.fromIntToString(timeInt);

//      assert
        Assert.assertEquals(expectedResult, actualResult);
    }

}