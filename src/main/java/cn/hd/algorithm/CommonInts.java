package cn.hd.algorithm;

import java.util.Scanner;

public class CommonInts {
    public static int[] getInts() {
        System.out.println("输入一个数组元素个数n=:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("下面开始输入数组的每个元素*********************");
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("输入数组的第"+(i+1)+"个元素");
            arr[i] = scanner.nextInt();
        }
        System.out.println("输入的数组是:");
        for(int i=0;i<n;i++){

            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return arr;

    }
}
