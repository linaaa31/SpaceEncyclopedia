package spaceencyclopedia.gui;

import spaceencyclopedia.core.Star;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StarDetailsPage extends BasePage {
    private Star star;
    private EncyclopediaManager manager;

    public StarDetailsPage(Star star, EncyclopediaManager manager) {
        super(star.getName());

        this.star = star;
        this.manager = manager;

        BackgroundPanel backgroundPanel =
                new BackgroundPanel("/spaceencyclopedia/images/img_1.png");
        backgroundPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(40, 70, 40, 70));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JLabel title = createLabel("THE SUN", 52, Font.BOLD);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel introPanel = new JPanel(new BorderLayout(50, 20));
        introPanel.setOpaque(false);
//        introPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 430));
        introPanel.setMaximumSize(new Dimension(1200, 430));
        introPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea introText = createTextArea(
                star.getOverview() +
                        "\n\nRadius: " + star.getRadius() + " km" +
                        "\nMass: " + star.getMass() + " kg" +
                        "\nTemperature: " + star.getTemperature() + " K" +
                        "\nDistance from Earth: " + star.getDistanceFromEarth() + " million km"
        );

        JLabel sunImage = createImageLabel("/spaceencyclopedia/images/sun.png", 330);

        introPanel.add(introText, BorderLayout.CENTER);
        introPanel.add(sunImage, BorderLayout.EAST);

        JTextArea compositionText = createTextArea(
                "COMPOSITION\n\n" + star.getComposition()
        );

        JTextArea distanceText = createTextArea(
                "DISTANCE\n\n" + star.getDistanceInfo()
        );

        JTextArea galaxyText = createTextArea(
                "GALAXY\n\n" + star.getGalaxyInfo()
        );

        JLabel structureTitle = createLabel("STRUCTURE", 52, Font.BOLD);
        structureTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel structurePanel = new JPanel(new BorderLayout());
        structurePanel.setOpaque(false);
        structurePanel.setMaximumSize(new Dimension(1200, 680));
        structurePanel.setAlignmentX(Component.LEFT_ALIGNMENT);


        StructureSunPanel structureSunPanel = new StructureSunPanel();
        structurePanel.add(structureSunPanel, BorderLayout.CENTER);
        JTextArea structureExplanation = createTextArea(
                "STRUCTURE LAYERS\n\n" + star.getStructure()
        );
        JTextArea factsText = createTextArea(
                "INTERESTING FACTS\n\n" + star.getInterestingFacts()
        );
        JButton favoriteButton = createButton(manager.getFavoritesManager().getFavorites().contains(star) ? "Added to Favorites"
                        : "Add to Favorites");

        favoriteButton.addActionListener(e -> {
            if (!manager.getFavoritesManager().getFavorites().contains(star)) {
                manager.getFavoritesManager().addFavorite(star);
                favoriteButton.setText("Added to Favorites");
            }
        });
        JButton backButton = createButton("Back");

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new MainMenuPage(manager).setVisible(true);
                dispose();
            }
        });
        favoriteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(introPanel);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(compositionText);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(distanceText);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(galaxyText);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(structureTitle);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(structurePanel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(structureExplanation);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(factsText);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        favoriteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        favoriteButton.setMaximumSize(favoriteButton.getPreferredSize());
        backButton.setMaximumSize(backButton.getPreferredSize());

        buttonsPanel.add(favoriteButton);
        buttonsPanel.add(Box.createVerticalStrut(15));
        buttonsPanel.add(backButton);

        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(buttonsPanel);

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
        textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        textArea.setMaximumSize(new Dimension(1200, Integer.MAX_VALUE));
        textArea.setPreferredSize(new Dimension(1200, textArea.getPreferredSize().height));

        return textArea;
    }

    private JLabel createImageLabel(String path, int width) {
        JLabel label = new JLabel();

        java.net.URL imageURL = getClass().getResource(path);

        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);

            int originalWidth = icon.getIconWidth();
            int originalHeight = icon.getIconHeight();

            int height = originalHeight * width / originalWidth;

            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage));
        } else {
            label.setText("Image not found");
            label.setForeground(Color.WHITE);
        }
        return label;
    }

    private class StructureSunPanel extends JPanel {

            private Image image;
            public StructureSunPanel() {
                setPreferredSize(new Dimension(1200, 650));
                setMaximumSize(new Dimension(1200, 650));
                setOpaque(false);

                java.net.URL imageURL = getClass().getResource("/spaceencyclopedia/images/StructureOfSun.png");

                if (imageURL != null) {
                    image = new ImageIcon(imageURL).getImage();
                }
            }

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (image != null) {
                    g2.drawImage(image, 60, 40, 580, 580, this);
                }

                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(3));
                g2.setFont(new Font("Serif", Font.BOLD, 30));

                drawLabelLine(g2, "Corona", 760, 120, 520, 130);
                drawLabelLine(g2, "Photosphere", 760, 210, 450, 250);
                drawLabelLine(g2, "Convective zone", 760, 310, 460, 340);
                drawLabelLine(g2, "Radiative zone", 760, 420, 500, 370);
                drawLabelLine(g2, "Core", 760, 530, 380, 350);
            }

            private void drawLabelLine(Graphics2D g2, String text, int textX, int textY, int lineEndX, int lineEndY) {

                g2.drawString(text, textX, textY);
                FontMetrics fm = g2.getFontMetrics();
                int startX = textX - 25;
                int startY = textY - fm.getHeight() / 3;

                g2.drawLine(startX, startY, lineEndX, lineEndY);
                g2.fillOval(lineEndX - 5, lineEndY - 5, 10, 10);
            }
        }
    }
