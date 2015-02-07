public class ex1_3_15 {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		Queue<String> q = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			q.enqueue(s);
		}
		String s = new String();
		int i = q.size() + 1 - k;
		while (i > 0) {
			s = q.dequeue();
			StdOut.println("k: " + k + ", dequeued: " + s);
			i--;
		}
		StdOut.println(s);
	}
}