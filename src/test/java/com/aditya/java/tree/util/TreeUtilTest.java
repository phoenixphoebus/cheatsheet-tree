package com.aditya.java.tree.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.aditya.java.tree.pojo.Node;

public class TreeUtilTest {

	@Test
	void emptyArrayForTreeCreationShouldReturnNull() {
		String[] emptyArray = {};
		assertEquals(null, TreeUtil.createTreeFromArray(emptyArray));
	}

	@Test
	void createNodeWithChildrenShouldThrowExceptionForZeroParameters() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Node<String> dummyNode = new Node<String>("a");
			TreeUtil.createNodeWithChildren("a", dummyNode, dummyNode, dummyNode);
		});
		assertEquals("Invalid length of parameter: children. Expected <=2. Found: 3", exception.getMessage());
	}

	@Test
	void createNodeWithChildrenShouldCreateNewNodeMatchingParameters() {
		Node<String> dummyNode1 = new Node<String>("1");
		Node<String> dummyNode2 = new Node<String>("2");
		Node<String> node = TreeUtil.createNodeWithChildren("a", dummyNode1, dummyNode2);
		assertAll("node", () -> assertEquals("a", node.data), () -> assertEquals("1", node.left.data),
				() -> assertEquals("2", node.right.data));
	}
	
	@Test
	void createNodeWithChildrenShouldCreateFourLevelTreeFromArrayCorrectly() {
		String[] array = {"1","2","3","4","5","6","7","8"};
		Node<String> node8 = TreeUtil.createNodeWithChildren("8");
		Node<String> node7 = TreeUtil.createNodeWithChildren("7");
		Node<String> node6 = TreeUtil.createNodeWithChildren("6");
		Node<String> node5 = TreeUtil.createNodeWithChildren("5");
		Node<String> node4 = TreeUtil.createNodeWithChildren("4", node8);
		Node<String> node3 = TreeUtil.createNodeWithChildren("3", node6, node7);
		Node<String> node2 = TreeUtil.createNodeWithChildren("2", node4, node5);
		Node<String> node1 = TreeUtil.createNodeWithChildren("1", node2, node3);
		assertEquals(node1, TreeUtil.createTreeFromArray(array));
	}
	
}
