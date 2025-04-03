
/**
 * @author Niser, Khalil: (2023/06/03)
 * 
 * Vectors.vectorLists: VectorTesting
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
 * NOTE: As of the Java 2 platform this class was retrofitted to implement the 
 * "List" interface, making it a member of the Java Collections Framework. unlike
 * the new collection implementation, "Vector" is synchronized. If a thread-safe 
 * implementation is not needed, it is recommended to use "ArrayList" in place of 
 * "Vector".
 */

package Vectors.vectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorTesting 
{

	/**
	 * 				---- ARRAYLIST_VS_VECTORS ----
	 * 				---- PERFORMANCE ----
	 * 				---- ADD_ITEMS_TO_AN_ARRAYLIST ----
	 * On the surface Vectors act exactly like an ArrayList. So, if they do 
	 * exactly the same thing, Why would you choose one over the other? How
	 * are they actually different? Why do they both exist? So, let's start
	 * going over some of those differences. 
	 * One of those differences is performance. Let's dive-in write some quick
	 * code to compare how long it takes to add a million items to an ArrayList
	 * vs a million items to a Vector.  
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/*
		 * This Variables is going to hold the number of elements
		 * that we want to add to our ArrayList and to our Vector.
		 * I want to add a million elements to each of them
		 */
		int size = 1000000;

		
		// DECLARE an ARRAY_LIST
		List< Integer > arrayList = new ArrayList<>();
		
		/*
		 * Timer times how long it takes to add a million items to 
		 * our arrayList. Time in milliseconds
		 */
		long start = System.currentTimeMillis();
		
		for ( int i = 0; i < size; i++ )
		{
			arrayList.add( i );
		}
		/*
		 * Capture the system time after we have added the
		 * million elements to our list. STOP TIMER
		 */
		long end = System.currentTimeMillis();
		
		System.out.println( "To Add " + size + " Elements to our ArrayList "
				+ "it Took: " + (end - start) + "ms");
		
		
		
		/** 				---- DECLARE_A_VECTOR ----			*/
		
		List< Integer > vector = new Vector<>();
		
		/*
		 * Timer to time how long it takes to add a million items to 
		 * our arrayList. Time in milliseconds
		 */
		start = System.currentTimeMillis();
		
		for ( int i = 0; i < size; i++ )
		{
			vector.add( i );
		}
		/*
		 * Capture the system time after we have added those
		 * million elements to our list. STOP TIMER
		 */
		end = System.currentTimeMillis();
		
		System.out.println();
		System.out.println( "To Add " + size + " Elements to our VECTOR'S LIST "
				+ "it Took: " + (end - start) + "ms");
		
		
		
		
		/** 				---- ADD_MULTI_THREADS_TO_AN_ARRAYLIST ----				 */
		
		List< Integer > multithreadList = Collections.synchronizedList( new ArrayList<>() );
		
		start = System.currentTimeMillis();
		
//		// LAMBDA EXPRESSION
		Thread t1 = new Thread(() -> 
		{
			
			for ( int i = 0; i < size; i++ )
			{
				multithreadList.add( i );
			}
		});
		
		
		Thread t2 = new Thread(() -> 
		{

			for (int i = 0; i < size; i++) 
			{
				multithreadList.add( i );
			}
		});
		
		// CALL EACH THREAD
		t1.start();
		t2.start();
		
		// COMPLETED WORK
		try 
		{
			t1.join();
		} 
		catch ( InterruptedException ie ) 
		{
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		try 
		{
			t2.join();
		} 
		catch ( InterruptedException ie ) 
		{
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		
		end = System.currentTimeMillis();
		
		System.out.println();
		System.out.println( "To Add Elements using Multithreads to an ArrayList LIST "
				+ "it Took: " + (end - start) + "ms");
		System.out.println( "Size is: " + multithreadList.size() );
		
		
		
		
		/** 				---- ADD_MULTI_THREADS_TO_A_VECTORLIST ----				 */
		
		List< Integer > multithreadedVectorList = new Vector<>();
		
		start = System.currentTimeMillis();
		
		// LAMBDA EXPRESSION
		t1 = new Thread(() -> 
		{
			
			for ( int i = 0; i < size; i++ )
			{
				multithreadedVectorList.add( i );
			}
		});
		
		
		t2 = new Thread(() ->
		{
			
			for ( int i = 0; i < size; i++ )
			{
				multithreadedVectorList.add( i ); 
			}
		});
		
		// CALL EACH THREAD
		t1.start();
		t2.start();
		
		// COMPLETED WORK
		try 
		{
			t1.join();
		} 
		catch ( InterruptedException ie ) 
		{
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		try 
		{
			t2.join();
		} catch (InterruptedException ie) 
		{
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		
		end = System.currentTimeMillis();
		
		System.out.println();
		System.out.println( "To Add Elements using Multithreads to a Vector LIST "
				+ "it Took: " + (end - start) + "ms");
		System.out.println( "Size is: " + multithreadedVectorList.size() );
		
	}

}
