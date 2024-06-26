package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListPanel<T> extends JPanel {
    private ArrayList<JButton> buttons;
    private JPanel buttonPanel;
    private ArrayList<T> objects;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public ListPanel(ArrayList<T> objs, CardLayout cl, JPanel cp) {
        this.objects = objs;
        this.cardLayout = cl;
        this.cardPanel = cp;

        setLayout(new BorderLayout());

        buttons = new ArrayList<>();
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel topButtonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your logic here
            }
        });
        topButtonPanel.add(addButton, gbc);

        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "HomePanel");
            }
        });
        topButtonPanel.add(backButton, gbc);

        add(topButtonPanel, BorderLayout.NORTH);
        JPanel scrollPanePanel = new JPanel(new BorderLayout());
        scrollPanePanel.add(scrollPane, BorderLayout.CENTER);
        scrollPanePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(scrollPanePanel, BorderLayout.CENTER);

        for (T obj : objects) {
            addButtonForObject(obj);
        }
    }

    public void addButtonForObject(T obj) {
        JButton button = new JButton(obj.toString());

        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(obj);
            }
        });

        buttons.add(button);
        buttonPanel.add(button);
        buttonPanel.add(Box.createVerticalStrut(10));

        revalidate();
        repaint();
    }

    private void handleButtonClick(T obj) {
        System.out.println("Button clicked for: " + obj.toString());
    }
}
