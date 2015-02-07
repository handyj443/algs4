import java.util.Iterator;

public class ch1_3_StackTest {
	public static void main(String[] args) {
		ResizingArrayStack<Integer> testStack = new ResizingArrayStack<Integer>();
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		testStack.push(4);
		testStack.push(5);
		Iterator<Integer> testStackIter = testStack.iterator();
		int el = testStackIter.next();
		StdOut.println(el);

		testStack.push(6);
		el = testStackIter.next();
		StdOut.println(el);

		for (int elem : testStack) {
			StdOut.println(elem);
		}
	}
}