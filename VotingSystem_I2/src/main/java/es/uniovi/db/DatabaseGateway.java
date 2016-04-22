package es.uniovi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import es.uniovi.db.util.Jdbc;
import es.uniovi.electoral.model.Configuration;
import es.uniovi.electoral.model.Option;
import es.uniovi.electoral.model.PollingStation;

public class DatabaseGateway {

	public void insertOption(Option option) throws SQLException {
		Connection con = Jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("Insert into OPTIONS Values (?,?,?)");
		
		ps.setLong(1, option.getId());
		ps.setString(2, option.getName());
		ps.setString(3, option.getComment());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}

	public void reset() throws SQLException {
		Connection con = Jdbc.getConnection();
		Statement st = con.createStatement();
		
		st.executeUpdate("DELETE FROM OPTIONS");
		st.executeUpdate("DELETE FROM VOTES");
		st.executeUpdate("DELETE FROM POLLING_STATION");
		st.executeUpdate("DELETE FROM CONFIGURATION");
		
		st.close();
		con.close();
	}

	public void insertStation(PollingStation station)
			throws SQLException {
		Connection con = Jdbc.getConnection();
		PreparedStatement ps = con
				.prepareStatement("Insert into POLLING_STATION Values (?,?,?,?,?)");

		ps.setLong(1, station.getCode());
		ps.setString(2, station.getProvince());
		ps.setString(3, station.getCity());
		ps.setString(4, station.getDistrict());
		ps.setString(5, station.getCountry());

		ps.executeUpdate();
		ps.close();
		con.close();
	}

	public void configure(Configuration conf) throws SQLException {
		Connection con = Jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO CONFIGURATION VALUES (?,?,?,?,?)");
		
		ps.setString(1, conf.getName());
		ps.setTimestamp(2, conf.getStartDate());
		ps.setTimestamp(3, conf.getEndDate());
		ps.setString(4, conf.getType());
		ps.setString(5, conf.getComment());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
}
