package com.aditya.java.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.aditya.java.tree.util.TreeUtil;

public class TreeInorderTest {
	
	@Test
	void recursiveInorderShouldTraverseTreeCorrectly() {
		List<String> expectedOutput = List.of("8","4","2","5","1","6","3","7");
		String[] array = {"1","2","3","4","5","6","7","8"};
		assertEquals(expectedOutput, TreeInorder.recursiveInorder(TreeUtil.createTreeFromArray(array)));
	}
}
