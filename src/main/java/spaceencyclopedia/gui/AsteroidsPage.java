package spaceencyclopedia.gui;

import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AsteroidsPage extends BasePage {

    private EncyclopediaManager manager;

    private JLabel title;
    private JTextArea descriptionArea;

    private JButton backButton;

    public AsteroidsPage(EncyclopediaManager manager) {

        super("Asteroids");

        this.manager = manager;

        BackgroundPanel backgroundPanel =
                new BackgroundPanel("/spaceencyclopedia/images/asteroidBackground.jpg");

        backgroundPanel.setLayout(new BorderLayout());

        // ===== MAIN CONTENT PANEL =====
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(30, 50, 30, 50));

        // ===== TITLE =====
        title = createLabel("ASTEROIDS", 45, Font.BOLD);

        // ===== GENERAL DESCRIPTION =====
        descriptionArea = new JTextArea(
                "Asteroids are rocky objects that orbit the Sun. "
                        + "Millions of asteroids exist in our Solar System, "
                        + "especially in the Asteroid Belt between Mars and Jupiter. "
                        + "They vary greatly in size, shape, and composition. "
                        + "Some are only a few meters wide, while others are hundreds "
                        + "of kilometers across. Scientists study asteroids to learn "
                        + "more about the early Solar System."
        );

        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);

        descriptionArea.setFont(new Font("Serif", Font.PLAIN, 24));

        descriptionArea.setForeground(Color.WHITE);

        descriptionArea.setOpaque(false);

        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===== ASTEROID EXAMPLES =====

        JPanel asteroidPanel1 = createAsteroidPanel(
                "Vesta",
                "/spaceencyclopedia/images/vesta.jpg",
                "Vesta is one of the largest asteroids in the Solar System. "
                        + "It has a rocky surface and a massive crater near its south pole."
        );

        JPanel asteroidPanel2 = createAsteroidPanel(
                "Eros",
                "/spaceencyclopedia/images/eros.jpg",
                "Eros is a near-Earth asteroid discovered in 1898. "
                        + "It was visited by NASA's NEAR Shoemaker spacecraft."
        );

        JPanel asteroidPanel3 = createAsteroidPanel(
                "Pallas",
                "/spaceencyclopedia/images/pallas.jpg",
                "Pallas is one of the first asteroids ever discovered. "
                        + "It has an unusual tilted orbit around the Sun."
        );

        // ===== BACK BUTTON =====
        backButton = createButton("Back");

        backButton.addActionListener(e -> {
            new MainMenuPage(manager).setVisible(true);
            dispose();
        });

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===== ADD COMPONENTS =====
        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(30));

        contentPanel.add(descriptionArea);
        contentPanel.add(Box.createVerticalStrut(40));

        contentPanel.add(asteroidPanel1);
        contentPanel.add(Box.createVerticalStrut(30));

        contentPanel.add(asteroidPanel2);
        contentPanel.add(Box.createVerticalStrut(30));

        contentPanel.add(asteroidPanel3);
        contentPanel.add(Box.createVerticalStrut(40));

        contentPanel.add(backButton);

        // ===== SCROLL PANE =====
        JScrollPane scrollPane = new JScrollPane(contentPanel);

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        contentPanel.setPreferredSize(
                new Dimension(this.getWidth(), 1500)
        );
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);


        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);

        add(backgroundPanel);
    }

    private JPanel createAsteroidPanel(String name,
                                       String imagePath,
                                       String description) {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(new BorderLayout(20, 20));

        // ===== IMAGE =====
        JLabel imageLabel = new JLabel();

        java.net.URL imageURL = getClass().getResource(imagePath);

        if (imageURL != null) {

            ImageIcon icon = new ImageIcon(imageURL);

            Image scaledImage = icon.getImage().getScaledInstance(
                    250,
                    180,
                    Image.SCALE_SMOOTH
            );

            imageLabel.setIcon(new ImageIcon(scaledImage));

        } else {

            imageLabel.setText("Image not found");
            imageLabel.setForeground(Color.WHITE);
        }

        // ===== TEXT =====
        JPanel textPanel = new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel asteroidName = createLabel(name, 28, Font.BOLD);

        JTextArea asteroidDescription = new JTextArea(description);

        asteroidDescription.setWrapStyleWord(true);
        asteroidDescription.setLineWrap(true);

        asteroidDescription.setEditable(false);

        asteroidDescription.setFont(new Font("Serif", Font.PLAIN, 20));

        asteroidDescription.setForeground(Color.WHITE);

        asteroidDescription.setOpaque(false);

        textPanel.add(asteroidName);
        textPanel.add(Box.createVerticalStrut(10));
        textPanel.add(asteroidDescription);

        panel.add(imageLabel, BorderLayout.WEST);
        panel.add(textPanel, BorderLayout.CENTER);

        return panel;
    }
}
