
/**
 * @author Niser, Khalil (06/16/2023)
 * 
 * Data Structure: Hashtables Chaining (ChainedHashtable) 
 * Theory/Implementation
 * 
 * 				---- HASHTABLES ----
 * The Hashtable class implements a hash table, which maps keys to values. 
 * Any non-null object can be used as a key or as a value. To successfully 
 * store and retrieve objects from a hashtable, the objects used as keys 
 * must implement the hashCode method and the equals method.  
 * 
 * The java.util.Hashtable class is a class in Java that provides a key-value 
 * data structure, similar to the Map interface. It was part of the original 
 * Java Collections framework and was introduced in Java 1.0.
 * 
 * However, the Hashtable class has since been considered obsolete and its use 
 * is generally discouraged. This is because it was designed prior to the 
 * introduction of the Collections framework and does not implement the Map 
 * interface, which makes it difficult to use in conjunction with other parts 
 * of the framework. In addition, the Hashtable class is synchronized, which 
 * can result in slower performance compared to other implementations of the 
 * Map interface.
 * 
 * In general, it’s recommended to use the Map interface or one of its 
 * implementations (such as HashMap or ConcurrentHashMap) instead of the 
 * Hashtable class.
 * 
 * ------------------------------------------------------------------------
 * 1.	Abstract Data Type: It doesn't dictate how the data is stored
 * 2.	Provides access to data using keys: 
 * 3.	Key doesn't have to be an integer
 * 4.	Consists of Key/value pairs: Data types don't have to match
 * 5.	Optimized for retrieval( when you know the key )
 * 6.	Associative Array is one type of hash table
 * 
 * 				---- HASHING ----
 * 1.	Maps keys of any data type to an integer
 * 2.	Hash function maps keys to an integer
 * 3.	In Java, hash function is Object.hashCode()
 * 4.	Collision occurs when more than one value has the same hashed
 * value
 * 
 * --------------------------------------------------------------------------
 * 				---- LOAD_FACTOR ----
 * 1.	Tells as how full a hash table is: Suppose we're backing the hash 
 * table with an Array(). The load factor will tell us how full is the 
 * array. And that is achieved by dividing the (# of items / capacity).
 * Which is essentaily the (size / capacity)
 * 
 * 2.	Load factor = number of items/capacity = size/capacity
 * 
 * 3.	Load factor is used to decide when to resize the array backing 
 * the hash table.
 * 
 * 4.	Do Not want Load factor too low (lots of empty spaces)
 * 
 * 5.	Do Not want load factor too high (will increase the likelihood
 * of Collisions)
 * 
 * 6.	Can play a role in determining the time complexity for retrieval 
 * 
 * -----------------------------------------------------------------------------
 * 				---- ADD_TO_A_HASHTABLE_BACKED_BY_AN_ARRAY()
 * 1.	Provide a key/value fair
 * 
 * 2.	Use a Hash function to hash the key to an integer value
 * 
 * 3.	Store the value at the hashed key value: This is the 
 * index into the array
 * 
 * ----------------------------------------------------------------------------
 * 
 * 				---- RETRIEVE_A_VALUE_FROM_A_TABLE ----
 * 1.	Provide the key 
 * 
 * 2.	Use a Hash function to hash the key to an integer value
 * 
 * 3.	Retrieve the value stored at the hashed key value
 * 
 * 
 * ----------------------------------------------------------------------------
 * 				---- ADD_"JANE_JONES"_WITH_THE_KEY_OF_JONES ----
 * 1.	Use a hash function to map "Jones", to an integer. Let's 
 * assume we get the value 4
 * 2.	Store "Jane Jones" at array[4]
 * 
 * 				---- RETRIVE_THE_EMPLOYEE_WITH_THE_KEY_OF_JONES ----
 * 1.	Provide the key "Jones"
 * 1.	Use the same hash function to map "Jones", to an integer. Let's 
 * assume we get the value 4
 * 2.	Retrieve the value at array[4] -> "Jane Jones"
 * 
 * 
 * 
 * -------------------------------------------------------------------------
 * 				---- CHAINING ----
 * Hash Tables(similar to tables in general) provide a subset of the 
 * dynamic set operations. Usually, a set of keys are mapped with some 
 * values based on certain relations. However, there might be situations 
 * when different keys map to the same position provided by the Hash 
 * function, which leads to a collision.
 * 
 * One of the ways to overcome this situation is Hash Table Chaining. 
 * 
 * The chaining approach to resolve collisions deals with it by going ahead 
 * and putting all the keys that map to a slot in that slot but representing 
 * them as a linked list.
 * 
 * Hash Table chaining in Java is possible with both, Singly Linked List and 
 * Doubly Linked List. Though the implementation is same, the only difference 
 * is that Doubly Linked List allows two-way traversal i.e., the node contains 
 * a pointer to the next as well as the previous node. 
 * 
 * 				---- TIME_COMPLEXITY ----
 *  Thus, the complexity of insertion and deletion at a known position is 
 *  reduced to O(1) (Constant Time) as compared to the Singly Linked List (O(n)) 
 *  (Linear Time) For this program I am writing the code for Chaining using a 
 *  Singly Linked List. Using LinkedList makes the implementation easier because 
 *  there is always room at the "Hashed" location. 
 *  But that doesn't mean that "Chaining" is better than "Linear Probing". In fact 
 *  on average Linear Probing performs better than Chaining does. It just means 
 *  that the implementation is a little bit simpler
 *  
 */


