
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

public class EmployeeMain 
{

	public static void main(String[] args) 
	{
		
		Employee jackMeoff = new Employee( "Jack", "MeOff", 5545454 );
		Employee nickoBalakhoff = new Employee( "Nicko", "Balakhoff", 8675309 );
		Employee deezNuttz = new Employee( "Deez", "Nuttz", 3698369 );
		Employee johnDoe = new Employee( "John", "Doe", 6666969 );
		Employee billEnd = new Employee( "Bill", "End", 7896896 );
		
		/*
		 * Initialize an instance of the class LinkedStack().
		 * It enables me with full access to all data fields 
		 * of the said class
		 */
		LinkedStack stack = new LinkedStack();
		
		stack.push( jackMeoff );
		stack.push( nickoBalakhoff );
		stack.push( deezNuttz );
		stack.push( johnDoe );
		stack.push( billEnd );
		
		System.out.println( "\t\t---- PUSH_ITEM_LIST_ONTO_THE_STACK ----!" );
		stack.printStack();
		
		System.out.println();
		
		System.out.println( "\t\t---- PEEK_THE_TOP_ITEM_ON_THE_STACK! ----");
		
		System.out.println( stack.peek() );
		System.out.println();
		stack.printStack();
		
		System.out.println();
		System.out.println( "\t\t---- POP_ITEM_FROM_THE_STACK ----");
		
		System.out.println( "POPPED: " + stack.pop() );
		
		System.out.println();
		
		System.out.println( "\t\t---- POST_POP_METHOD_IMPLEMENTS ----");
		
		System.out.println( stack.peek() );
		
		System.out.println();
		stack.printStack();

	}

}
