package com.aditya.java.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.aditya.java.tree.util.TreeUtil;

public class TreeDFSTest {

    @Test
    void iterativeDFSShouldTraverseTreeCorrectly() {
        List<String> expectedDFSOutput = List.of("1","3","7","6","2","5","4","8");
        String[] array = {"1","2","3","4","5","6","7","8"};
        assertEquals(expectedDFSOutput, TreeDFS.iterativeDFS(TreeUtil.createTreeFromArray(array)));
    }
}
