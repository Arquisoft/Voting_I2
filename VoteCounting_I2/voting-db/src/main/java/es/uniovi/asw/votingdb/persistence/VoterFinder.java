package es.uniovi.asw.votingdb.persistence;

import es.uniovi.asw.votingdb.domain.Voter;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

public class VoterFinder {

    public static Voter findById(Long id) {

        return Jpa.getManager().find(Voter.class, id);
    }

    public static Voter findByEmailAndPassword(String email, String password) {
        return Jpa.getManager()
                .createNamedQuery("Voter.findByEmailAndPassword", Voter.class)
                .setParameter(1, email)
                .setParameter(2, password)
                .getSingleResult();
    }

    public static Voter findByEmail(String email) {
        return Jpa.getManager()
                .createNamedQuery("Voter.findByEmail", Voter.class)
                .setParameter(1, email)
                .getSingleResult();
    }
}
