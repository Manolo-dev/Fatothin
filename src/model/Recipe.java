package model;

import java.util.ArrayList;
import java.util.Arrays;

import utils.Pair;

public class Recipe {
    private String name;
    private ArrayList<Pair<Aliment, Integer>> ingredients = new ArrayList<>();
    private Instructions instructions = new Instructions();
    private int time = 0;

    public Recipe(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");

        this.name = name;
    }

    public void add(Aliment ingredient) {
        if(ingredient == null) throw new IllegalArgumentException("Ingredient cannot be null");

        ingredients.add(new Pair<Aliment, Integer>(ingredient, 1));
    }

    public void add(Aliment ingredient, int quantity) {
        if(ingredient == null) throw new IllegalArgumentException("Ingredient cannot be null");
        if(quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");

        ingredients.add(new Pair<Aliment, Integer>(ingredient, quantity));
    }

    public void add(String step, int time) {
        if(step == null || step.isEmpty()) throw new IllegalArgumentException("Step cannot be null or empty");

        instructions.add(step, time);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Pair<Aliment, Integer>> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getInstructions() {
        return instructions.getSteps();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
            .append(name)
            .append(" (")
            .append(time)
            .append("mn)\n");
        for(Pair<Aliment, Integer> ingredient : ingredients) {
            sb
                .append(ingredient.getSecond())
                .append(" ")
                .append(ingredient.getFirst().getName())
                .append("\n");
        }
        sb.append(instructions.toString());
        return sb.toString();
    }

    private class Instructions {
        private ArrayList<Pair<String, Integer>> steps;

        public Instructions() {
            steps = new ArrayList<>();
        }

        public ArrayList<String> getSteps() {
            ArrayList<String> steps = new ArrayList<>();
            for(Pair<String, Integer> step : this.steps) {
                steps.add(step.getFirst());
            }
            return steps;
        }

        public void add(String step, int time) {
            if(step == null || step.isEmpty()) throw new IllegalArgumentException("Step cannot be null or empty");

            steps.add(new Pair<String, Integer>(step, time));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(Pair<String, Integer> step : steps) {
                sb
                    .append(step.getFirst())
                    .append(" (")
                    .append(step.getSecond())
                    .append(")\n");
            }
            return sb.toString();
        }
    }
}
