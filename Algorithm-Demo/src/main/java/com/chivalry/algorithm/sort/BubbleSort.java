package com.chivalry.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：O（n²）
 * 冒泡排序算法的原理如下： [1]
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。 [1]
 * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。 [1]
 * 针对所有的元素重复以上的步骤，除了最后一个。 [1]
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 *
 * @author Mr.zxb
 * @date 2020-08-20 10:44
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 8, 4, 5, 9, 7, 6};
        sort(array);

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array.length - 1; i1++) {
                if (array[i1] < array[i1 + 1]) {
                    int temp = array[i1 + 1];
                    array[i1 + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

//    public static void sort(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }
//    }


}
