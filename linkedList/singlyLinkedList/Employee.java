
/**
 * @author Niser, Khalil: (02/26/2023)
 * 
 * Data Structure: Employee ( SinglyLinkedList )
 * 	
 * 				---- IMPLIMENTATION/THEORY ----
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

//import vectors.vectorList.Employee;

public class Employee 
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
	public Employee(String firstName, String lastName, int employeeID) 
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
	public String getFirstName() {
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
	 * ---- toSTRING_METHOD() ---- toString: I want a toString() method generated. I
	 * want to be able to @Override the default because when I print an employee
	 * instance I'd like to see a firstName, lastName, and employeeID, I don't just
	 * want to see the object reference
	 */
	public String toString() 
	{
		return "Employee{ " + " firstName='" + firstName + '\'' + ", lastName='" 
	+ lastName + '\'' + ", employeeID'" + employeeID + '}';
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) 
		{
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) 
		{
			return false;
		}

		Employee employee = (Employee) obj;

		if (employeeID != employee.employeeID) 
		{
			return false;
		}
		if (!firstName.equals(employee.firstName)) 
		{
			return false;
		}

		return lastName.equals(employee.lastName);
	}

	@Override
	public int hashCode() 
	{
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + employeeID;

		return result;
	}

}
