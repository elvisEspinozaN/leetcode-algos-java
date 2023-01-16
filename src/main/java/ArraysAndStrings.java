import java.util.ArrayList;
import java.util.List;

public class ArraysAndStrings {


    /* Reverse String

    Write a function that reverses a string. The input string is given as
    an array of characters s.
    You must do this by modifying the input array in-place with 0(1) extra memory.

    Example :
    Input: s = ["h","e","l","l","o"]
    Output:    ["o","l","l","e","h"]
     */

    public void reverseString(char[] s) {
        // we can attempt to use a two pointer approach, allowing us to
        // use the same array

        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            char leftTemp = s[left];
            s[left++] = s[right];
            s[right--] = leftTemp;
        }

        System.out.println(s);

    }

    /* Squares of a Sorted Array

    Given an integer array nums sorted in non-decreasing order, return an array of the
    squares of each number sorted in non-decreasing order.

    Example 1 :
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
     */

    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] answer = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            int square;

            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                square = nums[left];
                left++;
            } else {
                square = nums[right];
                right--;
            }

            answer[i] = square * square;
        }

        return answer;
    }

    /* Check if Palindrome

    Example 1 :  Return true if a given string is a palindrom, false otherwise.
    That means, after reversing it, it is still the same string.
    For example: "abcdcba", or "racecar".
     */

    public boolean checkIfPalindrome(String s) {
        // simple two pointer approach, check to see if each
        // character equals one another

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }

            right--;
            left++;
        }

        return true;
    }

    /* Check for Target

    Example 1: Given a sorted array of unique integers and a target integer,
    return true if there exists a pair of numbers that sum to target, false otherwise.
    This problem is similar to Two Sum.

    For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13,
    return true because 4 + 9 = 13.
     */

    public boolean checkForTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {

            int current = nums[left] + nums[right];

            if(current == target) {
                return true;
            }

            if(current > target) {
                right--;
            } else {
                left++;
            }

        }

        return false;
    }

    /* Example 1: Given two sorted integer arrays, return an array that combines
    both of them and is also sorted.
     */

    public List<Integer> combine(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<Integer>();

        int one = 0, two = 0; // we can run through both arrays

        while(one < arr1.length && two < arr2.length) {

            if(arr1[one] > arr2[two]) {
                answer.add(arr2[two]); // add the lowest number of the compared integers
                two++;
            } else {
                answer.add(arr1[one]);
                one++;
            }

            // finish adding in the remaining numbers
            while(one < arr1.length) {
                answer.add(arr1[one]);
                one++;
            }

            while(two < arr2.length) {
                answer.add(arr2[two]);
                two++;
            }
        }

        return answer;
    }

    /* Example 392 : Is Subsequence.

    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by
    deleting some (can be none) of the characters without disturbing the relative positions of
    the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     */

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()) {

            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    /* Maximum Average Subarray I

    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value
    and return this value.
     */

    public double findMaxAverage(int[] nums, int k) {
        // use sliding window technique, have a window of the length of k
        // evaluate the elements to find the answer needed

        double current = 0;

        for(int i = 0; i < k; i++) {
            current += nums[i];
        }

        double answer = current;

        for(int i = k; i < nums.length; i++) {
            current += nums[i] - nums[i - k]; // decrease window by its beginning point;
            answer = Math.max(current, answer);
        }

        return answer / k;

    }

}
