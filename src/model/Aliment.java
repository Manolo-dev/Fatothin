package model;

public class Aliment {
    private String name;
    private int calories;
    private float proteins;
    private float carbohydrates;
    private float lipids;

    public Aliment(String name, int calories, float proteins, float carbohydrates, float lipids) {
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

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public float getProteins() {
        return proteins;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public float getLipids() {
        return lipids;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
            .append(name)
            .append(" : ")
            .append(calories)
            .append(" calories, ")
            .append(proteins)
            .append(" proteins, ")
            .append(carbohydrates)
            .append(" carbohydrates, ")
            .append(lipids)
            .append(" lipids");
        return sb.toString();
    }
}
