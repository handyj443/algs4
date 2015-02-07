public class ex1_2_1 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Point2D[] points = new Point2D[N];
		StdDraw.setPenRadius(.01);
		for (int i = 0; i < N; i++) {
			double x = StdRandom.random();
			double y = StdRandom.random();
			points[i] = new Point2D(x, y);
			points[i].draw();
		}
		double shortestDistance = Double.MAX_VALUE;
		int shortesti = 0;
		int shortestj = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				double distance = points[i].distanceTo(points[j]);
				if (distance < shortestDistance) {
					shortestDistance = distance;
					shortesti = i;
					shortestj = j;
				}
			}
		}
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(points[shortesti].x(), points[shortesti].y(), 
			         points[shortestj].x(), points[shortestj].y());
	}
}