package Frames;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


import javax.swing.JFrame;

public class Mandelbrot extends JFrame {
	
	
	
	
	public Mandelbrot() { 
		//setBounds(100,100,800,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	}
		
	 
    @Override
    public void paint(Graphics g) {
//    	System.out.println(cnt++);
        //g.drawImage(I, 0, 0, this);
    }
   
	
}
