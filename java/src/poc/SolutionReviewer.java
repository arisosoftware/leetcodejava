package poc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SolutionReviewer {
	/**
	 * 
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number. The function twoSum should return indices of the two
	 * numbers such that they add up to the target, where index1 must be less than
	 * index2. Please note that your returned answers (both index1 and index2) are
	 * not zero-based. Input: numbers={2, 7, 11, 15}, target=9 Output: index1=0,
	 * index2=1
	 * 
	 * 要注意map.put要放在for末尾，对于case[3, 3], target=6的情况，如果放在开头会覆盖第一个3
	 * 
	 * The optimal solution to solve this problem is using a HashMap. For each
	 * element of the array, (target-nums[i]) and the index are stored in the
	 * HashMap.
	 * 
	 */
	public static void main(String[] args) {
		Solution answerSolution = new Solution();

		StandardSolution standSolution = new StandardSolution();

		int max = 50;
		int min = 1;
		Random rand = new Random();
		boolean testNext = true;
		int round = 1;
		for (int r = 0; r < 2000 && testNext; r++) {
			int arraylen = rand.nextInt((max - min) + 1) / 2 + min;
			AnswerSheet data = new AnswerSheet(arraylen, rand, min, max);
			if (r == 0) {
				data.inputNum = new int[] { 2, 7, 11, 15 };
				data.target = 9;
			}

			data.stand = standSolution.twoSum(data.inputNum, data.target);
			if (data.stand != null) {
				data.tester = answerSolution.twoSum(data.inputNum, data.target);

				round++;
				if (data.tester != null) {
					for (int v = 0; v < data.stand.length; v++) {
						if (data.stand[v] != data.tester[v] || v >= data.tester.length) {
							System.out.printf("Error in testcase round %d \n", round);
							data.ReportToConsole(round);
							testNext = false;
							break;
						}
					}
				}

			}

		}

	}

}

class AnswerSheet {
	public int inputNum[];
	public int target;

	public int tester[];
	public int stand[];

	public AnswerSheet(int arraylen, Random rnd, int min, int max) {

		inputNum = new int[arraylen];

		for (int i = 0; i < arraylen; i++) {
			int randomNum = rnd.nextInt((max - min) + 1) + min;
			inputNum[i] = randomNum;
			if (i > 0) {
				inputNum[i] = inputNum[i] + inputNum[i - 1];
			}
		}

		// Arrays.sort(inputNum);
		int index1 = rnd.nextInt(arraylen);
		if (index1 == arraylen)
			index1 = arraylen - 1;
		int index2 = arraylen - index1;
		if (index2 == arraylen)
			index2 = arraylen - 1;

		// System.out.printf("%d %d %d \n", index1, index2, arraylen);
		target = inputNum[index1] + inputNum[index2];
		boolean changed = false;
		do {
			changed = false;
			for (int v0 = 0; v0 < arraylen; v0++) {
				for (int v1 = v0 + 1; v1 < arraylen; v1++) {
					if (inputNum[v0] + inputNum[v1] == target && (v1 != index1 && v1 != index2)) {
						inputNum[v1] = inputNum[v1] + 1;
						changed = true;
					}
				}
			}
		} while (changed);

	}

	public void ReportToConsole(int testRound) {

		System.out.printf("Test report %d \n", testRound);

		System.out.println("Input ");
		for (int pp = 0; pp < inputNum.length; pp++) {
			System.out.printf("%d ", inputNum[pp]);
		}
		System.out.printf("\nTarage %d \n ", target);
		System.out.println("Answer should be ");
		for (int pp = 0; pp < stand.length; pp++) {
			System.out.printf("%d ", stand[pp]);
		}

		for (int pp = 0; pp < stand.length; pp++) {
			System.out.printf(" (%d) ", inputNum[stand[pp]]);
		}

		System.out.println("\nbut your answer is ");
		for (int pp = 0; pp < tester.length; pp++) {
			System.out.printf("%d ", tester[pp]);
		}
		for (int pp = 0; pp < tester.length; pp++) {
			System.out.printf(" (%d) ", inputNum[tester[pp]]);
		}

	}

}
