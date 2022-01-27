//Christian Shimko

public class LinkedList {
	
	int size;
	Node head;
	private Node tail;
	
	LinkedList(){
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public void addToEnd(int value) {
		
		Node piece = new Node(value);
		
		if(this.tail != null) {this.tail.setNext(piece);} 	//sets previous tails nextNode to this node
		this.tail = piece;									//declares this node the new tail
		
		if (size < 1) {this.head = piece;}		//sets this node to the head as well as the tail if its the only node 
		else {piece.setNext(this.head);}		//if it is not the only node then its next node will be set to the current head because its a circularly linked list
		
		this.size += 1;//each additional node adds 1 to size
	}
	
	public void addToFront(int value) {
		Node piece = new Node(value);
		
		piece.setNext(this.head);		//sets this nodes head to the current head before renaming the head
		this.head = piece;			//sets as new head
		
		if(size<1) {this.tail = piece;}
		else {this.tail.setNext(piece);}
		
		size += 1;//each additional node adds 1 to size
	}
	
	
	public void addToIndex(int value, int index) {
		Node piece = new Node(value);
		Node previous = this.head;
		Node indexO = null;
		
		for(int i = 1;i < index-2;i++) {
		previous = previous.getNext();
		}								//iterates through the list to find the previous one
		indexO = previous.getNext();
		
		previous.setNext(piece);					//sets the previous next to this node and
		piece.setNext(indexO);						//set this nodes next to the node after which
													//eliminates the one in between
		
		this.size += 1;//each additional node adds 1 to size
	}
	
	
	public void deleteFront() {
		int valueDeleted = this.head.getData();
		this.head = this.head.getNext();
											//sets current heads getNext to the new head which deletes the previous head
		size-= 1;
		System.out.println("Eliminated: #" + valueDeleted);
	}
	
	
	public void deleteIndex(int index) {
		int valueDeleted = 0;
		Node previous = this.head;
		Node post = null;
		
		for(int i = 2; i < index;i++) {
			previous = previous.getNext();		//set previous
		}
		
		post = previous.getNext().getNext(); //set post
		valueDeleted = previous.getNext().getData();
		previous.setNext(post); //sets next for previous and pot which deletes the node in between
		size-= 1;
		System.out.println("Eliminated: #" + valueDeleted);
	}
	
	public void deleteEnd() {
		Node previous = this.head;
		Node post = null;
		
		for(int i = 1; i < this.size - 1 ;i++) {previous = previous.getNext();} 
		
		post = previous.getNext().getNext();
		previous.setNext(post);
		
		size-= 1;
	}
	
	public boolean contains(int Value) {
		Node temp = this.head;
		int data = temp.getData();
		
		if (data == Value) {return true;}
		for(int i = 0; i < size;i++) {
				temp = temp.getNext();
				data = temp.getData();
				if (data == Value) {
					i = size;
				}
		}
		
		if (data == Value) {return true;}
		else{return false;}
	}
	
	//emptys list
	public void empty() {
		this.head = null;
		this.tail = null;
	}
	
	
	//returns string of list
	public String toString() {
		Node temp = this.head;
		String list = " " + temp.getData();
		
		for(int i = 0;i < this.size - 1; i++) {
			temp = temp.getNext();
			list += " - " + temp.getData();
		} 
		
		return list;
	}
	
	
	

}
