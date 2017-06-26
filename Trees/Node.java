public class Node{
	Node left, right;
	
	int data;
	
	public Node(int data){
		this.data = data;
	}
	
	public void insert(int value){
		if(value <= data){
			if(left == null){
				left = new Node(value);
				
			}else{
				left.insert(value);
				
			}	
		}
		else{
			if(right == null){
				right = new Node(value);
				
			}else{
				right.insert(value);
				
			}		
		}
		
	}
	
	
	public void printInOrder(){
		if(left != null){
			left.printInOrder();
			
		}
		System.out.println(data);
		
		if(right != null){
			right.printInOrder();
			
		}
			
	}
	
	public boolean contains(int value){
		if(value  == data){
			
			return true;
			
		}else if(value < data){
			
			return left == null ?  false : left.contains(value);
			
		}else{
			return right == null ?  false : right.contains(value);
		}
		
	}
	
	public static void main(String[] args) {
		Node node = new Node(10);
		
		node.insert(5);
		node.insert(10);
		node.insert(89);
		node.insert(1);
		
		node.printInOrder();
		
		System.out.println("is 8 found:  " + node.contains(8));
	}
}