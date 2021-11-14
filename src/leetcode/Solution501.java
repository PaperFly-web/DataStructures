package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 501.二叉搜索树中的众数
 */
public class Solution501 {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> resMap = new HashMap<>();
        inorder(root, resMap);
        List<Map.Entry<Integer, Integer>> collect = resMap.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        }).collect(Collectors.toList());
        Map.Entry max = collect.get(collect.size() - 1);
        List<Integer> resList = collect.stream().filter(x -> {
            return x.getValue() == max.getValue();
        }).map(x -> {
            return x.getKey();
        }).collect(Collectors.toList());
        int [] res =new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i]= resList.get(i);
        }
        return res;
    }

    //利用中序遍历二叉搜索树为升序特性
    public void inorder(TreeNode root, Map<Integer, Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        if (res.get(root.val) == null) {
            res.put(root.val, 1);
        } else {
            res.put(root.val, res.get(root.val) + 1);
        }
        inorder(root.right, res);
    }

    static class TreeNode {
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
}
