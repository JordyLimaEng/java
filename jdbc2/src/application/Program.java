package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;// conex�o
		Statement st = null; // consulta sql
		ResultSet rs = null; // resultado da consulta

		try {
			conn = DB.getConnection();

			st = conn.createStatement();

			rs = st.executeQuery("select * from department"); // executa comando sql

			while (rs.next()) {
				// pega os inteiros e nomes que estiverem no campo Id e Name do BD
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//� interessante fechar a requisi��o para que n�o ocorra falha de mem�ria durante a execu��o do programa
			DB.closeResultSet(rs); 
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
		

	}

}
