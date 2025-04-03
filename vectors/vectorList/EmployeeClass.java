
/**
 * @author Niser, Khalil: (02/23/2023)
 * 
 * Data Structure: EmployeeClass ( Vectors )
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
 * NOTE: As of the Java 2 platform v1.2, this class was retrofitted to implement the "List"
 * interface, making it a member of the Java Collections Framework. Unlike the new collection
 * implementation, "Vector" is synchronized. If a thread-safe implementation is not needed, it
 * is recommended to use "ArrayList" in place of "Vector".
 */

package vectors.vectorList;

//import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class EmployeeClass 
{

	public static void main(String[] args) 
	{
		/*
		 * 				---- VECTOR ----
		 * This is the same project as that of ArrayList. If I want to 
		 * use Vector, because I have assigned this to "List Employee" 
		 * rather than "ArrayList Employee", all I have to do is change
		 * "ArrayList" into "Vector".
		 * 
		 * 				---- RESIZING_THE_ARRAY ----
		 * I am not going to worry about resizing the array is because I
		 * am only going to add four employees. And in Java the default 
		 * capacity of an ArrayList is 10.
		 */
		List< Employee > employeeList = new Vector<>();
	
		employeeList.add( new Employee ( "Jack", "MeOff", 5545454 ) );

		employeeList.add( new Employee ( "Deez", "Nutz", 8675309 ) );
		
		employeeList.add( new Employee ( "Nicko", "Balakhoph", 3693693 ) );
		
		employeeList.add( new Employee ( "Khalil", "Niser", 6666969 ) );
		
		/*
		 * 				---- LAMBDA_EXPRESSION ----
		 * Lambda expressions basically express instances of functional interfaces 
		 * (An interface with single abstract method is called functional interface. 
		 * An example is java.lang.Runnable). lambda expressions implement the only 
		 * abstract function and therefore implement functional interfaces
		 * 
		 * lambda expressions are added in Java 8 and provide below functionalities.
		 * 
		 * I)	Enable to treat functionality as a method argument, or code as data.
		 * II)	A function that can be created without belonging to any class.
		 * III)	A lambda expression can be passed around as if it was an object and 
		 * executed on demand.
		 * 
		 * Prints the items in the List.
		 * 
		 */
		employeeList.forEach( myEmployee -> System.out.println( myEmployee ) );
		
		System.out.println();
		
		// Display name of the second employee (Deez Nuts on the list
		System.out.println( employeeList.get( 1 ) );
		
		/*
		 * Check of the list of Employee's isEmpty:
		 * Return a "False", because I have names 
		 * stored on the list
		 */
		System.out.println();
		System.out.println( "Check if the List (ArrayList) is empty: "
		+ employeeList.isEmpty() );
		
		System.out.println();
		
		/*
		 * Replace one employee with another. Employee may within the 
		 * "list", or just another random name, like below
		 */
		System.out.println( "Replaced \"Deez Nuts\" with \"Christina\"");
		employeeList.set( 1, new Employee( "Christina", "Owen", 3052345) );
		
		employeeList.forEach( myEmployee -> System.out.println( myEmployee ) );
		
		/*
		 * This code will return the size of Employee's stored
		 * in memory not the capacity it can hold.
		 */
//		 System.out.println( "Number of Employee's in the List: " + 
//		 employeeList.size() );
		
		// System.out.println( );
		
		// Add Deez Nuts back to the list
		employeeList.add( 1, new Employee( "Deez", "Nutz", 8675309 ) );
		
		// employeeList.forEach( myEmployee -> System.out.println( myEmployee ) );
		
		// System.out.println();
		/*
		 * Employee Array (Object Array)
		 */
		System.out.println( "    ---- OBJECT_ARRAY ----: ");
		Employee[] employeeArray = employeeList.toArray(
				new Employee[ employeeList.size() ] );
		
		System.out.println( "The name of the five Employees's we have"
				+ " on the\nlist, but in an \"Employee_Array\" instead");
		System.out.println();
		for ( Employee employee: employeeArray )
		{
			System.out.println( employee );
		}
		
		System.out.println();
		System.out.print( "Know Whether the List Contains an instance."
				+ " For\nthat I will call the \"Contains\" method."
				+ " To check\nwhether the List Contains a certain Employee: ");
		System.out.println( employeeList.contains( new Employee( "Khalil", 
				"Niser", 6666969 ) ) );
		
		/*
		 * Because I have implemented the "equals Method" in the 
		 * Employee Class, this should return the index of the 
		 * any name I specify. Watch Code Below!
		 */
		System.out.println( "Index of employee Deez Nutz: " +
		 employeeList.indexOf( new Employee( "Deez", "Nutz", 8675309 ) ) );
		
		/*
		 * 				---- REMOVE_ITEM_FROM_LIST ----
		 */
		employeeList.remove( 2 );
		employeeList.forEach( myEmployee -> System.out.println( myEmployee ) );

	}

}
