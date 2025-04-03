
/**
 * @author Niser, Khalil: (01/26/2023)
 * 
 * Data Structure: Employee ( ArrayList )
 * 
 * 				---- ARRAY_LIST ----
 * Resizable-Array implementation of the list interface. Implements all optional
 * operations, and permits all the elements, including null. In addition to 
 * implementing the list interface, this class provides methods to manipulate the 
 * size of the array that is used internally to store the list. (This class is 
 * Roughly equivalent to vector, except that it this unsynchronized). 
 *  
 * 				---- TIME_COMPLEXITY ----
 * The size, isEmpty, get, set, iterator, and listIterator, operations run in 
 * constant time. The "add" operations runs in amortized constant time, that is, 
 * adding "n" elements requires O(n) time. All of the other operations run in 
 * linear time (roughly speaking). The constant factor is low compared to that of
 * the linkedList implementations. 
 * 
 * 				---- CAPACITY ----
 * Each array list instance has a capacity. The capacity is the size of the array 
 * used to store the elements in the list. It is always at least as large as the 
 * list size. As elements are added to an arrayList, it's capacity grows 
 * automatically. The details of the growth policy are not specified beyond the 
 * fact that adding an element has constant amortized cost.
 * 				---- SIZE_INCREASE ----
 * An application can increase the size of an "arrayList" before adding a large 
 * number of elements using the ensureCapacity operation. This may reduce the 
 * amount of incremental reallocation. 
 * 
 * NOTE: That this implementation (arrayList) is not synchronized.
 */

package list.arrayLists;

public class Employee 
{
	// Variables 
	private String firstName;
	private String lastName;
	private int employeeID;
	
	/**
	 * 				---- CLASS_CONSTRUCTOR ----
	 * 
	 * @param firstName
	 * @param lastName
	 * @param employeeID
	 */
	public Employee( String firstName, String lastName, int employeeID )
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
	}
	
	// SETTERS/GETTERS
	/*
	 * getFirstName;
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/*
	 * setFirstName
	 */
	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}
	
	/*
	 * getLastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/*
	 * setLastName
	 */
	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}
	
	/*
	 * getEmployeeID
	 */
	public int getEmployeeID()
	{
		return employeeID;
	}
	
	/*
	 * setEmployeeID
	 */
	public void setEmployeeID(int employeeID )
	{
		this.employeeID = employeeID;
	}
	

	/*
	 * 				---- toSTRING_METHOD() ----
	 * toString: I want a toString() method generated. I want to be
	 * able to @Override the default because when I print an employee 
	 * instance I'd like to see a firstName, lastName, and employeeID, 
	 * I don't just want to see the object reference
	 */
	@Override
	public String toString()
	{
		return "Employee{" + 
				"FirstName: '" + firstName + '\'' +
				", LastName: '" + lastName + '\'' +
				", EmployeeID: '" + employeeID + '}';
	}
	
	
	// 				---- EMPLEMENT THE EQUALS METHOD ----
	@Override
	public boolean equals( Object obj )
	{
		if ( this == obj )
		{
			return true;
		}
		if ( obj == null || getClass() != obj.getClass() )
		{
			return false;
		}
		
		Employee employee = ( Employee ) obj;
		
		if ( employeeID != employee.employeeID )
		{
			return false;
		}
		if ( !firstName.equals( employee.firstName ) )
		{
			return false;
		}
		
		return lastName.equals(employee.lastName );
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
