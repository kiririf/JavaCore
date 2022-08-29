package kaidalov.task2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] massiveNeedSort = {5, 6, 3, 2, 5, 1, 4, 9};
        selectionSort(massiveNeedSort);
        System.out.println(Arrays.toString(massiveNeedSort));
    }

    private static void selectionSort(int[] array) {
        for (int left = 1; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }
    //Решил использовать сортировку выбором т.к. она "устойчивая" - нормально работает с дублями.
}