package es.uniovi.asw.votingdb.business.impl.option;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

/**
 * Created by Fabio on 20/04/2016.
 */
public class UpdateOption implements Command<Option> {
    private Option option;

    public UpdateOption(Option option) {
        this.option = option;
    }

    @Override
    public Option execute() throws BusinessException {
        try {
            return Jpa.getManager().merge(option);
        } catch (Exception e) {
            throw new BusinessException();
        }
    }
}
