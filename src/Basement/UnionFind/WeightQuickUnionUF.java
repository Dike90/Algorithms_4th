package Basement.UnionFind;

import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by DK on 2017/1/12.
 * totally consume 12.792s, it's very fast.
 */
public class WeightQuickUnionUF {
    private int [] id;
    private int [] sz;
    private int count;
    public WeightQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i=0; i< N; i++)
        {
            id[i] = i;
            sz[i] = 1;
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
        while (p != id[p])
            p = id[p];
        return p;
    }
    public void union(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        //if p tree smaller than q tree ,then connect p to q;
        if (sz[pRoot] < sz[qRoot])
        {
            id[pRoot] = qRoot;
            //recalculate the q tree size
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
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
            int lines = 0;
            while (sc.hasNext())
            {
                //lines++;
                int p = sc.nextInt();
                int q = sc.nextInt();
                //System.out.print( "has handled:"+ lines + "lines,");
                if (wuf.connected(p,q))
                    continue;
                wuf.union(p,q);
                System.out.println(p +"--"+ q );


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
