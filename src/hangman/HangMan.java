/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Carol
 */
public class HangMan {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));
        frame.add(new Board());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
    
}
