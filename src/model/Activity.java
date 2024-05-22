package model;

public class Activity {
    private String name;
    private int calories;

    public Activity(String name, int calories) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");

        this.name = name;
        this.calories = calories;
    }

    public void ammend(int calories) {
        if(calories < 0) throw new IllegalArgumentException("Calories cannot be negative");

        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
            .append(name)
            .append(" : ")
            .append(calories)
            .append(" calories");
        return sb.toString();
    }
}
