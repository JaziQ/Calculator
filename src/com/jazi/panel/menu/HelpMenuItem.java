package com.jazi.panel.menu;

import javax.swing.*;
import java.awt.*;

/**
 * Class for adding <code>HelpMenuItem</code> in <code>MenuBar</code>
 * Contains information on how to use the program
 *
 * @author Andreev G.A.
 */
public class HelpMenuItem extends JDialog {

    /**
     * Create a new <code>HelpMenuItem</code>
     * Add a help information on the <code>JPanel</code>
     */
    public HelpMenuItem() {
        setTitle("Help");
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS));
        setLayout(new BorderLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> dispose());
        addHelpLabel(helpPanel);
        add(helpPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
        pack();
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addHelpLabel(JPanel helpLabel) {
        JLabel authorLabel = new JLabel("<html><center><h2>"
                + "The program supports such operators as division,<br>" +
                " multiplication, subtraction. You can also use brackets.<br><br>" +
                " ATTENTION: to use the calculator, you must insert<br>" +
                " a space before and after operators and brackets.<br></h2></center></html>");
        helpLabel.add(authorLabel);
    }


}
