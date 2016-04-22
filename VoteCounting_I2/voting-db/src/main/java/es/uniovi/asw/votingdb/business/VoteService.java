package es.uniovi.asw.votingdb.business;

import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;

import java.util.List;

/**
 * Created by Fabio on 11/04/2016.
 */
public interface VoteService {

    /**
     * Returns the list of all votes (not ordered, not grouped) of one polling station
     * @param pollingStation The polling station from which you need the votes
     * @return set of votes of this polling station
     */
    List<Vote> getVotesPolling(PollingStation pollingStation);

    /**
     * Returns the number of votes to one option in a given polling station
     * @param pollingStation The polling station from which you need the votes
     * @param option the option from which you want to know the number of votes
     * @return the number of votes to this option in this polling station
     */
    long getNumberVotesOptionPolling(PollingStation pollingStation, Option option);

    Vote updateVote(Vote vote);

    Vote deleteVote(Vote vote);

    List<Vote> getAllVotes();

}
