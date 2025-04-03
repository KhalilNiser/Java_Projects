
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

//import linkedList.doublyLinkedList.Employee;

public class Employee 
{

	// Variables
	private String firstName;
	private String lastName;
	private int employeeID;

	/**
	 * ---- CLASS_CONSTRUCTOR ----
	 * 
	 * @param firstName
	 * @param lastName
	 * @param employeeID
	 */
	public Employee(String firstName, String lastName, int employeeID) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;

	}

	/**
	 * ---- GETTER ----
	 * 
	 * @return getFirstName
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * ---- SETTER ----
	 * 
	 * @param setFirstName
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	/**
	 * ---- GETTER ---
	 * 
	 * @return getLastName
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/**
	 * ---- SETTER ----
	 * 
	 * @param setLastName
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	/**
	 * ---- GETTER ----
	 * 
	 * @return getEmployeeID
	 */
	public int getEmployeeID() 
	{
		return employeeID;
	}

	/**
	 * ---- SETTER ----
	 * 
	 * @param setEmployeeID
	 */
	public void setEmployeeID(int employeeID) 
	{
		this.employeeID = employeeID;
	}

	/**
	 * 				---- toSTRING_METHOD() ---- 
	 * 
	 * toString: I want a toString() method generated. I 
	 * want to be able to @Override the default because 
	 * when I print the employee reference name I'd like 
	 * to see a firstName, lastName, and employeeID, I 
	 * don't just want to see the object reference
	 */
	public String toString() 
	{
		return "Employee{ " + " firstName=': " + firstName + 
				'\'' + ", lastName=': " + lastName + '\''
				+ ", employeeID': " + employeeID + '}';
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) 
		{
			return false;
		}

		Employee employee = (Employee) obj;

		if (employeeID != employee.employeeID) 
		{
			return false;
		}
		if (!firstName.equals(employee.firstName)) 
		{
			return false;
		}

		return lastName.equals(employee.lastName);
	}

	@Override
	public int hashCode() 
	{
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + employeeID;

		return result;
	}

}
