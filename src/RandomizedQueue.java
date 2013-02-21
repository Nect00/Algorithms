import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
	private int size = 0;
	private int used = 0;
	
	//@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1];
	
	public RandomizedQueue() // construct an empty randomized queue
	{
	}

	public boolean isEmpty() // is the queue empty?
	{
		return used == 0;
	}

	public int size() // return the number of items on the queue
	{
		return this.size;
	}
	
	private void resize(int capacity) {
		//@SuppressWarnings("unchecked")
		Item[] b = (Item[]) new Object[capacity];
		int counter = 0;
		for(int i = 0; i < size; i++){
			if(a[i] != null) {
				b[counter] = a[i];
				counter++;
			}
		}
		a = b;
		size = counter;
	}
	
	public void enqueue(Item item) // add the item
	{
		if(item == null){
			throw new NullPointerException();
		} else {
			if(size == a.length){
				this.resize(2 * used);
			}
			a[size] = item;
			size++;
			used++;
		}
	}

	public Item dequeue() // delete and return a random item
	{
		if(used == 0) {
			throw new NoSuchElementException();
		}
		Item t = null;
		int index = 0;
		while(t == null) {
			index = StdRandom.uniform(this.size);
			t = a[index];
		}
		a[index] = null;
		used--;
		if(size == index){
			size--;
		}
		if(used <= a.length/4) {
			//if((a.length / 2) > 4)
				this.resize(a.length /2);
		}
		return t;
	}

	public Item sample() // return (but do not delete) a random item
	{
		Item ret = null;
		while(ret == null) {
			int index = StdRandom.uniform(this.size);
			ret = a[index++];
		}
		return ret;
	}

	public Iterator<Item> iterator() // return an independent iterator over
										// items in random order
	{
		return new RandomizedQueueIter();
	}
	
	private class RandomizedQueueIter implements Iterator<Item>
	{
		private int index = 0;
		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public Item next() {
//			if(index < size) {
//				throw new NoSuchElementException();
//			}
//			Item tmp = a[index];
//			while(tmp == null) {
//				index++;
//				tmp = a[index];
//			} 
//			return tmp;
			return sample();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}