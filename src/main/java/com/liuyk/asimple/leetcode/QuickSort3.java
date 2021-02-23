package com.liuyk.asimple.leetcode;

import org.springframework.util.StopWatch;
import java.util.Random;

/**
 * 3路快排
 *
 * @author liuyk
 */
public class QuickSort3 {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        //解决重复有序数组的排序性能问题
        int index = new Random().nextInt(r - l) + l;
        swap(array, l, index);
        int v = array[l];

        // 小于V 等于V 和大于V
        int lt = l, gt = r + 1;
        int i = l + 1;

        while (i < gt) {
            if (array[i] < v) {
                swap(array, i++, ++lt);
            } else if (array[i] > v) {
                swap(array, i, --gt);
            } else {
                i++;
            }
        }

        swap(array, l , lt);

        sort(array, l, lt - 1 );
        sort(array, gt, r);
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int size = 1000000;
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
            array[i] = i;
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        new QuickSort3().sort(array);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }


}
