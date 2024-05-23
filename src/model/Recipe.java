package model;

import java.util.ArrayList;
import java.util.Arrays;

import utils.Pair;

public class Recipe {
    private String name;
    private ArrayList<Pair<Aliment, Integer>> ingredients;
    private Instructions instructions;

    public Recipe(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");

        this.name = name;
        this.instructions = new Instructions();
    }

    public void addAliment(Aliment ingredient) {
        if(ingredient == null) throw new IllegalArgumentException("Ingredient cannot be null");

        ingredients.add(new Pair<Aliment, Integer>(ingredient, 1));
    }

    public void addAliment(Aliment ingredient, int quantity) {
        if(ingredient == null) throw new IllegalArgumentException("Ingredient cannot be null");
        if(quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");

        ingredients.add(new Pair<Aliment, Integer>(ingredient, quantity));
    }

    public void addInstruction(String step) {
        if(step == null || step.isEmpty()) throw new IllegalArgumentException("Step cannot be null or empty");

        instructions.add(step);
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
            .append("\n");
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
        private ArrayList<String> steps;

        public Instructions() {
            steps = new ArrayList<>();
        }

        public Instructions(String steps) {
            if(steps == null || steps.isEmpty()) throw new IllegalArgumentException("Steps cannot be null or empty");

            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(steps.split("\n")));
            temp.removeIf(s -> s == null || s.isEmpty());
        }

        public ArrayList<String> getSteps() {
            return steps;
        }

        public void add(String step) {
            if(step == null || step.isEmpty()) throw new IllegalArgumentException("Step cannot be null or empty");

            steps.add(step);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < steps.size(); i++) {
                sb
                    .append(i + 1)
                    .append(". ")
                    .append(steps.get(i))
                    .append("\n");
            }
            return sb.toString();
        }
    }
}
