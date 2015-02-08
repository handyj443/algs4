import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int N;        // number of items
    private Node<Item> front;   // front sentinel node
    private Node<Item> end;    // end sentinel node

    // doubly linked list
    private static class Node<Item> {
        private Item item;
        private Node<Item> prev;
        private Node<Item> next;
    }

    // construct an empty deque
    public Deque() {
        N = 0;
        front = new Node<Item>();
        end = new Node<Item>();
        front.item = null;
        front.prev = null;
        front.next = end;
        end.item = null;
        end.prev = front;
        end.next = null;
    }                      

    // is the deque empty?
    public boolean isEmpty() {
        return (N == 0);
    }                

    // return the number of items on the deque
    public int size() {
        return N;
    }                       

    // insert the item at the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        newNode.prev = front;
        newNode.next = front.next;
        front.next.prev = newNode;
        front.next = newNode;
        N++;
    }         

    // insert the item at the end
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        newNode.next = end;
        newNode.prev = end.prev;
        end.prev.next = newNode;
        end.prev = newNode;
        N++;
    }          

    // delete and return the item at the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item returnItem = front.next.item;
        front.next.next.prev = front;
        front.next = front.next.next;
        N--;
        return returnItem;
    }               

    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item returnItem = end.prev.item;
        end.prev.prev.next = end;
        end.prev = end.prev.prev;
        N--;
        return returnItem;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(front.next);
    }   

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current.item != null; 
        }
        public void remove() { 
            throw new UnsupportedOperationException();  
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> tq = new Deque<Integer>();
        tq.addFirst(1);
        tq.addFirst(2);
        tq.addFirst(3);
        StdOut.println(tq.removeLast());
        StdOut.println(tq.removeLast());
        StdOut.println(tq.removeLast());
        tq.addLast(1);
        tq.addLast(2);
        tq.addLast(3);
        StdOut.println(tq.removeLast());
        StdOut.println(tq.removeLast());
        StdOut.println(tq.removeLast());
        tq.addLast(1);
        tq.addLast(2);
        tq.addLast(3);
        StdOut.println(tq.removeFirst());
        StdOut.println(tq.removeLast());
        StdOut.println(tq.removeFirst());
        tq.addLast(1);
        tq.addLast(2);
        tq.addLast(3);
        for (int a : tq) {
            for (int b : tq) {
                StdOut.println(b);
            }
            StdOut.println(a);
        }
    }
}

