import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int gcdA = arrayA[0];  // arrayA의 최대공약수
        for (int i = 1; i < arrayA.length; i++) {
            int tmp = gcd(gcdA, arrayA[i]);
            gcdA = tmp;
        }
        int gcdB = arrayB[0];  // arrayB의 최대공약수
        for (int i = 1; i < arrayB.length; i++) {
            int tmp = gcd(gcdB, arrayB[i]);
            gcdB = tmp;
        }
        
        List<Integer> listA = new ArrayList<>();
        for (int i = 1; i * i <= gcdA; i++) {
            if (gcdA % i == 0) {
                if (i * i == gcdA) listA.add(i);
                else {
                    listA.add(i);
                    listA.add(gcdA / i);
                }
            }
        }
        List<Integer> listB = new ArrayList<>();
        for (int i = 1; i * i <= gcdB; i++) {
            if (gcdB % i == 0) {
                if (i * i == gcdB) listB.add(i);
                else {
                    listB.add(i);
                    listB.add(gcdB / i);
                }
            }
        }
        
        Collections.sort(listA, (o1, o2) -> o2-o1);
        Collections.sort(listB, (o1, o2) -> o2-o1);
        
        int answer = Integer.MIN_VALUE;
        for (int a : listA) {
            boolean chk = true;
            for (int b : arrayB) {
                if (b % a == 0) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                answer = Math.max(answer, a);
                break;
            }
        }
        for (int b : listB) {
            boolean chk = true;
            for (int a : arrayA) {
                if (a % b == 0) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                answer = Math.max(answer, b);
                break;
            }
        }
        
        if (answer == Integer.MIN_VALUE) return 0;
        return answer;
    }
    
    public int gcd(int x1, int x2) {
        int mx = Math.max(x1, x2);
        int mn = Math.min(x1, x2);
        
        while (true) {
            int tmp = mx % mn;
            if (tmp == 0) return mn;
            else {
                mx = mn;
                mn = tmp;
            }
        }
    }
}