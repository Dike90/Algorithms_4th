package Sort;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by DK on 2017/1/13.
 * 8Kints takes around 200ms.
 * on aliyun ECS 1Mints takes 4575.502s,it's longer than SelectionSort.
 * then I will test a optimization method, it's takes 3785.033s, it's faster.
 */
public class Insertion {
    public static void sort(Comparable [] a)
    {
        int N = a.length;
        for (int i = 1; i< N; i++) {
           // Comparable temp = a[i];
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
             //   a[j] = a[j-1];
               // a[j-1] = temp;
                exch(a, j, j-1);
            }


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
            //System.out.println(directory.getAbsolutePath());
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
            System.out.println("isSorted: "+isSorted(a));

        }
        catch (Exception e)
        {

        }
    }

}
