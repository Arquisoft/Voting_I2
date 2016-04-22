package es.uniovi.db.interfaces;

import java.util.List;

import com.sun.media.sound.InvalidDataException;

import es.uniovi.electoral.model.Configuration;
import es.uniovi.electoral.model.Option;
import es.uniovi.electoral.model.PollingStation;

public interface Create {

	public void create(Configuration conf, List<Option> options, List<PollingStation> stations) throws InvalidDataException;
}
