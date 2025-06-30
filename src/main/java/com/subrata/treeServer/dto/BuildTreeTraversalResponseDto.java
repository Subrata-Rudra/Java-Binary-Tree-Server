package com.subrata.treeServer.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildTreeTraversalResponseDto {
    private int root;
    private ArrayList<Integer> inorder;
    private ArrayList<Integer> preorder;
    private ArrayList<Integer> postorder;
    private HashMap<Integer, ArrayList<Integer>> levelorder;

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public ArrayList<Integer> getInorder() {
        return inorder;
    }

    public void setInorder(ArrayList<Integer> inorder) {
        this.inorder = inorder;
    }

    public ArrayList<Integer> getPreorder() {
        return preorder;
    }

    public void setPreorder(ArrayList<Integer> preorder) {
        this.preorder = preorder;
    }

    public ArrayList<Integer> getPostorder() {
        return postorder;
    }

    public void setPostorder(ArrayList<Integer> postorder) {
        this.postorder = postorder;
    }

    public HashMap<Integer, ArrayList<Integer>> getLevelorder() {
        return levelorder;
    }

    public void setLevelorder(HashMap<Integer, ArrayList<Integer>> levelorder) {
        this.levelorder = levelorder;
    }
}
