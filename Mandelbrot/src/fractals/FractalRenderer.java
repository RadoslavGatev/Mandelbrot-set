package fractals;

import java.awt.Canvas;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.MandelbrotFrame;

/**
 * The FractalRenderer coordinates and executes rendering events on the Fractal
 * object.
 *
 */
public class FractalRenderer implements Runnable {

	private Fractal fractal;
	private int width;
	private int height;
	private long magnification = 2;
	private int iterations = 70;

	// The x and y pixel coordinates to centre on
	private int x;
	private int y;

	private String fileName;
	private boolean isQuiet;
	double[] a, b;

	public FractalRenderer(int width, int height, double[] a, double[] b,
			String fileName, int countOfThreads, boolean isQuiet) {
		if (fileName == null) {
			throw new IllegalArgumentException(
					"The fileName argument must not be equal to null");
		}
		this.fractal = new Mandelbrot(width, height, countOfThreads);
		this.isQuiet = isQuiet;
		this.fileName = fileName;
		this.a = a;
		this.b = b;

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
			File outputfile = new File(fileName);
			try {
				ImageIO.write(fractal.getBufferedImage(), "png", outputfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (!isQuiet) {
				MandelbrotFrame mandelbrotFrame = new MandelbrotFrame(fractal);
				mandelbrotFrame.getCanvas().repaint();
				mandelbrotFrame.setVisible(true);
			}
		}

	}
}