package SimpleArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleArrayListInt list = new SimpleArrayListInt();
		
		printList(list);
		
		add(list, 3);
		add(list, 7);
		add(list, 1);
		
		printList(list);
		
		add(list, 2);
		add(list, 5);
		add(list, 2);
		add(list, 1);
		add(list, 1);
		
		printList(list);
		
		remove(list, 1);
		remove(list, 1);
		printList(list);
		
		remove(list, 1);
		printList(list);
	}

	public static boolean isEmpty(SimpleArrayListInt list) {
		return list.next == 0;
	}
	
	public static boolean isFull(SimpleArrayListInt list) {
		return list.next == list.data.length;
	}
	
	public static void add(SimpleArrayListInt list, int value) {
		
		if(isFull(list))
			resize(list);
		
		list.data[list.next++] = value; 	
	}
	
	public static void remove(SimpleArrayListInt list, int idx) {
		
		if(isEmpty(list) || idx < 0 || idx >= list.next)
			return;
		
		for(int i = idx; i < list.next - 1; i++) {
			list.data[i] = list.data[i + 1];
		}
		
		list.next--;
	}

	private static void resize(SimpleArrayListInt list) {
		int[] newData = new int[list.data.length * 2];
		
		for (int i = 0; i < list.data.length; i++) {
			newData[i] = list.data[i];
		}
		
		list.data = newData;
	}
	
	public static void printList(SimpleArrayListInt list) {
		System.out.println("List is Empty: " + isEmpty(list));
		System.out.println("List is Full:  " + isFull(list));
		for(int i = 0; i < list.data.length; i++) {
			if(i >= list.next) {
				System.out.print("_ ");
				continue;
			}
			
			System.out.print(list.data[i] + " ");
		}
		System.out.println();
		System.out.println();
	}
}
