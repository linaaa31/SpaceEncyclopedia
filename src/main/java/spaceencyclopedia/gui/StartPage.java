package spaceencyclopedia.gui;

import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import java.awt.*;

public class StartPage extends BasePage {

    private EncyclopediaManager manager;

    public StartPage(EncyclopediaManager manager) {
        super("Space Encyclopedia");

        this.manager = manager;

        BackgroundPanel panel =
                new BackgroundPanel("/spaceencyclopedia/images/img.png");
        panel.setLayout(new GridBagLayout());

        JLabel title = createLabel("SPACE ENCYCLOPEDIA", 50, Font.BOLD);
        JLabel subtitle = createLabel("Explore the Milky Way Galaxy", 26, Font.PLAIN);
        JButton enterButton = createButton("Enter Spacepedia");

        enterButton.addActionListener(e -> {
            System.out.println("Enter button clicked");
            new MainMenuPage().setVisible(true);
            dispose();
        });

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(15));
        textPanel.add(subtitle);
        textPanel.add(Box.createVerticalStrut(40));
        textPanel.add(enterButton);

        panel.add(textPanel);
        add(panel);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent e) {
                int width = getWidth();

                title.setFont(new Font("Serif", Font.BOLD, width / 16));
                subtitle.setFont(new Font("Serif", Font.PLAIN, width / 32));
                enterButton.setFont(new Font("Arial", Font.BOLD, width / 45));
            }
        });
    }
}