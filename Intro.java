/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

/**
 *
 * @author lorenzo.guglielmetto
 */
public class Intro extends Space{
    
    private int i = 0;
    private BufferStrategy strategy;
    
    public void avvia() throws InterruptedException{
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        for(i=100;i>=10;i-=1) {
            System.out.println("i: " + i);
            disegna();
            Thread.sleep(10);
        }
    }
    
    public void disegna(){
        Graphics2D grafica = (Graphics2D) strategy.getDrawGraphics();
        grafica.setColor(Color.black);
        grafica.fillRect(0,0,800,500);
        grafica.setColor(Color.GREEN);
        grafica.setFont(new Font("Bold", Font.HANGING_BASELINE, 40+i));
        grafica.drawString("SPACE INVADERS", 100+i, 100+i);
        grafica.setFont(new Font("Bold", Font.PLAIN, 10+i));
        grafica.drawString("      developed by DickBoss", 110+i+i, 110+i+i);
        grafica.dispose();
        strategy.show();
    }
}
