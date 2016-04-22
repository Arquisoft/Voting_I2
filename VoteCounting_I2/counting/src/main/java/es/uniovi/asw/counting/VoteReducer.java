package es.uniovi.asw.counting;

import es.uniovi.asw.resultsdb.business.ResultsService;
import es.uniovi.asw.resultsdb.infrastructure.ServicesFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class VoteReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private ResultsService db = ServicesFactory.createResultsService();

    public VoteReducer() {
    }

    public VoteReducer(ResultsService db) {
        this.db = db;
    }

    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        context.write(key, new IntWritable(sum));
        persist(key.toString(), sum);
    }

    private void persist(String option, int sum) {
        if (db != null) {
            db.createResultEntry(option, "", sum);
        }
    }
}