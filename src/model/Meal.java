package model;

import utils.Day;

public class Meal extends Activity {
    private Recipe recipe;
    
    public Meal(String name, int duration, int start, Day day, Recipe recipe) {
        super(name, validAndGetCalories(recipe), duration, start, day);
        
        this.recipe = recipe;
    }

    private static int validAndGetCalories(Recipe recipe) {
        if(recipe == null) throw new IllegalArgumentException("Recipe cannot be null");
        return recipe.getCalories();
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
