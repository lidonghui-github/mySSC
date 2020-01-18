package cn.hd.algorithm;



/**小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组 的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class 小和问题 {
    public static void main(String[] args) {
        int[] arr = CommonInts.getInts();
        System.out.println("则数组的小和是:"+GetSmallSum(arr));


    }

    public static int GetSmallSum(int[] arr) {
        int[] sum = new int[arr.length];
        //1.初始化sum每个元素为0
        for (int i = 0; i < sum.length; i++) {
            sum[i] = 0;
        }
        //2.遍历arr的每个元素，记作一个flag，然后让其左侧的元素与其对比，比flag小的就加到sum【i】里
        for (int i = 0; i < arr.length; i++) {
            int flag = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < flag) {
                    sum[i] += arr[j];
                }
            }
        }
        int smallSum = 0;
        for (int i = 0; i < sum.length; i++) {
            smallSum += sum[i];
        }
        return smallSum;
    }
}
