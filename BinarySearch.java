/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// implement binary search lol
		int[] a = {2,4,7,9,22,45,67,120,250,325,327,333,420};
		System.out.println("boofus");
		System.out.println("index of 45 should be 5, it is" + binarysearch(a, 45));
		System.out.println("index of 251 should be -1, it is" + binarysearch(a, 251));
		System.out.println("index of 7 should be 2, it is" + binarysearch(a, 7));
		assert(binarysearch(a, 45)==5);
		assert(binarysearch(a, 251)==2);
	}
	
	static int binarysearch(int []a, int num) {
		int lower = 0;
		int upper = a.length-1;
		return binaryhelper(a, num, lower, upper);
	}
	static int binaryhelper(int[] a, int num, int lower, int upper) {
		int ind = (upper+lower)/2;
		if (a[ind] == num) return ind;
		else if(lower >= upper) return -1;
		//else return(binaryhelper(a,num,ind+1, upper)||binaryhelper(a,num,lower, ind-1));
		int lowersearch = binaryhelper(a,num,ind+1, upper);
		int uppersearch = binaryhelper(a,num,lower, ind-1);
		if(lowersearch >= 0) return lowersearch;
		return uppersearch;
	}
}
