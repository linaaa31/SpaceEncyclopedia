package spaceencyclopedia.gui;

import spaceencyclopedia.core.Asteroid;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class AsteroidsPage extends BasePage {

    private EncyclopediaManager manager;

    public AsteroidsPage(EncyclopediaManager manager) {
        super("Asteroids");

        this.manager = manager;

        BackgroundPanel backgroundPanel =
                new BackgroundPanel("/spaceencyclopedia/images/asteroidBackground.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(30, 70, 30, 70));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JLabel title = createLabel("ASTEROIDS", 45, Font.BOLD);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea descriptionArea = createTextArea(
                "Asteroids are small rocky objects that orbit the Sun. Most asteroids are located in the " +
                        "Asteroid Belt between Mars and Jupiter, although some travel closer to Earth. " +
                        "They are considered leftovers from the early formation of the Solar System over 4.5 billion " +
                        "years ago. Asteroids vary greatly in size, shape, and composition. " +
                        "Some are made mostly of rock, while others contain metals such as iron and nickel.\n\n" +
                        "Scientists study asteroids to better understand the history of the Solar System " +
                        "and the formation of planets. Some asteroids are especially well known because of their size, " +
                        "unusual characteristics, or importance in space exploration. " +
                        "Among the most famous examples are Vesta, Eros, and Pallas."
        );

        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(descriptionArea);
        contentPanel.add(Box.createVerticalStrut(40));

        ArrayList<Asteroid> asteroids = manager.getAsteroids();

        for (Asteroid asteroid : asteroids) {
            JPanel asteroidPanel = createAsteroidPanel(asteroid);
            contentPanel.add(asteroidPanel);
            contentPanel.add(Box.createVerticalStrut(30));
        }

        JButton backButton = createButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButton.addActionListener(e -> {
            new MainMenuPage(manager).setVisible(true);
            dispose();
        });

        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(backButton);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        setContentPane(backgroundPanel);
    }

    private JPanel createAsteroidPanel(Asteroid asteroid) {
        JPanel panel = new JPanel(new BorderLayout(25, 20));
        panel.setOpaque(false);
        panel.setMaximumSize(new Dimension(1100, Integer.MAX_VALUE));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel imageLabel = createImageLabel(getAsteroidImagePath(asteroid));
        imageLabel.setVerticalAlignment(SwingConstants.TOP);

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel nameLabel = createLabel(asteroid.getName(), 28, Font.BOLD);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea asteroidDescription = createTextArea(
                asteroid.getDescription() +
                        "\n\nDiameter: " + asteroid.getDiameter() + " km" +
                        "\nDistance from Sun: " + asteroid.getDistanceFromSun() + " million km"
        );
        asteroidDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        boolean isFavorite = manager.getFavoritesManager().getFavorites().contains(asteroid);
        JButton favoriteButton = createButton(isFavorite ? "Added to Favorites" : "Add to Favorites");
        favoriteButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        favoriteButton.addActionListener(e -> {
            if (!manager.getFavoritesManager().getFavorites().contains(asteroid)) {
                manager.getFavoritesManager().addFavorite(asteroid);
                favoriteButton.setText("Added to Favorites");
            }
        });

        textPanel.add(nameLabel);
        textPanel.add(Box.createVerticalStrut(10));
        textPanel.add(asteroidDescription);
        textPanel.add(Box.createVerticalStrut(15));
        textPanel.add(favoriteButton);

        panel.add(imageLabel, BorderLayout.WEST);
        panel.add(textPanel, BorderLayout.CENTER);

        return panel;
    }

    private JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(text);

        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Serif", Font.PLAIN, 22));
        textArea.setMaximumSize(new Dimension(850, Integer.MAX_VALUE));

        return textArea;
    }

    private JLabel createImageLabel(String imagePath) {
        JLabel imageLabel = new JLabel();

        java.net.URL imageURL = getClass().getResource(imagePath);

        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            Image scaledImage = icon.getImage().getScaledInstance(250, 180, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        } else {
            imageLabel.setText("Image not found");
            imageLabel.setForeground(Color.WHITE);
        }

        imageLabel.setPreferredSize(new Dimension(280, 190));
        return imageLabel;
    }

    private String getAsteroidImagePath(Asteroid asteroid) {
        if (asteroid.getName().equalsIgnoreCase("Vesta")) {
            return "/spaceencyclopedia/images/vesta.png";
        } else if (asteroid.getName().equalsIgnoreCase("Eros")) {
            return "/spaceencyclopedia/images/eros.png";
        } else if (asteroid.getName().equalsIgnoreCase("Pallas")) {
            return "/spaceencyclopedia/images/pallas.png";
        }

        return "/spaceencyclopedia/images/default.jpg";
    }
}