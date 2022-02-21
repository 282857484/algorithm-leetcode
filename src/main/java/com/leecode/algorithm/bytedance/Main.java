package leecode.algorithm.bytedance;

//public class Main {
//    public static void main(String[] args) {
//        // Scanner input=new Scanner(System.in);
//        // String str=input.next();
//        System.out.println("hello world");
//        Main.passLength(100,10);
//        System.out.println(""+countn +". "+high);
//    }
//
//    public static double countn = 0;
//    public static double high = 0;
//    public static void passLength(double init, int n) {
//
//        for(int i = n; i > 0; i--) {
//            countn += init;
//            init = init / 2;
//            countn += init;
//        }
//        high = init;
//    }
//}
public class Main {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");
        String xx = Main.palindrome("babadfsfwesdtytd");
        System.out.println(xx);
    }

    public static String palindrome(String s) {
        int maxlength = 0;
        int jj = 0;
        byte[] ss = s.getBytes();
        // 假设i为回文中心
        for (int i = 0; i < ss.length; i ++) {
            int imax = 1;
            for(int j = i; (j > 0) && ((2*i-j) < ss.length); j--) {
                if (ss[j] == ss[2*i-j]){
                    imax ++;
                }
            }
            if (imax > maxlength) {
                maxlength = imax;
                jj = i;
            }
        }
        return s.substring(jj - maxlength, jj + maxlength-1);
    }

}