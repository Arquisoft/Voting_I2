package es.uniovi.asw.votingdb.business.impl;

import es.uniovi.asw.votingdb.business.OptionService;
import es.uniovi.asw.votingdb.business.impl.option.DeleteOption;
import es.uniovi.asw.votingdb.business.impl.option.UpdateOption;
import es.uniovi.asw.votingdb.domain.Option;

/**
 * Created by Fabio on 20/04/2016.
 */
public class OptionServiceImpl implements OptionService {
    @Override
    public Option updateOption(Option option) {
        return CommandExecutor.execute(new UpdateOption(option));
    }

    @Override
    public Option deleteOption(Option option) {
        return CommandExecutor.execute(new DeleteOption(option));
    }
}
