
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

package Queues.circularQueue;

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
	 * 
	 * 
	 * 
	 * 				---- CODE_EXPLANATION ----
	 * If I was to add()  the following employee's to my queue:
	 * 0 - jack - front
	 * 1 - nicko
	 * 2 - deez
	 * 3 - john
	 * 4 		- back
	 * it leaves me with position 4, and it's the back position.
	 * I can't just add "Bill", to position 4, because that is
	 * not the next available position. When I add "Bill" in here 
	 * I want the next available position to be 5. That means I 
	 * would have to resize the array[].
	 * (size() == queue.length - 1 ) 5 - 1 = 4. That way I would
	 * be able to add "Bill" to position 4, and increment back to 
	 * 5. Now I can have 5, 6, 7, ... 9.
	 * 
	 * 				---- POST_CODE_IMPLEMENTING ----
	 * 
	 * 0 - queue.add( jackMeoff ); (removed) (This guy becomes my new back)
	 * 1 - queue.add( nickoBalakhof ); (removed)
	 * 2 - queue.remove(); (I remove "Jack")
	 * 3 - queue.add( deezNuttz ); (I add "Deez") (back gets incremented by 1.
	 * And "Deez", becomes my new "Front")
	 * queue.remove(); (I remove "Nicko")
	 * queue.add(johnDoe); (I add "John") (Back gets incremented)
	 * queue.remove(); (I remove "John")
	 * 4 - queue.add(billEnd); (add "Bill")
	 * queue.remove();
	 * queue.add(jackMeoff);
	 * 
	 * 
	 * 				---- SYSTEM_ARRAYCOPY ----
	 * System.arraycopy( queue, front, newArray, 0, 
	 * queue.length - front );
	 * 
	 * Copy the elements from the "front" to the end  
	 * of the array.
	 * 1)	queue: I want to copy from the queue
	 * 2)	front: I want to start at the front. I want  
	 * to be starting with the first name on the top of
	 * the queue.
	 * 3)	newArray: Copy into newArray.
	 * 4)	Zero(0): Copy into position 0. In the newArray
	 * will be copying what's on the front of the queue, 
	 * back to position 0.
	 * 5)	queue.length - 1: Last, I want to be copying
	 * "queue.length - front" items.
	 */
	public void add( EmployeeQueue employee )
	{
		/*
		 * If, back equals the length of the "queue",
		 * Then the "queue" is full
		 */
		if ( size() == queue.length - 1 )
		{
			
			/*
			 * 				---- SAVE_THE_SIZE ----
			 * Here I have assigned size() to numItems later after 
			 * I have resized the array. I will use numItems to set 
			 * the back pointer
			 */
			int numOfItems = size();
			
			// Resize the "array" two times the size of the "queue"
			EmployeeQueue[] newArray = new EmployeeQueue[ 2 * queue.length ];
			
			System.arraycopy( queue, front, newArray, 0, queue.length - front );
			System.arraycopy( queue, 0, newArray, queue.length - front, back );
			
			queue = newArray;
			
			// Setting the front and the back fields
			front = 0;
//			back = size();
			back = numOfItems;
		}
		
		// Assign the new employee to back
		queue[ back ] = employee;
		
		if ( back < queue.length - 1 )
		{
			// Increment back
			back++;
		}
		else
		{
			back = 0;
		}
		
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
		 * If there is something in the Queue always remove
		 * from the front of the queue
		 */
		EmployeeQueue employee = queue[ front ];
		
		// Clean the front of the Queue
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
		else if ( front == queue.length )
		{
			/*
			 * If, there is still items on the queue(front ==
			 * queue.length), then I want to wrap front to the
			 * beginning (front = 0).
			 */
				front = 0;
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
	
	
	/**
	 * 				---- SIZE_METHOD ----
	 * @return
	 */
	public int size()
	{
		/*
		 * If, front is <= to back, then I know the queue
		 * hasn't wrapped. because back is still greater 
		 * than front. Front is still more towards the 
		 * front of the Array(), then back is. I don't have 
		 * the situation were front is more towards the back 
		 * of the Array(). and back is more towards the front
		 * of the Array()
		 */
		if ( front <= back )
		{
			return back - front;
		}
		else
		{
			return back - front + queue.length;
		}
		
	}
	
	public void printQueue()
	{
		if ( front <= back )
		{
			for ( int i = front; i < back; i++ )
			{
				System.out.println( queue[ i ] );
			}
		}
		else
		{
			for ( int i = front; i < queue.length; i++ )
			{
				System.out.println( queue[ i ] );
			}
			
			for ( int i = 0; i < back; i++ )
			{
				System.out.println( queue[ i ] );
			}
		}
		
	}
	
}
