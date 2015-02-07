public class ex1_1_19 {
	static int MAX = 100;
	static long[] fibs = new long[MAX];
	public static long F(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		if (fibs[N] != 0) return fibs[N];
		fibs[N] = F(N-1) + F(N-2);
		return fibs [N];
	}
	public static void main(String[] args) {
		for (int N = 0; N < 90; N++) {
			StdOut.println(N + " " + F(N));
		}
	}
}