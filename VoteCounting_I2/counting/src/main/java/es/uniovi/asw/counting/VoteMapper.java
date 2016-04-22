package es.uniovi.asw.counting;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class VoteMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final static IntWritable addOne = new IntWritable(1);

    protected void map(LongWritable key, Text option, Context context)
            throws IOException, InterruptedException {
            context.write(option, addOne);
    }

}
