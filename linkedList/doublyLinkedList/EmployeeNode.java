
/**
 * @author Niserm, Khalil (03/10/2023)
 * 
 * Data Structure: Employee (DoublyLinkedList)
 * 
 * 				---- IMPLIMENTATION/THEORY ----
 * 
 * 				---- DOUBLY_LINKED_LIST_BASIC_UNDERSTANDING ----
 * Doubly Linked List is a variation of Linked List in which navigation is
 * possible in both ways either forward or backward easily as compared to 
 * SinglyLinkedList. Following are important terms to understand the
 * concepts of SinglyLinedList.
 * 
 * 1)	Link: Each Link of a linked list can store a data called an element
 * 2)	Next: Each Link of a linked list contain a link to the next link "Next"
 * 3)	Prev: Each Link of a linked list contain a link to previous link 
 * called "Prev"
 * 4)	LinkedList: A LinkedList contains the connection link to the first link 
 * called "First" and to the last link called "Last"
 * 
 * 			  head							tail
 * [null]<-->[Jane]<-->[John]<-->[Mary]<-->[Mike]-->[null]
 * 5)	Each item in the list has next and previous fields
 * 6)	Each item The list has a head and a tail
 * 
 * 
 * 				---- DOUBLY_LINKED_LIST_REPRESENTATION ----
 * Following are the important points to be considered:
 * 1)	DoublyLinkedList contains a link element called First and Last
 * 2)	Each Link carries a data field(s) and a Link Field called next.
 * 3)	Each Link is linked with its next link using its next link.
 * 4)	Each Link is linked with its previous link using its prev link.
 * 5)	Last Link carries a Link as null to mark the end of the list.
 * 
 * 				---- BASIC_OPERATIONS ----
 * Following are the basic operations supported by a list
 * 1)	Insertion: Add an element at the beginning of the list.
 * 2)	Deletion: Add an element at the beginning of the list.
 * 3)	Insertion Last: Add an element in the end of the list.
 * 4)	Delete Last: Delete an element from the end of the list.
 * 5)	Insert After: add an element after an item of the list.
 * 6)	Delete: Delete an element from the list using key.
 * 7)	Display Forward: Displaying complete list in forward manner.
 * 8)	Display Backward: Displaying complete list in backward manner.
 * 
 * 				---- INSERT_AT_HEAD ----
 * 1)	Create a new node called "Bill"
 * 2)	Assign "Jane" to Bill's next field
 * 3)	Assign whatever "Jane" is pointing to as previous to "Bill's" 
 * previous field
 * 4)	Assign head to "Bill"
 * 5) O(1)Time Complexity: In short, O(1) means that it takes a "constant time", 
 * like 14 nanoseconds, or three minutes no matter the amount of data in the set.
 * 
 * 	 		  head									  tail
 * [null]<-->[Bill]<-->[Jane]<-->[John]<-->[Mary]<-->[Mike]-->[null]
 * 
 * 
 * 				---- INSERT_AT_TAIL ----
 * 1)	Create a new node called "Bill"
 * 2)	Assign tails next field to Bill's next field
 * 3)	Assign tail to "Bill's" previous field 
 * 4)	Assign tail's next field to "Bill"
 * 5)	Assign tail to "Bill"
 * 6) O(1)Time Complexity: In short, O(1) means that it takes a "constant time", 
 * like 14 nanoseconds, or three minutes no matter the amount of data in the set.
 * 
 *  		  head									  tail
 * [null]<-->[Jane]<-->[John]<-->[Mary]<-->[Mike]<-->[Bill]-->[null]
 * 
 * 
 * 				---- DELETE_FROM_HEAD ----
 * 1)	Assign "Jane" to "removedNode"
 * 2)	Assign "John's" previous field to "Jane's" previous field
 * 3)	Assign head to "Jane's" next filed
 * 4)	Return "removedNode" from the method
 * 5)	O(1) Constant Time Complexity
 * 
 * 			  head				  tail
 * [null]<-->[John]<-->[Mary]<-->[Mike]-->[null]
 * 
 * 
 * 				---- DELETE_FROM_TAIL ----
 * 
 * 			  head									  tail
 * [null]<-->[Jane]<-->[John]<-->[Mary]<-->[Mike]<-->[Bill]-->[null]
 * 
 * 1)	Assign "Bill" to "removedNode"
 * 2)	Assign "Mikes's" next field to "Bill's" next field
 * 3)	Assign tail to "Bill's" previous field 
 * 4)	Return "removedNode" from the method
 * 5)	O(1) Constant Time Complexity
 * 
 * 			 head				 		   tail
 * [null]-->[Jane]<-->[John]<-->[Mary]<-->[Mike]-->[null]
 * 
 * 
 * 				---- INSERT_NODE_A_BETWEEN_NODES_B_AND_C ----
 * 1)	Assign A's next field to B's next field
 * 2)	Assign A's previous field to B's previous field
 * 3)	Assign B's next field to A
 * 4)	Assign C's previous field to A
 * 5)	O(1) Time Complexity, but since I have to find the "insertion" 
 * position first, the worst case scenario this will run in O(n) Linear 
 * Time Complexity
 * 
 * 
 * 				---- REMOVE_NODE_A_FROM_BETWEEN_NODES_B_AND_C ----
 * 1)	Assign A to "removedNode"
 * 2)	Assign C's previous field to A's previous field
 * 3)	Assign B's next field to A's next field
 * 4)	Return A from the method
 * 5)	O(1) Time Complexity, but since I have to find A first, the worst 
 * case scenario this will run in O(n) Linear Time Complexity
 */

package linkedList.doublyLinkedList;

public class EmployeeNode 
{
	// Employee Field
	private Employee employee;

	/*
	 * This variable (EmployeeNode (next) stores a 
	 * reference to the next node in the list
	 */
	private EmployeeNode next;
	
	// Previous field
	private EmployeeNode previous;

	/**
	 * 				---- CLASS_CONSTRUCTOR ----
	 * 
	 * @param employee
	 */
	public EmployeeNode(Employee employee) 
	{
		this.employee = employee;
	}

	/* 				---- SETTERS_GETTERS ----				*/
	/**
	 * 				---- GETTER ----
	 * 
	 * @return employee
	 */
	public Employee getEmployee() 
	{
		return employee;
	}

	/**
	 * 				---- SETTER ----
	 * 
	 * @param employee
	 */
	public void setEmployee(Employee employee) 
	{
		this.employee = employee;
	}

	/**
	 * 				---- GETTER ----
	 * 
	 * @return next
	 */
	public EmployeeNode getNext() 
	{
		return next;
	}

	/**
	 * 				---- SETTER ----
	 * 
	 * @param next
	 */
	public void setNext(EmployeeNode next) 
	{
		this.next = next;
	}
	
	/**
	 * 				---- GETTER ----
	 * @return previous
	 */
	public EmployeeNode getPrevious()
	{
		return previous;
	}
	
	/**
	 * 				---- SETTER ----
	 * 
	 * @param previous
	 */
	public void setPrevious( EmployeeNode previous )
	{
		this.previous = previous;
	}

	/**
	 * 				---- toSTRING() ---- 
	 * When I print the String, what I'll be printing is the
	 * result of the toString() method in the "Employee" Class, 
	 * under the "@Override" section
	 */
	public String toString() 
	{
		return employee.toString();
	}

}