package hashTable.chaining;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable 
{
	
	/**
	 * "Hashtable" field Using the LinkedList class in my JDK
	 * with StoredEmployee as my parameter, with an array of 
	 * LinkedList I will call it hashtable
	 */
	private LinkedList< StoredEmployee >[] hashtable;
	
	/**
	 * 				---- CLASS_CONSTRUCTOR ----
	 */
	public ChainedHashtable()
	{
		hashtable = new LinkedList[ 10 ];
		
		/*
		 * Initialize each array position with a LinkedList
		 * (an empty LinkedList)
		 */
		for ( int i = 0; i < hashtable.length; i++ )
		{
			hashtable[ i ] = new LinkedList< StoredEmployee >();
		}
	}
	
	/**
	 * 				---- PUT_METHOD ----
	 * @param key
	 * @param employeee
	 */
	public void put( String key, Employee employee )
	{
		// Hash the key
		int hashedKey = hashKey( key );
		
		/*
		 * Add the employee to the LinkedList, that's 
		 * at the position hashedKey
		 */
		hashtable[ hashedKey ].add( new StoredEmployee ( key, employee ) );
	}
	
	/**
	 * 				---- GET_METHOD ----
	 * @param key
	 * @return
	 */
	public Employee get( String key )
	{
		// Hash the key
		int hashedKey = hashKey( key );
		
		/*
		 * Search the LinkedList at the position hashedKey
		 * for the "StoredEmployee" that matches this key.
		 * NOTE: I will use the ListIrerator to implement 
		 * the said code function
		 */
		ListIterator< StoredEmployee > iterator = 
				hashtable[ hashedKey ].listIterator();
		
		StoredEmployee employee = null;
		
		while ( iterator.hasNext() )
		{
			employee = iterator.next();
			
			if ( employee.key.equals( key ) )
			{
				return employee.employee;
			}
		}
		
		/*
		 * If By the time I drop out of this loop, it means
		 * I have iterated over the entire list and I have
		 * not found the StoredEmployee instance that matches
		 * the key so I'm just going to return null
		 */
		return null;
	}
	
	/**
	 * 				---- REMOVE_METHOD ----
	 * @param key
	 * @return
	 */
	public Employee remove( String key )
	{
		// Hash the key
		int hashedKey = hashKey( key );

		/*
		 * Search the LinkedList at the position hashedKey 
		 * for the "StoredEmployee" that matches this key. 
		 * NOTE: I will use the ListIterator to implement 
		 * the said code function
		 */
		ListIterator< StoredEmployee > iterator = 
				hashtable[ hashedKey ].listIterator();

		StoredEmployee employee = null;
		
		int index = -1;

		while ( iterator.hasNext() ) 
		{
			employee = iterator.next();
			
			 /*
			  * Every time a name is pulled off the iterator
			  * I want to increment the index 
			  */
			index++;

			if ( employee.key.equals( key ) ) 
			{
				break;
			}
		}

		/*
		 * When I break out of the loop there is two 
		 * possibilities. I have completely traversed 
		 * the list and I haven't found a StoredEmployee 
		 * instance that matches. Or the StoredEmployee
		 * employee field now contains the employee I'm 
		 * interested in.
		 */
		
		/*
		 * if employee equals null. This means it traversed 
		 * the entire list and it didn't find the employee 
		 * I'm looking for
		 */
		if ( employee == null )
		{
			return null;
		}
		/*
		 * It did find the employee I'm looking for
		 * and I want to remove it from the list
		 */
		else
		{
			hashtable[ hashedKey ].remove( index );
			
			return employee.employee;
		}
		
	}
	
	/**
	 * 				---- HASHKEY_METHOD ----
	 * @param key
	 * @return
	 */
	private int hashKey( String key )
	{
//		return key.length() % hashtable.length;
		
		return Math.abs( key.hashCode() % hashtable.length );
	}
	
	/**
	 * 				---- PRINT_HASHTABLE_METHOD ----
	 */
	public void printHashtable()
	{
		// Traverse the LinkedList at every position
		for ( int i = 0; i < hashtable.length; i++ )
		{
			// Don't traverse an empty LinkedList
			if ( hashtable[ i ].isEmpty() )
			{
				System.out.println( "position " + i + ": is Empty!" );
			}
			/*
			 * If, the LinkedList is Not empty, then I will need to 
			 * traverse the LinkedList. I will use the ListIterator
			 */
			else
			{
				System.out.print( "position " + i + ": " );
				
				/*
				 * Search the LinkedList at position i in the hashtable
				 * for the "StoredEmployee" that matches this key. 
				 * NOTE: I will use the ListIterator to implement 
				 * the said code function
				 */
				ListIterator< StoredEmployee > iterator = 
						hashtable[ i ].listIterator();
				
				while ( iterator.hasNext() )
				{
					System.out.print( iterator.next().employee );
					System.out.print( " --> ");
				}
				
				/*
				 * At the end of each list have it point to null
				 */
				System.out.println( "null" );
			}
		}
	}

}
