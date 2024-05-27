package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import model.Datas;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private HomePanel homePanel;
    private ListPanel<String> ListPanel;
    private Datas datas;

    public MainFrame(Datas dt) {
        this.datas = dt;

        setTitle("Fatothin");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        homePanel = new HomePanel(cardLayout, cardPanel);
        ListPanel = new ListPanel<String>(createMeals(), cardLayout, cardPanel);

        cardPanel.add(homePanel, "HomePanel");
        cardPanel.add(ListPanel, "ListPanel");

        add(cardPanel);

        cardLayout.show(cardPanel, "HomePanel");
    }

    private ArrayList<String> createMeals() {
        ArrayList<String> meals = new ArrayList<>();
        meals.add("Breakfast");
        meals.add("Lunch");
        meals.add("Dinner");
        for (int i = 0; i < 10; i++) {
            meals.add("Meal " + i);
        }
        return meals;
    }
}