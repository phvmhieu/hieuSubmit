/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.circle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author hieu
 */
public class Mycanvas extends Canvas {
    private Color color = Color.GRAY;
    public Mycanvas() {
        setBackground (Color.gray);
        setSize(300,300);
    }
    public void setColor(Color color){
        this.color = color;
    }
    //@Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        g.setColor(color);
        g.fillOval(100, 75, 100, 100);
    }
    
}
