package com.Nasa.ProjetoNasa.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.Nasa.ProjetoNasa.apiRest.Request;
import com.Nasa.ProjetoNasa.model.HistoryEvents;
import com.Nasa.ProjetoNasa.model.Utils;

public class Panel6HistoryEvents extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel6HistoryEvents() {

		setVisible(false);
		setBounds(0, 0, 1217, 597);
		setLayout(null);

		initialize();
	}

	private ImageIcon fundoIcon, fundo2Icon;
	private JLabel fundoLabel, fundo2Label;
	private JButton voltarBtn, buscarConteudoBtn;
	private JScrollPane scrollPane;
	private JPanel panel;
	private HistoryEvents[] historyEvents;
	private int tamanhoTotalTela = 80;
	private boolean fakePanel = false;

	private void initialize() {
		/***/
		buscarConteudoBtn = new JButton();
		voltarBtn = new JButton();
		fundoIcon = new ImageIcon(getClass().getResource("/HistoryEvents/01_fundo.png"));
		fundoLabel = new JLabel(fundoIcon);
		panel = new JPanel(null);
		scrollPane = new JScrollPane(panel);
		fundo2Icon = new ImageIcon(getClass().getResource("/HistoryEvents/02_fundo2.png"));
		fundo2Label = new JLabel(fundo2Icon);

		/***/
		scrollPane.setBounds(31, 0, 1176, 597);
		scrollPane.getViewport().setBackground(new Color(33, 33, 33));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setVisible(false);

		Utils.ajustesBotao(buscarConteudoBtn, "Content", 550, 283, "Search SpaceX Content");
		buscarConteudoBtn.setIcon(new ImageIcon(getClass().getResource("/HistoryEvents/03_botao_buscar.png")));
		buscarConteudoBtn.setRolloverIcon(new ImageIcon(getClass().getResource("/HistoryEvents/04_botao_buscar_rolover.png")));

		fundoLabel.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
		panel.setBackground(new Color(33, 33, 33));
		Utils.botaoVoltar(voltarBtn);
		fundo2Label.setBounds(0, 0, 1197, 597);

		/***/
		add(scrollPane);
		add(buscarConteudoBtn);
		add(voltarBtn);
		add(fundoLabel);

		/***/
		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource().equals(voltarBtn)) {
					if(!fakePanel) {
						setVisible(false);
						Frm1Principal.principal.fundoSetVisible(true);
						scrollPane.getVerticalScrollBar().setValue(0);
					}else {
						buscarConteudoBtn.setVisible(true);
						scrollPane.setVisible(false);
						fakePanel = false;
					}
					
				} else if (arg0.getSource().equals(buscarConteudoBtn)) {
					historyEvents = Request.requestHistoryEventsSpaceX();
					buscarConteudoBtn.setVisible(false);
					scrollPane.getVerticalScrollBar().setAutoscrolls(false);
					scrollPane.setVisible(true);
					buscarConteudo();
					fakePanel = true;
				}
			}
		}
		voltarBtn.addActionListener(new EventoButton());
		buscarConteudoBtn.addActionListener(new EventoButton());	
	}

	private void limparTela() {
		buscarConteudoBtn.setVisible(true);
		panel.removeAll();
	}

	public void buscarConteudo() {
		limparTela();
		for (int i = 0; i < historyEvents.length; i++) {
			/***/
			JLabel title = new JLabel(historyEvents[i].getTitle());
			JLabel date = new JLabel(historyEvents[i].getEvent_date_utc().substring(0, 10));
			JLabel link = new JLabel(historyEvents[i].getLinks().getArticle());
			String detailsString = historyEvents[i].getDetails();
			String html = "<html><body style='width: %1spx'>"+detailsString+"</body></html>";
			JLabel details = new JLabel(html);
			
			/***/
			details.setName(Integer.toString(i));
			title.setBounds(50, 80+(i*200), 700, 25);
			title.setFont(new Font("Montserrat", Font.PLAIN, 25));
			title.setForeground(Color.white);
			date.setBounds(65, 105+(i*200), 700, 15);
			date.setFont(new Font("Montserrat", Font.PLAIN, 15));
			date.setForeground(Color.white);
			link.setBounds(65,125+(i*200), 700, 15);
			link.setFont(new Font("Montserrat", Font.PLAIN, 15));
			link.setForeground(Color.white);
			link.setCursor(new Cursor(12));
			details.setBounds(65, 140+(i*200), 1079, 130);
			details.setFont(new Font("Montserrat", Font.PLAIN, 15));
			details.setVerticalAlignment(JLabel.TOP);
			details.setBorder(new EmptyBorder(0, 0, 0, 0));
			details.setForeground(Color.white);
			details.setBackground(new Color(33, 33, 33));
			
			/***/
			class EventoLabel implements MouseListener{
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						Desktop.getDesktop().browse(new URI(link.getText()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {}
				public void mouseReleased(MouseEvent arg0) {}
			}
			
			link.addMouseListener(new EventoLabel());
			
			/***/
			panel.add(title);
			panel.add(date);
			panel.add(link);
			panel.add(details);

			tamanhoTotalTela += 200;
		}
		panel.setPreferredSize(new Dimension(700, tamanhoTotalTela));
		panel.add(fundo2Label);
	}
}
