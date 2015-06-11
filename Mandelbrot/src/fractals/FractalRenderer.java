package fractals;

import java.awt.Canvas;

/**
 * The FractalRenderer coordinates and executes rendering events on the Fractal
 * object.
 * 
 * @author Alex Spurling
 *
 */
public class FractalRenderer implements Runnable {

	private Fractal fractal;
	private Canvas canvas;
	private int width;
	private int height;
	private long magnification = 1;
	private int iterations = 100;
	public final Object redrawLock = new Object();

	// The x and y pixel coordinates to centre on
	private int x;
	private int y;

	public FractalRenderer(Canvas canvas, Fractal fractal, int width, int height) {
		this.canvas = canvas;
		this.fractal = fractal;

		setSize(width, height);
	}

	private void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		x = width / 2;
		y = height / 2;
	}

	@Override
	public void run() {
		if (fractal.drawFractal(x, y, magnification, iterations)) {
			canvas.repaint();
		}

	}

}