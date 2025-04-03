package Stacks.demo;

public class Stack 
{

	final static int RogueValue = -999999;
	Node top = null;

	public boolean isEmpty() 
	{
		return top == null;
	}

	public void push(int n) 
	{
		Node node = new Node(n);
		node.next = top;
		top = node;
	} // end push

	public int pop() 
	{
		if (this.isEmpty())
			return RogueValue; // a symbolic constant
		int hold = top.data;
		top = top.next;
		return hold;
	} // end pop

	public void display() 
	{
		// start at the beginning of linkedList
		Node tempDisplay = top; 
		
		// Executes until we don't find end of list.
		while (tempDisplay != null) 
		{ 
			System.out.println(tempDisplay.data);
			tempDisplay = tempDisplay.next; // move to next Node
		}
	}

	public int peek() 
	{
		if (isEmpty()) 
		{
			System.out.printf("Stack is empty!");
			return RogueValue;
		} else 
		{
			return top.data;
		}
	}
}
