package com.Nasa.ProjetoNasa.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.Nasa.ProjetoNasa.apiRest.Request;
import com.Nasa.ProjetoNasa.model.Apod;
import com.Nasa.ProjetoNasa.model.Utils;

public class Panel1Apod extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel1Apod() {

		setVisible(false);
		setBounds(0, 0, 1217, 597);
		setLayout(null);

		initialize();

	}

	private ImageIcon fundoApodImageIcon, descricaoImageIcon, prosseguirImageIcon, hojeImageIcon, escolherImageIcon,
			aleatorioImageIcon;
	private JLabel fundoApodLabel, descricaoLabel;
	private JButton voltarButton, prosseguirButton, hojeButton, escolherButton, aleatorioButton, okButton;
	private JComboBox<String> diaComboBox, mesComboBox, anoComboBox;
	private boolean mensagemInformacao = false;

	@SuppressWarnings("deprecation")
	private void initialize() {

		/***/// initialization

		fundoApodImageIcon = new ImageIcon(getClass().getResource("/Apod/01_fundo_apod.png"));
		descricaoImageIcon = new ImageIcon(getClass().getResource("/Apod/02_apod_descricao.png"));
		prosseguirImageIcon = new ImageIcon(getClass().getResource("/Apod/03_botao_prosseguir.png"));
		hojeImageIcon = new ImageIcon(getClass().getResource("/Apod/05_botao_hoje.png"));
		escolherImageIcon = new ImageIcon(getClass().getResource("/Apod/07_botao_escolher.png"));
		aleatorioImageIcon = new ImageIcon(getClass().getResource("/Apod/09_botao_aleatorio.png"));

		fundoApodLabel = new JLabel(fundoApodImageIcon);
		voltarButton = new JButton();
		descricaoLabel = new JLabel(descricaoImageIcon);
		prosseguirButton = new JButton(prosseguirImageIcon);
		hojeButton = new JButton(hojeImageIcon);
		escolherButton = new JButton(escolherImageIcon);
		aleatorioButton = new JButton(aleatorioImageIcon);

		diaComboBox = new JComboBox<>();
		mesComboBox = new JComboBox<>();
		anoComboBox = new JComboBox<>();

		okButton = new JButton("ok");
		okButton.setFont(new Font("Montserrat", Font.PLAIN, 14));

		/***/// config

		fundoApodLabel.setBounds(0, 0, 1217, 597);
		Utils.botaoVoltar(voltarButton);
		descricaoLabel.setBounds(71, 245, descricaoImageIcon.getIconWidth(), descricaoImageIcon.getIconHeight());
		Utils.ajustesBotao(prosseguirButton, 525, 500, "/Apod/04_botao_prosseguir_rolover.png", null);
		Utils.ajustesBotao(hojeButton, 0, 486, "/Apod/06_botao_hoje_rolover.png", null);
		Utils.ajustesBotao(escolherButton, 400, 486, "/Apod/08_botao_escolher_rolover.png", null);
		Utils.ajustesBotao(aleatorioButton, 800, 486, "/Apod/10_botao_aleatorio_rolover.png", null);

		Utils.ajustesComboBox(diaComboBox, 410, 450);
		Utils.ajustesComboBox(mesComboBox, 543, 450);
		Utils.ajustesComboBox(anoComboBox, 676, 450);

		hojeButton.setVisible(false);
		escolherButton.setVisible(false);
		aleatorioButton.setVisible(false);

		diaComboBox.setVisible(false);
		mesComboBox.setVisible(false);
		anoComboBox.setVisible(false);

		int year = new Date().getYear() + 1900;
		for (int i = year; i >= 0; i--) {
			if (i >= 1996) {
				anoComboBox.addItem(Integer.toString(i));
			}
			if (i <= 12) {
				mesComboBox.addItem(Integer.toString(i));
			}
			if (i <= 31) {
				diaComboBox.addItem(Integer.toString(i));
			}
		}

		int dia = new Date().getDate();
		int mes = new Date().getMonth() + 1;
		int ano = new Date().getYear() - 1900;
		diaComboBox.setSelectedItem(Integer.toString(dia));
		mesComboBox.setSelectedItem(Integer.toString(mes));
		anoComboBox.setSelectedItem(Integer.toString(ano));

		okButton.setBounds(790, 450, 50, 30);
		okButton.setVisible(false);

		/***/// add

		add(voltarButton);
		add(descricaoLabel);
		add(prosseguirButton);
		add(hojeButton);
		add(escolherButton);
		add(aleatorioButton);
		add(anoComboBox);
		add(diaComboBox);
		add(mesComboBox);
		add(okButton);
		add(fundoApodLabel);

		/***/

		@SuppressWarnings("unused")
		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (arg0.getSource().equals(voltarButton)) {
					setVisible(false);
					Frm1Principal.principal.fundoSetVisible(true);
					diaComboBox.setVisible(false);
					mesComboBox.setVisible(false);
					anoComboBox.setVisible(false);
					okButton.setVisible(false);

				} else if (arg0.getSource().equals(prosseguirButton)) {
					descricaoLabel.setVisible(false);
					prosseguirButton.setVisible(false);
					hojeButton.setVisible(true);
					escolherButton.setVisible(true);
					aleatorioButton.setVisible(true);

				} else if (arg0.getSource().equals(hojeButton)) {
					mensagemCarregando();
					Apod apod = Request.requestApod(null, false);
					Panel1Apod2 p = new Panel1Apod2(apod);

				} else if (arg0.getSource().equals(escolherButton)) {
					diaComboBox.setVisible(true);
					mesComboBox.setVisible(true);
					anoComboBox.setVisible(true);
					okButton.setVisible(true);

				} else if (arg0.getSource().equals(okButton)) {
					if (Utils.validarData(diaComboBox.getSelectedItem().toString(),
							mesComboBox.getSelectedItem().toString(), anoComboBox.getSelectedItem().toString())) {
						String data = Utils.organizarData(diaComboBox.getSelectedItem().toString(),
								mesComboBox.getSelectedItem().toString(), anoComboBox.getSelectedItem().toString());
						mensagemCarregando();
						Apod apod = Request.requestApod(data, false);
						Panel1Apod2 p = new Panel1Apod2(apod);
					}

				} else if (arg0.getSource().equals(aleatorioButton)) {
					mensagemCarregando();
					Apod apod = Request.requestApod(null, true);
					Panel1Apod2 p = new Panel1Apod2(apod);

				}
			}
		}

		voltarButton.addActionListener(new EventoButton());
		prosseguirButton.addActionListener(new EventoButton());
		hojeButton.addActionListener(new EventoButton());
		escolherButton.addActionListener(new EventoButton());
		aleatorioButton.addActionListener(new EventoButton());
		okButton.addActionListener(new EventoButton());
	}

	private void mensagemCarregando() {
		if (mensagemInformacao == false) {
			JOptionPane.showMessageDialog(null, "Pode demorar um pouco até alcançar os servidores da Nasa",
					"Obtendo informações", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(getClass().getResource("/nasa_icon.png")));
		}
		mensagemInformacao = true;
	}

}
