class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long minT = time[0];
        for (int t : time) minT = Math.min(minT, t);

        long left = 0;
        long right = totalTrips * minT;
        while (left < right) {
            long mid = (left + right) / 2;

            long tmp = 0L;
            for (int t : time) {
                tmp += (long) mid / t;
            }

            if (tmp >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;   
    }
}