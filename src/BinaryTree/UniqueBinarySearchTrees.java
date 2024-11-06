package BinaryTree;

import java.math.BigInteger;

/**
 * Leetcode#96
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
       System.out.println(new UniqueBinarySearchTrees().numTrees(18));
    }
    public int numTrees1(int n) {
        return numTreesUtil(1,n);
    }

    public int numTreesUtil(int start, int end){
        if(start>end) return 1;
        int count =0;
        for(int i= start; i<=end;i++){
            int left = numTreesUtil(start,i-1);
            int right = numTreesUtil(i+1,end);
            count+=left*right;
        }
        return count;
    }

    /**
     * (2n!)/((n+1)!(n)!)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        BigInteger n1 = factorial(BigInteger.valueOf(2 * n));
        System.out.println(n1); // For debugging purposes
        BigInteger n2 = factorial(BigInteger.valueOf(n + 1));
        BigInteger n3 = factorial(BigInteger.valueOf(n));

        BigInteger result = n1.divide(n2.multiply(n3));

        return result.intValue();
    }

    private BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
