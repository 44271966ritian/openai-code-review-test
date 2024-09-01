package cn.tyy.d11.t2_1;

//合并有序数组

public class MergeSortedArrays {
    public static int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] result = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < m) {
            result[k++] = a[i++];
        }

        while (j < n) {
            result[k++] = b[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        int[] mergedArray = merge(a, b);

        System.out.println("c:");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}

