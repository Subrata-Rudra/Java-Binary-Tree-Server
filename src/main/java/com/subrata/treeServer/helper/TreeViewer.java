package com.subrata.treeServer.helper;

import com.subrata.treeServer.dto.TreeNodeDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TreeViewer {
    private static void inorderViewHelperDfs(ArrayList<Integer> inorderWiseNodes, TreeNodeDto curr) {
        if (curr.getLeft() != null) {
            inorderViewHelperDfs(inorderWiseNodes, curr.getLeft());
        }
        inorderWiseNodes.add(curr.getData());
        if (curr.getRight() != null) {
            inorderViewHelperDfs(inorderWiseNodes, curr.getRight());
        }
    }

    private static void preorderViewHelperDfs(ArrayList<Integer> preorderWiseNodes, TreeNodeDto curr) {
        preorderWiseNodes.add(curr.getData());
        if (curr.getLeft() != null) {
            preorderViewHelperDfs(preorderWiseNodes, curr.getLeft());
        }
        if (curr.getRight() != null) {
            preorderViewHelperDfs(preorderWiseNodes, curr.getRight());
        }
    }

    private static void postorderViewHelperDfs(ArrayList<Integer> postorderWiseNodes, TreeNodeDto curr) {
        if (curr.getLeft() != null) {
            postorderViewHelperDfs(postorderWiseNodes, curr.getLeft());
        }
        if (curr.getRight() != null) {
            postorderViewHelperDfs(postorderWiseNodes, curr.getRight());
        }
        postorderWiseNodes.add(curr.getData());
    }

    // left -> root -> right
    public static ArrayList<Integer> inorderView(TreeNodeDto root) {
        // Build the inorder traversal ArrayList
        ArrayList<Integer> inorderWiseNodes = new ArrayList<>();
        inorderViewHelperDfs(inorderWiseNodes, root);
        return inorderWiseNodes;
    }

    // root -> left -> right
    public static ArrayList<Integer> preorderView(TreeNodeDto root) {
        // Build the preorder traversal ArrayList
        ArrayList<Integer> preorderWiseNodes = new ArrayList<>();
        preorderViewHelperDfs(preorderWiseNodes, root);
        return preorderWiseNodes;
    }

    // left -> right -> root
    public static ArrayList<Integer> postorderView(TreeNodeDto root) {
        // Build the postorder traversal ArrayList
        ArrayList<Integer> postorderWiseNodes = new ArrayList<>();
        postorderViewHelperDfs(postorderWiseNodes, root);
        return postorderWiseNodes;
    }

    public static HashMap<Integer, ArrayList<Integer>> levelOrderView(TreeNodeDto root) {
        // Build the level order traversal HashMap
        HashMap<Integer, ArrayList<Integer>> levelWiseNodes = new HashMap<>();
        LinkedList<TreeNodeDto> queue = new LinkedList<>();
        queue.add(root);
        int ind = 0;
        while (!queue.isEmpty()) {
            ArrayList<TreeNodeDto> nextLevelNodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNodeDto curr = queue.poll();
                if (curr.getLeft() != null) {
                    nextLevelNodes.add(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    nextLevelNodes.add(curr.getRight());
                }
                levelWiseNodes.putIfAbsent(ind, new ArrayList<>());
                levelWiseNodes.get(ind).add(curr.getData());
            }
            ind++;
            queue.addAll(nextLevelNodes);
        }
        return levelWiseNodes;
    }
}
