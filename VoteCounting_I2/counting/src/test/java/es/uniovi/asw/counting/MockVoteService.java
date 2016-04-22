package es.uniovi.asw.counting;

import es.uniovi.asw.votingdb.business.VoteService;
import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;

import java.util.ArrayList;
import java.util.List;

public class MockVoteService implements VoteService {
    private PollingStation pollingStation = new PollingStation("", "", "","");
    private String[] options;

    public MockVoteService(String[] options) {
        this.options = options;
    }

    @Override
    public List<Vote> getVotesPolling(PollingStation pollingStation) {
        return null;
    }

    @Override
    public long getNumberVotesOptionPolling(PollingStation pollingStation, Option option) {
        return 0;
    }

    @Override
    public Vote updateVote(Vote vote) {
        return null;
    }

    @Override
    public Vote deleteVote(Vote vote) {
        return null;
    }

    @Override
    public List<Vote> getAllVotes() {

        List<Vote> votes = new ArrayList<Vote>();
        for (String option : options) {
            votes.add(new Vote(new Option(option, ""), pollingStation));
        }
        return votes;
    }
}
