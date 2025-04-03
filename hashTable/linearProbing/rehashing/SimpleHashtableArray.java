
/**
 * @author Niser, Khalil (0/23/2023)
 * 
 * Data Structure: Employee linearProbing.array[] (linearProbing) 
 * Theory/Implementation
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
 * 				---- COLLISION_HANDLING ----
 * 				---- LINEAR_PROBING ----
 * Hashing with linear probing. Another approach to implementing hashing 
 * is to store N key-value pairs in a hash table of size M > N, relying 
 * on empty entries in the table to help with with collision resolution. 
 * Such methods are called open-addressing hashing methods. The simplest 
 * open-addressing method is called linear probing: when there is a 
 * collision (when we hash to a table index that is already occupied with 
 * a key different from the search key), then we just check the next entry 
 * in the table (by incrementing the index). 
 * 
 * There are three possible outcomes:
 * 1.	key equal to search key: search hit
 * 2.	empty position (null key at indexed position): search miss
 * 3.	key not equal to search key: try next entry
 * 
 * 
 * 				---- OPEN_ADDRESSING ----
 * There are two possible strategies in handling "Collision" when 
 * programming "Hashtables". The first one is called "Open Addressing".
 * So with open addressing what we do is, if we try to put an employee
 * into the table and we find out that there is already an employee at
 * the slot where we want to put the new employee, then we look for 
 * another position in the array[].
 * 
 * 
 * 				---- LINEAR_PROBING ----
 * There are different ways that we can check for other positions. I'm 
 * going to use what's called "linear probing". With linear probing when 
 * we discover that a position for a hashedKey value is already occupied, 
 * we increment the hashed value by 1, then we check the resulting index.
 * 
 * 
 * 				---- REHASHING ----
 * Rehashing is the process of increasing the size of a hashmap and 
 * redistributing the elements to new buckets based on their new hash 
 * values. It is done to improve the performance of the hashmap and to 
 * prevent collisions caused by a high load factor.
 * 
 * When a hashmap becomes full, the load factor (i.e., the ratio of the 
 * number of elements to the number of buckets) increases. As the load 
 * factor increases, the number of collisions also increases, which can 
 * lead to poor performance. To avoid this, the hashmap can be resized 
 * and the elements can be rehashed to new buckets, which decreases the 
 * load factor and reduces the number of collisions.
 * 
 * During rehashing, all elements of the hashmap are iterated and their 
 * new bucket positions are calculated using the new hash function that 
 * corresponds to the new size of the hashmap. This process can be time-
 * consuming. Of course that means removes will no longer be done in, 
 * constant time, even if the employee you are removing is at the position 
 * you expect him/her to be at, but it is necessary to maintain the 
 * efficiency of the hashmap.
 * 
 * 
 * 				---- TWO_WAYS_TO_SOLVE_PROBLEM ----
 * 				---- ADDING_CODE_TO_METHOD(REMOVE) ----
 * There are two ways to solve this problem. You can on the remove method 
 * you can rehash all of the items that are already in the hashtable. You
 * can start with a new hashtable. So you would create a new hashtable 
 * and then your going to loop through the existing array and your gonna
 * rehash all of the values because after we've deleted "Jane", that would
 * move "Mary" into position five. Because when we do the rehashing when
 * we come to "Mary", we're gonna hash her key, which is gonna end up being 
 * five and in the new hash table position five would be empty. That is one 
 * way of doing it. Of course that means that on every remove you're going 
 * to have to iterate through all of the remaining elements and rehash 
 * them. That would mean there will be a performance hit and of course that
 * means remove will no longer be done in constant time (O(1)). 
 * 
 * 				---- ADDING_CODE_TO_STORED_EMPLOYEE_CLASS) ----
 * The second way to deal with this problem is, instead nulling-out the
 * employee or the position in the array. Instead we can add a field to 
 * "storedEmployee" class that says whether an employee has been deleted 
 * or not. Now, how would this help. well it would let us distinguish 
 * between positions that have always been empty meaning nothing has ever 
 * been added to them, and positions that used to have something in them
 * but that something has been deleted. And so in that case when we did 
 * our "findKey", in the "while loop", the position of "deleted employees" 
 * would not be set to null. When I delete "Jane", I would not remove her,
 * I would just set her deleted field to "True", and when I deleted "Mike",
 * also I would not remove him, instead just set his deleted field to 
 * "True", as well. And so when I came looking for the field "Mary", 
 * positions five and six wouldn't be "null", and I would be able to find
 * her.
 * Now, of course this also has it's disadvantages. For one you're gonna 
 * end up with a polluted hash table, because you will have a mix of live
 * and deleted values. The other thing is it means that even though you 
 * are deleting items your load factor is not going to change and it means 
 * you are gonna have to be doing a lot more "linear probing", because when 
 * you go to add an item if it collides with a deleted item, then you would 
 * have to do "linear probing". 
 * 
 * And so in the first solution, you are going to be hit when you do a 
 * "remove", because you are going to have to rehash the entire table. 
 * With the second solution, You are going to be hit when you do "adds", 
 * because there is going to be a lot more collision and you're gonna have 
 * to do a lot more "linear probing", because you never really removed 
 * anything from the table essentially. It depends on were you're willing 
 * to take the hit. Do you wanna take it on gets, or do you wanna take on 
 * removes. 
 * I would rather take it on the removes. I would rather rehash the table
 * Only because I feel going through later method I would have a cluttered 
 * table causing more collision. Were as in the former one it would keep 
 * my table clean, avoid collisions and reduce my load factor.
 * 
 * 				---- TIME_COMPLEXITY ----
 * It's called "Linear Probing" because each time we increment the index,
 * we are doing in a linear fashion, and every increment of the index is 
 * called a "probe". So if we have to increment the index once before we 
 * find an empty position then we have to use one probe. If we have to 
 * Increment the index three times before we find an empty position, then 
 * we have to use three probes. As you can see the lower the number of 
 * probes the better.
 * 
 * 
 * Constant time: O(1)
 * Linear time: O(n)
 * Logarithmic time: O(n log n)
 * Quadratic time: O(n^2)
 * Exponential time: O(2^n)
 * Factorial time: O(n!)
 * 
 */

