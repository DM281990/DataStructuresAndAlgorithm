package SlidngWindow;

import util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().minimumSubarrayLength(new int[]{16,1,2,20,32},45);
    }
    /**
     * Leetcode#219
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int[][]numsRecord = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsRecord[i][0]=nums[i];
            numsRecord[i][1]=i;
        }
        Arrays.sort(numsRecord,(n1,n2)->n2[0]-n1[0]);
        for(int i=1;i<numsRecord.length;i++) {
            if(numsRecord[i][0]==numsRecord[i-1][0]) {
                int diff = Math.abs(numsRecord[i-1][1]-numsRecord[i][1]);
                if(diff<=k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * LeetCode#594
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int num : nums) {
            if (!count.containsKey(num)) {
                count.put(num, 1);
            } else {
                count.compute(num, (k, v) ->v+=1);
            }
        }
        int maxLength=0;
        for(Integer key:count.keySet()){
            if(count.get(key-1)!=null){
                maxLength = Math.max(maxLength,count.get(key)+count.get(key-1));
            }
        }
        return maxLength;
    }

    /**
     * Leetcode#643
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i ++)
            sum += nums[i];
        int maxSum = sum;
        for(int i = k; i < nums.length; i ++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }

    /**
     * Leetcode#1652
     * @param code
     * @param k
     * @return
     */
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) return res;
        //Define the initial window and initial sum
        int start = 1, end = k, sum = 0;
        if (k < 0) {//If k < 0, the starting point will be end of the array.
            k = -k;
            start = code.length - k;
            end = code.length - 1;
        }
        for (int i = start; i <= end; i++) sum += code[i];
        //Scan through the code array as i moving to the right, update the window sum.
        for (int i = 0; i < code.length; i++) {
            res[i] = sum;
            sum -= code[(start++) % code.length];
            sum += code[(++end) % code.length];
        }
        return res;
    }
    /**
     * https://www.youtube.com/watch?v=20mjBSByOaQ&t=2s
     * Leetcode#1763
     */
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: arr) set.add(c);
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i+1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }

    /**
     * Leetcode#1876
     * @param s
     * @return
     */
    public int countGoodSubstrings(String s) {
        int k =3;
        char[] ch = s.toCharArray();
        if(k>ch.length) return 0;
        Map<Character,Integer> count = new HashMap<>();
        for(int i=0;i<k;i++){
            if(count.containsKey(ch[i])){
                count.compute(ch[i],(key,value)->value+=1);
            }
            else{
                count.put(ch[i],1);
            }
        }
        int cont=count.keySet().size()==3?1:0;
        for (int i=k;i<s.length();i++){
            count.compute(ch[i-k],(key,value)->value-=1);
            if(count.get(ch[i-k])==0)count.remove(ch[i-k]);
            if(count.containsKey(ch[i])){
                count.compute(ch[i],(key,value)->value+=1);
            }
            else{
                count.put(ch[i],1);
            }
            if(count.keySet().size()==3)
                cont++;
        }
        return cont;
    }
    /**
     * Leetcode#1876
     * @param s
     * @return
     */
    public int countGoodSubstrings1(String s) {
        int c = 0;
        char[] a = s.toCharArray();
        for (int i = 0; i <= a.length - 3; ++i) {
            if (a[i] != a[i + 1] && a[i] != a[i + 2] && a[i + 1] != a[i + 2])
                ++c;
        }
        return c;
    }

    /**
     * Leetcode#1984
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if(k==nums.length)return nums[nums.length-1]-nums[0];
        int diff =Integer.MAX_VALUE;
        for(int i=k-1;i<nums.length;i++){
            diff =Math.min(diff,nums[i]-nums[i-(k-1)]);
        }
        return diff;
    }

    /**
     * Leetcode#2269
     * @param num
     * @param k
     * @return
     */
    public int divisorSubstrings(int num, int k) {
        String numStr = num+"";
        int beauty=0;
        for(int i=k;i<=numStr.length();i++) {
            String divisorStr = numStr.substring(i-k,i);
            int divisorVal = Integer.valueOf(divisorStr);
            if(divisorVal!=0) {
                if(num%divisorVal==0) {
                    beauty++;
                }
            }
        }
        return beauty;
    }

    /**
     * Leetcode#2379
     * @param blocks
     * @param k
     * @return
     */
    public int minimumRecolors(String blocks, int k) {
        Map<Character,Integer> blkCnt = new HashMap<>();
        char []ch=blocks.toCharArray();
        blkCnt.put('W',0);
        blkCnt.put('B',0);
        int minChange = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            blkCnt.compute(ch[i],(key,v)->v+=1);
        }
        minChange = blkCnt.get('W');
        for(int i=k;i<ch.length;i++){
            blkCnt.compute(ch[i],(key,v)->v+=1);
            blkCnt.compute(ch[i-k],(key,v)->v-=1);
            minChange = Math.min( blkCnt.get('W'),minChange);
        }
        return minChange;
    }

    /**
     * Leetcode#2760
     * @param nums
     * @param threshold
     * @return
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0, n = nums.length, max = 0, curr = 0;

        for(int i=0; i<n; i++) {
            if(nums[i]%2 == 0 && nums[i] <= threshold && curr%2 == 0) {
                curr++;
            } else if(nums[i]%2 != 0 && nums[i] <= threshold && curr%2 != 0 ) {
                curr++;
            } else {
                curr = nums[i]%2 == 0 && nums[i] <= threshold ? 1 : 0;
            }
            res = Math.max(res, curr);
        }

        return res;
    }

    /**
     * Leetcode#3090
     * @param s
     * @return
     */
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int[] freq = new int[26];
        for (int i = 0, k = 0; i < s.length(); ++i) {
            ++freq[s.charAt(i)-97];
            while (freq[s.charAt(i)-97] == 3) --freq[s.charAt(k++)-97];
            ans = Math.max(ans, i-k+1);
        }
        return ans;
    }

    /**
     * Leetcode2932
     */
    public int maximumStrongPairXor(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])<=Math.min(nums[i],nums[j]))
                    res=Math.max(res,nums[i]^nums[j]);
            }
        }
        return res;
    }


    public void doBitWiseOrOperation(int[] bitCount, int[] orValWrapper, int n) {
        orValWrapper[0] = (orValWrapper[0] | n);
        for(int i = 0; i < 32; i++) {
            bitCount[i] += ((n & (1 << i)) != 0 ? 1 : 0);
        }
    }

    public void undoBitWiseOrOperation(int[] bitCount, int[] orValWrapper, int n) {
        for(int i = 0; i < 32; i++) {
            bitCount[i] += ((n & (1 << i)) != 0 ? -1 : 0);
            if (bitCount[i] == 0) orValWrapper[0] = orValWrapper[0] & (~(1 << i));
        }
    }
    /**
     * Failed
     * Leetcode#3095
     * @param nums
     * @param k
     * @return
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int orVal = 0;
        int minLength = Integer.MAX_VALUE;
        int[] bitCount = new int[32];
        int[] orValWrapper = {orVal};
        for(int start = 0, end = 0; end < nums.length; end++) {
            doBitWiseOrOperation(bitCount, orValWrapper, nums[end]);
            if(orValWrapper[0] < k) continue;
            for(; start <= end && orValWrapper[0] >= k; start++) {
                undoBitWiseOrOperation(bitCount, orValWrapper, nums[start]);
                minLength = Math.min(minLength, end - start + 1);
            }
        }
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }

    /**
     * Leetcode#3206
     * @param colors
     * @return
     */
    public int numberOfAlternatingGroups(int[] colors) {
        int count =0;
        if(colors[0]!=colors[1] && colors[1]==colors[colors.length-1])count++;
        for(int i=1;i<colors.length;i++){
            if(colors[i-1]== colors[(i+1)%colors.length] && colors[i]!=colors[i-1])count++;
        }
        return count;
    }

    /**
     * Leetcode#3318
     * @param nums
     * @param k
     * @param x
     * @return
     */
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;

        int[] ans = new int[n-k+1];
        for(int i=0; i<n-k+1; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i; j<i+k; j++){
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            }

            List<Pair> list = new ArrayList<>();
            for(int key:map.keySet()){
                list.add(new Pair(map.get(key), key));
            }
            Collections.sort(list, (Pair a, Pair b)->{
                if(a.first==b.first){
                    return b.second-a.second;
                }
                return b.first-a.first;
            });

            int sum = 0;
            int uniq = 0;
            for(Pair l:list){
                if(uniq >= x){
                    break;
                }

                sum += l.first*l.second;
                uniq++;
            }
            ans[i]=sum;
        }
        return ans;
    }

    /**
     * ALGORITHM ##################################################
     * Leetcode3258,713
     * @param s
     * @param k
     * @return
     */
    public int countKConstraintSubstrings(String s, int k) {
        int count = 0;
        int oneCount = 0;
        int zeroCount = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
            while (zeroCount > k && oneCount > k) {
                if (s.charAt(left) == '0') {
                    zeroCount--;
                } else {
                    oneCount--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
