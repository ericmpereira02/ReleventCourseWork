
public class Driver {

	
	public static void main(String[] args) {
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();

//		int n=10;
//
//		for (int i = 0; i < n; i++) {
//			tree.insert(i);
//		}
		tree.insert(184);
		tree.insert(185);
		tree.insert(57);
		tree.insert(304);
		tree.insert(434);
		tree.insert(554);
		tree.insert(388);
		tree.insert(511);
		tree.insert(464);
		tree.insert(362);
		tree.insert(215);
		tree.insert(368);
		tree.insert(438);
		tree.insert(165);

		System.out.println(tree);

		System.out.println(tree.checkIfRBPropertySatisfied());

		
		tree.delete(304);
		tree.delete(511);
		tree.delete(165);

		System.out.println(tree);
		System.out.println(tree.checkIfRBPropertySatisfied());

		System.out.println(tree.inorderTreeWalk());
	}
}
