class Solution {
    public String solution(String new_id) {
        
        // 1 ~ 4
        new_id = new_id.toLowerCase()
                       .replaceAll("[^a-zA-Z0-9\\-_\\.]", "")
                       .replaceAll("\\.{2,}", ".")
                       .replaceAll("^\\.|\\.$", "");
        
        // 5
        new_id = new_id.length() == 0 ? "a" : new_id;

        // 6
        new_id = new_id.substring(0, Math.min(15, new_id.length()))
                       .replaceAll("\\.$", "");

        // 7
        if (new_id.length() <= 2) {
            char last = new_id.charAt(new_id.length()-1);
            while (new_id.length() < 3) {
                new_id += last;
            }
        }
        
        return new_id;
    }
}