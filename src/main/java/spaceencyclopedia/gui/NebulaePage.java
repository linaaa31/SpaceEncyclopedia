package spaceencyclopedia.gui;
import spaceencyclopedia.core.Nebula;
import spaceencyclopedia.manager.EncyclopediaManager;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NebulaePage extends BasePage {
    private EncyclopediaManager manager;

    public NebulaePage(EncyclopediaManager manager) {
        super("Nebulae");
        this.manager = manager;
        BackgroundPanel backgroundPanel=
                new BackgroundPanel("/spaceencyclopedia/images/img_1.png");

        backgroundPanel.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);

        JLabel title = createLabel("NEBULAE", 48, Font.BOLD);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel nebulaPanel = new JPanel(new GridBagLayout());
        nebulaPanel.setOpaque(false);
        nebulaPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(25, 45, 25, 45);

        ArrayList<Nebula> nebulae = manager.getNebulae();

        for (int i = 0; i < nebulae.size(); i++) {
            Nebula nebula = nebulae.get(i);
            JButton button = createNebulaButton(nebula);

            button.addActionListener(e -> {
                new NebulaDetailsPage(nebula, manager).setVisible(true);
                dispose();
            });
            if (i < 3) {
                gbc.gridx = i;
                gbc.gridy = 0;
                gbc.gridwidth = 1;
            } else if (i == 3) {
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.gridwidth = 2;
            } else if (i == 4) {
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.gridwidth = 2;
            }
            nebulaPanel.add(button, gbc);
        }
        JButton backButton = createButton("Back");
        backButton.setPreferredSize(new Dimension(200, 60));

        backButton.setFont(new Font("Serif", Font.BOLD, 24));
        backButton.addActionListener(e -> {
            new MainMenuPage(manager).setVisible(true);
            dispose();
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        bottomPanel.add(backButton);
        mainPanel.add(nebulaPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        backgroundPanel.add(mainPanel, BorderLayout.CENTER);
        setContentPane(backgroundPanel);
    }
    private JButton createNebulaButton(Nebula nebula) {
        JButton button = new JButton(nebula.getName());
        button.setPreferredSize(new Dimension(300, 210));
        String imagePath = "/spaceencyclopedia/images/" +
                nebula.getName().toLowerCase().replace(" ", "") + ".png";
        java.net.URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            ImageIcon icon =new ImageIcon(imageURL);

            Image scaledImage = icon.getImage().getScaledInstance(
                    260, 150, Image.SCALE_SMOOTH
            );
            button.setIcon(new ImageIcon(scaledImage));
        }
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setFont(new Font("Serif", Font.BOLD, 24));
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}