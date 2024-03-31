package com.aditya.java.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.aditya.java.tree.pojo.Node;
import com.aditya.java.tree.util.TreeUtil;

public class TreeBFS {
    public static void main(String[] args) {
        String[] array = { "1", "2", "3", "4", "5", "6", "7", "8" };
        Node<String> treeRoot = TreeUtil.createTreeFromArray(array);
        List<String> bfs = iterativeBFS(treeRoot);
        System.out.println(bfs);
    }

    static <T> List<T> iterativeBFS(Node<T> treeRoot) {
        List<T> toReturn = new LinkedList<>();

        Queue<Node<T>> bfsQueue = new LinkedList<>();
        bfsQueue.add(treeRoot);

        do {
            Node<T> currentNode = bfsQueue.poll();
            if (currentNode.left != null) {
                bfsQueue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                bfsQueue.offer(currentNode.right);
            }
            toReturn.add(currentNode.data);
        } while (!bfsQueue.isEmpty());

        return toReturn;
    }
}
