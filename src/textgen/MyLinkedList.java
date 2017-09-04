package textgen;

import org.reactfx.util.LL;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element == null){
			throw new NullPointerException("Null elements are not allowed");
		}
		LLNode<E> newElement = new LLNode<E>(element);
		newElement.prev = tail.prev;
		newElement.next = tail;
		tail.prev.next = newElement;
		tail.prev = newElement;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Index must be a positive integer");
		}
		LLNode current = head.next;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		return (E)current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("Index must be a positive integer");
		}
		LLNode<E> newElement = new LLNode<E>(element);
		LLNode current = head.next;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		newElement.prev = current.prev;
		newElement.next = current;
		current.prev.next = newElement;
		current.prev = newElement;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("Index must be a positive integer");
		}
		LLNode current = head.next;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		current.next.prev = current.prev;
		current.prev.next = current.next;
		size--;
		return (E)current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("Index must be a positive integer");
		}
		LLNode current = head.next;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		current.data = element;
		return (E)current.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
