import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int N;      // number of items
    private Item[] q;   // queue elements

    // construct an empty randomized queue
    public RandomizedQueue() {
        N = 0;
        q = (Item[]) new Object[2];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return (N == 0);
    }                

    // return the number of items on the queue
    public int size() {
        return N;
    }

    // resize the underlying array
    private void resize(int newSize) {
        assert newSize >= N;
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            temp[i] = q[i];
        }
        q = temp;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        // double size of array if necessary
        if (N == q.length) {
            resize(2*q.length);   
        }
        N++;
    }

    // delete and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int p = StdRandom.uniform(N);
        //Swap q[p] with the last item in the array
        Item temp = q[p];
        q[p] = q[N-1];
        q[N-1] = null;   // to avoid loitering
        N--;
        // halve size of array if necessary
        if (N > 0 && N == q.length/4) {
            resize(q.length/2);
        }
        return temp;
    }   

    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int p = StdRandom.uniform(N);
        return q[p];
    }

    public Iterator<Item> iterator() {

    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() { 
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            
        }
    }

    public static void main(String[] args) {
        RandomizedQueue tq = new RandomizedQueue();
    }
}