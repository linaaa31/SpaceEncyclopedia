package spaceencyclopedia.gui;

import spaceencyclopedia.core.Star;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import java.awt.*;

public class StarsPage extends BasePage {
    private EncyclopediaManager manager;

    public StarsPage(EncyclopediaManager manager) {
        super("Stars");

        this.manager = manager;
        BackgroundPanel backgroundPanel = new BackgroundPanel("/spaceencyclopedia/images/img_1.png");

        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(new StarsPanel(), BorderLayout.CENTER);
        setContentPane(backgroundPanel);
    }

    private class StarsPanel extends JPanel {
        private JLabel title;
        private JButton sunButton;
        private JButton backButton;

        public StarsPanel() {
            setLayout(null);
            setOpaque(false);

            title = createLabel("STAR", 48, Font.BOLD);
            add(title);

            sunButton = createStarButton("sun", 580);

            sunButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    Star selectedStar = (Star) manager.searchByName("Sun");
                    new StarDetailsPage(selectedStar, manager).setVisible(true);
                    dispose();
                }
            });

            add(sunButton);

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
            int h = getHeight();
            title.setBounds(0, 20, w, 80);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            backButton.setBounds(25, 25, 110, 40);
            int size = Math.min(w, h) / 2 + 120;
            ImageIcon icon = loadStarIcon("sun", size);
            sunButton.setIcon(icon);
            sunButton.setBounds(w / 2 - icon.getIconWidth() / 2, h / 2 - icon.getIconHeight() / 2 + 40, icon.getIconWidth(), icon.getIconHeight());
        }
    }

    private JButton createStarButton(String starName, int size) {
        ImageIcon icon = loadStarIcon(starName, size);

        JButton button = new JButton(icon);
        button.setToolTipText("Sun");

        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        return button;
    }

    private ImageIcon loadStarIcon(String starName, int size) {
        String path = "/spaceencyclopedia/images/" + starName.toLowerCase() + ".png";

        ImageIcon originalIcon = loadImage(path);

        if (originalIcon == null) {
            System.out.println("Image not found: " + path);
            return null;
        }
        int originalWidth = originalIcon.getIconWidth();
        int originalHeight = originalIcon.getIconHeight();

        int width = size;
        int height = originalHeight * width / originalWidth;

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