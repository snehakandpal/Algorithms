import edu.princeton.cs.algs4.*;
public class PercolationStats {
	private int n;
	private int trials;
	private double[] percolationThreshold;
	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials) {
		if(n <= 0 || trials <= 0)
			throw new IllegalArgumentException("Invalid input.");
		this.n = n;
		this.trials = trials;
		percolationThreshold = new double[trials];
		for(int i = 0; i < trials; i++) {
			Percolation grid = new Percolation(n);
			int count = 0;	//to keep count of open sites 
			while(!(grid.percolates())) {
				openRandomSites(grid);
				count++;
			}
			percolationThreshold[i] = (double)count / (double)(n * n);
		}
	}    
	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(percolationThreshold);
	}
	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(percolationThreshold);
	}
	// low  endpoint of 95% confidence interval
	public double confidenceLo() {
		return (mean() - (1.96 * stddev() / (Math.sqrt(trials))));
	}
	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		return (mean() + (1.96 * stddev() / (Math.sqrt(trials))));
	}
	//to open random sites
	private void openRandomSites(Percolation grid) {
		int row = 0;
		int col = 0;
		boolean siteOpen = true;
		while(siteOpen) {
			row = StdRandom.uniform(1, n + 1);
			col = StdRandom.uniform(1, n + 1);
			siteOpen = grid.isOpen(row, col);
		}
		grid.open(row, col);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(n, t);
		StdOut.println("Mean = " +  ps.mean());
		StdOut.println("Standard Deviation = " +  ps.stddev());
		StdOut.println("95%% confidence interval = " +  ps.confidenceLo() + ", " + ps.confidenceHi());
	}
}
