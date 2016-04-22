package es.uniovi.asw.votingdb.business.impl;

import es.uniovi.asw.votingdb.business.PollingStationService;
import es.uniovi.asw.votingdb.business.impl.polling.DeletePollingStation;
import es.uniovi.asw.votingdb.business.impl.polling.UpdatePollingStation;
import es.uniovi.asw.votingdb.domain.PollingStation;

/**
 * Created by Fabio on 20/04/2016.
 */
public class PollingStationServiceImpl implements PollingStationService {
    @Override
    public PollingStation updatePollingStation(PollingStation pollingStation) {
        return CommandExecutor.execute(new UpdatePollingStation(pollingStation));
    }

    @Override
    public PollingStation deletePollingStation(PollingStation pollingStation) {
        return CommandExecutor.execute(new DeletePollingStation(pollingStation));
    }
}
