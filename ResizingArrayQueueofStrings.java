import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueueofStrings implements Iterable {
	private String[] a;		// array of strings
	private int N;			// number of elements in queue probably not needed
	private int front;		// points to the item at the front of queue

	public ResizingArrayQueueofStrings() {
		a = new String[2];
		front = 0;
		N = 0;
	}

	public boolean isEmpty() {
		return (N == 0);
	}

	public int size() {
		return N;
	}

	private void resize(int newSize) {
		assert newSize >= N;
		String[] new_a = new String[newSize];
		for (int i = 0; i < N; i++) {
		 	new_a[i] = a[(i + front) % a.length];
		}
		a = new_a;
		front = 0;
		StdOut.println("old size: " + N + ", new size: " + a.length);
	}

	private int incPointer(int p) {
		return (p + 1) % a.length;
	}

	public void enqueue(String s) {
		// if array a is full, double its size
		if (N == a.length) {
			resize(a.length * 2);
		}
		int end = (front + N) % a.length;
		a[end] = s;
		N++;
	}

	public String dequeue() {
		String result = a[front];
		a[front] = null;	// to avoid loitering
		front = incPointer(front);
		N--;
		// cut array a size in half if quarter full
		if (N == a.length / 4) {
			resize(a.length / 2);
		}
		return result;
	}

	public Iterator iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator {
		private int i = 0;
		public boolean hasNext() {
			return i < N;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
		public String next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			String s = a[(i + front) % a.length];
			i++;
			return s;
		}
	}

		/**
     * Unit tests the <tt>ResizingArrayQueue</tt> data type.
     */
    public static void main(String[] args) {
        ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
        for (String s : q) {
        	StdOut.println(s);
        }
    }
}