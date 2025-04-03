
/**
 * @author Niser, Khalil (04/10/2023)
 * 
 * Data Structure: MainQueue (Queues Array) 
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
 * 
 * 				---- TIME_COMPLEXITY ----
 * Time Complexity: The "Time Complexity" for a "Queue" that's backed by 
 * an Array[] will either be constant (0(1)), if we don't have to resize 
 * the array. And it will be linear (0(n), if we do have to resize the 
 * array
 * 
 */

package Queues.circularQueue;

public class MainQueue 
{

	public static void main(String[] args) 
	{
		// Stack of employye's
		EmployeeQueue jackMeoff = new EmployeeQueue( "Jack", "Meoff", 5545454 );
		EmployeeQueue nickoBalakhof = new EmployeeQueue( "Nicko", "Balakhof", 8675309 );
		EmployeeQueue deezNuttz = new EmployeeQueue( "Deez", "Nuttz", 3698369 );
		EmployeeQueue johnDoe = new EmployeeQueue( "John", "Doe", 6666969 );
		EmployeeQueue billEnd = new EmployeeQueue( "Bill", "End", 7698769 );
		
		// Instantiate ArrayQueue class: Access to class data
		ArrayQueue queue = new ArrayQueue( 5 );
		
		queue.add( jackMeoff );
		queue.add( nickoBalakhof );
		queue.remove();
		queue.add( deezNuttz );
		queue.remove();
		queue.add(johnDoe);
		queue.remove();
		queue.add(billEnd);
		queue.remove();
		queue.add(jackMeoff);
		
		System.out.println( "\t\t---- ORIGINAL_EMPLOYEES "
				+ "(CIRCULAR_QUEUE! ----)" );

//		// Print the queue on display
		queue.printQueue();
		
		System.out.println();
//		queue.add( jackMeoff );
//		queue.add( nickoBalakhof );
//		queue.add( deezNuttz );
//		queue.add(johnDoe);
//		queue.add(billEnd);
		
		System.out.println( "\t\t---- ORIGINAL_EMPLOYEES ----" );

		// Print the queue on display
//		queue.printQueue();
		
		System.out.println();
		System.out.println( "\t\t---- REMOVE_FIRST_TWO_EMPLOYEES! ----" );
		
		// Remove first two employees
//		queue.remove();
//		queue.remove();
		
		// Print the queue on display
//		queue.printQueue();
		
		System.out.println();
		System.out.println( "\t\t---- PEEK_AT_FIRST_EMPLOYEE! ----" );
		
		// Peek at the first employee
//		System.out.println( queue.peek() );
		
		System.out.println();
		System.out.println( "\t\t---- REMOVE_REMAINING_THREE_EMPLOYEES! ----" );
		
		// Remove first two employees
//		queue.remove();
//		queue.remove();
//		queue.remove();
		
//		queue.remove();
		
//		// Print the queue on display
//		queue.printQueue();
		
		System.out.println();
		System.out.println( "\t\t---- ADD_EMPLOYEE_TO_CURRENT_EMPTY_QUEUE! ----" );
		
		// Add first two employees
//		queue.add( deezNuttz );
//		queue.add( billEnd );
		
		// Print the queue on display
//		queue.printQueue();

	}

}
