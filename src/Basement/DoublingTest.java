package Basement;

/**
 * Created by DK on 2017/1/11.
 */
public class DoublingTest {
    public static double timeTrial(int N)
    {
        int MAX = 1000000;
        int [] a = new int [N];
        for (int i = 0; i< N ; i++)
        {
            a[i] = -MAX + (int) (Math.random() * 2 * MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = TwoSumFast.count(a);
        return timer.elapsedTime();
    }
    public static void main(String [] args)
    {
        for (int N = 250 ; true ; N +=N)
        {
            double time = timeTrial(N);
            System.out.println("N: "+ N + " time consume : "+ time + " seconds");
        }
    }
}
