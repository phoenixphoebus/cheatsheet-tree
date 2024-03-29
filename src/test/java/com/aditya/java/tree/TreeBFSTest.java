package com.aditya.java.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.aditya.java.tree.util.TreeUtil;

public class TreeBFSTest {
	
	
	@Test
	void iterativeBFSShouldTraverseTreeCorrectly() {
		List<String> expectedBFSOutput = List.of("1","2","3","4","5","6","7","8");
		String[] array = {"1","2","3","4","5","6","7","8"};
		assertEquals(expectedBFSOutput, TreeBFS.iterativeBFS(TreeUtil.createTreeFromArray(array)));
	}
}
