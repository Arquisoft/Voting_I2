package es.uniovi.asw.votingdb.business.impl.vote;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.exception.VotesNotFoundException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.persistence.VoteFinder;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Fabio on 12/04/2016.
 */
public class GetNumberVotesOptionPolling implements Command<Long> {

    private PollingStation pollingStation;
    private Option option;

    public GetNumberVotesOptionPolling(PollingStation pollingStation, Option option) {
        this.pollingStation = pollingStation;
        this.option =option;
    }

    @Override
    public Long execute() throws BusinessException {
        try {
            return VoteFinder.countByPollingStationAndOption(pollingStation,option);
        } catch (NoResultException e) {
            throw new VotesNotFoundException();
        }
    }
}
