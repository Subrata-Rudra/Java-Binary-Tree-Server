package com.subrata.treeServer.dto;

import java.util.ArrayList;

public class BuildTreeRequestDto {
    private ArrayList<Integer> elements;

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Integer> elements) {
        System.out.println("Elements: " + elements);
        this.elements = elements;
    }
}
