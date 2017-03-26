package Sort;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DK on 2017/1/13.
 * 8Kints consume around 200ms,1Mints takes very very long time. 6493.707s
 * on aliyun ECS 1Mints takes 3426.502s
 *
 */
public class Selection {
    public static void sort(Comparable[] a)
    {
        for (int i=0; i< a.length ; i++)
        {
            int min = i;
            for (int j = i+1 ; j < a.length; j++)
            {
                if (less(a[j] , a[min]))
                {
                    min = j;
                }
            }
            exch(a,i,min);
        }
    }
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable [] a)
    {
        for (int i = 0 ; i < a.length ; i ++)
        {
            System.out.println(a[i] + " ");
        }
        //System.out.println();
    }
    public static boolean isSorted(Comparable [] a)
    {
        for (int i=1 ; i< a.length; i++)
            if (less(a[i] , a[i-1]))
                return false;
        return true;
    }

    public static void  main(String [] args)
    {
        try {
            File directory = new File("");
            FileReader fReader = new FileReader(directory.getAbsolutePath()+"/algs4-data/8Kints.txt");
            Scanner sc = new Scanner(fReader);
            Integer[] a = new Integer[8000];
            int i = 0;
            while (sc.hasNextInt())
            {
                a[i] = sc.nextInt();
                i++;
            }
            long start = System.nanoTime();
            sort(a);
            long end = System.nanoTime();
            show(a);
            System.out.println((end - start)/ 1000000.0 + "ms");

        }
        catch (Exception e)
        {

        }
    }
}
