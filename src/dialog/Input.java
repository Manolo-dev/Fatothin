package dialog;

import java.util.ArrayList;
import java.util.Map;

import utils.Pair;
import utils.MenuAction;
import utils.Day;

public class Input {
    private ArrayList<Pair<String, MenuAction>> actions;

    public Input() {
        actions = new ArrayList<>();
    }

    public void displayMenu() {
        for(int i = 0; i < actions.size(); i++) {
            String name = actions.get(i).getFirst();
            System.out.println(String.format("%d. %s", i+1, name));
        }
    }

    public void put(String name, MenuAction action) {
        actions.add(new Pair<>(name, action));
    }

    public boolean execute() {
        int choice = 0;
        while(choice < 1 || choice > actions.size()) {
            System.out.print("Votre choix: ");
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch(NumberFormatException e) {
                choice = 0;
            }
        }

        return actions.get(choice - 1).getSecond().execute();
    }

    public static int inputInt() {
        Integer value = null;

        while(value == null) {
            try {
                String input = System.console().readLine();
                if(input.isEmpty()) return 0;
                value = Integer.parseInt(input);
            } catch(NumberFormatException e) {}
        }

        return value;
    }

    public static float inputFloat() {
        Float value = null;

        while(value == null) {
            try {
                String input = System.console().readLine();
                if(input.isEmpty()) return 0;
                value = Float.parseFloat(input);
            } catch(NumberFormatException e) {}
        }

        return value;
    }

    public static String inputString() {
        String value = null;

        while(value == null) {
            value = System.console().readLine();
        }

        return value;
    }

    public static Day inputDay() {
        Day value = null;

        while(value == null) {
            try {
                String input = System.console().readLine();
                value = Day.valueOf(input);
            } catch(IllegalArgumentException e) {}
        }

        return value;
    }
}
