package com.ubs.opsit.interviews.parse;

/**
 * Holder for input time with information about hours, minute and seconds
 * @author Yurii Tarasov
 *
 */
public class InputTimeHolder {

    private int hour;

    private int minute;

    private int second;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

}
