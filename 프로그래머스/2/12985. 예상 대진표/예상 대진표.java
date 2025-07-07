class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int aa = Math.min(a, b);
        int bb = Math.max(a, b);
        
        if (aa % 2 == 1 && bb - aa == 1) return answer;

        while (true) {
            if (aa % 2 == 0) {
                aa /= 2;
            } else {
                aa = (aa + 1) / 2;
            }
            
            if (bb % 2 == 0) {
                bb /= 2;
            } else {
                bb = (bb + 1) / 2;
            }
            
            answer++;
            
            if (aa % 2 == 1 && bb - aa == 1) break;
        }
        
        return answer;
    }
}