package spaceencyclopedia.gui;

import spaceencyclopedia.core.Planet;
import spaceencyclopedia.core.Satellite;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlanetDetailsPage extends BasePage {

    private Planet planet;
    private EncyclopediaManager manager;

    public PlanetDetailsPage(Planet planet, EncyclopediaManager manager) {
        super(planet.getName());

        this.planet = planet;
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

        JLabel title = createLabel(planet.getName().toUpperCase(), 48, Font.BOLD);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String imagePath = "/spaceencyclopedia/images/" + planet.getName().toLowerCase() + ".png";

        java.net.URL imageURL = getClass().getResource(imagePath);

        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            Image originalImage = icon.getImage();
            int originalWidth = icon.getIconWidth();
            int originalHeight = icon.getIconHeight();
            int newWidth = 350;
            int newHeight = (originalHeight * newWidth) / originalWidth;
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            imageLabel.setIcon(new ImageIcon(scaledImage));
        } else {
            imageLabel.setText("Planet image not found");
            imageLabel.setForeground(Color.WHITE);
        }

        JTextArea factsArea = new JTextArea("Radius: " + planet.getRadius() + " km" + "\n\nMass: " + planet.getMass() + " ×10^24 kg" +
                "\n\nDistance from Sun: " + planet.getDistanceFromSun() + " million km" + "\n\nHas Rings: " + planet.getHasRings() +
                "\n\nNumber of Satellites: " + planet.getNumberOfSatellites());

        factsArea.setEditable(false);
        factsArea.setOpaque(false);
        factsArea.setForeground(Color.WHITE);
        factsArea.setFont(new Font("Serif", Font.PLAIN, 24));
        factsArea.setLineWrap(true);
        factsArea.setWrapStyleWord(true);

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BorderLayout(50, 20));
        topPanel.setMaximumSize(new Dimension(1200, 380));
        topPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(imageLabel, BorderLayout.WEST);
        topPanel.add(factsArea, BorderLayout.CENTER);

        JTextArea infoArea = new JTextArea("ABOUT THE PLANET\n\n" + planet.getOverview() + "\n\nORIGINS AND FORMATION\n\n" + planet.getFormation() +
                "\n\nEXPLORATION AND DISCOVERIES\n\n" + planet.getExploration() + "\n\nINTERESTING FACTS\n\n" + planet.getInterestingFacts());

        infoArea.setEditable(false);
        infoArea.setOpaque(false);
        infoArea.setForeground(Color.WHITE);
        infoArea.setFont(new Font("Serif", Font.PLAIN, 24));
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setMaximumSize(new Dimension(1200, Integer.MAX_VALUE));
        infoArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        boolean isFavorite = manager.getFavoritesManager().getFavorites().contains(planet);

        JButton favoriteButton = createButton(isFavorite ? "Added to Favorites" : "Add to Favorites");
        favoriteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (!manager.getFavoritesManager().getFavorites().contains(planet)) {
                    manager.getFavoritesManager().addFavorite(planet);
                    favoriteButton.setText("Added to Favorites");
                }
            }
        });

        JButton backButton = createButton("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new PlanetsPage(manager).setVisible(true);
                dispose();
            }
        });
        favoriteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(topPanel);
        contentPanel.add(Box.createVerticalStrut(40));

        if (!planet.getSatellites().isEmpty()) {
            JLabel moonsTitle = createLabel("(SOME)SATELLITES OF " + planet.getName().toUpperCase(), 32, Font.BOLD);
            moonsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            JPanel moonsPanel = new JPanel();
            moonsPanel.setOpaque(false);
            moonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20)
            );

            for (Satellite satellite : planet.getSatellites()) {
                JPanel moonContainer = new JPanel();
                moonContainer.setOpaque(false);
                moonContainer.setLayout(new BoxLayout(moonContainer, BoxLayout.Y_AXIS));
                moonContainer.setPreferredSize(new Dimension(220, 230));//
                String moonImagePath = "/spaceencyclopedia/images/" + satellite.getName().toLowerCase()+ ".png";
                java.net.URL moonImageURL = getClass().getResource(moonImagePath);
                JButton moonButton = new JButton();
                if (moonImageURL != null) {
                    ImageIcon moonIcon =new ImageIcon(moonImageURL);
                    Image scaledMoon =moonIcon.getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH);
                    moonButton.setIcon(new ImageIcon(scaledMoon));
                }else{
                    moonButton.setText(satellite.getName());
                }
                moonButton.setContentAreaFilled(false);
                moonButton.setBorderPainted(false);
                moonButton.setFocusPainted(false);
                moonButton.setOpaque(false);
                moonButton.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent e) {
                                new SatelliteDetailsPage(satellite, manager).setVisible(true);
                                dispose();}
                        });
                JLabel moonName = new JLabel(satellite.getName());

                moonName.setForeground(Color.WHITE);
                moonName.setFont(new Font("Serif", Font.BOLD, 18));

                moonName.setPreferredSize(new Dimension(220, 35));
                moonName.setMaximumSize(new Dimension(220, 35));

                moonName.setAlignmentX(Component.CENTER_ALIGNMENT);

                moonContainer.add(moonButton);
                moonContainer.add(Box.createVerticalStrut(8));
                moonContainer.add(moonName);
                moonsPanel.add(moonContainer);
            }
            contentPanel.add(moonsTitle);
            contentPanel.add(Box.createVerticalStrut(20));
            contentPanel.add(moonsPanel);
            contentPanel.add(Box.createVerticalStrut(40));
        }
        contentPanel.add(infoArea);
        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(favoriteButton);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(backButton);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        add(backgroundPanel);
    }
}