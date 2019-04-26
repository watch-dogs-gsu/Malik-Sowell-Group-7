//Redghy Jean
//Assignment 5
//Data Structures


import java.util.*;

// This will be where I create class BSTNode

class BSTNode

{

// This creates 2 reference variables left, right to hold left and right sub trees

public BSTNode left,right;

// the variables store the data of node

public int data;

// the default constructor initializes to default values

public BSTNode()

{

left=null;

right = null;

data = 0;

}

// This is the constructor that receives data and constructs the node

public BSTNode(int n)

{

// assigning left and right to null since its a new node

left = null;

right = null;

data = n;

}

}

//  the BStree class

class BSTree

{

// This creates the reference to hold the root node

private BSTNode root;

// default constructor

public BSTree()

{

root = null;

}

// constructs with data

public BSTree(int n)

{

// creating bst node with the given data

root = new BSTNode(n);

}

// constructor which is taking node as argument

public BSTree(BSTNode node)

{

//making the node as root

root = node;

}

// method to insert the received data into tree

public void insert(int n)

{

// calling aux_insert method

root = aux_insert(root,n);

}

// insert method

private BSTNode aux_insert(BSTNode node, int data)

{

// if root is null, construct new node n return as root

if(node == null)

return new BSTNode(data);

// if data is greater than root then travel to right and insert it

if(node.data <= data)

node.right = aux_insert(node.right, data);

else

// if data is less than root then travel to left and insert it

node.left = aux_insert(node.left, data);

return node;

  

}

// method to print inorder

public void inorder()

{

// calling aux_inorder

aux_inorder(root);

System.out.println();

}

// in order will follow principlr Left-Root-Right

private void aux_inorder(BSTNode node)

{

// if given node is null return

if(node==null)

return;

// going to left subtreee

aux_inorder(node.left);

// printing root

System.out.print(node.data+" ");

// going to right subtreee

aux_inorder(node.right);

}

}

