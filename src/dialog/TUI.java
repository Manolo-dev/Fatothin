package dialog;

import java.util.ArrayList;

import utils.Day;
import model.Aliment;
import model.Recipe;
import model.Meal;
import model.Plan;

public class TUI {
    private static ArrayList<Aliment> aliments = new ArrayList<Aliment>();
    private static ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    private static ArrayList<Meal> meals = new ArrayList<Meal>();
    private static ArrayList<Plan> plans = new ArrayList<Plan>();

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Afficher les aliments");
        System.out.println("2. Afficher les recettes");
        System.out.println("3. Afficher les repas");
        System.out.println("4. Afficher les plans");
        System.out.println("5. Quitter");

        int choice = 0;
        while(choice < 1 || choice > 5) {
            System.out.print("Votre choix: ");
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch(NumberFormatException e) {
                choice = 0;
            }
        }

        switch(choice) {
            case 1:
                displayAliments();
                break;
            case 2:
                System.out.println("Afficher les recettes");
                break;
            case 3:
                System.out.println("Afficher les repas");
                break;
            case 4:
                System.out.println("Afficher les plans");
                break;
            case 5:
                return;
        }

        displayMenu();
    }

    public static void displayAliments() {
        for(Aliment aliment : aliments) {
            System.out.println(aliment.toString());
        }
        
        System.out.println("1. Ajouter un aliment");
        System.out.println("2. Supprimer un aliment");
        System.out.println("3. Retour");

        int choice = 0;
        while(choice < 1 || choice > 3) {
            System.out.print("Votre choix: ");
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch(NumberFormatException e) {
                choice = 0;
            }
        }

        switch(choice) {
            case 1:
                newAliment();
                break;
            case 2:
                removeAliment();
                break;
            case 3:
                return;
        }

        displayAliments();
    }

    public static void newAliment() {
        try {

            System.out.print("Nom: ");
            String name = System.console().readLine();

            for(Aliment aliment : aliments) {
                if(aliment.getName().equals(name)) {
                    System.out.println("Cet aliment existe déjà");
                    return;
                }
            }

            System.out.print("Calories: ");
            int calories = Integer.parseInt(System.console().readLine());
            System.out.print("Protéines: ");
            float proteins = Float.parseFloat(System.console().readLine());
            System.out.print("Glucides: ");
            float carbohydrates = Float.parseFloat(System.console().readLine());
            System.out.print("Lipides: ");
            float lipids = Float.parseFloat(System.console().readLine());

            aliments.add(new Aliment(name, calories, proteins, carbohydrates, lipids));
        } catch(Exception e) {
            System.out.println("Erreur lors de la création de l'aliment");
        }
    }

    public static void removeAliment() {
        try {
            System.out.print("Nom: ");
            String name = System.console().readLine();

            for(Aliment aliment : aliments) {
                if(aliment.getName().equals(name)) {
                    aliments.remove(aliment);
                    return;
                }
            }
            System.out.println("Cet aliment n'existe pas");
        } catch(Exception e) {
            System.out.println("Erreur lors de la suppression de l'aliment");
        }
    }
}
