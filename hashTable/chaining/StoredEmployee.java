
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

public class StoredEmployee 
{
	public String key;
	public Employee employee;
	
	
	public StoredEmployee( String key, Employee employee )
	{
		this.key = key;
		this.employee = employee;
	}

}
