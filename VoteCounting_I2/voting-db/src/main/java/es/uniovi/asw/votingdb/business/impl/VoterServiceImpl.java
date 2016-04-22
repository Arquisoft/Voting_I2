package es.uniovi.asw.votingdb.business.impl;

import es.uniovi.asw.votingdb.business.VoterService;
import es.uniovi.asw.votingdb.business.exception.VoterNotFoundException;
import es.uniovi.asw.votingdb.business.impl.voter.DeleteVoter;
import es.uniovi.asw.votingdb.business.impl.voter.GetVoter;
import es.uniovi.asw.votingdb.business.impl.voter.UpdatePassword;
import es.uniovi.asw.votingdb.business.impl.voter.UpdateVoter;
import es.uniovi.asw.votingdb.domain.Voter;

public class VoterServiceImpl implements VoterService {
    @Override
    public Voter getVoter(String email, String password)
            throws VoterNotFoundException {
        return CommandExecutor.execute(new GetVoter(email, password));
    }

    @Override
    public Voter updatePassword(Voter voter, String password) {
        return CommandExecutor.execute(new UpdatePassword(voter, password));
    }

    @Override
    public Voter updateVoter(Voter voter) {
        return CommandExecutor.execute(new UpdateVoter(voter));
    }

    @Override
    public Voter deleteVoter(Voter voter) {
        return CommandExecutor.execute(new DeleteVoter(voter));
    }
}
