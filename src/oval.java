/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author MyPC
 */
public class oval {
	//LinkedList<oval>Soval=new LinkedList<>();
	Color colorOval = Color.blue;
	boolean isFirstTime = true;
    Random rand=new Random();
    double a=(rand.nextInt(360))*Math.PI / 180;
    double x,y;
    double dx, dy, dx2, dy2;
    
    public  oval(double x,double y, double maxSpeed)
    
    {
    	dx2=(rand.nextInt((int)maxSpeed) + 2) * (rand.nextInt(2) == 1? 1 : -1);
        dy2=(rand.nextInt((int)maxSpeed) + 2) * (rand.nextInt(2) == 1? 1 : -1); 
        this.x=x;
        this.y=y;
    }
    public oval(){}
    
    public void paint(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.colorOval);                
        g2.fillOval((int)x, (int)y, 10, 10);      
    }
    public void move(double doCong)
    {
    	//this.colorOval = Color.red;
    	dx=cos(a)*(doCong); 
    	dy=sin(a)*(doCong);  	
        x+=dx;
        y+=dy;
        a+=(1)*Math.PI / 180;       
    }   
    public void move2() {
    	//this.colorOval = Color.black;
    	x+=dx2;
    	y+=dy2;
    }  
    public void setSpeedMove2(double maxSpeed) {
    	dx2=(rand.nextInt((int)maxSpeed) + 1) * (rand.nextInt(2) == 1? 1 : -1);
    	dy2=(rand.nextInt((int)maxSpeed) + 1) * (rand.nextInt(2) == 1? 1 : -1); 
    }
    
     public double getX()
    {return  x;}
    public double getY()
    {return y;}
}
