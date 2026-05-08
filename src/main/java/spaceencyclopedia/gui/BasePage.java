package spaceencyclopedia.gui;

import javax.swing.*;
import java.awt.*;

public abstract class BasePage extends JFrame {
    public BasePage(String title) {
        setTitle(title);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    protected JLabel createLabel(String text, int size, int style) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Serif", style, size));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    protected JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}