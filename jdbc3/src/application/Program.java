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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement("INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES " 
					+ "(?, ?, ?, ?, ?)"// placeholder, local onde vai vir o valor depois
					,Statement.RETURN_GENERATED_KEYS // retorna ID's dos dados inseridos
					);

			// modificando os placeholders
			st.setString(1, "Carlos José");// 1a interrogação, name
			st.setString(2, "carlos@gmail.com");// 2a interrogação, email
			st.setDate(3, new java.sql.Date(sdf.parse("15/05/1985").getTime()));// 3a interrogação, aniver
			st.setDouble(4, 5000.00);// 3a interrogação, salario
			st.setInt(5, 4);// 4a interrogação, departamento
			
			// Outra forma de inserir varios dados em uma table:
			//st = conn.prepareStatement(
			//		"insert into department (Name) values ('D1'), ('D2')",
			//		Statement.RETURN_GENERATED_KEYS
			//		);
			
			int rowsAffected = st.executeUpdate(); // quando a ação é para editar os dados, retorna inteiro com a qt de
													// linhas alteradas
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1); //tabela aux de uma coluna que retorna os id's
					System.out.println("OK! Id = " + id);
				}
			}else {
				System.out.println("No Rows affected!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();}
		 finally {
			DB.closeStatement(st);
			DB.closeConnection();// sempre finaliza a conexão por último
		}

	}

}
