package spaceencyclopedia.gui;

import spaceencyclopedia.core.*;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class FavoritesPage extends BasePage {

    private EncyclopediaManager manager;

    public FavoritesPage(EncyclopediaManager manager) {
        super("Favorites");

        this.manager = manager;

        BackgroundPanel backgroundPanel =
                new BackgroundPanel("/spaceencyclopedia/images/img_1.png");
        backgroundPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(40, 80, 40, 80));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JLabel title = createLabel("FAVORITES", 48, Font.BOLD);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(40));

        ArrayList<SpaceObject> favorites =
                manager.getFavoritesManager().getFavorites();

        if (favorites.isEmpty()) {
            JLabel emptyLabel = createLabel("No favorites yet.", 28, Font.PLAIN);
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPanel.add(emptyLabel);
        } else {
            addGroup(contentPanel, "Planets", Planet.class, favorites);
            addGroup(contentPanel, "Satellites", Satellite.class, favorites);
            addGroup(contentPanel, "Stars", Star.class, favorites);
            addGroup(contentPanel, "Asteroids", Asteroid.class, favorites);
            addGroup(contentPanel, "Black Holes", BlackHole.class, favorites);
            addGroup(contentPanel, "Nebulae", Nebula.class, favorites);
            addGroup(contentPanel, "Comets", Comet.class, favorites);
            addGroup(contentPanel, "Asteroids", Asteroid.class, favorites);
        }

        JButton backButton = createButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new MainMenuPage(manager).setVisible(true);
                dispose();
            }
        });

        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(backButton);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        add(backgroundPanel);
    }

    private void addGroup(JPanel contentPanel, String groupName, Class<?> groupClass, ArrayList<SpaceObject> favorites) {
        boolean hasObjects = false;
        for (SpaceObject object : favorites) {
            if (groupClass.isInstance(object)) {
                hasObjects = true;
                break;
            }
        }

        if (!hasObjects) {
            return;
        }

        JLabel groupLabel = createLabel(groupName, 34, Font.BOLD);
        groupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel groupPanel = new JPanel();
        groupPanel.setOpaque(false);
        groupPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

        for (SpaceObject object : favorites) {
            if (groupClass.isInstance(object)) {
                groupPanel.add(createFavoriteCard(object));
            }
        }

        contentPanel.add(groupLabel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(groupPanel);
        contentPanel.add(Box.createVerticalStrut(35));
    }

    private JPanel createFavoriteCard(SpaceObject object) {
        JPanel card = new JPanel();
        card.setOpaque(false);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setPreferredSize(new Dimension(180, 230));

        JButton imageButton = createImageButton(object);
        JLabel nameLabel = new JLabel(object.getName());
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 20));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton removeButton = createButton("Remove");
        removeButton.setFont(new Font("Arial", Font.BOLD, 14));
        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                openDetailsPage(object);
            }
        });

        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                manager.getFavoritesManager().removeFavorite(object);
                new FavoritesPage(manager).setVisible(true);
                dispose();
            }
        });

        card.add(imageButton);
        card.add(Box.createVerticalStrut(8));
        card.add(nameLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(removeButton);

        return card;
    }

    private JButton createImageButton(SpaceObject object) {
        String path = "/spaceencyclopedia/images/" +
                object.getName().toLowerCase() + ".png";

        java.net.URL imageURL = getClass().getResource(path);

        JButton button = new JButton();

        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            int originalWidth = icon.getIconWidth();
            int originalHeight = icon.getIconHeight();
            int maxSize = 120;
            if (object instanceof Star) {
                maxSize = 150;
            }
            int newWidth;
            int newHeight;
            if (originalWidth > originalHeight) {
                newWidth = maxSize;
                newHeight = (originalHeight * maxSize) / originalWidth;
            } else {
                newHeight = maxSize;
                newWidth = (originalWidth * maxSize) / originalHeight;
            }
            Image scaledImage = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage));
        }

        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        return button;
    }

    private void openDetailsPage(SpaceObject object) {
        if (object instanceof Planet) {
            new PlanetDetailsPage((Planet) object, manager).setVisible(true);
        } else if (object instanceof Satellite) {
            new SatelliteDetailsPage((Satellite) object, manager).setVisible(true);
        } else if (object instanceof Star) {
            new StarDetailsPage((Star) object, manager).setVisible(true);
        }
        dispose();
    }
}