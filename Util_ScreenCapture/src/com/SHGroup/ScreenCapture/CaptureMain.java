package com.SHGroup.ScreenCapture;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CaptureMain extends Thread {
	public CaptureMain() {

	}

	public static void main(String[] args) {
		new CaptureMain().start();
	}
	
	private JPanel jp;
	private final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	
	private final int blank = 20;

	@Override
	public void run() {
		JFrame jf = new JFrame("Hello!!!!!!!!!!!");
		jf.setBounds(blank, blank, d.width-blank*2, d.height-blank*2);
		
		jp = new JPanel(){
			Robot r;
			@Override
			public void paint(Graphics g){
				try{
					if(r == null) r = new Robot();
					BufferedImage img = r.createScreenCapture(new Rectangle(d.width, d.height));
					g.drawImage(img, 0, 0, d.width-blank*2, d.height-blank*2, null);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			
		};
		
		jf.add(jp);
		
		jf.setUndecorated(true);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true){
			try{
				jf.repaint();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
	}
}
