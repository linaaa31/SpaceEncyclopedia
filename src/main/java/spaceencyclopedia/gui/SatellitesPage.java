package spaceencyclopedia.gui;

import spaceencyclopedia.core.Satellite;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SatellitesPage extends BasePage {

    private EncyclopediaManager manager;

    public SatellitesPage(EncyclopediaManager manager) {
        super("Satellites");
        this.manager = manager;

        BackgroundPanel backgroundPanel =
                new BackgroundPanel("/spaceencyclopedia/images/img_1.png");

        backgroundPanel.setLayout(new BorderLayout());

        SatellitesPanel satellitesPanel = new SatellitesPanel();

        JScrollPane scrollPane = new JScrollPane(satellitesPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        setContentPane(backgroundPanel);
    }

    private class SatellitesPanel extends JPanel {

        private JLabel title;
        private JButton backButton;

        private ArrayList<JButton> satelliteButtons = new ArrayList<>();
        private ArrayList<JLabel> satelliteNameLabels = new ArrayList<>();
        private ArrayList<Satellite> satellites = manager.getSatellites();
        private ArrayList<JLabel> planetLabels = new ArrayList<>();

        public SatellitesPanel() {
            setLayout(null);
            setOpaque(false);
            title = createLabel("SATELLITES", 48, Font.BOLD);
            add(title);

            String currentPlanet = "";
            for (Satellite satellite : satellites) {
                if (!satellite.getParentPlanet().equals(currentPlanet)) {
                    currentPlanet = satellite.getParentPlanet();
                    JLabel planetLabel = createLabel("Satellites of " + currentPlanet, 30, Font.BOLD);
                    planetLabels.add(planetLabel);
                    add(planetLabel);
                }

                JButton button = createSatelliteButton(satellite.getName(), 110);

                button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        new SatelliteDetailsPage(
                                satellite,
                                manager
                        ).setVisible(true);
                        dispose();
                    }
                });

                JLabel moonName = new JLabel(satellite.getName());
                moonName.setForeground(Color.WHITE);
                moonName.setFont(new Font("Serif", Font.BOLD, 20));
                moonName.setHorizontalAlignment(SwingConstants.CENTER);
                satelliteButtons.add(button);
                satelliteNameLabels.add(moonName);

                add(button);
                add(moonName);
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

        public void doLayout() {
            int w = getWidth();
            title.setBounds(w / 2 - 130, 20, 300, 70);
            backButton.setBounds(25, 20, 110, 40);
            int iconSize = 170;
            int startY = 120;
            int sectionSpacing = 270;
            int moonGapX = 240;
            int labelIndex = 0;
            int satelliteIndex = 0;
            String currentPlanet = "";
            int y = startY;
            int x = 100;
            for (Satellite satellite : satellites) {
                if (!satellite.getParentPlanet().equals(currentPlanet)) {
                    currentPlanet = satellite.getParentPlanet();
                    JLabel label = planetLabels.get(labelIndex);
                    label.setBounds(60, y, 500, 50);
                    labelIndex++;
                    y += 80;
                    x = 100;
                }

                ImageIcon icon = loadSatelliteIcon(satellite.getName(), iconSize);
                JButton button = satelliteButtons.get(satelliteIndex);
                JLabel nameLabel = satelliteNameLabels.get(satelliteIndex);

                if (icon != null) {
                    button.setIcon(icon);
                    button.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
                    nameLabel.setBounds(x - 20, y + icon.getIconHeight() + 8, icon.getIconWidth() + 40, 30);
                } else {
                    button.setText(satellite.getName());
                    button.setBounds(x, y, 150, 40);
                    nameLabel.setBounds(x, y + 45, 150, 30);
                }

                satelliteIndex++;
                x += moonGapX;

                if (x + moonGapX > w - 100) {
                    x = 100;
                    y += 270;
                }

                if (satelliteIndex < satellites.size()) {
                    Satellite nextSatellite = satellites.get(satelliteIndex);
                    if (!nextSatellite.getParentPlanet().equals(currentPlanet)) {
                        y += sectionSpacing;
                    }
                }
            }
            setPreferredSize(new Dimension(w, y + 300));
        }
    }

    private JButton createSatelliteButton(String satelliteName, int size) {
        ImageIcon icon = loadSatelliteIcon(satelliteName, size);

        JButton button;
        if (icon != null) {
            button = new JButton(icon);
        } else {
            button = new JButton(satelliteName);
        }
        button.setToolTipText(satelliteName);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        return button;
    }

    private ImageIcon loadSatelliteIcon(String satelliteName, int size) {
        String path = "/spaceencyclopedia/images/" +
                satelliteName.toLowerCase() + ".png";
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