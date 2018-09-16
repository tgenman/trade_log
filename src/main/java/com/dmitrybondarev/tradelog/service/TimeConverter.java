package com.dmitrybondarev.tradelog.service;

/**
 * Class to convert time from int to String and String to int.
 */
public class TimeConverter {

    private static final int MINUTES_PER_HOUR = 60;

    private static final int SECONDS_PER_MINUTE = 60;

    private static final int MILLISECONDS_PER_SECONDS = 1000;

    public int fromStringToInt(String timeString) {
        String[] split = timeString.split("[:.]");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        int seconds = Integer.parseInt(split[2]);
        int mSeconds = Integer.parseInt(split[3]);
        int result = hours * MINUTES_PER_HOUR * SECONDS_PER_MINUTE * MILLISECONDS_PER_SECONDS
                + minutes * SECONDS_PER_MINUTE * MILLISECONDS_PER_SECONDS
                + seconds * MILLISECONDS_PER_SECONDS
                + mSeconds;
        return result;
    }

    public String fromIntToString(int timeInt) {
        int remainder = timeInt;

        int hours = remainder / (MINUTES_PER_HOUR * SECONDS_PER_MINUTE * MILLISECONDS_PER_SECONDS);
        remainder = remainder - (hours * MINUTES_PER_HOUR * SECONDS_PER_MINUTE * MILLISECONDS_PER_SECONDS);

        int minutes = remainder / (SECONDS_PER_MINUTE * MILLISECONDS_PER_SECONDS);
        remainder = remainder - (minutes * SECONDS_PER_MINUTE * MILLISECONDS_PER_SECONDS);

        int seconds = remainder / (MILLISECONDS_PER_SECONDS);
        remainder = remainder - (seconds * MILLISECONDS_PER_SECONDS);

        int mSeconds = remainder;

        String result = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, mSeconds);
        return result;
    }
}
