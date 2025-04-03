
/**
 * @author Niser, Khalil: (02/26/2023)
 * 
 * Data Structure: Employee ( SinglyLinkedList )
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
 * a pointer to the null. Each node in the list can be accessed in
 * linear by traversing through the list from head to tail.
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
 */

package linkedList.singlyLinkedList;

public class EmployeeLinkedList 
{
	private EmployeeNode head;
	
	// Initialized to zero by default
	private int size;
	
	/**
	 * 				---- ADD_DATA_TO_LIST ----
	 * Let's say I want to add an item to the LinkedList. For 
	 * best performance data items should be added to the 
	 * beginning. So I won't have to traverse the list 
	 * looking for an insertion point. I created a "addToFront" 
	 * method to add items to the list.
	 * 
	 * @param employee
	 */
	public void addToFront( Employee employee )
	{
		// NEW NODE
		EmployeeNode node = new EmployeeNode( employee );
		
		/*
		 * Setting this new node's textField. This textField 
		 * is going to point at whatever "head", is currently 
		 * pointing at
		 */
		node.setNext( head );
		
		// Set "head" to the new node
		head = node;
		
		/*
		 * Every time an employee is added, it will automatically 
		 * increment the size
		 */
		size++;
	}
	
	/**
	 * Return the node that was removed. 
	 * First test whether the list is empty. because if the 
	 * list is empty, then there is nothing to remove 
	 * 
	 * @return removeFromFront
	 */
	public EmployeeNode removeFromFront()
	{
		if ( isEmpty() )
		{
			return null;
		}
		
		/*
		 * If the list isn't empty store the first node on 
		 * the list
		 */
		EmployeeNode removedNode = null;
		
		// Point arrow to the next item on the list
		head = head.getNext();
		
		// Decrement size because, 
		// now I have one less item
		size--;
		
		// Return the removed node
//		removedNode.setNext( null );
		
		return removedNode;
	}
	
	/**
	 * 				---- GETTER ----
	 * @return size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * 				---- EMPTY_LIST ----
	 * A quick way to test whether the list is empty.
	 * If head is null, that means the list is empty
	 * @return isEmpty
	 */
	public boolean isEmpty()
	{
		return head == null;
	}
	
	/**
	 * 				---- OUTPUT_DISPLAY ---
	 * This method (printList) prints my list on the screen
	 */
	public void printList()
	{
		// Always start at the head
		EmployeeNode current = head;
		
		System.out.print( " HEAD--> " );
		
		/*
		 * Keep traversing the list until current hits "null". When
		 * it hits "null", I've reached the end of the list 
		 */
		while ( current != null )
		{
			System.out.print( current );
			// Print an arrow
			
			System.out.print( " --> "); 
			// Move to the nextNode
			current = current.getNext();
		}
		
		// Last item in the list (null)
		System.out.println( "NULL" );
	}

}
