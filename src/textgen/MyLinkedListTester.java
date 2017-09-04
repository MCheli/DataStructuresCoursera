/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> list2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		list2 = new MyLinkedList<Integer>();

		list2.add(0, 1);
		list2.add(0,2);
		list2.add(2,3);
		list2.add(1,4);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		try{
			list1.remove(25);
			fail("Too high of an index");
		}catch (IndexOutOfBoundsException e){

		}
		try{
			list1.remove(-1);
			fail("Too low of an index");
		}catch (IndexOutOfBoundsException e){

		}

	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		try{
			list1.add(null);
			fail("Can't add a null element");
		}catch (NullPointerException e){

		}
		assertEquals("Add: check last element is correct", (Integer)42, list1.get(2));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("Size: Check correct size of list1",3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		assertEquals("Add at Index: Check correct size of list2", 4, list2.size());
		assertEquals("Add at Index: Check correct value at position 0",(Integer)2, list2.get(0));
		assertEquals("Add at Index: Check correct value at position 1",(Integer)4, list2.get(1));
		assertEquals("Add at Index: Check correct value at position 2",(Integer)1, list2.get(2));
		assertEquals("Add at Index: Check correct value at position 3",(Integer)3, list2.get(3));
		try{
			list2.add(20, 5);
			fail("Out of bounds index");
		} catch (IndexOutOfBoundsException e){

		}
		try{
			list2.add(-1, 5);
			fail("Out of bounds index");
		} catch (IndexOutOfBoundsException e){

		}

		try{
			list1.add(0,null);
			fail("Can't add a null element");
		}catch (NullPointerException e){

		}

	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		list2.set(0, 3);
		list2.set(3, 5);

		try{
			list2.set(20, 5);
			fail("Out of bounds index");
		} catch (IndexOutOfBoundsException e){

		}
		assertEquals("Set at Index: Check correct value at position 0",(Integer)3,list2.get(0));
		assertEquals("Set at Index: Check correct value at position 3",(Integer)5,list2.get(3));

	}

}
