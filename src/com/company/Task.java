package com.company;

public class Task {
    int number;
    int duration;
    int startTime;
    int maxDelay;

    public void showInfo()
    {
        System.out.println("Nr: " + getNumber() + " Pj: " + getDuration() + " Rj: " + getStartTime() + " dj: " + getMaxDelay());
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getMaxDelay() {
        return maxDelay;
    }

    public void setMaxDelay(int maxDelay) {
        this.maxDelay = maxDelay;
    }
}
