package com.aditya.java.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.aditya.java.tree.pojo.Node;
import com.aditya.java.tree.util.TreeUtil;

public class TreeDFS {

    public static void main(String args[]) {
        String[] array = { "1", "2", "3", "4", "5", "6", "7", "8" };
        Node<String> treeRoot = TreeUtil.createTreeFromArray(array);
        List<String> dfs = iterativeDFS(treeRoot);
        System.out.println(dfs);
    }

    static <T> List<T> iterativeDFS(Node<T> treeRoot) {
        List<T> toReturn = new LinkedList<>();

        Stack<Node<T>> dfsStack = new Stack<>();
        dfsStack.push(treeRoot);

        do {
            Node<T> currentNode = dfsStack.pop();
            if (currentNode.left != null) {
                dfsStack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                dfsStack.push(currentNode.right);
            }
            toReturn.add(currentNode.data);
        } while (!dfsStack.isEmpty());
        return toReturn;
    }

}
