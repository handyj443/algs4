public class ex1_3_29<T> {
	private int N;			// size of linked list
	// end node of circular linked list such that no links are null and 
	// last.next is first when the list is not empty
	private Node last;		

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
		return (last == null);
	}

	public void enqueue(T item) {
		if (!isEmpty()) {
			Node newLast = new Node();
			newLast.item = item;
			newLast.next = last.next;
			last.next = newLast;
			last = newLast;
		} else {
			last = new Node();
			last.item = item;
			last.next = last;
		}
		N++;
	}

	public T dequeue() {
		T returnItem = last.next.item;
		if (size() == 1) {
			last = null;
		} else {
			last.next = last.next.next;
		}
		N--;
		return returnItem;
	}


	public static void main(String[] args) {
		ex1_3_29<Integer> testq = new ex1_3_29<Integer>();
		testq.enqueue(1);
		testq.enqueue(2);
		testq.enqueue(3);
		StdOut.println(testq.dequeue());
		StdOut.println(testq.dequeue());
		StdOut.println(testq.dequeue());
		testq.enqueue(3);
		testq.enqueue(2);
		testq.enqueue(1);
		StdOut.println(testq.dequeue());
		StdOut.println(testq.dequeue());
		StdOut.println(testq.dequeue());
	}
}