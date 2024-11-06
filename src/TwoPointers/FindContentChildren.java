package TwoPointers;

import java.util.Arrays;

public class FindContentChildren {

    public static void main(String[] args) {
        new FindContentChildren().findContentChildren(new int[]{10,9,8,7},new int[]{5,6,7,8});
    }
    public int findContentChildren(int[] g, int[] s) {
        int contentChild = 0;
        int i = 0;
        int j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                contentChild++;
            }
            j++;
        }
        return contentChild;
    }
}
