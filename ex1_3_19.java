public class ex1_3_19 {
	private int N;			// size of linked list
	private Node first;		// beginning of linked list

	// helper linked list class
	private class Node {
		private int value;
		private Node next;
	}

	public ex1_3_19() {
		int N = 0;
		first = null;
		assert check();
	}

	public int size() {
		return N;
	}

	public void push(int a) {
		Node newFirst = new Node();
		newFirst.value = a;
		newFirst.next = first;
		first = newFirst;
		N++;
		assert check();
	}

	public void removeLast() {
		if (N == 1) {
			first = null;
			N = 0;
		} else if (N > 1) {
			Node n = first;
			while (n.next.next != null) {
				n = n.next;
			}
			// n should now be pointing at the second from last node
			n.next = null;	// remove the last node
			N--;
		}
	}

	// deletes the kth item in the list, if it exists
	// (the list starts with item 1)
	public void delete(int k) {
		if (k > N || k <= 0) {
			throw new IllegalArgumentException();
		}
		if (N == 1) {
			first = null;
			N = 0;
		} else if (k == 1) {
			first = first.next;
			N--;
		} else {
			// set i to the node before the one to be deleted
			Node i = first;
			while (k > 2) {
				i = i.next;
				k--;
			}
			i.next = i.next.next;
			N--;
		}
	}

	public void print() {
		for (Node n = first; n != null; n = n.next) {
			StdOut.println(n.value);
		}
		StdOut.println("List contains " + N + " item(s).");
	}

	// check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
        }
        else if (N == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable N
        int numberOfNodes = 0;
        for (Node x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != N) return false;

        return true;
    }

	public static void main(String[] args) {
		ex1_3_19 list = new ex1_3_19();
		//	add a few items to the list
		list.push(1);
		list.push(2);
		list.push(3);
		list.print();
		list.delete(3);
		list.print();
		list.delete(2);
		list.print();
		list.delete(1);
		list.print();
	}
}