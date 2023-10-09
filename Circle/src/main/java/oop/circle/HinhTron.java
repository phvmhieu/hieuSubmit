/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.circle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author hieu
 */
public class HinhTron extends JFrame {
    private JComboBox<String> colorComboBox ;
    private Mycanvas canvas;
    private JPanel panel = new JPanel();
    private JLabel label1 = new JLabel("select color");
    
    public HinhTron(){
        setLayout(new FlowLayout());
        this.setTitle("HINH TRON");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        canvas = new Mycanvas();
        this.add(canvas);
        this.add(label1); label1.setVisible(true);
        this.add(panel); panel.add(label1);
        String[] choice = {"red", "blue", "green"};
        colorComboBox = new JComboBox<>(choice);
        colorComboBox.setVisible(true);
        panel.add(colorComboBox);
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                canvas.setColor(getSelectColor());
                canvas.repaint();
            }
            
        });
        this.pack();
    }
    private Color getSelectColor (){
        String color = (String) colorComboBox.getSelectedItem();
        switch(color){
            case"red":
                return Color.RED;
            case"blue":
                return Color.BLUE;
            case"green":
                return Color.GREEN;
            default:
                return Color.BLACK;
        }
    }
    
}
