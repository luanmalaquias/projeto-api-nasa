package com.Nasa.ProjetoNasa.ui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.Nasa.ProjetoNasa.apiRest.Request;
import com.Nasa.ProjetoNasa.model.Utils;
import com.Nasa.ProjetoNasa.model.nasalibrary.Item;

public class Panel5NasaLibrary2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private Item item;

	public Panel5NasaLibrary2(Item item) {
		super("NASA LIBRARY");
		try {
			this.item = item;
			setLayout(null);
			setSize(1366, 768);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setIconImage(new ImageIcon(getClass().getResource("/NasaLibrary/nasa_library_icon.png")).getImage());
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			if (screenSize.getWidth() == 1366 && screenSize.getHeight() == 768) {
				setExtendedState(MAXIMIZED_BOTH);
			}
			initialize();
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JScrollPane scrollPane;
	private JPanel painel;
	private URL url;
	private ImageIcon fundoIcon, linkIcon;
	private JLabel fundoLabel, linkLabel, titleLabel, idLabel, dateLabel, creatorLabel, keywordsLabel;
	private JTextArea descriptionArea;
	private String title;
	private String id;
	private String date;
	private String creator;
	private String keywords;
	private String descriptions;
	private JButton botaoLink;

	private void initialize() {
		/***/
		fundoIcon = new ImageIcon(getClass().getResource("/NasaLibrary/03_fundo_library_jp.png"));
		fundoLabel = new JLabel(fundoIcon);
		painel = new JPanel(null);
		scrollPane = new JScrollPane(painel);

		if (item.getData().get(0).getTitle() != null)
			title = item.getData().get(0).getTitle();
		if (item.getData().get(0).getNasa_id() != null)
			id = item.getData().get(0).getNasa_id();
		if (item.getData().get(0).getDate_created() != null)
			date = item.getData().get(0).getDate_created().substring(0, 10).replace("-", "/");
		if (item.getData().get(0).getSecondary_creator() != null)
			creator = item.getData().get(0).getSecondary_creator();
		keywords = "<html>";
		if (item.getData().get(0).getKeywords() != null)
			for (int i = 0; i < item.getData().get(0).getKeywords().size(); i++) {
				keywords += item.getData().get(0).getKeywords().get(i) + "<br/></html>";
			}
		if (item.getData().get(0).getDescription() != null)
			descriptions = item.getData().get(0).getDescription();

		titleLabel = new JLabel(title);
		idLabel = new JLabel(id);
		dateLabel = new JLabel(date);
		creatorLabel = new JLabel(creator);
		keywordsLabel = new JLabel(keywords);
		descriptionArea = new JTextArea("  " + descriptions);

		/***/
		scrollPane.setBounds(60, 72, 1256, 670);
		scrollPane.getViewport().setBackground(new Color(33, 33, 33));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		painel.setBackground(new Color(33, 33, 33));

		fundoLabel.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());

		createLabel(titleLabel, 0, 10, 1196, 30, SwingConstants.CENTER, SwingConstants.TOP, 25);
		createLabel(idLabel, 530, 50, 700, 10, SwingConstants.RIGHT, SwingConstants.TOP, 10);
		createLabel(dateLabel, 980, 60, 250, 10, SwingConstants.RIGHT, SwingConstants.TOP, 10);
		createLabel(creatorLabel, 0, 45, 1196, 10, SwingConstants.CENTER, SwingConstants.TOP, 10);
		createLabel(keywordsLabel, 10, 50, 400, 400, SwingConstants.LEFT, SwingConstants.TOP, 10);

		int tam = descriptions.length() / 74 + 1;
		descriptionArea.setBounds(298, 150, 600, tam * 19);
		descriptionArea.setForeground(Color.white);
		descriptionArea.setBackground(new Color(33, 33, 33));
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setEditable(false);
		descriptionArea.setFont(new Font("Montserrat", Font.PLAIN, 15));
		descriptionArea.setBorder(new EmptyBorder(0, 0, 0, 0));
		painel.setPreferredSize(new Dimension(900, (int) descriptionArea.getBounds().getHeight()));

		createImage();

		/***/
		add(scrollPane);
		painel.add(titleLabel);
		painel.add(idLabel);
		painel.add(dateLabel);
		painel.add(creatorLabel);
		painel.add(keywordsLabel);
		painel.add(descriptionArea);
		add(fundoLabel);

		/***/
	}

	private void createLabel(JLabel l, int x, int y, int X, int Y, int h, int v, int fontSize) {
		l.setBounds(x, y, X, Y);
		l.setHorizontalAlignment(h);
		l.setVerticalAlignment(v);
		l.setForeground(Color.white);
		l.setFont(new Font("Montserrat", Font.PLAIN, fontSize));
	}

	private void createImage() {
		try {
			if (item.getLinks() != null) {

				url = new URL(item.getLinks().get(0).getHref());
				linkIcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(700, -1, Image.SCALE_SMOOTH));
				linkLabel = new JLabel(linkIcon);
				linkLabel.setBounds(250, (int) (descriptionArea.getBounds().getMaxY()) + 30, 700, linkIcon.getIconHeight());

				painel.add(linkLabel);
				painel.setPreferredSize(new Dimension(900, (int) descriptionArea.getBounds().getMaxY() + linkIcon.getIconHeight() + 20));

			}
			createPlayButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createPlayButton() {
		if (!item.getData().get(0).getMedia_type().equalsIgnoreCase("image")) {
			ImageIcon playIcon = new ImageIcon(getClass().getResource("/Apod/16_video_player.png"));
			botaoLink = new JButton(playIcon);

			Utils.ajustesBotao(botaoLink, 598, 150, "/Apod/17_video_player_rolover.png", null);
			descriptionArea.setBounds(298, 250, 600, descriptionArea.getBounds().height);

			painel.setPreferredSize( new Dimension(900, (int) (descriptionArea.getBounds().getMaxY() + botaoLink.getBounds().height)));
			painel.add(botaoLink);

			String link = Request.requestUrlNasaLibrary(item.getHref(), item.getData().get(0).getMedia_type());

			botaoLink.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						Desktop.getDesktop().browse(new URI(link));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
