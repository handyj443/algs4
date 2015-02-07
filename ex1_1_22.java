/*************************************************************************
 *  Compilation:  javac ex1_1_22.java
 *  Execution:    java ex1_1_22 whitelist.txt < input.txt
 *  Dependencies: In.java StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/11model/tinyW.txt
 *                http://algs4.cs.princeton.edu/11model/tinyT.txt
 *                http://algs4.cs.princeton.edu/11model/largeW.txt
 *                http://algs4.cs.princeton.edu/11model/largeT.txt
 *
 *  % java ex1_1_22 tinyW.txt < tinyT.txt
 *  50
 *  99
 *  13
 *
 *  % java ex1_1_22 largeW.txt < largeT.txt | more
 *  499569
 *  984875
 *  295754
 *  207807
 *  140925
 *  161828
 *  [367,966 total values]
 *  
 *************************************************************************/

import java.util.Arrays;

/**
 *  The <tt>ex1_1_22</tt> class provides a static method for binary
 *  searching for an integer in a sorted array of integers.
 *  <p>
 *  The <em>rank</em> operations takes logarithmic time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class ex1_1_22 {

    /**
     * This class should not be instantiated.
     */
    private ex1_1_22() { }

    /**
     * Searches for the integer key in the sorted array a[].
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }
    public static int rank(int key, int[] a, int lo, int hi, int rdepth) {
        for (int i = 0; i < rdepth; i++) {
            StdOut.print("\t");
        }
        StdOut.printf("%2d %2d\n", lo, hi);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo)/2;
        if      (key < a[mid]) return rank(key, a, lo, mid - 1, rdepth + 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, rdepth + 1);
        else                   return mid;
    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument. Reads in integers from standard input and
     * prints to standard output those integers that do *not* appear in the file.
     */
    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}
