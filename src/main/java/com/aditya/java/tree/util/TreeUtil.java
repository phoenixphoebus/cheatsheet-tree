package com.aditya.java.tree.util;

import java.util.LinkedList;
import java.util.Queue;

import com.aditya.java.tree.pojo.Node;

public class TreeUtil {

	public static <T> Node<T> createTreeFromArray(T[] array) {
		if (array.length == 0) {
			return null;
		} else {
			Queue<Node<T>> currentlyProcessingQueue = new LinkedList<>();
			Queue<Node<T>> nextProcessingQueue = new LinkedList<>();

			Node<T> root = new Node<>(array[0]);
			nextProcessingQueue.offer(root);

			for (int i = 1; i < array.length;) {
				if (currentlyProcessingQueue.size() == 0) {
					// nextQ becomes currentQ and is reinitialized
					currentlyProcessingQueue = nextProcessingQueue;
					nextProcessingQueue = new LinkedList<>();
				}
				Node<T> currentItem = currentlyProcessingQueue.peek();
				if (currentItem.left == null) {
					// add to left and also add to nextQ
					currentItem.left = new Node<T>(array[i]);
					nextProcessingQueue.add(currentItem.left);
					i++;
				}
				else if (currentItem.right == null) {
					// add to right and also add to nextQ
					currentItem.right = new Node<T>(array[i]);
					nextProcessingQueue.add(currentItem.right);
					i++;
				}
				// take node out
				else {
					currentlyProcessingQueue.poll();
				}
			}
			return root;
		}

	}
	
	static <T> Node<T> createNodeWithChildren(T value, Node<T> ... children){
		if(children.length > 2) {
			throw new IllegalArgumentException("Invalid length of parameter: children. Expected <=2. Found: "+children.length);
			
		}
		if(value == null) {
			return null;
		}
		else {
			Node<T> node = new Node<>(value);
			node.left = children.length > 0 ? children[0] : null;
			node.right = children.length > 1 ? children[1] : null;
			return node;
		}
	}

}
