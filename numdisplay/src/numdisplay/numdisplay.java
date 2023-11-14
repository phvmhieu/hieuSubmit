/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numdisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author hieu
 */
public class numdisplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cmm c = new cmm();
        frame f = new frame();
        Th1 th1 = new Th1(f.lbl, c);
        Th2 th2 = new Th2(f.lbl, c);
        th1.start();
        th2.start();
    }

}

class frame extends JFrame {

    JLabel lbl = new JLabel();

    public frame() {
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(lbl);
        lbl.setLocation(200, 250);
    }

}

class cmm {

    int x = 0;

}

class Th1 extends Thread {

    JLabel lbl;
    cmm c;

    public Th1(JLabel lbl, cmm c) {
        this.lbl = lbl;
        this.c = c;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
            }
            synchronized (c) {

                lbl.setText("" + c.x);
                lbl.repaint();
                System.out.println("T1 - > " + c.x);
                if (c.x % 2 == 0) {
                    lbl.setForeground(Color.red);
                } else {
                    lbl.setForeground(Color.blue);
                }
                c.x++;
                i = c.x;

                c.notify();

            }

        }
    }

}

class Th2 extends Thread {

    JLabel lbl;
    cmm c;

    public Th2(JLabel lbl, cmm c) {
        this.lbl = lbl;
        this.c = c;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            synchronized (c) {
                try {
                    c.wait();
                } catch (InterruptedException e) {
                }
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(Th1.class.getName()).log(Level.SEVERE, null, ex);
                }

                lbl.setText("" + c.x);
                lbl.repaint();
                System.out.println("T2 - > " + c.x);

                if (c.x % 2 == 0) {
                    lbl.setForeground(Color.red);
                } else {
                    lbl.setForeground(Color.blue);
                }
                c.x++;
                i = c.x;

            }

        }

    }
}
