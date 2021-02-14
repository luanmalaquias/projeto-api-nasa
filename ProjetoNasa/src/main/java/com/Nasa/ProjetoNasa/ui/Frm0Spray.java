package com.Nasa.ProjetoNasa.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frm0Spray extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon sprayImageIcon = new ImageIcon(getClass().getResource("/00_nasa_spray.gif"));
	private JLabel sprayJLabel;
	private boolean state = true;

	public Frm0Spray() {
		setSize(sprayImageIcon.getIconWidth(), sprayImageIcon.getIconHeight());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setIconImage(new ImageIcon(getClass().getResource("/nasa_icon.png")).getImage());
		
		initialize();

		setVisible(true);
		turnOff();
	}

	private void initialize() {
		
		sprayJLabel = new JLabel(sprayImageIcon);

		/***/
		sprayImageIcon.getImage().flush();
		sprayImageIcon.getImage();

		/***/
		add(sprayJLabel);

		/***/
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				create();
			}
		});

	}

	private void turnOff() {
		try {
			Thread.sleep(7700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		create();
	}

	private void create() {
		this.dispose();
		if (state) {
			Frm1Principal.principal = new Frm1Principal();
		}
		this.state = false;
	}

}
