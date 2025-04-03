
/**
 * @author Niser, Khalil (03/25/2023)
 * 
 * Data Structure: Employee (Stacks Array) Theory/Implementation
 * 
 * 				---- STACK ----
 * Java Collection framework provides a Stack class that models 
 * and implements a Stack data structure. The class is based on 
 * the basic principle of last-in-first-out. In addition to the 
 * basic push and pop operations, the class provides three more 
 * functions of empty, search, and peek. The class can also be 
 * said to extend Vector and treats the class as a stack with 
 * the five mentioned functions. The class can also be referred 
 * to as the subclass of Vector.
 * 
 * I)	Abstract Data type: It dictates the operations we can 
 * perform on a set of data, but it doesn't tell us how the data 
 * should be stored.
 * 
 * II)	LIFO: Last in, First out - The last item you add to a 
 * Stack(), is always item you can remove. It's not like an array
 * were you can instruct it to give you the element at a said 
 * position. Because of that the Stack() has a concept of Top. The
 * item on the Top of the Stack() is the only item we're allowed to 
 * access. Is the only one we're allowed to look at. And it's the 
 * only one we're allowed to remove.
 * 
 * III)	Push: Adds an item as the top item on the stack 
 * 
 * IV)	Pop: Removes the top item on the stack
 * 
 * V)	Peek: Gets the top item on the stack without popping it
 * 
 * VI)	Ideal backing data structure: Linked List - Although a 
 * Stack() can be backed by any data structure (For instance like 
 * an Array{}()), but realistically a Linked List is the most
 * adequate data structure for a Stack(). Because in a Linked List 
 * we always want to be working with the item on the front of the 
 * list (If it's a Singly Linked List). We add items to the front 
 * of the list, and we remove items from the front of the list
 * 
 * 				---- HEIRARCHY_OF_CTACK_CLASS ----
 * 
 * Below are the hierarchy of a Stack class:
 * 
 * [Iterable]--extends-->[Collection]--extends-->[L:ist]
 * --implements-->[Vector]--extends-->[Stack]
 * 
 * I)	Serializable: It is a marker interface that classes 
 * must implement if they are to be serialized and deserialized.
 * 
 * II)	Cloneable: This is an interface in Java which needs to be 
 * implemented by a class to allow its objects to be cloned.
 * 
 * III)	Iterable<E>: This interface represents a collection of 
 * objects which is iterable — meaning which can be iterated.
 * 
 * IV)	Collection<E>: A Collection represents a group of objects 
 * known as its elements. The Collection interface is used to pass 
 * around collections of objects where maximum generality is 
 * desired.
 * 
 * V)	List<E>: The List interface provides a way to store the 
 * ordered collection. It is a child interface of Collection. 
 * 
 * VI)	RandomAccess: This is a marker interface used by List 
 * implementations to indicate that they support fast (generally 
 * constant time) random access.
 * 
 * 				---- CREATE_A_STACK ----
 * 
 * How to Create a Stack?
 * 
 * In order to create a stack, we must import java.util.stack package 
 * and use the Stack() constructor of this class. The below example 
 * creates an empty Stack.
 * 
 * Stack<E> stack = new Stack<E>();
 * 
 * NOTE: Here E is the type of Object.
 * 
 * 
 * 				---- TIME_COMPLEXITY ----
 * I)	Constant Time Complexity: O(1) For Push, Pop, and Peek, when 
 * using a Linked List
 * 
 * II)	Linear Time Complexity: If you use an Array(), then Push is O(n), 
 * because if the Array() is full, then you would have to be resize the 
 * Array().
 * 
 * III) If you know the maximum number of items that will ever be on
 * the Stack(), an Array() can be a good choice.
 * 
 * IV)	If memory is tight, an Array() might be a good choice
 * 
 * V)	Linked List is ideal
 * 
 */

package Stacks.array;

import java.util.EmptyStackException;

public class ArrayStack 
{
	// Array of stack: Backing Array()
	private Employee[] stack;
	// This field tracks where the "top" of the stack is
	private int top;
	
	/**
	 * 				---- CONSTRUCTOR ----
	 * Class constructor monitors the capacity of the stack.
	 * 
	 * @param capacity
	 */
	public ArrayStack( int capacity )
	{
		/*
		 * Stack with a length of size capacity: Mind you the 
		 * capacity will be the maximum number of items I can 
		 * store in the stack.
		 * 
		 * NOTE: I am not going to initialize the "top" variable.
		 * It is going to be initialized to zero (0) by default.
		 * So when the "top" is zero the stack is empty.
		 */
		stack = new Employee[ capacity ];
	}
	
	// Push method: accepts the "employee" instance
	public void push( Employee employee )
	{
		if ( top == stack.length )
		{
			/*
			 * 				---- RESIZE_THE_ARRAY() ----
			 * 
			 * If the "top" is full (top == stack.length()) then I 
			 * will need to resize the array. 
			 * NOTE: Resizing the array double the original length
			 */
			Employee[] newArray = new Employee[ 2 * stack.length ];
			
			/*
			 * Copy all the elements that currently exist in the 
			 * stack into this "newArray" field
			 */
			System.arraycopy( stack, 0, newArray, 0, stack.length );
			 
			stack = newArray;
			 
		}
		
		stack[ top++ ] = employee;
	}
	
	/**
	 * 				---- POP_METHOD ----
	 * The Java.util.Stack.pop() method in Java is used to 
	 * pop an element from the stack. The element is popped 
	 * from the top of the stack 
	 * 
	 * @return
	 */
	public Employee pop()
	{
		if ( isEmpty() )
		{
			throw new EmptyStackException();
		}
		
		/*
		 * NOTE: Top always the contains the index of the next 
		 * available position in the array. There is nothing at 
		 * "top", there is nothing stored at "top", the top item 
		 * on the stack is actually stored at "top - 1". So what
		 * I want to do is decrement "top - 1", and use the result 
		 * the index into stack.
		 * 
		 * For example: If top is 5, that means the employee
		 * at the top of the stack is at position 4. So I take
		 * the employee at position 4 ( mind you employee is
		 * now equal to 4), I take the employee at the top of 
		 * the stack and assign it to employee.
		 */
		Employee employee = stack[ --top ];
		
		/*
		 * Set the top of the stack to null. Because I assign 
		 * the employee at the top of the stack to employee. 
		 * So I set the top to null. Because I have popped 
		 * the employee at position top, and so I want to 
		 * null that out.
		 */
		stack[ top ] = null;
		
		return employee;
	}
	
	/*
	 * 				---- PEEK_METHOD ----
	 * At the "Peek" method we access the "top" item, but
	 * we don Not "pop" it. I retrieve the top item on the 
	 * stack, nevertheless, that item remains on the stack.
	 */
	public Employee peek()
	{
		if ( isEmpty() )
		{
			throw new EmptyStackException();
		}
		
		return stack[ top - 1 ];
	}
	
	/*				---- SIZE_METHOD ----			*/
	public int size()
	{
		return top;
	}
	
	// isEmpty() method
	public boolean isEmpty()
	{
		return top == 0;
	}
	
	/*				---- PRINT_METHOD ----				*/
	public void printStack()
	{
		for ( int i = top - 1; i >= 0; i-- )
		{
			System.out.println( stack[ i ] );
		}
	}

}
