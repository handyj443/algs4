public class Percolation {
    private int openSites;
    private final int latticeLength;
    private boolean[][] lattice;
    private WeightedQuickUnionUF connections;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) throws IllegalArgumentException {
        if (N <= 0) {
            throw new IllegalArgumentException();
        } else {
            openSites = 0;
            latticeLength = N;
            lattice = new boolean[N+1][N+1];
            //clear boolean array
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    lattice[i][j] = false;
                }
            }
            connections = new WeightedQuickUnionUF(N*N + 2);
        }
    }

    // open site (row i, column j) if it is not open already
    // i and j are integers between 1 and latticeLength
    public void open(int i, int j) throws IndexOutOfBoundsException {
        if (!validIndices(i, j)) {
            throw new IndexOutOfBoundsException();
        }
        if (!lattice[i][j]) {
            lattice[i][j] = true;
            openSites++;
            // connect to neighbouring sites
            if (j > 1 && lattice[i][j-1]) {
                connections.union(indexOf(i, j), indexOf(i, j-1));
            }
            if (j < latticeLength && lattice[i][j+1]) {
                connections.union(indexOf(i, j), indexOf(i, j+1));
            }
            if (i > 1 && lattice[i-1][j]) {
                connections.union(indexOf(i, j), indexOf(i-1, j));
            }
            if (i < latticeLength && lattice[i+1][j]) {
                connections.union(indexOf(i, j), indexOf(i+1, j));
            }
            // connect top/bottom row to virtual top/bottom site
            // set virtual top site to connections index N*N
            // and virtual bottom site to connections index N*N + 1
            if (i == 1) {
                connections.union(latticeLength*latticeLength, indexOf(i, j));
            }
            if (i == latticeLength) {
                connections.union(latticeLength*latticeLength + 1, indexOf(i, j));
            }
        }
    }

    // check whether i and j are [1, latticeLength]
    private boolean validIndices(int i, int j) {
        return (i >= 1 && i <= latticeLength && j >= 1 && j <= latticeLength);
    }

    private int indexOf(int i, int j) throws IndexOutOfBoundsException {
        if (validIndices(i, j)) {
            return (i - 1)*latticeLength + j - 1;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isOpen(int i, int j) throws IndexOutOfBoundsException {
        if (validIndices(i, j)) {
            return lattice[i][j];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
        if (validIndices(i, j)) {
            return connections.connected(latticeLength*latticeLength, indexOf(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean percolates() {
        return connections.connected(latticeLength*latticeLength,
                latticeLength*latticeLength + 1);
    }

    public static void main(String[] args) {
        Percolation testPerc = new Percolation(4);
        testPerc.open(1, 1);
        testPerc.open(1, 2);
        testPerc.open(2, 2);
        testPerc.open(3, 2);

        StdOut.println(testPerc.connections.connected(0, 9));
    }
}

