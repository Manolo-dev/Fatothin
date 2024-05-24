package dialog;

import java.util.ArrayList;

import model.Datas;
import model.Aliment;
import model.Recipe;
import utils.Day;

public class TUI {
    private static Datas datas = new Datas();

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        Input input = new Input();

        input.put("Afficher les aliments", TUI::displayAliments);
        input.put("Afficher les recettes", TUI::displayRecipes);
        input.put("Afficher les repas",    TUI::displayMeals);
        input.put("Afficher les plans",    TUI::displayPlans);
        input.put("Quitter", () -> false);

        do {
            input.displayMenu();
        } while(input.execute());
    }

    private static boolean displayAliments() {
        Input input = new Input();
        input.put("Ajouter un aliment",   TUI::addAliment);
        input.put("Supprimer un aliment", TUI::removeAliment);
        input.put("Retour", () -> false);

        do {
            ArrayList<Aliment> aliments = datas.getAliments();
            for(Aliment aliment : aliments) {
                System.out.println(aliment);
            }

            input.displayMenu();
        } while(input.execute());

        return true;
    }

    private static boolean addAliment() {
        System.out.println("Ajout d'un aliment");
        System.out.print("Nom: ");
        String name = System.console().readLine();
        if(datas.containsAliment(name)) {
            System.out.println("Cet aliment existe déjà");
            return true;
        }
        System.out.print("Calories: ");
        int calories = Input.inputInt();
        System.out.print("Protéines: ");
        float proteins = Input.inputFloat();
        System.out.print("Glucides: ");
        float carbohydrates = Input.inputFloat();
        System.out.print("Lipides: ");
        float lipids = Input.inputFloat();

        datas.add(new Aliment(name, calories, proteins, carbohydrates, lipids));

        return true;
    }

    private static boolean removeAliment() {
        System.out.println("Suppression d'un aliment");
        System.out.print("Nom: ");
        String name = System.console().readLine();
        if(!datas.containsAliment(name)) {
            System.out.println("Cet aliment n'existe pas");
            return true;
        }

        Aliment aliment = datas.getAliment(name);
        datas.remove(aliment);

        return true;
    }

    private static boolean displayRecipes() {
        Input input = new Input();

        input.put("Ajouter une recette",   TUI::addRecipe);
        input.put("Supprimer une recette", TUI::removeRecipe);
        input.put("Retour", () -> false);

        do {
            ArrayList<Recipe> recipes = datas.getRecipes();
            for(Recipe recipe : recipes) {
                System.out.println(recipe);
            }

            input.displayMenu();
        } while(input.execute());

        return true;
    }

    private static boolean addRecipe() {
        System.out.println("Ajout d'une recette");
        System.out.print("Nom: ");
        String name = System.console().readLine();
        if(datas.containsRecipe(name)) {
            System.out.println("Cette recette existe déjà");
            return true;
        }

        Recipe recipe = new Recipe(name);

        while(true) {
            System.out.print("Ingrédient (vide pour terminer): ");
            String ingredient = System.console().readLine();
            if(ingredient.isEmpty()) break;
            if(!datas.containsAliment(ingredient)) {
                System.out.println("Cet aliment n'existe pas");
                continue;
            }
            System.out.print("Quantité: ");
            int quantity = Input.inputInt();
            recipe.add(datas.getAliment(ingredient), quantity);
        }

        while(true) {
            System.out.print("Etape (vide pour terminer): ");
            String step = System.console().readLine();
            if(step.isEmpty()) break;
            System.out.print("Temps: ");
            int time = Input.inputInt();
            recipe.add(step, time);
        }

        datas.add(recipe);

        return true;
    }

    private static boolean removeRecipe() {
        System.out.println("Suppression d'une recette");
        System.out.print("Nom: ");
        String name = System.console().readLine();
        if(!datas.containsRecipe(name)) {
            System.out.println("Cette recette n'existe pas");
            return true;
        }

        Recipe recipe = datas.getRecipe(name);
        datas.remove(recipe);

        return true;
    }

    private static boolean displayMeals() {
        Input input = new Input();

        input.put("Ajouter un repas",   TUI::addMeal);
        input.put("Supprimer un repas", TUI::removeMeal);
        input.put("Retour", () -> false);

        do {
            ArrayList<Recipe> recipes = datas.getRecipes();
            for(Recipe recipe : recipes) {
                System.out.println(recipe);
            }

            input.displayMenu();
        } while(input.execute());

        return true;
    }

    private static boolean addMeal() {
        System.out.println("Ajout d'un repas");
        System.out.print("Nom: ");
        String name = System.console().readLine();
        if(datas.containsMeal(name)) {
            System.out.println("Ce repas existe déjà");
            return true;
        }

        System.out.print("Durée: ");
        int duration = Input.inputInt();
        System.out.print("Heure de début: ");
        int start = Input.inputInt();
        System.out.print("Jour: ");
        Day day = Input.inputDay();

        return true;
    }

    private static boolean removeMeal() {
        System.out.println("Suppression d'un repas");
        System.out.print("Nom: ");
        String name = System.console().readLine();
        if(!datas.containsMeal(name)) {
            System.out.println("Ce repas n'existe pas");
            return true;
        }

        

        return true;
    }

    private static boolean displayPlans() {return true;}
}
