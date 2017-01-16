package Basement;

/**
 * Created by DK on 2017/1/11.
 */
public class Stopwatch {
    private final long start;
    public Stopwatch()
    {
        start = System.currentTimeMillis();
    }
    public double elapsedTime()
    {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
