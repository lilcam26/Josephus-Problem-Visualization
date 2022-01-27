//Christian Shimko

public class Node {
	
	private int data;
	private Node next; //the node ahead of the current node used to link together the list

	Node(int value){
		this.data = value;
		Node next = null;
	}
	
	public Node getNext() {return this.next;}
	
	public void setNext(Node next) {this.next = next;}
	
	public int getData() {return this.data;}
	
	
}
