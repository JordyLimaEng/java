package application;

import java.sql.Connection;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();// só chamar esse método q conecta ao banco já implementado no DB.java
		DB.closeConnection();
	}

}
