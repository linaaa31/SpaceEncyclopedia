package spaceencyclopedia.gui;

import spaceencyclopedia.core.*;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchPage extends BasePage {

    private EncyclopediaManager manager;

    public SearchPage(EncyclopediaManager manager) {
        super("Search");

        this.manager = manager;

        BackgroundPanel backgroundPanel =
                new BackgroundPanel("/spaceencyclopedia/images/img_1.png");
        backgroundPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(60, 100, 60, 100));

        JLabel title = createLabel("SEARCH", 48, Font.BOLD);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("Serif", Font.PLAIN, 26));
        searchField.setMaximumSize(new Dimension(600, 50));

        JButton searchButton = createButton("Search");
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel resultLabel = createLabel("", 26, Font.BOLD);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton openButton = createButton("Open");
        openButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        openButton.setVisible(false);

        JButton backButton = createButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        final SpaceObject[] foundObject = new SpaceObject[1];

        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String name = searchField.getText().trim();

                SpaceObject object = manager.searchByName(name);
                foundObject[0] = object;
                if (object == null) {
                    resultLabel.setText("Object not found.");
                    openButton.setVisible(false);
                } else {
                    resultLabel.setText("Found: " + object.getName() + " (" + object.getType() + ")");
                    openButton.setVisible(true);
                }
            }
        });

        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                openDetailsPage(foundObject[0]);
            }
        });

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new MainMenuPage(manager).setVisible(true);
                dispose();
            }
        });

        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(searchField);
        contentPanel.add(Box.createVerticalStrut(25));
        contentPanel.add(searchButton);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(resultLabel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(openButton);
        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(backButton);

        backgroundPanel.add(contentPanel, BorderLayout.CENTER);
        setContentPane(backgroundPanel);
    }

    private void openDetailsPage(SpaceObject object) {
        if (object instanceof Planet) {
            new PlanetDetailsPage((Planet) object, manager).setVisible(true);
        } else if (object instanceof Satellite) {
            new SatelliteDetailsPage((Satellite) object, manager).setVisible(true);
        } else if (object instanceof Star) {
            new StarDetailsPage((Star) object, manager).setVisible(true);
        } else if (object instanceof Nebula) {
            new NebulaDetailsPage((Nebula) object, manager).setVisible(true);
        } else if (object instanceof Asteroid) {
            new AsteroidsPage(manager).setVisible(true);
        }
        dispose();
    }
}