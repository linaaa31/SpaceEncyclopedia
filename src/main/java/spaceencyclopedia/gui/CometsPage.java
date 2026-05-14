package spaceencyclopedia.gui;

import spaceencyclopedia.core.Comet;
import spaceencyclopedia.manager.EncyclopediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class CometsPage extends BasePage {

    private EncyclopediaManager manager;

    public CometsPage(EncyclopediaManager manager) {

        super("Comets");

        this.manager = manager;

        BackgroundPanel backgroundPanel = new BackgroundPanel("/spaceencyclopedia/images/comet.jpg");

        backgroundPanel.setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();

        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        contentPanel.setBorder(new EmptyBorder(40, 70, 40, 70));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JLabel title = createLabel("COMETS", 52, Font.BOLD);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        Comet generalComet = manager.getComets().get(0);

        JTextArea introText = createTextArea(generalComet.getOverview() + "\n\n" + generalComet.getOriginInfo() + "\n\n"
                + generalComet.getTailInfo() + "\n\n" + generalComet.getScientificImportance());

        JLabel examplesTitle = createLabel("FAMOUS EXAMPLES OF COMETS", 30, Font.BOLD);

        examplesTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(title);

        contentPanel.add(Box.createVerticalStrut(30));

        contentPanel.add(introText);

        contentPanel.add(Box.createVerticalStrut(40));

        contentPanel.add(examplesTitle);

        contentPanel.add(Box.createVerticalStrut(30));

        ArrayList<Comet> comets = manager.getComets();

        for (Comet comet : comets) {
            if (!comet.getName().equalsIgnoreCase("Comets")) {
                JPanel cometPanel = createCometPanel(comet);
                contentPanel.add(cometPanel);

                contentPanel.add(Box.createVerticalStrut(30));
            }
        }

        JTextArea conclusionText = createTextArea("CONCLUSION\n\n" + generalComet.getInterestingFacts());

        contentPanel.add(conclusionText);

        contentPanel.add(Box.createVerticalStrut(40));

        JButton backButton = createButton("Back");

        backButton.addActionListener(e -> {
            new MainMenuPage(manager).setVisible(true);
            dispose();
        });

        contentPanel.add(backButton);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        setContentPane(backgroundPanel);
    }

    private JPanel createCometPanel(Comet comet) {

        JPanel panel = new JPanel(new BorderLayout(25, 15));
        panel.setOpaque(false);
        panel.setMaximumSize(new Dimension(1100, Integer.MAX_VALUE));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel imageLabel = createImageLabel(comet.getImagePath(), 230);
        imageLabel.setVerticalAlignment(SwingConstants.TOP);
        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(comet.getName());
        nameLabel.setFont(new Font("Serif", Font.BOLD, 26));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea description = createTextArea(
                comet.getOverview() + "\n\n" +
                        "Origin:\n" + comet.getOriginInfo() + "\n\n" +
                        "Tail Information:\n" + comet.getTailInfo() + "\n\n" +
                        "Scientific Importance:\n" + comet.getScientificImportance() + "\n\n" +
                        "Interesting Facts:\n" + comet.getInterestingFacts()
        );

        description.setAlignmentX(Component.LEFT_ALIGNMENT);
        boolean isFavorite = manager.getFavoritesManager().getFavorites().contains(comet);
        JButton favoriteButton = createButton(isFavorite ? "Added to Favorites" : "Add to Favorites");
        favoriteButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        favoriteButton.addActionListener(e -> {
            if (!manager.getFavoritesManager().getFavorites().contains(comet)) {
                manager.getFavoritesManager().addFavorite(comet);
                favoriteButton.setText("Added to Favorites");
            }
        });
        textPanel.add(nameLabel);
        textPanel.add(Box.createVerticalStrut(10));
        textPanel.add(description);
        textPanel.add(Box.createVerticalStrut(15));
        textPanel.add(favoriteButton);
        panel.add(imageLabel, BorderLayout.WEST);
        panel.add(textPanel, BorderLayout.CENTER);

        return panel;
    }

    private JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Serif", Font.PLAIN, 22));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMaximumSize(new Dimension(850, Integer.MAX_VALUE));
        textArea.setPreferredSize(new Dimension(850, textArea.getPreferredSize().height));

        return textArea;
    }

    private JLabel createImageLabel(String path, int width) {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(width + 30, 180));
        label.setVerticalAlignment(SwingConstants.TOP);
        java.net.URL imageURL = getClass().getResource(path);
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);

            int originalWidth = icon.getIconWidth();

            int originalHeight = icon.getIconHeight();

            int height = originalHeight * width / originalWidth;

            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon finalIcon = new ImageIcon(scaledImage);
            label.setIcon(finalIcon);
            label.setBorder(new EmptyBorder(0, 0, 0, 20));
            label.setIcon(new ImageIcon(scaledImage));
        }

        return label;
    }

}