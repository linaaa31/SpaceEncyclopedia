package spaceencyclopedia.gui;

import spaceencyclopedia.core.Nebula;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NebulaDetailsPage extends BasePage {

    private Nebula nebula;
    private EncyclopediaManager manager;

    public NebulaDetailsPage(Nebula nebula, EncyclopediaManager manager) {
        super(nebula.getName());

        this.nebula = nebula;
        this.manager = manager;

        BackgroundPanel backgroundPanel = new BackgroundPanel("/spaceencyclopedia/images/img_1.png");
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

        JLabel title = createLabel(nebula.getName().toUpperCase() + " NEBULA", 48, Font.BOLD);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String imagePath = "/spaceencyclopedia/images/" +
                nebula.getName().toLowerCase().replace(" ", "") + ".png";

        java.net.URL imageURL = getClass().getResource(imagePath);

        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);

            Image originalImage = icon.getImage();
            int originalWidth = icon.getIconWidth();
            int originalHeight = icon.getIconHeight();

            int newWidth = 420;
            int newHeight = (originalHeight * newWidth) / originalWidth;

            Image scaledImage = originalImage.getScaledInstance(
                    newWidth, newHeight, Image.SCALE_SMOOTH
            );

            imageLabel.setIcon(new ImageIcon(scaledImage));
        } else {
            imageLabel.setText("Nebula image not found");
            imageLabel.setForeground(Color.WHITE);
        }

        JTextArea factsArea = createTextArea(
                "Distance from Earth: " + nebula.getDistanceFromEarth() + " light-years" +
                        "\n\nNebula Type: " + nebula.getNebulaType() +
                        "\n\nStar Forming Region: " + nebula.isStarFormingRegion()
        );

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BorderLayout(50, 20));
        topPanel.setMaximumSize(new Dimension(1200, 420));
        topPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(imageLabel, BorderLayout.WEST);
        topPanel.add(factsArea, BorderLayout.CENTER);

        JTextArea infoArea = createTextArea(
                "ABOUT THE NEBULA\n\n" + nebula.getOverview() +
                        "\n\nFORMATION\n\n" + nebula.getFormation() +
                        "\n\nIMPORTANCE\n\n" + nebula.getImportance() +
                        "\n\nINTERESTING FACTS\n\n" + nebula.getInterestingFacts()
        );

        infoArea.setMaximumSize(new Dimension(1200, Integer.MAX_VALUE));
        infoArea.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton favoriteButton = createButton("Add to Favorites");

        favoriteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                manager.getFavoritesManager().addFavorite(nebula);
                favoriteButton.setText("Added to Favorites");
            }
        });

        JButton backButton = createButton("Back");
        backButton.addActionListener(e -> {
            new NebulaePage(manager).setVisible(true);
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
        setContentPane(backgroundPanel);
    }

    private JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(text);

        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Serif", Font.PLAIN, 24));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        return textArea;
    }
}