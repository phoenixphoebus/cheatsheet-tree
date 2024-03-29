package com.aditya.java.tree;

import java.util.LinkedList;
import java.util.List;

import com.aditya.java.tree.pojo.Node;
import com.aditya.java.tree.util.TreeUtil;

public class TreeInorder {
	
	public static void main(String args[]) {
		String[] array = { "1", "2", "3", "4", "5", "6", "7", "8" };
		Node<String> treeRoot = TreeUtil.createTreeFromArray(array);
		List<String> inorder = recursiveInorder(treeRoot);
		System.out.println(inorder);
	}
	
	static <T> List<T> recursiveInorder(Node<T> treeRoot){
		List<T> toReturn = new LinkedList<>();
		inorder(treeRoot, toReturn);
		return toReturn;
	}

	
	private static <T> void inorder(Node<T> node, List<T> list) {
		if(node.left!=null) {
			inorder(node.left, list);
		}
		list.add(node.data);
		if(node.right!=null) {
			inorder(node.right, list);
		}
	}
}
