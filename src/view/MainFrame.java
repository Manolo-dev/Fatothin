package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private HomePanel homePanel;
    private ListPanel<String> ListPanel;

    public MainFrame() {
        setTitle("Meal Planner");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        homePanel = new HomePanel(cardLayout, cardPanel);
        ListPanel = new ListPanel<String>(createMeals());

        cardPanel.add(homePanel, "HomePanel");
        cardPanel.add(ListPanel, "ListPanel");

        add(cardPanel);

        cardLayout.show(cardPanel, "HomePanel");
    }

    private ArrayList<String> createMeals() {
        ArrayList<String> meals = new java.util.ArrayList<>();
        meals.add("Breakfast");
        meals.add("Lunch");
        meals.add("Dinner");
        for (int i = 0; i < 10; i++) {
            meals.add("Meal " + i);
        }
        return meals;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}

class Page1 extends JPanel {
    private JButton addButton;

    public Page1() {
        setLayout(new BorderLayout());

        addButton = new JButton("Add");
        add(addButton, BorderLayout.CENTER);
    }

    public void setAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
