package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    private JPanel buttonPanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public HomePanel(CardLayout cl, JPanel cp) {
        this.cardLayout = cl;
        this.cardPanel = cp;
        setLayout(new BorderLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 2));
        addButton("Aliment");
        addButton("Recipe");
        addButton("Meal");
        addButton("Plan");

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void addButton(String label) {
        JButton button = new JButton(label);

        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "ListPanel");
            }
        });

        buttonPanel.add(button);
    }
}
