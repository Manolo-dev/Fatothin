package model;

import java.util.ArrayList;
import java.util.Arrays;

import model.Aliment;

public class Recipe {
    private class Instructions {
        private ArrayList<String> steps;

        public Instructions(String steps) {
            if(steps == null || steps.isEmpty()) throw new IllegalArgumentException("Steps cannot be null or empty");

            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(steps.split("\n")));
            temp.removeIf(s -> s == null || s.isEmpty());
            
        }

        public ArrayList<String> getSteps() {
            return steps;
        }

        public String toString() {
            return String.join("\n", steps);
        }
    }

    private String name;
    private ArrayList<Aliment> ingredients;
    private Instructions instructions;

    public Recipe(String name, ArrayList<Aliment> ingredients, String steps) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if(ingredients == null) throw new IllegalArgumentException("Ingredients cannot be null");
        if(ingredients.isEmpty()) throw new IllegalArgumentException("Ingredients cannot be empty");

        this.name = name;
        this.ingredients = ingredients;
        this.instructions = new Instructions(steps);
    }

    public void add(Aliment ingredient) {
        if(ingredient == null) throw new IllegalArgumentException("Ingredient cannot be null");

        ingredients.add(ingredient);
    }

    public void remove(Aliment ingredient) {
        if(ingredient == null) throw new IllegalArgumentException("Ingredient cannot be null");

        ingredients.remove(ingredient);
    }
}
