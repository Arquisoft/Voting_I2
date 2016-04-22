package es.uniovi.asw.votingdb.business.impl.option;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.exception.OptionNotFoundException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.persistence.OptionFinder;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

import javax.persistence.NoResultException;

/**
 * Created by Fabio on 20/04/2016.
 */
public class DeleteOption implements Command<Option> {
    private Option option;

    public DeleteOption(Option option) {
        this.option = option;
    }

    @Override
    public Option execute() throws BusinessException {
        try {
            Jpa.getManager().remove(OptionFinder.findById(option.getOption_id()));
            return option;
        } catch (NoResultException e) {
            throw new OptionNotFoundException();
        }
    }
}
