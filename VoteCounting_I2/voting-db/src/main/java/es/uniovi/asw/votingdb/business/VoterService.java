package es.uniovi.asw.votingdb.business;

import es.uniovi.asw.votingdb.business.exception.VoterNotFoundException;
import es.uniovi.asw.votingdb.domain.Voter;

public interface VoterService {

    Voter getVoter(String email, String password) throws VoterNotFoundException;

    Voter updatePassword(Voter voter, String password);

    Voter updateVoter(Voter voter);

    Voter deleteVoter(Voter voter);
}
