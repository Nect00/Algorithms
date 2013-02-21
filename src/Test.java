import static org.junit.Assert.assertEquals;

public class Test {
	public static void main(String[] args) {
		Deque<String> list2 = new Deque<String>();
		list2.addLast("5");
		list2.addLast("4");
		list2.addLast("3");
		list2.addLast("2");
		list2.addLast("1");
		int counter = 1;
		for (String s : list2) {
			assertEquals(String.valueOf(counter), s);
			counter++;
		}
	}
}
