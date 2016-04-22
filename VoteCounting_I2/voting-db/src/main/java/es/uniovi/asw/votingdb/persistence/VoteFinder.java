package es.uniovi.asw.votingdb.persistence;

import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

import java.util.List;
import java.util.Set;

/**
 * Created by Fabio on 12/04/2016.
 */
public class VoteFinder {
    public static List<Vote> findByPollingStation(PollingStation pollingStation) {
        return Jpa.getManager()
                .createNamedQuery("Vote.findByPollingStation", Vote.class)
                .setParameter(1, pollingStation)
                .getResultList();
    }
    public static long countByPollingStationAndOption(PollingStation pollingStation,Option option) {
        return Jpa.getManager()
                .createNamedQuery("Vote.countByPollingStationAndOption", Long.class)
                .setParameter(1, pollingStation)
                .setParameter(2, option)
                .getSingleResult();
    }
    public static Vote findById(Long id) {
        return Jpa.getManager().find(Vote.class, id);
    }

    public static List<Vote> findAll() {
        return Jpa.getManager()
                .createNamedQuery("Vote.findAll", Vote.class)
                .getResultList();
    }
}
