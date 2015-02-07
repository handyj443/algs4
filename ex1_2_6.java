public class ex1_2_6 {
	public static boolean isCircular(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			if (b.equals(a.substring(i, a.length()) + a.substring(0, i))) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		String a = args[0];
		String b = args[1];
		if (isCircular(a, b)) {
			StdOut.println("True");
		} else {
			StdOut.println("False");
		}
	}
}

