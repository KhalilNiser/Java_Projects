
/**
 * @author Niser, Khalil (03/28/2023)
 * 
 * Data Structure: Employee (Stacks) Theory/Implementation
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

package Stacks.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;
//import java.util.ListIterator;

public class LinkedStack 
{
	
	/*
	 *  This field will be my "Stack". It will hold Instances
	 *  of my Employee Class
	 */
	private LinkedList< Employee > stack;
	
	/**
	 * 				---- CONSTRUCTOR ----
	 */
	public LinkedStack()
	{
		stack = new LinkedList< Employee >();
	}
	
	/**
	 * 				---- PUSH_METHOD ----
	 * Java.util.Stack.push(E element), method is used  
	 * to push an element into the Stack. 
	 * Items always get pushed onto the top of the Stack.
	 * 
	 * @param employee
	 */
	public void push( Employee employee ) 
	{
		stack.push( employee );
	}
	
	/**
	 * 				---- POP_METHOD() ----
	 * The Java.util.Stack.pop() method in Java is used 
	 * to pop an element from the stack. 
	 * NOTE: The item is always popped from the top of 
	 * the stack 
	 * @return
	 */
	public Employee pop()
	{
		return stack.pop();
	}
	
	/**
	 * 				---- PEEK_METHOD() ----
	 * The java.util.Stack.peek() method in Java is used 
	 * to retrieve or fetch the first element of the 
	 * Stack or the element present at the top of the 
	 * Stack. The element retrieved does not get deleted 
	 * or removed from the Stack.
	 * @return
	 */
	public Employee peek()
	{
		return stack.peek();
	}
	
	/**
	 * 				---- isEMPTY()_METHOD ----
	 * The Java.util.Stack.isEmpty() method in Java is 
	 * used to check and verify if a Stack is empty or 
	 * not. It returns True if the Stack is empty, else 
	 * it returns False.
	 * @return
	 */
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	
	/**
	 * 				---- PRINT_THE_STACK_METHOD() ----
	 */
	public void printStack()
	{
		ListIterator< Employee > iterator = stack.listIterator();
//		ListIterator< Employee > iterator = stack.listIterator();
		
		while ( iterator.hasNext() )
		{
			System.out.println( iterator.next() );
		}
	}

}
