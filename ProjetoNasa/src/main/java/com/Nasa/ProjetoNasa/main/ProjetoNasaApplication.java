package com.Nasa.ProjetoNasa.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Nasa.ProjetoNasa.ui.Frm1Principal;

@SpringBootApplication
public class ProjetoNasaApplication {

	public static void main(String args[]) {
		Frm1Principal.principal = new Frm1Principal();
	}

}
