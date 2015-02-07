public class ex1_1_14 {
	public static int lg(int n) {
		int res = 0;
		while (n != 1) {
			n = n/2;
			res++;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(lg(8) + " for 8");
		System.out.println(lg(7) + " for 7");
		System.out.println(lg(128) + " for 128");
		System.out.println(lg(125) + " for 125");
	}
}