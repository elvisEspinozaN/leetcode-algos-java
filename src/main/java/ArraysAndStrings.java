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

}
