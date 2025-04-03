
/**
 * @author Niser, Khalil (04/10/2023)
 * 
 * Data Structure: EmployeeQueue (Queues Array) 
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

public class EmployeeQueue 
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
	public EmployeeQueue( String firstName, String lastName, int employeeID ) 
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
	 * toString: I want a toString() method generated. I
	 * want to be able to @Override the default because 
	 * when I print the employee reference name I'd like 
	 * to see a firstName, lastName, and employeeID, I
	 * don't just want to see the object reference
	 */
	public String toString() {
		return "Employee{ " + " firstName=': " + firstName + 
				'\'' + ", lastName=': " + lastName + '\''
				+ ", employeeID': " + employeeID + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		EmployeeQueue employee = (EmployeeQueue) obj;

		if (employeeID != employee.employeeID) {
			return false;
		}
		if (!firstName.equals(employee.firstName)) {
			return false;
		}

		return lastName.equals(employee.lastName);
	}

	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + employeeID;

		return result;
	}

}
