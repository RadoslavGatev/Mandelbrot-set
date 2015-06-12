package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import fractals.Fractal;

public class FractalCanvas extends Canvas {
	private Fractal fractal;

	public FractalCanvas(Fractal fractal) {
		this.fractal = fractal;
	}

	public void paint(Graphics g) {
		g.drawImage(fractal.getBufferedImage(), 0, 0, Color.red, null);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}
}