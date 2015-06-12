package GUI;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import fractals.Fractal;

@SuppressWarnings("serial")
public class MandelbrotFrame extends JFrame {
	private final Canvas canvas;

	public MandelbrotFrame(Fractal fractal) {
		super("Mandelbrot");
		canvas = new FractalCanvas(fractal);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.getContentPane().setPreferredSize(
				new Dimension(fractal.getWidth(), fractal.getHeight()));

		this.getContentPane().add(canvas);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public Canvas getCanvas() {
		return canvas;
	}
}
