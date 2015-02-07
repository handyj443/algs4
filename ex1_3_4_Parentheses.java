public class ex1_3_4_Parentheses {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<Character>();

		while (!StdIn.isEmpty()) {
			char next = StdIn.readChar();
			if (next == '[' || next == '(' || next == '{') {
				stack.push(next);
			} else if ( next == ')' && (stack.isEmpty() || stack.pop() != '(')) { 
				StdOut.println("false");
				return;
			} else if (next == ']' && (stack.isEmpty() || stack.pop() != '[')) {
				StdOut.println("false");
				return;
			} else if (next == '}' && (stack.isEmpty() || stack.pop() != '{')) {
				StdOut.println("false");
				return;
			}
		}
		if (stack.isEmpty()) StdOut.println("true");
	}
}