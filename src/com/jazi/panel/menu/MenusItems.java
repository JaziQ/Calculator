package com.jazi.panel.menu;

import javax.swing.*;

/**
 *
 *
 * @author Andreev G.A.
 */
public class MenusItems extends JFrame {
    /**
     * Создаем меню, куда входят окно об авторе, help
     *
     * @return menuBar - JMenuBar
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
            AboutFrame aboutFrame = new AboutFrame();
        });
        return about;
    }

    private JMenuItem createHelp() {
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(e -> {
            HelpFrame helpFrame = new HelpFrame();
        });
        return help;
    }
}
