package es.uniovi.db.ports;

import java.sql.SQLException;
import java.util.List;

import com.sun.media.sound.InvalidDataException;

import es.uniovi.db.DatabaseGateway;
import es.uniovi.db.interfaces.Create;
import es.uniovi.electoral.model.Configuration;
import es.uniovi.electoral.model.Option;
import es.uniovi.electoral.model.PollingStation;

public class CreateP implements Create {

	
	@Override
	public void create(Configuration conf, List<Option> options,
			List<PollingStation> stations) throws InvalidDataException {
		try {
			DatabaseGateway dbg = new DatabaseGateway(); 
			
			dbg.reset();
			for (Option opt : options) {
				dbg.insertOption(opt);
			}
			
			for (PollingStation station : stations) {
				dbg.insertStation(station);
			}
			
			dbg.configure(conf);
		} catch (SQLException e) {
			System.out.print(e);
			throw new InvalidDataException("Data invalid");
		} 
	}
}
