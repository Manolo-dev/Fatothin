package model;

public class Aliment {
    private String name;
    private int calories;
    private int proteins;
    private int carbohydrates;
    private int lipids;

    public Aliment(String name, int calories, int proteins, int carbohydrates, int lipids) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if(calories < 0)                   throw new IllegalArgumentException("Calories cannot be negative");
        if(proteins < 0)                   throw new IllegalArgumentException("Proteins cannot be negative");
        if(carbohydrates < 0)              throw new IllegalArgumentException("Carbohydrates cannot be negative");
        if(lipids < 0)                     throw new IllegalArgumentException("Lipids cannot be negative");

        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.lipids = lipids;
    }

    public void ammend(int calories, int proteins, int carbohydrates, int lipids) {
        if(calories < 0)                   throw new IllegalArgumentException("Calories cannot be negative");
        if(proteins < 0)                   throw new IllegalArgumentException("Proteins cannot be negative");
        if(carbohydrates < 0)              throw new IllegalArgumentException("Carbohydrates cannot be negative");
        if(lipids < 0)                     throw new IllegalArgumentException("Lipids cannot be negative");
        
        this.calories = calories;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.lipids = lipids;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getProteins() {
        return proteins;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getLipids() {
        return lipids;
    }

    public String toString() {
        return name + " : " + calories + " calories, " + proteins + "g de protéines, " + carbohydrates + "g de carbohydrates, " + lipids + "g de lipids";
    }
}
