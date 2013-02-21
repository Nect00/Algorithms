import static org.junit.Assert.*;
import org.junit.Test;

public class DequeTest {
	@Test
	public void addFirstTest() {
		Deque<String> list = new Deque<String>();
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.addFirst("4");
		list.addFirst("5");
		
		assertEquals(5, list.size());
		assertEquals("1", list.removeLast());
		assertEquals("2", list.removeLast());
		assertEquals("5", list.removeFirst());
		assertEquals("4", list.removeFirst());
	}
	
	@Test
	public void addLastTest() {	
		Deque<String> list2 = new Deque<String>();
		list2.addLast("1");
		list2.addLast("2");
		list2.addLast("3");
		list2.addLast("4");
		list2.addLast("5");
		int counter = 1;
		for(String s : list2){
			assertEquals(String.valueOf(counter), s);
			counter++;
		}
	}
	
}