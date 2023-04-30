package tk3_no3;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Tk3_no3 extends JFrame implements ActionListener {

    private JLabel label;
    private JButton leftButton, rightButton;
    private JRadioButton redRadio, yellowRadio, blackRadio, orangeRadio, greenRadio;
    private JPanel panel;

    public Tk3_no3() {
        // Membuat objek JFrame
        super("Program GUI");

        // Membuat objek JLabel
        label = new JLabel("Programming is fun");

        // Membuat objek JRadioButton dan menambahkannya ke dalam ButtonGroup
        ButtonGroup group = new ButtonGroup();
        redRadio = new JRadioButton("Red");
        yellowRadio = new JRadioButton("Yellow");
        blackRadio = new JRadioButton("Black");
        orangeRadio = new JRadioButton("Orange");
        greenRadio = new JRadioButton("Green");
        group.add(redRadio);
        group.add(yellowRadio);
        group.add(blackRadio);
        group.add(orangeRadio);
        group.add(greenRadio);
        blackRadio.setSelected(true);

        // Membuat objek JButton
        leftButton = new JButton("<=");
        rightButton = new JButton("=>");

        // Menambahkan listener ke JButton
        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
        redRadio.addActionListener(this);
        yellowRadio.addActionListener(this);
        blackRadio.addActionListener(this);
        orangeRadio.addActionListener(this);
        greenRadio.addActionListener(this);

        // Membuat objek JPanel dan menambahkan komponen-komponennya
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(label, gbc);

        //Bagian RadioButton
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(redRadio, gbc);
        gbc.gridx = 2;
        panel.add(yellowRadio, gbc);
        gbc.gridx = 3;
        panel.add(blackRadio, gbc);
        gbc.gridx = 4;
        panel.add(greenRadio, gbc);
        gbc.gridx = 1;
        panel.add(orangeRadio, gbc);

        //Bagian Tombol Geser
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 50, 10, 50);
        panel.add(leftButton, gbc);
        gbc.gridy = 3;
        gbc.gridx = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 50, 10, 50);
        panel.add(rightButton, gbc);

        // Menambahkan komponen-komponen ke JFrame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Mengatur ukuran JFrame dan menampilkannya
        setSize(400, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Menggeser label ke kiri atau kanan dan mengubah warna
        if (e.getSource() == leftButton) {
            label.setLocation(label.getX() - 5, label.getY());
        } else if (e.getSource() == rightButton) {
            label.setLocation(label.getX() + 5, label.getY());
        } else if (e.getSource() == redRadio) {
            label.setForeground(Color.RED);
        } else if (e.getSource() == yellowRadio) {
            label.setForeground(Color.YELLOW);
        } else if (e.getSource() == blackRadio) {
            label.setForeground(Color.BLACK);
        } else if (e.getSource() == orangeRadio) {
            label.setForeground(Color.ORANGE);
        } else if (e.getSource() == greenRadio) {
            label.setForeground(Color.GREEN);
        }

        // Memastikan label tidak melebihi batas tepi kiri atau kanan
        if (label.getX() < 0) {
            label.setLocation(0, label.getY());
        } else if (label.getX() + label.getWidth() > getContentPane().getWidth()) {
            label.setLocation(getContentPane().getWidth() - label.getWidth(), label.getY());
        }
    }

    public static void main(String[] args) {
        Tk3_no3 program = new Tk3_no3();
        program.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
