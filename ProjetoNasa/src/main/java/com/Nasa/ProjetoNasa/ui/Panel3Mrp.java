package com.Nasa.ProjetoNasa.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.Nasa.ProjetoNasa.apiRest.Request;
import com.Nasa.ProjetoNasa.model.MarsRoverPhotos;
import com.Nasa.ProjetoNasa.model.Utils;

public class Panel3Mrp extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel3Mrp() {
		setVisible(false);
		setBounds(0, 0, 1217, 597);
		setLayout(null);

		initialize();
	}

	private ImageIcon fundoIcon, curiosityIcon, opportunityIcon, spiritIcon;
	private JLabel fundoLabel, solLabel;
	private JButton voltarButton, curiosityButton, opportunityButton, spiritButton, searchButton;
	private JComboBox<String> solBox;
	private boolean mensagemInformacao = false;
	private String rover = "";
	private JTextArea roverInfo;
	private boolean painel = false;

	private void initialize() {
		/***/
		voltarButton = new JButton();
		fundoIcon = new ImageIcon(getClass().getResource("/Mrp/01_fundo_mrp.png"));
		fundoLabel = new JLabel(fundoIcon);
		curiosityIcon = new ImageIcon(getClass().getResource("/Mrp/02_botao_curiosity.png"));
		curiosityButton = new JButton(curiosityIcon);
		opportunityIcon = new ImageIcon(getClass().getResource("/Mrp/04_botao_opportunity.png"));
		opportunityButton = new JButton(opportunityIcon);
		spiritIcon = new ImageIcon(getClass().getResource("/Mrp/06_botao_spirit.png"));
		spiritButton = new JButton(spiritIcon);
		solLabel = new JLabel("Sol: ");
		solBox = new JComboBox<String>();
		searchButton = new JButton("Search");
		roverInfo = new JTextArea();
		
		/***/
		fundoLabel.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
		Utils.botaoVoltar(voltarButton);
		Utils.ajustesBotao(curiosityButton, 0, 0, "/Mrp/03_botao_curiosity_rolover.png");
		Utils.ajustesBotao(opportunityButton, 406, 0, "/Mrp/05_botao_opportunity_rolover.png");
		Utils.ajustesBotao(spiritButton, 812, 0, "/Mrp/07_botao_spirit_rolover.png");

		solLabel.setBounds(553, 268, 50, 30);
		solLabel.setFont(new Font("Montserrat", Font.BOLD, 14));
		solLabel.setForeground(Color.white);
		solLabel.setVisible(false);
		solBox.setBounds(593, 268, 70, 30);
		solBox.setFont(new Font("Montserrat", Font.PLAIN, 14));
		solBox.setVisible(false);
		solBox.setCursor(new Cursor(12));

		searchButton.setBounds(553, 298, 110, 30);
		searchButton.setFont(new Font("Montserrat", Font.PLAIN, 13));
		searchButton.setVisible(false);
		searchButton.setCursor(new Cursor(12));
		
		roverInfo.setVisible(false);
		roverInfo.setEditable(false);
		roverInfo.setForeground(Color.white);
		roverInfo.setBounds(30, 100, 400, 400);
		roverInfo.setBackground(new Color(33, 33, 33));
		roverInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		roverInfo.setFont(new Font("Montserrat", Font.PLAIN, 15));

		/***/
		add(voltarButton);
		add(curiosityButton);
		add(opportunityButton);
		add(spiritButton);
		add(roverInfo);
		add(solLabel);
		add(solBox);
		add(searchButton);
		add(fundoLabel);

		/***/
		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource().equals(voltarButton)) {
					if(!painel) {
						setVisible(false);
						Frm1Principal.principal.fundoSetVisible(true);
						curiosityButton.setVisible(true);
						opportunityButton.setVisible(true);
						spiritButton.setVisible(true);
					}else {
						painel = false;
						curiosityButton.setVisible(true);
						opportunityButton.setVisible(true);
						spiritButton.setVisible(true);
					}

				} else if (arg0.getSource().equals(curiosityButton)) {
					painel = true;
					roverSelect("curiosity");
					rover = "curiosity";

				} else if (arg0.getSource().equals(opportunityButton)) {
					painel = true;
					roverSelect("opportunity");
					rover = "opportunity";

				} else if (arg0.getSource().equals(spiritButton)) {
					painel = true;
					roverSelect("spirit");
					rover = "spirit";

				} else if (arg0.getSource().equals(searchButton)) {
					String sol = solBox.getSelectedItem().toString();
					MarsRoverPhotos m = Request.requestMRP(rover, sol);
					if (m.getPhotos().size() == 0) {
						noPhotoInformation();
					} else {
						mensagemCarregando();
						@SuppressWarnings("unused")
						Panel3Mrp2 p = new Panel3Mrp2(m);						
					}
				}
			}
		}

		voltarButton.addActionListener(new EventoButton());
		curiosityButton.addActionListener(new EventoButton());
		opportunityButton.addActionListener(new EventoButton());
		spiritButton.addActionListener(new EventoButton());
		searchButton.addActionListener(new EventoButton());

	}

	public void ajustesCheckBox(JCheckBox c, int x, int y) {
		c.setBounds(x, y, 300, 20);
		c.setFont(new Font("Montserrat", Font.PLAIN, 14));
		c.setForeground(Color.white);
	}

	private void noPhotoInformation() {
		JOptionPane.showMessageDialog(null, "Infelizmente não há fotos registradas neste dia", "No data",
				JOptionPane.INFORMATION_MESSAGE);

	}

	private void mensagemCarregando() {
		if (mensagemInformacao == false) {
			JOptionPane.showMessageDialog(null, "Pode demorar um pouco até alcançar os servidores da Nasa",
					"Obtendo informações", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(getClass().getResource("/nasa_icon.png")));
		}
		mensagemInformacao = true;
	}

	@SuppressWarnings("deprecation")
	private boolean ajustarSols(int i, String c) {
		solBox.removeAllItems();
		if(c==null) {
			for (int j = i; j >= 0; j--) {
				solBox.addItem(Integer.toString(j));
			}
			return true;
		}
		
		Date hoje = new Date();
		Date programmerDayCount = new Date(2021-1900, 02-1, 15);
		int count = 3030;
		while(hoje.after(programmerDayCount)) {
			programmerDayCount.setDate(programmerDayCount.getDate()+1);
			count++;
		}
		for(int j = count; j>=0; j--) {
			solBox.addItem(Integer.toString(j));
		}
		
		return true;		
	}

	private void roverSelect(String string) {
		curiosityButton.setVisible(false);
		opportunityButton.setVisible(false);
		spiritButton.setVisible(false);
		solLabel.setVisible(true);
		solBox.setVisible(true);
		searchButton.setVisible(true);
		roverInfo.setVisible(true);

		if (string.equals("curiosity")) {
			String info = "Rover: Curiosity\r\n"
					+ "Active Time: 2012-today\r\n"
					+ "Operator: NASA\r\n"
					+ "Program Mission: Mars Exploration Rovers\r\n"
					+ "Landing date: 06/08/2012\r\n"
					+ "Yet active\r\n"
					+ "Launch vehicle: Atlas V 541 (AV-028)";
			roverInfo.setText(info);
			ajustarSols(3032, "c");
			
		} else if (string.equals("opportunity")) {
			String info = "Rover: MER-B (Opportunity) \r\n"
					+ "Active Time: 2004-2010\r\n"
					+ "Operator: NASA\r\n"
					+ "Program Mission: Mars Exploration Rovers\r\n"
					+ "Landing date: 25/01/2004\r\n"
					+ "Lost contact in 07/2018\r\n"
					+ "Launch vehicle: Delta II 7925\r\n"
					+ "Sol numbers: 5100";
			roverInfo.setText(info);
			ajustarSols(5100, null);

		} else if (string.equals("spirit")) {
			String info = "Rover: Spirit (MER-A) \r\n"
					+ "Active Time: 2004-2010\r\n"
					+ "Operator: NASA\r\n"
					+ "Program Mission: Mars Exploration Rovers\r\n"
					+ "Landing date: 3/01/2004\r\n"
					+ "Lost contact in 03/2010\r\n"
					+ "Launch vehicle: Delta II 7925\r\n"
					+ "Sol numbers: 609";
			roverInfo.setText(info);
			ajustarSols(643, null);
		}
	}
}
