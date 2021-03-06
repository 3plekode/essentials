// A linked list node
class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class Floyd {
	// Function to detect Cycle in a linked list using
	// Floyd’s Cycle Detection Algorithm
	public static boolean detectCycle(Node head) {
		// take two references - slow and fast
		Node slow = head, fast = head;

		while (fast != null && fast.next != null) {
			// move slow by one
			slow = slow.next;

			// move fast by two
			fast = fast.next.next;

			// if they meet any any node, linked list contains a cycle
			if (slow == fast) {
				return true;
			}
		}

		// we reach here if slow & fast do not meet
		return false;
	}

	// Detect Cycle in a linked list using Floyd’s Cycle Detection Algorithm
	public static void main(String[] args) {
		// input keys
		int[] keys = { 1, 2, 3, 4, 5 };

		Node head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}

		// insert cycle
		head.next.next.next.next.next = head.next.next;

		if (detectCycle(head)) {
			System.out.println("Cycle Found");
		} else {
			System.out.println("No Cycle Found");
		}
	}
}
