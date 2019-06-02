package poc2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class SolutionReviewer {
	/**
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked list.
	 * You may assume the two numbers do not contain any leading zero, except the
	 * number 0 itself. Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0
	 * -> 8 Explanation: 342 + 465 = 807.
	 * 
	 */

	public static void main(String[] args) {
		Solution testerSolution = new Solution();

		StandardSolution standSolution = new StandardSolution();

		int max = 50;
		int min = 1;
		Random rand = new Random();
		boolean testNext = true;
		int round = 1;
		for (int r = 0; r < 2000 && testNext; r++) {

			AnswerSheet data = new AnswerSheet(rand, min, max);

			data.expectResult = standSolution.addTwoNumbers(data.node1, data.node2);
			
			if (data.expectResult != null) {
				data.testerResult = testerSolution.addTwoNumbers(data.node1, data.node2);

				round++;
				//data.ReportError(round);
				
				
				if (data.testerResult != null) {
					ListNode p1 = data.expectResult;
					ListNode p2 = data.testerResult;

					while (p1 != null && p2 != null && p1.val == p2.val) {
						p1 = p1.next;
						p2 = p2.next;
					}
					if (p1 != null || p2 != null) {
					  data.ReportError(round);
						break;
					}
				}

			}

		}

	}

}

class AnswerSheet {
	public ListNode node1;
	public ListNode node2;
	public ListNode expectResult;
	public ListNode testerResult;

	void GenNodelist(Random rnd, int len, ListNode node) {
		ListNode Point = node;
		for (int i = 0; i < len; i++) {
			int digital = rnd.nextInt(10);
			ListNode newnode = new ListNode(digital);
			Point.next = newnode;
			Point = newnode;
		}
	}

	public AnswerSheet(Random rnd, int min, int max) {
		int list1Len = rnd.nextInt((max - min) + 1) + min;
		int list2Len = rnd.nextInt((max - min) + 1) + min;
		this.node1 = new ListNode(rnd.nextInt(10));
		this.node2 = new ListNode(rnd.nextInt(10));

		GenNodelist(rnd, list1Len, this.node1);
		GenNodelist(rnd, list2Len, this.node2);

	}

	void ReportOneList(ListNode node) {
		while (node != null) {
			System.out.printf("%d -> ", node.val);
			node = node.next;
		}
	}

	public void ReportError(int testRound) {

		System.out.printf("Test report %d \n", testRound);

		System.out.println("\nInput 1");
		ReportOneList(this.node1);
		System.out.println("\nInput 2");
		ReportOneList(this.node2);
		
 
		
		
		System.out.println("\nAnswer should be ");
		ReportOneList(this.expectResult);

		System.out.println("\n your answer is ");
		ReportOneList(this.testerResult);

	}

}
