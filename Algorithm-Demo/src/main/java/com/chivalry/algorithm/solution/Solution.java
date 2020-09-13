package com.chivalry.algorithm.solution;

import java.util.List;

/**
 * @author Mr.zxb
 * @date 2020-09-12 14:16:54
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkRecord("PPALLL"));
    }

    /**
     * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
     *
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     *
     * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
     * 示例 1:
     *
     * 输入: "PPALLP"
     * 输出: True
     * 示例 2:
     *
     * 输入: "PPALLL"
     * 输出: False
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
     *
     * 示例：
     *
     * 输入:
     *
     *           1
     *          / \
     *         3   2
     *        / \   \
     *       5   3   9
     *
     * 输出: [1, 3, 9]
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        
        return null;
    }

    /**
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     *
     * 最终结果按照字典顺序输出。
     *
     * 示例 1:
     *
     * 输入: "abbxxxxzzy"
     * 输出: [[3,6]]
     * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {

        return null;
    }

}
