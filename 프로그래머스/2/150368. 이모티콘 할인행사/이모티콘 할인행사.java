import java.util.*;

class Solution {
    public int[] sale = {10, 20, 30, 40};
    public int emoCnt;
    public int[] sel, answer, emoticons;
    public int[][] users;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        
        answer = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        emoCnt = emoticons.length;
        sel = new int[emoCnt];
        perm(0);
        
        return answer;
    }
    
    public void perm(int idx) {
        if (idx == emoCnt) {
            check(sel);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            sel[idx] = sale[i];
            perm(idx+1);
        }
    }
    
    public void check(int[] sel) {
        int[] tmp = new int[2];
        for (int[] user : users) {
            int price = 0;
            for (int i = 0; i < emoCnt; i++) {
                if (sel[i] >= user[0]) {
                    price += emoticons[i] * (100 - sel[i]) / 100;
                }
            }
            
            if (price >= user[1]) {
                tmp[0]++;
            } else {
                tmp[1] += price;
            }
        }
        
        if (tmp[0] > answer[0]) {
            answer[0] = tmp[0];
            answer[1] = tmp[1];
        } else if (tmp[0] == answer[0]) {
            if (tmp[1] > answer[1]) answer[1] = tmp[1];
        }
    }
}