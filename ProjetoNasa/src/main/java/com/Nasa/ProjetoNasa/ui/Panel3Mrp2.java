package com.Nasa.ProjetoNasa.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.Nasa.ProjetoNasa.model.MarsRoverPhotos;
import com.Nasa.ProjetoNasa.model.Utils;

public class Panel3Mrp2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private MarsRoverPhotos mrp;

	public Panel3Mrp2(MarsRoverPhotos mrp) {

		super("MRP");
		this.mrp = mrp;
		setSize(1366, 768);
		setLocationRelativeTo(null);
		setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource("/Mrp/mrp_icon.png")).getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if (screenSize.getWidth() == 1366 && screenSize.getHeight() == 768) {
			setExtendedState(MAXIMIZED_BOTH);
		}

		initialize();
		setVisible(true);
	}

	private ImageIcon fundoIcon, anteriorIcon, proximoIcon, fotoIcon;
	private JLabel fundoLabel, fotoLabel;
	private JButton anteriorButton, proximoButton, webView;
	private JTextArea info;
	private URL url;
	private int i = 0;

	private void initialize() {

		try {
			url = new URL(mrp.getPhotos().get(i).getImg_src());
			verifyHttps();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		/***/
		fotoIcon = new ImageIcon(url);
		fotoLabel = new JLabel(new ImageIcon(url));
		fotoLabel.setBounds(280, 0, 800, 740);
		fotoLabel.setHorizontalAlignment(0);
		fotoLabel.setVerticalAlignment(0);
		proximoIcon = new ImageIcon(getClass().getResource("/Mrp/09_botao_proximo.png"));
		proximoButton = new JButton(proximoIcon);
		anteriorIcon = new ImageIcon(getClass().getResource("/Mrp/11_botao_anterior.png"));
		anteriorButton = new JButton(anteriorIcon);
		info = new JTextArea("Photo: " + i + "\n" + mrp.info(i));
		fundoIcon = new ImageIcon(getClass().getResource("/Mrp/08_fundo_mrp_2.png"));
		fundoLabel = new JLabel(fundoIcon);
		webView = new JButton("Web View");

		/***/
		fundoLabel.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
		Utils.ajustesBotao(anteriorButton, 580, 630, "/Mrp/12_botao_anterior_rolover.png");
		Utils.ajustesBotao(proximoButton, 730, 630, "/Mrp/10_botao_proximo_rolover.png");
		info.setBounds(14, 216, 448, 190);
		info.setBackground(new Color(0, 0, 0, 0));
		info.setForeground(Color.white);
		info.setFont(new Font("Montserrat", Font.PLAIN, 15));
		info.setEditable(false);
		info.setBorder(new EmptyBorder(0, 0, 0, 0));
		webView.setBounds(14, 416, 100, 30);
		webView.setFont(new Font("Montserrat", Font.PLAIN, 13));
		webView.setCursor(new Cursor(12));

		/***/
		add(info);
		add(webView);
		add(proximoButton);
		add(anteriorButton);
		add(fotoLabel);
		add(fundoLabel);

		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource().equals(anteriorButton)) {
					i--;
					if (i < 0)
						i = mrp.getPhotos().size() - 1;
					trocarImagem();

				} else if (arg0.getSource().equals(proximoButton)) {
					i++;
					if (i > mrp.getPhotos().size() - 1)
						i = 0;
					trocarImagem();

				} else if (arg0.getSource().equals(webView)) {
					try {
						Desktop.getDesktop().browse(new URI(url.toString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		proximoButton.addActionListener(new EventoButton());
		anteriorButton.addActionListener(new EventoButton());
		webView.addActionListener(new EventoButton());

	}

	private void verifyHttps() {
		if (url.toString().contains("https")) {

		} else {
			String urlS = url.toString().replace("http", "https");
			URL url2;
			try {
				url2 = new URL(urlS);
				url = url2;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	private void trocarImagem() {
		try {
			info.setText("Photo: " + i + "\n" + mrp.info(i));
			url = new URL(mrp.getPhotos().get(i).getImg_src());
			verifyHttps();
			ImageIcon i = new ImageIcon(url);
			i.getImage().flush();
			fotoIcon.setImage(i.getImage());
			fotoLabel.setIcon(i);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
