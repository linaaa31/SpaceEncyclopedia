package spaceencyclopedia.gui;

import javax.swing.*;
import java.awt.Image;
import java.awt.Graphics;

public class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {

        java.net.URL imageUrl =
                getClass().getResource(imagePath);

        if (imageUrl != null) {
            backgroundImage =
                    new ImageIcon(imageUrl).getImage();
        } else {
            System.out.println("Image not found: " + imagePath);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (backgroundImage != null) {

            g.drawImage(
                    backgroundImage,
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    this
            );
        }
    }
}