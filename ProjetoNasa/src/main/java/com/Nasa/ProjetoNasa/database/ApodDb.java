package com.Nasa.ProjetoNasa.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

@SuppressWarnings("unused")
public class ApodDb {
	
	private Connection conexao;
	private PreparedStatement insert;
	private PreparedStatement select;

	public ApodDb() {
		try {
			conexao = ConexaoDB.abrirConexao();
			insert = conexao.prepareStatement("INSERT INTO apod VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			select = conexao.prepareStatement("SELECT * FROM apod WHERE data = ?");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
