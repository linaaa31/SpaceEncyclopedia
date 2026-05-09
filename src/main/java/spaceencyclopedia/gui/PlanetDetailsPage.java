package spaceencyclopedia.gui;

import spaceencyclopedia.core.Planet;
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
//            Image scaledImage = icon.getImage().getScaledInstance(
//                    350, 350, Image.SCALE_SMOOTH
//            );
//            imageLabel.setIcon(new ImageIcon(scaledImage));
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
        JButton favoriteButton = createButton("Add to Favorites");
        JButton backButton = createButton("Back");
        backButton.addActionListener(e -> {
            new PlanetsPage(manager).setVisible(true);
            dispose();
        });

        favoriteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(topPanel);
        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(infoArea);
        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(favoriteButton);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(backButton);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        add(backgroundPanel);
    }
}