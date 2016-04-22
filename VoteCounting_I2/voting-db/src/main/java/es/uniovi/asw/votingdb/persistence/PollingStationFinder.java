package es.uniovi.asw.votingdb.persistence;

import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

/**
 * Created by Fabio on 20/04/2016.
 */
public class PollingStationFinder {
    public static PollingStation findById(Long id) {
    return Jpa.getManager().find(PollingStation.class, id);
}
}
