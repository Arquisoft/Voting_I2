package es.uniovi.asw.votingdb.business.impl.voter;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.exception.VoterNotFoundException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Voter;
import es.uniovi.asw.votingdb.persistence.VoterFinder;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

import javax.persistence.NoResultException;

public class UpdatePassword implements Command<Voter> {
    private Voter voter;
    private String password;

    public UpdatePassword(Voter voter, String password) {
        this.voter = voter;
        this.password = password;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            voter = VoterFinder.findByEmail(voter.getEmail());
            voter.setPassword(password);
            return Jpa.getManager().merge(voter);
        } catch (NoResultException e) {
            throw new VoterNotFoundException();
        }
    }
}
