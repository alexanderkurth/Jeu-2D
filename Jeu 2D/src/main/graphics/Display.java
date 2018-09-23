package main.graphics;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display{
	
	private JFrame frame;
	protected Canvas canvas;
	
	private int width, height;
	private String title;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		
		createDisplay();
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width,  height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(canvas);
		frame.pack();
		
	}


	//-----------------------------Getters & Setters
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}	
}
