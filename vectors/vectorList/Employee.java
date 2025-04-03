
/**
 * @author Niser, Khalil: (02/23/2023)
 * 
 * Data Structure: Employee ( Vectors )
 * 
 * 				---- VECTOR ----
 * The Vector class implements a growable array of objects. Like an array, it 
 * contains components that can be accessed using an integer index. However,
 * the size of the "vector" can grow or shrink as needed to accommodate, adding,
 * and removing items after the vector has been created.
 *  
 * 				---- CAPACITY ----
 * Each "Vector" tries to optimize storage management by maintaining a "capacity
 * and a capacityIncrement". The capacity is always at least as large as the 
 * "Vector" size. It is usually larger because as components are added to the 
 * "Vector", the "vector's" storage increases in chunks the size of "capacity-
 * Increment". An application can increase the capacity of a "vector" before 
 * inserting a larger number of components, this reduces the amount of incremental
 * reallocation.
 * 
 * 				---- ITERATOR ----
 * The iterator's returned by the classes "iterator" and "listIterator" are "fail-fast":
 * If the "vector" is structurally modified at any time after the "iterator" is created,
 * in any way except through the "iterator's" own remove or add methods, the "iterator"
 * will throw a "ConcurrentModificationException". Thus, in the face of concurrent 
 * modification, the "iterator" fails quickly and cleanly, rather than risking arbitrary,
 * non-deterministic behavior at an undetermined time in the future. The "Enumerations" 
 * returned by the elements method are not "fail-fast". If the "Vector" is structurally 
 * modified at any time after the enumeration is created then the results of enumerating
 * are undefined.
 * 
 * 
 * 				---- SIZE_INCREASE ----
 * An application can increase the size of an "arrayList" before adding a large 
 * number of elements using the ensureCapacity operation. This may reduce the 
 * amount of incremental reallocation. 
 * 
 * 				---- SYNCHRONIZATION ----
 * NOTE: As of the Java 2 platform v1.2, this class was retrofitted to implement 
 * the "List" interface, making it a member of the Java Collections Framework. 
 * Unlike the new collection implementation, "Vector" is synchronized. If a 
 * thread-safe implementation is not needed, it is recommended to use "ArrayList" 
 * in place of "Vector".
 */


package vectors.vectorList;

// import list.arrayLists.Employee;

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
	
	// 				---- SETTERS_GETTERS ----

	/**
	 * 				---- GETTER ----
	 * @return firstName
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * 				---- SETTER ----
	 * @param firstName
	 */
	public void setFirstName( String firstName ) 
	{
		this.firstName = firstName;
	}

	/**
	 * 				---- GETTER ---
	 * @return lastName
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/**
	 * 				---- SETTER ----
	 * 
	 * @param lastName
	 */
	public void setLastName( String lastName ) 
	{
		this.lastName = lastName;
	}

	/**
	 * 				---- GETTER ----
	 * @return employeeID
	 */
	public int getEmployeeID() 
	{
		return employeeID;
	}

	/**
	 * 				---- SETTER ----
	 * @param employeeID
	 */
	public void setEmployeeID( int employeeID ) 
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
	public String toString()
	{
		return "Employee{" + 
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", employeeID'" + employeeID + '}';
	}
	
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
