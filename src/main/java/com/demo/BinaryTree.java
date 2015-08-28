package com.demo;

import java.util.Stack;

public class BinaryTree {
  public void preorder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while (!stack.empty()) {
      TreeNode p = stack.pop();
      System.out.printf("%d ", p.val);

      if (p.right != null) {
        stack.push(p.right);
      }
      if (p.left != null) {
        stack.push(p.left);
      }
    }
    System.out.println(" ");
  }

  public void inorder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;

    while (p != null || !stack.empty()) {
      if (p != null) {
        stack.push(p);
        p = p.left;
      } else {
        p = stack.pop();
        System.out.printf("%d ", p.val);
        p = p.right;
      }
    }
    System.out.println(" ");
  }

  public void postorder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    Stack<TreeNode> rep = new Stack<TreeNode>();
    TreeNode p = root;

    while (p != null) {
      rep.push(p);
      if (p.left != null)
        stack.push(p.left);

      if (p.right != null) {
        p.left = p.right;
        p = p.left;
      }
      else if (p.left != null) {
        p = p.left;
      }
      else {
        if (!stack.empty())
          p = stack.pop();
        else
          p = null;
      }
    }

    while (!rep.empty()) {
      p = rep.pop();
      System.out.printf("%d ", p.val);
    }
    System.out.println(" ");
  }

  // Validate binary search tree
  //   for all nodes, left children <= current node <= right children
  public boolean validate(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while (!stack.empty()) {
      TreeNode p = stack.pop();
      if (p.left != null)
        if (p.left.val <= p.val)
          stack.push(p.left);
        else
          return false;
      if (p.right != null)
        if (p.val <= p.right.val)
          stack.push(p.right);
        else
          return false;
    }
    return true;
  }
}
