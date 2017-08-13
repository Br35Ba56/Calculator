package Calculator;

/*
 * Author: Anthony Schneider
 * File: Calculator.java
 * Purpose: Builds a Calculator style GUI interface and contains main method.
 */

import java.awt.BorderLayout;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;

class Calculator {

    private JFrame frame;
    private JTextField displayTextField;
    private final StringBuilder infixExpressionBuilder = new StringBuilder();
    private final String[] buttonValues = {
            "C", "(", ")", "^",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"};

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Calculator window = new Calculator();
            window.frame.setVisible(true);
        });
    }

    private Calculator() {
        initialize();
    }

    ///////////////////////////////////////////////////////////////////////////////
    //                             GUI Initializer                               //
    ///////////////////////////////////////////////////////////////////////////////

    private void initialize() {
        //Define Frame
        frame = new JFrame();
        frame.setResizable(true);
        frame.setBounds(100, 100, 410, 460);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        //JPanel for text area
        JPanel textAreaPnl = new JPanel();
        textAreaPnl.setLayout(new BorderLayout());
        Dimension txtAreaPnlDem = new Dimension(420, 60);
        textAreaPnl.setPreferredSize(txtAreaPnlDem);
        frame.add(textAreaPnl, NORTH);

        //Define textArea 
        displayTextField = new JTextField();
        displayTextField.setEditable(false);
        Font textFont = new Font("Default", Font.BOLD, 34);
        displayTextField.setFont(textFont);
        displayTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        textAreaPnl.add(displayTextField, CENTER);

        //Define button panel
        JPanel buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(5, 4));
        frame.add(buttonPnl, CENTER);

        //Add Buttons and actions.
        for (String buttonString : buttonValues) {
            JButton button = new JButton(buttonString);
            button.setFont(new Font("Default", Font.BOLD, 24));
            buttonPnl.add(button);
            button.addActionListener(action);
        }
    }


    ///////////////////////////////////////////////////////////////////////////////
    //                              ACTION EVENTS                                //
    ///////////////////////////////////////////////////////////////////////////////

    private final AbstractAction action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonSource = (JButton) e.getSource();
            switch (buttonSource.getText()) {
                case "=":
                    evaluate();
                    break;
                case "C":
                    clear();
                    break;
                default:
                    appendText(buttonSource.getText());
                    break;
            }
        }
    };

    private void clear() {
        infixExpressionBuilder.setLength(0);
        ExpressionFormatter.clear();
        displayTextField.setText("");
    }

    private void evaluate() {
        List<String> expression = new InfixToPostfix().infixToPostfix(ExpressionFormatter
                .formatter(infixExpressionBuilder.toString()));
        Node exp = ExpressionTree.expressionTreeBuilder(expression);
        displayTextField.setText(String.valueOf(exp.evaluate()));
        infixExpressionBuilder.setLength(0);
        ExpressionFormatter.clear();
    }

    private void appendText(String input) {
        infixExpressionBuilder.append(input);
        displayTextField.setText(infixExpressionBuilder.toString());
    }
}

