public class ex1_3_29<T> {
	private int N;			// size of linked list
	private Node last;		// end node of circular linked list such that
							// last.next is first when the list is not empty

	// helper linked list class
	private class Node {
		private T item;
		private Node next;
	}

	public ex1_3_29() {
		int N = 0;
		last = null;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return last = null;
	}

	public void enqueue(T item) {

	}

	public T dequeue() {

	}

	public static void main(String[] args) {
		
	}
}