package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class Program { //exemplo de remoção no BD, utilizar exceptions para verificar se o dado a ser removido
						//possui algo atrelado antes

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?");
						
			st.setInt(1, 5);// Deleta o departamento de código 5
			//st.setInt(1, 2);// Deleta o departamento de código 2
			// ocorre exception pois o departamento possui dados atrelados a ele
			//Cannot delete or update a parent row: a foreign key constraint fails (`coursejdbc`.`seller`, CONSTRAINT `seller_ibfk_1` FOREIGN KEY (`DepartmentId`) REFERENCES `department` (`Id`))
			
			int rowsAffected = st.executeUpdate();
			System.out.println("OK! Rows Affected: " + rowsAffected);
		}catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
			//se não pode deletar, lança a exceção personalizada:
			//Cannot delete or update a parent row: a foreign key constraint fails (`coursejdbc`.`seller`, CONSTRAINT `seller_ibfk_1` FOREIGN KEY (`DepartmentId`) REFERENCES `department` (`Id`))
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();			
		}
	}

}
