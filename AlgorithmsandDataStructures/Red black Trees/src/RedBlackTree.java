/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 8, RedBlackTree
 */

import java.util.Stack;
/**
 * Creates a red and black tree data strutcture
 * @author ahaggard2013
 *
 * @param <Key>
 */
public  class RedBlackTree<Key extends Comparable<Key>>{

	/**
	 * true used to represent RED
	 */
	private static final boolean RED = true;
	/**
	 * false used to represent BLACK
	 */
	private static final boolean BLACK = false;
	/**
	 * root of tree
	 */
	private Node root;	 // pointer to the root
	/**
	 * used to print traversal
	 */
	private String inOrderTrav = ""; // holds in order traversal order
	/**
	 * helper class to create nodes
	 * @author ahaggard2013
	 *
	 */
	private class Node{

		Node parent;
		Node left;
		Node right;
		Key key;

		boolean color;  // true - red, false - black


		Node(Key key_){
			this.key=key_;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
		/**
		 * 
		 * @return
		 */
		public int getMaxBlackNodes(){
			// calculate maximum number of the black nodes on the path to the leaf

			int leftCount=0,rightCount=0;

			if (this.left!=null) {
				if (this.left.color==false) {
					leftCount+=1;
				}
				leftCount+=this.left.getMaxBlackNodes();
			}

			if (this.right!=null) {
				if (this.right.color==false) {
					rightCount+=1;
				}
				rightCount+=this.right.getMaxBlackNodes();
			}


			return Math.max(leftCount, rightCount);
		}
		/**
		 * 
		 * @return
		 */
		public Key getKey(){
			return key;
		}

		public String toString(){
			String result="";
			if (color) {
				result+=key.toString()+"_r";
			}else{
				result+=key.toString()+"_b";
			}
			return result;
		}


	}
	/**
	 * strips children from nodes needed in rotations
	 * @param temp original
	 * @param temp1 new node
	 */
	private void fixNode(Node temp, Node temp1){ // cleans up node being moved
		if (temp.parent == null) {
			this.root = temp1;
		} else {
			if (temp == temp.parent.left)
				temp.parent.left = temp1;
			else temp.parent.right = temp1;
		}
		if (temp1 != null) {
			temp1.parent = temp.parent;
		}
	}
	/**
	 * rotates nodes left
	 * @param temp node to rotate at
	 */
	private void leftRotate(Node temp) { //rotate node left
		if (temp == null)
			return;
		Node temp1 = temp.right;
		fixNode(temp, temp1);
		temp.right = temp1.left;
		if(temp1.left != null) {
			temp1.left.parent = temp;
		}
		temp1.left = temp;
		temp.parent = temp1;
		
	}
	/**
	 * rotates node right
	 * @param temp node to rotate
	 */
	private void rightRotate(Node temp) { //rotate node right
		if (temp == null)
			return;
		Node temp1 = temp.left;
		fixNode(temp, temp1);
		temp.left = temp1.right;
		if(temp1.right != null) {
			temp1.right.parent = temp;
		}
		temp1.right = temp;
		temp.parent = temp1;
	}
	/**
	 * fixes first case while inserting 
	 * @param temp node being inserted
	 */
	private void case1(Node temp) { //reassigns color in the instance of case 1 right
		if (temp.parent == null)
			temp.color = BLACK;
		else case2(temp);
}
	/**
	 * fixes second case while inserting 
	 * @param temp node being inserted
	 */
	private void case2(Node temp) { //rotate left in instance of case 2
		if (checkColor(getParent(temp)) == BLACK)
			return;
		else
			case3(temp);
	}
	/**
	 * fixes third case while inserting 
	 * @param temp node being inserted
	 */
	private void case3(Node temp) { //rotate right in the instance of case 3
		if(checkColor(getSibling(getParent(temp))) == RED) {
			temp.parent.color = BLACK;
			getSibling(getParent(temp)).color = BLACK;
			getGrandparent(temp).color = RED;
			case1(getGrandparent(temp));
		} else case4(temp);
	}
	/**
	 * fixes fourth case while inserting 
	 * @param temp node being inserted
	 */
	private void case4 (Node temp) { // fixes case 5
		if (temp == getRight(getParent(temp)) && getParent(temp) == getLeft(getGrandparent(temp))) {
			leftRotate(getParent(temp));
			temp = getLeft(temp);
		} else if( temp == getLeft(getParent(temp)) && getParent(temp) == getRight(getGrandparent(temp))) {
			rightRotate(getParent(temp));
			temp = getRight(temp);
		}
		case5(temp);
	}
	/**
	 * fixes fifth case while inserting 
	 * @param temp node being inserted
	 */
	private void case5(Node temp) { // fixes case 6
		getParent(temp).color = BLACK;
		getGrandparent(temp).color = RED;
		if (temp == getLeft(getParent(temp)) && getParent(temp) == getLeft(getGrandparent(temp))) {
			rightRotate(getGrandparent(temp));
		}
		else leftRotate(getGrandparent(temp));
	}
	/**
	 * checks what color to avoid null pointer ex.
	 * @param temp node to check color
	 * @return color
	 */
	private boolean checkColor(Node temp) { //checks color to be able to include NIL
		
		try {
			temp.color = temp.color;
		} catch (NullPointerException e) {
			return BLACK;
		}
		return temp.color;
	}
	/**
	 * gets grandparent to avoid null pointer ex.
	 * @param temp node to get gp from
	 * @return grand parent
	 */
	private Node getGrandparent(Node temp) { // gets grandparent
		if (temp == null || temp.parent == null)
			return null;
		else return temp.parent.parent;
	}
	/**
	 * gets node sibling to avoid null pointer ex
	 * @param temp node to get sibling from
	 * @return sibling
	 */
	private Node getSibling(Node temp) { // gets sibling
		if (temp == null || temp.parent == null)
			return null;
		else if (temp == temp.parent.left)
			return temp.parent.right;
		else return temp.parent.left;
	}
	/**
	 * gets right node
	 * @param temp node to get right
	 * @return right node
	 */
	private Node getRight(Node temp) { // gets right node
		if (temp == null) 
			return null;
		else return temp.right;
	}
	/**
	 * gets nodes parent
	 * @param temp node to get parent from
	 * @return nodes parent
	 */
	private Node getParent(Node temp) { // gets parent node
		if (temp == null) {
			return null;
		}
		
		else return temp.parent;
	}
	/**
	 *  gets left node
	 * @param temp node to get left from
	 * @return left node
	 */
	private Node getLeft(Node temp) { // gets left node
		if (temp == null)
			return null;
		else return temp.left;
	}
	/**
	 * fixes issues created with normal insertion
	 * @param temp node that was inserted
	 */
	private void fixProperties(Node temp) {// fixes insertion problems

		case1(temp);
	}
	/**
	 * inserts node into tree
	 * @param key key to insert
	 */
	public void insert(Key key) { // inserts node into tree
		// insert key into the tree
		Node temp = new Node(key);
		if (this.root == null) { //if tree is empty
			this.root = temp;
			this.root.color = BLACK;
			return;
		}
		temp.color = RED;
		Node finder = this.root;
		while (true) {
			if (temp.key.compareTo(finder.key) < 0) {
				if (finder.left == null) {
					finder.left = temp;
					break;
				}
				else finder = finder.left;
			}
			else if(temp.key.compareTo(finder.key) > 0) {
				if (finder.right == null) {
					finder.right = temp;
					break;
				}
				else finder = finder.right;
			}
		}
		temp.parent = finder;
		fixProperties(temp);
	}
	/**
	 * deletes key from tree (isn't working for your test cases)
	 * @param key key to delete
	 */
	public void delete(Key key) { // deletes key
		// delete key from the tree
	Node toDelete = new Node(key);
	toDelete = find(this.root, toDelete);
		if (getLeft(toDelete) != null && getRight(toDelete) != null	) {
			Node large = findMaximum(getLeft(toDelete));
			toDelete = large;
		}
		if (checkColor(toDelete) == BLACK) {
			toDelete.color = (getLeft(toDelete)!= null) ? checkColor(getLeft(toDelete)) : checkColor(getRight(toDelete));
			del1(toDelete);
		}
		fixNode(toDelete, (getLeft(toDelete)!= null) ? getLeft(toDelete) : getRight(toDelete));
	}
	/**
	 * fixes case 1 created by deletion
	 * @param temp node passed down to fix from
	 */
	private void del1 (Node temp) {
		if (getParent(temp) == null)
			return;
		else
			del2(temp);
	}
	/**
	 * 	 * fixes case 2 created by deletion
	 * @param temp node passed down to fix from
	 */
	private void del2 (Node temp) {
		if (checkColor(getSibling(temp)) == RED) {
			getParent(temp).color = RED;
			getSibling(temp).color = BLACK;
			if (temp == getLeft(getParent(temp)))
				leftRotate(getParent(temp));
			else
				rightRotate(getParent(temp));
		}
		del3(temp);
	}
	/**
	 * 	 * fixes case 3 created by deletion
	 * @param temp node passed down to fix from
	 */
	private void del3 (Node temp) {
		if (checkColor(getParent(temp)) == BLACK && checkColor(getSibling(temp)) == BLACK && checkColor(getLeft(getSibling(temp))) == BLACK && checkColor(getRight(getSibling(temp))) == BLACK) {
			getSibling(temp).color = RED;
			del1(getParent(temp));
		}
		else del4(temp);
	}
	/**
	 * 	 * fixes case 4 created by deletion
	 * @param temp node passed down to fix from
	 */
	private void del4(Node temp) {
		if (checkColor(getParent(temp)) == BLACK && checkColor(getSibling(temp)) == BLACK && checkColor(getLeft(getSibling(temp))) == BLACK && checkColor(getRight(getSibling(temp))) == BLACK) {
			getSibling(temp).color = RED;
			getParent(temp).color = RED;
		}
		else del5(temp);
	}
	/**
	 * 	 * fixes case 5 created by deletion
	 * @param temp node passed down to fix from
	 */
	private void del5(Node temp) {
		
		if (temp == getLeft(getParent(temp)) && checkColor(getSibling(temp)) == BLACK && checkColor(getLeft(getSibling(temp))) == RED && checkColor(getRight(getSibling(temp))) == BLACK) {
			getSibling(temp).color = RED;
			getLeft(getSibling(temp)).color = BLACK;
			rightRotate(getSibling(temp));
		}
		else if (temp == getRight(getParent(temp)) && checkColor(getSibling(temp)) == BLACK && checkColor(getRight(getSibling(temp))) == RED && checkColor(getLeft(getSibling(temp))) == BLACK) {
			getSibling(temp).color = RED;
			getRight(getSibling(temp)).color = BLACK;
			leftRotate(getSibling(temp));
		}
		del6(temp);
	}
	/**
	 * 	 * fixes case 6 created by deletion
	 * @param temp node passed down to fix from
	 */
	private void del6(Node temp) {
		getSibling(temp).color = checkColor(getParent(temp));
		getParent(temp).color = BLACK;
		if (temp == getLeft(getParent(temp))) {
			getRight(getSibling(temp)).color = BLACK;
			leftRotate(getParent(temp));
		}
		else {
			getLeft(getSibling(temp)).color = BLACK;
			rightRotate(getParent(temp));
		}
	}
	/**
	 * Finds smallest key in tree
	 * @return smallest value
	 */
	public Key findMinimum() { //finds smallest key in tree
		Node temp = this.root;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.key;
	}
	/**
	 * finds largest key in tree
	 * @return largest value in tree
	 */
	public Key findMaximum() { // finds largest value in tree
		// find maximum
		Node temp = this.root;
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.key;
	}
	/**
	 * finds max value from specified root
	 * @param temp1 root to find largest value from
	 * @return largest value in specified tree
	 */
	private Node findMaximum(Node temp1) { //finds largest value in tree specified from passed in root
		// find maximum
		Node temp = temp1;
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}
	/**
	 * preforms and inorder tree walk and places String int value linked to tree
	 * @return values of inorder tree walk
	 */
	public String inorderTreeWalk() { // return string representing inorder tree walk
		walk(this.root);
		String result = this.inOrderTrav;
		this.inOrderTrav = "";
		return result;
	}
	/**
	 * 
	 * @param temp finds a specified value in the tree
	 * @param toFind this is the value to find in the tree
	 * @return value searched for or null
	 */
	private Node find(Node temp, Node toFind) { // finds a certain value in the tree
		Node finder = temp;
		if (temp != null) {
			if (toFind.key.compareTo(finder.key) == 0) {
				return temp;
			}
			else {
				Node node = find(finder.left, toFind);
				if (node == null) {
					node = find(finder.right, toFind);
				}
				return node;
			}
		} else
			return null;
			
	}
	/**
	 * walks through the tree, this is used for the inorder traversal
	 * @param walker node that walks trhough the tree
	 */
	private void walk(Node walker) { // used for inorder traversal
		if (walker != null) {
			walk(walker.left);
			this.inOrderTrav += walker.key.toString() + " ";
			walk(walker.right);
		}
	}
	/**
	 * to string method
	 */
	public String toString(){
		// return level-order traversal of the tree. works well only for small trees with at most 8 nodes
		// this function might be helpful for debugging
		
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(this.root);	
		int emptyLeaf = 32;
		boolean isRowEmpty = false;

		String result="";
		while(isRowEmpty==false)
		{

			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			for(int j=0; j<emptyLeaf; j++)
				result+=' ';
			while(globalStack.isEmpty()==false)
			{
				Node temp = globalStack.pop();
				if(temp != null)
				{

					result+="["+temp+" ] ";
					localStack.push(temp.left);
					localStack.push(temp.right);
					if(temp.left != null ||temp.right != null)
						isRowEmpty = false;
				}
				else
				{
					result+="--";
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<emptyLeaf*2-2; j++)
					result+=' ';
			}
			result+="\n";
			emptyLeaf /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}

		return result;
	}
	/**
	 * checks if RB properties are sound.. already implemented
	 * @return true or false value
	 */
	public boolean checkIfRBPropertySatisfied(){
		boolean satisfied=true;

		// check if the root is black
		satisfied=satisfied & (this.root.color==false);

		// check property 4
		satisfied=satisfied & RBProperty4(root);

		// check property 3
		satisfied=satisfied & RBProperty3(root);

		return satisfied;
	}

