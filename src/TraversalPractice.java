

public class TraversalPractice {
  
  /**
   * Prints the odd values of the nodes in a tree.
   * Each value is printed on a separate line.
   * The nodes are traversed post-order.
   * 
   * @param node The root of the tree to print
   */
  public static void printOddNodes(Node<Integer> node) {
    if (node == null) return;
    printOddNodes(node.left);
    printOddNodes(node.right);

    if (node.value % 2 != 0) {
      System.out.println(node.value);
    }
      
  }


  /**
   * Prints the values of the nodes that have exactly one child in a tree.
   * Each value is printed on a separate line.
   * The nodes are traversed pre-order.
   * 
   * @param <T> The type of value the nodes hold
   * @param node The root of the tree to print
   */
  public static <T> void printNodesWithOneChild(Node<T> node) { //Fredrick
    if (node == null) return;

    // check for one child in both sides
    if ((node.left == null && node.right != null) ||  (node.left != null && node.right == null)) {
        System.out.println(node.value);
    }

    // Recurse on left and right children
    printNodesWithOneChild(node.left);
    printNodesWithOneChild(node.right);
}

     

  
    /**
   * Returns the sum of the values of all nodes in a tree.
   * Edge Case:
   *   Returns 0 if node is null
   *  
   * @param node The root of the tree
   * @return the sum 
   */
  public static int treeSum(Node<Integer> node) {
    
    if(node == null) return 0;
    int sumAllNodes = treeSum(node.left ) + treeSum(node.right) + node.value;

  
    return sumAllNodes;
  }

  /**
   * Returns the maximum value stored in a tree.
   * Assumes all values are positive.
   * Edge case:
   *   Returns 0 if node is null.
   * 
   * @param node The root of the tree
   * @return the max value
   */
  public static int maxVal(Node<Integer> node) { 
    if (node == null) return 0;

      int max = node.value; // right now this is the max then:

    int leftMax = maxVal(node.left); // find max in left
    int rightMax = maxVal(node.right); // find max in right

    if (leftMax > max) {
        max = leftMax;
    }

    if (rightMax > max) {
        max = rightMax;
    }

    return max;
}
  



  /**
   * Returns the number of levels in the tree.
   * Edge cases: 
   *   Returns 0 if node is null, returns 1 if there is only a root with no children.
   * 
   * @param <T> The type of value the nodes hold
   * @param node The root of the tree
   * @return The number of levels in the tree
   */
  public static <T> int numLevels(Node<T> node) { 
    if(node == null) return 0;

    int leftLevels = numLevels(node.left);
    int rightlevels = numLevels(node.right);



    return Math.max(leftLevels, rightlevels)+ 1;
  }



  public static void main(String[] args) { 
    /*
     *         99
     *       /    \
     *     45      82
     *    /  \        \
     *   9   5       16
     */

     // Replace the below line to create a tree 
     // as represented in the diagram above
     Node<Integer> smallTree = new Node<Integer>(99, null, null);// main root, start here
      smallTree.left = new Node<>(45, null, null);   // left child of 99
      smallTree.left.left = new Node<>(9,null, null);//left child of 45
      smallTree.left.right = new Node<>(5, null, null);// right child of 45
      smallTree.right = new Node<>(82, null, null); // right child of 99
      smallTree.right.right = new Node<> (16, null, null); // right child of 82

              
     //System.out.println(treeSum(smallTree));


    /*
     *              42
     *          /       \
     *       17           63
     *      /  \            \
     *     9    21           87
     *    /    /  \          /
     *   3    19   25     76
    */

    Node<Integer> largeTree = new Node<Integer>(42, null, null);
    largeTree.left = new Node<>(17,null, null); // 17 is left child of 42
      largeTree.left.left = new Node<>(9, null, null); // 9 is the left child of 17
      largeTree.left.left.left = new Node<>(3, null, null);// 3 is the left child of 9
                        //null), // no right child of 9
      largeTree.left.right = new Node<>(21,null, null); // 21 is the right child of 17
      largeTree.left.right.left = new Node<>(19, null, null); // 19 is the left child of 21
      largeTree.left.right.right = new Node<>(25, null, null); // 25 is the right child of 21
      largeTree.right = new Node<>(63, null, null); // 63 is right child of 42
                //null, // no left child of 63
      largeTree.right.right = new Node<>(87, null, null);// 87 is right child of 63
      largeTree.right.right.left = new Node<>(76, null, null);// 76 is the left child of 87
                       // null))); // no right child of 87

                  System.out.println(maxVal(largeTree));
  }
}