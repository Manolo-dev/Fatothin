package model;

import utils.Day;

public class Meal extends Activity {
    private Recipe recipe;

    public Meal(String name, int calories, int duration, int start, Day day, Recipe recipe) {
        super(name, calories, duration, start, day);
        if(recipe == null) throw new IllegalArgumentException("Recipe cannot be null");

        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
            .append(super.toString())
            .append(" : ")
            .append(recipe.getName());
        return sb.toString();
    }
}
