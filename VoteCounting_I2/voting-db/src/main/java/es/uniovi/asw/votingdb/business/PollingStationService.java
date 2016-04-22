package es.uniovi.asw.votingdb.business;

import es.uniovi.asw.votingdb.domain.PollingStation;

/**
 * Created by Fabio on 20/04/2016.
 */
public interface PollingStationService {

    PollingStation updatePollingStation(PollingStation pollingStation);
    PollingStation deletePollingStation(PollingStation pollingStation);
}
