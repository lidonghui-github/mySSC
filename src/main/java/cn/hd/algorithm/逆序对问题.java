package cn.hd.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 逆序对问题
 * 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序 对。
 */
public class 逆序对问题 {
    public static void main(String[] args) {
        int[] arr = CommonInts.getInts();
        System.out.println("则数组逆序对是:");
        PrintInversionPair(arr);
    }




    public static void PrintInversionPair(int arr[]) {
        //1.从下标1开始遍历数组元素，然后用其左侧的元素与其比较，
        // 如果左侧元素大，则把这俩数放在String类型的list中
        List<String> IPList = new ArrayList<String>();
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                IPList.add(arr[i-1]+"***"+arr[i]);
            }
        }
        System.out.println(IPList);

    }
}
