package com.Nasa.ProjetoNasa.model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class Utils {

	public static void ajustesBotao(JButton b, int x, int y, String s, String toolTip) {
		b.setBounds(x, y, b.getIcon().getIconWidth(), b.getIcon().getIconHeight());
		b.setRolloverIcon(new ImageIcon(Utils.class.getResource(s)));
		b.setToolTipText(toolTip);
		b.setBackground(new Color(0, 0, 0, 0));
		b.setForeground(Color.white);
		b.setFont(new Font("Consolas", Font.BOLD, 23));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setCursor(new Cursor(12));
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		b.setVerticalAlignment(SwingConstants.CENTER);
		b.setFont(new Font("Nasalization Rg", Font.BOLD, 15));
	}
	
	public static void ajustesBotao(JButton b, String text, int x, int y, String toolTip) {
		b.setText("<html>"+text+"</html>".toUpperCase());
		b.setBounds(x, y, 121, 62);
		b.setFocusPainted(false);
		b.setBorderPainted(false);
		b.setToolTipText(toolTip);
		b.setForeground(Color.white);
		b.setCursor(new Cursor(12));
		b.setContentAreaFilled(false);
		b.setBackground(new Color(0, 0, 0, 0));
		b.setVerticalAlignment(SwingConstants.CENTER);
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		b.setFont(new Font("Nasalization Rg", Font.BOLD, 15));
		b.setRolloverIcon(new ImageIcon(Utils.class.getResource("/02_botao_rolover.png")));
	}
	
	public static void ajustesComboBox(JComboBox<String> c, int x, int y) {
		c.setBounds(x, y, 100, 30);
		c.setFont(new Font("Montserrat", Font.PLAIN, 14));
	}
	
	@SuppressWarnings("deprecation")
	public static boolean validarData(String dia, String mes, String ano) {
		
		Date hoje = new Date();
		Date min = new Date(1995 - 1900, 6-1, 1);
		Date d = new Date();
		d.setDate(Integer.parseInt(dia));
		d.setMonth(Integer.parseInt(mes)-1);
		d.setYear(Integer.parseInt(ano)-1900);
		
		if(Integer.parseInt(dia)<1 || Integer.parseInt(dia)>31) {
			return false;
		}else if(Integer.parseInt(mes)<1 || Integer.parseInt(mes)>12) {
			return false;
		}
		
		if(d.before(min)) {
			return false;
		}else if(d.after(hoje)) {
			return false;
		}else if(d.equals(hoje)) {
			return true;
		}else if(d.after(min)) {
			return true;
		}
		
		return true;
	}

	
	public static String organizarData(String dia, String mes, String ano) {
		String data = "";
		data += ano + "-" + mes + "-" + dia;
		return data;
	}
	
	public static String dataPadraoBr(String data) {
		String dia = data.substring(8, 10);
		String mes = data.substring(5, 7); 
		String ano = data.substring(0, 4); 
		String hora = data.substring(11, 18);
		
		switch(mes) {
		case "01": mes = "Jan"; break;
		case "02": mes = "Fev"; break;
		case "03": mes = "Mar"; break;
		case "04": mes = "Abr"; break;
		case "05": mes = "Mai"; break;
		case "06": mes = "Jun"; break;
		case "07": mes = "Jul"; break;
		case "08": mes = "Ago"; break;
		case "09": mes = "Set"; break;
		case "10": mes = "Out"; break;
		case "11": mes = "Nov"; break;
		case "12": mes = "Dec"; break;
		}
		return dia + " " + mes + " " + ano + "  -  " + hora;
	}
	
	public static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
	
	public static void botaoVoltar(JButton b) {
		ImageIcon voltarImageIcon = new ImageIcon(Utils.class.getResource("/09_botao_voltar.png"));
		b.setIcon(voltarImageIcon);
		Utils.ajustesBotao(b, 0, 10, "/10_botao_voltar_rolover.png", null);
	}	
	
}
