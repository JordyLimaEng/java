package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program { // Transa��es - necessita ser:
	// Atomica
	// Consistente
	// Isolada
	// Dur�vel
	// toda a��o no BD deve seguir estes princ�pios, exemplo de uma transf. Banc�ria

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			//todos os commits ficam pendentes de o programador confirmar, protegendo a transa��o.
			conn.setAutoCommit(false);
			
			st = conn.createStatement();

			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
						
			/*int x=1;
			if(x<2) {// fake error para mostrar a quebra da transa��o
					//solu��o � criar uma prote��o para as transa��es
				throw new SQLException("fake error"); 
			}*/
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3290 WHERE DepartmentId = 2");
			
			conn.commit();//sem esse commit, as altera��es n�o s�o aplicadas
			
			System.out.println("rows1 "+rows1);
			System.out.println("rows2 "+rows2);
		} catch (SQLException e) {
			try {
				conn.rollback();// se der rollback quer dizer que deu um erro
				//ele volta e n�o deixa as altera��es em andamento e anteriores executar
				throw new DbException("Transaction not confirmed, Rollback ocurred!! Error caused by: " + e.getMessage());//indica qual o erro
			} catch (SQLException e1) {// caso ocorra um erro no rollback, lan�a outra exception
				throw new DbException("Error trying to rollback!, Error caused by: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
