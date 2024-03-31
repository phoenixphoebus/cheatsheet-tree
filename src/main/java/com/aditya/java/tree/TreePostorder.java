package com.aditya.java.tree;

import java.util.LinkedList;
import java.util.List;

import com.aditya.java.tree.pojo.Node;
import com.aditya.java.tree.util.TreeUtil;

public class TreePostorder {
    public static void main(String[] args) {
        String[] array = { "1", "2", "3", "4", "5", "6", "7", "8" };
        Node<String> treeRoot = TreeUtil.createTreeFromArray(array);
        List<String> inorder = recursivePostorder(treeRoot);
        System.out.println(inorder);
    }

    static <T> List<T> recursivePostorder(Node<T> treeRoot) {
        List<T> toReturn = new LinkedList<>();
        postorder(treeRoot, toReturn);
        return toReturn;
    }

    private static <T> void postorder(Node<T> node, List<T> list) {
        if (node.left != null) {
            postorder(node.left, list);
        }
        if (node.right != null) {
            postorder(node.right, list);
        }
        list.add(node.data);
    }
}
