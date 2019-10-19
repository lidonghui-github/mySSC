package cn.hd.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个数组arr，和一个数num，
 * 请把小于等于num的数放在数 组的左边，大于num的数放在数组的右边。
 */
public class 荷兰国旗问题 {
    public static void main(String[] args) {
        int[] arr = CommonInts.getInts();
        printSortArr(arr);
    }

    public static void printSortArr(int arr[]) {
        System.out.println("输入关键字数key = :");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        List<Integer> smallList = new ArrayList<>();
        List<Integer> bigList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=key){
                smallList.add(arr[i]);
            }else{
                bigList.add(arr[i]);
            }
        }
        int[] sortArr = new int [arr.length];
        for(int  i = 0;i<smallList.size();i++){
            sortArr[i]=smallList.get(i);
        }
        for(int j=0;j<bigList.size();j++){
            sortArr[j+smallList.size()]=bigList.get(j);
        }
        System.out.println("排行序后的数组是:");
       for(int i =0 ;i<sortArr.length;i++){
           System.out.print(sortArr[i]+" ");
       }
    }
}
