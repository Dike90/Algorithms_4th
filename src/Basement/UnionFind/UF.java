package Basement.UnionFind;

import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by DK on 2017/1/12.
 */
public class UF {
    private int[] id;
    private int count;
    public UF( int N)
    {
        count = N;
        id = new int [N];
        for (int i = 0 ; i< N ; i++)
        {
            id[i] = i;
        }
    }
    public int count(){ return count;}
    public boolean connected( int p ,int q)
    {
        return quick_find(p) == quick_find(q);
    }
    //can handle 100M data. totally 745.935s
    //625 data consume 0.04 seconds
    public int find( int p)
    {
        return id[p];
    }

    public int quick_find(int p)
    {
        while ( p != id[p])
            p = id[p];
        return p;
    }

    public void  union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return;
        for (int i =0; i< id.length; i++)
        {
            if (id[i] == qID)
                id[i]=pID;
        }
        count--;
    }
    //can't handle 100M data it may takes hours.
    //but 10M data will very fast.
    public void quick_union(int p, int q)
    {
        int pRoot = quick_find(p);
        int qRoot = quick_find(q);
        if (pRoot == qRoot)
            return;
        id[qRoot] = pRoot; //takes very long time.

        count--;
    }

    public static void main( String [] args)
    {
        //System.out.println("Please enter a number: ");
        try {
            FileReader fReader = new FileReader("E://IdeaProjects/Algorithms/src/algs4-data/largeUF.txt");
            Scanner sc = new Scanner(fReader);
            int N = sc.nextInt();
            long start = System.currentTimeMillis();
            UF uf = new UF(N);
            while (sc.hasNextInt())
            {
                int p = sc.nextInt();
                int q = sc.nextInt();
                if (uf.connected(p , q)) continue;
                uf.quick_union(p,q);
                System.out.print(p + "--" + q);
                System.out.println(" " +uf.count() + " components.");
            }
            System.out.println(uf.count() + " components.");
            long end = System.currentTimeMillis();
            System.out.println((end - start)/1000.0 + " seconds");
        }
        catch (Exception e)
        {

        }


    }

}
