package com.liuyk.asimple.leetcode;

public class BinarySearch {

    public static int search(int[] array, int dest) {
        int start = 0, end = array.length -1;
        if (dest < array[start] || dest > array[end]) {
            return -1;
        }
        while (start <= end) {
            int middle = (start + end) >>> 1;
            if (dest < array[middle]) {
                end = middle - 1;
            } else if (dest > array[middle]){
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] as = new int[]{1,2,3,4,5,6,7,8,9};

        System.out.println(search(as, 7));
    }

}
