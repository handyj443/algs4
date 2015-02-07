public class ex1_2_15 {

	public static void main(String[] args) {
		printArrayOfInts(readAllInts(StdIn.readAll()));
	}

	public static int[] readAllInts(String inString) {
		String[] intsAsStrings = inString.split("\\s+");
		int[] ints = new int[intsAsStrings.length];
		for (int i = 0; i < intsAsStrings.length; i++) {
			ints[i] = Integer.parseInt(intsAsStrings[i]);
		}
		return ints;
	}

	public static void printArrayOfInts(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}
}