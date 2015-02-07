public class ex1_1_15 {
	public static int[] histogram(int[] a, int M) {
		int[] res = new int[M];
		for (int i = 0; i < a.length; i++) {
			res[a[i]]++;
		}
		return res;
	}

	public static void printArrayOfInts(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%2d ", a[i]);
		}
		System.out.println();
	}

	public static int sumArrayOfInts(int[] a) {
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			res += a[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = {0, 1, 2, 3, 4, 5, 4, 3, 2, 4, 3, 3, 2, 5, 2, 1};
		int M = 6;
		int[] hist = histogram(a, M);
		printArrayOfInts(a);
		printArrayOfInts(hist);
		System.out.println(a.length + " = " + sumArrayOfInts(hist));
	}
}