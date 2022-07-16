package com.leecode.algorithm.node;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 堆
 * 演示
 */
public class Heap {
    public static void main(String[] args) {
        PriorityQueue heap = new PriorityQueue<A>(10, ((o1, o2) -> {
            if (o1.a > o2.a) {
                return 1;
            }
            if (o1.a == o2.a) {
                return 0;
            }
            if (o1.a < o2.a) {
                return -1;
            }
            return 0;
        }));
        heap.add(new A(1,3));
        heap.add(new A(4,3));
        heap.add(new A(3,3));
        heap.add(new A(2,3));
        Arrays.stream(heap.toArray()).forEach(a ->System.out.println(((A)a).a)); // 1 2 3 4
        System.out.println("---------------");
        heap = new PriorityQueue<A>(10, ((o1, o2) -> {
            if (o1.a < o2.a) {
                return 1;
            }
            if (o1.a == o2.a) {
                return 0;
            }
            if (o1.a > o2.a) {
                return -1;
            }
            return 0;
        }));

        heap.add(new A(1,3));
        heap.add(new A(4,3));
        heap.add(new A(3,3));
        heap.add(new A(2,3));
        Arrays.stream(heap.toArray()).forEach(a ->System.out.println(((A)a).a)); // 4 3 2 1


        System.out.println("---------------");
        Heap h = new Heap();
        int[] x = h.heapSort(new int[]{1,4,3,2},2);
        Arrays.stream(x).forEach(a -> System.out.println(a)); // 4 3 2 1
    }



    static class A {
        int a;
        int b;
        public A(int x, int y) {
            a = x;
            b = y;
        }
    }

    /**
     * 堆排序
     * 时间复杂度 nlog(k)
     * @param array 用数组代表一颗完全二叉树
     * @param k 只排k次,如果需要对数组完整排序的话则k = array.length
     * @return 返回从大到小的数组，最后k个是经过排序的
     */
    public int[] heapSort(int[] array, int k) {
        // 找第一个根节点，就看最后一个叶子节点的根节点是谁
        int lastRoot =  array.length / 2 - 1;
        // 1、初始化堆
        for (int i = lastRoot; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        // 2、对堆进行排序
        for (int i = array.length - 1; i >= (array.length - k); i--) {
            swap(array, i, 0);
            heapify(array, i, 0);
        }
        return array;
    }

    /**
     * （前提：之前对左右节点已经做过此操作）
     * 对以i为根节点的子树堆化
     * 从小到大
     * @param array 依托于数组的二叉树（二叉树构建堆）
     * @param n 以数组array[0:n]区间内进行堆化
     * @param i 对位置为i为根节点
     */
    public void heapify(int[] array, int n, int i) {
        if (i >= n) {
            return;
        }
        // 左节点
        int c1 = 2 * i + 1;
        // 右节点
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && array[max] > array[c1]) {
            max = c1;
        }
        if (c2 < n && array[max] > array[c2]) {
            max = c2;
        }
        if (i != max) {
            swap(array, i, max);
            // 交换的子节点需要对其重新堆化
            heapify(array, n, max);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
