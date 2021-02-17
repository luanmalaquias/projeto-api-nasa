package com.Nasa.ProjetoNasa.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.Nasa.ProjetoNasa.apiRest.Request;
import com.Nasa.ProjetoNasa.model.InSight;
import com.Nasa.ProjetoNasa.model.Utils;

public class Panel2Insight extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel2Insight() {
		setVisible(false);
		setBounds(0, 0, 1217, 597);
		setLayout(null);

		initialize();
	}

	private ImageIcon fundoInsightImageIcon;
	private JLabel fundoInsightJLabel, solJLabel, solInfoJLabel, dataInfoJLabel, highInfoJLabel, lowInfoJLabel;
	private JButton voltarButton, okButton;
	private JComboBox<String> solComboBox;
	private JTextArea informacoes;
	private InSight insight;

	private void initialize() {
		/***/
		fundoInsightImageIcon = new ImageIcon(getClass().getResource("/Mhs/01_fundo_insight.png"));
		fundoInsightJLabel = new JLabel(fundoInsightImageIcon);
		voltarButton = new JButton();
		okButton = new JButton("Search");
		solJLabel = new JLabel("Sol:");
		solComboBox = new JComboBox<>();
		informacoes = new JTextArea();
		solInfoJLabel = new JLabel("Sol");
		dataInfoJLabel = new JLabel("Date");
		highInfoJLabel = new JLabel("High");
		lowInfoJLabel = new JLabel("Low");
 
		/***/
		fundoInsightJLabel.setBounds(0, 0, 1217, 597);
		Utils.botaoVoltar(voltarButton);
		solJLabel.setBounds(540, 420, 30, 30);
		solJLabel.setFont(new Font("Montserrat", Font.BOLD, 14));
		solJLabel.setForeground(Color.white);
		solComboBox.setBounds(570, 420, 100, 30);
		solComboBox.setFont(new Font("Montserrat", Font.PLAIN, 14));
		for (int i = 708; i >= 355; i--) {
			solComboBox.addItem(Integer.toString(i));
		}
		okButton.setBounds(558, 450, 100, 30);
		okButton.setFont(new Font("Montserrat", Font.PLAIN, 14));
		informacoes.setBounds(730, 10, 480, 580);
		informacoes.setBackground(new Color(25,25,25,0));
		informacoes.setBorder(new EmptyBorder(0,0,0,0));
		informacoes.setForeground(Color.white);
		informacoes.setFont(new Font("Montserrat", Font.PLAIN, 13));
		informacoes.setEditable(false);
		ajustesJLabel(solInfoJLabel, 530, 215, 20);
		ajustesJLabel(dataInfoJLabel, 530, 245, 15);
		ajustesJLabel(highInfoJLabel, 530, 320, 17);
		ajustesJLabel(lowInfoJLabel, 530, 350, 17);
		
		/***/
		add(voltarButton);
		add(solJLabel);
		add(solComboBox);
		add(okButton);
		add(informacoes);
		add(fundoInsightJLabel);

		/***/
		@SuppressWarnings("unused")
		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (arg0.getSource().equals(voltarButton)) {
					setVisible(false);
					Frm1Principal.principal.fundoSetVisible(true);

				}else if(arg0.getSource().equals(okButton)) {
					insight = Request.requestInSight(solComboBox.getSelectedItem().toString());
					ajustar();
				}
			}

			
		}
		voltarButton.addActionListener(new EventoButton());
		okButton.addActionListener(new EventoButton());
	}
	
	private void ajustesJLabel(JLabel l, int x, int y, int f) {
		l.setBounds(x, y, 150, 30);
		l.setHorizontalAlignment(0);
		l.setFont(new Font("Montserrat", Font.PLAIN, f));
		l.setForeground(Color.white);
		add(l);
	}
	
	private void ajustar() {
		solInfoJLabel.setText("Sol " + insight.getSol());
		dataInfoJLabel.setText(mesToString(insight.getMeasurement().getFirst()));
		String maxTemp = insight.getAir().getTemperature().getMaximum();
		String lowTemp = insight.getAir().getTemperature().getMinimum();
		highInfoJLabel.setText("High: " + InSight.celsiusConverter(Double.parseDouble(maxTemp)) + " C");
		lowInfoJLabel.setText("Low: "+ InSight.celsiusConverter(Double.parseDouble(lowTemp)) + " C");
		informacoes.setText(insight.toString());
	}
	
	private String mesToString(String data) {
		String mes = data.substring(5,7);
		String dia = data.substring(8,10);
		String ano = data.substring(0,4);
		switch(mes) {
		case "01": return "Jan. " + dia + " " + ano;
		case "02": return "Fev. " + dia + " " + ano;
		case "03": return "Mar. " + dia + " " + ano;
		case "04": return "Abr. " + dia + " " + ano;
		case "05": return "Mai. " + dia + " " + ano;
		case "06": return "Jun. " + dia + " " + ano;
		case "07": return "Jul. " + dia + " " + ano;
		case "08": return "Ago. " + dia + " " + ano;
		case "09": return "Set. " + dia + " " + ano;
		case "10": return "Out. " + dia + " " + ano;
		case "11": return "Nov. " + dia + " " + ano;
		case "12": return "Dez. " + dia + " " + ano;
		}
		return null;
	}
		
}
