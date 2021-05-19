package com.jazi.panel;

import com.jazi.Calculator;
import com.jazi.panel.menu.MenusItems;
import com.jazi.valitators.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * A <code>MainPanel</code> extends of <code>JFrame</code>
 * Creates a calculator window, adds an input field, menus item, button with numeric and calculation operator
 *
 * @author Andreev G.A.
 */
public class MainFrame extends JFrame {
    private final JFrame window = new JFrame("Calculator");
    private final JTextField input = new JTextField();

    /**
     * Creates a new <code>MainPanel</code>
     */
    public MainFrame() {
        MenusItems menusItems = new MenusItems();
        window.setSize(300, 435);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        window.setJMenuBar(menusItems.createJMenu());
        enterArea();
        monthButton();
        pack();
    }

    /**
     * return instance of JFrame to use in the other class
     * @return window - JFrame
     */
    protected JFrame getWindow() {
        return window;
    }

    private void enterArea() {
        input.setFont(new Font("Arial", Font.BOLD, 24));
        input.setBounds(16, 10, 248, 36);
        input.setBackground(Color.white);
        input.setHorizontalAlignment(JTextField.RIGHT);
        //input.setEditable(false);
        window.add(input);

        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
                    result();
                }

                if (e.getKeyChar() == '='){
                    Timer timer = new Timer(25,(a) -> input.setText(input.getText().substring(0, input.getText().length() - 1)));
                    timer.setRepeats(false);
                    timer.start();
                    result();
                }

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    input.setText("");
                }
                window.repaint();
            }
        });
    }


    private void monthButton() {
        int num = 0;
        String[] arr = {"1", "2", "3", "С", "4", "5", "6", " * ", "7", "8", "9", " - ", "0", ".", " + ", " / ", "( ", " )", "="};
        JButton[] jButton = new JButton[arr.length];

        for (int e = 0; e < 5; e++) {
            for (int r = 0; r < 4; r++) {
                jButton[num] = new JButton();
                jButton[num].setFont(new Font("Arial", Font.PLAIN, 36));
                jButton[num].setText(arr[num]);
                jButton[num].setMargin(new Insets(0, 0, 0, 0));
                if (num < arr.length - 1) {
                    jButton[num].setBounds(16 + r * 62, 55 + e * 62, 60, 60);
                } else {
                    jButton[num].setBounds(16 + r * 62, 55 + e * 62, 122, 60);
                }
                jButton[num].setFocusable(false);

                window.add(jButton[num]);

                ActionListener numButton = new GoNumListener();
                jButton[num].addActionListener(numButton);

                if (num < arr.length - 1) {
                    num++;
                } else {
                    break;
                }
            }
        }
    }


    private class GoNumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getText();
            if (!name.equals("=") && !name.equals("С")) {
                input.setText(input.getText() + name);
            }
            if (name.equals("=")) {
                result();
            }

            if (name.equals("С")) {
                input.setText("");
            }
            window.repaint();
        }
    }


/*    private void result() {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            input.setText("" + engine.eval(input.getText()));
        } catch (ScriptException e1) {
            out.println(e1.getMessage());
        }
    }*/

    private void result() {
        boolean haveLetter = Validator.haveLetterValidation(input.getText());
        boolean noOperator = Validator.noOperatorValidation(input.getText());
        try {
            if (haveLetter){
                throw new ArithmeticException("Letter in the text field");
            }
            if (noOperator){
                throw new ArithmeticException("No Operator");
            }
            input.setText(" " + Calculator.eval(input.getText()));

        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this.window, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.window, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
