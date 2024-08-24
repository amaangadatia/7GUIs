// Amaan Gadatia
// 8/22/24
// A Java program that implements a counter GUI using Swing. Includes increment and reset buttons.


import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterGUI implements ActionListener {

    private int count = 0;
    private JTextField textField;
    private JFrame frame;
    private JPanel panel;
    private JButton countButton;
    private JButton resetButton;
    
    public CounterGUI() {
        frame = new JFrame();

        // creates an increment button
        countButton = new JButton("Count");
        countButton.addActionListener(this);

        // creates a button to reset the counter
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        // Create the text field and set it to read-only
        textField = new JTextField(5);
        textField.setText("0");
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);

        // Create panel and set layout
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panel.setLayout(new BorderLayout());
        panel.add(textField, BorderLayout.WEST);

        // Create a button panel to hold the Count and Reset buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(countButton);
        buttonPanel.add(resetButton);

        // Add the button panel to the center of the main panel
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Counter");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new CounterGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if the increment button is clicked
        if (e.getSource() == countButton) {
            count++;
            textField.setText(String.valueOf(count));
        }
        // if the reset button is clicked
        else if (e.getSource() == resetButton) {
            count = 0;
            textField.setText(String.valueOf(count));
        }
    }
}
