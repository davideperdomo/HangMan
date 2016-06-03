/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Carol
 */
public class Board extends JPanel implements ActionListener,KeyListener{
    private Timer timer;
    private int delay;
    private int x;
    private int dx;
    private int y;
    private int dy;
    private boolean dxmax;
    private boolean dxmin;
    private boolean ymax;
    private boolean ymin;
    public Board(){
        this.setFocusable(true);
        this.addKeyListener(this);
        this.dx=200;
        this.dy=100;
        this.dxmax=false;
        this.dxmin=false;
        this.ymax=false;
        this.ymin=false;
        this.delay=500;
        this.timer=new Timer(2,this);
        this.timer.start();       
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //estaticos
        g.drawOval(20,300,80,30);
        g.drawLine(60,300,60,70);
        g.drawLine(60,70,250,70);
        
        g.drawLine(250,70,dx,dy);
        g.drawOval(dx-25, dy, 50, 50);
        g.drawLine(dx,dy+50,dx-25,dy+75);
        g.drawLine(dx,dy+50,dx+25,dy+75);
        
        g.drawLine(dx,dy+50,dx,dy+150);
        g.drawLine(dx,dy+150,dx+25,dy+175);
        g.drawLine(dx,dy+150,dx-25,dy+175);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(dx==300){dxmax=true;dxmin=false;}
        if(!dxmax&&dxmin){dx+=10;}
        if(!dxmin&&dxmax){dx-=10;}
        if(dx==200){dxmin=true;dxmax=false;}
        
        if(dy==130){ymax=true;ymin=false;}
        if(!ymax&&ymin){dy+=6;}
        if(!ymin&&ymax){dy-=6;}
        if(dy==100){ymin=true;ymax=false;}
        
        repaint();
        
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    int k=e.getKeyCode();
        if(k==KeyEvent.VK_UP){if(delay>0){delay-=50;}System.out.println("UP");}
        if(k==KeyEvent.VK_DOWN){delay+=50;System.out.println("down");}
        if(k==KeyEvent.VK_S){timer.stop();}
        if(k==KeyEvent.VK_R){timer.start();}
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
