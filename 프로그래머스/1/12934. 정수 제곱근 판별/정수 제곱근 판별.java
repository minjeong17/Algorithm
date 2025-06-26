class Solution {
    public long solution(long n) {
        double tmp = Math.sqrt(n);
        return tmp == (int) tmp ? ((long) (tmp + 1)) * ((long) (tmp + 1)) : -1;
    }
}