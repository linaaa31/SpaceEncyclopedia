package spaceencyclopedia.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Objects;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import spaceencyclopedia.core.Star;
import spaceencyclopedia.manager.EncyclopediaManager;

public class MainMenuPage extends BasePage {

    private EncyclopediaManager manager;
    private JLabel title;
    private JButton planetsButton;
    private JButton moonsButton;
    private JButton starsButton;
    private JButton asteroidsButton;
    private JButton cometsButton;
    private JButton nebulaeButton;
    private JButton favoritesButton;
    private JButton searchButton;

    public MainMenuPage(EncyclopediaManager manager) {
        super("Solar System Menu");
        this.manager = manager;
        BackgroundPanel panel = new BackgroundPanel("/spaceencyclopedia/images/img.png");
        panel.setLayout(new GridBagLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        title = createLabel("SOLAR SYSTEM MENU", 40, Font.BOLD);
        planetsButton = createButton("Planets");
        moonsButton = createButton("Satellites");
        starsButton = createButton("Star");
        asteroidsButton = createButton("Asteroids");
        cometsButton = createButton("Comets");
        nebulaeButton = createButton("Nebulae");
        favoritesButton = createButton("Favorites");
        searchButton = createButton("Search");
        makeDarkButton(favoritesButton);
        makeDarkButton(searchButton);
        planetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new PlanetsPage(manager).setVisible(true);
                dispose();
            }
        });

        moonsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new SatellitesPage(manager).setVisible(true);
                dispose();
            }
        });

        Star star = (Star) manager.searchByName("Sun");

        starsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new StarDetailsPage(star, manager).setVisible(true);
                dispose();
            }
        });

        asteroidsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new AsteroidsPage(manager).setVisible(true);
                dispose();
            }
        });

        cometsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new CometsPage(manager).setVisible(true);
                dispose();
            }
        });

        nebulaeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new NebulaePage(manager).setVisible(true);
                dispose();
            }
        });

        favoritesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new FavoritesPage(manager).setVisible(true);
                dispose();
            }
        });

        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new SearchPage(manager).setVisible(true);
                dispose();
            }
        });

        JPanel gridPanel = new JPanel();
        gridPanel.setOpaque(false);
        gridPanel.setLayout(new GridLayout(4, 2, 20, 15));

        gridPanel.add(planetsButton);
        gridPanel.add(moonsButton);
        gridPanel.add(starsButton);
        gridPanel.add(asteroidsButton);
        gridPanel.add(cometsButton);
        gridPanel.add(nebulaeButton);
        gridPanel.add(favoritesButton);
        gridPanel.add(searchButton);

        menuPanel.add(title);
        menuPanel.add(Box.createVerticalStrut(40));
        menuPanel.add(gridPanel);

        panel.add(menuPanel);
        add(panel);

        addComponentListener(new ComponentAdapter() {
            {
                Objects.requireNonNull(MainMenuPage.this);
            }

            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });

        resizeComponents();
    }

    private void makeDarkButton(JButton button) {
        button.setBackground(new Color(5, 10, 35));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    private void resizeComponents() {
        int width = getWidth();

        title.setFont(new Font("Serif", Font.BOLD, width / 18));

        Font normalButtonFont = new Font("Arial", Font.BOLD, width / 50);

        JButton[] buttons = new JButton[]{
                planetsButton, moonsButton, starsButton, asteroidsButton,
                cometsButton, nebulaeButton, favoritesButton, searchButton
        };

        for (JButton button : buttons) {
            button.setFont(normalButtonFont);
            button.setPreferredSize(new Dimension(width / 4, width / 18));
        }

        revalidate();
        repaint();
    }
}