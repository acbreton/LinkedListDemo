public class LinkedListDemo {
	public static void main(String[] args){
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		String[] arr = alphabet.split("");

		LinkedList myLinkedList = new LinkedList();

		for(int i = 0; i < arr.length; i++){
			myLinkedList.append(arr[i]);
		}
		System.out.println(myLinkedList.size());
		myLinkedList.findNode("m");
	}

	public static class Node {
		String letter;
		Node next;
		Node previous;
		public Node(String data) {
			this.letter = data;
		}
	}

	public static class LinkedList {
		public Node head;

		public LinkedList(){
			this.head = null;
		}

		public void append(String letter){
			if(head == null) {
				head = new Node(letter);
				return;
			}

			Node current = head;
			while(current.next != null){
				current = current.next;
			}

			Node newNode = new Node(letter);
			current.next = newNode;
		}

		public void prepend(String letter){
			Node newHead = new Node(letter);
			newHead.next = head;
			head = newHead;
		}

		public void delete(String letter){
			if(head == null) return;
			Node current = head;
			if(current.letter == letter) {
				head = current.next;
				return;
			}

			while(current.next != null){
				if(current.next.letter == letter){
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
		}

		public int size(){
			if(this.head == null) return 0;

			int count = 1;
			Node current = this.head;

			while(current.next != null) {
				count++;
				current = current.next;
			}
			return count;
		}

		public Node findNode(String letterToFind) {
			if(this.head == null) return null;

			Node current = this.head;

			while(current.next != null){
				if(current.letter.equals(letterToFind)){
					System.out.println(current.letter);
					System.out.println(current.next.letter);
					break;
				}
				current = current.next;
			}
			return current;
		}
	}
}