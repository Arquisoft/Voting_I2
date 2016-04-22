package es.uniovi.asw.votingdb.business.impl.vote;

import es.uniovi.asw.votingdb.business.exception.BusinessException;
import es.uniovi.asw.votingdb.business.impl.Command;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.persistence.VoteFinder;

import java.util.List;

public class GetAllVotes implements Command<List<Vote>> {
    @Override
    public List<Vote> execute() throws BusinessException {
        return VoteFinder.findAll();
    }
}
