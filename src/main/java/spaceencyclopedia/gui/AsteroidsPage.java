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
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setMaximumSize(new Dimension(900, Integer.MAX_VALUE));
        contentPanel.setBorder(new EmptyBorder(30, 50, 30, 50));
        contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JScrollPane scrollPane = new JScrollPane(contentPanel);

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        title = createLabel("ASTEROIDS", 45, Font.BOLD);
        descriptionArea = new JTextArea(
                "Asteroids are small rocky objects that orbit the Sun. Most asteroids are located in the " +
                        "Asteroid Belt between Mars and Jupiter, although some travel closer to Earth. " +
                        "They are considered leftovers from the early formation of the Solar System over 4.5 billion " +
                        "years ago. Asteroids vary greatly in size, shape, and composition. " +
                        "Some are made mostly of rock," +
                        " while others contain metals such as iron and nickel.\n" +
                        "\n" +
                        "Scientists study asteroids to better understand the history of the Solar System " +
                        "and the formation of planets. Some asteroids are especially well known because of their size," +
                        " unusual characteristics, or importance in space exploration. " +
                        "Among the most famous examples are Vesta, Eros, and Pallas."
        );
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new Font("Serif", Font.PLAIN, 24));
        descriptionArea.setForeground(Color.WHITE);
        descriptionArea.setOpaque(false);
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel asteroidPanel1 = createAsteroidPanel(
                "Vesta",
                "/spaceencyclopedia/images/vestaAsteroid.png",
                "Vesta is one of the largest objects in the Asteroid Belt and is sometimes described" +
                        " as a protoplanet because of its layered internal structure. " +
                        "Its surface contains enormous craters created by powerful collisions that occurred " +
                        "millions of years ago. NASA’s Dawn spacecraft studied Vesta in detail and discovered " +
                        "mountains, valleys, and signs of ancient volcanic activity."
        );

        JPanel asteroidPanel2 = createAsteroidPanel(
                "Eros",
                "/spaceencyclopedia/images/eros.png",
                "Eros is a near-Earth asteroid discovered in 1898. It became historically important" +
                        " because it was the first asteroid successfully orbited and landed on by a spacecraft " +
                        "during the NEAR Shoemaker mission. Eros has an elongated shape and follows an orbit " +
                        "that occasionally brings it relatively close to Earth."
        );

        JPanel asteroidPanel3 = createAsteroidPanel(
                "Pallas",
                "/spaceencyclopedia/images/pallasImage.png",
                "Pallas is one of the largest asteroids in the Solar System and was discovered in 1802. " +
                        "Unlike many asteroids, it has a strongly tilted orbit around the Sun. Scientists believe " +
                        "that Pallas may contain water-rich materials beneath its surface, making it an important " +
                        "object for scientific research."
        );

        backButton = createButton("Back");
        backButton.addActionListener(e -> {
            new MainMenuPage().setVisible(true);
            dispose();
        });

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        addComponentListener(new java.awt.event.ComponentAdapter() {

            @Override
            public void componentResized(
                    java.awt.event.ComponentEvent e
            ) {

                int width = getWidth();

                title.setFont(
                        new Font("Serif", Font.BOLD, width / 18)
                );

                descriptionArea.setFont(
                        new Font("Serif", Font.PLAIN, width / 45)
                );
            }
        });
        add(backgroundPanel);
    }

    private JPanel createAsteroidPanel(String name,
                                       String imagePath,
                                       String description) {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(new BorderLayout(20, 20));


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
