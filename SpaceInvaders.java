/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author lorenzo.guglielmetto
 */
public class SpaceInvaders extends JFrame{

    private Space space = new Space();
    
    public SpaceInvaders() throws InterruptedException{
        super("Space Invaders Super Figo"); //dà un titolo alla finestra
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //permette di chiudere la finestra con la "X"
        //si aggiunge la finestra dello spazio
        this.setResizable(false);
        setIgnoreRepaint(true);
        Intro intro = new Intro();
        this.add(intro);
        this.pack();
        this.setVisible(true);
        intro.avvia();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        new SpaceInvaders();
    }
    
}
