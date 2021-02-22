package com.Nasa.ProjetoNasa.ui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Nasa.ProjetoNasa.model.Utils;

public class Panel4TrekImagery extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel4TrekImagery() {
		setVisible(false);
		setBounds(0, 0, 1217, 597);
		setLayout(null);

		initialize();
	}

	private JButton voltarBt;
	private ImageIcon fundoIcon;
	private JLabel fundoLabel;

	private ImageIcon globalI, curiosityI, martianI, mc11I, spiritI, opportunityI, phoenixI, sajournerI, molaI, cmolaI,
			teisI, mvI;
	private JButton globalB, curiosityB, martianB, mc11B, spiritB, opportunityB, phoenixB, sajournerB, molaB, cmolaB,
			teisB, mvB;

	private void initialize() {
		/***/
		fundoIcon = new ImageIcon(getClass().getResource("/Trek/00_fundo_trekimagery.png"));
		fundoLabel = new JLabel(fundoIcon);
		fundoLabel.setBounds(0, 0, fundoIcon.getIconWidth(), fundoIcon.getIconHeight());
		voltarBt = new JButton();
		Utils.botaoVoltar(voltarBt);

		globalI = new ImageIcon(getClass().getResource("/Trek/01_bt_global.png"));
		curiosityI = new ImageIcon(getClass().getResource("/Trek/03_bt_curiosity.png"));
		martianI = new ImageIcon(getClass().getResource("/Trek/05_bt_martianeast.png"));
		mc11I = new ImageIcon(getClass().getResource("/Trek/07_bt_mc11.png"));
		spiritI = new ImageIcon(getClass().getResource("/Trek/09_bt_spirit.png"));
		opportunityI = new ImageIcon(getClass().getResource("/Trek/11_bt_opportunity.png"));
		phoenixI = new ImageIcon(getClass().getResource("/Trek/13_bt_phoenix.png"));
		sajournerI = new ImageIcon(getClass().getResource("/Trek/15_bt_sajourner.png"));
		molaI = new ImageIcon(getClass().getResource("/Trek/17_bt_mola.png"));
		cmolaI = new ImageIcon(getClass().getResource("/Trek/19_bt_cmola.png"));
		teisI = new ImageIcon(getClass().getResource("/Trek/21_bt_teis.png"));
		mvI = new ImageIcon(getClass().getResource("/Trek/23_bt_mv.png"));

		globalB = new JButton(globalI);
		curiosityB = new JButton(curiosityI);
		martianB = new JButton(martianI);
		mc11B = new JButton(mc11I);
		spiritB = new JButton(spiritI);
		opportunityB = new JButton(opportunityI);
		phoenixB = new JButton(phoenixI);
		sajournerB = new JButton(sajournerI);
		molaB = new JButton(molaI);
		cmolaB = new JButton(cmolaI);
		teisB = new JButton(teisI);
		mvB = new JButton(mvI);

		/***/
		int x = 40;
		int y = 40;
		Utils.ajustesBotao(globalB, x, y, "/Trek/02_bt_global_rolover.png", null);
		Utils.ajustesBotao(curiosityB, (x + 253) + x, y, "/Trek/04_bt_curiosity_rolover.png", null);
		Utils.ajustesBotao(martianB, (x + 253 * 2) + x * 2, y, "/Trek/06_bt_martianeast_rolover.png", null);
		Utils.ajustesBotao(mc11B, (x + 253 * 3) + x * 3, y, "/Trek/08_bt_mc11_rolover.png", null);
		Utils.ajustesBotao(spiritB, x, (y + 143) + y, "/Trek/10_bt_spirit_rolover.png", null);
		Utils.ajustesBotao(opportunityB, (x + 253) + x, (y + 143) + y, "/Trek/12_bt_opportunity_rolover.png", null);
		Utils.ajustesBotao(phoenixB, (x + 253 * 2) + x * 2, (y + 143) + y, "/Trek/14_bt_phoenix_rolover.png", null);
		Utils.ajustesBotao(sajournerB, (x + 253 * 3) + x * 3, (y + 143) + y, "/Trek/16_bt_sajourner_rolover.png", null);
		Utils.ajustesBotao(molaB, x, (y + 143 * 2) + y * 2, "/Trek/18_bt_mola_rolover.png", null);
		Utils.ajustesBotao(cmolaB, (x + 253) + x, (y + 143 * 2) + y * 2, "/Trek/20_bt_cmola_rolover.png", null);
		Utils.ajustesBotao(teisB, (x + 253 * 2) + x * 2, (y + 143 * 2) + y * 2, "/Trek/22_bt_teis_rolover.png", null);
		Utils.ajustesBotao(mvB, (x + 253 * 3) + x * 3, (y + 143 * 2) + y * 2, "/Trek/24_bt_mv_rolover.png", null);

		/***/

		add(voltarBt);
		add(globalB);
		add(curiosityB);
		add(martianB);
		add(mc11B);
		add(spiritB);
		add(opportunityB);
		add(phoenixB);
		add(sajournerB);
		add(molaB);
		add(cmolaB);
		add(teisB);
		add(mvB);
		add(fundoLabel);

		/***/

		class EventoButton implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (arg0.getSource().equals(voltarBt)) {
						setVisible(false);
						Frm1Principal.principal.fundoSetVisible(true);

					} else if (arg0.getSource().equals(globalB)) {
						Desktop.getDesktop().browse(new URI(
								"https://api.nasa.gov/mars-wmts/catalog/Mars_Viking_MDIM21_ClrMosaic_global_232m.html"));

					} else if (arg0.getSource().equals(curiosityB)) {
						Desktop.getDesktop().browse(
								new URI("https://api.nasa.gov/mars-wmts/catalog/mars_pahrump_patch_8k_256m.html"));

					} else if (arg0.getSource().equals(martianB)) {
						Desktop.getDesktop()
								.browse(new URI("https://api.nasa.gov/mars-wmts/catalog/HRSC_Martian_east.html"));

					} else if (arg0.getSource().equals(mc11B)) {
						Desktop.getDesktop()
								.browse(new URI("https://api.nasa.gov/mars-wmts/catalog/MC11E_HRMOSCO_COL.html"));

					} else if (arg0.getSource().equals(spiritB)) {
						Desktop.getDesktop()
								.browse(new URI("https://api.nasa.gov/mars-wmts/catalog/spirit_hirise_mosaic.html"));

					} else if (arg0.getSource().equals(opportunityB)) {
						Desktop.getDesktop().browse(
								new URI("https://api.nasa.gov/mars-wmts/catalog/opportunity_hirise_mosaic.html"));

					} else if (arg0.getSource().equals(phoenixB)) {
						Desktop.getDesktop()
								.browse(new URI("https://api.nasa.gov/mars-wmts/catalog/phoenix_hirise_mosaic.html"));

					} else if (arg0.getSource().equals(sajournerB)) {
						Desktop.getDesktop()
								.browse(new URI("https://api.nasa.gov/mars-wmts/catalog/sojourner_hirise_mosaic.html"));

					} else if (arg0.getSource().equals(molaB)) {
						Desktop.getDesktop().browse(new URI(
								"https://api.nasa.gov/mars-wmts/catalog/Mars_MGS_MOLA_DEM_mosaic_global_463m_8.html"));

					} else if (arg0.getSource().equals(cmolaB)) {
						Desktop.getDesktop().browse(new URI(
								"https://api.nasa.gov/mars-wmts/catalog/Mars_MGS_MOLA_ClrShade_merge_global_463m.html"));

					} else if (arg0.getSource().equals(teisB)) {
						Desktop.getDesktop().browse(new URI(
								"https://api.nasa.gov/mars-wmts/catalog/Mars_MO_THEMIS-IR-Night_mosaic_60N60S_100m_v14_clon0_ly.html"));

					} else if (arg0.getSource().equals(mvB)) {
						Desktop.getDesktop()
								.browse(new URI("https://api.nasa.gov/mars-wmts/catalog/hrsc_mawrth_vallis.html"));
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		voltarBt.addActionListener(new EventoButton());
		globalB.addActionListener(new EventoButton());
		curiosityB.addActionListener(new EventoButton());
		martianB.addActionListener(new EventoButton());
		mc11B.addActionListener(new EventoButton());
		spiritB.addActionListener(new EventoButton());
		opportunityB.addActionListener(new EventoButton());
		phoenixB.addActionListener(new EventoButton());
		sajournerB.addActionListener(new EventoButton());
		molaB.addActionListener(new EventoButton());
		cmolaB.addActionListener(new EventoButton());
		teisB.addActionListener(new EventoButton());
		mvB.addActionListener(new EventoButton());
		

	}

}
