package es.uniovi.asw.votingdb.business.impl.vote;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

/**
 * Created by Fabio on 20/04/2016.
 */
public class UpdateVote implements Command<Vote> {
    private Vote vote;

    public UpdateVote(Vote vote) {
        this.vote = vote;
    }

    @Override
    public Vote execute() throws BusinessException {
        try {
            return Jpa.getManager().merge(vote);
        } catch (Exception e) {
            throw e;
            //throw new BusinessException();
        }
    }
}
