package com.aditya.java.tree;

import java.util.LinkedList;
import java.util.List;

import com.aditya.java.tree.pojo.Node;
import com.aditya.java.tree.util.TreeUtil;

public class TreePreorder {
    public static void main(String[] args) {
        String[] array = { "1", "2", "3", "4", "5", "6", "7", "8" };
        Node<String> treeRoot = TreeUtil.createTreeFromArray(array);
        List<String> preorder = recursivePreorder(treeRoot);
        System.out.println(preorder);
    }

    static <T> List<T> recursivePreorder(Node<T> treeRoot) {
        List<T> toReturn = new LinkedList<>();
        preorder(treeRoot, toReturn);
        return toReturn;
    }

    private static <T> void preorder(Node<T> node, List<T> list) {
        list.add(node.data);
        if (node.left != null) {
            preorder(node.left, list);
        }
        if (node.right != null) {
            preorder(node.right, list);
        }
    }
}
