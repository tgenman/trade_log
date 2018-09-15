package com.dmitrybondarev.tradelog.service;

public class TimeConverter {

    public int fromStringToInt(String timeString) {
        String[] split = timeString.split("[:.]");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        int seconds = Integer.parseInt(split[2]);
        int mSeconds = Integer.parseInt(split[3]);
        int result = hours * 60 * 60 * 1000
                + minutes * 60 * 1000
                + seconds * 1000
                + mSeconds;
        return result;
    }

    public String fromIntToString(int timeInt) {
        int remainder = timeInt;

        int hours = remainder / (60 * 60 * 1000);
        remainder = remainder - (hours * 60 * 60 * 1000);

        int minutes = remainder / (60 * 1000);
        remainder = remainder - (minutes * 60 * 1000);

        int seconds = remainder / (1000);
        remainder = remainder - (seconds * 1000);

        int mSeconds = remainder;

        String result = String.format("%02d:%02d:%02d.%d", hours, minutes, seconds, mSeconds);
        return result;
    }

    public static void main(String[] args) {
        String sample = "10:00:02.883";
        TimeConverter timeConverter = new TimeConverter();
        System.out.println(timeConverter.fromStringToInt(sample));
        System.out.println(timeConverter.fromIntToString(36002883));

    }
}
