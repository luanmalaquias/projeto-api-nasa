package com.Nasa.ProjetoNasa.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Nasa.ProjetoNasa.model.Utils;

public class Panel2Insight extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel2Insight() {
		setVisible(false);
		setBounds(0, 0, 1217, 597);
		setLayout(null);

		initialize();
	}

	private ImageIcon fundoInsightImageIcon, voltarImageIcon;
	private ImageIcon voltarImageIconRolOver;
	private JLabel fundoInsightJLabel;
	private JButton voltarButton;

	private void initialize() {
		/***/
		fundoInsightImageIcon = new ImageIcon(getClass().getResource("/Mhs/01_fundo_insight.png"));
		voltarImageIcon = new ImageIcon(getClass().getResource("/09_botao_voltar.png"));
		voltarImageIconRolOver = new ImageIcon(getClass().getResource("/10_botao_voltar_rolover.png"));
		fundoInsightJLabel = new JLabel(fundoInsightImageIcon);
		voltarButton = new JButton(voltarImageIcon);

		/***/
		fundoInsightJLabel.setBounds(0, 0, 1217, 597);
		Utils.ajustesBotao(voltarButton, 0, 10, voltarImageIconRolOver);

		/***/
		add(voltarButton);
		add(fundoInsightJLabel);

		/***/
		@SuppressWarnings("unused")
		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (arg0.getSource().equals(voltarButton)) {
					setVisible(false);
					Frm1Principal.principal.fundoSetVisible(true);

				}
			}
		}
		voltarButton.addActionListener(new EventoButton());

	}

}
