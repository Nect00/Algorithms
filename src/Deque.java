import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first = null;
	private Node last = null;
	private int size = 0;
	
	private class Node
	{
		Item current = null;
		Node next = null;
		Node previous = null;
	}
	
	public Deque() // construct an empty deque
	{
	}

	public boolean isEmpty() // is the deque empty?
	{
		return size == 0;
	}

	public int size() // return the number of items on the deque
	{
		return this.size;
	}

	public void addFirst(Item item) // insert the item at the front
	{
		if (item == null) {
			throw new NullPointerException();
		} else {
			size++;
			Node tmp = this.first;
			this.first = new Node();
			first.current = item;
			if(tmp != null) {
				first.next = tmp;
				first.next.previous = first;
			} else {
				this.last = this.first;
			}
		}
	}

	public void addLast(Item item) // insert the item at the end
	{
		if (item == null) {
			throw new NullPointerException();
		} else {
			if(this.isEmpty()) {
				this.last = new Node();
				this.first = this.last;
				this.first.current = item;		
			} else {
				this.last.next = new Node();
				this.last.next.current = item;
				this.last.next.previous = this.last;
				this.last = this.last.next;
			}
			size++;
		}
	}

	public Item removeFirst() // delete and return the item at the front
	{	
		if(!isEmpty()) {
			size--;
			Item tmp = this.first.current;
			if(size == 0) {
				this.first = this.last = null;
			} else {
				this.first = this.first.next;
				this.first.previous=null;
			}
			return tmp;
		}
		else {
			throw new NoSuchElementException();
		}
	}

	public Item removeLast() // delete and return the item at the end
	{
		if(!isEmpty()) {
			size--;
			Item tmp = this.last.current;
			if(size == 0) {
				this.first = this.last = null;
			} else {
				this.last.previous.next = null;
				this.last = this.last.previous;
			}
			return tmp;
		}
		else {
			throw new NoSuchElementException();
		}
	}

	public Iterator<Item> iterator() // return an iterator over items in order
										// from front to end
	{
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item>
	{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(current == null) {
				throw new NoSuchElementException();
			}
			Item i = current.current;
			current = current.next; 
			return i;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}