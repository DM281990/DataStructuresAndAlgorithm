package BinaryTree;

import util.Node;
import util.TreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //new Main().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        new Main().leafSimilar(new TreeNode(1,new TreeNode(2,null,null),new TreeNode(200,null,null)),
                new TreeNode(1,new TreeNode(2,null,null),new TreeNode(200,null,null)));
    }

    /**
     * Leetcode#94
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> listResult = new ArrayList<>();
        inorderTraversalUtil(root, listResult);
        return listResult;
    }

    private void inorderTraversalUtil(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalUtil(root.left, result);
        result.add(root.val);
        inorderTraversalUtil(root.right, result);
    }

    /**
     * LeetCode#100
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return isSameTree(p.left, q.left) && (p.val == q.val) && isSameTree(p.right, q.right);
    }

    /**
     * Leetcode#101
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricUtil(root.left, root.right);
    }

    public boolean isSymmetricUtil(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return isSymmetricUtil(l.left, r.right) && l.val == r.val && isSymmetricUtil(l.right, r.left);
    }

    /**
     * Leetcode#104
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * LeetCode#108
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBSTUtil(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTUtil(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        return new TreeNode(nums[mid], sortedArrayToBSTUtil(nums, start, mid - 1), sortedArrayToBSTUtil(nums, mid + 1, end));
    }

    /**
     * Leetcode#111
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * Leetcode#112
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * Leetcode#144
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalUtil(root, result);
        return result;
    }

    public void preorderTraversalUtil(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalUtil(root.left, result);
        preorderTraversalUtil(root.right, result);
    }

    /**
     * Leetcode#145
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalUtil(root, result);
        return result;
    }

    public void postorderTraversalUtil(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversalUtil(root.left, result);
        postorderTraversalUtil(root.right, result);
        result.add(root.val);
    }

    /**
     * Leetcode#222
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Leetcode#226
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = invertTree(root.right);
        TreeNode rightNode = invertTree(root.left);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    /**
     * Leetcode#257
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        binaryTreePathsUtil(root, pathList, "");
        return pathList;
    }

    private void binaryTreePathsUtil(TreeNode root, List<String> pathList, String str) {
        if (root.left == null && root.right == null) {
            pathList.add(str + root.val);
            return;
        }
        if (root.left == null) {
            binaryTreePathsUtil(root.right, pathList, str + root.val + "->");
        } else if (root.right == null) {
            binaryTreePathsUtil(root.left, pathList, str + root.val + "->");
        } else {
            binaryTreePathsUtil(root.left, pathList, str + root.val + "->");
            binaryTreePathsUtil(root.right, pathList, str + root.val + "->");
        }

    }

    /**
     * Leetcode#404
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null & root.right == null) return 0;
        return sumOfLeftLeavesUtil(root, false);
    }

    public int sumOfLeftLeavesUtil(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) return root.val;
        return sumOfLeftLeavesUtil(root.left, true) + sumOfLeftLeavesUtil(root.right, false);
    }

    /**
     * Leetcode#501
     *
     * @param root
     * @return
     */
    int maxcount = 1;

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        FindMode(root, map);
        ArrayList<Integer> list = new ArrayList<>();


        for (Integer key : map.keySet()) {
            if (map.get(key) == maxcount) {
                list.add(key);
            }
        }

        int ans[] = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            ans[j] = list.get(j);
        }
        return ans;


    }

    public void FindMode(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        } else if (map.containsKey(root.val)) {
            int count = map.get(root.val) + 1;
            map.put(root.val, count);
            maxcount = Math.max(count, maxcount);

        } else {
            map.put(root.val, 1);
        }
        FindMode(root.left, map);
        FindMode(root.right, map);
    }

    /**
     * Leetcode#530
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getMinimumDifferenceUtil(root, list);
        int minimum = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) minimum = Math.min(minimum, list.get(i) - list.get(i - 1));
        return minimum;
    }

    public void getMinimumDifferenceUtil(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getMinimumDifferenceUtil(root.left, list);
        list.add(root.val);
        getMinimumDifferenceUtil(root.right, list);
    }

    /**
     * Leetcode#543
     *
     * @param root
     * @return
     */
    int maxdiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterUtil(root);
        return maxdiameter;
    }

    public int diameterUtil(TreeNode root) {
        if (root == null) return 0;
        int leftLength = diameterUtil(root.left);
        int rightLength = diameterUtil(root.right);
        maxdiameter = Math.max(leftLength + rightLength, maxdiameter);
        return 1 + Math.max(leftLength, rightLength);
    }

    /**
     * Leetcode#563
     *
     * @param root
     * @return
     */
    int tilt = 0;

    public int findTilt(TreeNode root) {
        findTiltUtil(root);
        return tilt;
    }

    private int findTiltUtil(TreeNode root) {
        if (root == null) return 0;
        int left = findTiltUtil(root.left);
        int right = findTiltUtil(root.right);
        tilt = tilt + Math.abs(right - left);
        return root.val + left + right;
    }

    /**
     * Leetcode#572
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    /**
     * Leecode#617
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * Leetcode #637
     * @param root
     * @return
     */
    List<Double> sums = new ArrayList<>();
    List<Integer> counts = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        helper(root,0);
        List<Double> avg = new ArrayList<>();
        for(int i = 0;i<sums.size();i++){
            avg.add(sums.get(i)/counts.get(i));
        }

        return avg;
    }

    public void helper(TreeNode root,int level){
        if(root==null) return;
        if(sums.size()>level){
            Double sum=sums.get(level);
            int count=counts.get(level);
            sums.set(level,sum+((Integer)root.val).doubleValue());
            counts.set(level,count+1);
        }
        else{
            sums.add(((Integer)root.val).doubleValue());
            counts.add(1);
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }

    /**
     * Leetcode#653
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> values = new HashSet<>();
        return findTargetUtil(root,k,values);
    }

    private boolean findTargetUtil(TreeNode root, int k, Set<Integer> values) {
        if(root ==null) return false;
        if(values.contains(k-root.val))return true;
        values.add(root.val);
        return findTargetUtil(root.left,k,values)||findTargetUtil(root.right,k,values);
    }

    /**
     * Leetcode#671
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        findSecondMinimumValueUtil(root, map);
        List<Integer> list = new ArrayList<>(map.keySet());
        return list.size()>1?list.get(1):-1;
    }

    public void findSecondMinimumValueUtil(TreeNode root, TreeMap<Integer,Integer> map) {
        if(root ==null) return;
        findSecondMinimumValueUtil(root.left,map);
        map.put(root.val,1);
        findSecondMinimumValueUtil(root.right,map);
    }

    /**
     * Leetcode#559
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(root ==null)return 0;
        int height =0;
        for(int i=0;i<root.children.size();i++){
            height = Math.max(height,maxDepth(root.children.get(i)));
        }
        return height+1;
    }

    /**
     * Leetcode#589
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> preOrderList = new ArrayList<>();
        preOrderUtil(root,preOrderList);
        return  preOrderList;
    }

    private void preOrderUtil(Node root, List<Integer> preOrderList) {
        if(root ==null) return;
        preOrderList.add(root.val);
        for(int i =0;i<root.children.size();i++){
            preOrderUtil(root.children.get(i),preOrderList);
        }
    }
    /**
     * Leetcode#590
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> postOrderList = new ArrayList<>();
        postOrderUtil(root,postOrderList);
        return  postOrderList;
    }
    private void postOrderUtil(Node root, List<Integer> postOrderList) {
        if(root ==null) return;
        for(int i =0;i<root.children.size();i++){
            postOrderUtil(root.children.get(i),postOrderList);
        }
        postOrderList.add(root.val);
    }

    /**
     * Leetcode#700
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(val>root.val) return searchBST(root.right, val);
        else if(val<root.val) return searchBST(root.left, val);
        return root;
    }

    /**
     * Leetcode#703
     */
    PriorityQueue<Integer> pq;
    int k;
    public void KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int i : nums) {
            this.add(i);
        }
    }
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }

    /**
     * Leetcode#783
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        minDiffInBSTUtil(root,values);
        int min =Integer.MAX_VALUE;
        for(int i=1;i<values.size();i++){
            min = Math.min(min,values.get(i)-values.get(i-1));
        }
        return min;
    }

    private void minDiffInBSTUtil(TreeNode root, List<Integer> values) {
        if(root==null)return;
        minDiffInBSTUtil(root.left,values);
        values.add(root.val);
        minDiffInBSTUtil(root.right,values);
    }

    /**
     * Leetcode#872
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        leafSimilarUtil(root1,list1);
        leafSimilarUtil(root2,list2);
        if(list1.size()!=list2.size())return false;
        return checkElements(list1,list2);
    }

    private boolean checkElements(List<Integer> list1, List<Integer> list2) {
        for(int i=0;i<list1.size();i++){
            if(!Objects.equals(list1.get(i), list2.get(i)))return false;
        }
        return true;
    }


    private void leafSimilarUtil(TreeNode root, List<Integer>list) {
        if(root ==null) return;
        if(root.left == null && root.right ==null)list.add(root.val);
        leafSimilarUtil(root.left,list);
        leafSimilarUtil(root.right,list);
    }

    /**
     * Leetcode#897
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        increasingBSTUtil(root,list);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode temp =node;
        for(int i =1;i<list.size();i++){
            temp.right= new TreeNode(list.get(i));
            temp =temp.right;
        }
        return node;
    }

    private void increasingBSTUtil(TreeNode root, List<Integer> list) {
        if(root ==null)return;
        increasingBSTUtil(root.left,list);
        list.add(root.val);
        increasingBSTUtil(root.right,list);
    }

    /**
     * Leetcode#938
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root ==null) return 0;
        if(root.val<low) return rangeSumBST(root.right,low,high);
        if(root.val > high) return rangeSumBST(root.left,low,high);;
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }

    /**
     * Leetcode#965
     * @param root
     * @return
     */
    Set<Integer> set = new HashSet<>();
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        isUnivalTree(root.left);
        set.add(root.val);
        if(set.size()>1) return false;
        isUnivalTree(root.right);
        return set.size()<=1;
    }

    /**
     * Leetcode#993
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> parentmap = new HashMap<>();
        isCousinUtil(root.left, map, 1, parentmap, root);
        isCousinUtil(root.right, map, 1, parentmap, root);

        for (Integer m : map.keySet()) {
            List<Integer> list = map.get(m);
            if (list.contains(x) && list.contains(y)) {
                return !parentmap.get(x).equals(parentmap.get(y));
            }
        }
        return false;
    }

    private void isCousinUtil(TreeNode root, Map<Integer, List<Integer>> map, int level, Map<Integer, Integer> parentmap,TreeNode parent) {
        if(root==null) {
            return;
        }
        if(map.containsKey(level)) {
            parentmap.put(root.val, parent.val);
            map.get(level).add(root.val);
        }
        else {
            parentmap.put(root.val, parent.val);
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        }
        isCousinUtil(root.left, map, level+1,parentmap, root);
        isCousinUtil(root.right, map, level+1,parentmap, root);
    }

    /**
     * Leetcode#1022
     */
    int ans=0;
    public int sumRootToLeaf(TreeNode root) {
        help(root,0);
        return ans;
    }
    public void help(TreeNode root,int sum){
        if(root==null)  return;
        sum=sum*2 + root.val;
        help(root.left,sum);
        if(root.left==null&&root.right==null)    ans+=sum;
        help(root.right,sum);
        sum /= 2;
    }

    /**
     * Leetcode#1379
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target)
            return cloned;
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null)
            return res;
        return getTargetCopy(original.right, cloned.right, target);
    }

    /**
     * Leetcode#2236
     * @param root
     * @return
     */
    public boolean checkTree(TreeNode root) {
        return root.val == root.right.val+root.left.val;
    }

    /**
     * Leetcode#2331
     * @param root
     * @return
     */
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0) return false;
        if(root.val == 1) return true;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return root.val == 2 ? left|right : left&right;
    }
}
