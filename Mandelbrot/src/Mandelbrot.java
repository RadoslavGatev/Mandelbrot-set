package Frames;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Mandelbrot extends JFrame {
	
	
	private final int MAX_ITER = 500;
	private int cnt  = 0;
	private final double ZOOM = 150;
	private BufferedImage I;
	private double zx, zy, cX, cY, tmp;
	
	public Mandelbrot() { 
		setBounds(100,100,800,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	}
	
	public void start() { 
		
		for( int i =0; i < getHeight(); i++){
			for(int j = 0; j < getWidth(); j++){
				zx = zy = 0;
				cX = ( j - 500) /  ZOOM;
				cY = ( i - 400) / ZOOM;
				int iter = MAX_ITER;
		
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                I.setRGB(j, i, iter | (iter <<1));
				
			}
		}
		
	}
	
	 
    @Override
    public void paint(Graphics g) {
    	System.out.println(cnt++);
        g.drawImage(I, 0, 0, this);
    }
    
    public static void main( String[] args){
    	Mandelbrot frame = new Mandelbrot();
    	frame.setVisible(true);
    	frame.start();
    }
	
}
