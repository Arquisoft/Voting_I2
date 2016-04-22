package es.uniovi.asw.votingdb.business.impl.voter;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Voter;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

public class UpdateVoter implements Command<Voter> {
    private Voter voter;

    public UpdateVoter(Voter voter) {
        this.voter = voter;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            return Jpa.getManager().merge(voter);
        } catch (Exception e) {
            throw new BusinessException();
        }
    }
}
