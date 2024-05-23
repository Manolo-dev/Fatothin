package model;

import java.util.ArrayList;

public class Datas {
    private ArrayList<Aliment> aliments = new ArrayList<Aliment>();
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    private ArrayList<Meal> meals = new ArrayList<Meal>();
    private ArrayList<Plan> plans = new ArrayList<Plan>();

    public ArrayList<Aliment> getAliments() {
        return aliments;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public void add(Aliment aliment) {
        if(aliment == null) throw new IllegalArgumentException("Aliment cannot be null");
        if(aliments.contains(aliment)) throw new IllegalArgumentException("Aliment already exists");

        aliments.add(aliment);
    }

    public void add(Recipe recipe) {
        if(recipe == null) throw new IllegalArgumentException("Recipe cannot be null");
        if(recipes.contains(recipe)) throw new IllegalArgumentException("Recipe already exists");

        recipes.add(recipe);
    }

    public void add(Meal meal) {
        if(meal == null) throw new IllegalArgumentException("Meal cannot be null");
        if(meals.contains(meal)) throw new IllegalArgumentException("Meal already exists");

        meals.add(meal);
    }

    public void add(Plan plan) {
        if(plan == null) throw new IllegalArgumentException("Plan cannot be null");
        if(plans.contains(plan)) throw new IllegalArgumentException("Plan already exists");

        plans.add(plan);
    }

    public void remove(Aliment aliment) {
        if(aliment == null) throw new IllegalArgumentException("Aliment cannot be null");
        if(!aliments.contains(aliment)) throw new IllegalArgumentException("Aliment does not exist");

        aliments.remove(aliment);
    }

    public void remove(Recipe recipe) {
        if(recipe == null) throw new IllegalArgumentException("Recipe cannot be null");
        if(!recipes.contains(recipe)) throw new IllegalArgumentException("Recipe does not exist");

        recipes.remove(recipe);
    }

    public void remove(Meal meal) {
        if(meal == null) throw new IllegalArgumentException("Meal cannot be null");
        if(!meals.contains(meal)) throw new IllegalArgumentException("Meal does not exist");

        meals.remove(meal);
    }

    public void remove(Plan plan) {
        if(plan == null) throw new IllegalArgumentException("Plan cannot be null");
        if(!plans.contains(plan)) throw new IllegalArgumentException("Plan does not exist");

        plans.remove(plan);
    }

    public boolean containsAliment(String name) {
        for(Aliment aliment : aliments) {
            if(aliment.getName().equals(name)) return true;
        }
        return false;
    }

    public boolean containsRecipe(String name) {
        for(Recipe recipe : recipes) {
            if(recipe.getName().equals(name)) return true;
        }
        return false;
    }

    public boolean containsMeal(String name) {
        for(Meal meal : meals) {
            if(meal.getName().equals(name)) return true;
        }
        return false;
    }

    public boolean containsPlan(String name) {
        for(Plan plan : plans) {
            if(plan.getName().equals(name)) return true;
        }
        return false;
    }

    public Aliment getAliment(String name) {
        for(Aliment aliment : aliments) {
            if(aliment.getName().equals(name)) return aliment;
        }
        return null;
    }

    public Recipe getRecipe(String name) {
        for(Recipe recipe : recipes) {
            if(recipe.getName().equals(name)) return recipe;
        }
        return null;
    }

    public Meal getMeal(String name) {
        for(Meal meal : meals) {
            if(meal.getName().equals(name)) return meal;
        }
        return null;
    }

    public Plan getPlan(String name) {
        for(Plan plan : plans) {
            if(plan.getName().equals(name)) return plan;
        }
        return null;
    }

    public void clear() {
        aliments.clear();
        recipes.clear();
        meals.clear();
        plans.clear();
    }
}
