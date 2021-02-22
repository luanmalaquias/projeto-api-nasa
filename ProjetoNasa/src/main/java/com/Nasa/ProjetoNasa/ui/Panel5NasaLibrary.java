package com.Nasa.ProjetoNasa.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Nasa.ProjetoNasa.apiRest.Request;
import com.Nasa.ProjetoNasa.model.NasaLibrary;
import com.Nasa.ProjetoNasa.model.Utils;
import com.Nasa.ProjetoNasa.model.nasalibrary.Item;

public class Panel5NasaLibrary extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel5NasaLibrary() {
		setVisible(false);
		setBounds(0, 0, 1217, 597);
		setLayout(null);

		initialize();
	}

	private ImageIcon fundoIcon;
	private JLabel fundoLabel;
	private JButton voltarBt;
	private JTextField searchField;
	private JScrollPane scrollPane;
	private JPanel buttonPane;
	private boolean panel = false;
	private NasaLibrary nasaLibrary;
	private ArrayList<JLabel> linksButtons;

	private void initialize() {
		/***/
		fundoIcon = new ImageIcon(getClass().getResource("/NasaLibrary/01_fundo_library.png"));
		fundoLabel = new JLabel(fundoIcon);
		voltarBt = new JButton();
		searchField = new JTextField(10);
		buttonPane = new JPanel(null);
		scrollPane = new JScrollPane(buttonPane);
		linksButtons = new ArrayList<>();

		/***/
		fundoLabel.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
		Utils.botaoVoltar(voltarBt);
		searchField.setBounds(340, 200, 500, 40);
		searchField.setBorder(new EmptyBorder(0, 0, 0, 0));
		searchField.setFont(new Font("Montserrat", Font.PLAIN, 15));
		scrollPane.setBounds(200, 80, 1017, 517);
		scrollPane.setVisible(false);
		scrollPane.getViewport().setBackground(new Color(33, 33, 33));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		buttonPane.setBackground(new Color(33, 33, 33));

		/***/
		add(voltarBt);
		add(searchField);
		add(scrollPane);
		add(fundoLabel);

		/***/
		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource().equals(voltarBt)) {
					fundoLabel.setIcon(new ImageIcon(getClass().getResource("/NasaLibrary/01_fundo_library.png")));
					searchField.setBounds(340, 200, 500, 40);
					searchField.setText("");
					scrollPane.setVisible(false);
					if (!panel) {
						setVisible(false);
						Frm1Principal.principal.fundoSetVisible(true);
					}
					panel = false;

				} else if (arg0.getSource().equals(searchField) && !searchField.getText().equals("")) {
					if(!panel) {
						fundoLabel.setIcon(new ImageIcon(getClass().getResource("/NasaLibrary/02_fundo_library_rolover.png")));
						searchField.setBounds(210, 10, 500, 40);
						scrollPane.setVisible(true);
					}
					nasaLibrary = Request.requestNasaLibrary(searchField.getText(), "image");
					createButtons(nasaLibrary.getCollection().getItems().size());
					scrollPane.getVerticalScrollBar().setValue(0);
					panel = true;
				}
			}
		}

		voltarBt.addActionListener(new EventoButton());
		searchField.addActionListener(new EventoButton());

	}

	private void createButtons(int size) {
		
		int tamanhoY = 80;
		buttonPane.setPreferredSize(new Dimension(900, size*tamanhoY));
		linksButtons.clear();
		buttonPane.removeAll();
		buttonPane.setVisible(false);
		buttonPane.setVisible(true);
		organizarPorData();
		
		for (int i = 0; i < size; i++) {
			try {
				String title = nasaLibrary.getCollection().getItems().get(i).getData().get(0).getTitle();
				String description = nasaLibrary.getCollection().getItems().get(i).getData().get(0).getDescription();
				String data = Utils.dataPadraoBr(nasaLibrary.getCollection().getItems().get(i).getData().get(0).getDate_created());
				if(description!=null && description.length()>100) {
					description = description.substring(0, 100) + "...";
				}else {
					description += "...";
				}
				if(title.equals(description)) {
					description = "";
				}
		
				JLabel titleLabel = new JLabel(title);
				titleLabel.setCursor(new Cursor(12));
				titleLabel.setForeground(new Color(92,141,222));
				titleLabel.setFont(new Font("Montserrat", Font.PLAIN, 18));
				titleLabel.setName(Integer.toString(i));
				
				JLabel descriptionLabel = new JLabel(description);
				descriptionLabel.setForeground(new Color(70,70,70));
				descriptionLabel.setFont(new Font("Roboto", Font.PLAIN, 15));

				JLabel dateLabel = new JLabel(data);
				dateLabel.setForeground(new Color(90,90,90));
				dateLabel.setFont(new Font("Robot", Font.PLAIN, 13));
				
				linksButtons.add(titleLabel);
				linksButtons.add(descriptionLabel);
				linksButtons.add(dateLabel);
				
				class EventoCLick implements MouseListener{
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int i = Integer.parseInt(arg0.getComponent().getName());
						@SuppressWarnings("unused")
						Panel5NasaLibrary2 p = new Panel5NasaLibrary2(nasaLibrary.getCollection().getItems().get(i));
					}

					public void mouseEntered(MouseEvent arg0) {
						arg0.getComponent().setFont(new Font("Montserrat", Font.ITALIC, 18));
						arg0.getComponent().setForeground(new Color(173, 198, 239));
					}

					public void mouseExited(MouseEvent arg0) {
						arg0.getComponent().setFont(new Font("Montserrat", Font.PLAIN, 18));
						arg0.getComponent().setForeground(new Color(92,141,222));
					}
					public void mousePressed(MouseEvent arg0) {}
					public void mouseReleased(MouseEvent arg0) {}
				}

				titleLabel.addMouseListener(new EventoCLick());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int i = 0, y = 0; i < linksButtons.size(); i += 3, y += tamanhoY) {
			linksButtons.get(i).setBounds(0, y, 800, tamanhoY);
			linksButtons.get(i + 1).setBounds(0, y + 20, 800, tamanhoY);
			linksButtons.get(i + 2).setBounds(0, y + 40, 800, tamanhoY);
			buttonPane.add(linksButtons.get(i));
			buttonPane.add(linksButtons.get(i + 1));
			buttonPane.add(linksButtons.get(i + 2));
		}
		
	}

	@SuppressWarnings("deprecation")
	private void organizarPorData() {
		
		for (int i = 0; i < nasaLibrary.getCollection().getItems().size(); i++) {
			for (int j = 0; j < nasaLibrary.getCollection().getItems().size(); j++) {
				int anoJ = Integer.parseInt(nasaLibrary.getCollection().getItems().get(j).getData().get(0).getDate_created().substring(0, 4));
				int mesJ = Integer.parseInt(nasaLibrary.getCollection().getItems().get(j).getData().get(0).getDate_created().substring(5, 7));
				int diaJ = Integer.parseInt(nasaLibrary.getCollection().getItems().get(j).getData().get(0).getDate_created().substring(8, 10));
				Date dateJ = new Date(anoJ-1900, mesJ+1, diaJ);
				int anoI = Integer.parseInt(nasaLibrary.getCollection().getItems().get(i).getData().get(0).getDate_created().substring(0, 4));
				int mesI = Integer.parseInt(nasaLibrary.getCollection().getItems().get(i).getData().get(0).getDate_created().substring(5, 7));
				int diaI = Integer.parseInt(nasaLibrary.getCollection().getItems().get(i).getData().get(0).getDate_created().substring(8, 10));
				Date dateI = new Date(anoI-1900, mesI+1, diaI);
								
				if(dateI.after(dateJ)) {
					Item itemj = nasaLibrary.getCollection().getItems().get(j);
					Item itemi = nasaLibrary.getCollection().getItems().get(i);
					nasaLibrary.getCollection().getItems().set(j, itemi);
					nasaLibrary.getCollection().getItems().set(i, itemj);
				}
			}
		}
	}
}
