package es.uniovi.asw.counting;

import es.uniovi.asw.votingdb.infrastructure.ServicesFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.File;
import java.io.IOException;

public class VoteCount {

    public static void main(String[] args) throws Exception {
        run();
    }

    public static void run() throws Exception {
        String inputPath = "temp_input";
        new File(inputPath).mkdir();
        new VoteReader(ServicesFactory.createVoteService(),
                inputPath+"/votes").readVotes();
        Configuration conf = new Configuration();
        Job job = new Job(conf);
        job.setMapperClass(VoteMapper.class);
        job.setReducerClass(VoteReducer.class);
        job.setJarByClass(VoteMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        TextInputFormat.addInputPath(job, new Path(inputPath));
        FileSystem fs = FileSystem.get(conf);
        Path out = new Path("temp_out");
        fs.delete(out, true);
        TextOutputFormat.setOutputPath(job, out);
        job.waitForCompletion(true);
    }

}
