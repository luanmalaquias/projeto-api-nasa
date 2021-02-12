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

	private ImageIcon fundoInsightImageIcon, voltarImageIcon, botaoFecharIcon, botaoMinimizarIcon;
	private ImageIcon voltarImageIconRolOver;
	private JLabel fundoInsightJLabel;
	private JButton voltarButton, fecharButton, minimizarButton;

	private void initialize() {
		/***/
		fundoInsightImageIcon = new ImageIcon(getClass().getResource("/Mhs/01_fundo_insight.png"));
		voltarImageIcon = new ImageIcon(getClass().getResource("/09_botao_voltar.png"));
		botaoFecharIcon = new ImageIcon(getClass().getResource("/02_botao_fechar.png"));
		botaoMinimizarIcon = new ImageIcon(getClass().getResource("/04_botao_minimizar.png"));

		voltarImageIconRolOver = new ImageIcon(getClass().getResource("/10_botao_voltar_rolover.png"));

		fundoInsightJLabel = new JLabel(fundoInsightImageIcon);
		voltarButton = new JButton(voltarImageIcon);
		fecharButton = new JButton(botaoFecharIcon);
		minimizarButton = new JButton(botaoMinimizarIcon);

		/***/
		fundoInsightJLabel.setBounds(0, 0, 1217, 597);
		Utils.ajustesBotao(voltarButton, 0, 10, voltarImageIconRolOver);
		Utils.ajustesBotao(fecharButton, 1172, 0,new ImageIcon(getClass().getResource("/03_botao_fechar_rolover.png")));
		Utils.ajustesBotao(minimizarButton, 1067, 0, new ImageIcon(getClass().getResource("/05_botao_minimizar_rolover.png")));
		
		/***/
		add(voltarButton);
		add(minimizarButton);
		add(fecharButton);
		add(fundoInsightJLabel);

		/***/
		@SuppressWarnings("unused")
		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (arg0.getSource().equals(voltarButton)) {
					setVisible(false);
					Frm1Principal.principal.fundoSetVisible(true);
					
				}else if(arg0.getSource().equals(fecharButton)) {
					Frm1Principal.principal.dispose();
				
				}else if(arg0.getSource().equals(minimizarButton)) {
					Frm1Principal.principal.setExtendedState(1);
					
				}
			}
		}
		voltarButton.addActionListener(new EventoButton());
		minimizarButton.addActionListener(new EventoButton());
		fecharButton.addActionListener(new EventoButton());
	}
	
}
