package model;

import utils.Day;

public class Activity {
    private String name;
    private int calories;
    private int duration; // in half hours
    private int start; // in half hours
    private Day day;

    public Activity(String name, int calories, int duration, int start, Day day) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if(duration <= 0) throw new IllegalArgumentException("Duration cannot be negative or zero");
        if(duration > 48) throw new IllegalArgumentException("Duration cannot be greater than 24 hours");
        if(start < 0) throw new IllegalArgumentException("Start cannot be negative");
        if(start + duration > 48) throw new IllegalArgumentException("Activity cannot end after 24 hours");

        this.name = name;
        this.calories = calories;
        this.duration = duration;
        this.start = start;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getDuration() {
        return duration;
    }

    public int getStart() {
        return start;
    }

    public Day getDay() {
        return day;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
            .append(name)
            .append(" : ")
            .append(calories)
            .append(" calories for ")
            .append(duration)
            .append(" half hours")
            .append(" starting at ")
            .append(start)
            .append(" on ")
            .append(day.toString());
        return sb.toString();
    }
}
