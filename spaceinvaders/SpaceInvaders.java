/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Prof. Matteo Palitto
 */

// creo un JFrame che contiene il gioco
//permette di avere la barra per il titolo e i classici pulsanti -ox
public class SpaceInvaders extends JFrame {
    // Lo spazio immenso (il Canvas incui dipingere la scena del gioco
    private Space space = new Space();

    //private Graphics graphics;

    public SpaceInvaders() throws InterruptedException {
        super("Space Invaders 101"); //diamo un titolo alla finestra di gioco
        // quando premo la X della finestra voglio terminare il gioco/programma
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // aggiungo lo spazio profondo alla finestra di gioco
        this.setResizable(false);
        setIgnoreRepaint(true);

        
        // avvia l'introduzione
        Intro intro = new Intro();
        this.add(intro);
        // impacchetto il tutto e rendi visibile
        this.pack();
        this.setVisible(true);


        intro.run();
//        this.remove(intro);
//        this.add(space);
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        new SpaceInvaders();
    }
    
}

class Space extends Canvas {

    Space() {
       System.out.println("Setting canvas background and dimentions ");

       setBackground (Color.BLACK);
       setSize(800, 600);
    }
    
}

class Intro extends Space {
    private int i = 0;
    private BufferStrategy strategy;
        
    void run() throws InterruptedException {
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        for(i=100;i>=0;i-=1) {
            System.out.println("i: " + i);
            disegna();
            Thread.sleep(10);
        }
        //Thread.sleep(100);
        for(i=0;i<10;i+=1) {
            System.out.println("i: " + i);
            disegna();
            //Thread.sleep(10);
        }
    }

    
    void disegna() {
        //chiediamo il buffer in cui comporre la nuova immagine
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        //cancelliamo l'immagine precedente coprendola con un rettangolo nero
        g.setColor(Color.black);
        g.fillRect(0,0,800,600);
         
        // scrivi nel buffer la scritta in Rosso 
        g.setColor(Color.red);
        g.setFont(new Font("Bold", Font.PLAIN, 40+i));
        g.drawString("Space Invaders", 100+i, 100+i);
        g.setFont(new Font("Bold", Font.PLAIN, 10+i));
        g.drawString("          by Matteo Palitto", 110+i+i, 110+i+i);
        //rilascia risorse create per la composizione di questa immagine
        g.dispose(); 
        //visualizza la nuova immagine sullo schermo
        strategy.show(); 
    }

}
