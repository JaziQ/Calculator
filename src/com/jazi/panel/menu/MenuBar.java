package com.jazi.panel.menu;

import javax.swing.*;

/**
 * Class for adding <code>MenuBar</code> in <code>MainFrame</code>
 *
 * @author Andreev G.A.
 */
public class MenuBar extends JFrame {
    /**
     * Create a new <code>MenuBar</code>
     * Add item <code>AboutMenuItem</code> and <code>HelpMenuItem</code> in <code>MenuBar</code>
     *
     * @return <code>JMenuBar</code> menuBar - for use in <code>MainFrame</code>
     */
    public JMenuBar createJMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
        return menuBar;
    }

    private JMenu createFileMenu(){
        JMenu file = new JMenu("Menu");
        file.add(createAbout());
        file.add(createHelp());
        return file;
    }

    private JMenuItem createAbout() {
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(e -> {
            AboutMenuItem aboutMenuItem = new AboutMenuItem();
        });
        return about;
    }

    private JMenuItem createHelp() {
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(e -> {
            HelpMenuItem helpMenuItem = new HelpMenuItem();
        });
        return help;
    }
}
