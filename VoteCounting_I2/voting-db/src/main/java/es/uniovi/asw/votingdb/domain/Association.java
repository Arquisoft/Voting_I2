package es.uniovi.asw.votingdb.domain;

import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Voter;

/**
 * List of associations between classes in the model
 *
 * Created by Fabio on 11/04/2016.
 */
public class Association {

    /**
     * One voter belong to (exactly) one polling station
     */
    public static class Belong{

        public static void link(Voter voter, PollingStation pollingStation){
            voter.setPollingStation(pollingStation);
            pollingStation._getVoters().add(voter);
        }
        public static void unlink(Voter voter, PollingStation pollingStation){
            pollingStation._getVoters().remove(voter);
            voter.setPollingStation(null);
        }
    }

    /**
     * One polling station exercises voting (because vote is anonymous so voter cannot vote directly
     */
    public static class Exercise{

        public static void link(PollingStation pollingStation, Vote vote){
            vote.setPollingStation(pollingStation);
            pollingStation._getVotes().add(vote);
        }
        public static void unlink(PollingStation pollingStation, Vote vote){
            pollingStation._getVotes().remove(vote);
            vote.setPollingStation(null);
        }
    }

    /**
     * One vote is in favor of one option
     */
    public static class InFavorOf{

        public static void link(Option option,Vote vote){
            vote.setOption(option);
            option._getVotes().add(vote);
        }
        public static void unlink(Option option, Vote vote){
            option._getVotes().remove(vote);
            vote.setOption(null);
        }
    }
}
