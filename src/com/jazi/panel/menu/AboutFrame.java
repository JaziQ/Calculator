package com.jazi.panel.menu;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import static java.awt.Image.SCALE_FAST;

public class AboutFrame extends JDialog {
    public AboutFrame() {
        setTitle("About Author");
        JPanel aboutLabel = new JPanel();
        aboutLabel.setLayout(new BoxLayout(aboutLabel, BoxLayout.Y_AXIS));
        setLayout(new BorderLayout());
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> dispose());
        addImageLabel(aboutLabel);
        addAboutAuthorLabel(aboutLabel);
        add(aboutLabel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
        pack();
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addImageLabel(JPanel jPanel) {
        ClassLoader loader = getClass().getClassLoader();
        URL url = loader.getResource("image/Author.jpg");
        if (url == null) {
            return;
        }
        Image image = new ImageIcon(url).getImage();
        Image scaledImage = image.getScaledInstance(250, 350, SCALE_FAST);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);
        jPanel.add(imageLabel);
    }

    private void addAboutAuthorLabel(JPanel jPanel) {
        JLabel authorLabel = new JLabel("<html><center><h2>"
                + "Author:<br>"
                + "student group of 10702418<br>"
                + "Andreev Gleb Alexandrovich<br>"
                + "gleb_andreev01@mail.ru<br></h2></center></html>");
        authorLabel.setAlignmentX(CENTER_ALIGNMENT);
        jPanel.add(authorLabel);
    }

}
