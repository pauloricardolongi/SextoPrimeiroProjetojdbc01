package aplicacao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Programa {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		//ATUALIZAR SAL�RIOS
		try {
			conn = DB.getConnection();
			st =  conn.prepareStatement(
					
					"DELETE FROM department "
					+ "WHERE "
				    + "Id = ?");
			st.setInt(1, 2);
			
					
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
