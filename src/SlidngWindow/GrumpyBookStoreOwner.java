package SlidngWindow;

/**
 * https://www.youtube.com/watch?v=kCxCE0_66vM
 * Leetcode#1052
 */
public class GrumpyBookStoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int totalSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        int addSatisfied = 0;
        int currWindowSatisfied = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currWindowSatisfied += customers[i];
            }
        }
        addSatisfied = currWindowSatisfied;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                currWindowSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currWindowSatisfied -= customers[i - minutes];
            }
            addSatisfied = Math.max(addSatisfied, currWindowSatisfied);
        }
        return totalSatisfied + addSatisfied;
    }
}
