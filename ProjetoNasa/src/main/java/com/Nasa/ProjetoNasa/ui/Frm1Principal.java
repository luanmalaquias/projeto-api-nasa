package com.Nasa.ProjetoNasa.ui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.Nasa.ProjetoNasa.model.Utils;

public class Frm1Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static int screenX = 1217, screenY = 597;
	public static Frm1Principal principal;

	public Frm1Principal() {
		super("NASA API's");

		try {
			setSize(screenX, screenY);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setUndecorated(true);
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
	private ImageIcon apodImageIcon, insightMWSImageIcon;
	private JButton apodButton, insightMWSButton;
	private JPanel apodPanel, insightMWSPanel;
	
	// *

	private ImageIcon fundoImageIcon, botaoFecharIcon, botaoMinimizarIcon, nasaImageIcon;
	private JLabel fundoJLabel;
	private JButton fecharButton, minimizarButton, nasaButton;
	private JPanel fundoPanel;

	private void initialize() {

		try {
			/***/

			fundoImageIcon = new ImageIcon(getClass().getResource("/01_fundo_nasa.png"));
			botaoFecharIcon = new ImageIcon(getClass().getResource("/02_botao_fechar.png"));
			botaoMinimizarIcon = new ImageIcon(getClass().getResource("/04_botao_minimizar.png"));
			nasaImageIcon = new ImageIcon(getClass().getResource("/06_botao_nasa.png"));
			apodImageIcon = new ImageIcon(getClass().getResource("/08_botao_apod.png"));
			insightMWSImageIcon = new ImageIcon(getClass().getResource("/11_botao_insight.png"));
			
			fundoJLabel = new JLabel(fundoImageIcon);
			fecharButton = new JButton(botaoFecharIcon);
			minimizarButton = new JButton(botaoMinimizarIcon);
			nasaButton = new JButton(nasaImageIcon);
			apodButton = new JButton(apodImageIcon);
			insightMWSButton = new JButton(insightMWSImageIcon);
			fundoPanel = new JPanel(null);
			apodPanel = new Panel1Apod();
			insightMWSPanel = new Panel2Insight();

			/***/

			fundoJLabel.setBounds(0, 0, fundoImageIcon.getIconWidth(), fundoImageIcon.getIconHeight());
			Utils.ajustesBotao(fecharButton, 1217 - fecharButton.getIcon().getIconWidth(), 0,new ImageIcon(getClass().getResource("/03_botao_fechar_rolover.png")));
			Utils.ajustesBotao(minimizarButton, 1217 - 150, 0,new ImageIcon(getClass().getResource("/05_botao_minimizar_rolover.png")));
			Utils.ajustesBotao(nasaButton, 452, 122,new ImageIcon(getClass().getResource("/07_botao_nasa_rolover.png")));
			nasaButton.setToolTipText("Visit Nasa.gov");
			Utils.ajustesBotao(apodButton, 0, 535, new ImageIcon(getClass().getResource("/08_botao_apod_rolover.png")));
			apodButton.setToolTipText("Astronomy Photo Of The Day");
			Utils.ajustesBotao(insightMWSButton, 121, 535, new ImageIcon(getClass().getResource("/12_botao_insight_rolover.png")));
			insightMWSButton.setToolTipText("InSight: Mars Weather Service");
			fundoPanel.setBounds(0, 0, screenX, screenY);

			/***/

			add(apodPanel);
			add(insightMWSPanel);
			fundoPanel.add(fecharButton);
			fundoPanel.add(minimizarButton);
			fundoPanel.add(nasaButton);
			fundoPanel.add(apodButton);
			fundoPanel.add(insightMWSButton);
			fundoPanel.add(fundoJLabel);
			add(fundoPanel);

			/***/

			class EventoButton implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						if (arg0.getSource().equals(fecharButton)) {
							dispose();
						} else if (arg0.getSource().equals(minimizarButton)) {
							setExtendedState(ICONIFIED);
						} else if (arg0.getSource().equals(nasaButton)) {
							Desktop.getDesktop().browse(new URI("https://www.nasa.gov/"));
						} else if (arg0.getSource().equals(apodButton)) {
							apodPanel.setVisible(true);
							fundoPanel.setVisible(false);
						} else if(arg0.getSource().equals(insightMWSButton)) {
							insightMWSPanel.setVisible(true);
							fundoPanel.setVisible(false);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			fecharButton.addActionListener(new EventoButton());
			minimizarButton.addActionListener(new EventoButton());
			nasaButton.addActionListener(new EventoButton());
			apodButton.addActionListener(new EventoButton());
			insightMWSButton.addActionListener(new EventoButton());

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void fundoSetVisible(boolean b) {
		principal.fundoPanel.setVisible(b);
	}
	
	public static void main(String args[]) {
		principal = new Frm1Principal();

	}

}
