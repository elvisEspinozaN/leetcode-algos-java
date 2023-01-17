import java.util.*;

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

    /* Example 2351 : First Letter to Appear Twice

    Given a string s, return the first character to appear twice. It is guaranteed that
    the input will have a duplicate character.
     */

    public char repeatedCharacter(String s) {

        Set<Character> hs = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {

            if(hs.contains(s.charAt(i))) {
                return s.charAt(i);
            }
            hs.add(s.charAt(i));
        }

        return ' ';

    }

    /* Example 1: Given an integer array nums,
    find all the numbers x that satisfy the following: x + 1 is not in nums, and x - 1 is not in nums.

     */

    public List<Integer> findNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> hs = new HashSet<>();

        for(int n : nums) {
            hs.add(n);
        }

        for(int i : nums) {
            if(!hs.contains(i + 1) && !hs.contains(i - 1)) {
                answer.add(i);
            }
        }

        return answer;
    }

    /* Check if the Sentence Is Pangram

    A pangram is a sentence where every letter of the English alphabet appears at least once.

    Given a string sentence containing only lowercase English letters,
    return true if sentence is a pangram, or false otherwise.
     */

    public boolean checkIfPangram(String s) {

        Set<Character> hs = new HashSet<>();

        for(char c : s.toCharArray()) { // as long as all characters appear
            hs.add(c);
        }

        return hs.size() == 26; // size adds up to 26
    }

    /* Missing Number

    Given an array nums containing n distinct numbers in the range [0, n],
    return the only number in the range that is missing from the array.

    Example :
    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
    2 is the missing number in the range since it does not appear in nums.
    */

    public int missingNumber(int[] nums) {

        Set<Integer> hs = new HashSet<>();

        for(int i : nums) {
            hs.add(i);
        }

        for(int i = 0; i < nums.length + 1; i++) {
            if(!hs.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    /* Counting Elements

    Given an integer array arr, count how many elements x there are,
    such that x + 1 is also in arr. If there are duplicates in arr, count them separately.
     */

    public int countElements(int[] arr) {

        Set<Integer> hs = new HashSet<>();
        int answer = 0;

        for(int i : arr) {
            hs.add(i);
        }

        for(int i = 0; i < arr.length; i++) {
            if(hs.contains(arr[i] + 1)) {
                answer++;
            }
        }

        return answer;
    }

    /* Example 1: You are given a string s and an integer k. Find the length of the
    longest substring that contains at most k distinct characters.

    For example, given s = "eceba" and k = 2, return 3. The longest substring with at
    most 2 distinct characters is "ece".
     */

    public int findLongestSubstring(String s, int k) {
        // sliding window technique
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0, answer = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // default is 0, if found add the value of appearances
            counts.put(c, counts.getOrDefault(c, 0) + 1);

            while(counts.size() > k) { // constraint
                char remove = s.charAt(left);
                // at an attempt to contract window
                // remove the amount of appearances
                counts.put(remove, counts.getOrDefault(remove, 0) - 1);

                // no longer appears, remove then letter from the map
                if(counts.get(remove) == 0) {
                    counts.remove(remove);
                }

                // contract window
                left++;
            }

            // importnat formula to get the size of substring!!!!!
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

}
