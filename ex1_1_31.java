public class ex1_1_31 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);  //number of dots
		double p = Double.parseDouble(args[1]);  //probability of connecting line
		int RADIUS = 400;  //pixels
		int WIDTH = 500;
		int HEIGHT = 500;
		StdDraw.setXscale(-WIDTH, WIDTH);
		StdDraw.setYscale(-HEIGHT, HEIGHT);
		
		for (int i = 0; i < N; i++) {
			double angle = (double) i / N * 2 * Math.PI;
			double x = RADIUS * Math.cos(angle);
			double y = RADIUS * Math.sin(angle);
			System.out.println(x + " " + y);
			StdDraw.setPenRadius(0.01);
			StdDraw.point(x, y);
			for (int j = i + 1; j < N; j++) {
				if (StdRandom.bernoulli(p)) {
					double angle1 = (double) j / N * 2 * Math.PI;
					double x1 = RADIUS * Math.cos(angle1);
					double y1 = RADIUS * Math.sin(angle1);
					StdDraw.setPenRadius(0.001);
					StdDraw.line(x, y, x1, y1);
				}
			}
		}
	}
}