package project.front.loader;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

import project.back.untils.Utilitaire;
import project.front.home.Home;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class SplashScreen extends JWindow {
	private JProgressBar progressBar = new JProgressBar();
	private int count;   
	private Timer timer1;
	private static SplashScreen instance;
	private  Image splashScreen;
	private ImageIcon imageIcon;

	private SplashScreen()
	{
		splashScreen = Toolkit.getDefaultToolkit().getImage("/Users/cheikh/eclipse-workspace/E-sante/image/loader.jpg");
		imageIcon = new ImageIcon(splashScreen);
		setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width-getSize().width)/2;
		int y = (screenSize.height-getSize().height)/2;
		setLocation(x,y);
		progressBar.setMaximum(50);
		progressBar.setBounds(26, 367, 500, 15);
		loadProgressBar(); 
		getContentPane().add(progressBar, BorderLayout.SOUTH);

		setVisible(true);
	}
	private void loadProgressBar()
	{
		ActionListener al = new ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				count++;
				progressBar.setValue(count);
				if (count == 75){
					timer1.stop();
					setVisible(false);
					dispose();
					Home home = Home.getInstance();
					home.run();


				}               
			}};         
			timer1 = new Timer(75, al);
			timer1.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(splashScreen, 0, 0, this);
	}
	//DESIGN PATTERNS SINGLETON
	public static SplashScreen getInstance() {
		instance = new SplashScreen();
		return instance;
	}
}


