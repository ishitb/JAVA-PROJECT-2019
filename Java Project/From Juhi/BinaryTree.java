package com.company;

public class BinaryTree {

    Node root = new Node(Integer.MAX_VALUE);


    public void insert(Node root, int val){
        Node node = new Node(val);
        if (root.value == Integer.MAX_VALUE){
            this.root = node;
            System.out.println("Root: " + this.root.value + " Node:" + node.value + "\n");
        }
        else if(root.value>val){
            if(root.left == null){
                root.left = node;
                node.parent = root;
            }
            else{
                insert(root.left,val);
            }
        }
        else if(root.value<val){

            if(root.right == null){
                root.right = node;
                node.parent = root;
            }
            else{
                insert(node.right,val);
            }

        }

    }

    public static Node search(Node root, int val){
        if(root == null){
            Main.found = false;
            Node n = null;
            System.out.print("Element not found\n");
            return n;
        }

        else if(root.value == val){
            Main.found = true;
            System.out.println("Element was found\n");
            return root;
        }
        else if(root.value>val){
            search(root.left, val);
        }
        else if(root.value<val){
            search(root.right, val);
        }
//        if(Main.found == true){
//            System.out.print("Element was found\n");
//        }
        return root;
    }

    public static void delete(Node root, int val){
        Node test = search(root, val);
        Node par = new Node(0);
        par = test.parent;
        //TODO: idk wtf
//        if(par.left == test){
//            if(par.left)
//        }

    }



}



