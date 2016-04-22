package es.uniovi.asw.votingdb.persistence;

import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

/**
 * Created by Fabio on 20/04/2016.
 */
public class OptionFinder {
    public static Option findById(Long id) {
    return Jpa.getManager().find(Option.class, id);
}
}
