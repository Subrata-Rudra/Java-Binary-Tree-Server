package com.subrata.treeServer.dto;

public class TreeNodeDto {
    private Integer data;
    private TreeNodeDto left;
    private TreeNodeDto right;

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNodeDto getLeft() {
        return left;
    }

    public void setLeft(TreeNodeDto left) {
        this.left = left;
    }

    public TreeNodeDto getRight() {
        return right;
    }

    public void setRight(TreeNodeDto right) {
        this.right = right;
    }
}
