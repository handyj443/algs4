public class PercolationStats {
   private double[] threshold;   // array of experiment results
   private final int N;          // size of grid
   private final int T;          // number of experiments

   // perform T independent experiments on an N-by-N grid
   public PercolationStats(int N, int T) throws IllegalArgumentException { 
      if (N < 1 || T < 1) {
         throw new IllegalArgumentException();
      }
      this.N = N;
      this.T = T;
      threshold = new double[T];
      for (int i = 0; i < T; i++) {
         int openSites = 0;
         Percolation perc = new Percolation(N);
         while (!perc.percolates()) {
            int row = StdRandom.uniform(1, N+1);
            int col = StdRandom.uniform(1, N+1);
            if (!perc.isOpen(row, col)) {
               perc.open(row, col);
               openSites++;
            }
         }
         threshold[i] = (double) openSites / (N*N);
      }     
   }

   // sample mean of percolation threshold
   public double mean() {
      return StdStats.mean(threshold);
   }                  

   // sample standard deviation of percolation threshold   
   public double stddev() {
      return StdStats.stddev(threshold);
   }            
   // low  endpoint of 95% confidence interval      
   public double confidenceLo() {
      return mean() - (1.96 * stddev() / Math.sqrt(T));
   }            
   // high endpoint of 95% confidence interval
   public double confidenceHi() {
      return mean() + (1.96 * stddev() / Math.sqrt(T));
   }            

   // test client (described below)
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      int T = Integer.parseInt(args[1]);
      PercolationStats percStat = new PercolationStats(N, T);
      // StdOut.printf("mean                    = %d\n", percStat.mean());
      // StdOut.printf("stddev                  = %d\n", percStat.stddev());
      // StdOut.printf("95% confidence internal = %d, %d", percStat.stddev());
      StdOut.print("mean                    = ");
      StdOut.print(percStat.mean() + "\n");
      StdOut.print("stddev                  = ");
      StdOut.print(percStat.stddev() + "\n");
      StdOut.print("95% confidence internal = ");
      StdOut.print(percStat.confidenceLo() + ", " + percStat.confidenceHi());
   }  
}