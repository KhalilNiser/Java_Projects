
/**
 * @author Niser, Khalil (04/10/2023)
 * 
 * Data Structure: ArrayQueue (Queues Array) 
 * 
 * 				---- THEORY_IMPLEMENTATION ----
 * 				---- QUEUES ----
 * 
 * The Queue interface is present in java.util package and extends the 
 * Collection interface is used to hold the elements about to be 
 * processed in FIFO(First In First Out) order. It is an ordered list 
 * of objects with its use limited to inserting elements at the end of 
 * the list and deleting elements from the start of the list, (i.e.), 
 * it follows the FIFO or the First-In-First-Out principle.
 * Being an interface the queue needs a concrete class for the 
 * declaration and the most common classes are the PriorityQueue and 
 * LinkedList in Java. Note that neither of these implementations are 
 * thread-safe. PriorityBlockingQueue is one alternative implementation 
 * if the thread-safe implementation is needed.
 * 
 * Declaration: The Queue interface is declared as:
 * (public interface Queue extends Collection)
 * 
 * Creating Queue Objects: Since Queue is an interface, objects cannot be 
 * created of the type queue. We always need a class which extends this 
 * list in order to create an object. And also, after the introduction of 
 * Generics in Java 1.5, it is possible to restrict the type of object that 
 * can be stored in the Queue. This type-safe queue can be defined as:
 * 
 * // Obj is the type of the object to be stored in Queue 
 * Queue<Obj> queue = new PriorityQueue<Obj>(); 
 * 
 * 1.	Abstract data type. Just like "Stacks", they dictate how we 
 * can access the. And just like "Stacks", we use other data structures
 * to implement them
 * 2.	FIFO: First-in, First-out. Unlike "Stacks", Queue's follow the 
 * FIFO principle, while Stacks follow the LIFO principle
 * 3.	ADD - Also called enqueue: Add an item to the end of the Queue
 * 4.	Remove - Also called dequeue: Remove the item at the front of 
 * the queue. Remove the first item in the Queue.
 * 5.	Peek: View the head of the Queue. Retrieve the item at the front 
 * of the queue, but don't remove it
 * 
 */

package Queues.array;

import java.util.NoSuchElementException;

public class ArrayQueue 
{
	
	// Array Queue
	private EmployeeQueue[] queue;
	// Tracks the front of the queue
	private int front;
	// Tracks the back of the queue
	private int back;
	
	/**
	 * 				---- CLASS CONSTRUCTOR ----
	 * @param capacity
	 */
	public ArrayQueue( int capacity )
	{
		this.queue = new EmployeeQueue[ capacity ];
	}
	
	/**
	 * 				---- ADD_METHOD ----
	 * @param employee
	 */
	public void add( EmployeeQueue employee )
	{
		/*
		 * If, back equals the length of the "queue",
		 * Then the "queue" is full
		 */
		if ( back == queue.length )
		{
			// Resize the "array" two times the size of the "queue
			EmployeeQueue[] newArray = new EmployeeQueue[ 2 * queue.length ];
			
			/*
			 * Copy existing items of the queue over to the newArray.
			 * Copy from the queue, start from the beginning, copy 
			 * into the newArray, starting at the beginning, and I 
			 * want to copy the queue.length elements
			 */
			System.arraycopy( queue, 0, newArray, 0, queue.length );
			
			queue = newArray;
		}
		
		// Assign the new employee to back
		queue[ back ] = employee;
		
		// Back increment back
		back++;
	}
	
	/**
	 * 				---- SIZE_METHOD ----
	 * @return
	 */
	public int size()
	{
		return back - front;
	}
	
	/**
	 * 				---- REMOVE_METHOD ----
	 * @return
	 */
	public EmployeeQueue remove()
	{
		// Check if the size is zero (Meaning Queue is empty). 
		if ( size() == 0 )
		{
			throw new NoSuchElementException();
			
		}
		
		/*
		 * If there is something in the Queue. 
		 * Always remove from the front of the queue
		 */
		EmployeeQueue employee = queue[ front ];
		
		// Clean the front
		queue[ front ] = null;
		
		// Increment the front
		front++;
		
		/*
		 * Check whether the size is 0. if I removed the
		 * only item in the queue, Then reset the front 
		 * and back positions back to zero (back to an 
		 * empty Queue)
		 */
		if ( size() == 0 )
		{
			front = 0;
			back = 0;
		}
		
		// Return the employee that was pulled off the queue
		return employee;
		
	}
	
	/**
	 * 				---- PEEK_METHOD ----
	 * @return
	 */
	public EmployeeQueue peek()
	{
		// Check if the size is empty
		if (size() == 0) 
		{
			throw new NoSuchElementException();
		}
		
		return queue[ front ];
	}
	
	public void printQueue()
	{
		for ( int i = front; i < back; i++ )
		{
			System.out.println( queue[ i ] );
		}
	}
	
}
