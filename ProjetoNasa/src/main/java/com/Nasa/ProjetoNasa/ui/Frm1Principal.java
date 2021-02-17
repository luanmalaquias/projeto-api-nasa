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
	private static int screenX = 1233, screenY = 636; //1217 597
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
	private ImageIcon apodImageIcon, insightMWSImageIcon, mrpImageIcon, trekImageryImageIcon;
	private JButton apodButton, insightMWSButton, mrpButton, trekImageryButton;
	private JPanel apodPanel, insightMWSPanel, mrpPanel/*, trekImageryPanel*/;
	
	// *

	private ImageIcon fundoImageIcon, nasaImageIcon;
	private JLabel fundoJLabel;
	private JButton nasaButton;
	private JPanel fundoPanel;

	private void initialize() {

		try {
			/***/
			fundoImageIcon = new ImageIcon(getClass().getResource("/01_fundo_nasa.png"));
			nasaImageIcon = new ImageIcon(getClass().getResource("/06_botao_nasa.png"));
			apodImageIcon = new ImageIcon(getClass().getResource("/08_botao_apod.png"));
			insightMWSImageIcon = new ImageIcon(getClass().getResource("/11_botao_insight.png"));
			mrpImageIcon = new ImageIcon(getClass().getResource("/13_botao_mrp.png"));
			trekImageryImageIcon = new ImageIcon(getClass().getResource("/15_botao_trek_imagery.png"));
			
			fundoJLabel = new JLabel(fundoImageIcon);
			nasaButton = new JButton(nasaImageIcon);
			apodButton = new JButton(apodImageIcon);
			insightMWSButton = new JButton(insightMWSImageIcon);
			mrpButton = new JButton(mrpImageIcon);
			trekImageryButton = new JButton(trekImageryImageIcon);
			
			fundoPanel = new JPanel(null);
			apodPanel = new Panel1Apod();
			insightMWSPanel = new Panel2Insight();
			mrpPanel = new Panel3Mrp();

			/***/
			fundoJLabel.setBounds(0, 0, fundoImageIcon.getIconWidth(), fundoImageIcon.getIconHeight());
			Utils.ajustesBotao(nasaButton, 452, 122,"/07_botao_nasa_rolover.png");
			nasaButton.setToolTipText("Visit Nasa.gov");
			Utils.ajustesBotao(apodButton, 0, 535, "/08_botao_apod_rolover.png");
			apodButton.setToolTipText("Astronomy Photo Of The Day");
			Utils.ajustesBotao(insightMWSButton, 121, 535, "/12_botao_insight_rolover.png");
			insightMWSButton.setToolTipText("InSight: Mars Weather Service");
			fundoPanel.setBounds(0, 0, screenX, screenY);
			Utils.ajustesBotao(mrpButton, 121*2, 535, "/14_botao_mrp_rolover.png");
			mrpButton.setToolTipText("Mars Rover Photos");
			Utils.ajustesBotao(trekImageryButton, 121*3, 535, "/16_botao_trek_imagery_rolover.png");
			
			/***/
			add(apodPanel);
			add(insightMWSPanel);
			add(mrpPanel);
			fundoPanel.add(nasaButton);
			fundoPanel.add(apodButton);
			fundoPanel.add(insightMWSButton);
			fundoPanel.add(mrpButton);
			//fundoPanel.add(trekImageryButton);
			fundoPanel.add(fundoJLabel);
			add(fundoPanel);

			/***/

			class EventoButton implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						if (arg0.getSource().equals(nasaButton)) {
							Desktop.getDesktop().browse(new URI("https://www.nasa.gov/"));
						} else if (arg0.getSource().equals(apodButton)) {
							apodPanel.setVisible(true);
							fundoPanel.setVisible(false);
						} else if(arg0.getSource().equals(insightMWSButton)) {
							insightMWSPanel.setVisible(true);
							fundoPanel.setVisible(false);
						} else if(arg0.getSource().equals(mrpButton)) {
							mrpPanel.setVisible(true);
							fundoPanel.setVisible(false);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			nasaButton.addActionListener(new EventoButton());
			apodButton.addActionListener(new EventoButton());
			insightMWSButton.addActionListener(new EventoButton());
			mrpButton.addActionListener(new EventoButton());

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void fundoSetVisible(boolean b) {
		principal.fundoPanel.setVisible(b);
	}
	
	
	
}
