package com.subrata.treeServer.helper;

import java.util.ArrayList;
import java.util.LinkedList;

import com.subrata.treeServer.dto.TreeNodeDto;

public class TreeBuilder {
    public static TreeNodeDto levelOrderBuild(ArrayList<Integer> arr) {
        LinkedList<TreeNodeDto> queue = new LinkedList<>();
        TreeNodeDto root = new TreeNodeDto();
        if (arr.getFirst() != null) {
            root.setData(arr.getFirst());
        }
        if (root.getData() != null) {
            queue.add(root);
        }
        int ind = 1;
        while (!queue.isEmpty() && ind < arr.size()) {
            TreeNodeDto curr = queue.poll();
            if (ind < arr.size()) {
                TreeNodeDto l = new TreeNodeDto();
                if (arr.get(ind) != null) {
                    l.setData(arr.get(ind));
                }
                ind++;
                curr.setLeft(l);
                if (l.getData() != null) {
                    queue.add(l);
                }
            }
            if (ind < arr.size()) {
                TreeNodeDto r = new TreeNodeDto();
                if (arr.get(ind) != null) {
                    r.setData(arr.get(ind));
                }
                ind++;
                curr.setRight(r);
                if (r.getData() != null) {
                    queue.add(r);
                }
            }
        }
        return root;
    }
}
