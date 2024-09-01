package cn.tyy;

/*
* TODO
*  验证 HashMap计算阈值大小的函数
* */
public class Demo2 {
    public static void main(String[] args) {
        int arr[] = new int[32];
        arr[0] = 1;


        int[] arr1 = transfer(arr, 1);

        int[] arr2 = transfer(arr1, 2);

        int[] arr3 = transfer(arr2, 4);

        int[] arr4 = transfer(arr3, 8);

        int[] arr5 = transfer(arr4, 16);

    }

    /*
    * TODO
    *  原理
    *   将原来的二进制右移2的n次幂
    *   然后或上原值
    *   得到的就是高 2n 位是1的二进制数
    *  1---2
    *  2---4
    *  4---8
    *  8---16
    *  16---32
    *  最终32位都是1，我是指如果有这么高的位数的化，实际得到是为1的最高位往后都是1的二进制数，
    *  这个数一定是大于原值的，加1就可以得到大于原值的最小2次幂
    *  实际算法先将初始容量减一是为了防止初始容量就是2的n次幂的情况，不减一会得到2的n+1次幂,减一得到的是2的n次幂
    * */
    public static int[] transfer(int temp[],int num){
        int [] arr = new int[temp.length];
        for (int i = num; i < temp.length; i++) {
            arr[i] = temp[i-num];
        }
        for (int i = 0; i < num; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i] |= temp[i];
        }

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return arr;
    }
}
