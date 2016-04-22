package es.uniovi.asw.counting;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ParseVotesTest {

    @Test
    public void readVotes() throws Exception {
        String[] options = {"a","b", "c", "d"};
        String fileName = "temp_read";

        new VoteReader(new MockVoteService(options), fileName).readVotes();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName)))) {
            for (String option : options) {
                assertEquals(option, reader.readLine());
            }
            assertNull(reader.readLine());
        }
        new File(fileName).delete();
    }

}