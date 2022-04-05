/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(4);
		l1.add(20);
		l1.add(21);
		l1.add(30);
		
		LinkedList l2 = new LinkedList();
		l2.add(0);
		l2.add(2);
		l2.add(3);
		l2.add(6);
		l2.add(8);
		l2.add(9);
		l2.add(25);
		
		sortInterlinked(l1,l2).print();
	}
	
	public static class Node { 
        int data; 
        Node next = null; 
    
        Node(int d) { data = d; }  //constructor to create a new node
    } 
	public static class LinkedList { 
    Node head; // list head 
      //node - linkedlist
      Node tail;
      
      //this method shows the problem with java, you can have these weird references
      //that won't get picked up by GC.
      //the nodes in the middle of the list are not actually assigned to any variable.
      //but are in the reference chain
      public void add(int n) {
          if(head == null) {
              head = new Node(n);
          }
          else {
            if(tail == null) {
              tail = head;
            }
            tail.next = new Node(n);
            tail = tail.next;
          }
      }
      
      public void print() {
          Node iter = head;
          while(iter != null) {
              System.out.print(iter.data + ",");
              iter = iter.next;
          }
          System.out.println("\n");
      }
    
    }
    
    public static LinkedList sortInterlinked(LinkedList a, LinkedList b) {
        LinkedList res = new LinkedList();
        Node iter1 = a.head;
        Node iter2 = b.head;
        while(iter1 != null || iter2 != null) {
            if(iter2 == null || iter1.data < iter2.data) {
                res.add(iter1.data);
                //System.out.println("adding " + iter1.data);
                iter1 = iter1.next;
            } else {
                res.add(iter2.data);
                //System.out.println("adding " + iter2.data);
                iter2 = iter2.next;
            }
        }
        return res;
    }
}
