package com.Nasa.ProjetoNasa.ui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.Nasa.ProjetoNasa.model.Apod;
import com.Nasa.ProjetoNasa.model.Utils;

public class Panel1Apod2 extends JFrame {

	private static final long serialVersionUID = 1L;
	Apod apod;

	public Panel1Apod2(Apod apod) {
		super("APOD");
		try {
			this.apod = apod;
			setSize(1200, 600);
			setLocationRelativeTo(null);
			setLayout(null);
			setIconImage(new ImageIcon(getClass().getResource("/Apod/apod_icon.png")).getImage());
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setExtendedState(MAXIMIZED_BOTH);
			initialize();
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ImageIcon fundoImageIcon, urlImageIcon, webViewIcon, hdWebViewIcon, videoPlayerIcon;
	private ImageIcon webViewIconRolOver, hdWebViewIconRolOver, videoPlayerIconRolOver;
	private JLabel fundoJLabel, title, data, copyright, mediaType, serviceVersion, urlImageJLabel;
	private JTextArea explanationArea;
	private URL url;
	private JScrollPane scrollPane;
	private JButton webView, hdWebView, videoPlayer;

	private void initialize() {
		/***/

		try {
			url = new URL(apod.getUrl());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		fundoImageIcon = new ImageIcon(getClass().getResource("/Apod/11_apod_view.png"));
		fundoJLabel = new JLabel(fundoImageIcon);
		webViewIcon = new ImageIcon(getClass().getResource("/Apod/12_botao_web_view.png"));
		webViewIconRolOver = new ImageIcon(getClass().getResource("/Apod/13_botao_web_view_rolover.png"));
		hdWebViewIcon = new ImageIcon(getClass().getResource("/Apod/14_botao_hdweb_view.png"));
		hdWebViewIconRolOver = new ImageIcon(getClass().getResource("/Apod/15_botao_hdweb_view_rolover.png"));
		urlImageIcon = new ImageIcon(url);
		videoPlayerIcon = new ImageIcon(getClass().getResource("/Apod/16_video_player.png"));
		videoPlayerIconRolOver = new ImageIcon(getClass().getResource("/Apod/17_video_player_rolover.png"));
		videoPlayer = new JButton(videoPlayerIcon);

		title = new JLabel(apod.getTitle());
		data = new JLabel(apod.getDate());
		copyright = new JLabel(apod.getCopyright());
		mediaType = new JLabel(apod.getMedia_type());
		serviceVersion = new JLabel(apod.getService_version());
		explanationArea = new JTextArea("     " + apod.getExplanation());
		scrollPane = new JScrollPane(explanationArea);
		urlImageJLabel = new JLabel(urlImageIcon);
		webView = new JButton(webViewIcon);
		hdWebView = new JButton(hdWebViewIcon);

		/***/
		ajustesJLabel(title, 0, 10, 20);
		title.setSize(1366,30);
		title.setHorizontalAlignment(0);
		ajustesJLabel(copyright, 280, 30, 20);
		ajustesJLabel(data, 280, 50, 20);
		ajustesJLabel(mediaType, 280, 70, 20);
		ajustesJLabel(serviceVersion, 280, 90, 20);
		scrollPane.setBounds(1090, 10, 270, 695);
		explanationArea.setEditable(false);
		explanationArea.setFont(new Font("Arial", Font.PLAIN, 14));
		explanationArea.setBackground(new Color(25, 25, 25));
		explanationArea.setForeground(new Color(200, 200, 200));
		explanationArea.setLineWrap(true);
		explanationArea.setWrapStyleWord(true);
		urlImageJLabel.setBounds(280, 0, 800, 740);
		urlImageJLabel.setHorizontalAlignment(0);
		Utils.ajustesBotao(webView, 280, 670, webViewIconRolOver);
		Utils.ajustesBotao(hdWebView, 679, 670, hdWebViewIconRolOver);
		Utils.ajustesBotao(videoPlayer, 649, 360, videoPlayerIconRolOver);
		boolean a = (apod.getMedia_type().equals("video")) ? true : false;
		videoPlayer.setVisible(a);
		fundoJLabel.setBounds(0, 0, fundoImageIcon.getIconWidth(), fundoImageIcon.getIconHeight());

		/***/
		add(title);
		add(copyright);
		add(data);
		add(mediaType);
		add(serviceVersion);
		add(scrollPane);
		add(webView);
		add(hdWebView);
		add(videoPlayer);
		add(urlImageJLabel);
		add(fundoJLabel);

		/***/

		class EventoButton implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (arg0.getSource().equals(webView)) {
						Desktop.getDesktop().browse(new URI(apod.getUrl()));

					} else if (arg0.getSource().equals(hdWebView)) {
						Desktop.getDesktop().browse(new URI(apod.getHdurl()));
					}else if(arg0.getSource().equals(videoPlayer)) {
						Desktop.getDesktop().browse(new URI(apod.getUrl()));
					}
				} catch (Exception e) {
				}
			}
		}

		webView.addActionListener(new EventoButton());
		hdWebView.addActionListener(new EventoButton());
		videoPlayer.addActionListener(new EventoButton());
	}

	private void ajustesJLabel(JLabel l, int x, int y, int f) {
		l.setBounds(x, y, 300, 30);
		l.setFont(new Font("Bahnschrift", Font.PLAIN, f));
		l.setForeground(Color.white);
	}
	
	/*public static void main(String args[]) {
		String explicacao = "This gorgeous island universe lies about 85 million light-years distant in the southern constellation Fornax. Inhabited by young blue star clusters, the tightly wound spiral arms of NGC 1350 seem to join in a circle around the galaxy's large, bright nucleus, giving it the appearance of a cosmic eye. In fact, NGC 1350 is about 130,000 light-years across. That makes it as large or slightly larger than the Milky Way. For earth-based astronomers, NGC 1350 is seen on the outskirts of the Fornax cluster of galaxies, but its estimated distance suggests that it is not itself a cluster member. Of course, the bright spiky stars in the foreground of this telescopic field of view are members of our own spiral Milky Way galaxy.";
		Apod apod = new Apod("luan", "20210-02-11", explicacao, "https://apod.nasa.gov/apod/image/2102/NGC1350_crop.jpg", "video", "v1", "Spiral Galaxy NGC 1350", "https://www.youtube.com/embed/4on-e614tag?rel=0");
		new Panel1Apod2(apod);
	}*/
}
