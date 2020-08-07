import java.util.Arrays;

public class AlgorithmDemo {

    public static void main(String[] args) {
        selectionSort();
    }

    private static void selectionSort() {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;

            // 选出最小数的下标
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 最小数
            int min = arr[minIndex];
            // 最小数和第i个数交换位置
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
        System.out.print(Arrays.toString(arr));
    }


}
