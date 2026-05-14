package spaceencyclopedia.gui;

import spaceencyclopedia.core.*;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;

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

        DefaultListModel<String> hintModel = new DefaultListModel<>();
        JList<String> hintList = new JList<>(hintModel);
        hintList.setFont(new Font("Serif", Font.PLAIN, 22));
        hintList.setVisibleRowCount(5);

        JScrollPane hintScrollPane = new JScrollPane(hintList);
        hintScrollPane.setMaximumSize(new Dimension(600, 150));
        hintScrollPane.setVisible(false);

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

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateHints();
            }
            public void removeUpdate(DocumentEvent e) {
                updateHints();
            }
            public void changedUpdate(DocumentEvent e) {
                updateHints();
            }
            private void updateHints() {
                String text = searchField.getText().trim().toLowerCase();
                hintModel.clear();

                if (text.isEmpty()) {
                    hintScrollPane.setVisible(false);
                    contentPanel.revalidate();
                    contentPanel.repaint();
                    return;
                }

                for (SpaceObject object : manager.getObjects()) {
                    if (object.getName().toLowerCase().startsWith(text)) {
                        hintModel.addElement(object.getName());
                    }
                }
                hintScrollPane.setVisible(!hintModel.isEmpty());
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });

        hintList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && hintList.getSelectedValue() != null) {
                searchField.setText(hintList.getSelectedValue());
                hintScrollPane.setVisible(false);
            }
        });

        searchButton.addActionListener(e -> {
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
        });

        openButton.addActionListener(e -> openDetailsPage(foundObject[0]));

        backButton.addActionListener(e -> {
            new MainMenuPage(manager).setVisible(true);
            dispose();
        });

        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(searchField);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(hintScrollPane);
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
        } else if (object instanceof Comet) {
            new CometsPage(manager).setVisible(true);
        }

        dispose();
    }
}