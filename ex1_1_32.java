public class ex1_1_32 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);
		int[] hist = new int[N];
		double binSize = (r - l)/N;
		//read input data and populate histogram
		while (!StdIn.isEmpty()) {
			double datum = StdIn.readDouble();
				for (int bin = 0; bin < N; bin++) {
					if ((datum < l + (bin+1)*binSize) && (datum >= l + bin*binSize)) {
						hist[bin]++;
				}
			}
		}
		for (int bin = 0; bin < N; bin++) {
			System.out.printf("%4.2f ", l + bin);
		}
		System.out.println();
		printArrayOfInts(hist);
	}

	public static void printArrayOfInts(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%4d ", a[i]);
		}
		System.out.println();
	}
}