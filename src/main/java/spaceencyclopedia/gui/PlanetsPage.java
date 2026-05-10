package spaceencyclopedia.gui;

import spaceencyclopedia.core.Planet;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlanetsPage extends BasePage {
private EncyclopediaManager manager;

    public PlanetsPage(EncyclopediaManager manager) {
        super("Planets");

        this.manager = manager;

        BackgroundPanel backgroundPanel =
                new BackgroundPanel("/spaceencyclopedia/images/img_1.png");

        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(new SolarSystemPanel(), BorderLayout.CENTER);

        setContentPane(backgroundPanel);
    }

    private class SolarSystemPanel extends JPanel {

        private JLabel title;
        private JButton backButton;
        private ArrayList<JButton> planetButtons = new ArrayList<>();

        private String[] planets = {
                "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"
        };

        public SolarSystemPanel() {
            setLayout(null);
            setOpaque(false);
            title = createLabel("PLANETS", 48, Font.BOLD);
            add(title);

            for (String planet : planets) {
                JButton button = createPlanetButton(planet, 80);
                button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        Planet selectedPlanet = (Planet) manager.searchByName(planet);
                        new PlanetDetailsPage(selectedPlanet, manager).setVisible(true);
                        dispose();
                    }
                });

                planetButtons.add(button);
                add(button);
            }
            backButton = createButton("Back");
            backButton.setFont(new Font("Arial", Font.BOLD, 16));

            backButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    new MainMenuPage(manager).setVisible(true);
                    dispose();
                }
            });

            add(backButton);
        }
        private void drawSun(Graphics2D g2, int h){

            ImageIcon sunIcon = loadImage("/spaceencyclopedia/images/sun.png");

            if (sunIcon != null){
                g2.drawImage(sunIcon.getImage(), -350, h / 2 - 250, 500, 500, this);
            }
        }
        public void doLayout() {
            int w = getWidth();
            int h = getHeight();

            title.setBounds(w / 2 - 150, 35, 350, 70);
            backButton.setBounds(25, 25, 110, 40);

            int scale = Math.max(35, Math.min(w, h) / 8);

            int[][] positions = {
                    {16, 51, 42},     // Mercury
                    {25, 51, 58},     // Venus
                    {34, 51, 65},     // Earth
                    {42, 50, 55},     // Mars
                    {50, 51, 105},    // Jupiter
                    {63, 51, 95},     // Saturn
                    {75, 51, 70},     // Uranus
                    {90, 51, 70}      // Neptune
            };

            for (int i = 0; i < planets.length; i++) {
                String planet = planets[i];

                int baseSize = positions[i][2];
                int dynamicSize = baseSize * scale / 80;

                ImageIcon icon = loadPlanetIcon(planet, dynamicSize);
                planetButtons.get(i).setIcon(icon);

                int x = w * positions[i][0] / 100;
                int y = h * positions[i][1] / 100;
                planetButtons.get(i).setBounds(x - icon.getIconWidth() / 2, y - icon.getIconHeight() / 2, icon.getIconWidth(), icon.getIconHeight());
            }
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();
            drawSun(g2,h);
            drawOrbits(g2, w, h);
        }

        private void drawOrbits(Graphics2D g2, int w, int h) {
            g2.setColor(new Color(230, 230, 230));

            int centerX = 0;
            int centerY = h / 2;

            int[] orbitWidths = {w / 3, w / 2, w * 2 / 3, w * 5 / 6, w, (int) (w * 6.4 / 5), (int) (w * 7.5 / 5), w * 9 / 5,};

            for (int orbitWidth : orbitWidths) {
                int orbitHeight = h / 2 + orbitWidth / 8;
                g2.drawOval(centerX - orbitWidth / 2, centerY - orbitHeight / 2, orbitWidth, orbitHeight);
            }
        }
    }

    private JButton createPlanetButton(String planetName, int size) {
        ImageIcon icon = loadPlanetIcon(planetName, size);

        JButton button = new JButton(icon);
        button.setToolTipText(planetName);

        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        return button;
    }

    private ImageIcon loadPlanetIcon(String planetName, int size) {
        String path = "/spaceencyclopedia/images/" +
                planetName.toLowerCase() + ".png";

        ImageIcon originalIcon = loadImage(path);

        if (originalIcon == null) {
            System.out.println("Image not found: " + path);
            return null;
        }
        int originalWidth = originalIcon.getIconWidth();
        int originalHeight = originalIcon.getIconHeight();

        double ratio = (double) originalWidth / originalHeight;

        int width = size;
        int height = (int) (size / ratio);

        if (planetName.equalsIgnoreCase("Saturn")) {
            width = size + size / 2;
            height = size;
        }

        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private ImageIcon loadImage(String path) {
        java.net.URL imageUrl = getClass().getResource(path);

        if (imageUrl == null) {
            return null;
        }

        return new ImageIcon(imageUrl);
    }




}