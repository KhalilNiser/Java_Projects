
/**
 * @author Niser, Khalil: (02/26/2023)
 * 
 * Data Structure: EmployeeNode ( SinglyLinkedList )
 * Implementation/Theory
 * 
 * 				---- SINGLY_LINKED_LIST_THEORY ----
 * The singly linked list is a linear data structure in which each 
 * element of the list contains a pointer which points to the next 
 * element in the list. Each element in the singly linked list is 
 * called a node. Each node has two components: data and a pointer 
 * next which points to the next node in the list. 
 * 
 * 				---- HEAD_TAIL_NODES ----
 * The first node of the list is called as head, and the last node 
 * of the list is called a tail. The last node of the list contains 
 * a pointer to the null. Each node in the list can be accessed 
 * linearly by traversing through the list from head to tail.
 * 
 * 
 * [Head]								  [Tail]
 * [Jane][]---->[John][]---->[Mary][]---->[Mike][]----[null]
 * 
 * 				---- THEORY ----
 * I)	Each item in the list is called a node
 * II)	The first item in the list is the head of the list
 * 
 * 
 * 				---- INSERT_NEW_NAME_TO_LIST ----
 * [Head]										       [Tail]
 * [Bill][]---->[Jane][]---->[John][]---->[Mary][]---->[Mike][]----[null]
 * 
 * I)	Create a new node "Bill"
 * II)	Assign "Jane", to the next Field
 * III)	Assign head to "Bill"
 * IV)	Will be O(1) (Constant) time complexity
 * 
 * 
 * 				---- DELETE_NAME_FROM_LIST ----
 * [Head]							      [Tail]
 * [Jane][]---->[John][]---->[Mary][]---->[Mike][]----[null]
 * 
 * I)	Assign "Bill", to a temporary variable called "removedNode"
 * II)	Assign "head" to "Jane"
 * III)	Return "removedNode"
 * IV)	Will be O(1) (Constant) time complexity
 * 
 */

package linkedList.singlyLinkedList;

public class EmployeeNode 
{
	// Employee Field
	private Employee employee;
	
	/*
	 * This field (EmployeeNode (next)) stores a reference 
	 * to the next node in the list
	 */
	private EmployeeNode next;
	
	
	/**
	 * 				---- CLASS_CONSTRUCTOR ----
	 * @param employee
	 */
	public EmployeeNode( Employee employee )
	{
		this.employee = employee;
	}
	
	
	//		---- SETTERS_GETTERS ----
	/**
	 * 				---- GETTER ----
	 * @return employee
	 */
	public Employee getEmployee()
	{
		return employee;
	}
	
	/**
	 * 				---- SETTER ----
	 * @param employee
	 */
	public void setEmployee( Employee employee )
	{
		this.employee = employee;
	}
	
	/**
	 * 				---- GETTER ----
	 * @return next
	 */
	public EmployeeNode getNext()
	{
		return next;
	}
	
	/**
	 * 				---- SETTER ----
	 * @param next
	 */
	public void setNext( EmployeeNode next )
	{
		this.next = next;
	}
	
	/**
	 * 				---- toSTRING() ----
	 * When I print the String, what I'll be printing is the 
	 * result of the toString() method in the "Employee" 
	 * Class, under the "@Override" section
	 */
	public String toString()
	{
		return employee.toString();
	}

}
