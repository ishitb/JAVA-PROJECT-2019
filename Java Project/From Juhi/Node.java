package com.company;

public class Node{
    int value;
    Node left;
    Node right;
    Node parent;

    Node(int val){
        this.value = val;
        this.right = null;
        this.left = null;
        this.parent = null;
    }
}