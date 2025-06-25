import java.util.*;

class Solution {
    
    char[] opList;
    char[] op = {'+', '-'};
    int size, ans;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        size = numbers.length;
        opList = new char[size];
        ans = 0;
        comb(0, 0, numbers, target);
        
        return ans;
    }
    
    public void comb(int idx, int sidx, int[] numbers, int target) {
        if (sidx == size) {
            cal(opList, numbers, target);
            return;
        }
        
        for (int i = idx; i < 2; i++) {
            opList[sidx] = op[i];
            comb(idx, sidx+1, numbers, target);
        }
    }
    
    public void cal(char[] opList, int[] numbers, int target) {
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            if (opList[i] == '+') tmp += numbers[i];
            else tmp -= numbers[i];
        }
        
        if (tmp == target) ans++;
    }
}