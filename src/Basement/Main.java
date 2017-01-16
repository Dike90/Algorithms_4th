package Basement;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import edu.princeton.cs.algs4.StdDraw;
public class Main {

    public static void main(String[] args) {
        MyStack<String> s = new MyStack<String>();

        try {
            FileReader rdf = new FileReader("E://IdeaProjects/Algorithms/src/algs4-data/tobe.txt");
            Scanner scf = new Scanner(rdf);
            StdDraw.setPenRadius(0.05);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(1, 0.5);
            StdDraw.setPenColor(StdDraw.MAGENTA);
            StdDraw.line(0.2, 0.2, 0.8, 0.2);

        }
        catch (Exception e)
        {
            ;
        }


    }
}
