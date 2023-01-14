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

}
