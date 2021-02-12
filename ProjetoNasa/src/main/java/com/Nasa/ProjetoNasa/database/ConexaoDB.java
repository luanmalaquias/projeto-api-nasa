package com.Nasa.ProjetoNasa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	
	public static Connection conexao;
	
	public static Connection abrirConexao() {
		try {
			String url = "jdbc:sqlite:sqLiteDb/Dados.db";
			conexao = DriverManager.getConnection(url);
			return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void fecharConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
