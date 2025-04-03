package linkedList.linkedListChallenge2;

public class IntegerLinkedList 
{
	private IntegerNode head;
	private int size;
	
	public void addToFront( Integer value )
	{
		IntegerNode node = new IntegerNode( value );
		
		node.setNext( head );
		
		head = node;
		size++;
	}
	
	public IntegerNode removeFromFront()
	{
		if ( isEmpty() )
		{
			return null;
		}
		
		IntegerNode removedNode = head;
		
		head = head.getNext();
		
		size--;
		
		removedNode.setNext( null );
		
		return removedNode;
	}
	
	public void insertSorted( Integer value )
	{
		/*
		 * Checking whether the list (isEmpty(){}). Because if the 
		 * list isEmpty(), then I just insert the node.
		 * The other thing I'm doing here is checking whether the 
		 * first node in the list is >= to the value I'm inserting.
		 * That case I just enter the new node at the beginning/head 
		 * of the list.
		 * 
		 * NOTE: Assumption: The list is sorted. Because if the list
		 * is Not sorted, then this part (if-block statement) will
		 * not work.
		 */
		if ( head == null || head.getValue() >= value )
		{
			addToFront( value );
			
			return;
		}
		
		/*
		 * Assuming I don't have either one of those two cases. I am
		 * going to be inserting the new value at the front of the 
		 * list. I, then would need to find the insertion point.
		 * Since this is a SinglyLinkedList (it is a wrinkle). 
		 * So I'm going to do is traverse the list looking for the 
		 * first node with the value that's >= to the value that I 
		 * want to insert. 
		 */
		IntegerNode current = head.getNext();
		
		IntegerNode previous = head;
		
		while ( current != null && current.getValue() < value )
		{
			previous = current;
			
			current = current.getNext();
		}
		
		IntegerNode newNode = new IntegerNode( value );
		
		newNode.setNext( current );
		
		previous.setNext( newNode );
		
		size++;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public void printList()
	{
		IntegerNode current = head;
		
		System.out.print( " HEAD --> " );
		
		/*
		 * Keep traversing the list until current hits "null". 
		 * When it hits "null", I've reached the end of the list
		 */
		while ( current != null )
		{
			System.out.print( current );
			
			System.out.print( " <==> " );
			
			current = current.getNext();
			
		}
		
		System.out.println( "NULL" );
		
		
	}

}
