package com.leecode.algorithm.middle.sortArray;


import java.util.Arrays;
import java.util.Random;

/**
 * 排序方式
 */
public class Solution {
    /**
     *
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 随机一个[l,r]中的值
     * @param nums
     * @param l
     * @param r
     */
    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主轴
        swap(nums, r, i); // 交换到lr区间队尾
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1; // 大小分界线
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int[] sortArray(int[] nums) {
        //练习排序
        //快排
        //quicksort(nums, 0, nums.length - 1);
        //归并排序
//        mergesort(nums, 0, nums.length - 1);
        /**
         堆排序
         */
        heapSort(nums);
        //以下排序过不了
        /*
        冒泡排序(O(n²))
        bubblesort(nums);
        */
        /*
        选择排序
        selsort(nums);
        */
        /*
        直接插入
        insertSort(nums);
        */
        /*
        折半插入，但是可以提交
        HinsertSort(nums);
        */
        //shellsort(nums);
        return nums;
    }

    //快排
    public void quicksort(int[] nums, int L, int R){
        if(L >= R) return;
        int left = L, right = R;
        int pivot = nums[left];
        while(left < right){
            while(left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[right] = pivot;
        quicksort(nums, L, right - 1);
        quicksort(nums, right + 1, R);
    }

    //归并排序
    public void mergesort(int[] nums, int L, int R){
        if(L >= R) return;
        int mid = L + R >> 1;
        mergesort(nums, L, mid);
        mergesort(nums, mid + 1, R);
        int left = L, right = mid + 1;
        int[] tmp = new int[nums.length]; int idx = 0;
        while(left <= mid && right <= R){
            if(nums[left] < nums[right]) tmp[idx++] = nums[left++];
            else tmp[idx++] = nums[right++];
        }
        while(left <= mid) tmp[idx++] = nums[left++];
        while(right <= R) tmp[idx++] = nums[right++];
        for(int i = L, j = 0; i <= R; i++, j++) nums[i] = tmp[j];
    }




    //冒泡排序=======每次比较两个数，将小的放在前面，打的放到后面
    public void bubblesort(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; i + j + 1 < len; j++){
                if(nums[j] >= nums[j + 1]){
                    int tmp = nums[j]; nums[j] = nums[j + 1]; nums[j + 1] = tmp;
                }
            }
        }
    }

    //选择排序=======每次从n-i个数中找到最小的数作为第i个
    public void selsort(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int cur = i;
            for(int j = i; j < len; j++) {
                if(nums[j] < nums[cur]) {
                    cur = j;
                }
            }
            int tmp = nums[i]; nums[i] = nums[cur]; nums[i] = tmp;
        }
    }

    //插入排序====== 每次看当前数是否小于前面一个数，小于的话交换即可
    public void insertSort(int[] nums){
        int len = nums.length;
        for(int i = 1; i < len; i++){
            for(int j = i; j >= 0; j--){
                if(j > 0 && nums[j] < nums[j - 1]) {
                    int tmp = nums[j]; nums[j] = nums[j - 1]; nums[j - 1] = tmp;
                }else break;
            }
        }
    }

    //折半插入======找到之后用二分查找
    public void HinsertSort(int[] nums){
        int len = nums.length;
        for(int i = 1; i < len; i++){
            int cur = nums[i];
            int l = 0, r = i - 1;
            //找到第一个>=cur的数
            while(l < r){
                int mid = l + r >> 1;
                if(nums[mid] >= cur) r = mid;
                else l = mid + 1;
            }
            //此时l就是要插入的位置?不能直接判断，需要再加一层判断可以
            if(nums[l] < cur) continue;//找不到第一>=cur的数， 也就是说cur是最大的不需要移动。
            for(int j = i; j >= l + 1; j--) nums[j] = nums[j - 1];
            nums[l] = cur;
        }
    }

    //希尔排序======先分组再插入排序
    public void shellsort(int[] nums){
        int len = nums.length;
        for(int gap = len / 2; gap >= 1; gap = gap / 2){
            for(int i = 0; i <= gap - 1; i++){
                for(int j = i + gap; j < len; j++){
                    int pre = j - gap, tmp = nums[j];
                    while(pre >= i && nums[pre] > tmp){
                        nums[pre + gap] = nums[pre];
                        pre -= gap;
                    }
                    nums[pre + gap] = tmp;
                }
            }
        }
    }
    //堆排序----完全二叉树
//    public void heapsortXX(int[] nums){
//        int size = nums.length;
//        int[] h = new int[size + 1];
//        for(int i = 0; i < size; i++) h[i + 1] = nums[i];
//        for(int i = size / 2; i > 0; i--) down(h, i, size);
//        int len = size;
//        for(int i = 0; i < len; i++) {
//            nums[i] = h[1];
//            h[1] = h[size];
//            size--;
//            down(h, 1, size);
//        }
//    }
//
//    public void down(int[] h, int x, int size){
//        int idx = x, l = 2 * x, r = 2 * x + 1;
//        if(l <= size && h[idx] > h[l]) idx = l;
//        if(r <= size && h[idx] > h[r]) idx = r;
//        if(idx != x){
//            int tmp = h[x]; h[x] = h[idx]; h[idx] = tmp;
//            down(h, idx, size);
//        }
//    }

    /**
     * 堆排序
     * @param array 用数组代表一颗完全二叉树
     * @return
     */
    public int[] heapSort(int[] array) {
        // 找第一个根节点，就看最后一个叶子节点的根节点是谁
        int lastRoot =  array.length / 2 - 1;
        // 1、初始化堆
        for (int i = lastRoot; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        // 2、对堆进行排序
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, 0);
            heapify(array, i, 0);
        }

        return array;
    }

    /**
     * （前提：之前对左右节点已经做过此操作）
     * 对以i为根节点的子树堆化
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
        if (c1 < n && array[max] < array[c1]) {
            max = c1;
        }
        if (c2 < n && array[max] < array[c2]) {
            max = c2;
        }
        if (i != max) {
            swap(array, i, max);
            // 交换的子节点需要对其重新堆化
            heapify(array, n, max);
        }
    }

}