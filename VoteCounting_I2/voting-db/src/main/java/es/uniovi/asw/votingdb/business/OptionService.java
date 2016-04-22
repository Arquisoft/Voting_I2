package es.uniovi.asw.votingdb.business;

import es.uniovi.asw.votingdb.domain.Option;

/**
 * Created by Fabio on 20/04/2016.
 */
public interface OptionService {

    Option updateOption(Option option);

    Option deleteOption(Option option);
}
