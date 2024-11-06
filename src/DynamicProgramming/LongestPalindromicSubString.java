package DynamicProgramming;

/**
 * Leetcode#5
 */
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubString().longestPalindrome("babad"));
    }
    // Approach 1 : DP
    public String longestPalindrome(String s) {
        int[][] dynamicArray = new int[s.length()][s.length()];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        int maxLength = 1;
        String result = "";
        for (int i = 0; i < dynamicArray.length; i++) {
            dynamicArray[i][i] = 1;
            isPalindrome[i][i] = true;
        }
        for(int i=0;i<dynamicArray.length;i++){
            for(int j=0;j<i;j++){
                isPalindrome[i][j] = true;
            }
        }
        //printIntArray(dynamicArray);
        int i = 0;
        int k = 1;
        int j = i + k;
        while (i >= 0 && j < dynamicArray[0].length) {
            if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                dynamicArray[i][j] += dynamicArray[i + 1][j - 1] + 2;
                isPalindrome[i][j] = true;

            } else {
                //for subsequence
                //dynamicArray[i][j] += Math.max(Math.max(dynamicArray[i + 1][j - 1], dynamicArray[i][j - 1]), dynamicArray[i + 1][j]);
                dynamicArray[i][j] += Math.max(Math.max(dynamicArray[i + 1][j - 1], dynamicArray[i][j - 1]), dynamicArray[i + 1][j]);
            }
            //printIntArray(dynamicArray);
            if (dynamicArray[i][j] > maxLength) {
                maxLength = dynamicArray[i][j];
                result = s.substring(i, j + 1);
            }
            i++;
            j = i + k;
            if (j == dynamicArray[0].length) {
                i = 0;
                k++;
                j = i + k;
            }
        }

        return result.isEmpty() ? s.charAt(0) + "" : result;
    }

    public static void printIntArray(int[][] dynamicArray) {
        for (int i = 0; i < dynamicArray.length; i++) {
            for (int j = 0; j < dynamicArray[i].length; j++) {
                System.out.print(dynamicArray[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
}
