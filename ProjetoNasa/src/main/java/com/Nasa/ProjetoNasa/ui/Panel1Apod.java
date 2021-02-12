package com.Nasa.ProjetoNasa.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	private ImageIcon fundoApodImageIcon, voltarImageIcon, descricaoImageIcon, prosseguirImageIcon, hojeImageIcon,
			escolherImageIcon, aleatorioImageIcon, botaoFecharIcon, botaoMinimizarIcon;
	private ImageIcon voltarImageIconRolOver, prosseguirImageIconRolOver, hojeImageIconRolOver,
			escolherImageIconRolOver, aleatorioImageIconRolOver;
	private JLabel fundoApodLabel, descricaoLabel;
	private JButton voltarButton, prosseguirButton, hojeButton, escolherButton, aleatorioButton, fecharButton,
			minimizarButton, okButton;
	private JTextField anoTF;
	private JComboBox<String> diaComboBox, mesComboBox;

	private void initialize() {

		/***/// initialization

		voltarImageIcon = new ImageIcon(getClass().getResource("/09_botao_voltar.png"));
		fundoApodImageIcon = new ImageIcon(getClass().getResource("/Apod/01_fundo_apod.png"));
		descricaoImageIcon = new ImageIcon(getClass().getResource("/Apod/02_apod_descricao.png"));
		prosseguirImageIcon = new ImageIcon(getClass().getResource("/Apod/03_botao_prosseguir.png"));
		hojeImageIcon = new ImageIcon(getClass().getResource("/Apod/05_botao_hoje.png"));
		escolherImageIcon = new ImageIcon(getClass().getResource("/Apod/07_botao_escolher.png"));
		aleatorioImageIcon = new ImageIcon(getClass().getResource("/Apod/09_botao_aleatorio.png"));
		botaoFecharIcon = new ImageIcon(getClass().getResource("/02_botao_fechar.png"));
		botaoMinimizarIcon = new ImageIcon(getClass().getResource("/04_botao_minimizar.png"));

		voltarImageIconRolOver = new ImageIcon(getClass().getResource("/10_botao_voltar_rolover.png"));
		prosseguirImageIconRolOver = new ImageIcon(getClass().getResource("/Apod/04_botao_prosseguir_rolover.png"));
		hojeImageIconRolOver = new ImageIcon(getClass().getResource("/Apod/06_botao_hoje_rolover.png"));
		escolherImageIconRolOver = new ImageIcon(getClass().getResource("/Apod/08_botao_escolher_rolover.png"));
		aleatorioImageIconRolOver = new ImageIcon(getClass().getResource("/Apod/10_botao_aleatorio_rolover.png"));

		fundoApodLabel = new JLabel(fundoApodImageIcon);
		voltarButton = new JButton(voltarImageIcon);
		descricaoLabel = new JLabel(descricaoImageIcon);
		prosseguirButton = new JButton(prosseguirImageIcon);
		hojeButton = new JButton(hojeImageIcon);
		escolherButton = new JButton(escolherImageIcon);
		aleatorioButton = new JButton(aleatorioImageIcon);
		fecharButton = new JButton(botaoFecharIcon);
		minimizarButton = new JButton(botaoMinimizarIcon);

		diaComboBox = new JComboBox<>();
		mesComboBox = new JComboBox<>();
		anoTF = new JTextField("Ano");

		okButton = new JButton("ok");
		okButton.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

		/***/// config

		fundoApodLabel.setBounds(0, 0, 1217, 597);
		Utils.ajustesBotao(voltarButton, 0, 10, voltarImageIconRolOver);

		descricaoLabel.setBounds(71, 245, descricaoImageIcon.getIconWidth(), descricaoImageIcon.getIconHeight());
		Utils.ajustesBotao(prosseguirButton, 525, 500, prosseguirImageIconRolOver);
		Utils.ajustesBotao(hojeButton, 0, 486, hojeImageIconRolOver);
		Utils.ajustesBotao(escolherButton, 400, 486, escolherImageIconRolOver);
		Utils.ajustesBotao(aleatorioButton, 800, 486, aleatorioImageIconRolOver);

		Utils.ajustesComboBoc(diaComboBox, 410, 450);
		Utils.ajustesComboBoc(mesComboBox, 543, 450);
		Utils.ajustesTextField(anoTF, 676, 450);

		hojeButton.setVisible(false);
		escolherButton.setVisible(false);
		aleatorioButton.setVisible(false);

		diaComboBox.setVisible(false);
		mesComboBox.setVisible(false);
		anoTF.setVisible(false);

		for (int i = 1; i <= 31; i++) {
			diaComboBox.addItem(Integer.toString(i));
			if (i <= 12) {
				mesComboBox.addItem(Integer.toString(i));
			}
		}

		okButton.setBounds(790, 450, 50, 30);
		okButton.setVisible(false);

		Utils.ajustesBotao(fecharButton, 1172, 0, new ImageIcon(getClass().getResource("/03_botao_fechar_rolover.png")));
		Utils.ajustesBotao(minimizarButton, 1067, 0, new ImageIcon(getClass().getResource("/05_botao_minimizar_rolover.png")));

		/***/// add

		add(fecharButton);
		add(minimizarButton);
		add(voltarButton);
		add(descricaoLabel);
		add(prosseguirButton);
		add(hojeButton);
		add(escolherButton);
		add(aleatorioButton);
		add(anoTF);
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
					anoTF.setVisible(false);
					okButton.setVisible(false);

				} else if (arg0.getSource().equals(prosseguirButton)) {
					descricaoLabel.setVisible(false);
					prosseguirButton.setVisible(false);
					hojeButton.setVisible(true);
					escolherButton.setVisible(true);
					aleatorioButton.setVisible(true);

				} else if (arg0.getSource().equals(hojeButton)) {
					Apod apod = Request.requestApod(null, false);
					Panel1Apod2 p = new Panel1Apod2(apod);

				} else if (arg0.getSource().equals(escolherButton) || arg0.getSource().equals(diaComboBox)
						|| arg0.getSource().equals(mesComboBox) || arg0.getSource().equals(anoTF)
						|| arg0.getSource().equals(okButton)) {
					diaComboBox.setVisible(true);
					mesComboBox.setVisible(true);
					anoTF.setVisible(true);
					okButton.setVisible(true);

					if (Utils.isInteger(diaComboBox.getSelectedItem().toString())
							&& Utils.isInteger(mesComboBox.getSelectedItem().toString())
							&& Utils.isInteger(anoTF.getText())) {
						if (Utils.validarData(diaComboBox.getSelectedItem().toString(),
								mesComboBox.getSelectedItem().toString(), anoTF.getText())) {
							String data = Utils.organizarData(diaComboBox.getSelectedItem().toString(),
									mesComboBox.getSelectedItem().toString(), anoTF.getText());
							Apod apod = Request.requestApod(data, false);
							Panel1Apod2 p = new Panel1Apod2(apod);
						}
					}

				} else if (arg0.getSource().equals(aleatorioButton)) {
					Apod apod = Request.requestApod(null, true);
					Panel1Apod2 p = new Panel1Apod2(apod);
					
				} else if (arg0.getSource().equals(fecharButton)) {
					Frm1Principal.principal.dispose();
					
				} else if (arg0.getSource().equals(minimizarButton)) {
					Frm1Principal.principal.setExtendedState(1);
					
				}
			}

		}

		voltarButton.addActionListener(new EventoButton());
		prosseguirButton.addActionListener(new EventoButton());
		hojeButton.addActionListener(new EventoButton());
		escolherButton.addActionListener(new EventoButton());
		aleatorioButton.addActionListener(new EventoButton());
		okButton.addActionListener(new EventoButton());
		fecharButton.addActionListener(new EventoButton());
		minimizarButton.addActionListener(new EventoButton());
	}

}
