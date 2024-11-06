package TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode#202
 */
public class HappyNumber {

    /**
     * Slow and fast pointer
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;
//while loop is not used here because initially slow and
//fast pointer will be equal only, so the loop won't run.
        do {
//slow moving one step ahead and fast moving two steps ahead

            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

//if a cycle exists, then the number is not a happy number
//and slow will have a value other than 1

        return slow == 1;
    }

//Finding the square of the digits of a number

    public int square(int num) {

        int ans = 0;

        while (num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }

        return ans;
    }

    /**
     * Using set
     */
    public boolean isHappy1(int n) {
        Set<Integer> visit = new HashSet<>();

        while (!visit.contains(n)) {
            visit.add(n);
            n = getNextNumber(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    private int getNextNumber(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n = n / 10;
        }

        return output;
    }
}
