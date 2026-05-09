package spaceencyclopedia.gui;

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
import spaceencyclopedia.manager.EncyclopediaManager;

public class MainMenuPage extends BasePage {
    private EncyclopediaManager manager;
    private JLabel title;
    private JButton planetsButton;
    private JButton dwarfPlanetsButton;
    private JButton moonsButton;
    private JButton starsButton;
    private JButton asteroidsButton;
    private JButton cometsButton;
    private JButton blackHolesButton;
    private JButton nebulaeButton;
    private JButton funFactsButton;
    private JButton favoritesButton;
    private JButton searchButton;

    public MainMenuPage() {
        super("Milky Way Menu");
        this.manager = new EncyclopediaManager();
        manager.loadSampleData();
        BackgroundPanel panel =
                new BackgroundPanel("/spaceencyclopedia/images/img.png");
        panel.setLayout(new GridBagLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, 1));
        this.title = this.createLabel("MILKY WAY MENU", 40, 1);
        this.planetsButton = this.createButton("Planets");
        this.planetsButton.addActionListener(e -> {
            new PlanetsPage(manager).setVisible(true);
            dispose();
        });

        this.dwarfPlanetsButton = this.createButton("Dwarf Planets");
        this.dwarfPlanetsButton = this.createButton("Dwarf Planets");
        this.moonsButton = this.createButton("Moons");
        this.starsButton = this.createButton("Stars");
        this.asteroidsButton = this.createButton("Asteroids");
        this.cometsButton = this.createButton("Comets");
        this.blackHolesButton = this.createButton("Black Holes");
        this.nebulaeButton = this.createButton("Nebulae");
        this.funFactsButton = this.createButton("Fun Facts");
        this.favoritesButton = this.createButton("Favorites");
        this.searchButton = this.createButton("Search");
        this.asteroidsButton = this.createButton("Asteroids");

        this.asteroidsButton.addActionListener(e -> {
            new AsteroidsPage(manager).setVisible(true);
            dispose();
        });
        JPanel gridPanel = new JPanel();
        gridPanel.setOpaque(false);
        gridPanel.setLayout(new GridLayout(5, 2, 20, 15));
        gridPanel.add(this.dwarfPlanetsButton);
        gridPanel.add(this.moonsButton);
        gridPanel.add(this.starsButton);
        gridPanel.add(this.asteroidsButton);
        gridPanel.add(this.cometsButton);
        gridPanel.add(this.blackHolesButton);
        gridPanel.add(this.nebulaeButton);
        gridPanel.add(this.funFactsButton);
        gridPanel.add(this.favoritesButton);
        gridPanel.add(this.searchButton);
        this.planetsButton.setAlignmentX(0.5F);
        menuPanel.add(this.title);
        menuPanel.add(Box.createVerticalStrut(30));
        menuPanel.add(this.planetsButton);
        menuPanel.add(Box.createVerticalStrut(25));
        menuPanel.add(gridPanel);
        panel.add(menuPanel);
        this.add(panel);
        this.addComponentListener(new ComponentAdapter() {
            {
                Objects.requireNonNull(MainMenuPage.this);
            }

            public void componentResized(ComponentEvent e) {
                MainMenuPage.this.resizeComponents();
            }
        });
        this.resizeComponents();
    }

    private void resizeComponents() {
        int width = this.getWidth();
        this.title.setFont(new Font("Serif", 1, width / 18));
        new Font("Arial", 1, width / 35);
        Font normalButtonFont = new Font("Arial", 1, width / 50);
        this.planetsButton.setFont(normalButtonFont);
        this.planetsButton.setPreferredSize(new Dimension(this.getWidth() - 350,
                this.getHeight() / 10));
        this.planetsButton.setMaximumSize(new Dimension(this.getWidth() - 350,
                this.getHeight() / 10));
        this.planetsButton.setMinimumSize(new Dimension(300, 60));
        JButton[] buttons = new JButton[]{this.dwarfPlanetsButton, this.moonsButton,
                this.starsButton, this.asteroidsButton, this.cometsButton, this.blackHolesButton,
                this.nebulaeButton, this.funFactsButton, this.favoritesButton, this.searchButton};

        for(JButton button : buttons) {
            button.setFont(normalButtonFont);
            button.setPreferredSize(new Dimension(width / 4, width / 18));
        }

        this.revalidate();
        this.repaint();
    }
}