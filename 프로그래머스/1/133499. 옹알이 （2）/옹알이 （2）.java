class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String word : babbling) {
            boolean check = true;
            int len = word.length();
            String prev = "";
            for (int i = 0; i < len; ) {
                if (word.charAt(i) == 'a' && "aya".equals(word.substring(i, Math.min(i+3, len)))) {
                    if ("aya".equals(prev)) {
                        check = false;
                        break;
                    } else {
                        prev = "aya";
                        i += 3;
                    }
                } else if (word.charAt(i) == 'y' && "ye".equals(word.substring(i, Math.min(i+2, len)))) {
                    if ("ye".equals(prev)) {
                        check = false;
                        break;
                    } else {
                        prev = "ye";
                        i += 2;
                    }
                } else if (word.charAt(i) == 'w' && "woo".equals(word.substring(i, Math.min(i+3, len)))) {
                    if ("woo".equals(prev)) {
                        check = false;
                        break;
                    } else {
                        prev = "woo";
                        i += 3;
                    }
                } else if (word.charAt(i) == 'm' && "ma".equals(word.substring(i, Math.min(i+2,len)))) {
                    if ("ma".equals(prev)) {
                        check = false;
                        break;
                    } else {
                        prev = "ma";
                        i += 2;
                    }
                } else {
                    check = false;
                    break;
                }
            }
            
            if (check) {
                answer++;
                System.out.println(word);
            }
        }
        return answer;
    }
}