package org.example.GUI;

import org.example.Logic.Operation;
import org.example.Models.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PolynomialCalculatorUI extends JFrame {
    private final JTextField polynomial1Field;
    private final JTextField polynomial2Field;
    private JTextField resultField;

    public PolynomialCalculatorUI() {
        setTitle("Polynomial Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        polynomial1Field = new JTextField();
        polynomial2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JLabel polynomial1Label = new JLabel("Polynomial 1:");
        JLabel polynomial2Label = new JLabel("Polynomial 2:");
        JLabel resultLabel = new JLabel("Result:");

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('+');
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('-');
            }
        });

        add(polynomial1Label);
        add(polynomial1Field);
        add(polynomial2Label);
        add(polynomial2Field);
        add(addButton);
        add(subtractButton);
        add(resultLabel);
        add(resultField);
    }

    private void performOperation(char operator) {
        String polynomial1Text = polynomial1Field.getText().trim();
        String polynomial2Text = polynomial2Field.getText().trim();

        Polynomial polynomial1 = parsePolynomial(polynomial1Text);
        Polynomial polynomial2 = parsePolynomial(polynomial2Text);

        Operation operation = new Operation();
        Polynomial result; // Change the type of result to Polynomial

        if (operator == '+') {
            result = operation.add(polynomial1, polynomial2);
        } else {
            result = operation.subtract(polynomial1, polynomial2);
        }

        // Display the result in the result field
        resultField.setText("(" + polynomial1Text + ") " + operator +
                " (" + polynomial2Text + ") = " + result.toString());
    }
    private Polynomial parsePolynomial(String polynomialText) {
        Polynomial polynomial = new Polynomial();

        System.out.println("Input polynomial text: " + polynomialText);

        String[] terms = polynomialText.split("\\s*(?=[+-])");

        for (String term : terms) {
            System.out.println("Term: " + term);
            String[] parts = term.split("x\\^?");
            double coefficient;
            int exponent;

            if (parts.length == 0) continue;

            if (parts.length == 1) {
                // Term is constant or linear
                if (term.contains("x")) {
                    // Linear term
                    if (term.equals("x")) {
                        coefficient = 1.0;
                    } else if (term.equals("-x")) {
                        coefficient = -1.0;
                    } else {
                        coefficient = Double.parseDouble(term.substring(0, term.indexOf("x")));
                    }
                    exponent = 1;
                } else {
                    // Constant term
                    coefficient = Double.parseDouble(parts[0]);
                    exponent = 0;
                }
            } else if (parts.length == 2 && parts[0].isEmpty()) {
                coefficient = 1.0;
                exponent = Integer.parseInt(parts[1]);
            } else {
                coefficient = Double.parseDouble(parts[0]);
                if (parts[0].equals("-")) {
                    coefficient = -1.0;
                }
                exponent = Integer.parseInt(parts[1]);
            }

            System.out.println("Coefficient: " + coefficient + ", Exponent: " + exponent);
            polynomial.addTerm(exponent, coefficient);
        }

        return polynomial;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PolynomialCalculatorUI().setVisible(true);


            }
        });
    }
}
