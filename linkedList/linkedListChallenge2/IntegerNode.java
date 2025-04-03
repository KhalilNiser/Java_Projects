package linkedList.linkedListChallenge2;

public class IntegerNode 
{
	// Value variable
	private Integer value;
	
	/*
	 * This variable (EmployeeNode (next) stores a 
	 * reference to the next node in the list
	 */
	private IntegerNode next;
	
	// Previous variable
	private IntegerNode previous;
	
	/**
	 * 				---- CLASS_CONSTRUCTOR ----
	 * @param value
	 */
	public IntegerNode( Integer value )
	{
		this.value = value;
	}

	/*				---- GETTERS_SETTERS ----				*/
	
	/**
	 * 				---- GETTER ----
	 * 
	 * @return value
	 */
	public Integer getValue() 
	{
		return value;
	}

	/**
	 * 				---- SETTER ----
	 * 
	 * @param value
	 */
	public void setValue( Integer value ) 
	{
		this.value = value;
	}

	/**
	 * 				---- GETTER ----
	 * 
	 * @return next
	 */
	public IntegerNode getNext() 
	{
		return next;
	}

	/**
	 * 				---- SETTER ----
	 * 
	 * @param next
	 */
	public void setNext( IntegerNode next ) 
	{
		this.next = next;
	}

	/**
	 * 				---- GETTER ----
	 * 
	 * @return
	 */
	public IntegerNode getPrevious() 
	{
		return previous;
	}

	/**
	 * 				---- SETTER ----
	 * 
	 * @param previous
	 */
	public void setPrevious( IntegerNode previous ) 
	{
		this.previous = previous;
	}
	
	public String toString()
	{
		return value.toString();
	}

}
