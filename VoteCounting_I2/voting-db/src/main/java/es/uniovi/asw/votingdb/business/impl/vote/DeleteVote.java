package es.uniovi.asw.votingdb.business.impl.vote;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.exception.OptionNotFoundException;
import es.uniovi.asw.votingdb.business.exception.VotesNotFoundException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.persistence.OptionFinder;
import es.uniovi.asw.votingdb.persistence.VoteFinder;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

import javax.persistence.NoResultException;

/**
 * Created by Fabio on 20/04/2016.
 */
public class DeleteVote implements Command<Vote> {
    private Vote vote;

    public DeleteVote(Vote vote) {
        this.vote = vote;
    }

    @Override
    public Vote execute() throws BusinessException {
        try {
            Jpa.getManager().remove(VoteFinder.findById(vote.getId()));
            return vote;
        } catch (NoResultException e) {
            throw new VotesNotFoundException();
        }
    }
}