package hashTable.linearProbing.rehashing;

public class SimpleHashtableArray 
{
	// Array of StoredEmployee;
	private StoredEmployee[] hashtable;
	
	/**
	 * 				---- CONSTRUCTOR ----
	 * I will need a class constructor to set up the array.
	 * Pass as a parameter "hashtable" with a capacity of 10.
	 * 
	 * @param hashtable
	 */
	public SimpleHashtableArray()
	{
		hashtable = new StoredEmployee[ 10 ];
	}
	
	/**
	 * 				---- PUT_METHOD ----
	 * Method "put", employee's into the hashtable
	 * 
	 * @param key
	 * @param employee
	 * 
	 * 				---- LINEAR_PROBING ----
	 * 				---- COLLISION_HANDLING ----
	 * I will update my "put" method to use linear probing.
	 * 
	 */
	public void put( String key, Employee employee )
	{
		/*
		 * The "hashedKey", will give me the index in the 
		 * array. And then I'm going to have a really simple 
		 * hashtable.
		 */
		int hashedKey = hashKey( key );
		
		/*
		 * Check whether that position in the array is already 
		 * occupied. We would need to do some "linear probing"
		 * 
		 */
		if ( occupied( hashedKey ) )
		{
			int stopIndex = hashedKey;
			
			/*
			 * This is setting up the first probe. If the position 
			 * we just checked is the last slot in the array, I want 
			 * it to loop back to the front. 
			 * The next position I want to check is in position 
			 * zero (I want it to wrap back to the front of the array).
			 */
			if ( hashedKey == hashtable.length - 1 )
			{
				hashedKey = 0;
			}
			// If it's not the case, increment hashedKey
			else
			{
				hashedKey++;
			}
			
			while ( occupied( hashedKey ) && hashedKey != stopIndex )
			{
				/*
				 * This part of code (while loop) complements sets up
				 * the first part of code on top.
				 */
				hashedKey = ( hashedKey + 1 ) % hashtable.length;
			}
			
		}
		if ( occupied( hashedKey ) )
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
			/*
			 * Down here rather than just putting an employee 
			 * into the hashtable. I will need an istance of 
			 * the class StoredEmployee.  
			 */
			hashtable[ hashedKey ] = new StoredEmployee( key, employee );
			
		}
	}
	
	/**
	 * 				---- RETRIVE_METHOD ----
	 * @param key
	 * @return Retrieves an employee from the hashtable. Down 
	 * here rather than just putting an employee into the 
	 * hashtable. I will need an istance of the class 
	 * StoredEmployee. 
	 * 
	 * 				---- TIME_COMPLEXITY ----
	 * Retrieval runs in constant time O(1), direct access
	 */
	public Employee retreive( String key )
	{
		int hashedKey = findKey( key );
		
		if ( hashedKey == -1 )
		{
			return null;
		}
		
		return hashtable[ hashedKey ].employee;
	}
	
	/**
	 * 				---- REMOVE_METHOD ----
	 * 
	 * @param key
	 * @return
	 */
	public Employee remove( String key )
	{
		int hashedKey = findKey( key );
		
		/*
		 * If the table is empty. Return null (Do nothing). 
		 */
		if ( hashedKey == -1 )
		{
			return null;
		}
		
		Employee employee = hashtable[ hashedKey ].employee;
		
		hashtable[ hashedKey ] = null;
		
		// Store my current hashtable into a temporary variable
		StoredEmployee[] oldHashtable = hashtable;
		
		/*
		 * Create a brand new "StoredEmployee" array that's 
		 * going to be the same size as my oldHashtable[].
		 */
		hashtable = new StoredEmployee[ oldHashtable.length ];
		
		// Iterate through the entire length of the oldHashtable"
		for ( int i = 0; i < oldHashtable.length; i++ )
		{
			/*
			 * Hash all the values in the oldHashtable, and 
			 * assign them into the new hashtable
			 */
			if ( oldHashtable[ i ] != null )
			{
				put ( oldHashtable[ i ].key, oldHashtable[ i ].employee );
			}
		}
		
		return employee;
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
	
	/**
	 * 				---- FINDKEY_METHOD ----
	 * @param key
	 * @return
	 * I will use that method to find the employee I'm 
	 * looking for, with the given keys.
	 */
	private int findKey( String key ) 
	{
		// Hashing my hashKey parameter
		int hashedKey = hashKey( key );

		if ( hashtable[ hashedKey ] != null && 
				hashtable[ hashedKey ].key.equals( key ) ) 
		{
			return hashedKey;
		}

		
			int stopIndex = hashedKey;

			/*
			 * This is setting up the first probe. If the position 
			 * we just checked is the last slot in the array, I want 
			 * it to loop back to the front. The next position I want 
			 * to check is in position zero (I want it to wrap back to 
			 * the front of the array).
			 */
			if (hashedKey == hashtable.length - 1) 
			{
				hashedKey = 0;
			}
			// If it's not the case, increment hashedKey
			else 
			{
				hashedKey++;
			}

			while ( hashedKey != stopIndex && 
					hashtable[ hashedKey ] != null &&
					!hashtable[ hashedKey ].key.equals( key ) ) 
			{
				/*
				 * This part of code (while loop) complements sets up 
				 * the first part of code on top.
				 */
				hashedKey = ( hashedKey + 1 ) % hashtable.length;
			}
			
			/*
			 * If, hashtable[hashedKey] is Not equal to null, and
			 * the key in the hashtable[hashedKey], is equal to
			 * the key I'm looking for
			 */
			if ( hashtable[ hashedKey ] != null &&
					hashtable[ hashedKey ].key.equals( key ) )
			{
				return hashedKey;
			}
			else 
			{
				return -1;
			}
		}
	
	/**
	 * 				---- METHOD_OCCUPIED ----
	 * @param index
	 * @return 
	 * This method (occupied) checks whether a given position is 
	 * already occupied. I want to accept an index because it's 
	 * going to be checking whether specific position is already 
	 * occupied. And it's going to return hashtable[ index ] is 
	 * not equal to null.
	 * So if there is something already sitting on that table,
	 * then it's occupied. So if it's not equal to null, it 
	 * returns "true", if it is equal to null that means it's 
	 * empty, so it returns "false".
	 */
	private boolean occupied( int index )
	{
		return hashtable[ index ] != null;
	}
	
	// Print hashtable method
	public void printHashtable()
	{
		for ( int i = 0; i < hashtable.length; i++ )
		{
			
			if ( hashtable[ i ] == null )
			{
				System.out.println( "---- EMPTY_TABLE ----");
			}
			else
			{
				System.out.println( "Position " + i + ": " + hashtable[ i ].employee );
			}
			
		}
	}

}
