package Stack;

/**
 * Leetcode#1111
 * Basically, ( is 1 point, ) is -1 point.
 * We try to keep total points of two groups even,
 * by distributing parentheses alternatively.
 *
 *
 * The good part of this solution is that,
 * we actually need no extra variable to record anything.
 */
public class MaximumNestingDepthTwoValidParenthesesStrings {
    public static void main(String[] args) {
        new MaximumNestingDepthTwoValidParenthesesStrings().maxDepthAfterSplit("((()))(())()");
    }
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length(), res[] = new int[n];
        for (int i = 0; i < n; ++i)
            res[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
        return res;
    }
}
