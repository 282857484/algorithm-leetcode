package com.leecode.algorithm.interview.xinghuan;

import java.util.*;

public class Main {
    public static void main1(String[] args) {
//        String[] ss = new String[]{
//                "0 1" ,
//                "0 3" ,
//                "1 2" ,
//                "4 5"};
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
//        String n = "8 4";
        String[] x = n.split(" ");
        int N = Integer.valueOf(x[0]);
        int M = Integer.valueOf(x[1]);
        boolean[] m = new boolean[N];
        List<Set<String>> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] a = sc.nextLine().split(" ");
//            String[] a =ss[i].split(" ");
            int a1 = Integer.valueOf(a[0]);
            int a2 = Integer.valueOf(a[1]);
            m[a1] = true;
            m[a2] = true;
            boolean isContain = false;
            for (Set set :list) {
                if (set.contains(a1)) {
                    set.add(a2);
                    isContain = true;
                }
                if (set.contains(a2)) {
                    set.add(a1);
                    isContain = true;
                }
            }
            if (!isContain) {
                Set s = new HashSet();
                s.add(a1);
                s.add(a2);
                list.add(s);
            }
        }
        int cnt = list.size();
        for (boolean b:m) {
            if (!b) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int[] f = new int[]{4,7,4,9,4,10,0,1,1,10};
        int n = 10;
        int sum = 0;
        for (int i = 0; i < f.length; i++) {
            sum += f[i];
        }
        int g = sum / f.length;
        int s = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            int should = (i+1) * g;
            s += f[i];
            if (s != should) {
                c++;
            }
        }
        System.out.println(c);
    }

}
