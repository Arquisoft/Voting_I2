package es.uniovi.asw.votingdb.business.impl.voter;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.exception.VoterNotFoundException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Voter;
import es.uniovi.asw.votingdb.persistence.VoterFinder;

import javax.persistence.NoResultException;

public class GetVoter implements Command<Voter> {

    private String email;
    private String password;

    public GetVoter(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            return VoterFinder.findByEmailAndPassword(email, password);
        } catch (NoResultException e) {
            throw new VoterNotFoundException();
        }
    }
}
