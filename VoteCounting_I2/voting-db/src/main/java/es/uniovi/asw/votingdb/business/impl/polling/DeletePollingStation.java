package es.uniovi.asw.votingdb.business.impl.polling;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.exception.PollingNotFoundException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.persistence.PollingStationFinder;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

import javax.persistence.NoResultException;

/**
 * Created by Fabio on 20/04/2016.
 */
public class DeletePollingStation implements Command<PollingStation> {
    private PollingStation polling;

    public DeletePollingStation(PollingStation polling) {
        this.polling = polling;
    }

    @Override
    public PollingStation execute() throws BusinessException {
        try {
            Jpa.getManager().remove(PollingStationFinder.findById(polling.getPolling_station_code()));
            return polling;
        } catch (NoResultException e) {
            throw new PollingNotFoundException();
        }
    }
}
