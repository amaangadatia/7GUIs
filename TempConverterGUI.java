// Amaan Gadatia
// 9/7/24
// A Java program that implements a temperature converter GUI
// between Celsius and Fahrenheit using Swing.

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TempConverterGUI {

    private JFrame frame;
    private JTextField txt_c;
    private JTextField txt_f;
    private JLabel c_label;
    private JLabel f_label;

    public TempConverterGUI() {
        frame = new JFrame();
        c_label = new JLabel("Celsius =");
        f_label = new JLabel("Fahrenheit");
        txt_c = new JTextField();
        txt_f = new JTextField();

        // Key listener for Celsius text field
        txt_c.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txt_cKeyReleased(evt);
            }
        });

        // Key listener for Fahrenheit text field
        txt_f.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txt_fKeyReleased(evt);
            }
        });

        // Setting the frame layout
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_c, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(c_label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_f, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_label)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_c, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_label)
                    .addComponent(txt_f, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_label))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        // Final frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Temperature Converter");
        frame.pack();
        frame.setVisible(true);
    }

    // Method converting temp from Celsius to Fahrenheit
    private void txt_cKeyReleased(KeyEvent evt) {                                  
        try {
            if (txt_c.getText().equals("")) {
                txt_f.setText("");
            }
            else {
                float c = Float.parseFloat(txt_c.getText());
                float f = (float)(c * 1.8 + 32);
                txt_f.setText(Float.toString(f));
            }
        } catch (Exception e) {
        }
    }

    // Method converting temp from Fahrenheit to Celsius
    private void txt_fKeyReleased(java.awt.event.KeyEvent evt) {                                  
        try {
            if (txt_f.getText().equals("")) {
                txt_c.setText("");
            }
            else {
                float f = Float.parseFloat(txt_f.getText());
                float c = (float)((f - 32) / 1.8);
                txt_c.setText(Float.toString(c));
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new TempConverterGUI();
    }
}
