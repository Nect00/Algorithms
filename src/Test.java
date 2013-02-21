public class Test {
	public static void main(String[] args) {
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
		StdOut.printf("Counter=%i\n", counter);
	}
} 