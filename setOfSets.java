/*
this is not an interview question, this is just a toy example to show that if you add a new set with the same elements as an existing entry
into a set of sets, it doesn't count them as separate
*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Set<Set<Integer>> res = new HashSet();
		
		Set<Integer> a = new HashSet();
		a.add(1);
		a.add(2);
		
		Set<Integer> b = new HashSet();
		b.add(1);
		b.add(2);
		
		res.add(a);
		res.add(b);
		System.out.println(res.size());
	}
}
