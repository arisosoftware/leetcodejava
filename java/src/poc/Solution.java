package poc;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;
 

public class Solution {
	 
	public int[] twoSum(int[] nums, int target) {

		SortedMap<Integer, Integer> checkedlist = new TreeMap<>();

		int arraylen = nums.length;

		for (int v0 = 0; v0 < arraylen; v0++) {

			Integer mate = target - nums[v0];
			if ((mate > 0) && checkedlist.containsKey(mate)) {
				int[] answer = new int[] { checkedlist.get(mate) , v0 };
				return answer;
			} else {
				checkedlist.put(nums[v0], v0);
			}
		}

		return null;

	}
}
