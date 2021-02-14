package com.Nasa.ProjetoNasa.model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Utils {

	public static void ajustesBotao(JButton b, int x, int y, ImageIcon i) {
		b.setBounds(x, y, b.getIcon().getIconWidth(), b.getIcon().getIconHeight());
		b.setRolloverIcon(i);
		b.setBackground(new Color(0, 0, 0, 0));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setCursor(new Cursor(12));
	}

	public static void ajustesTextField(JTextField t, int x, int y) {
		t.setBounds(x, y, 100, 30);
		t.setHorizontalAlignment(0);
		t.setFont(new Font("Montserrat", Font.PLAIN, 14));

		class EventoFoco implements FocusListener {
			@Override
			public void focusGained(FocusEvent arg0) {
				t.selectAll();
			}
			@Override
			public void focusLost(FocusEvent arg0) {
			}
		}
		t.addFocusListener(new EventoFoco());
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
	
	public static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
	
}
