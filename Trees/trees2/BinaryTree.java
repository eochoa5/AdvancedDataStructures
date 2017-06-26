package trees2;

public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String name){
		
		Node newNode  = new Node(key, name);
		
		if(root  == null){
			root = newNode;
		}else{
			
			//if there is a root node, we grab it and focus on it 
			Node focusNode = root;
			
			Node parent;
			
			while(true){
				parent = focusNode; // the root
				
				if(key <focusNode.key){ //put node on left
					
					focusNode = focusNode.leftChild; // left child of the root
					
					if(focusNode == null){ // no left child
						
						parent.leftChild = newNode; /* new node created becomes left child of root, since 
						there's no left child */
						return;
						
					}
					
				}else{//put node on right
					focusNode = focusNode.rightChild;
					
					if(focusNode == null){ // no right child
						
						parent.rightChild = newNode; /* new node created becomes right child of root, since 
						there's no right child */
						return;
						
					}
					
				}
				
			}//end while loop
		}
	}
	
	public boolean contains(int key){
		
		Node focusNode = root; 
		
		while(focusNode.key != key){
			
			focusNode = key < focusNode.key ?  focusNode.leftChild : focusNode.rightChild;
				
			if (focusNode == null)
				return false;
		}
		
		return true;
		
	}
	
	public void inOrderTraverseTree(Node focusNode){
		
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
		
	}
	
	public void preOrderTraverseTree(Node focusNode){
		
		if(focusNode != null){
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
		}
		
	}
	
public void postOrderTraverseTree(Node focusNode){
		
		if(focusNode != null){
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
		
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.addNode(5, "root");
		bt.addNode(3, "second");
		bt.addNode(23, "third");
		bt.addNode(17, "4th");
		bt.addNode(7, "5th");
		
		//bt.inOrderTraverseTree(bt.root);
		//bt.preOrderTraverseTree(bt.root);
		bt.postOrderTraverseTree(bt.root);
		
		System.out.println(bt.contains(3));

	}

}

class Node{
	int key;
	String name; 
	
	Node rightChild;
	Node leftChild;
	
	Node(int key, String name){
		this.key = key;
		this.name = name;
		
	}
	
	public String toString(){
		return name  + " has a key " + key;
	}
}
