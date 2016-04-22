package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import es.uniovi.db.util.Jdbc;


public class JdbcTest {

	@Test
	public void testConnection() throws SQLException {
		Connection con = Jdbc.getConnection();
		
		Statement stmnt = con.createStatement();
		stmnt.execute("Select * From voters where password = 'pass'");
		ResultSet rs = stmnt.getResultSet();
		
		while (rs.next()) {
			assertEquals(rs.getString("email"), "test@test");
			}
		
	}
}
