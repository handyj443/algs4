public class ex1_3_9 {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("(")); // do nothing
			else if (s.equals("+") || s.equals("-") ||
				     s.equals("*") || s.equals("/")) {
				ops.push(s);
			}
			else if (s.equals(")")) {
				String op = ops.pop();
				String v = vals.pop();
				if (op.equals("+") || op.equals("-") ||
					op.equals("*") || op.equals("/")) {
					v = "( " + op + " " + vals.pop() + " " + v + " )";
				}
				vals.push(v);
			}
			else vals.push(s);
		}
		StdOut.println(vals.pop());
	}
}