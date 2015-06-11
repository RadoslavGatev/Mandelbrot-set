package mainP;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JFrame;

import org.apache.commons.cli.*;

import fractals.*;
import fractals.Mandelbrot;

public class Main {

	public static void main(String[] args) {
		Options options = new Options();
		Option output = new Option(String.valueOf(Parameters.OUTPUT.charAt(0)),
				true, "");
		output.setLongOpt(Parameters.OUTPUT);
		options.addOption(output);

		Option quiet = new Option(String.valueOf(Parameters.QUIET.charAt(0)),
				false, "");
		quiet.setLongOpt(Parameters.QUIET);
		options.addOption(quiet);

		Option rect = new Option(String.valueOf(Parameters.RECT.charAt(0)),
				true, "");
		rect.setLongOpt(Parameters.RECT);
		options.addOption(rect);

		Option size = new Option(String.valueOf(Parameters.SIZE.charAt(0)),
				true, "");
		size.setLongOpt(Parameters.SIZE);
		options.addOption(size);

		Option tasks = new Option(String.valueOf(Parameters.TASKS.charAt(0)),
				true, "");
		tasks.setLongOpt(Parameters.TASKS);
		options.addOption(tasks);

		CommandLineParser parser = new DefaultParser();
		try {

			int height = 480, width = 640;
			String fileName = "zad21.png";
			int countOfThreads = 1;
			double a[] = new double[2];
			double b[] = new double[2];
			boolean isQuiet = false;

			// parse the command line arguments
			CommandLine line = parser.parse(options, args);

			if (line.hasOption(Parameters.SIZE)) {
				String sizeDimensions = line.getOptionValue(Parameters.SIZE);
				String[] sizes = sizeDimensions.split("x");
				width = Integer.parseInt(sizes[0]);
				height = Integer.parseInt(sizes[1]);
			}

			if (line.hasOption(Parameters.RECT)) {
				String[] rectDimensions = line.getOptionValue(Parameters.RECT)
						.split(":");
				a[0] = Double.parseDouble(rectDimensions[0]);
				a[1] = Double.parseDouble(rectDimensions[1]);
				b[0] = Double.parseDouble(rectDimensions[2]);
				b[1] = Double.parseDouble(rectDimensions[3]);
			}

			if (line.hasOption(Parameters.TASKS)) {
				countOfThreads = Integer.parseInt(line
						.getOptionValue(Parameters.TASKS));
			}

			if (line.hasOption(Parameters.OUTPUT)) {
				fileName = line.getOptionValue(Parameters.OUTPUT);
			}

			if (line.hasOption(Parameters.QUIET)) {
				isQuiet = true;
			}

			// /////////

			final JFrame f = new JFrame("Mandelbrot");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			final Fractal fractal = new Mandelbrot(width, height,
					countOfThreads);
			final Canvas canvas = new FractalCanvas(fractal);

			f.getContentPane().setPreferredSize(new Dimension(width, height));

			f.getContentPane().add(canvas);
			f.setResizable(false);
			f.pack();
			f.setLocationRelativeTo(null);

			final FractalRenderer executor = new FractalRenderer(canvas,
					fractal, width, height);

			f.setVisible(true);

			Thread executorThread = new Thread(executor);
			executorThread.setDaemon(true);
			executorThread.start();

			canvas.repaint();
		} catch (ParseException exp) {
			// oops, something went wrong
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		}
	}

	@SuppressWarnings("serial")
	static class FractalCanvas extends Canvas {
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
}
