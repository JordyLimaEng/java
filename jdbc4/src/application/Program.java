package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement( //atualizar table
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? " //atualizar cada valor na table
					+ "WHERE "
					+ "(DepartmentId = ?)" //atualiza salarios do departamento informado
					);
			st.setDouble(1, 200);//incrementa em 200 os salarios
			st.setInt(2, 2);// incrementa os salarios do department 2
			
			int rowsAffected = st.executeUpdate();
			System.out.println("OK! Rows Affected: " + rowsAffected);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();			
		}
	}

}
