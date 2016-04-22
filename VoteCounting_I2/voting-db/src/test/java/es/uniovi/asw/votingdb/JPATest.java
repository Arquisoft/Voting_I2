package es.uniovi.asw.votingdb;



import es.uniovi.asw.votingdb.business.OptionService;
import es.uniovi.asw.votingdb.business.PollingStationService;
import es.uniovi.asw.votingdb.business.VoteService;
import es.uniovi.asw.votingdb.business.VoterService;
import es.uniovi.asw.votingdb.business.exception.VoterNotFoundException;
import es.uniovi.asw.votingdb.domain.*;
import es.uniovi.asw.votingdb.infrastructure.ServicesFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class JPATest {
    @Test
    public void testRetrieve() {
        String email = "test@test.es";
        String password = "test";
        Voter voter = new Voter("Test", "71866423B", email);
        voter.setPassword(password);

        VoterService vs = ServicesFactory.createVoterService();
        vs.updateVoter(voter);

        assertEquals(voter, vs.getVoter(email, password));

        vs.deleteVoter(voter);
    }

    @Test
    public void testUpdatePassword() {
        String email = "test@test.es";
        String password = "old";
        Voter voter = new Voter("Test", "71866423B", email);
        voter.setPassword(password);

        VoterService vs = ServicesFactory.createVoterService();
        vs.updateVoter(voter);

        assertEquals(voter, vs.getVoter(email, password));

        String newPassword = "new";
        vs.updatePassword(voter, newPassword);

        assertEquals(voter, vs.getVoter(email, newPassword));

        vs.deleteVoter(voter);
    }

    @Test
    public void testGetNumberVotes(){
        PollingStation p1 = new PollingStation("Asturias", "Jogin", "Cimavilla", "España");
        Option o1 = new Option("oo","oo");

        PollingStationService ps = ServicesFactory.createpollingStationService();
        OptionService os = ServicesFactory.createOptionService();
        VoteService vs = ServicesFactory.createVoteService();

        p1=ps.updatePollingStation(p1);
        o1=os.updateOption(o1);

        Vote v1 = new Vote(o1,p1);
        v1=vs.updateVote(v1);

        assertEquals(1L,vs.getNumberVotesOptionPolling(p1,o1));
        assertTrue(vs.getVotesPolling(p1).contains(v1));

        vs.deleteVote(v1);
        ps.deletePollingStation(p1);
        os.deleteOption(o1);
    }

    @Test
    public void getAll() {
        PollingStationService ps = ServicesFactory.createpollingStationService();
        OptionService os = ServicesFactory.createOptionService();
        VoteService vs = ServicesFactory.createVoteService();
        for (Vote vote : vs.getAllVotes()) {
            vs.deleteVote(vote);
        }

        PollingStation p1 = new PollingStation("Asturias", "Jogin", "Cimavilla", "España");
        Option o1 = new Option("oo","oo");

        p1=ps.updatePollingStation(p1);
        o1=os.updateOption(o1);

        Vote v1 = new Vote(o1,p1);
        v1=vs.updateVote(v1);

        List<Vote> votes = new ArrayList<Vote>();
        votes.add(v1);
        assertEquals(votes, vs.getAllVotes());
    }

    @Test(expected = VoterNotFoundException.class)
    public void testNotFound() throws Exception {
        VoterService vs = ServicesFactory.createVoterService();
        vs.getVoter("thisemaildoesnotexist@never.org", "thispassneither");
    }

}
