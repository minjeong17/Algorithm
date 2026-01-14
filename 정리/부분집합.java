public class 부분집합 {

    // 부분집합 : 주어진 집합에서 각 원소를 “포함/미포함”으로 선택해서 만들 수 있는 모든 조합
    // (공집합과 자기 자신 포함)

    static int[] nums = {1, 2, 3, 4, 5};
    static int N = nums.length;

    public static void main(String[] args) {
        // 비트마스킹
        for (int i = 0; i < (1<<N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1<<j)) != 0) {
                    System.out.print(nums[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
