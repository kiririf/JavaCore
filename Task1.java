package kaidalov.task1;

public class Task1 {
    static int value = 1;
    static int counter = 0;

    public static void main(String[] args) {
        int [][] massiveNeedSort = new int[10][10];
        doMatrixFull(massiveNeedSort);
        System.out.println("Max number is:" + findMinOrMaxForSortedMatrix(massiveNeedSort, "max"));
        System.out.println("Min number is:" + findMinOrMaxForSortedMatrix(massiveNeedSort, "min"));
        System.out.println("Average value is:" + (counter/100));
    }

    private static void doMatrixFull(int[][] matrix) {
        for (int line = 0; line < 10; line++) {
            for (int column = 0; column < 10; column++) {
                matrix[line][column] =
                        myRandomGenerator(column*line+1053/(column+1));
                counter += matrix[line][column];
            }
            selectionSort(matrix[line]);
        }
    }

    private static int myRandomGenerator(int someNum) {
        int secondNum = 19255;
        int thirdNum = 19251;
        value = (someNum * value + secondNum) % thirdNum;
        return value;
    }

    private static void selectionSort(int[] array) {
        for (int left = 1; left < array.length; left++) {
            int element = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (element < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = element;
        }
    }

    private static int findMinOrMaxForSortedMatrix(int[][] matrix, String minOrMax) {
        int matrixLength = matrix[0].length - 1;
        switch (minOrMax) {
            case "min":
                int minNumber = matrix[0][0];
                for (int line = 1; line < matrixLength; line++) {
                    if (minNumber > matrix[line][0]) {
                        minNumber = matrix[line][0];
                    }
                }
                return minNumber;
            case "max":
                int maxNumber = matrix[0][matrixLength];
                for (int line = 1; line < matrixLength; line++) {
                    if (maxNumber < matrix[line][matrixLength]) {
                        maxNumber = matrix[line][matrixLength];
                    }
                }
                return maxNumber;
            default:
                System.out.println("Print min or max, and check the matrix");
                return 0;
        }
    }
}
