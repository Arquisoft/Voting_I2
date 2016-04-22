package es.uniovi.asw.votingdb.business.impl.voter;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.exception.VoterNotFoundException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Voter;
import es.uniovi.asw.votingdb.persistence.VoterFinder;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

import javax.persistence.NoResultException;

public class DeleteVoter implements Command<Voter> {
    private Voter voter;

    public DeleteVoter(Voter voter) {
        this.voter = voter;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            Jpa.getManager().remove(VoterFinder.findByEmail(voter.getEmail()));
            return voter;
        } catch (NoResultException e) {
            throw new VoterNotFoundException();
        }
    }
}
