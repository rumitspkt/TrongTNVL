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
import java.util.Date;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;


public class bai2 extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	Date currentTime;
    long s1, s2;
	listOval liOval, liOval2, liOval3;
    Timer timer;
    Random rand=new Random();
    public bai2(int soLuongE, double tiLeECong, double doCong, double maxSpeed)
    {
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        liOval=new listOval();
        liOval2=new listOval();
        liOval3=new listOval();

        for(int i=0;i<soLuongE/3;i++)
            liOval.addoval(new oval(rand.nextInt(100) + 325,rand.nextInt(100) + 225, maxSpeed));
        for(int i=0;i<soLuongE/3;i++)
            liOval2.addoval(new oval(rand.nextInt(100) + 325,rand.nextInt(100) + 225, maxSpeed));
        for(int i=0;i<soLuongE/3;i++)
            liOval3.addoval(new oval(rand.nextInt(100) + 325,rand.nextInt(100) + 225, maxSpeed));
        listOval.tiLeECong = tiLeECong;
        listOval.doCong = doCong;
        listOval.maxSpeed = maxSpeed;        
        timer=new Timer(10,this);
        currentTime = new Date();
        s1 = currentTime.getTime();
        //System.out.println("s1 = " + s1);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //timer.start();
        liOval.move();
        currentTime = new Date();
        s2 = currentTime.getTime();
        //System.out.println("s2 = " + s2);
        if(s2 - s1 >= 1000) {
        	System.out.println("debug");
        	liOval2.move();
        }
        if(s2 - s1 >= 2000) {
        	System.out.println("debug");
        	liOval3.move();
        }
        repaint();      
    }
    public void paint(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(0,0 , 800, 600);       
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawOval(150, 50, 450, 450);
        liOval.paint(g);
        liOval2.paint(g);
        liOval3.paint(g);
        g2.setStroke(new BasicStroke());
        g2.setColor(Color.BLACK);
        g2.fillOval(300,200 , 150, 150);
        
    }
}
