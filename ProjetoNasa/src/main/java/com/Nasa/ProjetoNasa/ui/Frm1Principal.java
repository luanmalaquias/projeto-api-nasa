package com.Nasa.ProjetoNasa.ui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.Nasa.ProjetoNasa.model.Utils;

public class Frm1Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static int screenX = 1233, screenY = 636; // 1217 597
	public static Frm1Principal principal;

	public Frm1Principal() {
		super("NASA API's");

		try {
			setSize(screenX, screenY);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setResizable(false);
			setLayout(null);
			setIconImage(new ImageIcon(getClass().getResource("/nasa_icon.png")).getImage());
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

			initialize();

			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Area para novas funções do app
	private JButton apodButton, insightMWSButton, mrpButton, trekImageryButton, nasaSearchButton, historyBtn;
	private JPanel apodPanel, insightMWSPanel, mrpPanel, trekImageryPanel, nasaSearchPanel, historyPanel;

	// *

	private ImageIcon fundoImageIcon, nasaImageIcon, spacexIcon;
	private JLabel fundoJLabel;
	private JButton nasaButton, spacexButton;
	private JPanel fundoPanel;

	private void initialize() {

		try {
			/***/
			fundoImageIcon = new ImageIcon(getClass().getResource("/01_fundo_nasa.png"));
			fundoJLabel = new JLabel(fundoImageIcon);
			nasaImageIcon = new ImageIcon(getClass().getResource("/03_botao_nasa.png"));
			nasaButton = new JButton(nasaImageIcon);
			spacexIcon = new ImageIcon(getClass().getResource("/05_botao_spacex.png"));
			spacexButton = new JButton(spacexIcon);
			apodButton = new JButton();
			insightMWSButton = new JButton();
			mrpButton = new JButton();
			trekImageryButton = new JButton();
			nasaSearchButton = new JButton();
			historyBtn = new JButton();

			fundoPanel = new JPanel(null);
			apodPanel = new Panel1Apod();
			insightMWSPanel = new Panel2Insight();
			mrpPanel = new Panel3Mrp();
			trekImageryPanel = new Panel4TrekImagery();
			nasaSearchPanel = new Panel5NasaLibrary();
			historyPanel = new Panel6HistoryEvents();

			/***/
			fundoJLabel.setBounds(0, 0, fundoImageIcon.getIconWidth(), fundoImageIcon.getIconHeight());
			fundoPanel.setBounds(0, 0, screenX, screenY);
			Utils.ajustesBotao(nasaButton, 195, 254, "/04_botao_nasa_rolover.png", "Visit Nasa.gov");
			nasaButton.setToolTipText("Visit Nasa.gov");
			Utils.ajustesBotao(spacexButton, 628, 243, "/06_botao_spacex_rolover.png", "Visit Spacex.com");
			spacexButton.setToolTipText("Visit Spacex.com");

			Utils.ajustesBotao(apodButton, "APOD", 0, 535, "Astronomy Photo Of The Day");
			Utils.ajustesBotao(insightMWSButton, "INSIGHT MWS", 121, 535, "InSight: Mars Weather Service");
			Utils.ajustesBotao(mrpButton, "ROVER PHOTOS", 121 * 2, 535, "Mars Rover Photos");
			Utils.ajustesBotao(trekImageryButton, "TREK IMAGERY", 121 * 3, 535, "Trek Mars Imagery");
			Utils.ajustesBotao(nasaSearchButton, "NASA SEARCH", 121 * 4, 535, "Nasa Image And Library Service");
			Utils.ajustesBotao(historyBtn, "HISTORY EVENTS", 121 * 5, 535, "Last History Events from SpaceX");

			/***/
			add(apodPanel);
			add(insightMWSPanel);
			add(mrpPanel);
			add(trekImageryPanel);
			add(nasaSearchPanel);
			add(historyPanel);
			fundoPanel.add(nasaButton);
			fundoPanel.add(spacexButton);
			fundoPanel.add(apodButton);
			fundoPanel.add(insightMWSButton);
			fundoPanel.add(mrpButton);
			fundoPanel.add(trekImageryButton);
			fundoPanel.add(nasaSearchButton);
			fundoPanel.add(historyBtn);
			fundoPanel.add(fundoJLabel);
			add(fundoPanel);

			/***/

			class EventoButton implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						if (arg0.getSource().equals(nasaButton)) {
							Desktop.getDesktop().browse(new URI("https://www.nasa.gov/"));
						} else if (arg0.getSource().equals(spacexButton)) {
							Desktop.getDesktop().browse(new URI("https://www.spacex.com/"));
						} else if (arg0.getSource().equals(apodButton)) {
							apodPanel.setVisible(true);
							fundoPanel.setVisible(false);
						} else if (arg0.getSource().equals(insightMWSButton)) {
							insightMWSPanel.setVisible(true);
							fundoPanel.setVisible(false);
						} else if (arg0.getSource().equals(mrpButton)) {
							mrpPanel.setVisible(true);
							fundoPanel.setVisible(false);
						} else if (arg0.getSource().equals(trekImageryButton)) {
							trekImageryPanel.setVisible(true);
							fundoPanel.setVisible(false);
						} else if (arg0.getSource().equals(nasaSearchButton)) {
							nasaSearchPanel.setVisible(true);
							fundoPanel.setVisible(false);
						} else if (arg0.getSource().equals(historyBtn)) {
							historyPanel.setVisible(true);
							fundoPanel.setVisible(false);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			nasaButton.addActionListener(new EventoButton());
			spacexButton.addActionListener(new EventoButton());
			apodButton.addActionListener(new EventoButton());
			insightMWSButton.addActionListener(new EventoButton());
			mrpButton.addActionListener(new EventoButton());
			trekImageryButton.addActionListener(new EventoButton());
			nasaSearchButton.addActionListener(new EventoButton());
			historyBtn.addActionListener(new EventoButton());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fundoSetVisible(boolean b) {
		principal.fundoPanel.setVisible(b);
	}

}
