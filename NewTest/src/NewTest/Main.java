package NewTest;

public class Main {

	static ListNode head;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		display();
		
		addFront('A');
		addFront('f');
		addBack('k');
		addFront('1');
		
		display();
		
		remove(2);
		
		display();
		
		remove(0);
		
		display();
		
		remove(1);
		
		display();
	}

	public static boolean isEmpty() {
		return head == null;
	}
	
	public static void addFront(char value) {		
		ListNode newNode = new ListNode();
		newNode.item = value;
		newNode.next = head;
		head = newNode;
	}
	
	public static void addBack(char value) {		
		ListNode newNode = new ListNode();
		newNode.item = value;
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		ListNode cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		
		cur.next = newNode;
	}
	
	public static void remove(int idx) {
		
		if(head == null)
			return;
		
		if(idx == 0) {
			head = head.next;
			return;
		}
		
		ListNode before = head;
		for(int i = 1; i < idx; i++) {
			if(before.next == null)
				return;
			
			before = before.next;
		}
		
		before.next = before.next.next;
	}
	
	public static void display() {
		if(isEmpty()) {
			System.out.println("list is empty\n");
			return;
		}
			
		for(ListNode cur = head; cur != null; cur = cur.next) {
			System.out.print(cur.item + " ");
		}
		
		System.out.println();
		System.out.println();
	}
}
