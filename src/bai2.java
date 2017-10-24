/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;


public class bai2 extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	listOval liOval;
    Timer timer;
    Random rand=new Random();
    public bai2(int soLuongE, double tiLeECong, double doCong, double maxSpeed)
    {
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        liOval=new listOval();
      

        for(int i=0;i<soLuongE;i++)
            liOval.addoval(new oval(rand.nextInt(100) + 325,rand.nextInt(100) + 225, maxSpeed));
        liOval.tiLeECong = tiLeECong;
        liOval.doCong = doCong;
        liOval.maxSpeed = maxSpeed;
        timer=new Timer(10,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //timer.start();
        liOval.move();       
        repaint();      
    }
    public void paint(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(0,0 , 800, 600);       
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.GREEN);
        g2.drawOval(150, 50, 450, 450);
        liOval.paint(g);
        g2.setStroke(new BasicStroke());
        g2.setColor(Color.yellow);
        g2.fillOval(300,200 , 150, 150);
        
    }
}
