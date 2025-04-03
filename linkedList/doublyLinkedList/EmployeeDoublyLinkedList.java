
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

public class EmployeeDoublyLinkedList 
{
	private EmployeeNode head;
	private EmployeeNode tail;

	// Always initialized to zero by default
	private int size;

	/**
	 * 				---- ADD_DATA_TO_LIST ---- 
	 * 
	 * Let's say I want to add an item to the LinkedList. For best
	 * performance data items should be added to the beginning. So 
	 * I won't have to traverse the list looking for an insertion 
	 * point. I created a "addToFront" method to add items to the list.
	 * 
	 * @param employee
	 */
	public void addToFront(Employee employee) 
	{
		// NEW NODE
		EmployeeNode node = new EmployeeNode(employee);

		/*
		 * Setting this new node's textField. This textField 
		 * is going to point at whatever "head", is currently 
		 * pointing at
		 */
		node.setNext(head);
		
		if ( head == null )
		{
			tail = node;
		}
		else
		{
			head.setPrevious( node );
//			node.setNext( head );
		}

		// Set "head" to the new node
		head = node;

		/*
		 * Every time an employee is added, it will 
		 * automatically increment the size
		 */
		size++;
	}
	
	
	/**
	 * 				---- ADD_TO_END_(TAIL)_METHOD ----
	 * 
	 * For this method I will set the previous field to point 
	 * to the node that's currently at the end of the list.
	 * I will have a node that's pointed to by tail, and I want 
	 * to insert a node at the end so I want to tail to point 
	 * to the new node and I want the new node's previous field
	 * to point to whatever the current tail is.
	 * 
	 * @param employee
	 */
	public void addToEnd( Employee employee )
	{
		// New Node
		EmployeeNode node = new EmployeeNode( employee );
		
		/*
		 * If tail i.e. to null, set head to the new node.
		 * Otherwise set current tail's next field to the
		 * node being added. And set the previous node I 
		 * am adding to what used to the tail.
		 * 
		 * For example: If I have only Jane in the list, and 
		 * I'm adding John, I'm adding John to the end of the
		 * list. I'm gonna want Jane (the current tail/END)
		 * I'm gonna want her next filed to point to John (who
		 * is the NEW node), and I want John's previous field 
		 * to point to Jane, and John's next field to point to 
		 * end
		 */
		if ( tail == null )
		{
			head = node;
		}
		else
		{
			tail.setNext( node );
			node.setPrevious( tail );
		}
		
		tail = node;
		size++;
	}
	
	public boolean addBefore( Employee newEmployee, Employee existingEmployee )
	{
		/*
		 * return true if successfully able to add the employee
		 * into the list before the existing employee. Return 
		 * false if the existing employee doesn't exist in the
		 * list
		 */
		
		// If list is empty, return false
		/*if ( head == null )
		{
			return false;
		}*/
		
		// If list is empty, return false
		if ( isEmpty() )
		{
			return false;
		}
		
		// Find the existing employee
		EmployeeNode current = head;
		
		/*
		 * While, current is NOT equal to null. And current
		 * isn't the node we are looking for (is NOT equal
		 * to the existing employee)
		 */
		while ( ( current != null ) && 
				( !current.getEmployee().equals(existingEmployee) ) )
		{
			// Move on to the next node
			current = current.getNext();
		}
		
		/*
		 * If I get down to this point then, it means I have found 
		 * the existing employee in the list. So I want to insert 
		 * the new employee in-front of the existing employee. So 
		 * what I will have to do If I'm gonna squeeze this new 
		 * employee in-front of an existing employee I will have 
		 * to change four fields:
		 * 1)	Set the previous and next fields, of the new employee
		 * 
		 * 2)	Change the previous filed of the current node. Because 
		 * I'm inserting the new employee in-front of the current node.
		 * 
		 * 3)	That being said I will want the current node previous 
		 * field to point to the new employee.
		 * 
		 * 4)	And then the employee that's currently in-front of 
		 * current, is now going to be in-front of the new employee,
		 * so it's next field needs to be changed.
		 */
		if ( current == null ) 
		{
			return false;
		}
		
		// Create a new node for the new employee
		EmployeeNode newNode = new EmployeeNode( newEmployee );
		
		/*
		 * Set the new node's next and previous fields. And the 
		 * new node points to whatever the current node previous 
		 * field is pointing to.
		 */
		
		newNode.setPrevious( current.getPrevious() );
		
		newNode.setNext( current );
		
		/*
		 * Set the previous field of the current node
		 * to point to the "newNode"
		 */
		current.setPrevious( newNode );
		
		if ( head == current )
		{
			// Set head to the "newNode"
			head = newNode;
		}
		else
		{
			/*
			 * Get the "newNode's" previous and set it to the 
			 * "newNode"
			 */
			newNode.getPrevious().setNext( newNode );
		}
		
		size++;
		
		return true;
	}

	/**
	 * 
	 * Return the node that was removed. First test whether 
	 * the list is empty. because if the list is empty, then 
	 * there is nothing to remove
	 * 
	 * @return removeFromFront
	 */
	public EmployeeNode removeFromFront() {
		if (isEmpty()) {
			return null;
		}

		/*
		 * If the list isn't empty store the 
		 * first node on the list
		 */
		EmployeeNode removedNode = head;
		
		/*
		 * If removing the only node on the list, then set 
		 * tail to null. Otherwise set the previous field 
		 * to null.
		 */
		if ( head.getNext() == null )
		{
			tail = null;
		}
		else
		{
//			head.getNext().setPrevious( head.getPrevious() );
			head.getNext().setPrevious( null );
		}

		// Point arrow to the next item on the list
		head = head.getNext();

		// Decrement size because,
		// now I have one less item
		size--;
		
//		removedNode.setNext( null );
		
		return removedNode;
	}
	
	// REMOVE FROM END METHOD
	public EmployeeNode removeFromEnd()
	{
		// If list is empty do nothing
		if ( isEmpty() )
		{
			return null;
		}
		
		// Remove the last employee on the list
		EmployeeNode removedNode = tail;
		
		// If, I only have one employee on the list
		if ( tail.getPrevious() == null )
		{
			head = null;
		}
		// If, I have more than one employee on the list
		else
		{
			tail.getPrevious().setNext( null );
		}
		
		tail = tail.getPrevious();
		
		size--;
		
		removedNode.setPrevious( null );
		
		return removedNode;
	}

	/**
	 * ---- GETTER ----
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 				---- EMPTY_LIST ---- 
	 * A quick way to test whether the list is empty. If head
	 * is null, that means the list is empty
	 * 
	 * @return isEmpty
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * 				---- OUTPUT_DISPLAY --- 
	 * This method (printList) prints my list on the screen
	 */
	public void printList() {
		// Always start at the head
		EmployeeNode current = head;

		System.out.print(" HEAD--> ");

		/*
		 * Keep traversing the list until current hits "null". 
		 * When it hits "null", I've reached the end of the list
		 */
		while (current != null) 
		{
			System.out.print(current);
			
			// Print an arrow
			System.out.print(" <==> ");
			// Move to the nextNode
			current = current.getNext();
		}

		// Last item in the list (null)
		System.out.println("NULL");
	}

}
