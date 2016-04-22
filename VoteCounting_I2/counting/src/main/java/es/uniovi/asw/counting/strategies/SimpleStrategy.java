package es.uniovi.asw.counting.strategies;

public class SimpleStrategy implements CountStrategy {

    @Override
    public int getValue(String line, int accumulator) {
        return 1 + accumulator;
    }
}
