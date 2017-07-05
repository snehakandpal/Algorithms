import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
	private int gridSize;	// dimension of NxN grid
	private int[][] site;
	private int virtualTop;	
	private int virtualBottom;
	private int openSites;	// number of open sites in grid
	private int open = 1;	// value determining whether site is open  
	private WeightedQuickUnionUF uf;
	// create a NxN grid with all sites blocked	
	public Percolation(int n) {
		gridSize = n;
		site = new int[gridSize][gridSize];
		virtualTop = gridSize * gridSize;
		virtualBottom = gridSize * gridSize + 1;
		// to include the virtual top and bottom sites
		uf = new WeightedQuickUnionUF((gridSize * gridSize) + 2);	
	}
	// opens a site if not already opened
	public void open(int row, int col) {
		checkBounds(row, col);
		if(!isOpen(row, col)) {
			site[row - 1][col - 1] = open;
			openSites++;
			siteUnion(row, col);
		}
	}
	// checks if a site is open 
	public boolean isOpen(int row, int col) {
		checkBounds(row, col);
		return site[row - 1][col - 1] == open;
	}
	// checks if a site is full
	public boolean isFull(int row, int col) {
		checkBounds(row, col);
		if(!(isOpen(row, col)))
			return false;
		else if(uf.connected(virtualTop, convertTo1D(row, col)))
			return true;
		return false;
	}
	// returns number of open sites in the grid
	public int numberOfOpenSites() {
		return openSites;
	}
	// checks if the system percolates
	public boolean percolates() {
		return uf.connected(virtualTop, virtualBottom);
	}
	// checks whether the input is in bound of 1 to N
	private void checkBounds(int i, int j) {
		if(i < 1 || i > gridSize || j < 1 || j > gridSize) {
			throw new IllegalArgumentException("Value should be between 1 and " + gridSize + ".");
		}
	}
	// converts the 2D site[][] to 1D array 
	private int convertTo1D(int row, int col) {
		return (gridSize * (row - 1) + (col - 1));
	}
	// performs union of adjacent open sites
	private void siteUnion(int row, int col) {
		int site = convertTo1D(row, col);
		// connect with virtual top site 
		if(row == 1)
			uf.union(virtualTop, site);
		// connect with virtual bottom site
		if(row == gridSize) 
			uf.union(virtualBottom, site);
		// connect left site
		if(col > 1) {
			if((isOpen(row, col - 1))) 
				uf.union(site, convertTo1D(row, col - 1));
		}
		// connect top site
		if(row > 1) {
			if((isOpen(row - 1, col)))
				uf.union(site, convertTo1D(row - 1, col));
		}
		// connect right site
		if(col < gridSize) {
			if((isOpen(row, col + 1)))
				uf.union(site, convertTo1D(row, col + 1));
		}
		// connect bottom site
		if(row < gridSize) {
			if((isOpen(row + 1, col)))
				uf.union(site, convertTo1D(row + 1, col));
		}
	}
}
