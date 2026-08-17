import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        StringBuilder org = new StringBuilder(String.valueOf(x));

        if (Long.parseLong(org.toString()) == Long.parseLong(org.reverse().toString())) return true;
        else return false;
    }
}