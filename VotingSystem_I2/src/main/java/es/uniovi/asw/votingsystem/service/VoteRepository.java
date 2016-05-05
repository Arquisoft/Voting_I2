package es.uniovi.asw.votingsystem.service;

import es.uniovi.asw.votingsystem.model.Vote;
import org.springframework.data.repository.Repository;

public interface VoteRepository extends Repository<Vote, Long> {

    Vote save(Vote vote);
}
