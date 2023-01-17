import java.util.HashMap;
import java.util.Map;

public class Hashing {

    /* Example 1 : Two Sum

    Given an array of integers nums and an integer target, return indices of two numbers
    such that they add up to target. You cannot use the same index twice.
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            // we need the current num & target - nums[i]
            int aim = target - nums[i];

            // run through map and find aim
            if(map.containsKey(aim)) {
                return new int[] { i, map.get(aim) };
            }
            // if not just add it to map
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

}
