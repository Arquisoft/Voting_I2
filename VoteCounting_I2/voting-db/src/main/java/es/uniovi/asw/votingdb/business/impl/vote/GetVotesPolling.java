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
import java.util.Set;

/**
 * Created by Fabio on 12/04/2016.
 */
public class GetVotesPolling implements Command<List<Vote>> {

    private PollingStation pollingStation;

    public GetVotesPolling(PollingStation pollingStation) {
        this.pollingStation = pollingStation;
    }

    @Override
    public List<Vote> execute() throws BusinessException {
        try {
            return VoteFinder.findByPollingStation(pollingStation);
        } catch (NoResultException e) {
            throw new VotesNotFoundException();
        }
    }
}