	/**
	 * used to check RB properties
	 * @param node node to pass in
	 * @return true or false value
	 */
	private boolean RBProperty3(Node node){
		boolean satisfied=true;

		int leftCount=0;
		if (node.left!=null) {
			if (node.left.color==false) {
				leftCount++;
			}
			leftCount+=node.left.getMaxBlackNodes();
		}

		int rightCount=0;
		if (node.right!=null) {
			if (node.right.color==false) {
				rightCount++;
			}
			rightCount+=node.right.getMaxBlackNodes();
		}

		satisfied=((leftCount-rightCount)==0);

		if (!satisfied) {
			System.out.println("Left is: "+leftCount+" Right is: "+rightCount);
		}

		return satisfied;
	}
	/**
	 * used to check RB properties
	 * @param node node to pass in
	 * @return true or false value
	 */
	private boolean RBProperty4(Node node){
		boolean satisfied=true;

		if (node.color==true) {
			if (node.left!=null) {
				if (!node.left.color==false) {
					satisfied=false;
				}
			}

			if (node.right!=null) {
				if (!node.right.color==false) {
					satisfied=false;
				}
			}
		}

		// recursive calls for left and right subtree
		if (node.left!=null) {
			satisfied=satisfied & RBProperty4(node.left);
		}

		if (node.right!=null) {
			satisfied=satisfied & RBProperty4(node.right);
		}

		return satisfied;
	}
}
