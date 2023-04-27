package com.temperatureconverterapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame implements ActionListener {

    JButton btnConvert1;
    JButton btnConvert2;
    JButton btnExit;
    JButton btnClear;
    JButton btnSwap;
    JTextField textCelsius;
    JTextField textFahrenheit;
    JPanel bottomPanel;
    JPanel topPanel;
    JPanel centerPanel;

    AppFrame(){
        ImageIcon image = new ImageIcon("resources/images/icon-temperature.png");
        this.setIconImage(image.getImage());

        JLabel imgLabel = new JLabel();
        imgLabel.setText("Temperature Converter App");
        imgLabel.setIcon(image);
        imgLabel.setHorizontalTextPosition(JLabel.CENTER);
        imgLabel.setVerticalTextPosition(JLabel.TOP);
        imgLabel.setForeground(new Color(172, 176, 191));
        imgLabel.setFont(new Font("calibri", Font.PLAIN, 30));
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setVerticalAlignment(JLabel.TOP);

        //buttons
        btnConvert1 = new JButton();
        btnConvert1.setText("C° to F°");
        btnConvert1.setPreferredSize(new Dimension(80,30));
        btnConvert1.addActionListener(this);
        btnConvert2 = new JButton();
        btnConvert2.setText("F° to C°");
        btnConvert2.setPreferredSize(new Dimension(80,30));
        btnConvert2.addActionListener(this);
        btnClear = new JButton();
        btnClear.setText("Clear");
        btnClear.setPreferredSize(new Dimension(80,30));
        btnClear.addActionListener(this);
        btnExit = new JButton();
        btnExit.setText("Exit");
        btnExit.setPreferredSize(new Dimension(80,30));
        btnExit.addActionListener(this);
        btnSwap = new JButton();

        //textFields
        textCelsius = new JTextField();
        //textCelsius.setText("Celsius");
        textCelsius.setFont(new Font("calibri",Font.BOLD,15));
        textCelsius.setPreferredSize(new Dimension(80,30));
        textFahrenheit = new JTextField();
        //textFahrenheit.setText("Fahrenheit");
        textFahrenheit.setFont(new Font("calibri",Font.BOLD,15));
        textFahrenheit.setPreferredSize(new Dimension(80,30));

        //panels
        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        topPanel.add(imgLabel);
        topPanel.setBackground(new Color(80, 81, 87));

        centerPanel.setBackground(new Color(80, 81, 87));
        centerPanel.add(btnConvert1);
        centerPanel.add(btnConvert2);
        centerPanel.add(btnExit);

        bottomPanel.setBackground(new Color(80, 81, 87));
        bottomPanel.add(btnClear);
        bottomPanel.add(textCelsius);
        bottomPanel.add(textFahrenheit);

        // Frame
        this.setTitle("Temperature Converter App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLayout(new BorderLayout());
        //this.getContentPane().setBackground(new Color(80, 81, 87));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // exit
        if (e.getSource().equals(btnExit)){
            System.exit(0);
        }
        // clear textFields
        if (e.getSource().equals(btnClear)){
            textCelsius.setText("");
            textFahrenheit.setText("");
        }
        // convert celsius to fahrenheit
        if (e.getSource().equals(btnConvert1)){
            double inpCelsius = Double.parseDouble(textCelsius.getText());
            String inp = String.valueOf(CelsiusToFahrenheit(inpCelsius));
            textFahrenheit.setText(inp);
        }
        // convert fahrenheit to celsius
        if (e.getSource().equals(btnConvert2)){
            double inpCelsius = Double.parseDouble(textCelsius.getText());
            String inp = String.valueOf(FahrenheitToCelsius(inpCelsius));
            textFahrenheit.setText(inp);
        }
    }

    public double CelsiusToFahrenheit(double celsius){
        return celsius * 1.8 + 32;
    }

    public double FahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - 32) * 0.5556;
    }

}
