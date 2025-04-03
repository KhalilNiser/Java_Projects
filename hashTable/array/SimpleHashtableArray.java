
/**
 * @author Niser, Khalil (0/23/2023)
 * 
 * Data Structure: Employee Array[] (Hashtables) Theory/Implementation
 * 
 * 				---- HASH_TABLES ----
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
 * 1.	ABstract Data Type: It doesn't dictate how the data is stored
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
 * 				---- ADD_TO_A_HASHTABLE_BACKED_BY_AN_ARRAY()
 * 1.	Provide a key/value fair
 * 
 * 2.	Use a Hash function to hash the key to an integer value
 * 
 * 3.	Store the value at the hashed key value: This is the 
 * index into the array
 * 
 * 				---- RETRIEVE_A_VALUE_FROM_A_TABLE ----
 * 1.	Provide the key 
 * 
 * 2.	Use a Hash function to hash the key to an integer value
 * 
 * 3.	Retrieve the value stored at the hashed key value
 * 
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
 * 				---- TIME_COMPLEXITY ----
 * Retrieval runs in constant time O(1). Array direct access. This does 
 * not depend on the number of items that are in the array.
 * 
 */

package hashTable.array;

public class SimpleHashtableArray 
{
	private Employee[] hashtable;
	
	/**
	 * 				---- CONSTRUCTOR ----
	 * I will need a class constructor to set up the array.
	 * Pass as a parameter "hashtable" with a capacity of 10.
	 * 
	 * @param hashtable
	 */
	public SimpleHashtableArray()
	{
		hashtable = new Employee[ 10 ];
	}
	
	/**
	 * 				---- PUT_METHOD ----
	 * Method "put", employee's into the hashtable
	 * @param key
	 * @param employee
	 * 
	 * 				---- COLLISION ----
	 * 				---- IF_CONDITION_STATEMENT ----
	 * This hashtable does not handle collisions. So if 
	 * I try to put an employee into the hashtable, and
	 * when I hash the key, the hashed value is the same 
	 * value of an employee that I've already added. I'm 
	 * not going to add the employee. Instead I will have 
	 * a message saying "Sorry That array[] position is 
	 * already taken". Because this hashtable does not handle 
	 * Collision
	 */
	public void put( String key, Employee employee )
	{
		/*
		 * The "hashedKey", will give me the index into the 
		 * array. And then I'm going to have a really simple 
		 * hashtable.
		 */
		int hashedKey = hashKey( key );
		
		// If, there is a key inside the hashtable
		if ( hashtable[ hashedKey ] != null )
		{
			System.out.println( "Sorry, an employee already "
					+ " exists at position " + hashedKey );
		}
		/*
		 * Else, if that's not the case, then I will go ahead 
		 * and assign the employee into the "hashtable.index.
		 * hashedKey"
		 */
		else
		{
			hashtable[ hashedKey ] = employee;
		}
	}
	
	/**
	 * 				---- RETRIVE_METHOD ----
	 * @param key
	 * @return Retrieves an employee from the hashtable
	 * 
	 * 				---- TIME_COMPLEXITY ----
	 * Retrieval runs in constant time O(1), direct access
	 */
	public Employee retreive( String key )
	{
		int hashedKey = hashKey( key );
		
		return hashtable[ hashedKey ];
	}
	
	/**
	 * 				---- HASHING_METHOD ----
	 * @param key
	 * @return The length of the key modulus with the 
	 * length of the hashtable.
	 * 
	 * Basically taking a String (key), and hashing it to 
	 * an integer (key).
	 * 
	 * For example: Let's say I want to do "Jane Jones", my
	 * key.length will be "5", and the hashtable length is
	 * "10", so 5/10 = 0; with a remainder of 5. So I would 
	 * expect the key "jones" to return a hash value of 5.
	 * 
	 * NOTE: The "key", and the hashed value are NOT the same
	 * thing. We take the key and we hash it to a hashed value.
	 * The key can be anything. It can be a String, it can be 
	 * a character, it can be an Employee, while the hashed 
	 * value on the contrary, is always an "integer".
	 */
	private int hashKey( String key )
	{
		return key.length() % hashtable.length;
	}
	
	// Print hashtable method
	public void printHashtable()
	{
		for ( int i = 0; i < hashtable.length; i++ )
		{
			System.out.println( hashtable[ i ] );
		}
	}

}
