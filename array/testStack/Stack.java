package array.testStack;

public class Stack 
{
	
	final static int RogueValue = -999999;
	Node top = null;
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	public void push( int n )
	{
		Node node = new Node( n );
		
		node.next = top;
		this.top = node;
	} // END PUSH
	
	public int pop()
	{
		if ( this.isEmpty() )
		{
			return RogueValue;
		}
		
		int hold = top.data;
		top = top.next;
		
		return hold;
	} // END POP
	
	public int peek()
	{
		if ( this.isEmpty() )
		{
			System.out.printf( "Stack is Empty!" );
			
			return RogueValue;
		}
		else
		{
			return top.data;
		}
	} // END PEEK
	
	public void display()
	{
		Node tempDisplay = top;
		
		while ( tempDisplay != null )
		{
			System.out.println( tempDisplay.data );
			
			// Move on to the next Node
			tempDisplay = tempDisplay.next;
		}
	}

}
