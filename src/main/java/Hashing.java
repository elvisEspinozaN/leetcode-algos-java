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

}
