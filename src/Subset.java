public class Subset {
	public static void main(String[] args) {
		int K = StdIn.readInt();
		RandomizedQueue<String> list = new RandomizedQueue<String>();
		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			list.enqueue(s);
		}
		
		for(int i = 0; i < K; i++) {
			StdOut.printf("%S\n", list.dequeue());
		}
	}
}