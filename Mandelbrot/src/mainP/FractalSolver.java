package mainP;

import java.awt.image.BufferedImage;
import java.util.Observable;

public final class FractalSolver extends Observable {
	private final int MAX_ITER = 500;
	private int cnt = 0;
	private final double ZOOM = 150;
	private BufferedImage image;
	private double zx, zy, cX, cY, tmp;

	private int height, width, countOfThreads;
	private double[] a, b;

	public FractalSolver(int height, int width, double[] a, double[] b,
			int countOfThreads) {
		this.height = height;
		this.width = width;
		this.a = a;
		this.b = b;
		this.countOfThreads = countOfThreads;
		
		this.image=new BufferedImage(width, height, )
	}

	public void startComputing() {

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				zx = zy = 0;
				cX = (j - width) / ZOOM;
				cY = (i - height) / ZOOM;
				int iter = MAX_ITER;

				while (zx * zx + zy * zy < 4 && iter > 0) {
					tmp = zx * zx - zy * zy + cX;
					zy = 2.0 * zx * zy + cY;
					zx = tmp;
					iter--;
				}
				image.setRGB(j, i, iter | (iter << 4));

			}
		}

		// setChanged();
		// notifyObservers(bufferedImage);
	}

}
