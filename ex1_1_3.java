public class ex1_1_3 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			StdOut.println(args[i]);
		}
		//if ((args[0] == args[1]) && (args[1] == args[2])) {
		if (args[0].equals(args[1]) && args[1].equals(args[2])) {
			StdOut.println("equal");
		}
		else {
			StdOut.println("not equal");
		}
	}
}