package es.uniovi.asw.counting;

import es.uniovi.asw.votingdb.business.VoteService;
import es.uniovi.asw.votingdb.domain.Vote;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class VoteReader {
    private VoteService db;
    private String outputFile;

    public VoteReader(VoteService db, String outputFile) {
        this.db = db;
        this.outputFile = outputFile;
    }

    public void readVotes() {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile)))) {
            for (Vote vote : db.getAllVotes()) {
                writer.write(vote.getOption().getName());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
