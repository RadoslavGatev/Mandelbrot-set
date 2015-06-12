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

/**
 *
 * @author Chris
 */
public class FractalUI extends javax.swing.JFrame {

	/**
	 * Creates new form FractalUI
	 */
	public FractalUI() {
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
				double a[] = new double[] { Integer.parseInt(aStart.getText()),
						Integer.parseInt(aEnd.getText()) };
				double b[] = new double[] { Integer.parseInt(bStart.getText()),
						Integer.parseInt(bEnd.getText()) };
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

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(arguments1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(22, 22, 22)
						.addComponent(arguments1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(36, Short.MAX_VALUE)));

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
