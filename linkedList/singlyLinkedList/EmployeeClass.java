
/**
 * @author Niser, Khalil: (02/26/2023)
 * 
 * Data Structure: EmployeeClass ( SinglyLinkedList )
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

public class EmployeeClass 
{

	public static void main(String[] args) 
	{
		// List of employee's 
		Employee jackMeoff = new Employee( "Jack", "MeOff", 5545454 );
		Employee deezNutz = new Employee( "Deez", "Nutz", 8675309 );
		Employee nickoBalakhoff = new Employee( "Nicko", "Balakhoff", 3693693 );
		Employee johnDoe = new Employee( "John", "Doe", 6666969 );
		
		/*
		 * Create a Linkedlist and add some employee's to it
		 */
		EmployeeLinkedList list = new EmployeeLinkedList();
		
		System.out.println( list.isEmpty() );
		
		list.addToFront( jackMeoff );
		list.addToFront( deezNutz );
		list.addToFront( nickoBalakhoff );
		list.addToFront( johnDoe );
		
		// Displays the amount of "employee's" currently in the list
		System.out.println( "Total Number of Employees: " + list.getSize() );
		
		// EXECUTE RUN (OUTPUT DISPLAY)
		list.printList();
		
		list.removeFromFront();
		System.out.println( "Total Number of Employees: " + list.getSize() );
		list.printList();

	}

}
