import java.util.LinkedList;
import java.util.List;

class SolutionTest {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:");
    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

//    char[] cur = null;
//    List<String> list = new LinkedList<>();
//    public List<String> generateParenthesis(int n) {
//        cur = new char[n];
//        recallParenthesis(0, 0, 0);
//        return list;
//    }
//
//    private void recallParenthesis(int n, int leftNum, int rightNum) {
//        if (leftNum == cur.length -1 && rightNum == cur.length - 1)  {
//            list.add(new String(cur));
//            return;
//        }
//        if (leftNum == cur.length - 1 && rightNum != cur.length - 1)  {
//            cur[n] = ')';
//            recallParenthesis(n + 1, leftNum, rightNum + 1);
//        }
//        if (leftNum > rightNum) {
//            cur[n] = '(';
//            recallParenthesis(n + 1, leftNum + 1, rightNum);
//
//            cur[n] = ')';
//            recallParenthesis(n + 1, leftNum, rightNum + 1);
//        }
//    }
}