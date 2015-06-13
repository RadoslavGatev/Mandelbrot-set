/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import fractals.FractalRenderer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Window.Type;

/**
 *
 * @author Chris
 */
public class FractalUI extends javax.swing.JFrame {

	/**
	 * Creates new form FractalUI
	 */
	public FractalUI() {
		setResizable(false);
		initComponents();
		generate = arguments1.getGenerateButton();
		sizeW = arguments1.getWidthField();
		sizeH = arguments1.getHeightField();
		aStart = arguments1.getaStartField();
		aEnd = arguments1.getaEndField();
		bStart = arguments1.getbStartField();
		bEnd = arguments1.getbEndField();
		fileName = arguments1.getNameField();
		tasks = arguments1.getThreadsField();
		initButton();
	}

	private void initButton() {
		generate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				int height = Integer.parseInt(sizeH.getText());
				int width = Integer.parseInt(sizeW.getText());
				double a[] = new double[] {
						Double.parseDouble(aStart.getText()),
						Double.parseDouble(aEnd.getText()) };
				double b[] = new double[] {
						Double.parseDouble(bStart.getText()),
						Double.parseDouble(bEnd.getText()) };
				String name = fileName.getText();
				int countOfThreads = Integer.parseInt(tasks.getText());

				final FractalRenderer executor = new FractalRenderer(width,
						height, a, b, name, countOfThreads, false);

				Thread executorThread = new Thread(executor);
				executorThread.start();
			}
		});
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		arguments1 = new Arguments();
		arguments1.getFilenameField().setText("zad21.png");
		arguments1.getNameField().setText("1");
		arguments1.getbEndField().setText("2");
		arguments1.getbStartField().setText("-2");
		arguments1.getaEndField().setText("2");
		arguments1.getaStartField().setText("-2");
		arguments1.getHeightField().setText("480");
		arguments1.getWidthField().setText("640");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(arguments1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(arguments1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private Arguments arguments1;
	// End of variables declaration//GEN-END:variables
	private JButton generate;
	private JTextField sizeW;
	private JTextField sizeH;
	private JTextField aStart;
	private JTextField aEnd;
	private JTextField bStart;
	private JTextField bEnd;
	private JTextField fileName;
	private JTextField tasks;
}
