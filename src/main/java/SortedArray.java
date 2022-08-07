import java.util.Scanner;

public class SortedArray {
    // write code here
    public static int[] getIntegers(int number) {
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[number];
        for (int i = 0; i < number; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }

    public static int[] sortIntegers(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println("Element " + i + " contents " + arr[i]);
    }
}