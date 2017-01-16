package Basement;

import java.util.*;
import java.util.Arrays;

public class BinarySearch {



public static void main(String [] args)
{
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter a list number as a whitelist(less than 100 numbers):");
	int [] whitelist = new int[100];
	int i = 0;
	while(in.hasNext())
	{
		whitelist[i] = in.nextInt();
		i ++;
	}
	
	System.out.println("please enter a number to look up:");
	
	while(in.hasNext())
	{
		int key = in.nextInt();
		if(rank(key , whitelist) < 0)
			System.out.println(key);
	}
	in.close();
	
}

public static int rank(int key , int [] a)
{
	int lo = 0;
	int hi = a.length -1;
	while(lo <= hi)
	{
		int mid = lo + (hi - lo) /2;
		if(key < a[mid]) 
			hi = mid - 1;
		else if(key > a[mid]) 
			lo = mid + 1;
		else 
			return mid;
	}
	return -1;
}

}
