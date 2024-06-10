package com.chivalry.algorithm.solution;

import java.util.*;

/**
 * @author Mr.zxb
 * @date 2020-09-12 14:16:54
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.checkRecord("PPALLL"));
//        System.out.println(solution.romanToInt("MCMXCIV"));

//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        System.out.println(solution.removeElement(nums, 2));

//        String haystack = "leetcode", needle = "leeto";
//        System.out.println(solution.strStr(haystack, needle));

//        String s = "   fly me   to   the moon  ";
//        System.out.println(solution.lengthOfLastWord(s));

//        String a = "1010", b = "1011";
//        System.out.println(solution.addBinary(a, b));

        int[] nums = {2, 7, 11, 15};
        int[] twoSum = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(twoSum));
    }

    /**
     * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
     * <p>
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     * <p>
     * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
     * 示例 1:
     * <p>
     * 输入: "PPALLP"
     * 输出: True
     * 示例 2:
     * <p>
     * 输入: "PPALLL"
     * 输出: False
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        String[] strings = s.split("");
        for (String aChar : strings) {
            if (aChar.equals("A")) {
                absent++;
            }
            if (aChar.equals("L")) {
                late++;
            }
        }
        return absent <= 1 && late <= 2;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 您需要在二叉树的每一行中找到最大的值。
     * <p>
     * 示例：
     * <p>
     * 输入:
     * <p>
     * 1
     * / \
     * 3   2
     * / \   \
     * 5   3   9
     * <p>
     * 输出: [1, 3, 9]
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {

        return null;
    }

    /**
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     * <p>
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     * <p>
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     * <p>
     * 最终结果按照字典顺序输出。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abbxxxxzzy"
     * 输出: [[3,6]]
     * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
     *
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {

        return null;
    }

    /**
     * Roman to Integer
     * Input: s = "III"
     * Output: 3
     * Explanation: III = 3.
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0, number = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I' -> number = 1;
                case 'V' -> number = 5;
                case 'X' -> number = 10;
                case 'L' -> number = 50;
                case 'C' -> number = 100;
                case 'D' -> number = 500;
                case 'M' -> number = 1000;
            }
            if (number < prev) {
                sum -= number;
            } else {
                sum += number;
            }
            prev = number;
        }
        return sum;
    }

    /**
     * Remove Duplicates from Sorted Array
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    /**
     * remove element
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2,_,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 查找字符串中第一次出现的索引
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    /**
     * 搜索插入位置
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }
            if (nums[i] < target) {
                index++;
            }
        }
        return index;
    }

    /**
     * 最后一个字的长度
     * Input: s = "Hello World"
     * Output: 5
     * Explanation: The last word is "World" with length 5.
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int length = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isSpaceChar(ch)) {
                break;
            }
            length++;
        }
        return length;
    }

    /**
     * Plus One
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }

    /**
     * Given two binary strings a and b, return their sum as a binary string.
     * Example 1:
     * Input: a = "11", b = "1"
     * Output: "100"
     * <p>
     * Example 2:
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0; // 繰り上げを保持する変数

        int i = a.length() - 1;
        int j = b.length() - 1;

        // 逆順に2つの文字列をスキャンしていく
        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // 文字を数字に変換
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // 2進数の場合、sumが2以上の場合に繰り上げが発生する
            carry = sum / 2;
            result.insert(0, sum % 2); // 結果の先頭に加算結果を追加
        }

        // 最終的な繰り上げがある場合、結果に追加
        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }

    /**
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
     * The returned integer should be non-negative as well.
     * You must not use any built-in exponent function or operator.
     * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int start = 1;
        int end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // found the result
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid < x / mid) {
                // check the right part
                start = mid + 1;
            } else {
                // check the left part
                end = mid;
            }
        }
        return start;
    }

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 1; i < n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return a;
    }

    /**
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well.
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
     * representing the number of elements in nums1 and nums2 respectively.
     * <p>
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * <p>
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n,
     * where the first m elements denote the elements that should be merged,
     * and the last n elements are set to 0 and should be ignored.
     * nums2 has a length of n.
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of nums1 and nums2
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge nums2 into nums1
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * Given the roots of two binary trees p and q,
     * write a function to check if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical,
     * and the nodes have the same value.
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both trees are null
        if (p == null && q == null) {
            return true;
        }
        // One of p and q is null
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    /**
     * Implement the myAtoi(string s) function,
     * which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        s = s.trim(); // Step 1: Ignore leading whitespace

        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        int i = 0;

        // Step 2: Check for the sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Step 3 and 4: Read in next the characters until the next non-digit charcter or the end of the input is reached
        int n = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (n > (Integer.MAX_VALUE - digit) / 10) { // checking for overflow
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            n = n * 10 + digit;
            i++;
        }

        return sign * n; // Step 5 and 6: Apply the sign and return result
    }

    /**
     * Convert Sorted Array to Binary Search Tree
     * Given an integer array nums where the elements are sorted in ascending order, convert it to a
     * height-balanced
     * binary search tree.
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUtil(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTUtil(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTUtil(nums, start, mid - 1);
        root.right = sortedArrayToBSTUtil(nums, mid + 1, end);
        return root;
    }

    /**
     * Balanced Binary Tree
     * Given a binary tree, determine if it is
     * height-balanced
     * .
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }

    /**
     * Minimum Depth of Binary Tree
     * Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * Path Sum
     * Given the root of a binary tree and an integer targetSum,
     * return true if the tree has a root-to-leaf path such that adding up
     * all the values along the path equals targetSum.
     * <p>
     * A leaf is a node with no children.
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * Majority Element
     * Given an array nums of size n, return the majority element.
     * <p>
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     * Example 1:
     * Input: nums = [3,2,3]
     * Output: 3
     * <p>
     * Example 2:
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int i = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                i = num;
                count = 1;
            } else if (i == num) {
                count++;
            } else {
                count--;
            }
        }
        return i;
    }

    /**
     * 1. Two Sum
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     * <p>
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * <p>
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * <p>
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (!map.containsKey(difference)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(difference), i};
            }
        }
        return new int[0];
    }


}
