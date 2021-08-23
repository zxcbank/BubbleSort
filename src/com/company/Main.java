package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel{

    int [] mass = new int[188];
    static int j;

    Main(){
        JFrame fr = new JFrame("BUBBLE");
        fr.add(this);
        fr.setBounds(0,0,1920,1080);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setVisible(true);
        for (int i = 0; i < mass.length; i++)
            mass[i] =  new Random().nextInt(975);
    }

    public static void main(String[] args) {
	    Main frame = new Main();
	    frame.bSort();

    }

    public void bSort(){
        int tmp;
        for (int i = 0; i < mass.length; i++)
            for (j = 0; j < mass.length - 1; j++) {
                if (mass[j] > mass[j + 1]){
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tmp = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = tmp;
                    repaint();
                }
            }
    }

    public void paintComponent( Graphics g ){
        super.paintComponent(g);
        g.setColor(Color.black);
        for (int i = 0; i < mass.length; i++){
            if (i == j){
                g.setColor(Color.RED);
                g.fillRect(i * 10 + 10,1000 - mass[i], 10, mass[i]);
            }
            g.fillRect(i * 10 + 10,1000 - mass[i], 10, mass[i]);
            g.setColor(Color.black);
        }


    }
}