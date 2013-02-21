import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class RandomizedTest {
	@Test
	public void enque() {
		RandomizedQueue<String> list = new RandomizedQueue<>();
		
		list.enqueue("1");
		list.enqueue("2");
		list.enqueue("3");
		list.enqueue("4");
		list.enqueue("5");
		list.enqueue("6");
		
		assertEquals(6, list.size());	
	}
	
	@Test (expected=NoSuchElementException.class)
	public void dequeException() {
		RandomizedQueue<String> list = new RandomizedQueue<>();
		list.dequeue();
	}
	
	@Test (expected=NoSuchElementException.class)
	public void sampleException() {
		RandomizedQueue<String> list = new RandomizedQueue<>();
		list.sample();
	}
	
	@Test
	public void enqueDeque() {
		RandomizedQueue<String> list = new RandomizedQueue<>();
		list.enqueue("item");
		list.enqueue("item");
		list.dequeue();
		list.enqueue("item");
		list.enqueue("item");
		list.dequeue();
		list.enqueue("item");
		list.dequeue();
		list.dequeue();
		list.dequeue();
		list.enqueue("item");
		list.enqueue("item");
		list.dequeue();
		list.dequeue();
		list.enqueue("item");
		list.dequeue();
		list.enqueue("item");
		list.enqueue("item");
		list.dequeue();
		list.enqueue("item");
		list.dequeue();
		list.enqueue("item");
		list.dequeue();
		list.enqueue("item");
		list.enqueue("item");
		list.dequeue();
		list.dequeue();
		list.enqueue("item");
		list.dequeue();
		list.enqueue("item");
	}
	
	@Test
	public void iterator() {
		RandomizedQueue<String> list = new RandomizedQueue<>();
		list.enqueue("item1");
		list.enqueue("item2");
		list.enqueue("item3");
		list.enqueue("item4");
		list.enqueue("item5");
		int counter = 0;
		for(String s : list) {
			counter++;
		}
		assertEquals(list.size(), counter);
	}
}