package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import utils.Day;

public class Plan {
    private String name;
    private ArrayList<Activity> activities = new ArrayList<>();
    private HashMap<Day, boolean[]> freeSlots = new HashMap<>();

    public Plan(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");

        this.name = name;

        for(Day day : Day.values()) {
            freeSlots.put(day, new boolean[48]);
        }
    }

    private boolean isFree(Activity activity) {
        for(int i = activity.getStart(); i < activity.getStart() + activity.getDuration(); i++) {
            if(freeSlots.get(activity.getDay())[i]) return false;
        }
        return true;
    }

    public void add(Activity activity) {
        if(activity == null) throw new IllegalArgumentException("Activity cannot be null");
        if(activities.contains(activity)) throw new IllegalArgumentException("Activity already exists");

        if(!isFree(activity)) throw new IllegalArgumentException("Activity overlaps with another activity");

        activities.add(activity);
        
        for(int i = activity.getStart(); i < activity.getStart() + activity.getDuration(); i++) {
            freeSlots.get(activity.getDay())[i] = true;
        }
    }

    public void remove(Activity activity) {
        if(activity == null) throw new IllegalArgumentException("Activity cannot be null");
        if(!activities.contains(activity)) throw new IllegalArgumentException("Activity does not exist");

        activities.remove(activity);

        for(int i = activity.getStart(); i < activity.getStart() + activity.getDuration(); i++) {
            freeSlots.get(activity.getDay())[i] = false;
        }
    }

    public void remove(Day day, int start) {
        Activity activity = null;
        for(Activity a : activities) {
            if(a.getDay() == day && a.getStart() == start) {
                activity = a;
                break;
            }
        }

        if(activity == null) throw new IllegalArgumentException("Activity does not exist");

        activities.remove(activity);

        for(int i = activity.getStart(); i < activity.getStart() + activity.getDuration(); i++) {
            freeSlots.get(activity.getDay())[i] = false;
        }
    }

    public void remove(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");

        Activity activity = null;
        for(Activity a : activities) {
            if(a.getName().equals(name)) {
                activity = a;
                break;
            }
        }

        if(activity == null) throw new IllegalArgumentException("Activity does not exist");

        activities.remove(activity);
    }

    public String getName() {
        return name;
    }

    public Activity getActivitie(Day day, int start) {
        for(Activity activity : activities) {
            if(activity.getDay() == day && activity.getStart() == start) {
                return activity;
            }
        }
        return null;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public ArrayList<Activity> getActivities(Day day) {
        ArrayList<Activity> dayActivities = new ArrayList<>();
        for(Activity activity : activities) {
            if(activity.getDay() == day) {
                dayActivities.add(activity);
            }
        }
        return dayActivities;
    }

    public int getCalories() {
        int calories = 0;
        for(Activity activity : activities) {
            calories += activity.getCalories();
        }
        return calories;
    }

    public int getCalories(Day day) {
        int calories = 0;
        for(Activity activity : activities) {
            if(activity.getDay() == day) {
                calories += activity.getCalories();
            }
        }
        return calories;
    }

    public boolean[] getFreeSlots(Day day) {
        return freeSlots.get(day);
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
                sb
                    .append("\t")
                    .append(activity.toString())
                    .append("\n");
            }
        }

        return sb.toString();
    }
}
