
/**
 * @author Niser, Khalil: (01/26/2023)
 * 
 * Data Structure: EmplloyeeClass ( ArrayList )
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

import java.util.ArrayList;
import java.util.List;

public class EmployeeClass 
{

	public static void main(String[] args) 
	{
		/*
		 * 				---- LIST ----
		 * The reason I am using "List" rather than ArrayList, is by
		 * using List, if I decide later I want to use a different 
		 * type of List, it's easy to change the specific implementation
		 * of List that I am using.
		 * 
		 * 				---- RESIZING_THE_ARRAY ----
		 * I am not going to worry about resizing the array is because I
		 * am only going to add four employees. And in Java the default 
		 * capacity of an ArrayList is 10.
		 */
		List< Employee > employeeList = new ArrayList<>();
	
		employeeList.add( new Employee ( "Jack", "MeOff", 5545454 ) );

		employeeList.add( new Employee ( "Deez", "Nutz", 8675309 ) );
		
		employeeList.add( new Employee ( "Nicko", "Balakhoph", 3693693 ) );
		
		employeeList.add( new Employee ( "Khalil", "Niser", 6666969 ) );
		
		/*
		 * 				---- LAMBDA_EXPRESSION ----
		 * 
		 * Prints the items in the List.
		 */
		employeeList.forEach( myEmployee -> System.out.println( myEmployee ) );
		
		System.out.println();
		
		// Print out the second employee on the list
		System.out.println( "\t---- SECOND EMPLOYEE ON THE LIST ----" );
		System.out.println( employeeList.get( 1 ) );
		
		/*
		 * Check of the list of Employee's isEmpty:
		 * Return a "False", because the list is NOT empty
		 */
		System.out.println();
		System.out.println( "---- CHECK IF THE LIST (ArrayList) IS EMPTY: ----> "
		+ employeeList.isEmpty() );
		
		System.out.println();
		
		/*
		 * Replace one employee with another. Employee may be within 
		 * the "list", or just another randomly new employee
		 * See Code Below:
		 * nameOfListThatContainsData.set(FirstParameter is the index of the
		 * employee being replaced), new Employee(name of NewEmployeee)
		 * 
		 * NOTE: listName.set(Replaces current employee on the list). Were as 
		 * listName.add(Will allow us to add a new employee. At the end of 
		 * the list)
		 */
		System.out.println( "\t---- REPLACE EMPLOYEE NAME ----");
		System.out.println( "\t---- Replace Name of Second Employee ----\n"
				+ "\t---- (Deez Nutz), on the List With John Doe ----");
		employeeList.set( 1, new Employee( "John", "Doe", 3053050) );
		
		employeeList.forEach( myEmployee -> System.out.println( myEmployee ) );
		
		/*
		 * This code will return the size of Employee's stored
		 * in memory not the capacity it can hold.
		 */
		System.out.println();
		System.out.println( "\t---- SIZE_OF_LIST ----");
		 System.out.println( "Number of Items on the List: " + 
		 employeeList.size() );
		
		 System.out.println( );
		
		// Add Deez Nuts back to the list
		 System.out.println( "\t---- ADD_DEEZ_NUTZ_BACK_TO_THE_LIST_INDEX_4: ----" );
		employeeList.add( 3, new Employee( "Deez", "Nutz", 8675309 ) );
		
		 employeeList.forEach( myEmployee -> System.out.println( myEmployee ) );
		
	    System.out.println();
	    
	    
		/*
		 * 				---- EMPLOYEE_ARRAY_(OBJECT_ARRAY) ----
		 * If I want the array, let's say I have an arrayList and 
		 * I want that backing array. I want the array that's holding
		 * the employee's, but I won't be getting an employee array,
		 * instead I will getting an "Object Array"
		 */
		
		// ---- OBJECT_ARRAY_METHOD ----
		// Object[] employeeArray = employeeList.toArray();
	    
	    /*
	     * ---- EMPLOYEE_ARRAY_METHOD
	     * Just as the code for the Object Array, only difference 
	     * is instead calling on the employeeArray (toArray()) and 
	     * not passing anything, I will change this call to say 
	     * (as an argument) (new Employee[employeeList.size()])
	     * the employee array passing as an argument the size,
	     * the length of the employeeList. 
	     */
	    System.out.println( "    ---- EMPLOYEE_ARRAY ----: ");
		Employee[] employeeArray = employeeList.toArray(
				new Employee[ employeeList.size() ] );
		
		System.out.println( "The names of the five Employees we have"
				+ " on the\nlist, but this time will be geeting "
				+ " the \"employeeArray\"!" );
		
		System.out.println();
		
		for ( Employee employee: employeeArray )
		{
			System.out.println( employee );
		}
		
		System.out.println();
		
		System.out.print( "Know Whether the List Contains an instance."
				+ " For\nthat I will call the \"Contains\" method."
				+ " To check\nwhether the List Contains a certain Employee: ");
		
		System.out.println( employeeList.contains( new Employee( "Jack", 
				"MeOff", 5545454 ) ) );
		
		/*
		 * Because I have implemented the "equals Method" in the 
		 * Employee Class, this should return the index of the 
		 * method. Any name I specify. Watch Code Below!
		 */
		System.out.println();
		System.out.println( "\t---- INDEX_OF_METHOD ----" );
		System.out.println( "Index of method, will return the name of the"
				+ "\nindex number in which the Employee \"Deez Nutz: \" exists is in: " +
		 employeeList.indexOf( new Employee( "Deez", "Nutz", 8675309 ) ) );
		
		/*
		 * 				---- REMOVE_ITEM_FROM_LIST ----
		 */
		System.out.println();
		
		System.out.println( "Last, but not least. I will Remove"
				+ " an Item from the List.\nNOTE: All the Elemets that "
				+ "come after the one that was remeoved,\nwill be shifted "
				+ "down one position!");
		
		System.out.println( "\t---- REMOVE_AN_ITEM_FROM_THE_LIST! ----");
		
		System.out.println();
		employeeList.remove( 2 );
		// This line prints out the list (employeeList)
		employeeList.forEach( myEmployee -> System.out.println( myEmployee ) );
		

	}

}
