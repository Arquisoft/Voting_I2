package es.uniovi.electoral;

import java.util.List;

import com.sun.media.sound.InvalidDataException;

import es.uniovi.db.interfaces.Create;
import es.uniovi.db.ports.CreateP;
import es.uniovi.electoral.model.Configuration;
import es.uniovi.electoral.model.Option;
import es.uniovi.electoral.model.PollingStation;

public class CreateR {

	public void create( Configuration conf, List<Option> options, List<PollingStation> stations) throws InvalidDataException {
	
		Create cr = new CreateP();
			cr.create(conf, options, stations);
		
	}
	
}
