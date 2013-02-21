import static org.junit.Assert.*;

import org.junit.Test;

public class RandomiszedTest {
	@Test
	public void test() {
		RandomizedQueue<String> list = new RandomizedQueue<>();
		list.enqueue("1");
		list.enqueue("2");
		list.enqueue("3");
		list.enqueue("4");
		list.enqueue("5");
		list.enqueue("6");
		
		assertEquals(6, list.size());	
	}
}
