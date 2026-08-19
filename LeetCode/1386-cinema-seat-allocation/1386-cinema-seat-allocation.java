import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int answer = 0;

        Arrays.sort(reservedSeats, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int[] seatReserved = new int[3];
        Arrays.fill(seatReserved, 1);
        int num = 1;
        for (int[] seat : reservedSeats) {
            if (seat[0] != num) {
                if (seatReserved[0] + seatReserved[1] + seatReserved[2] == 3) answer += 2;
                else if (seatReserved[0] + seatReserved[1] + seatReserved[2] == 2) {
                    if (seatReserved[1] == 0) answer += 2;
                    else answer += 1;
                } else answer += seatReserved[0] + seatReserved[1] + seatReserved[2];
                answer += (seat[0] - num - 1) * 2;
                num = seat[0];
                Arrays.fill(seatReserved, 1);
            }

            if (seat[1] >= 2 && seat[1] <= 5) seatReserved[0] = 0;
            if (seat[1] >= 4 && seat[1] <= 7) seatReserved[1] = 0;
            if (seat[1] >= 6 && seat[1] <= 9) seatReserved[2] = 0;
        }

        if (seatReserved[0] + seatReserved[1] + seatReserved[2] == 3) answer += 2;
        else if (seatReserved[0] + seatReserved[1] + seatReserved[2] == 2) {
            if (seatReserved[1] == 0) answer += 2;
            else answer += 1;
        } else answer += seatReserved[0] + seatReserved[1] + seatReserved[2];

        if (n > reservedSeats[reservedSeats.length-1][0]) answer += (n - reservedSeats[reservedSeats.length-1][0]) * 2;

        return answer;
    }
}