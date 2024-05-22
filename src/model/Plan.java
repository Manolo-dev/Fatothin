package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import utils.Day;

public class Plan {
    private String name;
    private ArrayList<Activity> activities;

    public Plan(String name, ArrayList<Activity> activities) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if(activities == null) throw new IllegalArgumentException("Activities cannot be null");
        if(activities.isEmpty()) throw new IllegalArgumentException("Activities cannot be empty");

        this.name = name;
        this.activities = activities;
    }

    public void add(Activity activity) {
        if(activity == null) throw new IllegalArgumentException("Activity cannot be null");

        activities.add(activity);
    }

    public void remove(Activity activity) {
        if(activity == null) throw new IllegalArgumentException("Activity cannot be null");

        activities.remove(activity);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public int getCalories() {
        int calories = 0;
        for(Activity activity : activities) {
            calories += activity.getCalories();
        }
        return calories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        for(Day day : Day.values()) {
            sb.append(day).append("\n");

            ArrayList<Activity> dayActivities = new ArrayList<>();
            for(Activity activity : activities) {
                if(activity.getDay() == day) {
                    dayActivities.add(activity);
                }
            }

            Collections.sort(dayActivities, new Comparator<Activity>() {
                @Override
                public int compare(Activity a1, Activity a2) {
                    return Integer.compare(a1.getStart(), a2.getStart());
                }
            });

            for(Activity activity : dayActivities) {
                sb.append(activity.toString()).append("\n");
            }
        }

        return sb.toString();
    }
}
