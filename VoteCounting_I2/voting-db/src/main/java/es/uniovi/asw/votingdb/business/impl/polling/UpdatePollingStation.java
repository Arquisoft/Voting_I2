package es.uniovi.asw.votingdb.business.impl.polling;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.domain.Voter;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

/**
 * Created by Fabio on 20/04/2016.
 */
public class UpdatePollingStation implements Command<PollingStation> {
    private PollingStation polling;

    public UpdatePollingStation(PollingStation polling) {
        this.polling = polling;
    }

    @Override
    public PollingStation execute() throws BusinessException {
        try {
            return Jpa.getManager().merge(polling);
        } catch (Exception e) {
            throw new BusinessException();
        }
    }
}
