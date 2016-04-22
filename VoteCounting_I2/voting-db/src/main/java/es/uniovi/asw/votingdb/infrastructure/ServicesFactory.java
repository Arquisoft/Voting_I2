package es.uniovi.asw.votingdb.infrastructure;

import es.uniovi.asw.votingdb.business.OptionService;
import es.uniovi.asw.votingdb.business.PollingStationService;
import es.uniovi.asw.votingdb.business.VoteService;
import es.uniovi.asw.votingdb.business.VoterService;
import es.uniovi.asw.votingdb.business.impl.OptionServiceImpl;
import es.uniovi.asw.votingdb.business.impl.PollingStationServiceImpl;
import es.uniovi.asw.votingdb.business.impl.VoteServiceImpl;
import es.uniovi.asw.votingdb.business.impl.VoterServiceImpl;
import es.uniovi.asw.votingdb.domain.PollingStation;

public class ServicesFactory {

    public static VoterService createVoterService() {
        return new VoterServiceImpl();
    }
    public static VoteService createVoteService() {
        return new VoteServiceImpl();
    }

    public static PollingStationService createpollingStationService() {
        return new PollingStationServiceImpl();
    }
    public static OptionService createOptionService() {
        return new OptionServiceImpl();
    }
}
