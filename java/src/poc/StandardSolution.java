package poc;

import java.util.HashMap;

public class StandardSolution {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int mate = target - nums[i];
			if (mate > 0) {
				if (map.containsKey(mate)) {
					return new int[] { map.get(mate), i };
				}
				map.put(nums[i], i);
			}

		}
		return null;
	}

}

//
//Finished
//Runtime: 0 ms
//Your input
//[2,7,11,15]
//9
//Output
//[0,1]
//Expected
//[0,1]
//		