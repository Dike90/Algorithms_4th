package Basement.UnionFind;

import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by DK on 2017/1/12.
 * it may little slower than weightquickunionUF
 * 10.253s
 */
public class HeightQuickUnionUF {
    private int [] id;
    private int [] height;
    private int count;
    public HeightQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        height = new int[N];
        for (int i=0; i< N; i++)
        {
            id[i] = i;
            height[i] = 1;
        }
    }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    public int count()
    {
        return count;
    }
    public int find(int p)
    {
        int i =0;
        while (p != id[p]) {
            p = id[p];
            i++;
        }
        if (i > height[p])
            height[p] = i;
        return p;
    }
    public void union(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        //if p tree shorter than q tree ,then connect p to q;
        if (height[pRoot] < height[qRoot])
        {
            id[pRoot] = qRoot;
            //recalculate the q tree height
            height[qRoot] += height[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            height[pRoot] += height[qRoot];
        }
        count--;
    }

    public static void  main(String [] args)
    {
        try {

            FileReader fReader = new FileReader("E://IdeaProjects/Algorithms/src/algs4-data/largeUF.txt");
            Scanner sc = new Scanner(fReader);
            int N = sc.nextInt();
            long start = System.currentTimeMillis();
            WeightQuickUnionUF wuf = new WeightQuickUnionUF(N);
            while (sc.hasNext())
            {
                int p = sc.nextInt();
                int q = sc.nextInt();
                if (wuf.connected(p,q))
                    continue;
                wuf.union(p,q);
                System.out.println(p +"--"+ q );
               // System.out.println( ","+wuf.count() + " components.");

            }
           System.out.println(wuf.count() + " components.");
            long end = System.currentTimeMillis();
            System.out.println((end - start)/1000.0 + " seconds");
        }
        catch (Exception e)
        {

        }
    }
}
